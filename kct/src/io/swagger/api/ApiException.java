package io.swagger.api;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-01-16T08:00:40.804Z[GMT]")
public class ApiException extends Exception {
    private static final long serialVersionUID = -2174637728997742359L;
    private int code;

    public ApiException(int code, String msg) {
        super(msg);
        this.code = code;
    }
}
