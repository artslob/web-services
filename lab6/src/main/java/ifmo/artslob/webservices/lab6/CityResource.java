package ifmo.artslob.webservices.lab6;

import ifmo.artslob.webservices.lab6.errors.EmptyMethodParameterError;
import ifmo.artslob.webservices.lab6.errors.InvalidIntegerError;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/cities")
@Produces({MediaType.APPLICATION_JSON})
public class CityResource {
    @POST
    public String createCity(
            @FormParam("name") String name,
            @FormParam("country") String country,
            @FormParam("founded") String founded,
            @FormParam("population") String population,
            @FormParam("area") String area
    ) throws EmptyMethodParameterError, InvalidIntegerError {
        this.checkPersonParameters(name, country, founded, population, area);
        int result = newDAO().createCity(name, country, founded, population, area);
        return Integer.toString(result);
    }

    @GET
    public List<City> getCities(
            @QueryParam("name") String name,
            @QueryParam("country") String country,
            @QueryParam("founded") String founded,
            @QueryParam("population") String population,
            @QueryParam("area") String area
    ) {
        // read method allows empty parameters
        // *NO* need to validate parameters here
        return newDAO().getCities(name, country, founded, population, area);
    }

    @PUT
    @Path("/{id}")
    public String updateCity(
            @PathParam("id") String id,
            @FormParam("name") String name,
            @FormParam("country") String country,
            @FormParam("founded") String founded,
            @FormParam("population") String population,
            @FormParam("area") String area
    ) throws EmptyMethodParameterError, InvalidIntegerError {
        this.checkPersonId(id);
        this.checkPersonParameters(name, country, founded, population, area);
        boolean result = newDAO().updateCity(id, name, country, founded, population, area);
        return Boolean.toString(result);
    }

    @DELETE
    @Path("/{id}")
    public String deleteCity(@PathParam("id") String id) throws InvalidIntegerError {
        this.checkPersonId(id);
        boolean result = new PostgreSQLDAO(ConnectionUtil.getConnection()).deleteCity(id);
        return Boolean.toString(result);
    }

    private PostgreSQLDAO newDAO() {
        return new PostgreSQLDAO(ConnectionUtil.getConnection());
    }

    private void checkPersonId(String id) throws InvalidIntegerError {
        if (isInvalidInteger(id)) {
            throw new InvalidIntegerError("id parameter isn`t valid integer");
        }
    }

    private void checkPersonParameters(
            String name,
            String country,
            String founded,
            String population,
            String area
    ) throws EmptyMethodParameterError, InvalidIntegerError {
        if (isStringEmpty(name)) {
            throw new EmptyMethodParameterError("name parameter is empty");
        }
        if (isStringEmpty(country)) {
            throw new EmptyMethodParameterError("country parameter is empty");
        }
        if (isInvalidInteger(founded)) {
            throw new InvalidIntegerError("founded parameter isn`t valid integer");
        }
        if (isInvalidInteger(population)) {
            throw new InvalidIntegerError("population parameter isn`t valid integer");
        }
        if (isInvalidInteger(area)) {
            throw new InvalidIntegerError("area parameter isn`t valid integer");
        }
    }

    private boolean isStringEmpty(String string) {
        return string == null || string.trim().isEmpty();
    }

    private boolean isInvalidInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException e) {
            return true;
        }
        return false;
    }
}
