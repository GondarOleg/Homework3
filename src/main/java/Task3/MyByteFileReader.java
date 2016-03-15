package Task3;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Oleg on 13.03.2016.
 */
public class MyByteFileReader {



    public static void main(String[] args) {


        Set<String> wordsToFind = new HashSet<String>();
        wordsToFind.add("abstract");
        wordsToFind.add("continue");
        wordsToFind.add("for");
        wordsToFind.add("new");
        wordsToFind.add("switch");
        wordsToFind.add("assert");
        wordsToFind.add("default");
        wordsToFind.add("goto");
        wordsToFind.add("package");
        wordsToFind.add("synchronized");
        wordsToFind.add("boolean");
        wordsToFind.add("do");
        wordsToFind.add("if");
        wordsToFind.add("private");
        wordsToFind.add("this");
        wordsToFind.add("break");
        wordsToFind.add("double");
        wordsToFind.add("implements");
        wordsToFind.add("protected");
        wordsToFind.add("throw");
        wordsToFind.add("byte");
        wordsToFind.add("else");
        wordsToFind.add("import");
        wordsToFind.add("public");
        wordsToFind.add("throws");
        wordsToFind.add("case");
        wordsToFind.add("enum");
        wordsToFind.add("instanceof");
        wordsToFind.add("return");
        wordsToFind.add("transient");
        wordsToFind.add("catch");
        wordsToFind.add("extends");
        wordsToFind.add("int");
        wordsToFind.add("short");
        wordsToFind.add("try");
        wordsToFind.add("char");
        wordsToFind.add("final");
        wordsToFind.add("interface");
        wordsToFind.add("static");
        wordsToFind.add("void");
        wordsToFind.add("class");
        wordsToFind.add("finally");
        wordsToFind.add("long");
        wordsToFind.add("strictfp");
        wordsToFind.add("volatile");
        wordsToFind.add("const");
        wordsToFind.add("float");
        wordsToFind.add("native");
        wordsToFind.add("super");
        wordsToFind.add("while");
        wordsToFind.add("const");
        wordsToFind.add("and");
        wordsToFind.add("goto");

        FileInputStream fis = null;
        try {
            fis = new FileInputStream("C:\\homework\\test\\RailwayStation.java");


            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            String line = null;
            try {


                FileOutputStream fos = new FileOutputStream("c:/homework/test/wordsinfileByte.txt");
                //StringBuilder outputStrinBuilder = new StringBuilder();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8"));
                String s;

                for (String string :
                        wordsToFind) {



                    int count = 0;
                    while (bufferedReader.readLine() != null) {

                        if (bufferedReader.readLine().contains(string)) {
                            count++;
                        }
                       // bufferedReader.




                    }


                    if (count > 0) {

                        bufferedWriter.write(string + " find " + count + " times\n");

                        bufferedWriter.flush();
                    }


                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}




