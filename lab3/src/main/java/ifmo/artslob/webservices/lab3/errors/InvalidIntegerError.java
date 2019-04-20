package ifmo.artslob.webservices.lab3.errors;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "ifmo.artslob.webservices.lab3.errors.CityServiceFault")
public class InvalidIntegerError extends Exception {
    private static final long serialVersionUID = -6677483225123321556L;
    private final CityServiceFault fault;

    public InvalidIntegerError(String message, CityServiceFault fault) {
        super(message);
        this.fault = fault;
    }

    public InvalidIntegerError(String message, Throwable cause, CityServiceFault fault) {
        super(message, cause);
        this.fault = fault;
    }

    public CityServiceFault getFaultInfo() {
        return fault;
    }
}
