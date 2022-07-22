package org.game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class FileService {
    private ArrayList<Password> passwords = new ArrayList<Password>();

    private String textOfFile = new String(Files.readAllBytes(Paths.get("C:\\Users\\akowalewski\\IdeaProjects\\HangmanMvn\\src\\main\\resources\\passwords.txt")));

    public FileService() throws IOException {
        fromTextToArrays();
    }

    public String getTextOfFile() {
        return this.textOfFile;
    }

    public ArrayList<Password> getPasswords() {
        return this.passwords;
    }

    public void saveToFile(String password, Integer attemps) throws IOException {
        String myNew = "\n" + password + "-" + attemps;
        String textOfFile = new String(Files.readAllBytes(Paths.get("C:\\Users\\akowalewski\\IdeaProjects\\HangmanMvn\\src\\main\\resources\\passwords.txt")));
        Files.write(Paths.get("C:\\Users\\akowalewski\\IdeaProjects\\HangmanMvn\\src\\main\\resources\\passwords.txt"), myNew.getBytes(), StandardOpenOption.APPEND);
    }

    private void fromTextToArrays() {
        String[] arr = this.textOfFile.split("\n");
        String[][] both = new String[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            both[i] = arr[i].split("-");

        }

        for (int i = 0; i < both.length; i++) {
            passwords.add(new Password(both[i][0], Integer.valueOf(both[i][1])));

        }

    }




}
