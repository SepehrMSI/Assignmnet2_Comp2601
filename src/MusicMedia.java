/**
 * abstract class used to store common fields for music media subtypes
 */

import java.util.Comparator;

/**
 * 
 * @author Bullwinkle Moose
 *
 */

public abstract class MusicMedia {

	private String sku;
	private String title;
	private String artist;
	private int year;
	public static final int CURRENT_YEAR = 2021;
	public static final int FIRST_YEAR = 1860;

	/**
	 * default constructor
	 */
	public MusicMedia() {
		super();
	}

	/**
	 * @param title  used to set the title field
	 * @param artist used to set the artist field
	 */
	public MusicMedia(String sku, String title, String artist) {
		super();

		if (!validateString(sku) || !validateString(title) || !validateString(artist)) {
			throw new IllegalArgumentException("invalid data entered");
		}
		this.sku = sku;
		this.title = title;
		this.artist = artist;
		year = CURRENT_YEAR;
	}

	public MusicMedia(String sku, String title, String artist, int year) {
		super();
		if (!validateString(sku) || !validateString(title) || !validateString(artist)) {
			throw new IllegalArgumentException("invalid data entered");
		}
		this.sku = sku;
		this.title = title;

		if (!validateString(artist) || !validateYear(year)) {
			System.out.println(artist + " " + year);

			throw new IllegalArgumentException("invalid data entered");
		}
		this.artist = artist;
		this.year = year;
	}	

	/**
	 * @return the sku
	 */
	public String getSku() {
		return sku;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {

		if (!validateYear(year)) {

			throw new IllegalArgumentException("invalid data entered");
		}

		this.year = year;
	}

	/**
	 * abstract method to be implemented by sub classes. Used to play a music media
	 * type.
	 */
	public abstract void play();

	/**
	 * @return the title as a String
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		if(!validateString(title)) {
			throw new IllegalArgumentException("invalid data entered");
		}
		
		this.title = title;
	
	}

	/**
	 * @return the artist as a String
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * @param artist the artist to set
	 */
	public void setArtist(String artist) {
		if(!validateString(artist)) {
			throw new IllegalArgumentException("invalid data entered");
		}
		
		this.artist = artist;
	}

	@Override
	public String toString() {
		return "MusicMedia [sku=" + sku + ", title=" + title + ", artist=" + artist + ", year=" + year + "]";
	}
	

	protected boolean validateString(String value) {

		if (value == null || value.isBlank()) {
			return false;
		}

		return true;
	}

	protected boolean validateInt(int value) {

		if (value < 0) {
			return false;
		}
		return true;
	}

	private boolean validateYear(int value) {

		if (value < FIRST_YEAR || value > CURRENT_YEAR) {
			return false;
		}
		return true;
	}

}
