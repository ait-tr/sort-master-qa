package de.ait.sortMaster.gui.page;

import de.ait.sortMaster.gui.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContainersPage extends BasePage {

    public ContainersPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(tagName = "h2")
    WebElement heading;

    @FindBy (xpath = "//li[1]//div[1]//form[1]//div[1]//input[1]")
    WebElement glassContainerInput;

    @FindBy (xpath = "//li[1]//div[1]//form[1]//button[1]")
    WebElement glassContainerAddButton;

    @FindBy(css = ".bg-green-100")
    WebElement message;

    public void addItemNameToGlassContainer(String itemName) {
        glassContainerInput.clear();
        glassContainerInput.sendKeys(itemName);
        pause(500);
    }

    public void submitAddItemToGlassContainer() {
        glassContainerAddButton.click();
        pause(500);
    }

    public String getHeadingText(){
        return heading.getText();
    }

    public String getSuccessMessage() {
        return message.getText();
    }


}
