package ie.atu.sw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Menu {
    //Initialise variables
    private Scanner s;
    private Settings parser;
    private String textFilePath;
    private Map<String, String> dictionary = new HashMap<>();
    private String outputFile;
    private Parser textFileParser;

    /**
     * Takes in the parameters
     * s - Scanner for the user to input into the system
     * Settings is initiated in Menu so that methods are used in this class
     * @throws Exception
     */
    public Menu() throws Exception {
        super();
        s = new Scanner(System.in);
        parser = new Settings();

    }

    /**
     * Switch statements on which number is pressed by the user will determine the outcome from the menu
     * When the menu is run in Runner the options 1-6 below are used to determine the outcome on menu
     * @throws Exception
     */
    public void startMainMenu() throws Exception {
        while (true) {
           MenuTemplate.showMainMenu();
            int choice = Integer.parseInt(s.nextLine());
            switch (choice) {
                case 1 -> processFile("text file");
                case 2 -> processFile("dictionary");
                case 3 -> processFile("google-1000");
                case 4 -> processFile("output file");
                case 5 -> execute();
                case 6 -> System.exit(0);

            }
        }
    }
    //Method to process files when you use text file, dictionary, common words and output file
    private String processFile(String type) throws Exception{
        System.out.print("Specify " +type+" path");
        String filePath = s.nextLine();
        switch (type) {
            case "text file" ->this.textFilePath = filePath;
            case "dictionary" -> parser.parseFile(filePath);
            case "google-1000" -> parser.parseStopWords(filePath);
            case "output file" -> this.outputFile = filePath;
        }
        return filePath;
    }
    //Create a method for execute to parse the textfiles and output to the API

    /**
     * Executes the programme when all input files have been selected
     * calls the parser method and produces an output
     * @throws Exception
     */
    public void execute() throws Exception{
        textFileParser = new TextFileParser(parser, outputFile);
        textFileParser.parseFile(textFilePath);

    }


}



