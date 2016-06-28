package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import sepa.GroupHeader;
import sepa.TransferPaymentInformation;
import sepa.TransferPaymentItem;
import sepa.XmlSEPATransfersFile;

public class TestXML {

	private GroupHeader gh;
	private TransferPaymentInformation tp;
	
	private XmlSEPATransfersFile xmlPrueba;
	
	public XmlSEPATransfersFile getXmlPrueba() {
		return xmlPrueba;
	}

	public void setXmlPrueba(XmlSEPATransfersFile xmlPrueba) {
		this.xmlPrueba = xmlPrueba;
	}

	@Before
	public void setUp() throws Exception {
		gh = new GroupHeader();
		tp = new TransferPaymentInformation();
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	
	@Test
	public void testCreDtTm_Cadena() {
	    // <CreDtTm>2016-05-25T12:55:58</CreDtTm>
	    this.gh.setCreDtTm("2016-05-25T12:55:58");
	    assertTrue("2016-05-25T12:55:58".compareTo(gh.getCreDtTmStr())==0);
	}
	
	@Test
	public void testCreDtTm_Fecha() throws ParseException {
	    // <CreDtTm>2016-05-25T12:55:58</CreDtTm>
		// Paso CreDtTm en forma de fecha y me devuelve la cadena correcta
		String strFecha = "2016-05-25T12:55:58";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date d1 = df.parse(strFecha);
		this.gh.setCreDtTm(d1);
	    assertTrue(strFecha.compareTo(gh.getCreDtTmStr())==0);
	    
	}
	
	
	@Test
	public void testXMLFinal() throws ParseException {
	    /*
	     * Vamos a probar que el fichero XML se genera correctamente
	     */
	    XmlSEPATransfersFile auxXML = new XmlSEPATransfersFile();
	    
	    /* datos ficticios */
	    
	    /* Generar Header */
	    
	    this.gh.setCreDtTm("2016-05-25T12:55:58");
		this.gh.setMsgId("TR00000065");
		this.gh.setNbOfTxs("21");
		this.gh.setCtrlSum("156965.10");
		this.gh.setNm("JLA ASOCIADOS");
		this.gh.setId("A79261020002");
		
		auxXML.setGroupHeader(this.gh);
		
		/* generar pagos */
		
		/* datos generales y agregados */
		
		this.tp.setPmtInfId("LOTE-00000065"); 
		this.tp.setPmtMtd("TRF");
		this.tp.setBtchBookg("false");
		this.tp.setInstrPrty("HIGH");
		this.tp.setCd("SEPA");
		this.tp.setCd_LclInstrm("TRF");
		this.tp.setCd_CtgyPurp("SUPP");
		this.tp.setReqdExctnDt("2016-05-25");
		this.tp.setNm("JLA ASOCIADOS CORREDURIA DE SEGUROS");
		this.tp.setCtry("ES");
		this.tp.setAdrLine("SAGASTA, 32, 5º DERECHA");
		this.tp.setAdrLine2("28004 MADRID");
		this.tp.setId_Dbtr("A79261020002");
		this.tp.setIBAN("ES0400750322880000000000");
		this.tp.setCcy("EUR");
		this.tp.setBIC("POPUESMMXXX");
		this.tp.setNm("JLA ASOCIADOS CORREDURIA DE SEGUROS");
		
		/* generamos un pago y lo insertamos */
		
		TransferPaymentItem pagoItem = new TransferPaymentItem();
		pagoItem.setInstrId("INSTRID-02-01");
		pagoItem.setEndToEndId("ENDTOEND-02");
		pagoItem.setCd_SvcLvl("SEPA");
		pagoItem.setNm_Cdtr("WR BERKLEY EUROPE AG SUCURSAL EN ESPANA");
		pagoItem.setInstdAmt(26000.33);
		pagoItem.setCtry_PstlAdr_Cdtr("ES");
		pagoItem.setAdrLine_PstlAdr(".");
		pagoItem.setAdrLine2_PstlAdr(".");
		pagoItem.setIBAN("ES3400491500022900000000");
		pagoItem.setCd_Purp("OTHR");
		pagoItem.setUstrd("LIQUIDACION 05/16");

		this.tp.InsertarPago(pagoItem);
		
		auxXML.InsertarPago(this.tp);
		
		/* datos de los pagos */
		
		
		/* Generamos el fichero */
		auxXML.GenerateXML("/home/sergio/Documentos/fichero.xml");
		
	    assertTrue(0==0);

	}
	
	@Test
	public void TestFileFormatXSD ()
	{
		
		/* se comprueba que el fichero generado en la prueba anterior es correcto según el esquema definido en el XSD */
	       try {
	           //XML a validar
	           Source xmlFile = new StreamSource(new File("/home/sergio/Documentos/fichero.xml"));
	          
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




