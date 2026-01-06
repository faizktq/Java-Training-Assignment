import java.io.*;
import java.util.HashMap;

class BankFileHandler {

    private static final String FILE_NAME = "accounts.dat";

    public static void saveAccounts(HashMap<Integer, BankAccount> accounts) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(accounts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<Integer, BankAccount> loadAccounts() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (HashMap<Integer, BankAccount>) ois.readObject();
        } catch (Exception e) {
            return new HashMap<>();
        }
    }
}
