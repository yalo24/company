import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest {
    WebDriver driver;
    LoginPage loginPage;
    private static final By loginInput=By.xpath(".//input[@id='login']");
    private static final By passwordInput=By.xpath(".//input[@id='password']");
    private static final By loginButton=By.xpath(".//button[@type='submit']");
    private static final By News1=By.xpath("//*[@id=\"blog-articles\"]/div[2]/a']");
    @BeforeTest
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage=new LoginPage(driver);
        driver.get("https://my.monkkee.com/#/");
        Thread.sleep(3000);

    }
    @Test
    public void loginTest(){
        loginPage.find(loginInput).sendKeys(loginPage.getLogin());
        loginPage.find(passwordInput).sendKeys(loginPage.getPassword());
        loginPage.click(loginButton);
    }
    @Test
    public void NewsTest(){


       /* WebElement News1 = driver.findElement(By.xpath("//*[@id=\"blog-articles\"]/div[1]/a"));
        News1.click();
        Assert.assertEquals(News1.getText(), "Eating your own dog food");
        WebElement News2 = driver.findElement(By.xpath("//*[@id=\"blog-articles\"]/div[2]/a"));
        News2.click();
        Assert.assertEquals(News2.getText(), "5 ideas how to use coloured tags");
        WebElement News3 = driver.findElement(By.xpath("//*[@id=\"blog-articles\"]/div[3]/a"));
        News3.click();
        Assert.assertEquals(News3.getText(), "New: Timestamp function");
        WebElement News4 = driver.findElement(By.xpath("//*[@id=\"blog-articles\"]/div[4]/a"));
        News4.click();
        Assert.assertEquals(News4.getText(), "Why you must never forget your monkkee password!!");
        WebElement News5 = driver.findElement(By.xpath("//*[@id=\"blog-articles\"]/div[5]/a"));
        News5.click();
        Assert.assertEquals(News5.getText(), "Why monkkee won’t launch an app in the near future");*/
    }
    @Test
    public void SeachTest() {
        driver.get("https://www.monkkee.com/en/blog/");
        WebElement element1 = driver.findElement(By.xpath("//input[@id=\"s\"]"));
        element1.sendKeys("Why you must never forget your monkkee password!!");
        element1.submit();

    }
}
