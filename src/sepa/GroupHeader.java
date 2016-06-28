package sepa;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;



public class GroupHeader {
	
	/*
	 * 
	 *  
		 1.1  	 	     MessageIdentification  	 MessageIdentification  	<MsgId>	++	01.01	 [1..1]  	 Text  
		 1.2  	 	     CreationDateTime  	 CreationDateTime  	<CreDtTm>	++	01.02	 [1..1]  	 DateTime  
		 1.3  	 	     Authorisation  	 Authorisation  	<Authstn>	++	01.03	 [0..2]  	 
		 1.4  	 {Or  	         Code  	 Code  	<Cd>	+++	01.03.01	 [1..1]  	 Code  
		 1.5  	 Or}  	         Proprietary  	 Proprietary  	<Prtry>	+++	01.03.02	 [1..1]  	 Text  
		 1.6  	 	     NumberOfTransactions  	 NumberOfTransactions  	<NbOfTxs>	++	01.04	 [1..1]  	 Text  
		 1.7  	 	     ControlSum  	 ControlSum  	<CtrlSum>	++	01.05	 [0..1]  	 Quantity  
		 1.8  	 	     InitiatingParty  	 InitiatingParty  	<InitgPty>	++	01.06	 [1..1]  	
		 9.1.0  	 	         Name  	 Name  	<Nm>	+++	01.06.01	 [0..1]  	 Text  
		 9.1.1  	 	         PostalAddress  	 PostalAddress  	<PstlAdr>	+++	01.06.02	 [0..1]  	 
		 9.1.2  	 	             AddressType  	 AddressType  	<AdrTp>	++++	01.06.02.01	 [0..1]  	 Code  
		 9.1.3  	 	             Department  	 Department  	<Dept>	++++	01.06.02.02	 [0..1]  	 Text  
		 9.1.4  	 	             SubDepartment  	 SubDepartment  	<SubDept>	++++	01.06.02.03	 [0..1]  	 Text  
		 9.1.5  	 	             StreetName  	 StreetName  	<StrtNm>	++++	01.06.02.04	 [0..1]  	 Text  
		 9.1.6  	 	             BuildingNumber  	 BuildingNumber  	<BldgNb>	++++	01.06.02.05	 [0..1]  	 Text  
		 9.1.7  	 	             PostCode  	 PostCode  	<PstCd>	++++	01.06.02.06	 [0..1]  	 Text  
		 9.1.8  	 	             TownName  	 TownName  	<TwnNm>	++++	01.06.02.07	 [0..1]  	 Text  
		 9.1.9  	 	             CountrySubDivision  	 CountrySubDivision  	<CtrySubDvsn>	++++	01.06.02.08	 [0..1]  	 Text  
		 9.1.10  	 	             Country  	 Country  	<Ctry>	++++	01.06.02.09	 [0..1]  	 Code  
		 9.1.11  	 	             AddressLine  	 AddressLine  	<AdrLine>	++++	01.06.02.10	 [0..7]  	 Text  
		 9.1.12  	 	         Identification  	 Identification  	<Id>	+++	01.06.03	 [0..1]  	 
		 9.1.13  	 {Or  	             OrganisationIdentification  	 OrganisationIdentification  	<OrgId>	++++	01.06.03.01	 [1..1]  	 
		 9.1.14  	 	                 BICOrBEI  	 BICOrBEI  	<BICOrBEI>	+++++	01.06.03.01.01	 [0..1]  	 Identifier  
		 9.1.15  	 	                 Other  	 Other  	<Othr>	+++++	01.06.03.01.02	 [0..n]  	 
		 9.1.16  	 	                     Identification  	 Identification  	<Id>	++++++	01.06.03.01.02.01	 [1..1]  	 Text  
		 9.1.17  	 	                     SchemeName  	 SchemeName  	<SchmeNm>	++++++	01.06.03.01.02.02	 [0..1]  	 
		 9.1.18  	 {{Or  	                         Code  	 Code  	<Cd>	+++++++	01.06.03.01.02.02.01	 [1..1]  	 Code  
		 9.1.19  	 Or}}  	                         Proprietary  	 Proprietary  	<Prtry>	+++++++	01.06.03.01.02.02.02	 [1..1]  	 Text  
		 9.1.20  	 	                     Issuer  	 Issuer  	<Issr>	++++++	01.06.03.01.02.03	 [0..1]  	 Text  
		 9.1.21  	 Or}  	             PrivateIdentification  	 PrivateIdentification  	<PrvtId>	++++	01.06.03.02	 [1..1]  	 
		 9.1.22  	 	                 DateAndPlaceOfBirth  	 DateAndPlaceOfBirth  	<DtAndPlcOfBirth>	+++++	01.06.03.02.01	 [0..1]  	 
		 9.1.23  	 	                     BirthDate  	 BirthDate  	<BirthDt>	++++++	01.06.03.02.01.01	 [1..1]  	 DateTime  
		 9.1.24  	 	                     ProvinceOfBirth  	 ProvinceOfBirth  	<PrvcOfBirth>	++++++	01.06.03.02.01.02	 [0..1]  	 Text  
		 9.1.25  	 	                     CityOfBirth  	 CityOfBirth  	<CityOfBirth>	++++++	01.06.03.02.01.03	 [1..1]  	 Text  
		 9.1.26  	 	                     CountryOfBirth  	 CountryOfBirth  	<CtryOfBirth>	++++++	01.06.03.02.01.04	 [1..1]  	 Code  
		 9.1.27  	 	                 Other  	 Other  	<Othr>	+++++	01.06.03.02.02	 [0..n]  	 
		 9.1.28  	 	                     Identification  	 Identification  	<Id>	++++++	01.06.03.02.02.01	 [1..1]  	 Text  
		 9.1.29  	 	                     SchemeName  	 SchemeName  	<SchmeNm>	++++++	01.06.03.02.02.02	 [0..1]  	 
		 9.1.30  	 {{Or  	                         Code  	 Code  	<Cd>	+++++++	01.06.03.02.02.02.01	 [1..1]  	 Code  
		 9.1.31  	 Or}}  	                         Proprietary  	 Proprietary  	<Prtry>	+++++++	01.06.03.02.02.02.02	 [1..1]  	 Text  
		 9.1.32  	 	                     Issuer  	 Issuer  	<Issr>	++++++	01.06.03.02.02.03	 [0..1]  	 Text  
		 9.1.33  	 	         CountryOfResidence  	 CountryOfResidence  	<CtryOfRes>	+++	01.06.04	 [0..1]  	 Code  
		 9.1.34  	 	         ContactDetails  	 ContactDetails  	<CtctDtls>	+++	01.06.05	 [0..1]  	 
		 9.1.35  	 	             NamePrefix  	 NamePrefix  	<NmPrfx>	++++	01.06.05.01	 [0..1]  	 Code  
		 9.1.36  	 	             Name  	 Name  	<Nm>	++++	01.06.05.02	 [0..1]  	 Text  
		 9.1.37  	 	             PhoneNumber  	 PhoneNumber  	<PhneNb>	++++	01.06.05.03	 [0..1]  	 Text  
		 9.1.38  	 	             MobileNumber  	 MobileNumber  	<MobNb>	++++	01.06.05.04	 [0..1]  	 Text  
		 9.1.39  	 	             FaxNumber  	 FaxNumber  	<FaxNb>	++++	01.06.05.05	 [0..1]  	 Text  
		 9.1.40  	 	             EmailAddress  	 EmailAddress  	<EmailAdr>	++++	01.06.05.06	 [0..1]  	 Text  
		 9.1.41  	 	             Other  	 Other  	<Othr>	++++	01.06.05.07	 [0..1]  	 Text  
		 1.9  	 	     ForwardingAgent  	 ForwardingAgent  	<FwdgAgt>	++	01.07	 [0..1]  	   
		 6.1.0  		         FinancialInstitutionIdentification  	 FinancialInstitutionIdentification  	<FinInstnId>	+++	01.07.01	 [1..1]  	 
		 6.1.1  		             BIC  	 BIC  	<BIC>	++++	01.07.01.01	 [0..1]  	 Identifier  
		 6.1.2  		             ClearingSystemMemberIdentification  	 ClearingSystemMemberIdentification  	<ClrSysMmbId>	++++	01.07.01.02	 [0..1]  	 
		 6.1.3  		                 ClearingSystemIdentification  	 ClearingSystemIdentification  	<ClrSysId>	+++++	01.07.01.02.01	 [0..1]  	 
		 6.1.4  	 {Or  	                     Code  	 Code  	<Cd>	++++++	01.07.01.02.01.01	 [1..1]  	 Code  
		 6.1.5  	 Or}  	                     Proprietary  	 Proprietary  	<Prtry>	++++++	01.07.01.02.01.02	 [1..1]  	 Text  
		 6.1.6  	 	                 MemberIdentification  	 MemberIdentification  	<MmbId>	+++++	01.07.01.02.02	 [1..1]  	 Text  
		 6.1.7  	 	             Name  	 Name  	<Nm>	++++	01.07.01.03	 [0..1]  	 Text  
		 6.1.8  	 	             PostalAddress  	 PostalAddress  	<PstlAdr>	++++	01.07.01.04	 [0..1]  	 
		 6.1.9  	 	                 AddressType  	 AddressType  	<AdrTp>	+++++	01.07.01.04.01	 [0..1]  	 Code  
		 6.1.10  	 	                 Department  	 Department  	<Dept>	+++++	01.07.01.04.02	 [0..1]  	 Text  
		 6.1.11  	 	                 SubDepartment  	 SubDepartment  	<SubDept>	+++++	01.07.01.04.03	 [0..1]  	 Text  
		 6.1.12  	 	                 StreetName  	 StreetName  	<StrtNm>	+++++	01.07.01.04.04	 [0..1]  	 Text  
		 6.1.13  	 	                 BuildingNumber  	 BuildingNumber  	<BldgNb>	+++++	01.07.01.04.05	 [0..1]  	 Text  
		 6.1.14  	 	                 PostCode  	 PostCode  	<PstCd>	+++++	01.07.01.04.06	 [0..1]  	 Text  
		 6.1.15  	 	                 TownName  	 TownName  	<TwnNm>	+++++	01.07.01.04.07	 [0..1]  	 Text  
		 6.1.16  	 	                 CountrySubDivision  	 CountrySubDivision  	<CtrySubDvsn>	+++++	01.07.01.04.08	 [0..1]  	 Text  
		 6.1.17  	 	                 Country  	 Country  	<Ctry>	+++++	01.07.01.04.09	 [0..1]  	 Code  
		 6.1.18  	 	                 AddressLine  	 AddressLine  	<AdrLine>	+++++	01.07.01.04.10	 [0..7]  	 Text  
		 6.1.19  	 	             Other  	 Other  	<Othr>	++++	01.07.01.05	 [0..1]  	 
		 6.1.20  	 	                 Identification  	 Identification  	<Id>	+++++	01.07.01.05.01	 [1..1]  	 Text  
		 6.1.21  	 	                 SchemeName  	 SchemeName  	<SchmeNm>	+++++	01.07.01.05.02	 [0..1]  	 
		 6.1.22  	 {Or  	                     Code  	 Code  	<Cd>	++++++	01.07.01.05.02.01	 [1..1]  	 Code  
		 6.1.23  	 Or}  	                     Proprietary  	 Proprietary  	<Prtry>	++++++	01.07.01.05.02.02	 [1..1]  	 Text  
		 6.1.24  	 	                 Issuer  	 Issuer  	<Issr>	+++++	01.07.01.05.03	 [0..1]  	 Text  
		 6.1.25  	 	         BranchIdentification  	 BranchIdentification  	<BrnchId>	+++	01.07.02	 [0..1]  	 
		 6.1.26  	 	             Identification  	 Identification  	<Id>	++++	01.07.02.01	 [0..1]  	 Text  
		 6.1.27  	 	             Name  	 Name  	<Nm>	++++	01.07.02.02	 [0..1]  	 Text  
		 6.1.28  		             PostalAddress  	 PostalAddress  	<PstlAdr>	++++	01.07.02.03	 [0..1]  	 
		 6.1.29  		                 AddressType  	 AddressType  	<AdrTp>	+++++	01.07.02.03.01	 [0..1]  	 Code  
		 6.1.30  		                 Department  	 Department  	<Dept>	+++++	01.07.02.03.02	 [0..1]  	 Text  
		 6.1.31  		                 SubDepartment  	 SubDepartment  	<SubDept>	+++++	01.07.02.03.03	 [0..1]  	 Text  
		 6.1.32  		                 StreetName  	 StreetName  	<StrtNm>	+++++	01.07.02.03.04	 [0..1]  	 Text  
		 6.1.33  		                 BuildingNumber  	 BuildingNumber  	<BldgNb>	+++++	01.07.02.03.05	 [0..1]  	 Text  
		 6.1.34  		                 PostCode  	 PostCode  	<PstCd>	+++++	01.07.02.03.06	 [0..1]  	 Text  
		 6.1.35  		                 TownName  	 TownName  	<TwnNm>	+++++	01.07.02.03.07	 [0..1]  	 Text  
		 6.1.36  		                 CountrySubDivision  	 CountrySubDivision  	<CtrySubDvsn>	+++++	01.07.02.03.08	 [0..1]  	 Text  
		 6.1.37  		                 Country  	 Country  	<Ctry>	+++++	01.07.02.03.09	 [0..1]  	 Code  
		 6.1.38  		                 AddressLine  	 AddressLine  	<AdrLine>	+++++	01.07.02.03.10	 [0..7]  	 Text  

	 * 
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
	
	
	public String getCreDtTmStr() {
		DateFormat df = new SimpleDateFormat(FORMATO_FECHA);
		String txtcreDtTm = df.format(creDtTm);
		return txtcreDtTm;
	}
	public void setCreDtTm(Date creDtTm) {
		this.creDtTm = creDtTm;
	}
	public Date getCreDtTm() {
		return creDtTm;
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
		// return ctrlSum;
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
