package ifmo.artslob.webservices.lab3;

import ifmo.artslob.webservices.lab3.errors.CityServiceFault;
import ifmo.artslob.webservices.lab3.errors.EmptyMethodParameterError;
import ifmo.artslob.webservices.lab3.errors.InvalidIntegerError;

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
    ) throws EmptyMethodParameterError, InvalidIntegerError {
        this.checkPersonParameters(name, country, founded, population, area);
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
        // read method allows empty parameters
        // *NO* need to validate parameters here
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
    ) throws EmptyMethodParameterError, InvalidIntegerError {
        this.checkPersonId(id);
        this.checkPersonParameters(name, country, founded, population, area);
        return new PostgreSQLDAO().updateCity(id, name, country, founded, population, area);
    }

    @WebMethod(operationName = "deleteCity")
    public boolean deleteCity(@WebParam(name = "id") String id) throws InvalidIntegerError {
        this.checkPersonId(id);
        return new PostgreSQLDAO().deleteCity(id);
    }

    private void checkPersonId(String id) throws InvalidIntegerError {
        if (isInvalidInteger(id)) {
            throw new InvalidIntegerError("id parameter isn`t valid integer", CityServiceFault.defaultInstance());
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
            throw new EmptyMethodParameterError("name parameter is empty", CityServiceFault.defaultInstance());
        }
        if (isStringEmpty(country)) {
            throw new EmptyMethodParameterError("country parameter is empty", CityServiceFault.defaultInstance());
        }
        if (isInvalidInteger(founded)) {
            throw new InvalidIntegerError("founded parameter isn`t valid integer", CityServiceFault.defaultInstance());
        }
        if (isInvalidInteger(population)) {
            throw new InvalidIntegerError("population parameter isn`t valid integer", CityServiceFault.defaultInstance());
        }
        if (isInvalidInteger(area)) {
            throw new InvalidIntegerError("area parameter isn`t valid integer", CityServiceFault.defaultInstance());
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
