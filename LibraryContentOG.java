import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class LibraryContentOG extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private MusicMedia media;
	private MusicLibrary library;

	

//	
//	public static void main(String[] args) {
//		try {
//			LibraryContentOG dialog = new LibraryContentOG(library.sortByTitle(), "By Title");
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
 
	/**
	 * Create the dialog.
	 */
	public LibraryContentOG(List<MusicMedia> media, String sortingType) {
		
		
		this.library = new MusicLibrary();
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[grow]", "[grow]"));
		{
			
			List<MusicMedia> sortedLibrary;
			 switch (sortingType) {
	            case "By Type":
	                // Use the sortByType method in MusicLibrary
	                sortedLibrary = new MusicLibrary().sortByType();
	                break;
	            case "By Title":
	                // Use the sortByTitle method in MusicLibrary
	                sortedLibrary = new MusicLibrary().sortByTitle();
	                break;
	            // Add more cases for other sorting types if needed

	            default:
	                throw new IllegalArgumentException("Invalid sorting type: " + sortingType);
	        }
			
			
			 JList<MusicMedia> musicList = new JList<>(sortedLibrary.toArray(new MusicMedia[0]));
			 JScrollPane scrollPane = new JScrollPane(musicList);	
		     getContentPane().add(scrollPane, BorderLayout.CENTER);

			 
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
//			{
//				JButton cancelButton = new JButton("Cancel");
//				cancelButton.setActionCommand("Cancel");
//				buttonPane.add(cancelButton);
//			}
		}
	}

}
