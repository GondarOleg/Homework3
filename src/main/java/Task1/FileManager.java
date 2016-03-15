package Task1;

import java.io.IOException;

/**
 * Created by Oleg on 14.03.2016.
 */
public class FileManager {

    public static void main(String[] args) {


        DirectoryViewer.showAllSubdirectories("c:/homework/GondarHomework1.2/");
        DirectoryViewer.showOnlyFiles("c:/homework/GondarHomework1.2/");
        DirectoryViewer.showOnlySelectedDirectory("c:/homework/GondarHomework1.2/");


        FileManipulator fileManipulator = new FileManipulator("c:/homework/test/test1.txt");
        try {
            fileManipulator.writeFile("testString1\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileManipulator.appendFile("testString2");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileManipulator.showFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileManipulator.deleteFile();


    }


}
