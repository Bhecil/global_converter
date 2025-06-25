import java.util.Arrays;

public class GlobalConverter {

    public static void main(String[] args) {
        String stringToConvert;
        String conversionBase;

        if (args.length != 2) {
            System.out.println("Invalid number of arguments.");
            return;    
        }

        stringToConvert = args[1];
        conversionBase = args[0];

        if (IsBaseValid(conversionBase) == false) {
            System.out.println("Invalid Base.");
        }
        else {
            System.out.println("Valid Base.");
        }

        if (IsStringValid(stringToConvert) == false) {
            System.out.println("Invalid String.");
        }
        else {
            System.out.println("Valid String.");
        }

        if (IsBaseValid(conversionBase) == false || IsStringValid(stringToConvert) == false) {
            return;
        }

        System.out.println("ASCII: " + Arrays.toString(ToASCII(stringToConvert)));
    }

    private static boolean IsStringValid(String stringToConvert) {
        return (stringToConvert != null) && stringToConvert.matches("^[a-zA-Z0-9- ]+$");
    }

    private static boolean IsBaseValid(String conversionBase) {
        return (conversionBase != null) && conversionBase.matches("^-[hobt]$");
    }

    private static int[] ToASCII(String stringToConvert) {
        var asciiString = new int[stringToConvert.length()];

        for (int index = 0; index < stringToConvert.length(); index++) {
            asciiString[index] = (int)stringToConvert.charAt(index);            
        }

        return asciiString;
    }
}
