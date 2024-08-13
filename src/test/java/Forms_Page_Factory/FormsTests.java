package Forms_Page_Factory;

import Forms_Page_Factory.LoginForm;
import Forms_Page_Factory.RegisterForm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FormsTests {

    WebDriver driver;
    WebDriverWait wait;
    String loginUrl = "https://www.tutorialspoint.com/selenium/practice/login.php";
    String registerUrl = "https://www.tutorialspoint.com/selenium/practice/register.php";
    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\mrx\\Documents\\Drivers\\firefox\\geckodriver\\geckodriver.exe");

        driver = new FirefoxDriver();

    }

    @Test
    public void registerUserTest() {
        // Открытие веб-страницы
        String registerUrl = "https://www.tutorialspoint.com/selenium/practice/register.php#";
        driver.get(registerUrl);
        driver.manage().window().maximize();

        RegisterForm regform = new RegisterForm(driver);
        regform.register("Dimitri", "Golubev", "dimitri777", "privet");

        assertEquals(driver.getCurrentUrl(), registerUrl);
    }

    @Test
    public void checkLoginTest() {
        // Открытие веб-страницы

        driver.get(loginUrl);
        driver.manage().window().maximize();

        LoginForm loginForm = new LoginForm(driver);
        loginForm.login("dimitri777", "privet");

        assertEquals(driver.getCurrentUrl(), loginUrl);

    }

    @Test
    public void backToLoginFormfromRegisterFormTest(){
        // Открытие веб-страницы
        driver.get(registerUrl);
        driver.manage().window().maximize();

        RegisterForm regform = new RegisterForm(driver);
        regform.backToLoginForm();

        System.out.println(driver.getCurrentUrl());
        assertEquals(driver.getCurrentUrl(), loginUrl);
    }

    @Test
    public void toRegistrationFormFromLoginFormTest(){
        // Открытие веб-страницы
        driver.get(loginUrl);
        driver.manage().window().maximize();

        LoginForm loginform = new LoginForm(driver);
        loginform.goToRegistrationForm();

        //System.out.println(driver.getCurrentUrl());
        assertEquals(driver.getCurrentUrl(), registerUrl);
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
