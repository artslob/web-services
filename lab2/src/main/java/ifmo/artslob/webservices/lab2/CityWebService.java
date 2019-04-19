package ifmo.artslob.webservices.lab2;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "CityService")
public class CityWebService {
    @WebMethod(operationName = "createCity")
    public int createCity(
            @WebParam(name = "name") String name,
            @WebParam(name = "country") String country,
            @WebParam(name = "founded") String founded,
            @WebParam(name = "population") String population,
            @WebParam(name = "area") String area
    ) {
        return new PostgreSQLDAO().createCity(name, country, founded, population, area);
    }

    @WebMethod(operationName = "getCities")
    public List<City> getCities(
            @WebParam(name = "name") String name,
            @WebParam(name = "country") String country,
            @WebParam(name = "founded") String founded,
            @WebParam(name = "population") String population,
            @WebParam(name = "area") String area
    ) {
        return new PostgreSQLDAO().getCities(name, country, founded, population, area);
    }

    @WebMethod(operationName = "updateCity")
    public boolean updateCity(
            @WebParam(name = "id") String id,
            @WebParam(name = "name") String name,
            @WebParam(name = "country") String country,
            @WebParam(name = "founded") String founded,
            @WebParam(name = "population") String population,
            @WebParam(name = "area") String area
    ) {
        return new PostgreSQLDAO().updateCity(id, name, country, founded, population, area);
    }

    @WebMethod(operationName = "deleteCity")
    public boolean deleteCity(@WebParam(name = "id") String id) {
        return new PostgreSQLDAO().deleteCity(id);
    }
}
