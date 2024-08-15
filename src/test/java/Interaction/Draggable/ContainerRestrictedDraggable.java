package Interaction.Draggable;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContainerRestrictedDraggable {

    private WebDriver driver;

    @Test
    public void testContainerRestrictedDraggable() {
        // Запускаем браузер и открываем страницу
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\mrx\\Documents\\Drivers\\firefox\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/dragabble.php");
        driver.manage().window().maximize();

        // Переходим во вкладку "Axis Restricted"
        WebElement containerRestrictedTab = driver.findElement(By.xpath("//body//main//button[3]"));
        containerRestrictedTab.click();

        // Находим элементы
        WebElement draggableElement = driver.findElement(By.id("intro"));
        WebElement container = driver.findElement(By.id("parentContainer"));

        // Получаем начальную позицию и размеры контейнера
        Point containerLocation = container.getLocation();
        Dimension containerSize = container.getSize();

        // Перетаскиваем элемент за пределы контейнера вправо
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(draggableElement, containerSize.width + 10, 0).perform();

        // Получаем новую позицию элемента
        //Point newPosition = draggableElement.getLocation();

        // Перетаскиваем элемент в разные направления
        actions.dragAndDropBy(draggableElement, -containerSize.width - 10, 0).perform(); // Влево
        actions.dragAndDropBy(draggableElement, 0, -containerSize.height - 10).perform(); // Вверх
        actions.dragAndDropBy(draggableElement, containerSize.width + 10, containerSize.height + 10).perform(); // Вправо-вниз

        // Получаем новую позицию элемента после каждого перетаскивания
        Point newPosition = draggableElement.getLocation();

        // Проверяем все границы контейнера
        int leftBoundary = containerLocation.x;
        int rightBoundary = containerLocation.x + containerSize.width;
        int topBoundary = containerLocation.y;
        int bottomBoundary = containerLocation.y + containerSize.height;

        assertTrue(newPosition.x >= leftBoundary, "Элемент был перетащен за левую границу контейнера");
        assertTrue(newPosition.x <= rightBoundary, "Элемент был перетащен за правую границу контейнера");
        assertTrue(newPosition.y >= topBoundary, "Элемент был перетащен за верхнюю границу контейнера");
        assertTrue(newPosition.y <= bottomBoundary, "Элемент был перетащен за нижнюю границу контейнера");

        driver.quit();
    }
}