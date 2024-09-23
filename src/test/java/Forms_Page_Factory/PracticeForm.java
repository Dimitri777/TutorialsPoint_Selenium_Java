package Forms_Page_Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class PracticeForm {

    WebDriver driver;

    @FindBy(id = "name")
    WebElement nameField;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "gender")
    WebElement maleRadioButton;

    @FindBy(xpath = "//*[@id=\"practiceForm\"]/div[3]/div/div/div[2]/input")
    WebElement femaleRadioButton;

    @FindBy(xpath = "//*[@id=\"practiceForm\"]/div[3]/div/div/div[3]/input")
    WebElement otherRadioButton;

    @FindBy(id = "mobile")
    WebElement mobileField;

    @FindBy(xpath = "//*[@id=\"dob\"]")
    WebElement dobField;

    @FindBy(id = "subjects")
    WebElement subjectsField;

    @FindBy(id = "hobbies")
    WebElement sportsCheckbox;

    @FindBy(xpath = "//*[@id=\"practiceForm\"]/div[7]/div/div/div[2]/input")
    WebElement readingCheckbox;

    @FindBy(xpath = "//*[@id=\"practiceForm\"]/div[7]/div/div/div[3]/input")
    WebElement musicCheckbox;

    @FindBy(xpath = "//input[@id='picture']")
    WebElement pictureChooseFileBox;

    @FindBy(xpath = "//textarea[@id='picture']")
    WebElement currentAddressTextArea;

    @FindBy(id = "state")
    WebElement stateListbox;

    @FindBy(id = "city")
    WebElement cityListbox;

    @FindBy(xpath = "//*[@id=\"practiceForm\"]/div[11]/input")
    WebElement submitButton;

    // Constructor
    public PracticeForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginToPracticeForm(String name, String email, String mobileNumber, String dateOfBirth, String subjects, String currAddress) {

        nameField.sendKeys(name);
        emailField.sendKeys(email);
        femaleRadioButton.click();
        otherRadioButton.click();
        maleRadioButton.click();

        mobileField.sendKeys(mobileNumber);

        dobField.sendKeys(dateOfBirth);

        subjectsField.sendKeys(subjects);

        sportsCheckbox.click();
        readingCheckbox.click();
        musicCheckbox.click();


        pictureChooseFileBox.click();
        File file = new File("C:\\Users\\mrx\\Desktop\\1.jpg");
        pictureChooseFileBox.sendKeys(file.getAbsolutePath());

        currentAddressTextArea.sendKeys(currAddress);

        Select selectState = new Select(stateListbox);
        selectState.selectByVisibleText("Haryana");

        Select selectCity = new Select(cityListbox);
        selectCity.selectByVisibleText("Agra");

        submitButton.click();
    }
}
