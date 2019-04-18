package ifmo.artslob.webservices.lab2;

import javax.xml.ws.Endpoint;

public class App {
    public static void main(String[] args) {
        String url = "http://0.0.0.0:8080/CityService";
        Endpoint.publish(url, new CityWebService());
        System.out.println("Started on:" + url);
    }
}
