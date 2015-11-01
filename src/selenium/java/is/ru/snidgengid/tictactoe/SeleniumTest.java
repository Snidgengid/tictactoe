package is.ru.snidgengid.tictactoe;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class SeleniumTest {

    static WebDriver driver;
    static String baseUrl;
    static String port;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass
    public static void before() {
        driver = new FirefoxDriver();
        port = System.getenv("PORT");
        if (port == null) {
            port = "4567";
        }
        baseUrl = "http://localhost:" + port;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void after() {
        driver.close();
    }

    @Before
    public void setup() {
        ;
    }


    @Test
    public void test() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.id("canvas1")).click();
        driver.findElement(By.id("canvas2")).click();
        driver.findElement(By.id("canvas4")).click();
        driver.findElement(By.id("newGame")).click();
        try {
            assertEquals("", driver.findElement(By.id("newGame")).getAttribute("id=newGame"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
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