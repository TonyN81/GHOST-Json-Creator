package com.ghostjsonconverter.dao.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EmptyFileException;
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
	
	private static String XLSX_FILE_PATH = "src/main/resources/CardFile.xlsx";
	private static String CARD_TYPE = "Visa";
	@Override
	public List<CreditCard> getAll() {
		
		List<CreditCard> creditCards = new ArrayList<>();
		Workbook workbook;
		try {
			workbook = WorkbookFactory.create(new File(XLSX_FILE_PATH));
		
		
			if (workbook != null) {
				Sheet sheet = workbook.getSheetAt(0);
				DataFormatter dataFormatter = new DataFormatter();
				
				CreditCard creditCard = null;
				Iterator<Row> rowIterator = sheet.rowIterator();
				while (rowIterator.hasNext()) {
					
					creditCard = new CreditCard();
					
					Row row = rowIterator.next();
					Cell nameCell = row.getCell(0);
					String name = dataFormatter.formatCellValue(nameCell);
					creditCard.setName(name);
					
					Cell numberCell = row.getCell(1);
					String number = dataFormatter.formatCellValue(numberCell);
					creditCard.setCardNumber(number);
					
					Cell expiryMonthCell = row.getCell(2);
					String expiryMonth = dataFormatter.formatCellValue(expiryMonthCell);
					creditCard.setExpiryMonth(expiryMonth);
					
					Cell expiryYearCell = row.getCell(3);
					String expiryYear = dataFormatter.formatCellValue(expiryYearCell);
					creditCard.setExpiryYear(expiryYear);
					
					Cell cvvCell = row.getCell(4);
					String cvv = dataFormatter.formatCellValue(cvvCell);
					creditCard.setCvv(cvv);
					
					// card type is currently static
					creditCard.setCardType(CARD_TYPE);
					
					creditCards.add(creditCard);
				}
			}
		} catch (EncryptedDocumentException | InvalidFormatException | IOException | EmptyFileException e) {
			System.err.println("Error fetching credit cards.  Make sure xlsx file is present.");
			//e.printStackTrace();
		}
		
		return creditCards;
	}

}
