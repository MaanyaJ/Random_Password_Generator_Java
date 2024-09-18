import java.security.SecureRandom;
import java.util.Scanner;

public class project {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the length of the password: ");
        int passwordLength = in.nextInt();

        System.out.print("Include lowercase letters? (y/n): ");
        boolean includeLowercase = in.next().equalsIgnoreCase("y");

        System.out.print("Include uppercase letters? (y/n): ");
        boolean includeUppercase = in.next().equalsIgnoreCase("y");

        System.out.print("Include digits? (y/n): ");
        boolean includeDigits = in.next().equalsIgnoreCase("y");

        System.out.print("Include special characters? (y/n): ");
        boolean includeSpecialChars = in.next().equalsIgnoreCase("y");

        String generatedPassword = generatePassword(passwordLength, includeLowercase, includeUppercase, includeDigits, includeSpecialChars);
        System.out.println("Generated Password: " + generatedPassword);

        in.close();
    }

    public static String generatePassword(int length, boolean includeLowercase, boolean includeUppercase, boolean includeDigits, boolean includeSpecialChars) {
        StringBuilder allCharacters = new StringBuilder();

        if (includeLowercase) {
            allCharacters.append("abcdefghijklmnopqrstuvwxyz");
        }
        if (includeUppercase) {
            allCharacters.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        }
        if (includeDigits) {
            allCharacters.append("0123456789");
        }
        if (includeSpecialChars) {
            allCharacters.append("!@#$%^&*()-_+=<>?");
        }

        if (allCharacters.length() == 0) {
            System.out.println("Error: At least one character type must be included.");
            return "";
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allCharacters.length());
            char randomChar = allCharacters.charAt(randomIndex);
            password.append(randomChar);
        }

        return password.toString();
    }
}
