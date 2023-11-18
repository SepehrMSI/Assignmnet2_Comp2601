

import java.util.Objects;

public class CompactDisc extends PhysicalMedia {

	private int numberOfTracks;

	/**
	 * 
	 */
	public CompactDisc() {
		super();

	}

	/**
	 * @param title
	 * @param artist
	 */
	public CompactDisc(String sku, String title, String artist, int year, int numberOfTracks) {
		super(sku, title, artist, year);

		setNumberOfTracks(numberOfTracks);

	}

	/**
	 * @return the numberOfTracks
	 */
	public int getNumberOfTracks() {
		return numberOfTracks;
	}

	/**
	 * @param numberOfTracks the numberOfTracks to set
	 */
	public void setNumberOfTracks(int numberOfTracks) {

		if (numberOfTracks < 1) {

			throw new IllegalArgumentException("invlaid number of trakcs entered");
		}
		this.numberOfTracks = numberOfTracks;
	}

	@Override
	public void play() {

		System.out.println("Playing the " + getTitle() + " compact disc");

	}

	@Override
	public String toString() {
		return "CompactDisc [numberOfTracks=" + numberOfTracks + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(numberOfTracks);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompactDisc other = (CompactDisc) obj;
		return numberOfTracks == other.numberOfTracks;
	}

	
	

}
