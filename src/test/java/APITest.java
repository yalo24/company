

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class APITest {
    Root pet1= new Root(2122,new Category(), "Gertg",null, null, null);
    Root pet2= new Root(2012, null, "DDTYHJ",null,null,null  );

    @Test
    public void first(){
  Root root = given()
                .contentType(ContentType.JSON) //устанавливаем тип контента джейсон
                .baseUri("https://petstore.swagger.io/v2") //пишем урл
          .body(pet1)
                          .when()//после него ключевые запросы
                .post("pet/")

                .as(Root.class);

        System.out.println(root.name);


    }
}

