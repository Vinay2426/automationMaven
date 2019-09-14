package TestAutomationMaven;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Registration
{
    protected static WebDriver driver;

    public String generateEmail(String startValue)      //this method will add new number to email every time you run so there will be new email each time
    {
        String email = startValue.concat(new Date().toString());
        //your code
        return  email;
    }
    public static String randomDate()       //this method will add new number to email every time you run so there will be new email each time
    {
        DateFormat format = new SimpleDateFormat("ddMMyyHHmmss");
        return format.format(new Date());
    }

    @BeforeMethod               //will execute before every method
    public void openBrowser()
    {
        System.setProperty("webdriver.chrome.driver", "src\\main\\Resources\\BrowserDriver\\chromedriver.exe");

        //open the browser
        driver = new ChromeDriver();
        //maximise the browser window screen
        //driver.manage().window().fullscreen();
        driver.manage().window().maximize();
        //set implicit wait fro driver object
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //open the website
        driver.get("https://demo.nopcommerce.com/");
    }

    @AfterMethod                //will execute at the end of every method
    public void closeBrowser()
    {
        driver.close();      //will close the open browser
    }

    @Test
        public void registerAccount()       //account registration method has being done already in beforemethod here it will just compare the result
    {
        //click on register button
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        //enter firstname
        driver.findElement(By.id("FirstName")).sendKeys("Venus");
        //enter lastname
        driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("Patel");
        //enter email
        driver.findElement(By.name("Email")).sendKeys("test"+randomDate()+"@test.com");
        //Thread.sleep(2000); //it will wait for 2 seconds and will give result.
        //enter the password
        driver.findElement(By.id("Password")).sendKeys("test123");
        //confirm password
        driver.findElement(By.id("ConfirmPassword")).sendKeys("test123");
        //click on register to register the account
        driver.findElement(By.name("register-button")).click();

        String ExpectedResult = "Your registration completed";
        String ActualResult = driver.findElement(By.xpath("//div[@class='result']")).getText();
        Assert.assertEquals(ActualResult,ExpectedResult);
    }
    @Test
        public void emailAFriend()
    {
        //click on register button
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        //enter firstname
        driver.findElement(By.id("FirstName")).sendKeys("Venus");
        //enter lastname
        driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("Patel");
        //enter email
        driver.findElement(By.name("Email")).sendKeys("test"+randomDate()+"@test.com");
        //Thread.sleep(2000); //it will wait for 2 seconds and will give result.
        //enter the password
        driver.findElement(By.id("Password")).sendKeys("test123");
        //confirm password
        driver.findElement(By.id("ConfirmPassword")).sendKeys("test123");
        //click on register to register the account
        driver.findElement(By.name("register-button")).click();
        //click on continue and it will lead to the homepage
        driver.findElement(By.xpath("//input[@name='register-continue']")).click();
        driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']//div[@class='item-grid']//div[2]//div[1]//div[1]//a[1]//img[1]")).click();
        //click on email a friend
        driver.findElement(By.xpath("//input[@value='Email a friend']")).click();
        //fill friend's email address
        driver.findElement(By.id("FriendEmail")).sendKeys("testtest123456@test.com");
        //fill personal message
        driver.findElement(By.name("PersonalMessage")).sendKeys("This very good deal mate, don't need to miss it. go ahead and buy it");
        //click on send email
        driver.findElement(By.name("send-email")).click();
        //message end of the process
        String ExpectedResult = "Email a friend";
        //message locator
        String ActualResult = driver.findElement(By.xpath("//h1")).getText();
        //compare Actual result to expected result
        Assert.assertEquals(ActualResult,ExpectedResult);
    }
    @Test
    public void selectCameraAndPhoto()
    {
        //click on register button
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        //enter firstname
        driver.findElement(By.id("FirstName")).sendKeys("Venus");
        //enter lastname
        driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("Patel");
        //enter email
        driver.findElement(By.name("Email")).sendKeys("test"+randomDate()+"@test.com");
        //Thread.sleep(2000); //it will wait for 2 seconds and will give result.
        //enter the password
        driver.findElement(By.id("Password")).sendKeys("test123");
        //confirm password
        driver.findElement(By.id("ConfirmPassword")).sendKeys("test123");
        //click on register to register the account
        driver.findElement(By.name("register-button")).click();
        //click on continue and it will lead to the homepage
        driver.findElement(By.xpath("//input[@name='register-continue']")).click();
        //select on Electrics
        driver.findElement(By.xpath("//h2[@class='title']//a[contains(text(),'Electronics')]")).click();
        //click on Camera & photo
        driver.findElement(By.xpath("//img[@alt='Picture for category Camera & photo']")).click();
        //message end of the process
        String ExpectedResult = "Camera & photo";
        //locator for actual result
        String ActualResult = driver.findElement(By.xpath("//h1[contains(text(),'Camera & photo')]")).getText();
        //compare the actual with expected result
        Assert.assertEquals(ActualResult,ExpectedResult);
    }
    @Test
    public void userShouldBeFilterJewellery()
    {
        //click on register button
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        //enter firstname
        driver.findElement(By.id("FirstName")).sendKeys("Venus");
        //enter lastname
        driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("Patel");
        //enter email
        driver.findElement(By.name("Email")).sendKeys("test"+randomDate()+"@test.com");
        //Thread.sleep(2000); //it will wait for 2 seconds and will give result.
        //enter the password
        driver.findElement(By.id("Password")).sendKeys("test123");
        //confirm password
        driver.findElement(By.id("ConfirmPassword")).sendKeys("test123");
        //click on register to register the account
        driver.findElement(By.name("register-button")).click();
        //click on continue and it will lead to the homepage
        driver.findElement(By.xpath("//input[@name='register-continue']")).click();
        //select jewllery option
        driver.findElement(By.linkText("Jewelry")).click();
        //click on Filter by price $700-$3000
        driver.findElement(By.xpath("//a[contains(@href, '700-3000')]")).click();

        //comparing actual and expected result
        String Expectedresult="$700.00 - $3,000.00";
        String Actualresult= driver.findElement(By.xpath("//span[@class='item']")).getText();
        Assert.assertEquals(Actualresult,Expectedresult);
        String Productprice=driver.findElement(By.xpath("//span[@class='price actual-price']")).getText();

        String price1=String.valueOf(Productprice.replace("$",""));
        String price2=String.valueOf(price1.replace(",",""));
        double price=Double.valueOf(price2);

        Assert.assertTrue(price>=700 && price<=3000);
    }
    @Test
    public void AddBooksToShoppingBasket() throws InterruptedException
    {
        //click on register button
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        //enter firstname
        driver.findElement(By.id("FirstName")).sendKeys("Venus");
        //enter lastname
        driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("Patel");
        //enter email
        driver.findElement(By.name("Email")).sendKeys("test"+randomDate()+"@test.com");
        //Thread.sleep(2000); //it will wait for 2 seconds and will give result.
        //enter the password
        driver.findElement(By.id("Password")).sendKeys("test123");
        //confirm password
        driver.findElement(By.id("ConfirmPassword")).sendKeys("test123");
        //click on register to register the account
        driver.findElement(By.name("register-button")).click();
        //click on continue and it will lead to the homepage
        driver.findElement(By.xpath("//input[@name='register-continue']")).click();
        //click(select) Books category
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/books']")).click();
        //add first book to cart
        driver.findElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//input[1]")).click();
        //pause for few seconds
        Thread.sleep(2000);
        //add second book to cart
        driver.findElement(By.xpath("//div[@class='page-body']//div[2]//div[1]//div[2]//div[3]//div[2]//input[1]")).click();
        Thread.sleep(5000);
        //click on Shopping cart
        driver.findElement(By.xpath("//span[@class='cart-label']")).click();
        //to check the result we will compare the two books cost with actual cost of the books
        String ExpectedResult = "$78.00";
        //locator for actual result
        String ActualResult = driver.findElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$78.00')]")).getText();
        //compare the actual with expected result
        Assert.assertEquals(ActualResult,ExpectedResult);
    }
}