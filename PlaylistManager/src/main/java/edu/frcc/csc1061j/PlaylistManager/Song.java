package edu.frcc.csc1061j.PlaylistManager;

/**
 * 
 * Class song
 * Stores the artist name and song title
 *   
 * @author Hridaya Bijayananda
 *
 */
public class Song 
{

	private String artistName; // The artist's name
	private String songTitle; // The song's title
	
	/**
	 * Default constructor 
	 * @paramartistName The artist's name
	 * @paramsongTitle The song's title
	 */
	public Song(String artistName, String songTitle)
	{
		this.artistName = artistName;
		this.songTitle = songTitle;
	} // end of default constructor

	/**
	 * Auto-generated getter for artist's name
	 * @return Artist's name
	 */
	public String getArtistName() 
	{
		return artistName;
	}

	/**
	 * Auto-generated setter for artist's name
	 * @paramartistName The artist's name
	 */
	public void setArtistName(String artistName) 
	{
		this.artistName = artistName;
	}

	/**
	 * Auto-generated getter for song's title
	 * @return Song's title
	 */
	public String getSongTitle() 
	{
		return songTitle;
	}

	/**
	 * Auto-generated setter for song's title
	 * @paramsongTitle
	 */
	public void setSongTitle(String songTitle) 
	{
		this.songTitle = songTitle;
	}
	// end of getters and setters

	/**
	 * Auto-generated to-String method
	 * @return The the artist's name and the song title
	 */
	@Override
	public String toString() 
	{
		return "Song: \n" + "Artist name: " + getArtistName() + ", Song title: " + getSongTitle() + "\n" + getArtistName() + " - " + getSongTitle();
	} // end of to-String method
	
} // end of class Song
