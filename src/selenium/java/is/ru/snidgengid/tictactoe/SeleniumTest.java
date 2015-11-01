package is.ru.snidgengid.tictactoe;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import java.util.regex.Pattern;
import static org.apache.commons.lang3.StringUtils.join;


public class SeleniumTest {

    static WebDriver driver;
    static String baseUrl;
    static String port;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public static void before() {
        driver = new FirefoxDriver();
        port = System.getenv("PORT");
        if (port == null) {
            port = "4567";
        }
        baseUrl = "http://localhost:" + port;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public static void after() {
        driver.close();
    }

    @Before
    public void setup() {
        ;
    }

    @Test
    public void testSelenium() throws Exception {
        selenium.open(baseUrl+ "/");
        selenium.click("id=canvas1");
        selenium.click("id=canvas2");
        selenium.click("id=canvas5");
        selenium.click("id=canvas8");
        selenium.click("id=canvas4");
        selenium.click("id=canvas3");
        selenium.click("id=canvas6");
        verifyEquals("", selenium.getText("id=canvas9"));
    }
}