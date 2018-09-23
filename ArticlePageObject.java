package lib.UI;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import lib.Platform;

abstract public class ArticlePageObject extends MainPageObject {

    protected static String
    TITLE,
    FOOTER_ELEMENT,
    OPTIONS_BUTTON,
    OPTIONS_ADD_TO_MY_LIST_BUTTON,
    OPTIONS_ADD_TO_FOLDER_BUTTON,
    ADD_TO_MY_LIST_OVERLAY,
    MY_LIST_NAME_INPUT,
    MY_LIST_OK_BUTTON,
    CLOSE_ARTICLE_BUTTON,
    CLOSE_SYNC_WINDOW_BUTTON,
    JAVA_ARTICLE,
    JAVASCRIPT_ARTICLE,
    JAVASCRIPT_SAVED;


    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(TITLE, "Cannot find article title on page!", 15);
    }

    public String getArticleTitle() {
        WebElement title_element = (WebElement) waitForTitleElement();
        if (Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("text");
        } else {
            return title_element.getAttribute("name");
        }
    }

    public void swipeToFooter()
    {
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    40
            );
        }else {
            this.swipeUpTillElementAppear(FOOTER_ELEMENT,
            "Cannot find the end of article",
            40);
        }
    }

    public void addArticleToMyList(String name_of_folder)
    {
        if (Platform.getInstance().isAndroid()) {
            this.waitForElementAndClick(
                    OPTIONS_BUTTON,
                    "Cannot find button to open article options",
                    5
            );
            this.waitForElementPresent(
                    OPTIONS_ADD_TO_MY_LIST_BUTTON,
                    "Add to reading list is not found",
                    10
            );

            this.waitForElementAndClick(
                    OPTIONS_ADD_TO_MY_LIST_BUTTON,
                    "Cannot find option to add article to reading list",
                    5
            );

            this.waitForElementAndClick(
                    ADD_TO_MY_LIST_OVERLAY,
                    "Cannot find 'Got it' tip overlay",
                    5
            );

            this.waitForElementAndClear(
                    MY_LIST_NAME_INPUT,
                    "Cannot find input to set name of article folder",
                    5
            );

            this.waitForElementAndSendKeys(
                    MY_LIST_NAME_INPUT,
                    name_of_folder,
                    "Cannot put text into article folder input",
                    5
            );

            this.waitForElementAndClick(
                    MY_LIST_OK_BUTTON,
                    "Cannot press the OK button",
                    5
            );
        } else {
            this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON,
                    "Cannot find option to add article to read",
                    40);
        }
    }

    public void addArticleToMySavedFolder(String name_of_folder)
    {
        if (Platform.getInstance().isAndroid()) {
            this.waitForElementAndClick(
                    OPTIONS_BUTTON,
                    "Cannot find button to open article options",
                    5
            );
            this.waitForElementPresent(
                    OPTIONS_ADD_TO_MY_LIST_BUTTON,
                    "Add to reading list is not found",
                    10
            );

            this.waitForElementAndClick(
                    OPTIONS_ADD_TO_MY_LIST_BUTTON,
                    "Cannot find option to add article to reading list",
                    5
            );

            this.waitForElementAndClick(
                    OPTIONS_ADD_TO_FOLDER_BUTTON,
                    "Cannot find 'Got it' tip overlay",
                    5
            );

        } else {
            this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON,
                    "Cannot find option to add article to read",
                    40);
        }
    }

    public void addArticleToMySaved(){
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "Cannot find option to add article to read", 5);
    }

    public void closeArticle()
    {
        if (Platform.getInstance().isAndroid()) {
            this.waitForElementAndClick(
                    CLOSE_ARTICLE_BUTTON,
                    "Cannot close article, cannot find X link",
                    5);
        } else {
            this.waitForElementAndClick(
                    CLOSE_ARTICLE_BUTTON,
                    "Cannot close article, cannot find back button",
                    5);
        }
    }

    public void closeSyncWindow()
    {
        if (Platform.getInstance().isIOS()) {
            this.waitForElementAndClick(
                    CLOSE_SYNC_WINDOW_BUTTON,
                    "Cannot close article, cannot find X link",
                    5);
        }
    }

    public void assertResultAfterSwipeArticle()
    {
        if (Platform.getInstance().isAndroid()) {
            this.waitForElementNotPresent(
                    JAVA_ARTICLE,
                    "Cannot delete saved article",
                    5
            );

            this.waitForElementPresent(
                    JAVASCRIPT_ARTICLE,
                    "Saved article is not found",
                    10
            );

            this.waitForElementAndClick(
                    JAVASCRIPT_ARTICLE,
                    "Javascript article is not found",
                    15
            );
        } else {
            this.waitForElementNotPresent(
                    JAVA_ARTICLE,
                    "Cannot delete saved article",
                    5
            );

            this.waitForElementPresent(
                    JAVASCRIPT_ARTICLE,
                    "Saved article is not found",
                    10
            );

            this.waitForElementAndClick(
                    JAVASCRIPT_ARTICLE,
                    "Javascript article is not found",
                    15
            );
        }

    }

    public WebElement waitForTitleElementByTitle(String article_title){
        String title_id = TITLE.replace("{ARTICLE}",article_title);
        return this.waitForElementPresent(title_id, "Cannot find element by title", 25);

    }
    public void assertTitleElementPresent(String article_title, String error_message){
        String title_id = TITLE.replace("{ARTICLE}",article_title);
        this.assertElementPresent(title_id, error_message);
    }
}
