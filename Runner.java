package ie.atu.sw;

import java.io.*;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;
import java.nio.file.Files;

public class Runner {

    /**
     * Starts the main menu from the Menu Class
     * Using Hashmap gets the word of the book and word in the dictionary associated with it
     * @param args passes in arguments of the words from book and dictionary
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
    HashMap<String, String> map = new HashMap<>();
    Menu m = new Menu();
    m.startMainMenu();

    }
}
