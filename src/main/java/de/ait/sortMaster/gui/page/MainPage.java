package de.ait.sortMaster.gui.page;

import de.ait.sortMaster.gui.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage extends BasePage {

    private final By header = By.tagName("h2");
    private final By inputField = By.tagName("input");
    private final By resultItems = By.cssSelector("ul > li");
    private final By errorText = By.cssSelector(".text-red-500");
    private final By noMatchMessage = By.cssSelector(".text-gray-500");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }

    public boolean isInputVisible() {
        return isElementDisplayed(driver.findElement(inputField));
    }

    public void searchFor(String query) {
        type(driver.findElement(inputField), query);
        pause(500); // simulate debounce (React waits 300ms)
    }

    public int getNumberOfResults() {
        List<WebElement> items = driver.findElements(resultItems);
        return items.size();
    }

    public boolean isNoMatchMessageVisible() {
        return isElementDisplayed(driver.findElement(noMatchMessage));
    }

    public boolean isErrorVisible() {
        return isElementDisplayed(driver.findElement(errorText));
    }
}
