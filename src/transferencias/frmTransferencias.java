package transferencias;

import static org.junit.Assert.assertTrue;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import excel.ExcelSepa;
import sepa.JlaInfoSepa;
import sepa.XmlSEPATransfersFile;

import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionEvent;

public class frmTransferencias {
	
	static final String FORMATO_FECHA = "dd/MM/yyyy HH:mm:ss";

	private JFrame frmGeneracinDeFicheros;
	private JPanel panelNorte;
	
	private JButton btnCargarExcel;
	private JButton btnGenerarxml;
	private JTextArea textPane;
	
	private String ficheroExcel;
	private String ficheroXML;
	
	PrintStream printStream;
	
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
		frmGeneracinDeFicheros.setBounds(100, 100, 850, 500);
		frmGeneracinDeFicheros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGeneracinDeFicheros.getContentPane().setLayout(null);
		
		// Panel para menú principal
		panelNorte = new JPanel();
		panelNorte.setBounds(0, 0, 450, 10);
		panelNorte.setLayout(new FlowLayout());
		
		// Organizar elementos en ventana
		frmGeneracinDeFicheros.getContentPane().add(panelNorte);
		
		btnCargarExcel = new JButton("Cargar Excel");
		btnCargarExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CargarExcel();
			}
		});
		btnCargarExcel.setBounds(30, 50, 304, 53);
		frmGeneracinDeFicheros.getContentPane().add(btnCargarExcel);
		
		btnGenerarxml = new JButton("GenerarXML");
		btnGenerarxml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SalvarXML();
			}
		});
		btnGenerarxml.setBounds(519, 50, 304, 53);
		frmGeneracinDeFicheros.getContentPane().add(btnGenerarxml);
		
		textPane = new JTextArea();
		textPane.setBounds(12, 115, 811, 357);
		frmGeneracinDeFicheros.getContentPane().add(textPane);
		
	}

	private void CargarExcel() {
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(this.frmGeneracinDeFicheros);
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = fileChooser.getSelectedFile();
		    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
		    textPane.setText("Selected file: " + selectedFile.getAbsolutePath());
		    this.ficheroExcel = selectedFile.getAbsolutePath();
		}
	}
	
	private void SalvarXML()
	{

	        
	        JFileChooser fileChooser = new JFileChooser();
	            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("todos los archivos *.xml", "xml","XML"));//filtro para ver solo archivos .edu
	            int seleccion = fileChooser.showSaveDialog(null);
	            try{
	                if (seleccion == JFileChooser.APPROVE_OPTION){//comprueba si ha presionado el boton de aceptar
	                    File JFC = fileChooser.getSelectedFile();
	                    String PATH = JFC.getAbsolutePath();//obtenemos el path del archivo a guardar
	                    this.ficheroXML = PATH + JFC.getName();
	                    
	                    printStream = new PrintStream(new CustomOutputStream(this.textPane));
	                    System.setOut(printStream);
	                    
	                    GenerarXML();
	                    
	                    System.out.println(" -> Fichero  generado correctamente");
	                    
	                    //JOptionPane.showMessageDialog(null,"¡Guardado exitoso!", "¡Guardado exitoso!", JOptionPane.INFORMATION_MESSAGE);
	                }
	            }catch (Exception e){//por alguna excepcion salta un mensaje de error
	                JOptionPane.showMessageDialog(null,"¡Error al guardar el archivo!", "¡Oops! Error", JOptionPane.ERROR_MESSAGE);
	            }
	}  
	
	private void GenerarXML() throws IOException
	{
		ExcelSepa  excel = new ExcelSepa();
		excel.setRutaExcel(this.ficheroExcel);
		System.out.println(" -> Abierto fichero Excel ".concat(this.ficheroExcel));
		JlaInfoSepa datosEntrada = excel.LeerTransacciones();
		System.out.println(" -> Se han leido las transacciones de ".concat(this.ficheroExcel));
		XmlSEPATransfersFile xmlSepa = new XmlSEPATransfersFile(datosEntrada); 
		xmlSepa.GenerateXML(this.ficheroXML);
		System.out.println(" -> Ganerando XML ");

		/* se comprueba que el fichero generado en la prueba anterior es correcto según el esquema definido en el XSD */
	       try {
	           //XML a validar
	           Source xmlFile = new StreamSource(new File(this.ficheroExcel));
	           
	          
	           //Esquema con el que comparar
	           Source schemaFile = new StreamSource(new File("xsd/transferencias.xsd"));

	           //Preparación del esquema
	           SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	           Schema schema = schemaFactory.newSchema(schemaFile);
	           
	           //Creación del validador
	           Validator validator = schema.newValidator();

	           //Definición del manejador de excepciones del validador
	           final List exceptions = new LinkedList();
	           validator.setErrorHandler(new ErrorHandler()
	            {
	            @Override
	            public void warning(SAXParseException exception) throws SAXException
	            {
	             exceptions.add(exception);
	            }

	            @Override
	            public void fatalError(SAXParseException exception) throws SAXException
	            {
	             exceptions.add(exception);
	            }

	            @Override
	            public void error(SAXParseException exception) throws SAXException
	            {
	             exceptions.add(exception);
	            }
	            });

	           //Validación del XML
	           validator.validate(xmlFile);
	           
	           boolean validFile = false;
	           
	           //Resultado de la validación. Si hay errores se detalla el error y la posición exacta en el XML
	           if (exceptions.size()==0) {
	            System.out.println("FILE " + xmlFile.getSystemId() + " IS VALID");
	            validFile = true;
	           } else {
	            System.out.println("FILE " + xmlFile.getSystemId() + " IS INVALID");
	            System.out.println("NUMBER OF ERRORS: "+exceptions.size());
	                for(int i = 0; i < exceptions.size(); i++) {
	                 i=i+1;
	                 System.out.println("Error # " + i + ":");
	                 i=i-1;
	                 System.out.println("    - Line: "+((SAXParseException) exceptions.get(i)).getLineNumber());
	                 System.out.println("    - Column: "+((SAXParseException) exceptions.get(i)).getColumnNumber());
	                 System.out.println("    - Error message: "+((Throwable) exceptions.get(i)).getLocalizedMessage());
	                 System.out.println("------------------------------");
	                           }
	                   }
	           
	           assertTrue(validFile);
	           
	            } catch (SAXException e) {
	             e.printStackTrace();
	            } catch (IOException e) {
	            e.printStackTrace();
	           }
	}
	
}
