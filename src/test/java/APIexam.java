import io.restassured.http.ContentType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APIexam {
  Root4 pet1= new Root4(0, "ssd", "ssss", "sss", null, null, null, 0);

  Root4 [] array = new Root4[]{pet1};


    @Test
    public void first(){

        Root5 root5 = given()
                .contentType(ContentType.JSON) //устанавливаем тип контента джейсон
                .baseUri("https://petstore.swagger.io/v2") //пишем урл
                .body(array)
                .when()//после него ключевые запросы
                .post("/user/createWithArray")
                .as(Root5.class);

        System.out.println(root5.code+" "+root5.message);
        Assert.assertEquals(root5.code, 200);
        Assert.assertEquals(root5.message, "ok");


    }
}


