import java.util.Scanner;

public class ArrayOperations {
    // Global variables to be accessible across all methods
    static int[] arr;
    static int n = 0; // Tracks the current number of elements
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("--- Array Operations Program ---");
        System.out.print("Enter the maximum size of the array: ");
        int size = sc.nextInt();
        arr = new int[size];

        while (true) {
            System.out.println("\n----------- MENU -----------");
            System.out.println("1. Insert Element (At End)");
            System.out.println("2. Insert Element (At Position)"); 
            System.out.println("3. Delete Element (by Index)");
            System.out.println("4. Linear Search");
            System.out.println("5. Binary Search (Requires Sorted Array)");
            System.out.println("6. Find Maximum Value");
            System.out.println("7. Count Even/Odd Numbers");
            System.out.println("8. Perform Insertion Sort");
            System.out.println("9. Display Array");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: insert(); break;
                case 2: insertAtPosition(); break; 
                case 3: delete(); break;
                case 4: linearSearch(); break;
                case 5: binarySearch(); break;
                case 6: findMax(); break;
                case 7: countEvenOdd(); break;
                case 8: insertionSort(); break;
                case 9: display(); break;
                case 0: 
                    System.out.println("Exiting program...");
                    System.exit(0);
                default: 
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // 1. Insertion (at end)
    public static void insert() {
        if (n >= arr.length) {
            System.out.println("Error: Array is Full (Overflow).");
        } else {
            System.out.print("Enter value to insert: ");
            int val = sc.nextInt();
            arr[n] = val;
            n++; 
            System.out.println("Inserted " + val + " successfully.");
        }
    }

    // 2. Insert at Specific Position
    public static void insertAtPosition() {
        if (n >= arr.length) {
            System.out.println("Error: Array is Full (Overflow).");
            return;
        }

        System.out.print("Enter index to insert at (0 to " + n + "): ");
        int index = sc.nextInt();

        if (index < 0 || index > n) {
            System.out.println("Error: Invalid Index. Must be between 0 and " + n);
            return;
        }

        System.out.print("Enter value to insert: ");
        int val = sc.nextInt();

        
        for (int i = n; i > index; i--) {
            arr[i] = arr[i - 1];
        }

        arr[index] = val;
        n++;
        System.out.println("Inserted " + val + " at index " + index + " successfully.");
    }

    // 3. Deletion
    public static void delete() {
        if (n == 0) {
            System.out.println("Error: Array is Empty (Underflow).");
            return;
        }
        System.out.print("Enter index to delete (0 to " + (n - 1) + "): ");
        int index = sc.nextInt();

        if (index < 0 || index >= n) {
            System.out.println("Error: Invalid Index.");
        } else {
            int deletedValue = arr[index];
            for (int i = index; i < n - 1; i++) {
                arr[i] = arr[i + 1];
            }
            n--; 
            System.out.println("Deleted " + deletedValue + " successfully.");
        }
    }

    // 4. Linear Search
    public static void linearSearch() {
        if (n == 0) {
            System.out.println("Array is empty.");
            return;
        }
        System.out.print("Enter value to search: ");
        int key = sc.nextInt();
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                System.out.println("Element found at index: " + i);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Element not found.");
    }

    // 5. Binary Search
    public static void binarySearch() {
        if (n == 0) {
            System.out.println("Array is empty.");
            return;
        }
        System.out.println("(Note: Ensure array is sorted before using Binary Search)");
        System.out.print("Enter value to search: ");
        int key = sc.nextInt();

        int low = 0;
        int high = n - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == key) {
                result = mid;
                break;
            }
            if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found.");
        }
    }

    // 6. Find Maximum
    public static void findMax() {
        if (n == 0) {
            System.out.println("Array is empty.");
            return;
        }
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Maximum value in array is: " + max);
    }

    // 7. Count Even and Odd
    public static void countEvenOdd() {
        if (n == 0) {
            System.out.println("Array is empty.");
            return;
        }
        int evenCount = 0;
        int oddCount = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) evenCount++;
            else oddCount++;
        }
        System.out.println("Even Numbers: " + evenCount);
        System.out.println("Odd Numbers: " + oddCount);
    }

    // 8. Insertion Sort
    public static void insertionSort() {
        if (n < 2) {
            System.out.println("Array is already sorted or empty.");
            return;
        }
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        System.out.println("Array sorted using Insertion Sort.");
    }

    // 9. Display Array
    public static void display() {
        if (n == 0) {
            System.out.println("Array is empty.");
            return;
        }
        System.out.print("Current Array Elements: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}