package ie.atu.sw;

import java.util.*;
import java.io.*;
public class Indexer{

    //Intialise variables
    private Map<String,WordDetail> idx = new HashMap<>(); //Creating a Map interface to get a string of words with List
    private Settings parser;
    private IndexFileWriter writer;

    private WordDetail wordDetail;

    /**
     * Method to take in the file from Parser and to output in a file as a String
     * idx Creating a Map interface to get a string of words with List
     * parser set to parser same as that is in Settings
     * writer is set to File write an output file
     * @param parser
     * @param outputFile
     */
    public Indexer(Settings parser, String outputFile) {
        idx = new HashMap<>();
        this.parser = parser;
        writer = new IndexFileWriter(outputFile);
    }

    public void addToIndex(String word, int page){
        //Replace and trim any words found in the input file and only have uppercase A-Z, lowercase a-z and 0-9, everything else replace with " "
        String wordClean = word.trim().toLowerCase().replaceAll("[^A-Za-z0-9]", " ");
        //If the file contains any stop words or the dictionary does not have the word do not process
        if (parser.checkStopWords(wordClean) || (parser.searchDictionary(wordClean) == null))
            return;
//idx does not contain the word
        if (!idx.containsKey(word)) {
            wordDetail = new WordDetail(page, parser.searchDictionary(wordClean));
            idx.put(word, wordDetail);
        }

        wordDetail = new WordDetail(idx.get(word));
        wordDetail.add(page);
        idx.put(word, wordDetail);
    }

    /**
     * printIndex - print out the String (word in the book) and the Worddetail of the
     * selected word from the dictionaary
     */
    public void printIndex(){
        for (Map.Entry<String, WordDetail> entry : idx.entrySet()) {
            System.out.println("index "+entry.getKey() + ": " + entry.getValue());
            System.out.println();
        }
    }



}


