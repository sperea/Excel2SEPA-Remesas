package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import sepa.JlaInfoSepa;
import sepa.JlaTransferenciaSepa;

public class ExcelSepa {
	
		private String RutaExcel;
	
		public String getRutaExcel() {
			return RutaExcel;
		}

		public void setRutaExcel(String rutaExcel) {
			RutaExcel = rutaExcel;
		}
		
		public JlaInfoSepa LeerTransacciones() throws IOException
		{
			
			
			FileInputStream file = null;
			try {
				file = new FileInputStream(new File(this.getRutaExcel()));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Parece que hay un error al abrir el fichero Excel de la siguiente ruta: " . concat(this.getRutaExcel()));
				e.printStackTrace();
			}
			// Crear el objeto que tendra el libro de Excel
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			/*
			 * Obtenemos la primera pestaña a la que se quiera procesar indicando el indice. La primera pestaña contiene los datos generales del pago
			 * Una vez obtenida la hoja excel con las filas que se quieren leer obtenemos el iterator
			 * que nos permite recorrer cada una de las filas que contiene.
			 */
			HSSFSheet sheetGeneral = workbook.getSheetAt(0); /* GENERAL */
			
			
			HSSFCell cellFechaComienzo = sheetGeneral.getRow(9).getCell(3);
			Date fechaComienzo = cellFechaComienzo.getDateCellValue();
			
			HSSFCell cellCodigoInterno = sheetGeneral.getRow(10).getCell(3);
			String codigoInterno = cellCodigoInterno.getStringCellValue();
			
			HSSFCell cellRSocialEmisor = sheetGeneral.getRow(11).getCell(3);
			String rSocialEmisor = cellRSocialEmisor.getStringCellValue();
			
			HSSFCell cellIdFiscal = sheetGeneral.getRow(12).getCell(3);
			String idFiscal = cellIdFiscal.getStringCellValue();
			
			HSSFCell cellAddr1 = sheetGeneral.getRow(13).getCell(3);
			String addr1 = cellAddr1.getStringCellValue();
			
			HSSFCell cellAddr2 = sheetGeneral.getRow(14).getCell(3);
			String addr2 = cellAddr2.getStringCellValue();
			
			HSSFCell cellIban = sheetGeneral.getRow(15).getCell(3);
			String iban = cellIban.getStringCellValue();
			
			HSSFCell cellBic = sheetGeneral.getRow(16).getCell(3);
			String bic = cellBic.getStringCellValue();
			
			JlaInfoSepa infoSepa = new JlaInfoSepa();
	//		infoSepa.setFechaOperacion(fechaComienzo);
			infoSepa.setIdOperacion(codigoInterno);
			infoSepa.setrSocialEmisor(rSocialEmisor);
			infoSepa.setIdFiscalEmisor(idFiscal);
			infoSepa.setAddress1(addr1);
			infoSepa.setAddress2(addr2);
			infoSepa.setIbanEmisor(iban);
			infoSepa.setBicEmisor(bic); 
			
			//System.out.println("Codigo Interno: ".concat(codigoInterno));
			//System.out.println("Id Fiscal: ".concat(idFiscal));
			//System.out.println("Bic: ".concat(bic));

			
			HSSFSheet sheetTransferencias = workbook.getSheetAt(1); /* TRANSFERENCIAS */
			boolean fin = false;
			Iterator<Row> rowIterator = sheetTransferencias.iterator();
			Row filaTransferencias;
			int numFila = 0;
			// Recorremos todas las filas para mostrar el contenido de cada celda
			while ((rowIterator.hasNext()) && (!fin)){
					JlaTransferenciaSepa transferenciaSepa = new JlaTransferenciaSepa();
					
					filaTransferencias = rowIterator.next();
					numFila++;
					
					if (numFila > 1)
					{
						if (filaTransferencias.getCell(0).getCellType() == HSSFCell.CELL_TYPE_BLANK)
							// ya no hay más filas
								fin = true;
						else
						{
								//System.out.println(filaTransferencias.getCell(0).getStringCellValue());
								//System.out.println(filaTransferencias.getCell(1).getStringCellValue());
								//System.out.println(filaTransferencias.getCell(2).getStringCellValue());
								//System.out.println(filaTransferencias.getCell(3).getStringCellValue());
								//System.out.println(filaTransferencias.getCell(4).getStringCellValue());
								//System.out.println(filaTransferencias.getCell(5).getStringCellValue());
								transferenciaSepa.setBeneficiario(filaTransferencias.getCell(0).getStringCellValue()); 
								transferenciaSepa.setAddress1(filaTransferencias.getCell(1).getStringCellValue());
								transferenciaSepa.setAddress2(filaTransferencias.getCell(2).getStringCellValue());
								transferenciaSepa.setPais(filaTransferencias.getCell(3).getStringCellValue());
								transferenciaSepa.setIban(filaTransferencias.getCell(4).getStringCellValue());
								transferenciaSepa.setConcepto(filaTransferencias.getCell(5).getStringCellValue());
								transferenciaSepa.setImporte(filaTransferencias.getCell(6).getNumericCellValue());
								
								infoSepa.InsertarTransferencia(transferenciaSepa);
						}
					}
					
					
			}
			
			// cerramos el libro excel
			workbook.close();
			
			return infoSepa;
			
		}

		public void LeerExcel () throws IOException
		{
			FileInputStream file = null;
			try {
				file = new FileInputStream(new File(this.getRutaExcel()));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Parece que hay un error al abrir el fichero Excel de la siguiente ruta: " . concat(this.getRutaExcel()));
				e.printStackTrace();
			}
			// Crear el objeto que tendra el libro de Excel
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			/*
			 * Obtenemos la primera pestaña a la que se quiera procesar indicando el indice. La primera pestaña contiene los datos generales del pago
			 * Una vez obtenida la hoja excel con las filas que se quieren leer obtenemos el iterator
			 * que nos permite recorrer cada una de las filas que contiene.
			 */
			HSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			Row row;
			// Recorremos todas las filas para mostrar el contenido de cada celda
			while (rowIterator.hasNext()){
			    row = rowIterator.next();
			    // Obtenemos el iterator que permite recorres todas las celdas de una fila
			    Iterator<Cell> cellIterator = row.cellIterator();
			    Cell celda;
			    while (cellIterator.hasNext()){
					celda = cellIterator.next();
					// Dependiendo del formato de la celda el valor se debe mostrar como String, Fecha, boolean, entero...
					switch(celda.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
					    if( HSSFDateUtil.isCellDateFormatted(celda) ){
					       System.out.println(celda.getDateCellValue());
					    }else{
					       System.out.println(celda.getNumericCellValue());
					    }
					    System.out.println(celda.getNumericCellValue());
					    break;
					case Cell.CELL_TYPE_STRING:
					    System.out.println(celda.getStringCellValue());
					    break;
					case Cell.CELL_TYPE_BOOLEAN:
					    System.out.println(celda.getBooleanCellValue());
					    break;
					} // switch 
			    } // while
			} //while
			// cerramos el libro excel
			workbook.close();
		} // LeerExcel()
	
	    public static void main(String args[]) throws IOException{
	    	ExcelSepa e = new ExcelSepa();
	    	e.setRutaExcel("/home/sergio/test");
	    	e.LeerExcel(); /*prueba */
	    }
}
