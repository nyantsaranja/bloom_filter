

import method.SHA256;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PasswordGenerator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int PASSWORD_LENGTH = 10;
    private static final String FILENAME = "passwords2.txt";

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Set<String> passwords = new HashSet<>();

        while (passwords.size() < 1000000) {
            String password = generatePassword();
            password= SHA256.hash(password);
            passwords.add(password);
        }

        System.out.println("Generated " + passwords.size() + " unique passwords.");

        try {
            FileWriter writer = new FileWriter(FILENAME);
            for (String password : passwords) {
                writer.write(password + "\n");
            }
            writer.close();
            System.out.println("Passwords written to file " + FILENAME);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file " + FILENAME);
            e.printStackTrace();
        }
    }

    private static String generatePassword() {
        SecureRandom random = new SecureRandom();
        char[] password = new char[PASSWORD_LENGTH];

        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            password[i] = CHARACTERS.charAt(random.nextInt(CHARACTERS.length()));
        }

        return new String(password);
    }

    public static List<String> readPasswordsFromFile(String filename) {
        String[] passwords = null;
        List<String> passwordList=new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                passwordList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return passwordList;
    }
}
