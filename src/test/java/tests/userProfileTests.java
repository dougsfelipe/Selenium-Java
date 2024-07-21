package tests;


import java.util.concurrent.TimeUnit;

import Pages.HomePage;
import Pages.ProfilePage;
import Pages.LoginPage;
import Suporte.Generator;
import Suporte.Screenshoot;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class userProfileTests {
    private WebDriver Navegador;
    private LoginPage loginPage;
    private HomePage homePage;
    private ProfilePage profilePage;

    CharSequence PASSWORD = null;
    CharSequence EMAIL = null;

    @Rule
    public TestName test = new TestName();


    @Before
    public void setUp() throws Exception {

        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        Navegador = new ChromeDriver();
        Navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        loginPage = new LoginPage(Navegador);
        homePage = new HomePage(Navegador);
        profilePage = new ProfilePage(Navegador);

        //Enter test page

        loginPage.open();
        loginPage.clickLoginLink();
        loginPage.enterEmail(EMAIL);
        loginPage.clickLoginButton();
        loginPage.enterPassword(PASSWORD);
        loginPage.clickLoginButton();

    }

    @Test
    public void test1Logincheck() {
        String textoNoElemento = homePage.getProfileHeaderText();
        Assert.assertEquals("Quem vai assistir?", textoNoElemento);
        Screenshoot.tirar(Navegador, "C:\\Users\\dougl\\Desktop\\Cursos\\WebAutomationJava\\src\\testReport" + Generator.dataHoraArquivo() + test.getMethodName() + ".png");
    }

    @Test
    public void test2EnterHome() {
        homePage.clickFirstProfile();
        String textoNoElemento = homePage.getStarHighlightsText();
        Assert.assertEquals("Destaques Star", textoNoElemento);
        Screenshoot.tirar(Navegador, "C:\\Users\\dougl\\Desktop\\Cursos\\WebAutomationJava\\src\\testReport" + Generator.dataHoraArquivo() + test.getMethodName() + ".png");
    }

    @Test
    public void test3SearchMovie() {

        homePage.clickFirstProfile();
        homePage.clickSearchButton();
        homePage.enterSearchQuery("Roger Rabbit");
        String textMovie = homePage.getFirstMovieTitle();
        Assert.assertEquals("Uma Cilada para Roger Rabbit", textMovie);
        Screenshoot.tirar(Navegador, "C:\\Users\\dougl\\Desktop\\Cursos\\WebAutomationJava\\src\\testReport" + Generator.dataHoraArquivo() + test.getMethodName() + ".png");
    }

    @Test
    public void test4CreateUser(){
        profilePage.clickCreateUser();
        profilePage.enterPassword(PASSWORD);
        profilePage.clickContinueLogin();
        profilePage.selectAvatar();
        profilePage.enterProfileName("Test Child");
        profilePage.clickSaveButton();
        String textoNoElemento = profilePage.getProfileName();
        Assert.assertEquals("Test Child", textoNoElemento);
        Screenshoot.tirar(Navegador, "C:\\Users\\dougl\\Desktop\\Cursos\\WebAutomationJava\\src\\testReport" + Generator.dataHoraArquivo() + test.getMethodName() + ".png");
    
    }


    @Test public void test5CheckIfIsChildMode(){



        //Enter New Profile
        Navegador.findElement(By.xpath("//*[@id=\"remove-main-padding_index\"]/div/div/section/ul/div[3]/div/div")).click();

        //Search an adult movie
        Navegador.findElement(By.cssSelector("#nav-list > span:nth-child(3) > a")).click();
        Navegador.findElement(By.cssSelector("#explore-ui-main-content-container > div._1r8f3tq5.xgfbc13ua.xgfbc13ia.xgfbc15o > input")).sendKeys("Roger Rabbit");

        WebElement me = Navegador.findElement(By.cssSelector("#explore-ui-main-content-container > div._1r8f3tqg.xgfbc1c.xgfbc11xu"));
        WebDriverWait wait = new WebDriverWait(Navegador,10);
        wait.until(ExpectedConditions.visibilityOf(me));

        //Check if movie is Blocked
        String textoNoElemento = me.getText();
        Assert.assertEquals("Nenhum resultado encontrado para \"Roger Rabbit\"",textoNoElemento);

        Screenshoot.tirar(Navegador, "C:\\Users\\dougl\\Desktop\\Cursos\\WebAutomationJava\\src\\testReport"+ Generator.dataHoraArquivo() + test.getMethodName() + "adultMovie.png");

        //Search an kids movie
        Navegador.findElement(By.cssSelector("#explore-ui-main-content-container > div._1r8f3tq5.xgfbc13ua.xgfbc13ia.xgfbc15o > input")).clear();
        Navegador.findElement(By.cssSelector("#explore-ui-main-content-container > div._1r8f3tq5.xgfbc13ua.xgfbc13ia.xgfbc15o > input")).sendKeys("A casa do Myckey Mouse");
        WebElement me2 = Navegador.findElement(By.xpath("//*[@id=\"explore-ui-main-content-container\"]/div[2]/div/div/section/div/div/a/div[2]/div[1]/span"));
        String textoNoElemento2 = me2.getText();

        //Check if movie is found
        Assert.assertEquals("A Casa do Mickey Mouse",textoNoElemento2);
        wait.until(ExpectedConditions.visibilityOf(me2));
        Screenshoot.tirar(Navegador, "C:\\Users\\dougl\\Desktop\\Cursos\\WebAutomationJava\\src\\testReport"+ Generator.dataHoraArquivo() + test.getMethodName() + "kidsMovie.png");

    }


    @Test public void test6editUser(){

        WebDriverWait wait = new WebDriverWait(Navegador,10);


        //Click in Edit user
        Navegador.findElement(By.cssSelector("nav > button")).click();
        Navegador.findElement(By.xpath("//*[@id=\"remove-main-padding_index\"]/div/section/ul/div[3]")).click();

        //Change Nome do Profile
        WebElement elementEditProfile = Navegador.findElement(By.xpath("//*[@id=\"editProfile\"]"));
        wait.until(ExpectedConditions.visibilityOf(elementEditProfile));
        elementEditProfile.sendKeys(Keys.CONTROL + "a");
        elementEditProfile.sendKeys("Profile");
        //Change to adult Mode
        Navegador.findElement(By.cssSelector("div:nth-child(3) > div:nth-child(2) > label")).click();
        //Password is a local variable
        Navegador.findElement(By.id("password")).sendKeys(PASSWORD);
        Navegador.findElement(By.id("password-continue-login")).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("#app_index > div.sc-dHmInP.fcdCun > div > div")));

        // Wait 2 seconds (2000 ms)
        try {

            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Navegador.findElement(By.cssSelector("#remove-main-padding_index > div > nav > button")).click();
        Screenshoot.tirar(Navegador, "C:\\Users\\dougl\\Desktop\\Cursos\\WebAutomationJava\\src\\testReport"+ Generator.dataHoraArquivo() + test.getMethodName() + "adultMovie.png");
        WebElement me2 = Navegador.findElement(By.xpath("//*[@id=\"remove-main-padding_index\"]/div/section/ul/div[3]/div/h3"));
        String textProfileChange = me2.getText();

        // Check if Profile changed name
        Assert.assertEquals("Profile",textProfileChange);

    }

    @Test public void test7verifyAdult(){
        // Click in Profile
        Navegador.findElement(By.xpath("//*[@id=\"remove-main-padding_index\"]/div/div/section/ul/div[3]/div/div")).click();
        WebElement me = Navegador.findElement(By.xpath("//*[@id=\"explore-ui-main-content-container\"]/div[3]/div"));
        String textoNoElemento = me.getText();
        Assert.assertEquals("Destaques Star",textoNoElemento);

        // Search for an adult movie

        Navegador.findElement(By.cssSelector("#nav-list > span:nth-child(3) > a")).click();
        WebElement movieTitle = Navegador.findElement(By.cssSelector("#explore-ui-main-content-container > div._1r8f3tq5.xgfbc13ua.xgfbc13ia.xgfbc15o > input"));
        movieTitle.sendKeys("Roger Rabbit");

        movieTitle = Navegador.findElement(By.xpath("//*[@id=\"explore-ui-main-content-container\"]/div[2]/div/div/section/div/div/a/div[2]/div[1]"));
        String textMovie = movieTitle.getText();

        // Check if movie is found

        Assert.assertEquals("Uma Cilada para Roger Rabbit",textMovie);
        Screenshoot.tirar(Navegador, "C:\\Users\\dougl\\Desktop\\Cursos\\WebAutomationJava\\src\\testReport"+ Generator.dataHoraArquivo() + test.getMethodName() + ".png");

    }

    @Test public void test8DeletProfile(){
        //Click in edit Profile
        Navegador.findElement(By.cssSelector("nav > button")).click();
        Navegador.findElement(By.xpath("//*[@id=\"remove-main-padding_index\"]/div/section/ul/div[3]")).click();
        //Click in delete Profile
        Navegador.findElement(By.xpath("//*[@id=\"remove-main-padding_index\"]/div/div/form/div[2]/div[2]/button")).click();
        //Confirm deletion
        Navegador.findElement(By.xpath("//*[@id=\"app_index\"]/div[2]/div/div/div/button[2]")).click();
        //Check if the profile is not more in the profile lists
        WebDriverWait wait = new WebDriverWait(Navegador, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\\\"remove-main-padding_index\\\"]/div/section/ul/div[3]\"")));
    }

    @After
    public void TearDown() throws Exception {
       Navegador.quit();
    }
}
