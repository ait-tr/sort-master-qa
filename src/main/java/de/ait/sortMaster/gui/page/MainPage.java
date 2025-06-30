package de.ait.sortMaster.gui.page;

import de.ait.sortMaster.gui.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {
    @FindBy(tagName = "h2")
    WebElement header;
    @FindBy(tagName = "input")
    WebElement input;
    @FindBy(css = "ul > li")
    List<WebElement> resultItems;
    @FindBy(css = "ul > li")
    WebElement errorText;
    @FindBy(css = ".text-gray-500")
    WebElement noMatchMessage;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderText() {
        return header.getText();
    }

    public boolean isInputVisible() {
        return isElementDisplayed(input);
    }

    public void searchFor(String query) {
        type(input, query);
        pause(500); // simulate debounce (React waits 300ms)
    }

    public int getNumberOfResults() {
        return resultItems.size();
    }

    public boolean isNoMatchMessageVisible() {
        return isElementDisplayed(noMatchMessage);
    }

    public boolean isErrorVisible() {
        return isElementDisplayed(errorText);
    }
}
