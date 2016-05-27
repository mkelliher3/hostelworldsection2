import com.hostelworld.pageobjects.HomePage;
import com.hostelworld.pageobjects.ResultsPage;
import com.hostelworld.util.WebUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by M on 21/05/2016.
 */
public class HostelworldTest {

    private WebDriver driver;

    @Before
    public void setDriver() {
        String browserName = System.getenv("browser");
        if (browserName != null && browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver();
        }
    }

//    Use Case 1: Search property results with names in alphabetical order
    @Test
    public void searchByName() {
//        Go to the Hostelworld website
        HomePage homePage = WebUtil.goToHomePage(driver);

//        Fill in the search box for Dublin, Ireland and then go to results page
        final String city = "Dublin, Ireland";
        homePage.fillInSearchBox(driver, city);
        homePage.clickOnSearchResult(driver, city);
        ResultsPage resultsPage = homePage.clickOnSearchButton(driver);

//        Sort the results in alphabetical order
        resultsPage.clickOnSortButton(driver);
        resultsPage.clickOnSortByNameItem(driver);

//        Asserting that the result[3] is before result[6] in alphabetical order
        String firstResult = resultsPage.getResultName(driver, 3);
        String secondResult = resultsPage.getResultName(driver, 6);
        Assert.assertTrue(firstResult.compareTo(secondResult) < 0);
    }

//    Use case 2: Search property results with price ranging from lowest to highest
    @Test
    public void searchByPrice() {
//        Go to the Hostelworld website
        HomePage homePage = WebUtil.goToHomePage(driver);

//        Fill in search box for Dublin, Ireland and go to results page
        final String city = "Dublin, Ireland";
        homePage.fillInSearchBox(driver, city);
        homePage.clickOnSearchResult(driver, city);
        ResultsPage resultsPage = homePage.clickOnSearchButton(driver);

//        Sort the results with price ranging from lowest to highest
        resultsPage.clickOnSortButton(driver);
        resultsPage.clickOnSortByPriceItem(driver);

//        Asserting that the result[3]'s dorm room is cheaper than result[6]
        String firstResult = resultsPage.getResultPrice(driver, 3);
        String secondResult = resultsPage.getResultPrice(driver, 6);
        Assert.assertTrue(firstResult.compareTo(secondResult) < 0);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
