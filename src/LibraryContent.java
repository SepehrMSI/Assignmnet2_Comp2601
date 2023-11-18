import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class LibraryContent extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private MusicLibrary library;


	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			LibraryContent dialog = new LibraryContent(library);
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public LibraryContent(List<MusicMedia> sortedList) {
		
		this.library = library;
		DefaultListModel<String> listModel = new DefaultListModel<>();
		JList<String> musicList = new JList<>(listModel);
		
		
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[grow]", "[grow]"));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, "cell 0 0,grow");
			{
				JList list = new JList();
				scrollPane.setViewportView(list);
				
				 for (MusicMedia media : sortedList) {
			            listModel.addElement(media.toString());
			        }
			}
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
		}
	}

	 private void displaySortedData(Runnable sortFunction) {
	        sortFunction.run();
	        List<MusicMedia> sortedData = library.();
	        listModel.clear();
	        sortedData.forEach(media -> listModel.addElement(media.toString()));
	    }

	
}
