
package com.softvision.xmlparameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class TC_004_ResponseCode {

	@Parameters({"url1","url2","url3","url4","excelpath"})
	@Test
	public void responseCode(String url1,String url2,String url3,String url4,String excelpath) throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException,
			IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException

	{
		int row = 1;
		ArrayList<String> urlList = new ArrayList<String>();
		urlList.add(url1);    // "https://www.amazon.com/"
		urlList.add(url2);     // "https://www.yahoo.com/"
		urlList.add(url3);    // "https://www.google.com/"
		urlList.add(url4);      // "https://www.ebay.com/"

		for (String url : urlList) {
			Response response = RestAssured.get(url);

			int respcode = response.getStatusCode();

			System.out.println(respcode);

		   // String excelpath= "./exceloutput/output.xlsx"

			Workbook wb = WorkbookFactory.create(new FileInputStream(excelpath));

			// write data to new row and new cell

			wb.getSheet("sheet1").createRow(row).createCell(1)
					.setCellValue("Response code of url " + url + " is --" + respcode);
			wb.write(new FileOutputStream(excelpath));
			row++;

		}
	}
}