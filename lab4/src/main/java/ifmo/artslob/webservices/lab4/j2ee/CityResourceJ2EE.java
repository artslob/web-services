package ifmo.artslob.webservices.lab4.j2ee;

import ifmo.artslob.webservices.lab4.City;
import ifmo.artslob.webservices.lab4.PostgreSQLDAO;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RequestScoped
@Path("/cities")
@Produces({MediaType.APPLICATION_JSON})
public class CityResourceJ2EE {
    @Resource(lookup = "jdbc/ifmo-ws")
    private DataSource dataSource;

    @GET
    public List<City> getCities(
            @QueryParam("name") String name,
            @QueryParam("country") String country,
            @QueryParam("founded") String founded,
            @QueryParam("population") String population,
            @QueryParam("area") String area
    ) {
        return new PostgreSQLDAO(getConnection()).getCities(name, country, founded, population, area);
    }

    private Connection getConnection() {
        Connection result = null;
        try {
            result = dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CityResourceJ2EE.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}

