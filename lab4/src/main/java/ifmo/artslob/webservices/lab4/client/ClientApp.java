package ifmo.artslob.webservices.lab4.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import ifmo.artslob.webservices.lab4.City;

import javax.ws.rs.core.MediaType;
import java.util.List;

public class ClientApp {
    private static final String URL = "http://localhost:8080/rest/cities";

    public static void main(String[] args) {
        Client client = Client.create();
        printList(getCities(
                client,
                getCliArgOrNull(args, 0),
                getCliArgOrNull(args, 1),
                getCliArgOrNull(args, 2),
                getCliArgOrNull(args, 3),
                getCliArgOrNull(args, 4)
        ));
        System.out.println();
        printList(getCities(client, "Paris", null, null, null, null));
    }

    private static List<City> getCities(
            Client client,
            String name,
            String country,
            String founded,
            String population,
            String area
    ) {
        WebResource webResource = client.resource(URL);
        if (name != null) {
            webResource = webResource.queryParam("name", name);
        }
        if (country != null) {
            webResource = webResource.queryParam("country", country);
        }
        if (founded != null) {
            webResource = webResource.queryParam("founded", founded);
        }
        if (population != null) {
            webResource = webResource.queryParam("population", population);
        }
        if (area != null) {
            webResource = webResource.queryParam("area", area);
        }
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }
        GenericType<List<City>> type = new GenericType<List<City>>() {
        };
        return response.getEntity(type);
    }

    private static void printList(List<City> cities) {
        if (cities.size() == 0) {
            System.out.println("got empty cities list");
            return;
        }
        for (City city : cities) {
            System.out.println(city);
        }
    }

    private static String getCliArgOrNull(String[] args, int number) {
        return (args.length > number) ? args[number].trim() : null;
    }
}
