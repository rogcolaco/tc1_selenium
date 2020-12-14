package selenium_testes;

import com.sun.org.apache.xml.internal.resolver.helpers.BootstrapResolver;
import model.Filme;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.jnlp.ClipboardService;
import java.util.ArrayList;

public class TesteFilme {

    public static void main(String[] args) throws InterruptedException {
        Filme filme = new Filme();
        //ArrayList<Filme> filmes;

        //INFORMA O DIRETORIO DO MOTOR CHROME PARA O SELENIUM
        String userPath = System.getProperty("user.dir");
        String chromeDriverPath = userPath + "/lib/chromeDriver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        WebDriver driver = new ChromeDriver();
        String url = "http://localhost/view/index.html";
        //O método get abre uma página de uma certa url.
        driver.get(url);
        driver.manage().window().maximize();

        Thread.sleep(2000);

        //Verifica comportamento do item de menu cadastrar novo filme
        driver.findElement(By.linkText("Cadastrar novo Filme")).click();

        String titulo = driver.getTitle();
        if(titulo.equals("Cadastrar Novo Filme")){
            System.out.println("Estamos na página correta");
            driver.findElement(By.id("codigo")).sendKeys("1");
            driver.findElement(By.id("nome")).sendKeys("O Poderoso Chefão");
            driver.findElement(By.id("lancamento")).sendKeys("1970");
            driver.findElement(By.id("diretor")).sendKeys("Coppolla");
            driver.findElement(By.id("ator")).sendKeys("Marlon Brando");

            Thread.sleep(1000);

            //Obtendo dados do novo filme
            Filme novofilme = new Filme(
                    Integer.parseInt(driver.findElement(By.id("codigo")).getAttribute("value")),
                    Integer.parseInt(driver.findElement(By.id("lancamento")).getAttribute("value")),
                    driver.findElement(By.id("nome")).getAttribute("value"),
                    driver.findElement(By.id("diretor")).getAttribute("value"),
                    driver.findElement(By.id("ator")).getAttribute("value")
            );

            filme.incluirFilme(filme.filmes,novofilme);

            //Print no terminal apenas para confirmar a inclusão do filme
            for(Filme f : filme.filmes){
                System.out.println(f.toString());
            }


        } else {
            System.out.println("Estamos na página errada");

        }

        driver.close();

    }
}
