package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By createUserLabel = By.cssSelector("ul > label");
    private By passwordField = By.id("password");
    private By continueLoginButton = By.id("password-continue-login");
    private By avatarOption = By.xpath("//*[@id=\"select-avatar\"]/div[2]/div/div/div/div/div/div[1]");
    private By profileNameField = By.id("addProfile");
    private By saveButton = By.xpath("//*[@id=\"remove-main-padding_index\"]/div/section/div/section/form/div/div[2]/button");
    private By profileName = By.xpath("//*[@id=\"remove-main-padding_index\"]/div/div/section/ul/div[3]/div/h3");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void clickCreateUser() {
        driver.findElement(createUserLabel).click();
    }

    public void enterPassword(CharSequence password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickContinueLogin() {
        driver.findElement(continueLoginButton).click();
    }

    public void selectAvatar() {
        driver.findElement(avatarOption).click();
    }

    public void enterProfileName(String name) {
        driver.findElement(profileNameField).sendKeys(name);
    }

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }

    public String getProfileName() {
        WebElement profileElement = wait.until(ExpectedConditions.visibilityOfElementLocated(profileName));
        return profileElement.getText();
    }
}
