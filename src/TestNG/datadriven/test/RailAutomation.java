package TestNG.datadriven.test;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestNG.utility.TrainUtil;

public class RailAutomation {
	
	 public static WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.get("http://hectronicafms.com/lfms/index.php");
		driver.findElement(By.id("name")).sendKeys("Superadmin");
		driver.findElement(By.id("contact")).sendKeys("Superadmin12");
		driver.findElement(By.name("login")).click();
		
		driver.findElement(By.xpath("//a[@href='../fueldelivery/index.php']")).click();
		driver.findElement(By.name("add")).click();
		
		
	}
	 
	@DataProvider
	public static Iterator<Object[]> gettraindata() {
		ArrayList<Object[]>traindata = TrainUtil.getDataFromExcel1();
		return traindata.iterator();
		
		
	}
	
	
	
	@Test(dataProvider="gettraindata")
	public void rail(String date, String storagetank, String flowmeter, String shift, String fromtime, String tilltime, String shiftmanager, String operator, String atg, String locono, String locoshed, String fuelpoint, String trainno, String traintype, String locopilotid, String locopilotname, String Inward, String Preset, String Fuelstarttime, String Fuelendtime, String Qtyissued, String OpenReading, String CloseReading, String TransactionDate, String VegaT)
	{

			
		driver.findElement(By.xpath("//input[@id='date']")).clear();
		driver.findElement(By.xpath("//input[@id='date']")).sendKeys(date);
		
		WebElement listbox = driver.findElement(By.id("storage_tank"));
		Select s=new Select(listbox);
		s.selectByValue(storagetank);
		
		driver.findElement(By.id("flow_meter")).clear();
		driver.findElement(By.id("flow_meter")).sendKeys(flowmeter);
		
		WebElement listbox1 = driver.findElement(By.id("select_shift"));
		Select se=new Select(listbox1);
		se.selectByValue(shift);
		
		driver.findElement(By.id("from_time")).clear();
		driver.findElement(By.id("from_time")).sendKeys(fromtime);
		
		driver.findElement(By.id("till_time")).clear();
		driver.findElement(By.id("till_time")).sendKeys(tilltime);
		
		driver.findElement(By.id("shift_manager")).clear();
		driver.findElement(By.id("shift_manager")).sendKeys(shiftmanager);
		
		driver.findElement(By.id("operator_name")).clear();
		driver.findElement(By.id("operator_name")).sendKeys(operator);
		
		driver.findElement(By.id("atg_start_reading")).clear();
		driver.findElement(By.id("atg_start_reading")).sendKeys(atg);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		
		driver.findElement(By.id("loco_no")).clear();
		driver.findElement(By.id("loco_no")).sendKeys(locono);
		
		driver.findElement(By.id("loco_shed")).clear();
		driver.findElement(By.id("loco_shed")).sendKeys(locoshed);
		
		WebElement listbox2 = driver.findElement(By.id("fuel_point"));
		Select list=new Select(listbox2);
		list.selectByValue(fuelpoint);
		
		driver.findElement(By.id("train_no")).clear();
		driver.findElement(By.id("train_no")).sendKeys(trainno);
		
		WebElement listbox3 = driver.findElement(By.id("train_type"));
		Select list3=new Select(listbox3);
		list3.selectByValue("traintype");
		
		driver.findElement(By.id("loco_pilot_id_no")).clear();
		driver.findElement(By.id("loco_pilot_id_no")).sendKeys(locopilotid);
		
		driver.findElement(By.id("loco_pilot_name")).clear();
		driver.findElement(By.id("loco_pilot_name")).sendKeys(locopilotname);
		
		driver.findElement(By.id("inward_balance")).clear();
		driver.findElement(By.id("inward_balance")).sendKeys(Inward);
		
		driver.findElement(By.id("preset")).clear();
		driver.findElement(By.id("preset")).sendKeys(Preset);
		
		driver.findElement(By.id("fuelling_start_time")).clear();
		driver.findElement(By.id("fuelling_start_time")).sendKeys(Fuelstarttime);
		
		driver.findElement(By.id("fuelling_stop_time")).clear();
		driver.findElement(By.id("fuelling_stop_time")).sendKeys(Fuelendtime);
		
		driver.findElement(By.id("quantity_issued")).clear();
		driver.findElement(By.id("quantity_issued")).sendKeys(Qtyissued);
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,400)");
		
		driver.findElement(By.id("opening_reading")).clear();
		driver.findElement(By.id("opening_reading")).sendKeys(OpenReading);
		
		driver.findElement(By.id("closing_reading")).clear();
		driver.findElement(By.id("closing_reading")).sendKeys(CloseReading);
		
		driver.findElement(By.id("transaction_date")).clear();
		driver.findElement(By.id("transaction_date")).sendKeys(TransactionDate);
		
		driver.findElement(By.id("vegat_srno")).clear();
		driver.findElement(By.id("vegat_srno")).sendKeys("VegaT");
		
		driver.findElement(By.xpath("//input[@id='button_action']")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		}
		
	

	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}
	
}


