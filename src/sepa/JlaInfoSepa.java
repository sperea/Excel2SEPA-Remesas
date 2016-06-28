package sepa;

import java.util.ArrayList;
import java.util.Date;

public class JlaInfoSepa {
	
	/*
	 * 
Fecha operación
Código interno de fichero
Razón Social de EMISOR
ID Fiscal Emisor
Dirección, Línea 1
Dirección, Línea 2
IBAN
BIC

	 * 
	 */
	
	private String idOperacion;
	private String rSocialEmisor;
	private String idFiscalEmisor;
	private String address1;
	private String address2;
	private String ibanEmisor;
	private String bicEmisor;
	private Date fechaOperacion;
	
	public JlaInfoSepa(String idOperacion, String rSocialEmisor, String idFiscalEmisor, String address1,
			String address2, String ibanEmisor, String bicEmisor, Date fechaOperacion) {
		super();
		this.idOperacion = idOperacion;
		this.rSocialEmisor = rSocialEmisor;
		this.idFiscalEmisor = idFiscalEmisor;
		this.address1 = address1;
		this.address2 = address2;
		this.ibanEmisor = ibanEmisor;
		this.bicEmisor = bicEmisor;
		this.fechaOperacion = fechaOperacion;
		this.transferencias = new ArrayList<JlaTransferenciaSepa>();
	}
	
	public JlaInfoSepa() {
		super();
		this.transferencias = new ArrayList<JlaTransferenciaSepa>();
	}
	
	
	private ArrayList<JlaTransferenciaSepa> transferencias;
	
	
	
	public void InsertarTransferencia (JlaTransferenciaSepa t)
	{
		this.transferencias.add(t);
	}
	
	public Date getFechaOperacion() {
		return fechaOperacion;
	}
	public void setFechaOperacion(Date fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}
	public String getIdOperacion() {
		return idOperacion;
	}
	public void setIdOperacion(String idOperacion) {
		this.idOperacion = idOperacion;
	}
	public String getrSocialEmisor() {
		return rSocialEmisor;
	}
	public void setrSocialEmisor(String rSocialEmisor) {
		this.rSocialEmisor = rSocialEmisor;
	}
	public String getIdFiscalEmisor() {
		return idFiscalEmisor;
	}
	public void setIdFiscalEmisor(String idFiscalEmisor) {
		this.idFiscalEmisor = idFiscalEmisor;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getIbanEmisor() {
		return ibanEmisor;
	}
	public void setIbanEmisor(String ibanEmisor) {
		this.ibanEmisor = ibanEmisor;
	}
	public String getBicEmisor() {
		return bicEmisor;
	}
	public void setBicEmisor(String bicEmisor) {
		this.bicEmisor = bicEmisor;
	}

	public ArrayList<JlaTransferenciaSepa> getTransferencias() {
		return transferencias;
	}
	public void setTransferencias(ArrayList<JlaTransferenciaSepa> transferencias) {
		this.transferencias = transferencias;
	}
	

}
