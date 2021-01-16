package io.swagger.api.factories;

import io.swagger.api.V1ApiService;
import io.swagger.api.impl.V1ApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-01-16T08:00:40.804Z[GMT]")
public class V1ApiServiceFactory {
    private final static V1ApiService service = new V1ApiServiceImpl();

    public static V1ApiService getV1Api() {
        return service;
    }
}
