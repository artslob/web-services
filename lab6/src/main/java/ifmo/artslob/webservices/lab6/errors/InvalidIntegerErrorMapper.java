package ifmo.artslob.webservices.lab6.errors;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InvalidIntegerErrorMapper implements ExceptionMapper<InvalidIntegerError> {
    @Override
    public Response toResponse(InvalidIntegerError e) {
        return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
    }
}
