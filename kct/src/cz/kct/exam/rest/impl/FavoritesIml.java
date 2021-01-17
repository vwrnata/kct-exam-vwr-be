package cz.kct.exam.rest.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;

import cz.kct.exam.db.favorites.FavoriteEntity;
import cz.kct.exam.db.favorites.FavoritesFacade;
import io.swagger.model.FavoriteRestEntity;
import io.swagger.model.ApiResponse;

/**
 * Implementace REST API /v1/favorites/
 * 
 * @author wojta
 *
 */
public class FavoritesIml {

    /**
     * Nacte z DB Oblibena plemena, prevede na REST a vrati jako REST Response
     * 
     * @param securityContext
     * 
     * @return Response REST Response
     */
    public Response getFavorites(SecurityContext securityContext) {
        System.out.println("getFavorites");
        List<FavoriteRestEntity> restFavorites = new ArrayList<FavoriteRestEntity>();
        Status responseStatus = Status.OK;
        String errorMessage = "";

        FavoritesFacade facade = new FavoritesFacade();
        List<FavoriteEntity> favorites = null;
        try {
            favorites = facade.getFavorites();
            for (FavoriteEntity favoriteEntity : favorites) {
                restFavorites.add(new FavoriteRestEntity(favoriteEntity));
            }
            if (!restFavorites.isEmpty()) {
                return Response.status(responseStatus).encoding("UTF-8")
//                        .header("Access-Control-Allow-Origin", "http://localhost:8080")
                        .header("Access-Control-Allow-Origin", "*").entity(restFavorites).build();
            } else {
                responseStatus = Status.NO_CONTENT;
            }
        } catch (SQLException e) {
            System.err.println(e.getLocalizedMessage());
            responseStatus = Status.INTERNAL_SERVER_ERROR;
            errorMessage = e.getLocalizedMessage();
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
            responseStatus = Status.INTERNAL_SERVER_ERROR;
            errorMessage = e.getLocalizedMessage();
        }

        return Response.ok(new ApiResponse(responseStatus.name(), errorMessage)).status(responseStatus)
                .header("Access-Control-Allow-Origin", "*").build();
    }

    /**
     * Nacte z DB Oblibene plemeno podle ID, prevede na REST a vrati jako REST
     * Response
     * 
     * @param securityContext
     * 
     * @return Response REST Response
     */
    public Response getFavoriteById(String favoriteId, SecurityContext securityContext) {
        System.out.println("getFavoriteById");
        FavoriteRestEntity restFavorite = null;
        Status responseStatus = Status.OK;
        String errorMessage = "";

        FavoritesFacade facade = new FavoritesFacade();
        FavoriteEntity favorite = null;
        try {
            favorite = facade.getFavorite(favoriteId);
            restFavorite = new FavoriteRestEntity(favorite);
            if (null != restFavorite && !restFavorite.getId().equals("")) {
                return Response.status(responseStatus).encoding("UTF-8").header("Access-Control-Allow-Origin", "*")
                        .entity(restFavorite).build();
            } else {
                responseStatus = Status.NO_CONTENT;
            }
        } catch (SQLException e) {
            System.err.println(e.getLocalizedMessage());
            responseStatus = Status.INTERNAL_SERVER_ERROR;
            errorMessage = e.getLocalizedMessage();
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
            responseStatus = Status.INTERNAL_SERVER_ERROR;
            errorMessage = e.getLocalizedMessage();
        }

        return Response.ok(new ApiResponse(responseStatus.name(), errorMessage)).status(responseStatus)
                .header("Access-Control-Allow-Origin", "*").build();
    }

    /**
     * Prida do DB Oblibene plemeno
     * 
     * @param securityContext
     * 
     * @return Response Status.OK, nebo Status.INTERNAL_SERVER_ERROR
     */
    public Response addFavorite(FavoriteRestEntity restFavorite, SecurityContext securityContext) {
        System.out.println("addFavorite, " + restFavorite);
        FavoriteEntity favorite = new FavoriteEntity(restFavorite);
        Status responseStatus = Status.OK;
        String errorMessage = "";

        FavoritesFacade facade = new FavoritesFacade();
        try {
            facade.addFavorite(favorite);
            return Response.status(responseStatus).encoding("UTF-8").header("Content-type", "application/json")
                    .header("Access-Control-Allow-Origin", "*").entity(new FavoriteRestEntity(favorite)).build();
        } catch (SQLException e) {
            System.err.println(e.getLocalizedMessage());
            responseStatus = Status.INTERNAL_SERVER_ERROR;
            errorMessage = e.getLocalizedMessage();
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
            responseStatus = Status.INTERNAL_SERVER_ERROR;
            errorMessage = e.getLocalizedMessage();
        }
        return Response.ok(new ApiResponse(responseStatus.name(), errorMessage)).status(responseStatus)
                .header("Access-Control-Allow-Origin", "*").build();
    }

    /**
     * Smaze z DB Oblibene plemeno
     * 
     * @param securityContext
     * 
     * @return Response Status.OK, nebo Status.INTERNAL_SERVER_ERROR
     */
    public Response removeFavorite(String favoriteId, SecurityContext securityContext) {
        System.out.println("removeFavorite, " + favoriteId);
        Status responseStatus = Status.OK;
        String errorMessage = "";

        FavoritesFacade facade = new FavoritesFacade();
        try {
            facade.deleteFavorite(favoriteId);
            return Response.ok(new ApiResponse(responseStatus.name(), errorMessage)).status(responseStatus)
                    .header("Content-type", "application/json").header("Access-Control-Allow-Origin", "*").build();
        } catch (SQLException e) {
            System.err.println(e.getLocalizedMessage());
            responseStatus = Status.INTERNAL_SERVER_ERROR;
            errorMessage = e.getLocalizedMessage();
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
            responseStatus = Status.INTERNAL_SERVER_ERROR;
            errorMessage = e.getLocalizedMessage();
        }
        return Response.ok(new ApiResponse(responseStatus.name(), errorMessage)).status(responseStatus)
                .header("Access-Control-Allow-Origin", "*").build();
    }

    /**
     * CORS hack na localhost
     * 
     * @param securityContext
     * 
     * @return Response Access-Control-Allow*
     */
    public Response sendOption(SecurityContext securityContext) {
        System.out.println("sendOption");

        return Response.status(Status.OK).encoding("UTF-8")
//                .header("Access-Control-Allow-Origin", "http://localhost:8080")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, OPTIONS")
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "Content-type")
                .build();
    }
}
