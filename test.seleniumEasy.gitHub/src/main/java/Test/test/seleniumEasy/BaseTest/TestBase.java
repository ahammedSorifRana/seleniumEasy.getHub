package Test.test.seleniumEasy.BaseTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static WebDriver Driver ;
	public final String xbrowser = "Chrome";
	public final String webAddress ="http://www.seleniumeasy.com/test/";
	
			public final String Simple_Form_Demo ="Simple Form Demo";
			public final String Checkbox_Demo ="Checkbox Demo";
			public final String Radio_Buttons_Demo ="Radio Buttons Demo";
			public final String Select_Dropdown_List ="Select Dropdown List";
			public final String Input_Form_Submit ="Input Form Submit";
			public final String Ajax_Form_Submit ="Ajax Form Submit";
			public final String JQuery_Select_dropdown ="JQuery Select dropdown";
			public final String Bootstrap_Date_Picker ="Bootstrap Date Picker";
			public final String JQuery_Date_Picker ="JQuery Date Picker";
			public final String Table_Pagination ="Table Pagination";
			public final String Table_Data_Search ="Table Data Search";
			public final String Table_Filter ="Table Filter";
			public final String Table_Sort_Search ="Table Sort & Search";
			public final String Table_Data_Download ="Table Data Download";
	public final String NavInputForm = "Input Forms";
	public final String NavDatePicker ="Date pickers";
	public final String NavTable ="Table";
	
	/**
	 * it will get the Browser and associate Driver
	 * @param Browser
	 */
	
	public void chooseBrowser(String Browser) {
		
		switch (Browser)
			{
				case "Firefox":
					System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//Driver//geckodriver.exe");
					Driver = new FirefoxDriver();
					break;
				case"Chrome":
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Driver//chromedriver.exe");
					Driver = new ChromeDriver();
					break;
				default:
					System.out.println("Browser Not Found");
					break;
				}
				
		}
	/**
	 * It will get the URL
	 * @param URL
	 */
	public void getUrl(String URL) {
			Driver.get(URL);
			Driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			Driver.manage().window().maximize();

		}
	/**
	 * It will call two mathod 
	 * @exception it will launch Browser and launch the URL
	 * @
	 * @param Browser
	 * @param URL
	 */
	public void inIt() {
		chooseBrowser(xbrowser);
		Driver.get(webAddress);
		}
	public void closeTest() {
		Driver.close();
		}
	/**
	 * @exception get click on Navigation bar then select Manu Bar
	 * @param NavBarName
	 * @param ManuName
	 */
	public void chosseLeftManu(String NavBarName,String ManuName) {
		chosseNavigationManue(NavBarName);
		chosseManu(ManuName);
		}
	public void chosseNavigationManue(String BarName) {
		String NavXpath = "//div[@id='navbar-brand-centered']//ul[@class='nav navbar-nav']//a[contains(text(),'"+BarName+"')]";
		Driver.findElement(By.xpath(NavXpath)).click();
		}
	public void chosseManu(String ManuNames) {
		String ManuXpath = "//div[@id='navbar-brand-centered']//ul[@class='nav navbar-nav']//ul[@class='dropdown-menu']//li//a[contains(text(),'"+ManuNames+"')]";
		Driver.findElement(By.xpath(ManuXpath)).click();
		}

}
