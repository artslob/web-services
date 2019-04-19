package ifmo.artslob.webservices.lab2.client;

import ifmo.artslob.webservices.lab2.client.generated.City;
import ifmo.artslob.webservices.lab2.client.generated.CityService;
import ifmo.artslob.webservices.lab2.client.generated.CityWebService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class WebServiceClient {
    private final static String createMethodName = "create";
    private final static String readMethodName = "read";
    private final static String updateMethodName = "update";
    private final static String deleteMethodName = "delete";

    public static void main(String[] args) throws MalformedURLException {
        String method = (args.length > 0) ? args[0] : "default";

        URL url = new URL("http://localhost:8080/CityService?wsdl");
        CityWebService cityWebService = new CityService(url).getCityWebServicePort();

        switch (method) {
            case createMethodName: {
                cityWebService.createCity("", "", "", "", "");
                break;
            }
            case readMethodName: {
                List<City> cities = cityWebService.getCities("", "", "", "", "");
                for (City city : cities) {
                    System.out.println("City{" +
                            "name='" + city.getName() + '\'' +
                            ", country='" + city.getCountry() + '\'' +
                            ", founded=" + city.getFounded() +
                            ", population=" + city.getPopulation() +
                            ", area=" + city.getArea() +
                            '}');
                }
                System.out.println("Total cities: " + cities.size());
                break;
            }
            case updateMethodName: {
                cityWebService.updateCity("", "", "", "", "", "");
                break;
            }
            case deleteMethodName: {
                cityWebService.deleteCity("");
                break;
            }
            default: {
                System.err.println("Program requires first cli argument to be name of one CRUD method: " +
                        createMethodName + ", " + readMethodName + ", " + updateMethodName + " or " + deleteMethodName);
                System.exit(1);
                break;
            }
        }
    }
}
