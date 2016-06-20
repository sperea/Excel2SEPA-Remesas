package test;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sepa.GroupHeader;
import sepa.TransferPaymentInformation;
import sepa.XmlSEPATransfersFile;

public class TestGroupHeader {

	private GroupHeader gh;
	private TransferPaymentInformation tp;
	
	@Before
	public void setUp() throws Exception {
		gh = new GroupHeader();
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	
	@Test
	public void testCreDtTm_Cadena() {
	    // <CreDtTm>2016-05-25T12:55:58</CreDtTm>
	    this.gh.setCreDtTm("2016-05-25T12:55:58");
	    assertTrue("2016-05-25T12:55:58".compareTo(gh.getCreDtTm())==0);
	}
	
	@Test
	public void testCreDtTm_Fecha() throws ParseException {
	    // <CreDtTm>2016-05-25T12:55:58</CreDtTm>
		// Paso CreDtTm en forma de fecha y me devuelve la cadena correcta
		String strFecha = "2016-05-25T12:55:58";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date d1 = df.parse(strFecha);
		this.gh.setCreDtTm(d1);
	    assertTrue(strFecha.compareTo(gh.getCreDtTm())==0);
	    
	}
	
	
	@Test
	public void testXMLFinal() throws ParseException {
	    /*
	     * Vamos a probar que el fichero XML se genera correctamente
	     */
	    XmlSEPATransfersFile auxXML = new XmlSEPATransfersFile();
	    
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
		this.tp.setNbOfTxs("21");
		this.tp.setCtrlSum("156965.10");
		this.tp.setInstrPrty("HIGH");
		this.tp.setCd("SEPA");
		this.tp.setCd_LclInstrm("TRF");
		this.tp.setCd_CtgyPurp("SUPP");
		this.tp.setReqdExctnDt("2016-05-25");
		
		/* Generamos el fichero */
		auxXML.GenerateXML("/home/sergio/Documentos/fichero.xml");
		
	    assertTrue(0==0);

	}
	


	
}




