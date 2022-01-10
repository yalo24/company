import io.restassured.http.ContentType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APIexam {
  Root4 pet1= new Root4(2122, "Fit", "КПир", "egf", null, null, null, 12);


    @Test
    public void first(){

        Root4 root4 = given()
                .contentType(ContentType.JSON) //устанавливаем тип контента джейсон
                .baseUri("petstore.swagger.io/v2") //пишем урл
                .body(pet1)
                .when()//после него ключевые запросы
                .post("user/")

                .as(Root4.class);

        System.out.println(root4.firstName);


    }
}


