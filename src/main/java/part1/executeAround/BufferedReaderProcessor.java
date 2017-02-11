package part1.executeAround;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferedReaderProcessor {

    /**
     * BufferedReader -> String function
     *
     * @param br the input argument
     * @return A String containing some content from BufferedReader
     * @throws IOException if an I/O error occurs
     */
    String process(BufferedReader br) throws IOException;

}
