package org.game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;

public class FileService {

    static Connection connection = null;
    static String url = "jdbc:mysql://localhost:3306/";
    static String username = "root";
    static String databasePassword = "password";
    private ArrayList<Password> passwords = new ArrayList<Password>();

    private String textOfFile = new String(Files.readAllBytes(Paths.get("C:\\Users\\akowalewski\\IdeaProjects\\HangmanMvn\\src\\main\\resources\\passwords.txt")));

    public FileService() throws IOException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        loadFromDatabse();
    }

    public String getTextOfFile() {
        return this.textOfFile;
    }

    public ArrayList<Password> getPasswords() {
        return this.passwords;
    }

    public void saveToDatabse(String password, Integer attemps) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
//        String myNew = "\n" + password + "-" + attemps;
//        String textOfFile = new String(Files.readAllBytes(Paths.get("C:\\Users\\akowalewski\\IdeaProjects\\HangmanMvn\\src\\main\\resources\\passwords.txt")));
//        Files.write(Paths.get("C:\\Users\\akowalewski\\IdeaProjects\\HangmanMvn\\src\\main\\resources\\passwords.txt"), myNew.getBytes(), StandardOpenOption.APPEND);

        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection(url, username, databasePassword);
        PreparedStatement ps = connection.prepareStatement("Insert into myDatabase.passwords values(?)");
        ps.setString(1, password);

        int status = ps.executeUpdate();

        if(status != 0){
            System.out.println("Succes");
        }
    }

    private void loadFromDatabse() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection(url, username, databasePassword);
        PreparedStatement ps = connection.prepareStatement("Select * from myDatabase.passwords");
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            Password loadPassword = new Password(rs.getString("name"), 11);
            passwords.add(loadPassword);

        }
    }




}
