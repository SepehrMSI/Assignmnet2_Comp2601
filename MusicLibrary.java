
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Collections;


public class MusicLibrary{
	
	private HashMap<String, MusicMedia> library;
	
	{
		library = new HashMap<>();
	}
	
	public MusicLibrary() {}
	
	
	
	 

	public void addMusic(final MusicMedia selection) {

		if (selection != null) {

			library.put(selection.getSku(), selection);
		}
	}

	public void deleteMusic(final String sku) 
	{
		if (sku != null && !sku.isBlank()) 
		{
			if (library.containsKey(sku)) 
			{
				library.remove(sku);
				System.out.println("Entry deleted successfully.");
			}
			else
			{
				System.out.println("Entry with SKU " + sku + " not found.");
			}
		}
	}
	
	
	public void displayLibrary() {
		
		if(library.size() > 0) {
			
			for(String key : library.keySet()) {
				
				System.out.println(library.get(key));
			}
		}
	}
	
	public void displayChoice(String prefix) {
		
		if(prefix != null && !prefix.isBlank()) {
			
			for(String key : library.keySet()) {
				
				if(key.startsWith(prefix)) {
					
					System.out.println(library.get(key));
				}
			}
		}
	}
	

	 public void updateMusic(final String sku, final MusicMedia updatedMedia) 
	 {
	        if (sku != null && !sku.isBlank() && updatedMedia != null) {
	            if (library.containsKey(sku)) 
	            {
	                library.put(sku, updatedMedia);
	                System.out.println("Entry updated successfully.");
	            } else {
	                System.out.println("Entry with SKU " + sku + " not found.");
	            }
	        }
	    }
	
	    
	    
	    public List<MusicMedia> sortByType() {
	        List<MusicMedia> sortedList = library.values().stream()
	                .sorted(Comparator.comparing(MusicMedia::getSku))
	                .collect(Collectors.toList());

	        // Print the sorted list
	        System.out.println("Sorted by Type (SKU):");
	        for (MusicMedia media : sortedList) {
	            System.out.println(media);
	        }

	        return sortedList;
	    }

	    

	    public List<MusicMedia> sortByArtist() 
	    {
	        return library.values()
	        		.stream()
	                .sorted(Comparator.comparing(MusicMedia::getArtist))
	                .collect(Collectors.toList());
	    }

	    public List<MusicMedia> sortByTitle() {
	        return library.values().stream()
	                .sorted(Comparator.comparing(MusicMedia::getTitle))
	                .collect(Collectors.toList());
	    }

	    public List<MusicMedia> sortByYear() {
	        return library.values().stream()
	                .sorted(Comparator.comparingInt(MusicMedia::getYear))
	                .collect(Collectors.toList());
	    }

	 
	 
//	 public void sortByType()
//		{
//			library.values()
//					.stream()
//					.sorted(Comparator.comparing(MusicMedia::getSku))
//					.forEach(System.out::println);
//		}
		
//		public void sortByArtist() {
//		    library.values()
//		            .stream()
//		            .sorted(Comparator.comparing(MusicMedia::getArtist))
//		            .forEach(System.out::println);
//		}
//		
//		
//		public void sortByTitle() {
//		    library.values()
//		            .stream()
//		            .sorted(Comparator.comparing(MusicMedia::getTitle))
//		            .forEach(System.out::println);
//		}
//		
//		public void sortByYear() {
//		    library.values()
//		            .stream()
//		            .sorted(Comparator.comparingInt(MusicMedia::getYear))
//		            .forEach(System.out::println);
//		} 
  
}
