import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ask the user for password length
        System.out.print("Enter password length (from 6 to 50 characters): ");
        int length = scanner.nextInt();
        
        if (length < 6 || length > 50) {
            System.out.println("Error: Password length must be between 6 and 50 characters.");
            return;
        }
        
        // Ask for character types to include
        System.out.print("Include lowercase letters? (true/false): ");
        boolean includeLower = scanner.nextBoolean();
        System.out.print("Include uppercase letters? (true/false): ");
        boolean includeUpper = scanner.nextBoolean();
        System.out.print("Include numbers? (true/false): ");
        boolean includeNumbers = scanner.nextBoolean();
        System.out.print("Include special symbols? (true/false): ");
        boolean includeSymbols = scanner.nextBoolean();
        
        String password = generatePassword(length, includeLower, includeUpper, includeNumbers, includeSymbols);
        System.out.println("Generated password: " + password);
    }
    
    public static String generatePassword(int length, boolean lower, boolean upper, boolean numbers, boolean symbols) {
        String lowerChars = "abcdefghijklmnopqrstuvwxyz";
        String upperChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numberChars = "0123456789";
        String symbolChars = "!@#$%^&*()-_=+<>?/";
        
        String allChars = "";
        if (lower) allChars += lowerChars;
        if (upper) allChars += upperChars;
        if (numbers) allChars += numberChars;
        if (symbols) allChars += symbolChars;
        
        if (allChars.isEmpty()) {
            System.out.println("Error: You must select at least one character type.");
            return "";
        }
        
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allChars.length());
            password.append(allChars.charAt(randomIndex));
        }
        
        return password.toString();
    }
}
