import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.Random;

public class LesTest {



    private static void accept(WebElement item) {
        String str = item.getText();
        System.out.println(str);
        item.click();
    }

    @Test
    public void first() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"content\"]/div/button"));
        element.click();
        WebElement deleteButton = driver.findElement(By.xpath("//*[@class=\"added-manually\"]"));

        Assert.assertEquals(deleteButton.getText(), "Delete");

    }

    @Test
    public void first2() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"dropdown\"]"));
        element1.click();
        WebElement Ops2 = driver.findElement(By.xpath("//*//*[@id=\"dropdown\"]/option[3]"));
        Ops2.click();
        Assert.assertEquals(Ops2.getText(), "Option 2");
    }

    @Test
    public void first3() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://onliner.by/");
        WebElement element3 = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/header/div[2]/div/nav/ul[1]/li[3]/a[2]"));
        element3.click();
        WebElement element4 = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div/div/div/div[2]/div/div/div[3]/div/div[2]/div[2]/div[2]/div[2]/div/div[2]/div[1]/div/div/div[1]"));
        element4.click();
        WebElement element5 = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div/div/div/div[2]/div/div/div[3]/div/div[2]/div[2]/div[2]/div[2]/div/div[2]/div[1]/div/div/div[1]/div/div[2]/div[2]/div/div[2]/ul/li[7]/label"));
        element5.click();
        List<WebElement> newList = driver.findElements(By.xpath("//ul[@class='vehicle-form_offers']/div[3]/div/a"));
            System.out.println(newList.size());
      System.out.println(newList.get(12));

        }


    @Test
    public void first4() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://onliner.by/");
        WebElement element3 = driver.findElement(By.xpath("//*[@id=\"fast-search\"]/form/input[1]"));
        System.out.println(element3.getAttribute("placeholder").contains("Поиск в Каталоге. Например,"));

        /* element3.getAttribute("placeholder").contains("Поиск в Каталоге. Например,");*/
        Assert.assertTrue(element3.getAttribute("placeholder").contains("Поиск в Каталоге. Например,"));

    }

    @Test
    public void first5() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        long beforeSize = getFolderSize();
        driver.get("https://the-internet.herokuapp.com/download");
        Random random = new Random();
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='example']//a"));
        list.get(random.nextInt(list.size())).click();

        long afterSize = getFolderSize();
        Assert.assertTrue(beforeSize == afterSize);
    }

    private long getFolderSize() {
        String folderPath = "C:\\Users\\st.ITSTEP";
        File file = new File(folderPath);
        long length = 0;
        for (int i = 0; i < file.list().length; i++) {
            File tmp = new File(folderPath + "\\" + file.list()[i]);
            length += tmp.length();
            System.out.println(file.list()[i] + "------------" + tmp.length());
        }
        return length;
    }


}



