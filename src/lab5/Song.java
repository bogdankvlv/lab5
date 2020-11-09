package lab5;

/**
 *
 * @author Bogdan Kovalov
 * @since 11/6/2020
 * @version 1.0
 *
 */
public class Song implements Comparable<Song> {

    
    //Declaration of variables
    
    public String songTitle;
    public int streamCount;
    public String artistName;
    public int artistAverage;
    public Song left;
    public Song right;

    
    /**
     * Empty Constructor method
     */

    public Song() {
        this.songTitle = null;
        this.streamCount = 0;
        this.artistName = null;
        this.artistAverage = 0;
        left = null;
        right = null;
    }

   /**
    * Constructor method that passes on three variables.
    * @param songTitle The song name
    * @param artistName The artist name
    * @param streamCount Number of times that the song was played.
    */

    public Song(String songTitle, String artistName, int streamCount) {
        this.songTitle = songTitle;
        this.streamCount = streamCount;
        this.artistName = artistName;
        this.artistAverage = streamCount;
        left = null;
        right = null;
    }

    /**
     * Setter method that sets the song title.
     * @param songTitle The name of the song
     */
    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    /**
     * Getter method that returns the song title.
     * @return The song title
     */
    public String getSongTitle() {
        return this.songTitle;
    }

    /**
     * Setter method that sets the stream count
     * @param streams The amount of times the song was streamed.
     */
    public void setStreamCount(int streams) {
        this.streamCount = streams;
    }

   /**
    * Getter method that returns the stream count
    * @return The stream count
    */
    public int getStreamCount() {
        return this.streamCount;
    }

   
   /**
    * Setter method that sets the artist name
    * @param name The name of the artist.
    */
    public void setArtistName(String name) {
        this.artistName = name;
    }

    /**
     * Getter method that returns the artist name
     * @return The name of the artist.
     */
    public String getArtistName() {
        return this.artistName;
    }

    /**
     * Setter method that sets the artist Average.
     * @param obj The song objects.
     */
    public void setArtistAverage(Song obj) {
        this.artistAverage = (this.streamCount + obj.streamCount) / 2;
    }

    
    public int compareTo(Song obj) {
        return this.songTitle.compareToIgnoreCase(obj.songTitle);
    }

    /**
     * To String method that returns a string.
     * @return A string.
     */
    public String toString() {
        return this.songTitle + " by " + this.artistName + " has streamed " + this.streamCount + " times and streamed on average " + this.artistAverage + " times";
    }
}
