package tests;


import java.util.concurrent.TimeUnit;
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

    @Rule
    public TestName test = new TestName();


    @Before
    public void setUp() throws Exception {

        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        Navegador = new ChromeDriver();
        Navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Enter test page
        Navegador.get("https://www.disneyplus.com/pt-br");

        //Login in Disne+
        Navegador.findElement(By.linkText("ENTRAR")).click();
        Navegador.findElement(By.id("email")).sendKeys("douglasfelipecandido1@gmail.com");
        Navegador.findElement(By.cssSelector("form > button")).click();
        //Password is a local variable
        Navegador.findElement(By.id("password")).sendKeys("Dougl@s020498");
        Navegador.findElement(By.cssSelector("form > button")).click();

    }

    @Test
    public void test1Logincheck() {

        WebElement me = Navegador.findElement(By.cssSelector("#remove-main-padding_index > div > div > section > h2"));
        String textoNoElemento = me.getText();
        //Check if profile page is redered
        Assert.assertEquals("Quem vai assistir?",textoNoElemento);

        Screenshoot.tirar(Navegador, "C:\\Users\\dougl\\Desktop\\Cursos\\WebAutomationJava\\src\\testReport"+ Generator.dataHoraArquivo() + test.getMethodName() + ".png");

    }

    @Test
    public void test2EnterHome() {
        Navegador.findElement(By.xpath("//*[@id=\"remove-main-padding_index\"]/div/div/section/ul/div[1]/div/div")).click();

        WebElement me = Navegador.findElement(By.xpath("//*[@id=\"explore-ui-main-content-container\"]/div[3]/div"));
        String textoNoElemento = me.getText();
        //Check if enter in Disney/Star+ selection movie page
        Assert.assertEquals("Destaques Star",textoNoElemento);

        Screenshoot.tirar(Navegador, "C:\\Users\\dougl\\Desktop\\Cursos\\WebAutomationJava\\src\\testReport"+ Generator.dataHoraArquivo() + test.getMethodName() + ".png");
    }

    @Test
    public void test3SearchMovie() {

        //Click in search bar and serch a movie (Rogger Rabbit)
        Navegador.findElement(By.xpath("//*[@id=\"remove-main-padding_index\"]/div/div/section/ul/div[1]/div/div")).click();
        Navegador.findElement(By.cssSelector("#nav-list > span:nth-child(3) > a")).click();
        Navegador.findElement(By.cssSelector("#explore-ui-main-content-container > div._1r8f3tq5.xgfbc13ua.xgfbc13ia.xgfbc15o > input")).sendKeys("Roger Rabbit");

        // Check if the movie is found
        WebElement movieTitle = Navegador.findElement(By.xpath("//*[@id=\"explore-ui-main-content-container\"]/div[2]/div/div/section/div/div/a/div[2]/div[1]"));
        String textMovie = movieTitle.getText();
        Assert.assertEquals("Uma Cilada para Roger Rabbit",textMovie);

        Screenshoot.tirar(Navegador, "C:\\Users\\dougl\\Desktop\\Cursos\\WebAutomationJava\\src\\testReport"+ Generator.dataHoraArquivo() + test.getMethodName() + ".png");

    }

    @Test
    public void test4CreateUser(){

        //Click in Create User - Junior Mode
        Navegador.findElement(By.cssSelector("ul > label")).click();
        //Password is a local variable
        Navegador.findElement(By.id("password")).sendKeys("Dougl@s020498");
        //Create User - Test Child
        Navegador.findElement(By.id("password-continue-login")).click();
        Navegador.findElement(By.xpath("//*[@id=\"select-avatar\"]/div[2]/div/div/div/div/div/div[1]")).click();
        Navegador.findElement(By.id("addProfile")).sendKeys("Test Child");
        Navegador.findElement(By.cssSelector(" label > p")).click();
        Navegador.findElement(By.xpath("//*[@id=\"remove-main-padding_index\"]/div/section/div/section/form/div/div[2]/button")).click();


        WebElement me = Navegador.findElement(By.xpath("//*[@id=\"remove-main-padding_index\"]/div/div/section/ul/div[3]/div/h3"));
        String textoNoElemento = me.getText();
        //Check if profile is in Profiles list
        Assert.assertEquals("Test Child",textoNoElemento);
        WebDriverWait wait = new WebDriverWait(Navegador, 10);
        wait.until(ExpectedConditions.visibilityOf(me));

        Screenshoot.tirar(Navegador, "C:\\Users\\dougl\\Desktop\\Cursos\\WebAutomationJava\\src\\testReport"+ Generator.dataHoraArquivo() + test.getMethodName() + ".png");
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
        Navegador.findElement(By.id("password")).sendKeys("Dougl@s020498");
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

    @Test public void test7verificarAdulto(){
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

    @Test public void test8excluirPerfil(){
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
