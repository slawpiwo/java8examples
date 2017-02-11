package part1.executeAround;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Java6Assertions.assertThat;


public class FileProcessorTest {

    private FileProcessor processor = new FileProcessor();

    @Test
    public void shouldGetOneLineFromFile() throws IOException {
        //when
        String line = processor.processFile((BufferedReader br) -> br.readLine(), "src/test/resources/data.txt");

        //then
        assertThat(line).isEqualTo("Execute around pattern");
    }

    @Test
    public void shouldThrowFileNotFoundException() throws IOException {
        //when and then
        assertThatThrownBy(
                () -> processor.processFile((BufferedReader br) -> br.readLine(), "src/test/resources/bad.txt"))
                .isExactlyInstanceOf(FileNotFoundException.class);
    }

}
