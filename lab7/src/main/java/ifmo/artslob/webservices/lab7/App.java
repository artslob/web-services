package ifmo.artslob.webservices.lab7;

public class App {
    private final static String publishMethodName = "publish";
    private final static String browseMethodName = "browse";

    public static void main(String[] args) {
        String method = (args.length > 0) ? args[0] : "default";

        switch (method) {
            case publishMethodName: {
                checkParamsLength(args, 4);
                new Publisher().publish(args[1].trim(), args[2].trim(), args[3].trim());
                break;
            }
            case browseMethodName: {
                checkParamsLength(args, 42);
                break;
            }
            default: {
                String operations = String.join(", ", publishMethodName, browseMethodName);
                System.err.println(
                        String.format("Program requires first cli argument to be name of operation: %s.", operations)
                );
                System.exit(1);
                break;
            }
        }
    }

    private static void checkParamsLength(String[] args, int length) {
        if (args.length < length) {
            String message = String.format("Wrong number of parameters, got: %d, expected: %d", args.length, length);
            System.err.println(message);
            System.exit(1);
        }
    }
}
