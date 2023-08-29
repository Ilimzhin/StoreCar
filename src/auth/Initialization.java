package auth;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Initialization {
    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,32}$";
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);
    static Scanner scanner = new Scanner(System.in);
    static User user = new User();

    public boolean initialization() {
        System.out.println("--- Registration ---");
        regLogin();
        regPassword();
        System.out.println("--- Authorization ---");
        return auth();
    }

    private void regLogin() {
        String login;
        while (true) {
            System.out.print("• Enter login: ");
            login = scanner.next();
            if (login.length() > 3) {
                user.setLogin(login);
                break;
            } else localNotifications(4);
        }
    }

    private void regPassword() {
        String password;
        while (true) {
            System.out.print("• Enter password: ");
            password = scanner.next();
            if (PASSWORD_PATTERN.matcher(password).matches()) {
                user.setPassword(password);
                break;
            } else localNotifications(6);
        }
    }

    private boolean auth() {
        String login, password;
        int counter = 0;
        while (true) {
            if (counter <= 3) {
                System.out.print("• Enter login: ");
                login = scanner.next();
                System.out.print("• Enter password: ");
                password = scanner.next();
                if (login.equals(user.getLogin()) && password.equals(user.getPassword())) return true;
                else localNotifications(3);
            } else {
                localNotifications(5);
                System.exit(0);
            }
            counter++;
        }
    }

    public static void localNotifications(int status) {
        // Errors:        if (status == 1) System.out.println("[!] Incorrect value.");
        if (status == 2) System.out.println("[!] Unknown error.");
        else if (status == 3) System.out.println("[!] Incorrect login or password.");
        else if (status == 4) System.out.println("[!] Login length should not be less than 3.");
        else if (status == 5) System.out.println("[!] Too many attempts have been used.");
        else if (status == 6) System.out.println("""
                [!] The password must be at least 8 characters long, have at least:\s
                1. One digit;
                2. One special character;                            
                3. One capital letter;
                4. One small letter.""");        // Notifications:
        else if (status == 7)
            System.out.println("[i] Login to the account has been successfully completed.");        // Else:
        else System.out.println("[!] Non-existent status error code.");
    }
}

