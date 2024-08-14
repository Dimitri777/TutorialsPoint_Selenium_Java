package Widgets.Autocomplete;


import Widgets.Autocomplete.AutocompletePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

public class AutocompleteTests {

    WebDriver driver;
    AutocompletePage autocompletePage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\mrx\\Documents\\Drivers\\firefox\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/auto-complete.php");
        driver.manage().window().maximize();
        autocompletePage = new AutocompletePage(driver);
    }

    @Test
    public void testAutocompleteFunctionality() {
        // Ввод текста в поле автозаполнения
        String inputText = "Javas";
        autocompletePage.enterTextInAutocompleteField(inputText);

        // Ожидание появления вариантов автозаполнения
        autocompletePage.waitForAutocompleteOptions();

        // Выбор варианта "JavaScript"
        String expectedOption = "JavaScript";
        autocompletePage.selectAutocompleteOption(expectedOption);

        // Проверка выбранного варианта
        String selectedText = autocompletePage.getSelectedOptionText();
        assertEquals("Выбран неверный вариант из автозаполнения.", expectedOption, selectedText);
    }

    @After
    public void tearDown() {
        if (driver != null) {
           driver.quit();
        }
    }
}
