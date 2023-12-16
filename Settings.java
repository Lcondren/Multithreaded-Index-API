package ie.atu.sw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class Settings implements Parser {


    private Set<String> stopwords = new ConcurrentSkipListSet<>();

    private Map<String, String> dictionary = new ConcurrentSkipListMap<>();
    private StringBuffer tempDefinition;

    /**
     * Takes the method from the Parser class
     * Implements the method parseFile
     * @param filepath
     * @throws IOException
     */
    @Override
    public void parseFile(String filepath) throws IOException {
        dictionary = new ConcurrentHashMap<>();
        Files.lines(Path.of(filepath))
                .forEach(line -> Thread.startVirtualThread(() -> processLine(line))
                );
    }

    /**
     * Processes the text line by line
     * Given the text in the console, it processes it line by line in the console
     * @param line
     */
    public void processLine(String line){

        add(line);
    }

    /**
     * For every line of the file
     * @param line
     */
    public void add(String line){
        String[] tempArray = line.split(",");
        //Word in the text file will be first in the Array.
        // Ensure that words only include [^a-zA-Z0-9] otherwise be replaced with ""
        String word = tempArray[0].toLowerCase().trim().replaceAll("[^a-zA-Z0-9]", "");
        //The definition of the word will be the second in the Array
        String def = tempArray[1];
        //From Dictionary put the definition next to the word
        dictionary.put(word, def);
    }

    /**
     * parserStopWords takes in the words from the google text file
     * adds them to the stopwords using Virtual Threads
     * When programme is run the words do not get used in the output
     * @param filepath
     * @throws IOException
     */
    public void parseStopWords(String filepath) throws IOException{
        stopwords = new ConcurrentSkipListSet<>();
        Files.lines(Path.of(filepath))
                .forEach(line -> Thread.startVirtualThread(() -> stopwords.add(line))
                );
    }

    /**
     * Check for true or false for any stopwords
     * Any words that appear in the Google-1000 text file, will not process in the text file that is being parsed
     * with th Dictionary
     * @param word for each word in the text
     * @return the meaning of that word from the text
     */
    public boolean checkStopWords(String word){

        return stopwords.contains(word);
    }

    public String searchDictionary(String word) {
        tempDefinition = new StringBuffer();
        //If dictionary contains the word then return the word plus the definition in the dictionary of that word
        //Run time for this is 0(n) where n = numbers of words in the dictionary
        if (dictionary.containsKey(word)){
            return tempDefinition.append(word+ ", "+dictionary.get(word)).toString();
            //Otherwise if it does not contain the word don't do anything just return null
        }return null;
    }

}


