package Links_POP;

import Links_POP.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

public class LinkTests {

    WebDriver driver;
    HomePage homePage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\mrx\\Documents\\Drivers\\firefox\\geckodriver\\geckodriver.exe");

        // Инициализация браузера
        driver = new FirefoxDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/links.php"); // Замените на реальный URL страницы
        driver.manage().window().maximize();

        // Инициализация Page Object
        homePage = new HomePage(driver);
    }

    @Test
    public void testHomeLink() {
        // Клик на ссылку "Home"
        homePage.clickHomeLink();

        // Ожидание перед переключением на новую вкладку (опционально)
        try {
            Thread.sleep(2000);  // Можно заменить на WebDriverWait, если это связано с ожиданием загрузки страницы
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Переключение на новую вкладку и проверка URL
        String currentUrl = homePage.switchToNewTab();
        assertEquals("https://www.tutorialspoint.com/index.htm", currentUrl);

        // Закрытие вкладки и возврат на исходную
        homePage.closeCurrentTabAndSwitchBack();
    }

    @Test
    public void testHomePWPUlink() {
        // Клик на ссылку "HomewPWPU"
        homePage.clickHomePWPUlink();

        // Переключение на новую вкладку и проверка URL
        String currentUrl = homePage.switchToNewTab();
        assertEquals("about:blank", currentUrl);

        // Закрытие вкладки и возврат на исходную
        homePage.closeCurrentTabAndSwitchBack();
    }

    @After
    public void tearDown() {
        if (driver != null) {
           //driver.quit();
        }
    }
}
