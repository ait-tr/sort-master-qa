package de.ait.sortMaster.gui.page;

import de.ait.sortMaster.gui.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(tagName = "h2")
    WebElement heading;

    @FindBy(tagName = "input")
    WebElement input;

    @FindBy(css = "ul > li")
    List<WebElement> resultItems;

    @FindBy(css = ".text-gray-500")
    WebElement noMatchText;

    public String getHeadingText(){
        return heading.getText();
    }

    public Boolean isInputVisible(){
        return isElementDisplayed(input);
    }

    public void queryFor(String query){
        type(input, query);
        pause(500);
    }

    public int getNumberOfResults(){
        return resultItems.size();
    }

    public Boolean isNoMatchTextVisible(){
        return isElementDisplayed(noMatchText);
    }
}
