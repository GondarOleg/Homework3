package Task4;

import java.io.*;
import java.util.*;

/**
 * Created by Oleg on 14.03.2016.
 */
public class MyFileReader {

    private Set<String> reservedWords = new HashSet<String>();

    public static void main(String[] args) {

        MyFileReader myFileReader = new MyFileReader();
        myFileReader.checkFileForReservedWords();
    }

    public void getReserverWords() {

        try {
            FileReader fileReader = new FileReader("c:/homework/test/words.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                this.reservedWords.add(string);

            }
            bufferedReader.close();
            fileReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void checkFileForReservedWords() {

        this.getReserverWords();

        Map<String, Integer> wordsCounter = new HashMap<String, Integer>();

        FileReader fileReader = null;
        try {
            fileReader = new FileReader("c:/homework/test/words.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String string;

            FileWriter fileWriter = new FileWriter("c:/homework/test/wordsinfile1.txt");

            while ((string = bufferedReader.readLine()) != null
                    && string != " ") {

                FileReader fileReader1 = new FileReader("C:\\homework\\test\\RailwayStation.java");


                Scanner scanner = new Scanner(fileReader1);

                int count = 0;
                while (scanner.hasNextLine()) {

                    if (scanner.findInLine(string) != null) {
                        count++;
                    }
                    scanner.nextLine();

                }


                if (count > 0) {

                    fileWriter.write(string + " find " + count + " times\n");
                    fileWriter.flush();
                }
                fileReader1.close();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}