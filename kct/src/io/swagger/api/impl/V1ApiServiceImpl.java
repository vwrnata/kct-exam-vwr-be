package io.swagger.api.impl;

import io.swagger.api.*;

import io.swagger.model.FavoriteRestEntity;

import io.swagger.api.NotFoundException;

import cz.kct.exam.rest.impl.FavoritesIml;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-01-16T08:00:40.804Z[GMT]")
public class V1ApiServiceImpl extends V1ApiService {
    @Override
    public Response addFavorite(FavoriteRestEntity body, SecurityContext securityContext) throws NotFoundException {
        return new FavoritesIml().addFavorite(body, securityContext);
    }

    @Override
    public Response deleteFavorite(String favoriteId, SecurityContext securityContext) throws NotFoundException {
        return new FavoritesIml().removeFavorite(favoriteId, securityContext);
    }

    @Override
    public Response getFavoriteById(String favoriteId, SecurityContext securityContext) throws NotFoundException {
        return new FavoritesIml().getFavoriteById(favoriteId, securityContext);
    }

    @Override
    public Response getFavorites(SecurityContext securityContext) throws NotFoundException {
        return new FavoritesIml().getFavorites(securityContext);
    }
    
    @Override
    public Response v1FavoritesFavoriteIdOptions(String favoriteId, SecurityContext securityContext) throws NotFoundException {
        return new FavoritesIml().sendOption(securityContext);
    }
    
    @Override
    public Response v1FavoritesOptions(SecurityContext securityContext) throws NotFoundException {
        return new FavoritesIml().sendOption(securityContext);
    }
}
