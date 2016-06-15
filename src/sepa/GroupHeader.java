package sepa;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;



public class GroupHeader {
	
	/*
	 * 
			A. CABECERA [1...1]
			Identificación de mensaje [1...1]
			Fecha y hora de creación [1...1]
			Número de operaciones [1...1]
			Control de suma [0...1]
			+ Parte iniciadora [1...1]
	 * 
	 */
	
	static final String FORMATO_FECHA = "yyyy-MM-dd'T'HH:mm:ss";
	
	/* campos generales */
	
	private String msgId;
	private Date creDtTm;
	private String nbOfTxs;
	private String ctrlSum;
	private String nm;
	private String Id;
	private String BICOrBEI;
	private String cd; /*código */
	private String prtry; /* propietario */
	private String issr; /* emisor */ 
	
	/* los siguientes campos sólo son necesarios para personas físicas, esto no se usa en empresas */ 
	
	private String birthDt; /* fecha de nacimiento */
	private String cityOfBirth; /* ciudad de nacimiento */
	private String ctryOfBirth; /* pais de nacimiento */
	/* otra */
	private String otraId; /* id */
	private String otraPrtry; /* propietario */
	private String otraIssr; /* emisor */ 
	
	
	/* PUBLIC */
	
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
	
	public Date getCreDtTmStr() {
		return creDtTm;
	}
	public void setCreDtTm(Date creDtTm) {
		this.creDtTm = creDtTm;
	}
	public String getCreDtTm() {
		DateFormat df = new SimpleDateFormat(FORMATO_FECHA);
		String txtcreDtTm = df.format(creDtTm);
		return txtcreDtTm;
	}
	public void setCreDtTm(String creDtTm) {
		
		SimpleDateFormat formatter = new SimpleDateFormat(FORMATO_FECHA);
		//String dateInString = "Friday, Jun 7, 2013 12:10:56 PM";		
			
		try {
			Date sqlDate = (Date) formatter.parse(creDtTm);
			this.creDtTm = sqlDate;

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public String getNbOfTxs() {
		return nbOfTxs;
	}
	public void setNbOfTxs(String nbOfTxs) {
		this.nbOfTxs = nbOfTxs;
	}
	
	
	public String getCtrlSum() {
		return ctrlSum;
	}
	public void setCtrlSum(String ctrlSum) {
		this.ctrlSum = ctrlSum;
	}
	
	
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	
	
	public String getBICOrBEI() {
		return BICOrBEI;
	}
	public void setBICOrBEI(String bICOrBEI) {
		BICOrBEI = bICOrBEI;
	}
	
	
	public String getCd() {
		return cd;
	}
	public void setCd(String cd) {
		this.cd = cd;
	}
	
	
	public String getPrtry() {
		return prtry;
	}
	public void setPrtry(String prtry) {
		this.prtry = prtry;
	}
	
	
	public String getIssr() {
		return issr;
	}
	public void setIssr(String issr) {
		this.issr = issr;
	}
	
	
	public String getBirthDt() {
		return birthDt;
	}
	public void setBirthDt(String birthDt) {
		this.birthDt = birthDt;
	}
	
	
	public String getCityOfBirth() {
		return cityOfBirth;
	}
	public void setCityOfBirth(String cityOfBirth) {
		this.cityOfBirth = cityOfBirth;
	}
	
	
	public String getCtryOfBirth() {
		return ctryOfBirth;
	}
	public void setCtryOfBirth(String ctryOfBirth) {
		this.ctryOfBirth = ctryOfBirth;
	}
	
	
	public String getOtraId() {
		return otraId;
	}
	public void setOtraId(String otraId) {
		this.otraId = otraId;
	}
	
	
	public String getOtraPrtry() {
		return otraPrtry;
	}
	public void setOtraPrtry(String otraPrtry) {
		this.otraPrtry = otraPrtry;
	}
	
	
	public String getOtraIssr() {
		return otraIssr;
	}
	public void setOtraIssr(String otraIssr) {
		this.otraIssr = otraIssr;
	}
	

	

	
}
