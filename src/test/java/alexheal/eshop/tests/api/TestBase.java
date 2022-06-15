package alexheal.eshop.tests.api;

import alexheal.eshop.config.App;
import alexheal.eshop.helpers.allure.Layer;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;

import static com.codeborne.selenide.Selenide.open;

@Tag("api")
@Feature("api")
@Layer("api")
public class TestBase {
    @BeforeAll
    public static void beforeAll() {
        RestAssured.baseURI = App.config.apiUrl();
    }
}
