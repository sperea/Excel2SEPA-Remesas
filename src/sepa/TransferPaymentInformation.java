package sepa;

import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TransferPaymentInformation {
	
	/* Datos de pago */
	
	/*
			B. INFORMACIÓN DEL PAGO [1...n]
			Identificación de información del pago [1...1]
			 Medio de pago [1...1]
			 Indicador de apunte en cuenta [0...1]
			 Número de operaciones [0...1]
			 Control de suma [0...1]
			+ Información del tipo de pago [0...1]
			Fecha de ejecución solicitada [1...1]
			+ Ordenante [1...1]
			+ Cuenta del ordenante [1...1]
			+ Entidad del ordenante [1...1]
			+ Ultimo ordenante [0...1]
			Cláusula de gastos [0...1]
	 */
	
	/*
	 * 
			2.0 [1..n] + Información del pago <PmtInf>
			2.1 [1..1] ++ Identificación de Información del pago <PmtInfId> 35
			2.2 [1..1] ++ Método de pago <PmtMtd> 3
			2.3 [0..1] ++ Indicador de apunte en cuenta <BtchBookg> 5
			2.4 [0..1] ++ Número de operaciones <NbOfTxs> 5
			2.5 [0..1] ++ Control de suma <CtrlSum> 18
			2.6 [0..1] ++ Información del tipo de pago <PmtTpInf>
			2.7 [0..1] +++ Prioridad de la instrucción <InstrPrty> 4
			2.8 [0..1] +++ Nivel de servicio <SvcLvl>
			2.9 [1..1] ++++ Código <Cd> 4
			2.11 [0..1] +++ Instrumento local <LclInstrm>
			2.12 [1..1] {Or ++++ Código <Cd> 4
			2.13 [1..1] Or} ++++ Propietario <Prtry> 35
			2.14 [0..1] +++ Tipo de transferencia <CtgyPurp>
			2.15 [1..1] ++++ Código <Cd> 4
			2.17 [1..1] ++ Fecha de ejecución solicitada <ReqdExctnDt> 10
			2.19 [1..1] ++ Ordenante <Dbtr>
			[0..1] +++ Nombre <Nm> 70
			[0..1] +++ Dirección postal <PstlAdr>
			[0..1] ++++ País <Ctry> 2
			[0..2] ++++ Dirección en texto libre <AdrLine> 70
			[0..1] +++ Identificación <Id>
			[1..1]{Or ++++ Persona jurídica <OrgId>
			[1..1]{{Or +++++ BIC o BEI <BICOrBEI> 11
			[1..1] Or}} +++++ Otra <Othr>
			[1..1] ++++++ Identificación <Id> 35
			[0..1] ++++++ Nombre del esquema <SchmeNm>
			[1..1]{{Or +++++++ Código <Cd> 4
			[1..1] Or}} +++++++ Propietario <Prtry> 35
			[0..1] ++++++ Emisor <Issr> 35
			[1..1]Or} ++++ Persona física <PrvtId>
			[1..1]{{Or +++++ Fecha y lugar de nacimiento <DtAndPlcOfBirth>
			[1..1] ++++++ Fecha de nacimiento <BirthDt> 8
			[0..1] ++++++ Provincia de nacimiento <PrvcOfBirth> 35
			[1..1] ++++++ Ciudad de nacimiento <CityOfBirth> 35
			[1..1] ++++++ País de nacimiento <CtryOfBirth> 2
			[1..1] Or}} +++++ Otra <Othr>
			[1..1] ++++++ Identificación <Id> 35
			[0..1] ++++++ Nombre del esquema <SchmeNm>
			[1..1]{{Or +++++++ Código <Cd> 4
			[1..1] Or}} +++++++ Propietario <Prtry> 35
			[0..1] ++++++ Emisor <Issr> 35
			2.20 [1..1] ++ Cuenta del ordenante <DbtrAcct>
			14
			Indice Ocurrencias Nombre <Etiqueta XML> Longitud
			2.20 [1..1] +++ Identificación <Id>
			2.20 [1..1]{Or ++++ IBAN <IBAN> 34
			2.20 [1..1]Or} ++++ Otro <Othr>
			2.20 [1..1] +++++ Identificación <Id> 35
			[0..1] +++ Divisa o moneda <Ccy> 3
			2.21 [1..1] ++ Entidad ordenante <DbtrAgt>
			[1..1] +++ Identificación de la entidad ordenante <FinInstnId>
			[0..1] ++++ BIC de la entidad ordenante <BIC> 11
			[0..1] ++++ Otra <Othr>
			[1..1] +++++ Identificación <Id> 35
			2.23 [0..1] ++ Último ordenante <UltmtDbtr>
			[0..1] +++ Nombre <Nm> 70
			[0..1] +++ Dirección postal <PstlAdr>
			[0..1] ++++ País <Ctry> 2
			[0..2] ++++ Dirección en texto libre <AdrLine> 70
			[0..1] +++ Identificación <Id>
			[1..1]{Or ++++ Persona jurídica <OrgId>
			[1..1]{{Or +++++ BIC o BEI <BICOrBEI> 11
			[1..1] Or}} +++++ Otra <Othr>
			[1..1] ++++++ Identificación <Id> 35
			[0..1] ++++++ Nombre del esquema <SchmeNm>
			[1..1]{{Or +++++++ Código <Cd> 4
			[1..1]Or}} +++++++ Propietario <Prtry> 35
			[0..1] ++++++ Emisor <Issr> 35
			[1..1]Or} ++++ Persona física <PrvtId>
			[1..1]{{Or +++++ Fecha y lugar de nacimiento <DtAndPlcOfBirth>
			[1..1] ++++++ Fecha de nacimiento <BirthDt> 8
			[0..1] ++++++ Provincia de nacimiento <PrvcOfBirth> 35
			[1..1] ++++++ Ciudad de nacimiento <CityOfBirth> 35
			[1..1] ++++++ País de nacimiento <CtryOfBirth> 2
			[1..1] Or}} +++++ Otra <Othr>
			[1..1] ++++++ Identificación <Id> 35
			[0..1] ++++++ Nombre del esquema <SchmeNm>
			[1..1]{{Or +++++++ Código <Cd> 4
			[1..1]Or}} +++++++ Propietario <Prtry> 35
			[0..1] ++++++ Emisor <Issr> 35
			2.24 [0..1] ++ Cláusula de gastos <ChrgBr> 4
	 * 
	 */
	



	private String PmtMtd;
	private String BtchBookg;
	private String InstrPrty;
	private String Cd_SvcLvl;
	private String Cd_LclInstrm;
	private String Prtry_2_13;
	private String Cd_CtgyPurp;
	private Date ReqdExctnDt;
	private String Nm1;
	private String Ctry1;
	private String AdrLine1;
	private String BICOrBEI1;

	private String Id_Dbtr;
	private String Cd1;
	private String Prtry1;
	private String Issr1;
	private Date BirthDt1;
	private String PrvcOfBirth1;
	private String CityOfBirth1;
	private String CtryOfBirth1;
	private String Id11;
	private String Cd11;
	private String Prtry11;
	private String Issr11;
	private String IBAN;
	private String Id111;
	private String Ccy;
	private String BIC;
	private String Id1111;
	private String Nm;
	private String Ctry;
	private String AdrLine;
	private String AdrLine2; /* linea 2 de la direccion */
	private String BICOrBEI;
	private String Id11111;
	private String Cd111;
	private String Prtry111;
	private String Issr111;
	private Date BirthDt;
	private String PrvcOfBirth;
	private String CityOfBirth;
	private String CtryOfBirth;
	private String Id;
	private String Cd;
	private String Prtry;
	private String Issr;
	private String ChrgBr;

	
	
	/* listado de pagos individuales */
	private ArrayList<TransferPaymentItem> numeros = new ArrayList<TransferPaymentItem>();
	
	
	private String PmtInfId;
	/**
	 * @return the pmtInfId
	 */
	public String getPmtInfId() {
		return PmtInfId;
	}


	public void InsertarPago (TransferPaymentItem _pago)
	{
		this.numeros.add(_pago);
	}
	
	
	/**
	 * @param pmtInfId the pmtInfId to set
	 */
	public void setPmtInfId(String pmtInfId) {
		PmtInfId = pmtInfId;
	}



	/**
	 * @return the pmtMtd
	 */
	public String getPmtMtd() {
		return PmtMtd;
	}



	/**
	 * @param pmtMtd the pmtMtd to set
	 */
	public void setPmtMtd(String pmtMtd) {
		PmtMtd = pmtMtd;
	}



	/**
	 * @return the btchBookg
	 */
	public String getBtchBookg() {
		return BtchBookg;
	}



	/**
	 * @param btchBookg the btchBookg to set
	 */
	public void setBtchBookg(String btchBookg) {
		BtchBookg = btchBookg;
	}



	/**
	 * @return the nbOfTxs
	 */
	public String getNbOfTxs() {
		//return NbOfTxs
      return Integer.toString(this.getPagos().size());
	}
	
	/**
	 * @return the nbOfTxs
	 */
	public int getNbOfTxsInteger() {
		//return NbOfTxs
      return this.getPagos().size();
	}




	/**
	 * @return the ctrlSum
	 */
	public String getCtrlSum() {
        ArrayList<TransferPaymentItem> pagos = this.getPagos();
        Iterator<TransferPaymentItem> iteradorPagos = pagos.iterator();
        double sumaImportes = 0.0;
        while(iteradorPagos.hasNext())
        {
        	TransferPaymentItem pagoActual = iteradorPagos.next();
        	sumaImportes += pagoActual.getInstdAmt();
        }
        
		DecimalFormatSymbols simbolos = DecimalFormatSymbols.getInstance(Locale.ENGLISH);
		DecimalFormat formateador = new DecimalFormat("####.##",simbolos);
		// String InstdAmtStr = df.format(this.InstdAmt);
		return formateador.format(sumaImportes);

	}
	
	public Double getCtrlSumDouble() {
        ArrayList<TransferPaymentItem> pagos = this.getPagos();
        Iterator<TransferPaymentItem> iteradorPagos = pagos.iterator();
        double sumaImportes = 0.0;
        while(iteradorPagos.hasNext())
        {
        	TransferPaymentItem pagoActual = iteradorPagos.next();
        	sumaImportes += pagoActual.getInstdAmt();
        }
        
		return sumaImportes;

	}


	/**
	 * @return the instrPrty
	 */
	public String getInstrPrty() {
		return InstrPrty;
	}



	/**
	 * @param instrPrty the instrPrty to set
	 */
	public void setInstrPrty(String instrPrty) {
		InstrPrty = instrPrty;
	}



	/**
	 * @return the prtry_2_13
	 */
	public String getPrtry_2_13() {
		return Prtry_2_13;
	}



	/**
	 * @param prtry_2_13 the prtry_2_13 to set
	 */
	public void setPrtry_2_13(String prtry_2_13) {
		Prtry_2_13 = prtry_2_13;
	}



	/**
	 * @return the nm1
	 */
	public String getNm1() {
		return Nm1;
	}



	/**
	 * @param nm1 the nm1 to set
	 */
	public void setNm1(String nm1) {
		Nm1 = nm1;
	}



	/**
	 * @return the ctry1
	 */
	public String getCtry1() {
		return Ctry1;
	}



	/**
	 * @param ctry1 the ctry1 to set
	 */
	public void setCtry1(String ctry1) {
		Ctry1 = ctry1;
	}



	/**
	 * @return the adrLine1
	 */
	public String getAdrLine1() {
		return AdrLine1;
	}



	/**
	 * @param adrLine1 the adrLine1 to set
	 */
	public void setAdrLine1(String adrLine1) {
		AdrLine1 = adrLine1;
	}



	/**
	 * @return the bICOrBEI1
	 */
	public String getBICOrBEI1() {
		return BICOrBEI1;
	}



	/**
	 * @param bICOrBEI1 the bICOrBEI1 to set
	 */
	public void setBICOrBEI1(String bICOrBEI1) {
		BICOrBEI1 = bICOrBEI1;
	}



	/**
	 * @return the cd1
	 */
	public String getCd1() {
		return Cd1;
	}



	/**
	 * @param cd1 the cd1 to set
	 */
	public void setCd1(String cd1) {
		Cd1 = cd1;
	}



	/**
	 * @return the prtry1
	 */
	public String getPrtry1() {
		return Prtry1;
	}



	/**
	 * @param prtry1 the prtry1 to set
	 */
	public void setPrtry1(String prtry1) {
		Prtry1 = prtry1;
	}



	/**
	 * @return the issr1
	 */
	public String getIssr1() {
		return Issr1;
	}



	/**
	 * @param issr1 the issr1 to set
	 */
	public void setIssr1(String issr1) {
		Issr1 = issr1;
	}



	/**
	 * @return the birthDt1
	 */
	public Date getBirthDt1() {
		return BirthDt1;
	}



	/**
	 * @param birthDt1 the birthDt1 to set
	 */
	public void setBirthDt1(Date birthDt1) {
		BirthDt1 = birthDt1;
	}



	/**
	 * @return the prvcOfBirth1
	 */
	public String getPrvcOfBirth1() {
		return PrvcOfBirth1;
	}



	/**
	 * @param prvcOfBirth1 the prvcOfBirth1 to set
	 */
	public void setPrvcOfBirth1(String prvcOfBirth1) {
		PrvcOfBirth1 = prvcOfBirth1;
	}



	/**
	 * @return the cityOfBirth1
	 */
	public String getCityOfBirth1() {
		return CityOfBirth1;
	}



	/**
	 * @param cityOfBirth1 the cityOfBirth1 to set
	 */
	public void setCityOfBirth1(String cityOfBirth1) {
		CityOfBirth1 = cityOfBirth1;
	}



	/**
	 * @return the ctryOfBirth1
	 */
	public String getCtryOfBirth1() {
		return CtryOfBirth1;
	}



	/**
	 * @param ctryOfBirth1 the ctryOfBirth1 to set
	 */
	public void setCtryOfBirth1(String ctryOfBirth1) {
		CtryOfBirth1 = ctryOfBirth1;
	}



	/**
	 * @return the id11
	 */
	public String getId11() {
		return Id11;
	}



	/**
	 * @param id11 the id11 to set
	 */
	public void setId11(String id11) {
		Id11 = id11;
	}



	/**
	 * @return the cd11
	 */
	public String getCd11() {
		return Cd11;
	}



	/**
	 * @param cd11 the cd11 to set
	 */
	public void setCd11(String cd11) {
		Cd11 = cd11;
	}



	/**
	 * @return the prtry11
	 */
	public String getPrtry11() {
		return Prtry11;
	}



	/**
	 * @param prtry11 the prtry11 to set
	 */
	public void setPrtry11(String prtry11) {
		Prtry11 = prtry11;
	}



	/**
	 * @return the issr11
	 */
	public String getIssr11() {
		return Issr11;
	}



	/**
	 * @param issr11 the issr11 to set
	 */
	public void setIssr11(String issr11) {
		Issr11 = issr11;
	}



	/**
	 * @return the iBAN
	 */
	public String getIBAN() {
		return IBAN;
	}



	/**
	 * @param iBAN the iBAN to set
	 */
	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}



	/**
	 * @return the id111
	 */
	public String getId111() {
		return Id111;
	}



	/**
	 * @param id111 the id111 to set
	 */
	public void setId111(String id111) {
		Id111 = id111;
	}



	/**
	 * @return the ccy
	 */
	public String getCcy() {
		return Ccy;
	}



	/**
	 * @param ccy the ccy to set
	 */
	public void setCcy(String ccy) {
		Ccy = ccy;
	}



	/**
	 * @return the bIC
	 */
	public String getBIC() {
		return BIC;
	}



	/**
	 * @param bIC the bIC to set
	 */
	public void setBIC(String bIC) {
		BIC = bIC;
	}



	/**
	 * @return the id1111
	 */
	public String getId1111() {
		return Id1111;
	}



	/**
	 * @param id1111 the id1111 to set
	 */
	public void setId1111(String id1111) {
		Id1111 = id1111;
	}



	/**
	 * @return the nm
	 */
	public String getNm() {
		return Nm;
	}



	/**
	 * @param nm the nm to set
	 */
	public void setNm(String nm) {
		Nm = nm;
	}



	/**
	 * @return the ctry
	 */
	public String getCtry() {
		return Ctry;
	}



	/**
	 * @param ctry the ctry to set
	 */
	public void setCtry(String ctry) {
		Ctry = ctry;
	}



	/**
	 * @return the adrLine
	 */
	public String getAdrLine() {
		return AdrLine;
	}



	/**
	 * @param adrLine the adrLine to set
	 */
	public void setAdrLine(String adrLine) {
		AdrLine = adrLine;
	}



	/**
	 * @return the bICOrBEI
	 */
	public String getBICOrBEI() {
		return BICOrBEI;
	}



	/**
	 * @param bICOrBEI the bICOrBEI to set
	 */
	public void setBICOrBEI(String bICOrBEI) {
		BICOrBEI = bICOrBEI;
	}



	/**
	 * @return the id11111
	 */
	public String getId11111() {
		return Id11111;
	}



	/**
	 * @param id11111 the id11111 to set
	 */
	public void setId11111(String id11111) {
		Id11111 = id11111;
	}



	/**
	 * @return the cd111
	 */
	public String getCd111() {
		return Cd111;
	}



	/**
	 * @param cd111 the cd111 to set
	 */
	public void setCd111(String cd111) {
		Cd111 = cd111;
	}



	/**
	 * @return the prtry111
	 */
	public String getPrtry111() {
		return Prtry111;
	}



	/**
	 * @param prtry111 the prtry111 to set
	 */
	public void setPrtry111(String prtry111) {
		Prtry111 = prtry111;
	}



	/**
	 * @return the issr111
	 */
	public String getIssr111() {
		return Issr111;
	}



	/**
	 * @param issr111 the issr111 to set
	 */
	public void setIssr111(String issr111) {
		Issr111 = issr111;
	}



	/**
	 * @return the birthDt
	 */
	public Date getBirthDt() {
		return BirthDt;
	}



	/**
	 * @param birthDt the birthDt to set
	 */
	public void setBirthDt(Date birthDt) {
		BirthDt = birthDt;
	}



	/**
	 * @return the prvcOfBirth
	 */
	public String getPrvcOfBirth() {
		return PrvcOfBirth;
	}



	/**
	 * @param prvcOfBirth the prvcOfBirth to set
	 */
	public void setPrvcOfBirth(String prvcOfBirth) {
		PrvcOfBirth = prvcOfBirth;
	}



	/**
	 * @return the cityOfBirth
	 */
	public String getCityOfBirth() {
		return CityOfBirth;
	}



	/**
	 * @param cityOfBirth the cityOfBirth to set
	 */
	public void setCityOfBirth(String cityOfBirth) {
		CityOfBirth = cityOfBirth;
	}



	/**
	 * @return the ctryOfBirth
	 */
	public String getCtryOfBirth() {
		return CtryOfBirth;
	}



	/**
	 * @param ctryOfBirth the ctryOfBirth to set
	 */
	public void setCtryOfBirth(String ctryOfBirth) {
		CtryOfBirth = ctryOfBirth;
	}



	/**
	 * @return the id
	 */
	public String getId() {
		return Id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		Id = id;
	}



	/**
	 * @return the cd
	 */
	public String getCd() {
		return Cd;
	}



	/**
	 * @param cd the cd to set
	 */
	public void setCd(String cd) {
		Cd = cd;
	}



	/**
	 * @return the prtry
	 */
	public String getPrtry() {
		return Prtry;
	}



	/**
	 * @param prtry the prtry to set
	 */
	public void setPrtry(String prtry) {
		Prtry = prtry;
	}



	/**
	 * @return the issr
	 */
	public String getIssr() {
		return Issr;
	}



	/**
	 * @param issr the issr to set
	 */
	public void setIssr(String issr) {
		Issr = issr;
	}



	/**
	 * @return the chrgBr
	 */
	public String getChrgBr() {
		return ChrgBr;
	}



	/**
	 * @param chrgBr the chrgBr to set
	 */
	public void setChrgBr(String chrgBr) {
		ChrgBr = chrgBr;
	}



	/**
	 * @return the numeros
	 */
	public ArrayList<TransferPaymentItem> getPagos() {
		return numeros;
	}



	/**
	 * @param numeros the numeros to set
	 */
	public void setPagos(ArrayList<TransferPaymentItem> numeros) {
		this.numeros = numeros;
	}

	public String getCd_SvcLvl() {
		return Cd_SvcLvl;
	}



	public void setCd_SvcLvl(String cd_SvcLvl) {
		Cd_SvcLvl = cd_SvcLvl;
	}



	public String getCd_LclInstrm() {
		return Cd_LclInstrm;
	}



	public void setCd_LclInstrm(String cd_LclInstrm) {
		Cd_LclInstrm = cd_LclInstrm;
	}



	public String getCd_CtgyPurp() {
		return Cd_CtgyPurp;
	}



	public void setCd_CtgyPurp(String cd_CtgyPurp) {
		Cd_CtgyPurp = cd_CtgyPurp;
	}
	
	public Date getReqdExctnDt() {
		return ReqdExctnDt;
	}

	public String getReqdExctnDt2String() {
		// para mostrar este campo en el formato solicitado: dd-mm-yyyy
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String txtReqdExctnDt = df.format(ReqdExctnDt);
		return txtReqdExctnDt;
	}

	public void setReqdExctnDt(Date reqdExctnDt) {
		ReqdExctnDt = reqdExctnDt;
	}
	
	public void setReqdExctnDt(String _reqdExctnDt) {
	
			
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			//String dateInString = "Friday, Jun 7, 2013 12:10:56 PM";	
			Date sqlDate = (Date) formatter.parse(_reqdExctnDt);
			this.ReqdExctnDt = sqlDate;

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	public String getAdrLine2() {
		return AdrLine2;
	}

	public void setAdrLine2(String adrLine2) {
		AdrLine2 = adrLine2;
	}

	public String getId_Dbtr() {
		return Id_Dbtr;
	}



	public void setId_Dbtr(String id_Dbtr) {
		Id_Dbtr = id_Dbtr;
	}

}
