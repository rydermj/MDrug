package org.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Workbook workbook;
	public static String value;
	public static Sheet sheet;
	public static Cell cell;
	public static Actions a;
	public static Robot r;
	public static ExtentReports extentReport;
	public static ExtentHtmlReporter htmlReporter;
	
	public static void MyReport(String reportName) {
		extentReport = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter(reportName+".html");
		extentReport.attachReporter(htmlReporter);
		
	}

	public static void flush() {
		extentReport.flush();
	}
	
	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	public static void launchBrowser(String browser) {
		//RemoteWebDriver driver=null;
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.err.println("undefined browser entered.");
			break;
		}
	}

	public static void launchUrl(String siteUrl) {
		driver.get(siteUrl);
	}

	public static void maxWindow() {
		driver.manage().window().maximize();
	}

	public static void ss(String fileNameHere) throws IOException {
		TakesScreenshot ss = (TakesScreenshot) driver;
		File source = ss.getScreenshotAs(OutputType.FILE);
		File destination = new File("./screenshots/" + fileNameHere + ".png");
		FileUtils.copyFile(source, destination);
	}

	public static void input(WebElement WebElementRefName, String yourInput) {
		WebElementRefName.clear();
		WebElementRefName.sendKeys(yourInput);
	}

	public static void btnclick(WebElement element) {
		element.click();
	}

	public static WebElement myXpath(String path) {
		return driver.findElement(By.xpath(path));

	}

	public static WebElement myId(String id) {
		return driver.findElement(By.id(id));

	}
	public static WebElement myId1(String s) {
		return driver.findElement(By.id(s));
	}

	public static WebElement myCss(String cssSelector) {
		return driver.findElement(By.cssSelector(cssSelector));

	}

	public static WebElement myClassName(String className) {
		return driver.findElement(By.className(className));

	}

	public static WebElement myLinkText(String linkText) {
		return driver.findElement(By.linkText(linkText));

	}

	public static WebElement myTagName(String tagName) {
		return driver.findElement(By.tagName(tagName));

	}

	public static String getCurrentUrl() {
		return driver.getCurrentUrl();

	}

	public static String getTitle() {
		return driver.getTitle();

	}

	public static void close() {
		driver.close();
	}

	public static void quit() {
		driver.quit();

	}

	public static void impWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}

	public static void navigateForward() {
		driver.navigate().forward();
	}

	public static void navigateBackword() {
		driver.navigate().back();
	}

	public static void refresh() {
		driver.navigate().refresh();

	}
	
	public static void jclick(WebElement elementName) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", elementName);
	}

	public static void alertAccept() {
		impWait();
		driver.switchTo().alert().accept();
	}

	public static void alertcancel() {
		impWait();
		driver.switchTo().alert().dismiss();
	}

	public static void alertinput(String input) {
		impWait();
		driver.switchTo().alert().sendKeys(input);
	}

	public static String windowHandle() {
		return driver.getWindowHandle();
	}

	public static Set<String> windowHandles() {
		return driver.getWindowHandles();
	}
	
	public static WebDriver switchToWindow(int i) {
		Set<String> allWin = driver.getWindowHandles();
		List<String> li=new ArrayList<String>();
		li.addAll(allWin);
		return driver.switchTo().window(li.get(i));
	}

	public static void goDown(WebElement elementName) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", elementName);
	}

	public static void goUp(WebElement elementName) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", elementName);
	}

	public static void myExcel(String path) throws IOException {
		File file = new File(path);
		FileInputStream fileInputStream = new FileInputStream(file);
		workbook = new XSSFWorkbook(fileInputStream);

	}

	public static Cell myExcelgetCell(String path, String sheetName, int enterRow, int enterCell) throws IOException {
		File file = new File(path);
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(enterRow);
		return cell = row.getCell(enterCell);

	}

	public static void myExcelGetAllData(String sheetName) {
		sheet = workbook.getSheet(sheetName);
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row eachRows = sheet.getRow(i);
			for (int j = 0; j < eachRows.getPhysicalNumberOfCells(); j++) {
				Cell cell = eachRows.getCell(j);
				int type = cell.getCellType();
				if (type == 1) {
					String value = cell.getStringCellValue();

					System.out.println(value);
				} else {

					if (DateUtil.isCellDateFormatted(cell)) {
						Date dateCellValue = cell.getDateCellValue();
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
						String value = simpleDateFormat.format(dateCellValue);
						System.out.println(value);

					} else {
						double numericCellValue = cell.getNumericCellValue();
						// we must convert this double into string
						// for that we must first convert this double into long
						// and then long into String
						long l = (long) numericCellValue;
						String value = String.valueOf(l);
						System.out.println(value);
						/*
						 * // enhanced for loop myself completed task :) for (Row row : sheet) { for
						 * (Cell cell : row) { System.out.println(cell); } }
						 */

					}

				}
			}
		}

	}

	public static void myExcelGetAllData(String sheetName, String dateFormat) {
		sheet = workbook.getSheet(sheetName);
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row eachRows = sheet.getRow(i);
			for (int j = 0; j < eachRows.getPhysicalNumberOfCells(); j++) {
				Cell cell = eachRows.getCell(j);
				int type = cell.getCellType();
				if (type == 1) {
					String value = cell.getStringCellValue();

					System.out.println(value);
				} else {

					if (DateUtil.isCellDateFormatted(cell)) {
						Date dateCellValue = cell.getDateCellValue();
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
						String value = simpleDateFormat.format(dateCellValue);
						System.out.println(value);

					} else {
						double numericCellValue = cell.getNumericCellValue();
						// we must convert this double into string
						// for that we must first convert this double into long
						// and then long into String
						long l = (long) numericCellValue;
						String value = String.valueOf(l);
						System.out.println(value);
						/*
						 * // enhanced for loop myself completed task :) for (Row row : sheet) { for
						 * (Cell cell : row) { System.out.println(cell); } }
						 */

					}

				}
			}
		}

	}

	public static void myExcelGetAllAccountData(String sheetName, String dateFormat) {
		sheet = workbook.getSheet(sheetName);
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row eachRows = sheet.getRow(i);
			for (int j = 0; j < eachRows.getPhysicalNumberOfCells(); j++) {
				Cell cell = eachRows.getCell(j);
				int type = cell.getCellType();
				if (type == 1) {
					String value = cell.getStringCellValue();

					System.out.println(value);
				} else {

					if (DateUtil.isCellDateFormatted(cell)) {
						Date dateCellValue = cell.getDateCellValue();
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
						String value = simpleDateFormat.format(dateCellValue);
						System.out.println(value);

					} else {
						double numericCellValue = cell.getNumericCellValue();
						// we must convert this double into string
						// for that we must first convert this double into long
						// and then long into String
						// long l = (long) numericCellValue;
						String value = String.valueOf(numericCellValue);
						System.out.println(value);
						/*
						 * // enhanced for loop myself completed task :) for (Row row : sheet) { for
						 * (Cell cell : row) { System.out.println(cell); } }
						 */

					}

				}
			}
		}

	}

	public static Actions moveToElement(WebElement target) {
		a = new Actions(driver);
		a.moveToElement(target).perform();
		return a;
	}

	public static Actions dragAndDrop(WebElement source, WebElement destination) {
		a = new Actions(driver);
		a.dragAndDrop(source, destination).perform();
		return a;

	}

	public static Actions doubleClick() {
		a = new Actions(driver);
		a.doubleClick().perform();
		;
		return a;
	}

	public static Actions doubleClick(WebElement target) {
		a = new Actions(driver);
		a.doubleClick(target).perform();
		;
		return a;
	}

	public static Actions contextClick() {
		a = new Actions(driver);
		a.contextClick().perform();
		;
		return a;

	}

	public static Actions contextClick(WebElement target) {
		a = new Actions(driver);
		a.contextClick(target).perform();
		;
		return a;

	}

	public static void upArrow(int times) throws AWTException {
		r = new Robot();
		for (int i = 0; i < times; i++) {
			r.keyPress(KeyEvent.VK_UP);
			r.keyRelease(KeyEvent.VK_UP);
		}

	}

	public static void downArrow(int times) throws AWTException {
		r = new Robot();
		for (int i = 0; i < times; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}

	}

	public static void enterKey() throws AWTException {
		r = new Robot();

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

	public static void tabKey(int times) throws AWTException {
		r = new Robot();
		for (int i = 0; i < times; i++) {
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
		}
	}

	public static void tabKey() throws AWTException {
		r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);

	}

	public static void shiftKeyPress() throws AWTException {
		r = new Robot();

		r.keyPress(KeyEvent.VK_SHIFT);
		

	}

	public static void ShiftKeyRelease() throws AWTException {
		r = new Robot();

		r.keyRelease(KeyEvent.VK_SHIFT);

	}
	public static void capsLockOff() throws AWTException {
		r = new Robot();

		r.keyPress(KeyEvent.VK_CAPS_LOCK);

	}

	public static void capsLockOn() throws AWTException {
		r = new Robot();

		r.keyRelease(KeyEvent.VK_CAPS_LOCK);

	}

}
