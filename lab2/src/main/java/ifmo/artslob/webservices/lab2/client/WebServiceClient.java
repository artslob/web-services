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
                int new_id = cityWebService.createCity("", "", "", "", "");
                System.out.println("Created new city with id: " + new_id);
                break;
            }
            case readMethodName: {
                List<City> cities = cityWebService.getCities("", "", "", "", "");
                for (City city : cities) {
                    System.out.println(cityToString(city));
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

    private static String cityToString(City city) {
        return String.format("City{name='%s', country='%s', founded=%d, population=%d, area=%d}",
                city.getName(), city.getCountry(), city.getFounded(), city.getPopulation(), city.getArea());
    }
}
