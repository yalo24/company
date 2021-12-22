

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITest {
    @Test
    public void first(){

        given()
                .contentType(ContentType.JSON) //устанавливаем тип контента джейсон
                .baseUri("http://swanger.io/y2") //пишем урл

                .when()//после него ключевые запросы
                .get("pet/findByStatus?status=sold")
                .body()

                .prettyPrint();


    }
}
