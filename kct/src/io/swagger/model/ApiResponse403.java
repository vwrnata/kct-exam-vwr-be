/*
 * Cat Breed Api
 * API pro ukladani oblíbených plemen koček
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * ApiResponse403
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-01-16T08:00:40.804Z[GMT]")
public class ApiResponse403 {
    @JsonProperty("status")
    private String status = null;

    @JsonProperty("message")
    private String message = null;

    public ApiResponse403 status(String status) {
        this.status = status;
        return this;
    }

    /**
     * Textová reprezentace HTML status kódu
     * 
     * @return status
     **/
    @JsonProperty("status")
    @Schema(example = "FORBIDDEN", description = "Textová reprezentace HTML status kódu")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ApiResponse403 message(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get message
     * 
     * @return message
     **/
    @JsonProperty("message")
    @Schema(example = "entity is not deletable", description = "")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ApiResponse403 apiResponse403 = (ApiResponse403) o;
        return Objects.equals(this.status, apiResponse403.status)
                && Objects.equals(this.message, apiResponse403.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, message);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApiResponse403 {\n");

        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
