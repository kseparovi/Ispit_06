package FirstTask;

import java.util.Scanner;

public class TestApp {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1, input2;
        String exitInput;

        do {
            System.out.print("Please enter string or number: ");
            input1 = scanner.nextLine();
            System.out.print("Please enter string or number: ");
            input2 = scanner.nextLine();

            if (AUX_CLS.checkUserInputs(input1, input2)) {
                System.out.println("Concatenation: " + input1 + input2);
            } else {
                try {
                    double num1 = Double.parseDouble(input1);
                    double num2 = Double.parseDouble(input2);
                    AUX_CLS.performArithmeticOperations(num1, num2);
                } catch (NumberFormatException e) {
                    System.out.println("One of the inputs is not a valid number. Please try again.");
                }
            }

            System.out.println("<<<<<<<<<<<<<<<<<< Finished one round >>>>>>>>>>>>>>>>>>>>>>");
            System.out.print("To exit enter 'x' - any other to continue: ");
            exitInput = scanner.nextLine();

        } while (!exitInput.equalsIgnoreCase("x"));

        System.out.println("User decides to quit app!");
        scanner.close();
    }
}
