package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By profileHeader = By.cssSelector("#remove-main-padding_index > div > div > section > h2");
    private By starHighlights = By.xpath("//*[@id=\"explore-ui-main-content-container\"]/div[3]/div");
    private By firstProfile = By.xpath("//*[@id=\"remove-main-padding_index\"]/div/div/section/ul/div[1]/div/div");
    private By searchButton = By.cssSelector("#nav-list > span:nth-child(3) > a");
    private By searchField = By.cssSelector("#explore-ui-main-content-container > div._1r8f3tq5.xgfbc13ua.xgfbc13ia.xgfbc15o > input");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getProfileHeaderText() {
        return driver.findElement(profileHeader).getText();
    }

    public String getStarHighlightsText() {
        return driver.findElement(starHighlights).getText();
    }

    public void clickFirstProfile() {
        driver.findElement(firstProfile).click();
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public void enterSearchQuery(String query) {
        driver.findElement(searchField).sendKeys(query);
    }

    public String getFirstMovieTitle() {
        WebElement movieTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"explore-ui-main-content-container\"]/div[2]/div/div/section/div/div/a/div[2]/div[1]")));
        return movieTitle.getText();
    }
}
