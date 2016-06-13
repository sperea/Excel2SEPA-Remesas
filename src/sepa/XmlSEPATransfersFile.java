package sepa;

import java.util.ArrayList;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlSEPATransfersFile {

	

	private GroupHeader groupHeader;
	
	/* información del pago 1..N */
	
	private ArrayList<TransferPaymentInformation> numeros = new ArrayList<TransferPaymentInformation>();
	
	public GroupHeader getGroupHeader() {
		return groupHeader;
	}

	public void setGroupHeader(GroupHeader groupHeader) {
		this.groupHeader = groupHeader;
	}

	
	public void GenerateXML(String filePath)
	{
	      try {
	    	  
	          DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	          DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

	          // root elements
	          Document doc = docBuilder.newDocument();
	          Element rootElement = doc.createElement("Document");
	          // xmlns="urn:iso:std:iso:20022:tech:xsd:pain.001.001.03" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	          Attr attr = doc.createAttribute("xmlns");
              attr.setValue("urn:iso:std:iso:20022:tech:xsd:pain.001.001.03");
              rootElement.setAttributeNode(attr);
	          attr = doc.createAttribute("xmlns:xsi");
              attr.setValue("http://www.w3.org/2001/XMLSchema-instance");
              rootElement.setAttributeNode(attr);
	          doc.appendChild(rootElement);


	          // CstmrCdtTrfInitn
	          Element CstmrCdtTrfInitn = doc.createElement("CstmrCdtTrfInitn");
	          rootElement.appendChild(CstmrCdtTrfInitn);

	          /*********************************************
	           *  HEADER
	           ********************************************/
	          
	          // CstmrCdtTrfInitn
	          Element GrpHdr = doc.createElement("GrpHdr");
	          CstmrCdtTrfInitn.appendChild(GrpHdr);
	          
	          Element MsgId = doc.createElement("MsgId");
	          MsgId.setTextContent(this.groupHeader.getMsgId());
	          GrpHdr.appendChild(MsgId);
	          

	  // *************************************************************************************************************************************


	          // Write the XML File

	          TransformerFactory transformerFactory = TransformerFactory.newInstance();
	          Transformer transformer = transformerFactory.newTransformer();
	          DOMSource source = new DOMSource(doc);
	          StreamResult result = new StreamResult(new File(filePath));



	          transformer.transform(source, result);

	          System.out.println("File Created Succesfully!");

	        } catch (ParserConfigurationException pce) {
	          pce.printStackTrace();
	        } catch (TransformerException tfe) {
	          tfe.printStackTrace();
	        }
	      }
	}
	

