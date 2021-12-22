import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

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
    public void NewsTest() {
        String startHandle = driver.getWindowHandle();
        List<WebElement> newList = driver.findElements(By.xpath("//div[@class='blog-article']//a"));
        newList.forEach(item -> {

            String str = item.getText();
            System.out.println(str);

            item.click();
           // try {
            //    Thread.sleep(3000);
          //  } catch (InterruptedException e) {
          //      e.printStackTrace();
          //  }
            ArrayList<String> handles = new ArrayList<>(driver.getWindowHandles());
            String lastHandle = handles.get(1);
            driver.switchTo().window(lastHandle);
            System.out.println(driver.getCurrentUrl());
            WebElement title = driver.findElement(By.xpath("//div[@class='post-title']//h1"));
            String o = title.getText();
            System.out.println(o);
            Assert.assertEquals(o, str);
            driver.close();
            driver.switchTo().window(startHandle);

        });
    }


    @Test
    public void SeachTest() {
        driver.get("https://www.monkkee.com/en/blog/");
        String text = "a321cbf8-7ac1-45a6-b804-0916195185b1";
        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"blog\"]/div/div/div[2]/div[1]"));
        element1.sendKeys(text);
               element1.submit();
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='body ']"));
        list.forEach(item -> {

            String str = item.getText();
            System.out.println(str);
            Assert.assertTrue(str.contains(text));});


    }
    @Test //ссылки из футера
    public void footerLinksTest() throws InterruptedException {
        List<WebElement> footerList = driver.findElements(By.xpath("//li[@class='footer-menu-item']"));
        footerList.forEach(item ->
                System.out.println(item.getText()));
        footerList.forEach(WebElement::click);

    }

}

