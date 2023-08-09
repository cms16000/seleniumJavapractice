package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageObjects {

    public PageObjects(){
    }

    @FindBy(how = How.ID, using = "search-bar")
    public  WebElement magnifyingGlass;

    @FindBy(how = How.ID, using = "search-keyword")
    public  WebElement searchBar;

    @FindBy(how = How.XPATH, using = "//*[@role='search']")
    public List<WebElement> searchSubmit;

}
