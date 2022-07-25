package org.game;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Menu {
    Main() throws IOException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        super();
    }

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Menu menu = new Menu();
        while (true) {
            Menu AgainMenu = new Menu(false);
        }
    }
}