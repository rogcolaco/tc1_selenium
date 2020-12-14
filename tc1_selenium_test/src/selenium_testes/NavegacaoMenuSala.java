package selenium_testes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavegacaoMenuSala {
    public static void main(String[] args) throws InterruptedException {
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

        //Verifica comportamento do item de menu cadastrar nova sala
        driver.findElement(By.linkText("Cadastrar nova Sala")).click();

        Thread.sleep(2000);

        //Ir para a página anterior
        driver.navigate().back();
        Thread.sleep(2000);

        //Ir para a próxima posterior novamente
        driver.navigate().forward();
        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(2000);

        //Verifica comportamento do item de menu Listar uma Sala
        driver.findElement(By.linkText("Listar uma Sala")).click();

        Thread.sleep(2000);

        //Ir para a página anterior
        driver.navigate().back();
        Thread.sleep(2000);

        //Ir para a próxima posterior novamente
        driver.navigate().forward();
        Thread.sleep(2000);

        driver.navigate().back();
    }
}
