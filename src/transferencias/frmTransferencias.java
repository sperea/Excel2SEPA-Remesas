package transferencias;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class frmTransferencias {
	
	static final String FORMATO_FECHA = "dd/MM/yyyy HH:mm:ss";

	private JFrame frmGeneracinDeFicheros;
	private JPanel panelNorte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				
				try {
					frmTransferencias window = new frmTransferencias();
					window.frmGeneracinDeFicheros.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frmTransferencias() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		// Inicializar ventana
		frmGeneracinDeFicheros = new JFrame();
		frmGeneracinDeFicheros.setType(Type.UTILITY);
		frmGeneracinDeFicheros.setResizable(false);
		frmGeneracinDeFicheros.setTitle("Generación de ficheros de transferencias");
		frmGeneracinDeFicheros.setBounds(100, 100, 450, 300);
		frmGeneracinDeFicheros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGeneracinDeFicheros.getContentPane().setLayout(null);
		
		// Panel para menú principal
		panelNorte = new JPanel();
		panelNorte.setBounds(0, 0, 450, 10);
		panelNorte.setLayout(new FlowLayout());
		
		// Organizar elementos en ventana
		frmGeneracinDeFicheros.getContentPane().add(panelNorte);
		
		JButton btnCargarExcel = new JButton("Cargar Excel");
		btnCargarExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CargarExcel();
			}
		});
		btnCargarExcel.setBounds(30, 50, 173, 25);
		frmGeneracinDeFicheros.getContentPane().add(btnCargarExcel);
		
		JButton btnGenerarxml = new JButton("GenerarXML");
		btnGenerarxml.setBounds(250, 50, 173, 25);
		frmGeneracinDeFicheros.getContentPane().add(btnGenerarxml);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(12, 115, 411, 145);
		frmGeneracinDeFicheros.getContentPane().add(textPane);
		
	}

	private void CargarExcel() {
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(this.frmGeneracinDeFicheros);
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = fileChooser.getSelectedFile();
		    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
		}
	}
}
