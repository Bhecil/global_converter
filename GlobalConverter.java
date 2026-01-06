import java.util.Scanner;

public class GlobalConverter {
    static String input;
    static String base;

    public static void main(String[] args) {

        gatherInput(args);

        if (isValidInput(input)) {
            System.out.println("Valid input");
        } else {
            System.out.println("Invalid input.\nMust be alphanumerical");
        }

        if (isValidBase(base)) {
            System.out.println("Valid base");
        } else {
            System.out.println("Invalid base.\nAvailable bases:\n -o octal\n -h hexadecimal\n -b binary\n -t text");
        }

        System.out.println(toASCII(input));

    }

    private static void gatherInput(String[] args) {
        if (args.length >= 2) {
            // default input
            input = args[1];
            base = args[0];
        } else {
            // manual input
            System.out.println("Enter string to convert:");
            Scanner sc = new Scanner(System.in);
            input = sc.nextLine();

            System.out.println("Enter base:");
            base = sc.nextLine();

            sc.close();
        }

    }

    private static boolean isValidBase(String base) {
        return base.matches("-[ohbt]");
    }

    private static boolean isValidInput(String input) {
        return input.matches("[A-Za-z0-9 ]+");
    }

    private static String toASCII(String input) {
        String ascii = "";

        for (char c : input.toCharArray()) {
            ascii += ((int) c);
        }

        return ascii;
    }

}
