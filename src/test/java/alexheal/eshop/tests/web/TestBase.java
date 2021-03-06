package alexheal.eshop.tests.web;

import alexheal.eshop.config.Project;
import alexheal.eshop.helpers.allure.AllureAttachments;
import alexheal.eshop.drivers.UIWebDriver;
import alexheal.eshop.helpers.DriverUtils;
import alexheal.eshop.helpers.allure.Layer;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({ScreenShooterExtension.class})
@Feature("web")
@Layer("web")
@Tags({@Tag("web"), @Tag("all")})
public class TestBase {
    @BeforeAll
    static void beforeAll() {
        if(!SelenideLogger.hasListener("AllureSelenide"))
            SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        UIWebDriver.configure();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = DriverUtils.getSessionId();

        AllureAttachments.addScreenshotAs("Last screenshot");
        AllureAttachments.addPageSource();
        AllureAttachments.addBrowserConsoleLogs();

        Selenide.closeWebDriver();

        if (Project.isVideoOn()) {
            AllureAttachments.addVideo(sessionId);
        }
    }
}
