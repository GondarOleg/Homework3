package Task1;

import java.io.File;

/**
 * Created by Oleg on 12.03.2016.
 */


public class DirectoryViewer {


    public static void showOnlyFiles(String path){
        File[] files = getDirectoryElements(path);
        for (File f : files){
            System.out.print( !(f.isDirectory())
                                    ? f.getName() + "\n"
                                    : "");
        }
    }

    public static void showOnlySelectedDirectory(String path){

        File[] files = getDirectoryElements(path);
        for (File f : files){
            System.out.println(f.getName());
        }

    }

    public static void showAllSubdirectories(String path){
        System.out.println(path);
        recursiveListDir(path, "|_");
    }

    private static void recursiveListDir(String path, String token){

        File[] files = getDirectoryElements(path);

        token = "|_  " + token;
        for (int i = 0; i < files.length; i++){

            System.out.println(token + files[i].getName());
            if (files[i].isDirectory()){
                recursiveListDir(path+"\\"+files[i].getName()+"\\", token);
            }

        }

    }

    private static File[] getDirectoryElements(String path){

        File f1 = new File(path);
        return f1.listFiles();

    }

}


