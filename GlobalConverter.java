import java.util.Scanner;

public class GlobalConverter {
    public static void main(String[] args) {

        String input = "";

        if (args.length >= 1) {
            // default input
            input = args[0];
        } else {
            // manual input
            System.out.println("Enter string to convert :");
            Scanner sc = new Scanner(System.in);
            input = sc.nextLine();
            sc.close();
        }

        if (isValid(input)) {
            System.out.println("Valid Input");
        } else {
            System.out.println("Invalid input.\nMust be alphanumerical");
        }

    }

    private static boolean isValid(String input) {
        return input.matches("[A-Za-z0-9]+");
    }
}
