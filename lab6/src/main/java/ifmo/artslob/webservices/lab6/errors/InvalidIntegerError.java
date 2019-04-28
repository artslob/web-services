package ifmo.artslob.webservices.lab6.errors;

public class InvalidIntegerError extends Exception {
    private static final long serialVersionUID = -6751234882732231471L;

    public InvalidIntegerError(String message) {
        super(message);
    }

    public static InvalidIntegerError getDefaultInstance() {
        return new InvalidIntegerError("could not parse parameter as integer");
    }
}
