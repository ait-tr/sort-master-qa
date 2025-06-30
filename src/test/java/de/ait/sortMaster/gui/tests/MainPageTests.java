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
        mainPage = new MainPage(app.getDriver());
    }

    @Test
    public void shouldDisplayHeaderAndInput() {
        Assert.assertEquals(mainPage.getHeaderText(), "Find the Right Container");
        Assert.assertTrue(mainPage.isInputVisible(), "Search input should be visible");
    }

    @Test
    public void shouldReturnNoResultsForInvalidSearch() {
        mainPage.searchFor("zzzxxyyq");
        Assert.assertTrue(mainPage.isNoMatchMessageVisible(), "No match message should be shown");
        Assert.assertEquals(mainPage.getNumberOfResults(), 0);
    }

    @Test
    public void shouldReturnResultsForValidSearch() {
        mainPage.searchFor("newspaper");
        int resultCount = mainPage.getNumberOfResults();
        Assert.assertTrue(resultCount > 0, "Expected at least one result");
    }

    @Test
    public void shouldNotShowResultsForEmptyInput() {
        mainPage.searchFor("   "); // spaces only
        Assert.assertEquals(mainPage.getNumberOfResults(), 0);
    }
}
