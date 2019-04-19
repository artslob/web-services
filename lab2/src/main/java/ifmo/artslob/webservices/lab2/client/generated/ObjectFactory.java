
package ifmo.artslob.webservices.lab2.client.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ifmo.artslob.webservices.lab2.client.generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreateCityResponse_QNAME = new QName("http://lab2.webservices.artslob.ifmo/", "createCityResponse");
    private final static QName _UpdateCity_QNAME = new QName("http://lab2.webservices.artslob.ifmo/", "updateCity");
    private final static QName _CreateCity_QNAME = new QName("http://lab2.webservices.artslob.ifmo/", "createCity");
    private final static QName _DeleteCity_QNAME = new QName("http://lab2.webservices.artslob.ifmo/", "deleteCity");
    private final static QName _UpdateCityResponse_QNAME = new QName("http://lab2.webservices.artslob.ifmo/", "updateCityResponse");
    private final static QName _DeleteCityResponse_QNAME = new QName("http://lab2.webservices.artslob.ifmo/", "deleteCityResponse");
    private final static QName _GetCitiesResponse_QNAME = new QName("http://lab2.webservices.artslob.ifmo/", "getCitiesResponse");
    private final static QName _GetCities_QNAME = new QName("http://lab2.webservices.artslob.ifmo/", "getCities");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ifmo.artslob.webservices.lab2.client.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdateCity }
     * 
     */
    public UpdateCity createUpdateCity() {
        return new UpdateCity();
    }

    /**
     * Create an instance of {@link CreateCity }
     * 
     */
    public CreateCity createCreateCity() {
        return new CreateCity();
    }

    /**
     * Create an instance of {@link DeleteCity }
     * 
     */
    public DeleteCity createDeleteCity() {
        return new DeleteCity();
    }

    /**
     * Create an instance of {@link CreateCityResponse }
     * 
     */
    public CreateCityResponse createCreateCityResponse() {
        return new CreateCityResponse();
    }

    /**
     * Create an instance of {@link GetCities }
     * 
     */
    public GetCities createGetCities() {
        return new GetCities();
    }

    /**
     * Create an instance of {@link UpdateCityResponse }
     * 
     */
    public UpdateCityResponse createUpdateCityResponse() {
        return new UpdateCityResponse();
    }

    /**
     * Create an instance of {@link DeleteCityResponse }
     * 
     */
    public DeleteCityResponse createDeleteCityResponse() {
        return new DeleteCityResponse();
    }

    /**
     * Create an instance of {@link GetCitiesResponse }
     * 
     */
    public GetCitiesResponse createGetCitiesResponse() {
        return new GetCitiesResponse();
    }

    /**
     * Create an instance of {@link City }
     * 
     */
    public City createCity() {
        return new City();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2.webservices.artslob.ifmo/", name = "createCityResponse")
    public JAXBElement<CreateCityResponse> createCreateCityResponse(CreateCityResponse value) {
        return new JAXBElement<CreateCityResponse>(_CreateCityResponse_QNAME, CreateCityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2.webservices.artslob.ifmo/", name = "updateCity")
    public JAXBElement<UpdateCity> createUpdateCity(UpdateCity value) {
        return new JAXBElement<UpdateCity>(_UpdateCity_QNAME, UpdateCity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2.webservices.artslob.ifmo/", name = "createCity")
    public JAXBElement<CreateCity> createCreateCity(CreateCity value) {
        return new JAXBElement<CreateCity>(_CreateCity_QNAME, CreateCity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2.webservices.artslob.ifmo/", name = "deleteCity")
    public JAXBElement<DeleteCity> createDeleteCity(DeleteCity value) {
        return new JAXBElement<DeleteCity>(_DeleteCity_QNAME, DeleteCity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2.webservices.artslob.ifmo/", name = "updateCityResponse")
    public JAXBElement<UpdateCityResponse> createUpdateCityResponse(UpdateCityResponse value) {
        return new JAXBElement<UpdateCityResponse>(_UpdateCityResponse_QNAME, UpdateCityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2.webservices.artslob.ifmo/", name = "deleteCityResponse")
    public JAXBElement<DeleteCityResponse> createDeleteCityResponse(DeleteCityResponse value) {
        return new JAXBElement<DeleteCityResponse>(_DeleteCityResponse_QNAME, DeleteCityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitiesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2.webservices.artslob.ifmo/", name = "getCitiesResponse")
    public JAXBElement<GetCitiesResponse> createGetCitiesResponse(GetCitiesResponse value) {
        return new JAXBElement<GetCitiesResponse>(_GetCitiesResponse_QNAME, GetCitiesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCities }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2.webservices.artslob.ifmo/", name = "getCities")
    public JAXBElement<GetCities> createGetCities(GetCities value) {
        return new JAXBElement<GetCities>(_GetCities_QNAME, GetCities.class, null, value);
    }

}
