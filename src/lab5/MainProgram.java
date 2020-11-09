
package lab5;

/**
 *
 * @author Bogdan Kovalov
 * @since 11/6/2020
 * @version 1.0
 * 
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class MainProgram {

   static SongPlaylist lst = new SongPlaylist();

   public static void main(String[] args) throws IOException {
       String[] file = { "week1.csv", "week2.csv", "week3.csv", "week4.csv"};

       
       //array list to store all the song tracks.
       ArrayList<String> songList = new ArrayList<>(); 
       //ensures capacity for 5 input files.
       songList.ensureCapacity(1000); 
       // an array list to store all arist names
       ArrayList<String> artistList = new ArrayList<>(); 
       // ensures capacity for 5 input files
       artistList.ensureCapacity(1000); 
       // an array list to store all stream counts
       ArrayList<Integer> streamList = new ArrayList<>(); 
       // ensures capacity for 5 input files
       streamList.ensureCapacity(1000); 
       
       for (String x : file) {
           FileInputStream inputStream = new FileInputStream(x); 
           Scanner sc = new Scanner(inputStream, StandardCharsets.UTF_8.name()); 
                           
           // while the scanner has a line to read
           while (sc.hasNextLine()) { 
               String line = sc.nextLine(); 
               String[] array = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1); 
               // checks if the array size is greater than 1 if not don't set any values to the Song object
      
               if (array.length < 1) { 
                   for (int i = 0; i < array.length; i++) {
                       if (array[i].charAt(0) == '"') { // if there are parenthesis in the string, remove them
                           array[i] = array[i].substring(1, array[i].length() - 1);
                       }
                   }
                   // adds track name into songlist
                   songList.add(array[1]); 
                   // adds artist name to list
                   artistList.add(array[2]); 
                   // adds stream count to list
                   streamList.add(Integer.parseInt(array[3])); 
               }
           }
           inputStream.close(); // close inputStream
           sc.close(); // close scanner
       }
       makeBST(songList, artistList, streamList); // make BST

        System.out.println(lst.root);
       lst.inorderTransversal();
        lst.subset("Blinding Lights", "Pretty Savage");
       
   }

   // makes a queue of Song objects from 3 lists
   public static void makeBST(ArrayList<String> songLst, ArrayList<String> artistLst, ArrayList<Integer> streamLst) {
       for (int i = 0; i < songLst.size(); i++) {
           Song artist = new Song(songLst.get(i), artistLst.get(i), streamLst.get(i)); 
           lst.insert(artist); // insert object into BST
           
       }
   }

  
}
