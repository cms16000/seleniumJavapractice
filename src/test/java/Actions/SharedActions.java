package Actions;

import org.openqa.selenium.WebElement;

public class SharedActions {
    ActionsHolder actions;
    public SharedActions(ActionsHolder actions) {
        this.actions = actions;
    }

    public void sharedClick(WebElement element){
        try {
            element.click();
        }
        catch (Exception e){
            element.click();
        }

    }

    public void sharedSendKeys(WebElement element, String text){
        try {
            element.sendKeys(text);
        }
        catch (Exception e){
            element.sendKeys(text);
        }

    }
}
