package Forms_Page_Factory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

public class FormsTests {

    WebDriver driver;
    String loginUrl = "https://www.tutorialspoint.com/selenium/practice/login.php";
    String registerUrl = "https://www.tutorialspoint.com/selenium/practice/register.php";
    String practiceUrl = "https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php";

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\mrx\\Documents\\Drivers\\firefox\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize(); // Открытие браузера в полноэкранном режиме
    }

    @Test
    public void registerUserTest() {
        driver.get(registerUrl);
        RegisterForm regform = new RegisterForm(driver);
        regform.register("Dimitri", "Golubev", "dimitri7773", "privet");

        assertEquals(driver.getCurrentUrl(), registerUrl+"#");

    }

    @Test
    public void practiceFormTest() {
        String pageTitle = "Selenium Practice - Student Registration Form";
        driver.get(practiceUrl);
        PracticeForm practiceForm = new PracticeForm(driver);
        practiceForm.loginToPracticeForm("Alexandra Ivanova", "aliv@gmail.com", "+74951234567",
                "01.01.1980", "Math, Physics", "Test address whatever, 1, 2-3/5");

        assertEquals(driver.getCurrentUrl(), practiceUrl);
        assertEquals(driver.getTitle(), pageTitle);
    }

    @Test
    public void checkLoginTest() {
        driver.get(loginUrl);
        LoginForm loginForm = new LoginForm(driver);
        loginForm.login("dimitri777", "privet");

        assertEquals(driver.getCurrentUrl(), loginUrl);
    }

    @Test
    public void backToLoginFormfromRegisterFormTest() {
        driver.get(registerUrl);
        RegisterForm regform = new RegisterForm(driver);
        regform.backToLoginForm();

        assertEquals(driver.getCurrentUrl(), loginUrl);
    }

    @Test
    public void toRegistrationFormFromLoginFormTest() {
        driver.get(loginUrl);
        LoginForm loginform = new LoginForm(driver);
        loginform.goToRegistrationForm();

        assertEquals(driver.getCurrentUrl(), registerUrl);
    }

    @After
    public void tearDown() {
        if (driver != null) {
          //  driver.quit();
        }
    }
}
