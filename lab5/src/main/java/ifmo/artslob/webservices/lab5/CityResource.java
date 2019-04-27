package ifmo.artslob.webservices.lab5;

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
    ) {
        int result = new PostgreSQLDAO(ConnectionUtil.getConnection()).createCity(name, country, founded, population, area);
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
        return new PostgreSQLDAO(ConnectionUtil.getConnection()).getCities(name, country, founded, population, area);
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
    ) {
        boolean result = new PostgreSQLDAO(ConnectionUtil.getConnection()).updateCity(id, name, country, founded, population, area);
        return Boolean.toString(result);
    }

    @DELETE
    @Path("/{id}")
    public String deleteCity(@PathParam("id") String id) {
        boolean result = new PostgreSQLDAO(ConnectionUtil.getConnection()).deleteCity(id);
        return Boolean.toString(result);
    }
}
