package ifmo.artslob.web.services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "PersonService")
public class PersonWebService {
    @WebMethod(operationName = "getPersons")
    public List<Person> getPersons() {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.getPersons();
    }
}
