package ifmo.artslob.webservices.lab2.client;

import ifmo.artslob.webservices.lab2.client.generated.City;
import ifmo.artslob.webservices.lab2.client.generated.CityService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class WebServiceClient {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/CityService?wsdl");
        CityService cityService = new CityService(url);
        List<City> cities = cityService.getCityWebServicePort().getCities();
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
