
package ifmo.artslob.webservices.clientj2ee.generated;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
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
@WebService(name = "CityWebServiceJ2EE", targetNamespace = "http://j2ee.webservices.artslob.ifmo/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CityWebServiceJ2EE {


    /**
     * 
     * @param area
     * @param country
     * @param name
     * @param founded
     * @param population
     * @return
     *     returns java.util.List<ifmo.artslob.webservices.clientj2ee.generated.City>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCities", targetNamespace = "http://j2ee.webservices.artslob.ifmo/", className = "ifmo.artslob.webservices.clientj2ee.generated.GetCities")
    @ResponseWrapper(localName = "getCitiesResponse", targetNamespace = "http://j2ee.webservices.artslob.ifmo/", className = "ifmo.artslob.webservices.clientj2ee.generated.GetCitiesResponse")
    @Action(input = "http://j2ee.webservices.artslob.ifmo/CityWebServiceJ2EE/getCitiesRequest", output = "http://j2ee.webservices.artslob.ifmo/CityWebServiceJ2EE/getCitiesResponse")
    public List<City> getCities(
        @WebParam(name = "name", targetNamespace = "")
        String name,
        @WebParam(name = "country", targetNamespace = "")
        String country,
        @WebParam(name = "founded", targetNamespace = "")
        String founded,
        @WebParam(name = "population", targetNamespace = "")
        String population,
        @WebParam(name = "area", targetNamespace = "")
        String area);

}