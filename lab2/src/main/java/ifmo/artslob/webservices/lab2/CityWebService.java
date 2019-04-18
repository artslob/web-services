package ifmo.artslob.webservices.lab2;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "CityService")
public class CityWebService {
    @WebMethod(operationName = "getCities")
    public List<City> getCities() {
        return new PostgreSQLDAO().getCities();
    }
}
