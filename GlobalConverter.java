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

        System.out.println(toASCII(input));

        sc.close();
    }

    private static void GetValidInput() {
        while (!isValidInput()) {
            System.out.println("Enter an alphanumerical string to convert:");
            input = sc.nextLine();
        }
    }

    private static void GetValidBase() {
        while (!isValidBase()) {
            System.out.println("Available bases:\n -o octal\n -h hexadecimal\n -b binary\n -t text");
            System.out.println("Enter a valid base:");
            base = sc.nextLine();
        }
    }

    private static boolean isValidBase() {
        return base.length() == 2 && base.matches("-[ohbt]");
    }

    private static boolean isValidInput() {
        return input.length() > 0 && input.matches("[A-Za-z0-9 ]+");
    }

    private static String toASCII(String input) {
        String ascii = "";

        for (char c : input.toCharArray()) {
            ascii += ((int) c);
        }

        return ascii;
    }

}
