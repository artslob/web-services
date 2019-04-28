package ifmo.artslob.webservices.lab6;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import org.glassfish.grizzly.http.server.HttpServer;

import java.io.IOException;
import java.net.URI;

public class App {
    private static final URI BASE_URI = URI.create("http://localhost:8080/rest/");

    public static void main(String[] args) {
        HttpServer server = null;
        System.out.println("starting server on " + BASE_URI);
        try {
            ResourceConfig resourceConfig = new PackagesResourceConfig(CityResource.class.getPackage().getName());
            server = GrizzlyServerFactory.createHttpServer(BASE_URI, resourceConfig);
            server.start();
            System.in.read();
            stopServer(server);
        } catch (IOException e) {
            e.printStackTrace();
            stopServer(server);
        }
    }

    private static void stopServer(HttpServer server) {
        if (server != null)
            server.stop();
    }
}
