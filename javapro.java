package newjava;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class javapro {
	public static WebDriver driver;
	static String deidentifiedid1;

	public static void main(String[] args) throws InterruptedException {
		
		chromeIntialize();
		login();
		createPatient();
		scheduleinsurancesubmission();
		markimplantcomplete();
		navigatetopatienttab();
		searchcreatedpatient();
		removecreatedpatient();
		System.out.println("Scenario Executed Successfully");
		driver.close();
		
	}
		
	
	
	public static void chromeIntialize() {
		
		//Initialize Chrome driver and open QA Inspire Clinician Portal	
		
		System.setProperty("webdriver.chrome.driver","C:\\Selenium Setup\\chromedriver_win32\\chromedriver.exe");  
		driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://qa-portal.inspiresleep.net/");
	}

	
	
	public static void login () throws InterruptedException {	
	    
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	    // Click on Login button in QA Inspire Clinician Portal
		
	    WebElement Loginbutton = driver.findElement(By.xpath("//button[@class='btn btn--secondary btn--lg btn--flat']"));
	    Loginbutton.click();
	    
	    
	    // Enter login credentials
	    
	    WebElement signin = driver.findElement(By.xpath("//input[@id='signInName']"));
	    WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
	    WebElement  submit = driver.findElement(By.xpath("//button[@id='next']"));
	   
	    signin.sendKeys("stp2cob@rbeigcn.com"); 
	    password.sendKeys("Maanu_123");
	    submit.click();	
	    
	    
	    WebElement clinician = driver.findElement(By.xpath("//span[@class='user-menu__primary-details__name']"));
	    String clinician1 = clinician.getText();
	    WebElement practice = driver.findElement(By.xpath("//header/div[1]/div[4]/div[1]/span[2]"));
	    String practice1 = practice.getText();
	    System.out.println("Logged in as " + clinician1 + " & default practice selected is " + practice1);
	    
	}
	
	public static void createPatient() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Click on Patients tab
		
		WebElement patienttab = driver.findElement(By.xpath("//a[@id='test-header-nav-patients']"));
		patienttab.click();
		
		
		// Click on Add Patient button
		
		WebElement addpatbutton1 = driver.findElement(By.xpath("//button[@id='test-patients-header-add-patient']"));
		addpatbutton1.click();
		
		
		// Enter patient details like First name & last name
		
		WebElement firstname = driver.findElement(By.xpath("//body/div[@id='react-app']/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/span[1]/input[1]"));
		firstname.sendKeys("MOD8");
		
		WebElement lastname = driver.findElement(By.xpath("//body/div[@id='react-app']/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/span[1]/input[1]"));
		lastname.sendKeys("GURU");
		
		// Fetch De-identified ID and store it as String
		
		WebElement deidentifiedid = driver.findElement(By.xpath("//body/div[@id='react-app']/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[2]/div[2]/div[1]/span[1]/input[1]"));
		deidentifiedid1 = deidentifiedid.getAttribute("value");
		
		// Enter patient details like Phone number, Email address & Confirm Email address
		
		WebElement phonenumber = driver.findElement(By.xpath("//body/div[@id='react-app']/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/span[1]/input[1]"));
		phonenumber.sendKeys("8045001324");
		
		WebElement emailaddress = driver.findElement(By.xpath("//body/div[@id='react-app']/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[2]/div[1]/div[1]/span[1]/input[1]"));
		emailaddress.sendKeys("000004mguru@yopmail.com");
		
		WebElement confirmemailaddress = driver.findElement(By.xpath("//body/div[@id='react-app']/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[2]/div[1]/div[2]/div[1]/span[1]/input[1]"));
		confirmemailaddress.sendKeys("000004mguru@yopmail.com");	
		
		// Click on Add patient button in the pop-up
		
		WebElement addpatbutton2 = driver.findElement(By.xpath("(//div[@class='modal__footer']//button[@class='btn btn--secondary btn--flat'])[2]"));
		addpatbutton2.click();
		
		// Fetch notification message & display
		
		WebElement notification2 = driver.findElement(By.xpath("//body/div[@id='react-app']/div[1]/div[1]/div[1]/div[2]/div[1]"));
		String notification3 = notification2.getText();
		System.out.println(notification3);
		
	}
	    
	public static void scheduleinsurancesubmission() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Moving to Insurance Submission in timeline
		
		WebElement insurancesubmission = driver.findElement(By.xpath("//body/div[@id='react-app']/div[1]/div[2]/div[1]/div[3]/div[12]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[3]/div[1]/div[2]"));
		insurancesubmission.click();
		
		// Clicking on Add details button in Insurance Submission
		
		WebElement adddetails = driver.findElement(By.xpath("//body/div[@id='react-app']/div[1]/div[2]/div[1]/div[3]/div[12]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[3]/div[1]/div[3]/div[1]/button[1]"));
		adddetails.click();
		
		WebElement datepicker = driver.findElement(By.xpath("//input[@class='form-control__input form-control__input--filled form-control__input--valid form-control__input--flat form-control__input--readOnly']"));
		datepicker.click();
		
		// To select date as current date + 3 days
		
		WebElement selectdate = driver.findElement(By.xpath("(//button[contains(@class,'react-calendar__tile--active')]//following::button)[3]"));
		selectdate.click();
		
		// Enter notes
		
		WebElement notes = driver.findElement(By.xpath("//textarea[@placeholder='Add a note to share with the patient’s care team…']"));
		notes.sendKeys("Executing Automation Scenario");
		
		// Click on Save button
		
		WebElement savebutton = driver.findElement(By.xpath("(//button[contains(text(),'Save')])[15]"));
		savebutton.click();
		
		// Fetch notification message & display
		
		WebElement notification = driver.findElement(By.xpath("//body/div[@id='react-app']/div[1]/div[1]/div[1]/div[2]/div[1]"));
		String notification1 = notification.getText();
		System.out.println(notification1 + " for Insurance Submission");
		
	}
	
	public static void markimplantcomplete() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Mark Implant complete & click on Save & Notify care team
		
		WebElement implant = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[12]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]"));
		Actions action2 = new Actions(driver);
		action2.moveToElement(implant).click().perform();
			
		WebElement adddetails1 = driver.findElement(By.xpath("//body/div[@id='react-app']/div[1]/div[2]/div[1]/div[3]/div[12]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[3]/div[1]/button[1]"));
		adddetails1.click();
			
		WebElement markcomplete = driver.findElement(By.xpath("//button[contains(text(),'Mark completed')]"));
		markcomplete.click();
			
		WebElement saveandnotifycareteam = driver.findElement(By.xpath("//body/div[@id='react-app']/div[1]/div[2]/div[1]/div[3]/div[8]/div[1]/div[1]/div[3]/div[3]/button[3]"));
		saveandnotifycareteam.click();
		
		WebElement notification = driver.findElement(By.xpath("//span[contains(text(),'Implant: Marked complete')]"));
		String notification1 = notification.getText();
		System.out.println(notification1);
			
	}
	
	public static void navigatetopatienttab() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Click on Patients tab
		
		WebElement patienttab = driver.findElement(By.xpath("//a[@id='test-header-nav-patients']"));
		patienttab.click();
		Thread.sleep(4000);
		
	}
		
	public static void searchcreatedpatient() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Enter De-identified id of created patient in search patients field
		Thread.sleep(3000);
		WebElement searchpatients = driver.findElement(By.xpath("//input[@id='test-patients-header-search']"));
		searchpatients.click();
		searchpatients.sendKeys(deidentifiedid1);
		
		// Click on search button
		
		WebElement searchbutton = driver.findElement(By.xpath("//button[@id='test-patients-header-search-patient']"));
		searchbutton.click();
		
		// Enter Patient details page 
		
		WebElement enterpatient = driver.findElement(By.xpath("//div[@class='patients-grid__patient-name']"));
		enterpatient.click();
		
	}
	
	public static void removecreatedpatient() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Click on Edit patient button
		
		WebElement editpatientbutton = driver.findElement(By.xpath("//button[@title='Edit patient']"));
		editpatientbutton.click();
		
		// Scroll down the page till remove patient element is found
		
		WebElement removepatientbutton = driver.findElement(By.xpath("//button[contains(text(),'Remove patient')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", removepatientbutton);
		removepatientbutton.click();
		
		// Click on "Yes, delete" button to remove the patient
		
		WebElement yesdeletebutton = driver.findElement(By.xpath("//body/div[@id='react-app']/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/button[2]"));
		yesdeletebutton.click();
		
		// Fetch notification message & display
		
		WebElement notification = driver.findElement(By.xpath("//body/div[@id='react-app']/div[1]/div[1]/div[1]/div[2]/div[1]"));
		String notification1 = notification.getText();
		System.out.println(notification1);
	
	}

}
