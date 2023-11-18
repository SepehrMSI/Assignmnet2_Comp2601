import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class AudioFileDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField skuField;
	private JTextField titleField;
	private JTextField artistField;
	private JTextField yearField;
	private JTextField fileName;
	private JTextField resolution;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AudioFileDialog dialog = new AudioFileDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AudioFileDialog() {
		setBounds(100, 100, 550, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][grow]", "[][][][][][][]"));
		{
			JLabel SKU = new JLabel("SKU");
			contentPanel.add(SKU, "cell 0 0,alignx trailing");
		}
		{
			skuField = new JTextField();
			skuField.setEnabled(false);
			contentPanel.add(skuField, "cell 1 0,growx");
			skuField.setColumns(10);
		}
		{
			JLabel TitleLabel = new JLabel("Title");
			contentPanel.add(TitleLabel, "cell 0 1,alignx right");
		}
		{
			titleField = new JTextField();
			contentPanel.add(titleField, "cell 1 1,growx");
			titleField.setColumns(10);
		}
		{
			JLabel artistLabel = new JLabel("Artist");
			contentPanel.add(artistLabel, "cell 0 2,alignx right");
		}
		{
			artistField = new JTextField();
			contentPanel.add(artistField, "cell 1 2,growx");
			artistField.setColumns(10);
		}
		{
			JLabel yearLabel = new JLabel("Year");
			contentPanel.add(yearLabel, "cell 0 3,alignx trailing");
		}
		{
			yearField = new JTextField();
			contentPanel.add(yearField, "cell 1 3,growx");
			yearField.setColumns(10);
		}
		{
			JLabel fileName = new JLabel("File Name");
			contentPanel.add(fileName, "cell 0 4,alignx trailing");
		}
		{
			fileName = new JTextField();
			contentPanel.add(fileName, "cell 1 4,growx");
			fileName.setColumns(10);
		}
		{
			JLabel resolution = new JLabel("Resolution");
			contentPanel.add(resolution, "cell 0 5,alignx trailing");
		}
		{
			resolution = new JTextField();
			resolution.setColumns(10);
			contentPanel.add(resolution, "cell 1 5,growx");
		}
		{
			
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				{
					buttonPane.setLayout(new MigLayout("", "[75px][84px][86px][][][][118.00][44.00][49.00][103.00][][]", "[29px]"));
				}
			}
			JButton btnSave = new JButton("Save");
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			{
				JButton btnClear = new JButton("Clear");
				btnClear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnClear.setActionCommand("OK");
				buttonPane.add(btnClear, "cell 0 0");
			}
			btnSave.setActionCommand("OK");
			buttonPane.add(btnSave, "cell 6 0,alignx right");
			JButton deleteButton = new JButton("Delete");
			
			deleteButton.setActionCommand("OK");
			buttonPane.add(deleteButton, "cell 9 0,alignx right,aligny top");
			getRootPane().setDefaultButton(deleteButton);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton, "cell 11 0,alignx right,aligny top");
			}
		}
	}

}

