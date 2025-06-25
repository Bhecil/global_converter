
public class GlobalConverter {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Invalid number of arguments.");
            return;    
        }
        
        String stringToConvert = args[0];

        if (IsStringValid(stringToConvert) == false) {
            System.out.println("Invalid String.");
        }
        else {
            System.out.println("Valid String");
        }
    }

    private static boolean IsStringValid(String stringToConvert) {
        return (stringToConvert != null) && stringToConvert.matches("^[a-zA-Z0-9- ]+$");
    }
}
