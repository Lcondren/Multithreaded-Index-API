package ie.atu.sw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static java.nio.file.Path.of;

/**
 * TextFileParser implements Parser
 * All methods used in Parser are to be implemented in TextFileParser
 * @Override methods are implemented in the class TextFileParser
 */
public class TextFileParser implements Parser{
    //Initialise variables in the class
    private int page = 1;
    private int lineNumber = 0;
    private int wordCount = 0;
    private Indexer indexer;

    public TextFileParser(Settings parser, String outputFile) {

        indexer = new Indexer(parser, outputFile);
    }

    /**
     * This parses the file on the input and processes it line by line
     * Gets the file from the specified path and goes through it line by line
     * @param file
     * @throws IOException
     */
    public void parseFile(String file) throws IOException{
        Files.lines(Path.of(file))
                .forEach(line -> processLine(line));
        print();

    }

    /**
     * Implements the method that is from Parser
     * @param line
     */
    @Override
    public void processLine(String line) {
        //line number is 40 lines long, after 40 lines move on to the next page
        if (lineNumber % 40 == 0)page++;
        Arrays.stream(line.split("\\s+")).forEach(w -> add(w));
        lineNumber++;
    }

    /**
     * Method adds the word to the index
     * This gives the word and the page that the word is on the E-Book
     * @param word
     */
    public void add(String word){
        indexer.addToIndex(word,page);
    }

    /**
     * Method prints the index to console
     */
    public void print(){
        indexer.printIndex();
    }
}
