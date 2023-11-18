import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;

public class Assignment2 {

	public static MusicLibrary library;

	
	static
	{
		library = new MusicLibrary();
	}

	public static void main(String[] args) {

		Assignment2 a1 = new Assignment2();
		System.out.println("DEBUG: Library Contents");
		a1.readFile();
		a1.loadFrame();
		
		library.sortByType();
        System.out.println();

//        library.sortByArtist();
//        System.out.println();
//
//        library.sortByTitle();
//        System.out.println();
//
//        library.sortByYear();
//		
		
		
//	    System.out.println("\nDEBUG: Library Contents (After Sorting by Title)");
//	    a1.sortByTitle();
//	    
//	    System.out.println("\nDEBUG: Library Contents (After Sorting by Artist)");
//	    a1.sortByArtist();
//	    
//	    System.out.println("\nDEBUG: Library Contents (After Sorting by Year)");
//	    a1.sortByYear();
//	    
//
//	    System.out.println("\nDEBUG: TYPE");
//	    a1.sortByType();

	}

	private void readFile() {

		try (FileReader reader = new FileReader("music_data.txt");) {

			Scanner scanner = new Scanner(reader);
			String prefix = null;
			while (scanner.hasNextLine()) {
				String oneLine = scanner.nextLine();
				// System.out.println(oneLine);
				String[] data = oneLine.split("\\|");
				prefix = oneLine.substring(0, 2);

				switch (prefix) {
				case "vr":
					library.addMusic(new VinylRecord(data[0], data[1], data[2], Integer.parseInt(data[3]),
							Integer.parseInt(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6])));
					break;

				case "af":
					library.addMusic(new AudioFile(data[0], data[1], data[2], Integer.parseInt(data[3]), data[4],
							Integer.parseInt(data[5])));
					break;

				case "cd":
					library.addMusic(new CompactDisc(data[0], data[1], data[2], Integer.parseInt(data[3]),
							Integer.parseInt(data[4])));
					break;

				default:
					throw new IllegalArgumentException("invlid SKU entered");

				}

			}

			scanner.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		//library.displayLibrary();

	}
	
	
	private void loadFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusicLibraryFrame frame = new MusicLibraryFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

}
