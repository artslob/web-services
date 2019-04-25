package ifmo.artslob.webservices.lab4;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/cities")
@Produces({MediaType.APPLICATION_JSON})
public class CityResource {
    @GET
    public List<City> getCities(
            @QueryParam("name") String name,
            @QueryParam("country") String country,
            @QueryParam("founded") String founded,
            @QueryParam("population") String population,
            @QueryParam("area") String area
    ) {
        return new PostgreSQLDAO().getCities(name, country, founded, population, area);
    }
}
