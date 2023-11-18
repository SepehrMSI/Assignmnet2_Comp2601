public abstract class DigitalMedia extends MusicMedia implements FileProcessor {
	
	private String filePath;
	
	public DigitalMedia() {}
	
	public DigitalMedia(String sku, String title, String artist, int year) {
		
		super(sku, title, artist, year);
	}
	
	@Override
	public void save(String filePath) {
		if (filePath == null || filePath.isEmpty()) {

			throw new IllegalArgumentException("invalid filePath entered");
		}
		
		this.filePath = filePath;
		System.out.println("Saving the audio file");

	}

	@Override
	public void delete(String filePath) {
		
		if (filePath == null || filePath.isEmpty()) {

			throw new IllegalArgumentException("invalid filePath entered");
		}
		
		System.out.println("Deleting the audio file");
	}

	@Override
	public String toString() {
		return "DigitalMedia [filePath=" + filePath + ", toString()=" + super.toString() + "]";
	}
	

}
