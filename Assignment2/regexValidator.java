import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class regexValidator {
    private static final String MOBILE_REGEX = "^\\d{10}$";
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final String USERNAME_REGEX = "^[a-zA-Z0-9]{5,15}$";
    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("---- Input Validation System ----");
            System.out.println("1. Validate Mobile Number");
            System.out.println("2. Validate Email Number");
            System.out.println("3. Validate Username");
            System.out.println("4. Validate Password");
            System.out.println("5. Exit");

            System.out.println("\n\n Choose the option");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice>=1 && choice <5) {
                System.out.println("Enter the Value to Validate: ");
                String input = sc.nextLine();
                validateInput(choice,input);   
            }
            if (choice == 5) System.exit(0);
        }
    }
    private static void validateInput(int type,String input){
        String regex = "";
        String fieldName = "";
        switch (type) {
            case 1:
                regex = MOBILE_REGEX; fieldName = "Mobile Number";
                break;
            case 2:
                regex = EMAIL_REGEX; fieldName = "Email";
                break;
            case 3:
                regex = USERNAME_REGEX; fieldName = "Username";
                break;
            case 4:
                regex = PASSWORD_REGEX; fieldName = "Password";
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if(matcher.matches()){
            System.out.println("Your "+fieldName+" is valid");
        }
        else{
            System.out.println("Invalid input for "+fieldName+" . Please Try again.");
        }
    }
}
