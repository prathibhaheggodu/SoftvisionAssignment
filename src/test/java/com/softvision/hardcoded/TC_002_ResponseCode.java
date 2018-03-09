
package com.softvision.hardcoded;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class TC_002_ResponseCode {

	@Test
	public void responseCode() throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException,
			IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException

	{
		int row = 1;
		ArrayList<String> urlList = new ArrayList<String>();
		urlList.add("https://www.amazon.com/");
		urlList.add("https://www.yahoo.com/");
		urlList.add("https://www.google.com/");
		urlList.add("https://www.ebay.com/");

		for (String url : urlList) {
			Response response = RestAssured.get(url);

			int respcode = response.getStatusCode();

			System.out.println(respcode);

			String path = "./exceloutput/output.xlsx";

			Workbook wb = WorkbookFactory.create(new FileInputStream(path));

			// write data to new row and new cell

			wb.getSheet("sheet1").createRow(row).createCell(1)
					.setCellValue("Response code of url " + url + " is --" + respcode);
			wb.write(new FileOutputStream("./exceloutput/output.xlsx"));
			row++;

		}
	}
}