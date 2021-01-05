package selenium_testes;

import model.Filme;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class ListarTodosFilmes {

    public static void main(String[] args) throws InterruptedException {
        Filme filme = new Filme();

        //Iniciando o teste com uma lista vazia
        ArrayList <Filme> todosFilmes = filme.filmes;
        //ArrayList <Filme> todosFilmes = filme.carregaFilmes(filme.filmes);

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

        //clica no item de menu Listar todos os Filmes
        driver.findElement(By.linkText("Listar todos os Filmes")).click();

        if(todosFilmes.isEmpty()){
            System.out.println("lista vazia");
            url = "http://localhost/view/nullFilmes.html";
            driver.findElement(By.linkText("Listar todos os Filmes")).click();
            driver.get(url);
            Thread.sleep(1500);

            //Testes de navegação as páginas são as mesmas testadas na classe TesteFilme
            driver.findElement(By.linkText("Cadastrar novo Filme")).click();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
            driver.findElement(By.linkText("Voltar ao Menu Principal")).click();
            Thread.sleep(2000);

        } else {
            System.out.println("lista com elementos");
            url = "http://localhost/view/todosFilmes.html";
            driver.findElement(By.linkText("Listar todos os Filmes")).click();
            driver.get(url);
        }

        Thread.sleep(2000);
        driver.close();
    }
}
