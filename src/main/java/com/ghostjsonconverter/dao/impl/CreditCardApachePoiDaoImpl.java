package com.ghostjsonconverter.dao.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.ghostjsonconverter.dao.CreditCardDao;
import com.ghostjsonconverter.model.CreditCard;

public class CreditCardApachePoiDaoImpl implements CreditCardDao {
	
	private static String XLSX_FILE_PATH = "CardFile.xlsx";
	private static String CARD_TYPE = "Visa";
	
	private static int NAME_INDEX = 0;
	private static int CARD_NUMBER_INDEX = 1;
	private static int EXPIRY_MONTH_INDEX = 2;
	private static int EXPIRY_YEAR_INDEX = 3;
	private static int CVV_INDEX = 4;
	
	private DataFormatter dataFormatter = new DataFormatter();
	@Override
	public List<CreditCard> getAll() {
		
		List<CreditCard> creditCards = new ArrayList<>();
		Workbook workbook;
		try {
			workbook = WorkbookFactory.create(new File(XLSX_FILE_PATH));
		
		
			if (workbook != null) {
				Sheet sheet = workbook.getSheetAt(0);
				
				CreditCard creditCard = null;
				Iterator<Row> rowIterator = sheet.rowIterator();
				
				while (rowIterator.hasNext()) {
					
					Row row = rowIterator.next();
					// skip header
					if (row.getRowNum() == 0) {
						continue;
					}
					creditCard = new CreditCard();
					creditCard.setName(getCellAsString(row.getCell(NAME_INDEX)));
					creditCard.setCardNumber(getCellAsString(row.getCell(CARD_NUMBER_INDEX)));
					creditCard.setExpiryMonth(getCellAsString(row.getCell(EXPIRY_MONTH_INDEX)));
					creditCard.setExpiryYear(getCellAsString(row.getCell(EXPIRY_YEAR_INDEX)));
										
					// card type is currently static
					creditCard.setCardType(CARD_TYPE);
					
					creditCards.add(creditCard);
				}
			}
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			System.err.println("Error fetching credit cards.");
		}
		
		return creditCards;
	}
	
	private String getCellAsString(Cell cell) {
		String value = dataFormatter.formatCellValue(cell);
		return value;
	}

}
