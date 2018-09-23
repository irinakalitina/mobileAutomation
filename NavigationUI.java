package lib.UI;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.By;

abstract public class NavigationUI extends MainPageObject {

    protected static String
            MY_LIST_LINK;

    public NavigationUI(AppiumDriver driver) {
        super(driver);
    }


    public void clickMyLists() {
        if (Platform.getInstance().isAndroid()) {
            this.waitForElementAndClick(
                    MY_LIST_LINK,
                    "Cannot find navigation button to My list",
                    5
            );
        } else {
            this.waitForElementAndClick(
                    MY_LIST_LINK,
                    "Cannot find Saved button",
                    5
            );
        }
    }
}