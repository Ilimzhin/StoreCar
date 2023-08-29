package auth;

import java.util.Scanner;

public class RegAndLogin {

    Scanner sc = new Scanner(System.in);

    public void registrationAndLogin() {

        boolean isActive = true;
        String logPasTry = "";
        System.out.println("Регистрация");
        System.out.println("Придумайте логин");
        String regLoginNow = sc.nextLine();

        logPasTry += regLoginNow;
        while (isActive) {
            String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
            System.out.println("Придумайте пароль");
            String regPasswordNow = sc.nextLine();
            if (regPasswordNow.matches(pattern)) {
                logPasTry += regPasswordNow;
                break;
            }
            System.out.println("В пароле  должна быть одна заглавная буква, одна маленькая буква, одна цифра и один спецсимвол минимум 8 символов ");
        }
        //

        int logPasTryNum = 1;
        while (isActive) {
            if (logPasTryNum < 4) {
                System.out.println("У вас есть " + logPasTryNum + " из 3");
                System.out.println("Введите логин");
                String loginNow = sc.next();
                System.out.println("Введите пароль");
                String passwordNow = sc.next();
                if (logPasTry.contains(loginNow) && logPasTry.contains(passwordNow)) {
                    System.out.println("Вы успешно зашли");
                    break;
                }
            } else {
                System.out.println("Вы не правильно ввели логин или пароль");
                System.exit(0);
            }
            logPasTryNum++;
        }
    }
}
