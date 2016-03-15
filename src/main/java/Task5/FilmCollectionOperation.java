package Task5;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Oleg on 14.03.2016.
 */
public class FilmCollectionOperation {

    public static void main(String[] args) {

        FilmCollection collection = new FilmCollection();
        fillCollection(collection);
        serializeCollection(collection);
        collection = deserializeCollection("c:/homework/test/serialize.ser");
        System.out.println("___________________________________________________");

        Set<Actor> actors1 = new HashSet<Actor>();
        actors1.add(new Actor("Test", "Test"));
        actors1.add(new Actor("Test1", "Test1"));
        actors1.add(new Actor("Test2", "Test2"));


        collection.addFilmToCollection(new Film("test3", actors1));

        serializeCollection(collection);

        FilmCollection collection1 = deserializeCollection("c:/homework/test/serialize.ser");
        collection1.showFilmsInCollection();
        collection.removeFilmFromCollection("test");
        serializeCollection(collection);
        collection1 = null;
        collection1 = deserializeCollection("c:/homework/test/serialize.ser");
        System.out.println("_____________Deleted one film__________");
        collection1.showFilmsInCollection();
    }

    public static void serializeCollection(FilmCollection f){
        FileOutputStream fo = null;
        try {
            fo = new FileOutputStream("c:/homework/test/serialize.ser");
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(f);
            oo.close();
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static FilmCollection deserializeCollection(String path) {
        FilmCollection coll = null;
        try {
            FileInputStream fi = new FileInputStream(path);
            ObjectInputStream oi = new ObjectInputStream(fi);
            coll = (FilmCollection) oi.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return coll;
    }

        public void showFilmCollection(FilmCollection filmCollection) {
            for (Film f : filmCollection.getFilmsSet()) {
                f.showAll();
            }
        }



    public static void fillCollection(FilmCollection filmCollection){
        Set<Actor> actors = new HashSet<Actor>();
        actors.add(new Actor("Test", "Test"));
        actors.add(new Actor("Test1", "Test1"));
        actors.add(new Actor("Test2", "Test2"));

        filmCollection.addFilmToCollection(new Film("test", actors));
        filmCollection.addFilmToCollection(new Film("test1", actors));

    }

}
