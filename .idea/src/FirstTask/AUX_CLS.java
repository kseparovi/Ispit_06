package FirstTask;

public class AUX_CLS {
    public static boolean checkUserInputs(String input1, String input2) {
        try {
            Double.parseDouble(input1);
            Double.parseDouble(input2);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public static void performArithmeticOperations(double num1, double num2) {
        System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
        System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
        System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
        try {
            if (num2 == 0) {
                throw new ZeroDivisionException("Division by zero is not defined!");
            } else {
                System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
            }
        } catch (ZeroDivisionException e) {
            System.out.println(e.getMessage());
        }
    }
}
