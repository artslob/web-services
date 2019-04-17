package ifmo.artslob.webservices.clientj2ee;

import ifmo.artslob.webservices.clientj2ee.generated.City;
import ifmo.artslob.webservices.clientj2ee.generated.CityServiceJ2EE;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class WebServiceClientJ2EE {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://127.0.0.1:8080/lab1/CityServiceJ2EE?wsdl");
        CityServiceJ2EE cityService = new CityServiceJ2EE(url);
        List<City> cities = cityService
                .getCityWebServiceJ2EEPort()
                .getCities(args[0], args[1], args[2], args[3], args[4]);
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
    }
}
