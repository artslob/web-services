package ifmo.artslob.webservices.lab3.errors;

public class CityServiceFault {
    private static final String DEFAULT_MESSAGE = "some error occurred in CityService";
    private String message;

    public CityServiceFault(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static CityServiceFault defaultInstance() {
        return new CityServiceFault(DEFAULT_MESSAGE);
    }
}
