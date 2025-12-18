import java.util.*;

public class BasicMathOperations {

    // --- Mathematical Methods ---

    public static int add(int num1, int num2) {
        return num1 + num2;
    }

    public static int subtract(int num1, int num2) {
        return num1 - num2;
    }

    public static int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public static double divide(int num1, int num2) {
        return (double) num1 / num2;
    }

    public static int remainder(int num1, int num2) {
        return num1 % num2;
    }

    public static int square(int num) {
        return num * num;
    }

    public static int cube(int num) {
        return num * num * num;
    }

    public static int absolute(int num) {
        if (num < 0) {
            return -num;
        }
        return num;
    }

    // --- Main Method ---

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Math Operations Menu ---");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Remainder");
            System.out.println("6. Square");
            System.out.println("7. Cube");
            System.out.println("8. Absolute Value");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            if (choice == 0) {
                System.out.println("Exiting program.");
                break;
            }

            int num1, num2; // Variables to store input

            switch (choice) {
                case 1:
                    System.out.print("Enter two numbers: ");
                    num1 = sc.nextInt();
                    num2 = sc.nextInt();
                    System.out.println("Result: " + add(num1, num2));
                    break;

                case 2:
                    System.out.print("Enter two numbers: ");
                    num1 = sc.nextInt();
                    num2 = sc.nextInt();
                    System.out.println("Result: " + subtract(num1, num2));
                    break;

                case 3:
                    System.out.print("Enter two numbers: ");
                    num1 = sc.nextInt();
                    num2 = sc.nextInt();
                    System.out.println("Result: " + multiply(num1, num2));
                    break;

                case 4:
                    System.out.print("Enter dividend and divisor: ");
                    num1 = sc.nextInt();
                    num2 = sc.nextInt();
                    if (num2 == 0) {
                        System.out.println("Error: Cannot divide by zero.");
                    } else {
                        System.out.println("Result: " + divide(num1, num2));
                    }
                    break;

                case 5:
                    System.out.print("Enter dividend and divisor: ");
                    num1 = sc.nextInt();
                    num2 = sc.nextInt();
                    if (num2 == 0) {
                        System.out.println("Error: Cannot divide by zero.");
                    } else {
                        System.out.println("Result: " + remainder(num1, num2));
                    }
                    break;

                case 6:
                    System.out.print("Enter a number: ");
                    num1 = sc.nextInt();
                    System.out.println("Result: " + square(num1));
                    break;

                case 7:
                    System.out.print("Enter a number: ");
                    num1 = sc.nextInt();
                    System.out.println("Result: " + cube(num1));
                    break;

                case 8:
                    System.out.print("Enter a number: ");
                    num1 = sc.nextInt();
                    System.out.println("Result: " + absolute(num1));
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        sc.close();
    }
}