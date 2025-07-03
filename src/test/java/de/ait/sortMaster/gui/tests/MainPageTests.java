package de.ait.sortMaster.gui.tests;

import de.ait.sortMaster.gui.core.TestBase;
import de.ait.sortMaster.gui.page.MainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPageTests extends TestBase {

   private MainPage mainPage;

   @BeforeMethod
   public void setUpPage() {
       mainPage = new MainPage(app.driver);
   }

    @Test
    public void headingIsDisplayedWithCorrectTextTest() {
        Assert.assertEquals(mainPage.getHeadingText(), "Find the Right Container");
    }

    @Test
    public void inputShouldBeVisibleTest() {
       Assert.assertTrue(mainPage.isInputVisible());
    }

    @Test
    public void shouldReturnResultsForInvalidSearch(){
       mainPage.queryFor("asdjakdaosl");
       Assert.assertEquals(mainPage.getNumberOfResults(), 0);
    }

    @Test
    public void shouldReturnResultsForValidSearch(){
        mainPage.queryFor("newspaper");
        Assert.assertTrue(mainPage.getNumberOfResults() > 0, "Expected at least one result");
    }


    @Test
    public void shouldReturnNoResultsForEmptySearch(){
        mainPage.queryFor("   ");
        Assert.assertEquals(mainPage.getNumberOfResults(), 0);
    }

    @Test
    public void noMatchMessageShouldBeDisplayed() {
        mainPage.queryFor("asdjakdaosl");
        Assert.assertTrue(mainPage.isNoMatchTextVisible());
    }
}
