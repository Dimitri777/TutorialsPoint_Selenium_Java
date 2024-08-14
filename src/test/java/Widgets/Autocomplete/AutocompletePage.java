package Widgets.Autocomplete;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AutocompletePage {

    WebDriver driver;

    // Локаторы для элементов на странице
    @FindBy(id = "tags")
    WebElement autocompleteField;

    @FindBy(xpath = "//div[@id='ui-id-2']")
    List<WebElement> autocompleteOptions;

    public AutocompletePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Ввод текста в поле автозаполнения
    public void enterTextInAutocompleteField(String text) {
        autocompleteField.clear();
        autocompleteField.sendKeys(text);
    }

    // Ожидание появления вариантов автозаполнения
    public void waitForAutocompleteOptions() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(autocompleteOptions));
    }

    // Выбор варианта из автозаполнения по тексту
    public void selectAutocompleteOption(String optionText) {
        for (WebElement option : autocompleteOptions) {
            if (option.getText().equalsIgnoreCase(optionText)) {
                option.click();
                break;
            }
        }
    }

    // Получение текста выбранного варианта
    public String getSelectedOptionText() {
        return autocompleteField.getAttribute("value");
    }
}
