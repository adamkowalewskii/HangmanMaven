package org.game;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PasswordService {
    private String password;
    private int attemps;

    private ArrayList<Password> passwords = new ArrayList<Password>();



    PasswordService() throws IOException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        FileService fileService = new FileService();
        this.passwords = fileService.getLoadPasswords();

    }

    public ArrayList<Password> getPasswords() {
        return this.passwords;
    }

    public Password getRandomPassword() {
        Random rand = new Random();
        int idx = rand.nextInt(passwords.size());

        return passwords.get(idx);
    }

    public void aksInTerminalAndAdd() throws IOException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj hasło, które ma zostać dodane: ");
        password = scanner.nextLine();
        password = password.toLowerCase();
        System.out.println("Podaj liczbę prób jaką użytkownik ma na zgadnięcie tego hasła(max liczba to 11 inaczej było by za łatwo ;): ");
        attemps = scanner.nextInt();

        boolean flag = true;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLetter(password.charAt(i)) == false) {
                if (password.charAt(i) == ' ') {
                } else {
                    flag = false;
                }
            }
        }

        if (!flag) {
            System.out.println("Podane hasło zawiera cyfrę lub inny znak nie będący literą. Podaj nowe poprawne hasło!");
            PasswordService passwordService = new PasswordService();
        } else if (attemps > 11) {
            System.out.println("Podana liczba jest większ niż 11, spróbuj ponownie!");
            PasswordService passwordService = new PasswordService();

        } else {
            FileService fileService = new FileService();
            fileService.saveToDatabse(password, attemps);
        }

    }
}
