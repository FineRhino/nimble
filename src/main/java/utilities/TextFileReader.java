package utilities;
import java.io.IOException;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Scanner;
/**
 * Created by Joseph on 5/6/2017.
 */
public class TextFileReader {

    public void readFile(String fn) {

        // This will reference one line at a time
        String line = null;
        Properties props = new Properties();

            try {
                // FileReader reads text files in the default encoding.
                FileReader fileReader =
                        new FileReader(fn);

                // Always wrap FileReader in BufferedReader.
                BufferedReader bufferedReader =
                        new BufferedReader(fileReader);

                while((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }

                // Always close files.
                bufferedReader.close();
            }
            catch(FileNotFoundException ex) {
                System.out.println(
                        "Unable to open file '" +
                                fn + "'");
            }
            catch(IOException ex) {
                System.out.println(
                        "Error reading file '"
                                + fn + "'");
                // Or we could just do this:
                // ex.printStackTrace();
            }
        }
    }
