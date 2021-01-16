package cz.kct.exam.rest.impl;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;

import io.swagger.model.FavoriteEntity;

/**
 * Implementace REST API /v1/favorites/
 * 
 * @author wojta
 *
 */
public class FavoritesIml {

    public Response getFavorites(SecurityContext securityContext) {
        System.out.println("getFavorites");
        FavoriteEntity favorites = new FavoriteEntity();
        Status responseStatus = Status.OK;
        
        return Response.status(responseStatus).encoding("UTF-8").header("Content-type", "application/json")
                .entity(favorites).build();
    }
    
    public Response getFavoriteById(String favoriteId, SecurityContext securityContext) {
        System.out.println("getFavoriteById");
        FavoriteEntity favorites = new FavoriteEntity();
        Status responseStatus = Status.OK;
        
        return Response.status(responseStatus).encoding("UTF-8").header("Content-type", "application/json")
                .entity(favorites).build();
    }
    
    public Response addFavorite(FavoriteEntity favorite, SecurityContext securityContext) {
        System.out.println("addFavorite");
        FavoriteEntity favorites = new FavoriteEntity();
        Status responseStatus = Status.OK;
        
        return Response.status(responseStatus).encoding("UTF-8").header("Content-type", "application/json")
                .entity(favorites).build();
    }
    
    public Response removeFavorite(String favoriteId, SecurityContext securityContext) {
        System.out.println("removeFavorite");
        FavoriteEntity favorites = new FavoriteEntity();
        Status responseStatus = Status.OK;
        
        return Response.status(responseStatus).encoding("UTF-8").header("Content-type", "application/json")
                .entity(favorites).build();
    }
}
