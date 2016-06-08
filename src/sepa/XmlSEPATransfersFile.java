package sepa;

import java.util.ArrayList;

public class XmlSEPATransfersFile {

	
	private GroupHeader groupHeader;
	
	/* información del pago 1..N */
	
	private ArrayList<TransferPaymentInformation> numeros = new ArrayList<TransferPaymentInformation>();
	
}
