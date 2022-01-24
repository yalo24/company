

import io.restassured.http.ContentType;
import org.asynchttpclient.Response;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.lang.reflect.Type;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.rootPath;

public class APITest {
    private static String requestBody = "{\n" +
            "    \"name\": \"morpheus\",\n" +
            "    \"job\": \"leader\"\n" +
            "}";

    Root3 user = new Root3("Uffcy", "sing", "2345", null);

  /*  @Test
    public void first() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
              Root root = given()
                .contentType(ContentType.JSON) //устанавливаем тип контента джейсон
                .when()//после него ключевые запросы
                .get("https://reqres.in/api/users?page=2") //LIST USERS
                .as(Root.class);
        System.out.println(root.page);
        System.out.println(root.total_pages);
        for (int i = 0; i < root.data.size(); i++) {
            Datum d = root.data.get(i);
            System.out.println(d.avatar);
            WebDriver driver = new ChromeDriver();
            driver.get(root.data.get(i).avatar);
            driver.close();
                    }
    }
}*/

    @Test
    public void first2() {
        /*Root root =*/
         given()
                .contentType(ContentType.JSON) //устанавливаем тип контента джейсон
                .when()//после него ключевые запросы
                .get("https://reqres.in/api/users/2")
    .then().statusCode(200);//SINGLE USER
                //.as(Root.class);
        //System.out.println(root.page);
        //System.out.println(root.support.text);

    }

    @Test
    public void first3() {
        Root root = given()
                .contentType(ContentType.JSON) //устанавливаем тип контента джейсон
                .when()//после него ключевые запросы
                .get("https://reqres.in/api/users/23") //SINGLE USER NOT FOUND
                .as(Root.class);
        System.out.println(root.page);
        System.out.println(root.toJson());

    }

    @Test
    public void first4() {
        Root1 root1 = given()
                .contentType(ContentType.JSON) //устанавливаем тип контента джейсон
                .when()//после него ключевые запросы
                .get("https://reqres.in/api/unknown") //LIST <RESOURCE>
                .as(Root1.class);
        System.out.println(root1.page);
        System.out.println(root1.total_pages);
        for (int i = 0; i < root1.data.size(); i++) {
            Datum1 d = root1.data.get(i);
            System.out.println(d.color);
        }
        System.out.println(root1.data.get(3).pantone_value);
    }

    @Test
    public void first5() {
        Root2 root2 = given()
                .contentType(ContentType.JSON) //устанавливаем тип контента джейсон
                .when()//после него ключевые запросы
                .get("https://reqres.in/api/unknown/2") //SINGLE <RESOURCE>
                .as(Root2.class);
        System.out.println(root2.data.name);
        System.out.println(root2.support.url);

    }

    @Test
    public void first6() {
        Root3 root3= given()
                .contentType(ContentType.JSON) //устанавливаем тип контента джейсон
                .baseUri("https://reqres.in") //пишем урл
                .body(user)
                .when()
                .post("api/users")
                .body()
                .as(Root3.class);

        System.out.println(root3.name);

    }
    @Test
    public void first7() {
        Root3 root3= given()
                .contentType(ContentType.JSON) //устанавливаем тип контента джейсон
                .baseUri("https://reqres.in") //пишем урл
                .body(user)
                .when()
                .post("api/users")
                .body()
                .as(Root3.class);

        System.out.println(root3.name);

    }
}






