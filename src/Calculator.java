import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    private final static Scanner scanner = new Scanner(System.in);

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) throw new IllegalArgumentException("Cannot divide by zero.");
        return a / b;
    }

    public static void showMenu() {
        System.out.println("\n===== Choose an operation =====");
        System.out.println("[1] Add (+)");
        System.out.println("[2] Subtract (-)");
        System.out.println("[3] Multiply (*)");
        System.out.println("[4] Divide (/)");
        System.out.println("[5] Exit");
        System.out.print("Please select an operation: ");
    }

    public static void startCalculator() {
        System.out.print("Enter the first number: ");
        double a = scanner.nextDouble();

        while (true) {
            try {
                showMenu();
                String input = scanner.next();

                // Exit condition
                if (input.equals("5") || input.equalsIgnoreCase("exit")) {
                    System.out.println("Thank you for using the calculator. Goodbye!");
                    break;
                }

                // Validate the operation input
                if (!input.matches("[1-4]") && !input.matches("[+\\-*/xX]")) {
                    System.out.println("Invalid input. Please choose a valid operator.");
                    continue;
                }

                System.out.print("Enter the next number: ");
                double b = scanner.nextDouble();

                // Perform the operation and display result
                double result = switch (input) {
                    case "1", "+" -> add(a, b);
                    case "2", "-" -> subtract(a, b);
                    case "3", "*", "x", "X" -> multiply(a, b);
                    case "4", "/" -> divide(a, b);
                    default -> {
                        System.out.println("Invalid operator.");
                        yield a;
                    }
                };

                System.out.println("Result: " + a + " " + input + " " + b + " = " + result);
                a = result;

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter valid numbers.");
                scanner.nextLine(); // Clear the invalid input
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("===== Welcome to the Java Calculator =====");
        startCalculator();
        scanner.close();
    }
}
