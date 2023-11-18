import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

public class MusicLibraryFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MusicMedia media;
	private MusicLibrary library;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public MusicLibraryFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Music Library");
		setSize(450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		library = new MusicLibrary();
		readFile();
		buildMenu();
		
	}
	

	

	public void buildMenu() {
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');
		menuBar.add(fileMenu);
		
		JMenuItem saveDataMenuItem = new JMenuItem("Save Data");
		saveDataMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_DOWN_MASK));
		saveDataMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		fileMenu.add(saveDataMenuItem);
		
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_DOWN_MASK));
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		fileMenu.add(exitMenuItem);
		
		JMenu sortMenu = new JMenu("Sort");
		sortMenu.setMnemonic('S');
		menuBar.add(sortMenu);
		
		JMenuItem byTypeMenuItem = new JMenuItem("By Type");
		byTypeMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				library.sortByType();
//		        LibraryContentOG dialogByType = new LibraryContentOG(library, "By Type");
				List<MusicMedia> sortedList = library.sortByType();
                LibraryContentOG dialogByType = new LibraryContentOG(sortedList,  "By Type");
//				LibraryContentOG dialogByType = new LibraryContentOG(new MusicLibrary().sortByType(), "By Type");
				dialogByType.setVisible(true);
			}
		});
		sortMenu.add(byTypeMenuItem);
		
		
//		
//		JMenuItem byArtistMenuItem = new JMenuItem("By Artist");
//		byTypeMenuItem.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			
//			}
//		});
//		sortMenu.add(byArtistMenuItem);
//		
		
		 JMenuItem byTitleMenuItem = new JMenuItem("By Title");
	        byTitleMenuItem.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                List<MusicMedia> sortedList = library.sortByTitle();
	                LibraryContentOG dialogByTitle = new LibraryContentOG(sortedList, "By Title");
	                dialogByTitle.setVisible(true);
	            }
	        });
		sortMenu.add(byTitleMenuItem);
		
		
//				
//		JMenuItem byYearMenuItem = new JMenuItem("By Year");
//		byTypeMenuItem.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		sortMenu.add(byYearMenuItem);

		
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic('H');
		menuBar.add(helpMenu);

		JMenuItem aboutMenuItem = new JMenuItem("About");
		aboutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		aboutMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(MusicLibraryFrame.this, "Assignment 2 by\nSepehr Masoudi\nA01348201", "About",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		helpMenu.add(aboutMenuItem);
		
	}	
	
	public void readFile() {

		try (FileReader reader = new FileReader("music_data.txt");) {

			 Scanner scanner = new Scanner(reader);
	            String prefix = null;

	            while (scanner.hasNextLine()) {
	                String oneLine = scanner.nextLine();
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
	                        throw new IllegalArgumentException("Invalid SKU entered");
	                }
	            }

	            scanner.close();

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e1) {
	            e1.printStackTrace();
	        }
		
		
	    }
}
