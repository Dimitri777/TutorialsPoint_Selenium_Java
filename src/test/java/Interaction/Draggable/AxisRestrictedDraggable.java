package Interaction.Draggable;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;

public class AxisRestrictedDraggable {

    private WebDriver driver;

    @Test
    public void testAxisRestrictedDraggable() {
        // Запускаем браузер и открываем страницу
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\mrx\\Documents\\Drivers\\firefox\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/dragabble.php");
        driver.manage().window().maximize();

        // Переходим во вкладку "Axis Restricted"
        WebElement axisRestrictedTab = driver.findElement(By.id("nav-profile-tab"));
        axisRestrictedTab.click();

        // Находим элементы
        WebElement draggableX = driver.findElement(By.id("div_element"));
        WebElement draggableY = driver.findElement(By.id("div_elementy"));

        // Инициализируем класс Actions для взаимодействия с элементами
        Actions actions = new Actions(driver);

        // Перетаскиваем элемент по горизонтали
        Point initialPositionX = draggableX.getLocation();
        actions.dragAndDropBy(draggableX, 100, 0).perform();
        Point finalPositionX = draggableX.getLocation();

        // Проверяем, что элемент переместился только по горизонтали
        assertEquals(initialPositionX.y, finalPositionX.y);

        // Перетаскиваем элемент по вертикали
        Point initialPositionY = draggableY.getLocation();
        actions.dragAndDropBy(draggableY, 0, 100).perform();
        Point finalPositionY = draggableY.getLocation();

        // Проверяем, что элемент переместился только по вертикали
        assertEquals(initialPositionY.x, finalPositionY.x-1);

        driver.quit();
    }


}
