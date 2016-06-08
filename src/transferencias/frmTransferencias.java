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
		frmGeneracinDeFicheros.setTitle("Generación de ficheros de transferencias");
		frmGeneracinDeFicheros.setBounds(100, 100, 450, 300);
		frmGeneracinDeFicheros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGeneracinDeFicheros.getContentPane().setLayout(new BorderLayout(0, 0));
		
		// Panel para menú principal
		panelNorte = new JPanel();
		panelNorte.setLayout(new FlowLayout());

		// Menu principal
		JMenuBar menuBar = new JMenuBar();
		
		// Organizar elementos en ventana
		frmGeneracinDeFicheros.getContentPane().add(panelNorte,BorderLayout.NORTH);
		panelNorte.add(menuBar);
		JMenuItem mntmNuevoFichero = new JMenuItem("Nuevo fichero");
		menuBar.add(mntmNuevoFichero);
		mntmNuevoFichero.setHorizontalAlignment(SwingConstants.LEFT);
		
		JMenuItem mntmHistrico = new JMenuItem("Histórico");
		menuBar.add(mntmHistrico);
		mntmHistrico.setHorizontalAlignment(SwingConstants.LEFT);
		
		JMenu menu = new JMenu("Preferencias");
		menu.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(menu);
		
		JMenuItem mntmCompaas = new JMenuItem("Compañías");
		menu.add(mntmCompaas);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("General");
		menu.add(mntmNewMenuItem);
	}

}
