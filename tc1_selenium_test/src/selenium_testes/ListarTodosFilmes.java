package selenium_testes;

import model.Filme;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.management.snmp.jvmmib.JVM_MANAGEMENT_MIBOidTable;

import java.util.ArrayList;

public class ListarTodosFilmes {


    public static void main(String[] args) throws InterruptedException {
        Filme filme = new Filme();

        //Iniciando o teste com uma lista vazia
        ArrayList <Filme> todosFilmes = filme.filmes;

        //INFORMA O DIRETORIO DO MOTOR CHROME PARA O SELENIUM
        String userPath = System.getProperty("user.dir");
        String chromeDriverPath = userPath + "/lib/chromeDriver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        WebDriver driver = new ChromeDriver();
        String url = "http://localhost/view/index.html";
        //O método get abre uma página de uma certa url.
        driver.get(url);
        driver.manage().window().maximize();

        Thread.sleep(1500);

        //clica no item de menu Listar todos os Filmes
        driver.findElement(By.linkText("Listar todos os Filmes")).click();

        //Chama método responsável por verificar se existe filmes cadastrados
        //e navegar pelas páginas
        ListarTodosFilmes.verificaListaFilmes(todosFilmes, url, driver);

        //Acrescentando um conjunto de filmes a lista para teste
        todosFilmes = filme.carregaFilmes(filme.filmes);

        String titulo = driver.getTitle();
        // Teste para verificar se voltamos ao menu principal de forma a evitar erros
        if(titulo.equals("Menu Principal Cinema")){
            //Chama método responsável por verificar se existe filmes cadastrados
            //e navegar pelas páginas
            ListarTodosFilmes.verificaListaFilmes(todosFilmes, url, driver);
        }


        Thread.sleep(2000);
        driver.close();
    }

    private static void verificaListaFilmes(ArrayList<Filme> todosFilmes, String url, WebDriver driver) throws InterruptedException {
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

            Integer i = 0;

            while(i < todosFilmes.size()){
                if (i == 0 ){
                    //JS incluí o atributo readonly no campo "código" do formulário
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    WebElement codigoElement = driver.findElement(By.id("anterior"));
                    js.executeScript("document.getElementById('anterior').setAttribute('disabled',true)", codigoElement);
                }

            }

            /*for (int i = 0; i < todosFilmes.size();) {
                if (i == 0){
                    System.out.println("primeiro elemento");
                    i++;
                } else  if (i < todosFilmes.size()-1){
                    System.out.println("não chegou no último");
                    i++;
                } else{
                    System.out.println("chegamos ao último");
                    i--;
                }
            }*/
        }
    }
}
