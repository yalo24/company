import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File;
import java.util.List;
import java.util.UUID;

public class HomePageTest {
    private static final By loginInput = By.xpath(".//input[@id='login']");
    private static final By passwordInput = By.xpath(".//input[@id='password']");
    private static final By loginButton = By.xpath(".//button[@type='submit']");

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;

    @BeforeTest
    public void setUp() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        driver.get("https://my.monkkee.com/#/");
        Thread.sleep(2000);
        loginPage.find(loginInput).sendKeys(loginPage.getLogin());
        loginPage.find(passwordInput).sendKeys(loginPage.getPassword());
        loginPage.click(loginButton);
    }

    @Test
    public void addEntry() throws InterruptedException {
        waitElement(HomePage.addButton);
        homePage.find(HomePage.addButton).click();
        waitElement(HomePage.editableArea);
        String testText = UUID.randomUUID().toString();
        homePage.find(HomePage.editableArea).sendKeys(testText);
        homePage.find(HomePage.homeButton).click();
        waitElement(HomePage.itemBodyList);
        List<WebElement> elements = driver.findElements(HomePage.itemBodyList);

        boolean flag = false;

        for (WebElement element : elements) {
            if (element.getText().equals(testText))
                flag = true;
        }
        Assert.assertTrue(flag);
    }
        // найти запись
        @Test
        public void findMassage () throws InterruptedException {
            waitElement(HomePage.itemBodyList);
            homePage.find(HomePage.itemBodyList);
            String text = "xcvmbbn.,n";
            List<WebElement> list = driver.findElements(By.xpath("//div[@class='body '][contains(text(),'" + text + "')]"));
            Assert.assertTrue(list.size() > 0, "text is found");

        }
        // удалить запись
        @Test
        public void delMassage () throws InterruptedException {

            waitElement(HomePage.flagButton);
            homePage.find(HomePage.flagButton).click();
            waitElement(homePage.deleteButton);
            homePage.find(homePage.deleteButton).click();

            driver.switchTo().alert().accept();

        }

    // логаут
 //   @Test
  //  public void LogOut () throws InterruptedException {

  //      waitElement(HomePage.logOut);
   //     homePage.find(HomePage.logOut).click();


   // }



    // переход по стрелкам
    @Test
    public void putMassage () throws InterruptedException {
        waitElement(HomePage.itemBodyList);
        homePage.find(HomePage.itemBodyList).click();
        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[1]/div/a[4]"));
        element1.click();
        WebElement element2 = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[1]/div/a[5]/i"));
        element2.click();
    }



    private void waitElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }
}

                    



