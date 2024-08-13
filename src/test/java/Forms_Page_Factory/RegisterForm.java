package Forms_Page_Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterForm {
    WebDriver driver;

    @FindBy(id = "firstname")
    WebElement firstNameField;

    @FindBy(id = "lastname")
    WebElement lastNameField;

    @FindBy(id= "username")
    WebElement userNameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(xpath = "//input[@value='Register']")
    WebElement registerButton;

    @FindBy(xpath = "//a[@type='submit']")
    WebElement backToLoginButton;

    // Constructor
    public RegisterForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void register(String firstname, String lastname, String username, String password) {

        firstNameField.sendKeys(firstname);
        lastNameField.sendKeys(lastname);
        userNameField.sendKeys(username);
        passwordField.sendKeys(password);

        registerButton.click();

    }

    public void backToLoginForm() {
        backToLoginButton.click();
    }



}
