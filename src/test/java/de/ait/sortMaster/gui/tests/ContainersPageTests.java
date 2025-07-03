package de.ait.sortMaster.gui.tests;

import de.ait.sortMaster.gui.core.TestBase;
import de.ait.sortMaster.gui.page.ContainersPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContainersPageTests extends TestBase {

    private ContainersPage containerPage;

    @BeforeMethod
    public void setUpPage() {
        app.driver.get("http://localhost:5173/#/containers");
        containerPage = new ContainersPage(app.driver);
    }

    @Test
    public void headingIsDisplayedWithCorrectTextTest() {
        Assert.assertEquals(containerPage.getHeadingText(), "Rubbish Containers");
    }

    @Test
    public void enterItemNameAndCreateItemToGlassContainerTest() {
        containerPage.addItemNameToGlassContainer("Jar");
        containerPage.submitAddItemToGlassContainer();
        Assert.assertEquals(containerPage.getSuccessMessage(), "Item created successfully!");
    }


}
