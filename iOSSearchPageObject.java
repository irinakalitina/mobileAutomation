package lib.UI.ios;

import io.appium.java_client.AppiumDriver;
import lib.UI.SearchPageObject;

public class iOSSearchPageObject extends SearchPageObject
{
    static
    {
        SEARCH_INIT_ELEMENT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        SEARCH_INPUT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
//        SEARCH_INPUT = "xpath://XCUIElementTypeNavigationBar[@name='Wikipedia, scroll to top of Explore']";
        SEARCH_CANCEL_BUTTON = "id:Close";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeLink[contains(@name='{SUBSTRING}')]";
        SEARCH_RESULT_ELEMENT = "xpath://XCUIElementTypeLink";
        SEARCH_EMPTY_RESULT_ELEMENT = "xpath://XCUIElementTypeStaticText[@name=\"No results found\"]";

        SEARCH_EMPTY_RESULTS = "id:org.wikipedia:id/search_empty_image";
        SEARCH_LIST_ITEM = "xpath://XCUIElementTypeCell";
    }

    public iOSSearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
