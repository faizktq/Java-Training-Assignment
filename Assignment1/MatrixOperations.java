import java.util.Scanner;

public class MatrixOperations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MATRIX OPERATIONS MENU ---");
            System.out.println("1. Addition (A + B)");
            System.out.println("2. Subtraction (A - B)");
            System.out.println("3. Multiplication (A * B)");
            System.out.println("4. Transpose of a Matrix");
            System.out.println("5. Check if Square Matrix");
            System.out.println("6. Check if Diagonal Matrix");
            System.out.println("7. Check if Identity Matrix");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            
            if (choice == 8) {
                System.out.println("Exiting program...");
                break;
            }

            switch (choice) {
                case 1: // Addition
                    System.out.println("--- Input Matrix A ---");
                    int[][] a1 = inputMatrix(sc);
                    System.out.println("--- Input Matrix B ---");
                    int[][] b1 = inputMatrix(sc);
                    add(a1, b1);
                    break;

                case 2: // Subtraction
                    System.out.println("--- Input Matrix A ---");
                    int[][] a2 = inputMatrix(sc);
                    System.out.println("--- Input Matrix B ---");
                    int[][] b2 = inputMatrix(sc);
                    subtract(a2, b2);
                    break;

                case 3: // Multiplication
                    System.out.println("--- Input Matrix A ---");
                    int[][] a3 = inputMatrix(sc);
                    System.out.println("--- Input Matrix B ---");
                    int[][] b3 = inputMatrix(sc);
                    multiply(a3, b3);
                    break;

                case 4: // Transpose
                    System.out.println("--- Input Matrix ---");
                    int[][] a4 = inputMatrix(sc);
                    transpose(a4);
                    break;

                case 5: // Check Square
                    System.out.println("--- Input Matrix ---");
                    int[][] a5 = inputMatrix(sc);
                    if (isSquare(a5)) System.out.println("Result: It is a Square Matrix.");
                    else System.out.println("Result: It is NOT a Square Matrix.");
                    break;

                case 6: // Check Diagonal
                    System.out.println("--- Input Matrix ---");
                    int[][] a6 = inputMatrix(sc);
                    if (isDiagonal(a6)) System.out.println("Result: It is a Diagonal Matrix.");
                    else System.out.println("Result: It is NOT a Diagonal Matrix.");
                    break;

                case 7: // Check Identity
                    System.out.println("--- Input Matrix ---");
                    int[][] a7 = inputMatrix(sc);
                    if (isIdentity(a7)) System.out.println("Result: It is an Identity Matrix.");
                    else System.out.println("Result: It is NOT an Identity Matrix.");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // --- Helper Method to Input a Matrix ---
    public static int[][] inputMatrix(Scanner sc) {
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];
        System.out.println("Enter elements for " + rows + "x" + cols + " matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    // --- Helper Method to Display a Matrix ---
    public static void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // 1. Addition Logic
    public static void add(int[][] a, int[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) {
            System.out.println("Error: Matrix dimensions must match for addition.");
            return;
        }
        int rows = a.length;
        int cols = a[0].length;
        int[][] sum = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum[i][j] = a[i][j] + b[i][j];
            }
        }
        System.out.println("Sum Matrix:");
        displayMatrix(sum);
    }

    // 2. Subtraction Logic
    public static void subtract(int[][] a, int[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) {
            System.out.println("Error: Matrix dimensions must match for subtraction.");
            return;
        }
        int rows = a.length;
        int cols = a[0].length;
        int[][] diff = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                diff[i][j] = a[i][j] - b[i][j];
            }
        }
        System.out.println("Difference Matrix:");
        displayMatrix(diff);
    }

    // 3. Multiplication Logic
    public static void multiply(int[][] a, int[][] b) {
        int r1 = a.length;
        int c1 = a[0].length;
        int r2 = b.length;
        int c2 = b[0].length;

        if (c1 != r2) {
            System.out.println("Error: Columns of A must equal Rows of B.");
            return;
        }

        int[][] product = new int[r1][c2];

        // Standard 3-loop multiplication
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    product[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        System.out.println("Product Matrix:");
        displayMatrix(product);
    }

    // 4. Transpose Logic
    public static void transpose(int[][] a) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] trans = new int[cols][rows]; // Dimensions are swapped

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                trans[j][i] = a[i][j]; // Swap indices
            }
        }
        System.out.println("Transpose Matrix:");
        displayMatrix(trans);
    }

    // 5. Check Square
    public static boolean isSquare(int[][] a) {
        return a.length == a[0].length;
    }

    // 6. Check Diagonal
    public static boolean isDiagonal(int[][] a) {
        if (!isSquare(a)) return false; // Must be square first

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                // If indices are different (non-diagonal) AND value is not 0
                if (i != j && a[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // 7. Check Identity
    public static boolean isIdentity(int[][] a) {
        if (!isSquare(a)) return false;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (i == j && a[i][j] != 1) return false; // Diagonal must be 1
                if (i != j && a[i][j] != 0) return false; // Non-diagonal must be 0
            }
        }
        return true;
    }
}