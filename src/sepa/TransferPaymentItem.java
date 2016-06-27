package sepa;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class TransferPaymentItem {
	
	private String InstrId;
	private String EndToEndId;
	private String Cd_SvcLvl;
	private double InstdAmt;
	private String Ctry_PstlAdr_CdtrAgt;
	private String Nm_Cdtr;
	private String Ctry_PstlAdr_Cdtr;
	private String AdrLine_PstlAdr;
	private String AdrLine2_PstlAdr;
	private String IBAN;
	private String Cd_Purp;
	private String Ustrd;
	
	
	public String getInstrId() {
		return InstrId;
	}
	public void setInstrId(String instrId) {
		InstrId = instrId;
	}
	public String getEndToEndId() {
		return EndToEndId;
	}
	public void setEndToEndId(String endToEndId) {
		EndToEndId = endToEndId;
	}
	public String getCd_SvcLvl() {
		return Cd_SvcLvl;
	}
	public void setCd_SvcLvl(String cd_SvcLvl) {
		Cd_SvcLvl = cd_SvcLvl;
	}
	public double getInstdAmt() {
		return InstdAmt;
	}
	public String getInstdAmt2String() {
		
		DecimalFormatSymbols simbolos = DecimalFormatSymbols.getInstance(Locale.ENGLISH);
		DecimalFormat formateador = new DecimalFormat("####.##",simbolos);
		// String InstdAmtStr = df.format(this.InstdAmt);
		return formateador.format(this.InstdAmt);
	}
	public void setInstdAmt(double instdAmt) {
		InstdAmt = instdAmt;
	}
	public String getCtry_PstlAdr_CdtrAgt() {
		return Ctry_PstlAdr_CdtrAgt;
	}
	public void setCtry_PstlAdr_CdtrAgt(String ctry_PstlAdr_CdtrAgt) {
		Ctry_PstlAdr_CdtrAgt = ctry_PstlAdr_CdtrAgt;
	}
	public String getNm_Cdtr() {
		return Nm_Cdtr;
	}
	public void setNm_Cdtr(String nm_Cdtr) {
		Nm_Cdtr = nm_Cdtr;
	}
	public String getCtry_PstlAdr_Cdtr() {
		return Ctry_PstlAdr_Cdtr;
	}
	public void setCtry_PstlAdr_Cdtr(String ctry_PstlAdr_Cdtr) {
		Ctry_PstlAdr_Cdtr = ctry_PstlAdr_Cdtr;
	}
	public String getAdrLine_PstlAdr() {
		return AdrLine_PstlAdr;
	}
	public void setAdrLine_PstlAdr(String adrLine_PstlAdr) {
		AdrLine_PstlAdr = adrLine_PstlAdr;
	}
	public String getAdrLine2_PstlAdr() {
		return AdrLine2_PstlAdr;
	}
	public void setAdrLine2_PstlAdr(String adrLine2_PstlAdr) {
		AdrLine2_PstlAdr = adrLine2_PstlAdr;
	}
	
	public String getIBAN() {
		return IBAN;
	}
	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}
	public String getCd_Purp() {
		return Cd_Purp;
	}
	public void setCd_Purp(String cd_Purp) {
		Cd_Purp = cd_Purp;
	}
	public String getUstrd() {
		return Ustrd;
	}
	public void setUstrd(String ustrd) {
		Ustrd = ustrd;
	}

	
	
}
