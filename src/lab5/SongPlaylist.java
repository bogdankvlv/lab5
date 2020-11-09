
package lab5;

/**
 *
 * @author Bogdan Kovalov
 * @since 11/6/2020
 * @version 1.0
 *
 * 
 */

public class SongPlaylist {
  
    // root node of BST.
   public Song root; 
  
   public SongPlaylist() {
      
       root = null;
      
   }
   
   /**
    * Method which returns whether the BST is empty or not.
    * @return whether the BST is empty.
    */
   public boolean isEmpty() {
      
       return root == null;
      
   }
  
   /**
    * Method that adds objects into the BST.
    * @param obj 
    */
   public void insert(Song obj) {
      
       if (root == null) {
          
           root = obj;
       }
       else {
          
           Song current = root;
          
           Song parent;
          
           while (true) {
              
               parent = current;
               // if the object's songtitle eqauals the current nodes song title, reset average stream for the song
               if (obj.songTitle.compareToIgnoreCase(current.songTitle) == 0) {
                   current.setArtistAverage(obj);
                   return;
               }
               else if (obj.songTitle.compareToIgnoreCase(current.songTitle) < 0) {
                  
                   current = current.left;
                  
                   if (current == null) {
                      
                       parent.left = obj;
                       return;
                      
                   }
               }
               else {
                   current = current.right;
                  
                   if (current == null) {
                      
                       parent.right = obj;
                       return;
                      
                   }
               }
           }
       }
   }
  
  
  
   public void inorderTransversal() {
      
       inorder(root);
      
   }
   
   public void inorder(Song root) {
      
       if (root == null) {
          
           return;
          
       }
      // transverses left of root
       inorder(root.left); 
      
       // prints root
       System.out.println(root); 
      
       // transverses right of root
       inorder(root.right); 
   }
  
   /**
    * subset method that is made to print out songs within range of two values in argument. ex. subset("jingle bells", "merry christmas") only prints songs alphabetically between
    * jingle bells and merry christmas.
    * @param song1 The first song
    * @param song2 The second song
    */
  
   public void subset(String song1, String song2) {
       subset(root, song1, song2); 
   }
   public Song subset(Song root, String song1, String song2) { 
  
       if (root == null) {
           return root;
       }
      
       Song current = root;
      
       if (song1.compareTo(current.songTitle) < 0) {
           subset(current.left, song1, song2);
       }
       if ((song1.compareTo(current.songTitle) <= 0) && (song2.compareTo(current.songTitle) >= 0)) {
           System.out.println(current);
       }
       if (song2.compareTo(current.songTitle) > 0) {
           subset(current.right, song1, song2);
       }
       return root;
   }
}