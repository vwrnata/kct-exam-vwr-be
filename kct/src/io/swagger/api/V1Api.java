package io.swagger.api;

import io.swagger.api.V1ApiService;
import io.swagger.api.factories.V1ApiServiceFactory;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import io.swagger.model.ApiResponse403;
import io.swagger.model.FavoriteEntity;
import io.swagger.model.ModelApiResponse;

import io.swagger.api.NotFoundException;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/v1")

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-01-16T08:00:40.804Z[GMT]")
public class V1Api {
    private final V1ApiService delegate;

    public V1Api(@Context ServletConfig servletContext) {
        V1ApiService delegate = null;

        if (servletContext != null) {
            String implClass = servletContext.getInitParameter("V1Api.implementation");
            if (implClass != null && !"".equals(implClass.trim())) {
                try {
                    delegate = (V1ApiService) Class.forName(implClass).newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        if (delegate == null) {
            delegate = V1ApiServiceFactory.getV1Api();
        }

        this.delegate = delegate;
    }

    @POST
    @Path("/favorites/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Přidá plemeno do oblíbených", description = "", tags = { "Oblíbená plemena" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = FavoriteEntity.class))),

            @ApiResponse(responseCode = "400", description = "Bad request. Není zadán povinný query parametr.", content = @Content(schema = @Schema(implementation = ModelApiResponse.class))) })
    public Response addFavorite(
            @Parameter(in = ParameterIn.DEFAULT, description = "Přidávané plemeno", required = true) FavoriteEntity body

            , @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.addFavorite(body, securityContext);
    }

    @DELETE
    @Path("/favorites/{favoriteId}")

    @Produces({ "application/json" })
    @Operation(summary = "Smaže plemeno ze seznamu oblíbených plemen.", description = "", tags = { "Oblíbená plemena" })
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation"),

            @ApiResponse(responseCode = "400", description = "Bad request. Není zadán povinný query parametr."),

            @ApiResponse(responseCode = "403", description = "Forbidden. Záznam není smazatelný.", content = @Content(schema = @Schema(implementation = ApiResponse403.class))) })
    public Response deleteFavorite(
            @Parameter(in = ParameterIn.PATH, description = "ID plemena", required = true) @PathParam("favoriteId") String favoriteId,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.deleteFavorite(favoriteId, securityContext);
    }

    @GET
    @Path("/favorites/{favoriteId}")

    @Produces({ "application/json" })
    @Operation(summary = "Vrátí oblíbené plemeno podle ID.", description = "", tags = { "Oblíbená plemena" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = FavoriteEntity.class)))),

            @ApiResponse(responseCode = "400", description = "Bad request. Není zadán povinný query parametr.", content = @Content(schema = @Schema(implementation = ModelApiResponse.class))) })
    public Response getFavoriteById(
            @Parameter(in = ParameterIn.PATH, description = "ID plemena", required = true) @PathParam("favoriteId") String favoriteId,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.getFavoriteById(favoriteId, securityContext);
    }

    @GET
    @Path("/favorites/")

    @Produces({ "application/json" })
    @Operation(summary = "Vrátí seznam všech oblíbených plemen.", description = "", tags = { "Oblíbená plemena" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = FavoriteEntity.class)))),

            @ApiResponse(responseCode = "400", description = "Bad request. Není zadán povinný query parametr.", content = @Content(schema = @Schema(implementation = ModelApiResponse.class))) })
    public Response getFavorites(@Context SecurityContext securityContext) throws NotFoundException {
        return delegate.getFavorites(securityContext);
    }
}
