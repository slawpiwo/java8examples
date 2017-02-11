package part1.executeAround;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {

    public String processFile(BufferedReaderProcessor processor, String filePath) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            return processor.process(bufferedReader);
        }
    }
}
