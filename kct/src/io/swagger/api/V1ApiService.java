package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.ApiResponse403;
import io.swagger.model.FavoriteEntity;
import io.swagger.model.ModelApiResponse;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-01-16T08:00:40.804Z[GMT]")
public abstract class V1ApiService {
    public abstract Response addFavorite(FavoriteEntity body, SecurityContext securityContext) throws NotFoundException;

    public abstract Response deleteFavorite(String favoriteId, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response getFavoriteById(String favoriteId, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response getFavorites(SecurityContext securityContext) throws NotFoundException;
}
