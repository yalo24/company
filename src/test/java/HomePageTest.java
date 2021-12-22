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
        waitElement(By.xpath("//*[@id=\"cke_46\"]/span[1]"));
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
        public void SeachTest() throws InterruptedException {
         //   driver.get("https://www.monkkee.com/en/blog/");
            Thread.sleep(5000);
            String text = "a321cbf8-7ac1-45a6-b804-0916195185b1";
            WebElement element1 = driver.findElement(By.xpath("//*[@id=\"appendedInputButton\"]"));
            element1.sendKeys(text);
            element1.submit();
            Thread.sleep(2000);
            List<WebElement> list = driver.findElements(By.xpath("//div[@class='body ']"));
            list.forEach(item -> {

                String str = item.getText();
                System.out.println(str);
                Assert.assertTrue(str.contains(text));});

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

                    



