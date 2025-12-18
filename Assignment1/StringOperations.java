public class StringOperations {

    /* * =========================================================================================
     * DIFFERENCES BETWEEN STRING, STRINGBUFFER, AND STRINGBUILDER
     * =========================================================================================
     * * 1. MUTABILITY:
     * - String:        IMMUTABLE. Once created, it cannot be changed. Modifying it creates
     * a new object in memory.
     * - StringBuffer:  MUTABLE. Can be modified (append, delete) without creating new objects.
     * - StringBuilder: MUTABLE. Similar to StringBuffer but generally faster.
     * * 2. THREAD SAFETY (SYNCHRONIZATION):
     * - String:        Thread-safe because it is immutable.
     * - StringBuffer:  THREAD-SAFE. All methods are 'synchronized'. Safe for multi-threading.
     * - StringBuilder: NOT THREAD-SAFE. Methods are not synchronized.
     * * 3. PERFORMANCE:
     * - String:        Slowest for frequent manipulations (concatenation loops).
     * - StringBuffer:  Slower than StringBuilder (due to synchronization overhead).
     * - StringBuilder: FASTEST for string manipulation in a single-threaded environment.
     * * 4. STORAGE:
     * - String:        Stored in the "String Constant Pool" (mostly) inside the Heap.
     * - Buffer/Builder: Stored in the Heap.
     * =========================================================================================
     */

    public static void main(String[] args) {
        System.out.println("--- String Operations Demonstration ---");

        // Initial String
        String str = "  Hello Java Developers  ";
        String str2 = "Hello Java Developers";
        String str3 = "hello java developers";

        // 1. length()
        System.out.println("\n1. length(): " + str.length());

        // 2. trim() - Removes leading and trailing whitespace
        String trimmed = str.trim();
        System.out.println("2. trim(): [" + trimmed + "]");

        // 3. isEmpty()
        System.out.println("3. isEmpty(): " + str.isEmpty());

        // 4. charAt()
        System.out.println("4. charAt(6): " + trimmed.charAt(6)); // Returns 'J'

        // 5. equals() - Case sensitive comparison
        System.out.println("5. equals(): " + trimmed.equals(str2));

        // 6. compareTo() - Lexicographical comparison (returns integer)
        // Returns 0 if equal, negative if smaller, positive if larger
        System.out.println("6. compareTo(): " + trimmed.compareTo(str3));

        // 7. toLowerCase() - Converts to lower case
        System.out.println("7. toLowerCase(): " + trimmed.toLowerCase());

        // 8. startsWith() & endsWith()
        System.out.println("8a. startsWith('Hello'): " + trimmed.startsWith("Hello"));
        System.out.println("8b. endsWith('Python'): " + trimmed.endsWith("Python"));

        // 9. contains() - Checks if sequence exists
        System.out.println("9. contains('Dev'): " + trimmed.contains("Dev"));

        // 10. indexOf() & lastIndexOf()
        String phrase = "Java is fun and Java is powerful";
        System.out.println("10a. indexOf('Java'): " + phrase.indexOf("Java"));      // First occurrence
        System.out.println("10b. lastIndexOf('Java'): " + phrase.lastIndexOf("Java")); // Last occurrence

        // 11. substring() - Extracts part of string
        // Note: End index is exclusive
        System.out.println("11. substring(6, 10): " + trimmed.substring(6, 10)); // "Java"

        // 12. replace() - Replaces all occurrences
        System.out.println("12. replace('Java', 'C++'): " + trimmed.replace("Java", "C++"));

        // 13. matches() - Checks against a Regular Expression (Regex)
        String email = "student@example.com";
        // Regex for "anything" then "@" then "anything"
        System.out.println("13. matches(Regex): " + email.matches(".*@.*")); 

        // 14. split() - Splits string into array based on delimiter
        String csv = "Apple,Banana,Mango";
        String[] fruits = csv.split(",");
        System.out.print("14. split(','): ");
        for (String f : fruits) {
            System.out.print("[" + f + "] ");
        }
        System.out.println();

        // 15. join() - Joins elements with a delimiter (Static method)
        String joined = String.join(" | ", "One", "Two", "Three");
        System.out.println("15. join(): " + joined);

        // 16. valueOf() - Converts other data types to String
        int num = 100;
        String sNum = String.valueOf(num);
        System.out.println("16. valueOf(100): " + (sNum + 50)); // Result: "10050" (Concatenation)

        // 17. toString()
        // String already overrides toString() to return itself
        System.out.println("17. toString(): " + trimmed.toString());
    }
}