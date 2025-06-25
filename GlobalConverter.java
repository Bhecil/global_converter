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

        System.out.println("Base " + conversionBase + ": " + ToBase(conversionBase, ToASCII(stringToConvert)));
    }

    private static boolean IsStringValid(String stringToConvert) {
        return (stringToConvert != null) && stringToConvert.matches("^[a-zA-Z0-9- ]+$");
    }

    private static boolean IsBaseValid(String conversionBase) {
        return (conversionBase != null) && conversionBase.matches("^-[hdobt]$");
    }

    private static int[] ToASCII(String stringToConvert) {
        var asciiString = new int[stringToConvert.length()];

        for (int index = 0; index < stringToConvert.length(); index++) {
            asciiString[index] = (int)stringToConvert.charAt(index);            
        }

        return asciiString;
    }

    private static String ToBase(String conversionBase, int[] asciiString) {
        var convertedString = "";
        var divisor = 1;

        //convert base text to int
        switch (conversionBase) {
            case "-h" -> divisor = 16;
            case "-d" -> divisor = 10;
            case "-o" -> divisor = 8;
            case "-b" -> divisor = 2;
        }

        //convert each digit into the given base
        for (int index = 0; index < asciiString.length; index++) {
            var convertedDigit = "";

            int quotient;
            int dividend = asciiString[index];
            int remainder;

            //successive division until quotient is 0
            do { 
                quotient = dividend / divisor;
                remainder = dividend % divisor;

                if (divisor == 16 && remainder > 9) {
                    switch (remainder) {
                        case 10 -> convertedDigit += "A";
                        case 11 -> convertedDigit += "B";
                        case 12 -> convertedDigit += "C";
                        case 13 -> convertedDigit += "D";
                        case 14 -> convertedDigit += "E";
                        case 15 -> convertedDigit += "F";
                    }
                }
                else {
                    convertedDigit += remainder;
                }

                dividend = quotient;
                
            } while (quotient != 0);

            //add the (reversed) digit to the converted string
            convertedString += new StringBuilder(convertedDigit).reverse().toString() +" ";
        }

        return convertedString;
    }
}
