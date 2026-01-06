import java.util.Scanner;

public class GlobalConverter {
    static String input = "";
    static String base = "";

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        if (args.length >= 2) {
            // default input
            input = args[1];
            base = args[0];
        }

        GetValidInput();
        GetValidBase();

        System.out.println(convert());
    }

    private static void GetValidInput() {
        while (!isValidInput()) {
            System.out.println("Enter an alphanumerical string to convert:");
            input = sc.nextLine();
        }
    }

    private static void GetValidBase() {
        while (!isValidBase()) {
            System.out.println("Available bases:\n -b binary\n -d decimal\n -h hexadecimal\n -o octal\n -t text");
            System.out.println("Enter a valid base:");
            base = sc.nextLine();
        }
    }

    private static boolean isValidBase() {
        return base.length() == 2 && base.matches("-[bdhot]");
    }

    private static boolean isValidInput() {
        return input.length() > 0 && input.matches("[A-Za-z0-9 ]+");
    }

    private static String convert() {
        StringBuilder converted = new StringBuilder();
        int b = 10;

        for (char c : input.toCharArray()) {
            int ascii = (int) c;
            String val = "";
            if (base.equals("-d")) {
                // decimal
                val = Integer.toString(ascii);
            } else if (base.equals("-t")) {
                System.out.println("Coming soon");

            } else {
                // binary, octal and hexadecimal
                switch (base) {
                    case "-b":
                        b = 2;
                        break;
                    case "-o":
                        b = 8;
                        break;
                    case "-h":
                        b = 16;
                        break;
                }
                val = toBase(ascii, b);
            }
            converted.append(val).append(" ");
        }

        return converted.toString();

    }

    private static String toBase(int value, int b) {
        if (value == 0)
            return "0";

        StringBuilder converted = new StringBuilder();

        while (value != 0) {
            int digit = value % b;
            if (digit < 10)
                converted.append(digit);
            else // hex values from A to F
                converted.append((char) ('A' + digit - 10));
            value /= b;
        }
        return converted.reverse().toString();
    }
}
