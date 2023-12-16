package ie.atu.sw;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import java.util.Map;

/**
 * This class is writing the Index of the file
 * to an output file
 */
public class IndexFileWriter {

    private String outputFile = null;

    /**
     * Writes an Indexer File to an outputfile
     * @param outputFile
     */
    public IndexFileWriter(String outputFile) {
        this.outputFile = outputFile;
    }

    /**
     * Saves the name of the file as a String with mapping as Word(String) and WordDetail(which is the meaning of the word)
     * Writes to a file using a map with String and the Word Detail, it will produce the word (entry) and the meaning (entrySet())
     * @param map String, Word Detail
     * @param fileName name of the file specified
     */
    public static void save(HashMap<String, WordDetail> map, String fileName) {
        try {
            FileWriter fw = new FileWriter(fileName);
            //Iterite through the words and their meanings from the Dictionary
            for (Map.Entry<String, WordDetail> entry : map.entrySet()) {
                fw.write(entry.getKey() + "," + entry.getValue() + "\n");
            }
            //Close FileWriter so that there is no leaks
            fw.close();
            //Any exceptions, they will be caught here and will print out the Stack Trace
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}