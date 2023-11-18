/**
 * sub class of MusicMedia to hold fields distinct to audio music files
 */



/**
 * An Audio File.
 * 
 * @author Bullwinkle Moose
 *
 */
public class AudioFile extends DigitalMedia {

	private String fileName;
	private int fileResolution;

	/**
	 * Default constructor
	 */
	public AudioFile() {
		super();
	}

	/**
	 * Constructor allowing all the attributes to be set.
	 * 
	 * @param title    the title to set
	 * @param artist   the artist to set
	 * @param fileName the filename to set
	 * @param fileResolution the size of the file
	 */
	public AudioFile(String sku, String title, String artist, int year, String fileName, int fileResolution) {
		super(sku, title, artist, year);
		if(!validateString(fileName) || !validateInt(fileResolution)) {
			throw new IllegalArgumentException("invalid data entered");
		}
		this.fileName = fileName;
		this.fileResolution = fileResolution;
	}

	public AudioFile(String sku, String title, String artist, int year, String fileName) {
		super(sku, title, artist, year);
		if(!validateString(fileName)) {
			throw new IllegalArgumentException("invalid data entered");
		}
		this.fileName = fileName;
	}

	/**
	 * Get the filename.
	 * 
	 * @return the fileName as a String
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Set the filename.
	 * 
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		if(!validateString(fileName)) {
			throw new IllegalArgumentException("invalid data entered");
		}
		this.fileName = fileName;

	}

	/**
	 * Get the file size.
	 * 
	 * @return the fileSize as a double
	 */
	public double getFileResolution() {
		return fileResolution;
	}

	/**
	 * Set the file size.
	 * 
	 * @param fileSize the fileSize to set
	 */
	public void setFileResolution(int fileResolution) {
		if(!validateInt(fileResolution)) {
			throw new IllegalArgumentException("invalid data entered");
		}
		this.fileResolution = fileResolution;
	}

	/**
	 * Plays an audio file. For now, it needs only to output a message to the
	 * console indicating that the audio file is being played.
	 */
	@Override
	public void play() {
		System.out.println("Playing \"" + fileName + "\".");
	}

	/**
	 * Saves a file to the hard disk. For now, it needs only to output a message to
	 * the console indicating that the audio file is being saved.
	 */
	@Override
	public void save(String path) {
		System.out.println("Saving \"" + fileName + "\" to \"" + path + "\" folder.");
	}

	/**
	 * Deletes a file from the hard disk. For now, it needs only to output a message
	 * to the console indicating that the audio file is being deleted.
	 */
	@Override
	public void delete(String path) {
		System.out.println("Deleting \"" + fileName + "\" from \"" + path + "\" folder.");
	}

	@Override
	public String toString() {
		return "AudioFile [fileName=" + fileName + ", fileResolution=" + fileResolution + ", toString()="
				+ super.toString() + "]";
	}
	
}
