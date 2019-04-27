package ifmo.artslob.webservices.lab5.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import ifmo.artslob.webservices.lab5.City;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.util.List;

public class ClientApp {
    private final static String createMethodName = "create";
    private final static String readMethodName = "read";
    private final static String updateMethodName = "update";
    private final static String deleteMethodName = "delete";

    private static final String URL = "http://localhost:8080/rest/cities";

    public static void main(String[] args) {
        Client client = Client.create();
        String method = (args.length > 0) ? args[0] : "default";

        switch (method) {
            case createMethodName: {
                checkParamsLength(args, 6);
                String result = createCity(client, args[1], args[2], args[3], args[4], args[5]);
                System.out.println("Created new city with id: " + result);
                break;
            }
            case readMethodName: {
                List<City> cities = getCities(
                        client,
                        getCliArgOrNull(args, 1),
                        getCliArgOrNull(args, 2),
                        getCliArgOrNull(args, 3),
                        getCliArgOrNull(args, 4),
                        getCliArgOrNull(args, 5)
                );
                for (City city : cities) {
                    System.out.println(city);
                }
                System.out.println("Total cities: " + cities.size());
                break;
            }
            case updateMethodName: {
                checkParamsLength(args, 7);
                String success = updateCity(client, args[1], args[2], args[3], args[4], args[5], args[6]);
                System.out.println("Update operation is successful: " + success);
                break;
            }
            case deleteMethodName: {
                checkParamsLength(args, 2);
                String success = deleteCity(client, args[1]);
                System.out.println("Delete operation is successful: " + success);
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

    private static String createCity(
            Client client,
            String name,
            String country,
            String founded,
            String population,
            String area
    ) {
        WebResource webResource = client.resource(URL);
        MultivaluedMap<String, String> formData = cityFormData(name, country, founded, population, area);
        ClientResponse response = webResource
                .type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
                .post(ClientResponse.class, formData);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }
        GenericType<String> type = new GenericType<String>() {
        };
        return response.getEntity(type);
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

    private static String updateCity(
            Client client,
            String id,
            String name,
            String country,
            String founded,
            String population,
            String area
    ) {
        WebResource webResource = client.resource(URL + "/" + id.trim());
        MultivaluedMap<String, String> formData = cityFormData(name, country, founded, population, area);
        ClientResponse response = webResource
                .type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
                .put(ClientResponse.class, formData);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }
        GenericType<String> type = new GenericType<String>() {
        };
        return response.getEntity(type);
    }

    private static String deleteCity(Client client, String id) {
        WebResource webResource = client.resource(URL + "/" + id.trim());
        ClientResponse response = webResource
                .type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
                .delete(ClientResponse.class);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }
        GenericType<String> type = new GenericType<String>() {
        };
        return response.getEntity(type);
    }

    private static MultivaluedMap<String, String> cityFormData(
            String name,
            String country,
            String founded,
            String population,
            String area
    ) {
        MultivaluedMap<String, String> formData = new MultivaluedMapImpl();
        formData.add("name", name);
        formData.add("country", country);
        formData.add("founded", founded);
        formData.add("population", population);
        formData.add("area", area);
        return formData;
    }

    private static void checkParamsLength(String[] args, int length) {
        if (args.length < length) {
            String message = String.format("Wrong number of parameters, got: %d, expected: %d", args.length, length);
            System.err.println(message);
            System.exit(1);
        }
    }

    private static String getCliArgOrNull(String[] args, int number) {
        return (args.length > number) ? args[number].trim() : null;
    }
}
