package ie.atu.sw;

import java.io.IOException;

public interface Parser {
    /**
     * The interface Parser is an <b>abstraction</b>
     * Interfaces are completely declarative. They
     * specify what an <i>implementing</i> class should do, but not how
     * it does it. Any class that declares the implements
     * must implement all its methods
     */

    /**
     * Parses a file from the filepath selected
     * @param filepath
     * @throws IOException
     */
    public void parseFile(String filepath) throws IOException;

    /**
     * Processes line from the file selected
     * @param line
     */
    public void processLine(String line);

    /**
     * Adds an input
     * @param input
     */
    public void add(String input);
}
