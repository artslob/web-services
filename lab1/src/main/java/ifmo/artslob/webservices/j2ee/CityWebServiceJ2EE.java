package ifmo.artslob.webservices.j2ee;

import ifmo.artslob.webservices.City;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebService(serviceName = "CityServiceJ2EE")
public class CityWebServiceJ2EE {
    @Resource(lookup = "jdbc/ifmo-ws")
    private DataSource dataSource;

    @WebMethod(operationName = "getCities")
    public List<City> getCities(
            @WebParam(name = "name") String name,
            @WebParam(name = "country") String country,
            @WebParam(name = "founded") String founded,
            @WebParam(name = "population") String population,
            @WebParam(name = "area") String area
    ) {
        return new PostgreSQLDAO(getConnection()).getCities(name, country, founded, population, area);
    }

    private Connection getConnection() {
        Connection result = null;
        try {
            result = dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CityWebServiceJ2EE.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}

