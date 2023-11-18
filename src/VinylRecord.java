public class VinylRecord extends PhysicalMedia {

	private int numberOfTracks;
	private int size;
	private int weightInGrams;

	private final int SINGLE_SIZE;
	private final int EP_SIZE;
	private final int LP_SIZE;

	private final int SINGLE_WEIGHT;
	private final int EP_WEIGHT;
	private final int LP_WEIGHT;
	
	private static final int DEFAULT_SIZE = 7;
	private static final int DEFAULT_WEIGHT = 40;
	private static final int DEFAULT_TRACK_NUMBER = 2;
	private static final int CURRENT_YEAR = 2022;

	{
		SINGLE_SIZE = DEFAULT_SIZE;
		EP_SIZE = 10;
		LP_SIZE = 12;

		SINGLE_WEIGHT = DEFAULT_WEIGHT;
		EP_WEIGHT = 100;
		LP_WEIGHT = 180;
	}

	public VinylRecord() {
		super();

	}
	
	public VinylRecord(String sku, String title, String artist) {
		this(sku, title, artist, CURRENT_YEAR, DEFAULT_TRACK_NUMBER, DEFAULT_SIZE, DEFAULT_WEIGHT);
	}

	public VinylRecord(String sku, String title, String artist, int year, int numberOfTracks, int size, int weightInGrams) {
		super(sku, title, artist, year);
		setNumberOfTracks(numberOfTracks);
		setSize(size);
		setWeightInGrams(weightInGrams);
	}

	public int getNumberOfTracks() {
		return numberOfTracks;
	}

	public void setNumberOfTracks(int numberOfTracks) {

		if (numberOfTracks < 1) {

			throw new IllegalArgumentException("invlaid number of trakcs entered");
		}
		this.numberOfTracks = numberOfTracks;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		
		if (size == SINGLE_SIZE || size == EP_SIZE || size == LP_SIZE) {
			this.size = size;
		} else {
			throw new IllegalArgumentException("Record size is invalid");
		}
	}

	public int getWeightInGrams() {
		return weightInGrams;
	}

	public void setWeightInGrams(int weightInGrams) {

		if (size == SINGLE_SIZE && weightInGrams == SINGLE_WEIGHT) {
			this.weightInGrams = weightInGrams;
		} else if (size == EP_SIZE && weightInGrams == EP_WEIGHT) {
			this.weightInGrams = weightInGrams;
		} else if (size == LP_SIZE && weightInGrams == LP_WEIGHT) {
			this.weightInGrams = weightInGrams;
		} else {
			throw new IllegalArgumentException("Record weight is invalid");
		}
	}

	@Override
	public String toString() {
		return "VinylRecord [numberOfTracks=" + numberOfTracks + ", size=" + size + ", weightInGrams=" + weightInGrams
				+ ", toString()=" + super.toString() + "]";
	}

	@Override
	public void play() {
		System.out.println("Playing a vinyl record");

	}

}
