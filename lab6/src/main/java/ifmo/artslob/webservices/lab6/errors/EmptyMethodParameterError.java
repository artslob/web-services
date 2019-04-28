package ifmo.artslob.webservices.lab6.errors;

public class EmptyMethodParameterError extends Exception {
    private static final long serialVersionUID = -6758644772732231174L;

    public EmptyMethodParameterError(String message) {
        super(message);
    }

    public static EmptyMethodParameterError getDefaultInstance() {
        return new EmptyMethodParameterError("parameter cannot be null or empty");
    }
}
