package Links_POP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;

public class HomePage {

    WebDriver driver;

    // Локаторы для ссылок
    private By homeLink = By.linkText("Home");
    private By homePWPUlink = By.linkText("HomewPWPU");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для клика на ссылку "Home"
    public void clickHomeLink() {
        driver.findElement(homeLink).click();
    }

    // Метод для клика на ссылку "HomewPWPU"
    public void clickHomePWPUlink() {
        driver.findElement(homePWPUlink).click();
    }

    // Метод для переключения на новую вкладку и получения текущего URL
    public String switchToNewTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); // Переключаемся на новую вкладку
        return driver.getCurrentUrl();
    }

    // Метод для закрытия текущей вкладки и возвращения на исходную вкладку
    public void closeCurrentTabAndSwitchBack() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.close(); // Закрываем текущую вкладку
        driver.switchTo().window(tabs.get(0)); // Возвращаемся на исходную вкладку
    }
}
