
package ifmo.artslob.web.services.generated;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PersonWebService", targetNamespace = "http://services.web.artslob.ifmo/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PersonWebService {


    /**
     * 
     * @return
     *     returns java.util.List<ifmo.artslob.web.services.generated.Person>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPersons", targetNamespace = "http://services.web.artslob.ifmo/", className = "ifmo.artslob.web.services.generated.GetPersons")
    @ResponseWrapper(localName = "getPersonsResponse", targetNamespace = "http://services.web.artslob.ifmo/", className = "ifmo.artslob.web.services.generated.GetPersonsResponse")
    @Action(input = "http://services.web.artslob.ifmo/PersonWebService/getPersonsRequest", output = "http://services.web.artslob.ifmo/PersonWebService/getPersonsResponse")
    public List<Person> getPersons();

}
