package tests;

import Suporte.Generator;
import Suporte.Screenshoot;
import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class informacaoesUsuariosTest {
    private WebDriver Navegador;

    @Rule
    public TestName test = new TestName();


    @Before
    public void setUp() throws Exception {

        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        Navegador = new ChromeDriver();
        Navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Navegador.get("https://www.disneyplus.com/pt-br");

        Navegador.findElement(By.linkText("ENTRAR")).click();

        Navegador.findElement(By.id("email")).sendKeys("douglasfelipecandido1@gmail.com");

        Navegador.findElement(By.cssSelector("form > button")).click();

        Navegador.findElement(By.id("password")).sendKeys("Dougl@s020498");

        Navegador.findElement(By.cssSelector("form > button")).click();

    }
    @Ignore
    public void VerificarLogin() {

        WebElement me = Navegador.findElement(By.cssSelector("#remove-main-padding_index > div > div > section > h2"));
        String textoNoElemento = me.getText();
        Assert.assertEquals("Quem vai assistir?",textoNoElemento);

    }

    @Ignore
    public void entrarnaHome() {
        Navegador.findElement(By.xpath("//*[@id=\"remove-main-padding_index\"]/div/div/section/ul/div[1]/div/div")).click();

        WebElement me = Navegador.findElement(By.xpath("//*[@id=\"explore-ui-main-content-container\"]/div[3]/div"));
        String textoNoElemento = me.getText();
        Assert.assertEquals("Destaques Star",textoNoElemento);

    }

    @Ignore
    public void PesquisarFilme() {

        Navegador.findElement(By.xpath("//*[@id=\"remove-main-padding_index\"]/div/div/section/ul/div[1]/div/div")).click();


        Navegador.findElement(By.cssSelector("#nav-list > span:nth-child(3) > a")).click();

        Navegador.findElement(By.cssSelector("#explore-ui-main-content-container > div._1r8f3tq5.xgfbc13ua.xgfbc13ia.xgfbc15o > input")).sendKeys("Roger Rabbit");

        WebElement me = Navegador.findElement(By.xpath("//*[@id=\"explore-ui-main-content-container\"]/div[2]/div/div/section/div/div/a/div[2]/div[1]"));

        Screenshoot.tirar(Navegador, "C:\\Users\\dougl\\Desktop\\Cursos\\WebAutomationJava\\src\\testReport"+ Generator.dataHoraArquivo() + test.getMethodName() + ".png");



    }

    @Test public void CriarUsuario(){
        Navegador.findElement(By.cssSelector("ul > label")).click();

        Navegador.findElement(By.id("password")).sendKeys("Dougl@s020498");

        Navegador.findElement(By.id("password-continue-login")).click();

        Navegador.findElement(By.xpath("//*[@id=\"select-avatar\"]/div[2]/div/div/div/div/div/div[1]")).click();

        Navegador.findElement(By.id("addProfile")).sendKeys("Test Child");

        Navegador.findElement(By.cssSelector(" label > p")).click();

        Navegador.findElement(By.xpath("//*[@id=\"remove-main-padding_index\"]/div/section/div/section/form/div/div[2]/button")).click();


        WebElement me = Navegador.findElement(By.xpath("//*[@id=\"remove-main-padding_index\"]/div/div/section/ul/div[3]/div/h3"));
        String textoNoElemento = me.getText();

        Assert.assertEquals("Test Child",textoNoElemento);

        WebDriverWait wait = new WebDriverWait(Navegador, 10);
        wait.until(ExpectedConditions.visibilityOf(me));

        Screenshoot.tirar(Navegador, "C:\\Users\\dougl\\Desktop\\Cursos\\WebAutomationJava\\src\\testReport"+ Generator.dataHoraArquivo() + test.getMethodName() + ".png");
        // Assert
    }
    @After
    public void TearDown() throws Exception {
        Navegador.quit();
    }
}
