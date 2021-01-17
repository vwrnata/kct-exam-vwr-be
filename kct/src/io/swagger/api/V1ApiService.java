package io.swagger.api;

import io.swagger.model.FavoriteRestEntity;

import io.swagger.api.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-01-17T07:02:49.531Z[GMT]")
public abstract class V1ApiService {
    public abstract Response addFavorite(FavoriteRestEntity body, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response deleteFavorite(String favoriteId, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response getFavoriteById(String favoriteId, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response getFavorites(SecurityContext securityContext) throws NotFoundException;

    public abstract Response v1FavoritesFavoriteIdOptions(String favoriteId, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response v1FavoritesOptions(SecurityContext securityContext) throws NotFoundException;
}
