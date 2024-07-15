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
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;


import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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

    @Test
    public void test1VerificarLogin() {

        WebElement me = Navegador.findElement(By.cssSelector("#remove-main-padding_index > div > div > section > h2"));
        String textoNoElemento = me.getText();
        Assert.assertEquals("Quem vai assistir?",textoNoElemento);

    }

    @Test
    public void test2entrarnaHome() {
        Navegador.findElement(By.xpath("//*[@id=\"remove-main-padding_index\"]/div/div/section/ul/div[1]/div/div")).click();

        WebElement me = Navegador.findElement(By.xpath("//*[@id=\"explore-ui-main-content-container\"]/div[3]/div"));
        String textoNoElemento = me.getText();
        Assert.assertEquals("Destaques Star",textoNoElemento);

    }

    @Test
    public void test3PesquisarFilme() {

        Navegador.findElement(By.xpath("//*[@id=\"remove-main-padding_index\"]/div/div/section/ul/div[1]/div/div")).click();


        Navegador.findElement(By.cssSelector("#nav-list > span:nth-child(3) > a")).click();

        Navegador.findElement(By.cssSelector("#explore-ui-main-content-container > div._1r8f3tq5.xgfbc13ua.xgfbc13ia.xgfbc15o > input")).sendKeys("Roger Rabbit");

        WebElement movieTitle = Navegador.findElement(By.xpath("//*[@id=\"explore-ui-main-content-container\"]/div[2]/div/div/section/div/div/a/div[2]/div[1]"));
        String textMovie = movieTitle.getText();
        Assert.assertEquals("Uma Cilada para Roger Rabbit",textMovie);

        Screenshoot.tirar(Navegador, "C:\\Users\\dougl\\Desktop\\Cursos\\WebAutomationJava\\src\\testReport"+ Generator.dataHoraArquivo() + test.getMethodName() + ".png");

    }

    @Test
    public void test4CriarUsuario(){
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


    @Test public void test5verificarKidsMode(){



        //Entrar no Perfil
        Navegador.findElement(By.xpath("//*[@id=\"remove-main-padding_index\"]/div/div/section/ul/div[3]/div/div")).click();

        // Pesquisar Adulto
        Navegador.findElement(By.cssSelector("#nav-list > span:nth-child(3) > a")).click();

        //Pesquisar Adulto
        Navegador.findElement(By.cssSelector("#explore-ui-main-content-container > div._1r8f3tq5.xgfbc13ua.xgfbc13ia.xgfbc15o > input")).sendKeys("Roger Rabbit");

        //Pesquisa Adulto
        WebElement me = Navegador.findElement(By.cssSelector("#explore-ui-main-content-container > div._1r8f3tqg.xgfbc1c.xgfbc11xu"));
        WebDriverWait wait = new WebDriverWait(Navegador,10);
        wait.until(ExpectedConditions.visibilityOf(me));


        String textoNoElemento = me.getText();
        Assert.assertEquals("Nenhum resultado encontrado para \"Roger Rabbit\"",textoNoElemento);


        Screenshoot.tirar(Navegador, "C:\\Users\\dougl\\Desktop\\Cursos\\WebAutomationJava\\src\\testReport"+ Generator.dataHoraArquivo() + test.getMethodName() + "adultMovie.png");

        //Pesquisa Kids
        Navegador.findElement(By.cssSelector("#explore-ui-main-content-container > div._1r8f3tq5.xgfbc13ua.xgfbc13ia.xgfbc15o > input")).clear();

        Navegador.findElement(By.cssSelector("#explore-ui-main-content-container > div._1r8f3tq5.xgfbc13ua.xgfbc13ia.xgfbc15o > input")).sendKeys("A casa do Myckey Mouse");
        WebElement me2 = Navegador.findElement(By.xpath("//*[@id=\"explore-ui-main-content-container\"]/div[2]/div/div/section/div/div/a/div[2]/div[1]/span"));
        String textoNoElemento2 = me2.getText();
        Assert.assertEquals("A Casa do Mickey Mouse",textoNoElemento2);

        wait.until(ExpectedConditions.visibilityOf(me2));

        Screenshoot.tirar(Navegador, "C:\\Users\\dougl\\Desktop\\Cursos\\WebAutomationJava\\src\\testReport"+ Generator.dataHoraArquivo() + test.getMethodName() + "kidsMovie.png");

    }


    @Test public void test6editarUsuario(){

        WebDriverWait wait = new WebDriverWait(Navegador,10);


        //Clicar em Editar Perfil
        Navegador.findElement(By.cssSelector("nav > button")).click();
        // Clicar no Perfil
        Navegador.findElement(By.xpath("//*[@id=\"remove-main-padding_index\"]/div/section/ul/div[3]")).click();
        //Mudar nome para Profile
        WebElement elementEditProfile = Navegador.findElement(By.xpath("//*[@id=\"editProfile\"]"));
        wait.until(ExpectedConditions.visibilityOf(elementEditProfile));
        elementEditProfile.sendKeys(Keys.CONTROL + "a");
        elementEditProfile.sendKeys("Profile");
        //Mudar para modo Adulto div:nth-child(3) >
        Navegador.findElement(By.cssSelector("div:nth-child(3) > div:nth-child(2) > label")).click();
        //Colocar Senha
        Navegador.findElement(By.id("password")).sendKeys("Dougl@s020498");
        //Clicar em Salvar #remove-main-padding_index > div > nav > button
        Navegador.findElement(By.id("password-continue-login")).click();

        //Clicar em Pronto

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("#app_index > div.sc-dHmInP.fcdCun > div > div")));
        Navegador.findElement(By.cssSelector("#remove-main-padding_index > div > nav > button")).click();
        // Assert
        Screenshoot.tirar(Navegador, "C:\\Users\\dougl\\Desktop\\Cursos\\WebAutomationJava\\src\\testReport"+ Generator.dataHoraArquivo() + test.getMethodName() + "adultMovie.png");

        WebElement me2 = Navegador.findElement(By.xpath("//*[@id=\"remove-main-padding_index\"]/div/section/ul/div[3]/div/h3"));
        String textProfileChange = me2.getText();
        Assert.assertEquals("Profile",textProfileChange);

    }

    @Test public void test7verificarAdulto(){
        // Clicar no Perfil
        Navegador.findElement(By.xpath("//*[@id=\"remove-main-padding_index\"]/div/div/section/ul/div[3]/div/div")).click();

        WebElement me = Navegador.findElement(By.xpath("//*[@id=\"explore-ui-main-content-container\"]/div[3]/div"));
        String textoNoElemento = me.getText();
        Assert.assertEquals("Destaques Star",textoNoElemento);

        // Pesquisar Filme Adulto

        Navegador.findElement(By.cssSelector("#nav-list > span:nth-child(3) > a")).click();
        WebElement movieTitle = Navegador.findElement(By.cssSelector("#explore-ui-main-content-container > div._1r8f3tq5.xgfbc13ua.xgfbc13ia.xgfbc15o > input"));
        movieTitle.sendKeys("Roger Rabbit");

        movieTitle = Navegador.findElement(By.xpath("//*[@id=\"explore-ui-main-content-container\"]/div[2]/div/div/section/div/div/a/div[2]/div[1]"));
        String textMovie = movieTitle.getText();
        Assert.assertEquals("Uma Cilada para Roger Rabbit",textMovie);
        Screenshoot.tirar(Navegador, "C:\\Users\\dougl\\Desktop\\Cursos\\WebAutomationJava\\src\\testReport"+ Generator.dataHoraArquivo() + test.getMethodName() + ".png");

        // Assert
    }

    @Test public void test8excluirPerfil(){
        //Clicar em Editar Perfil
        Navegador.findElement(By.cssSelector("nav > button")).click();
        // Clicar no 3 Perfil
        Navegador.findElement(By.xpath("//*[@id=\"remove-main-padding_index\"]/div/section/ul/div[3]")).click();
        //Clicar em Excluir Perfil
        Navegador.findElement(By.xpath("//*[@id=\"remove-main-padding_index\"]/div/div/form/div[2]/div[2]/button")).click();
        //Confirmar a exclusao no PopUp
        Navegador.findElement(By.xpath("//*[@id=\"app_index\"]/div[2]/div/div/div/button[2]")).click();
        // Assert
        WebDriverWait wait = new WebDriverWait(Navegador, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\\\"remove-main-padding_index\\\"]/div/section/ul/div[3]\"")));
    }

    @After
    public void TearDown() throws Exception {
       Navegador.quit();
    }
}
