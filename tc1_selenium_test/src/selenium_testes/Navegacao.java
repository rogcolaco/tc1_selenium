package selenium_testes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navegacao {
    public static void main(String[] args) throws InterruptedException {
        //INFORMA O DIRETORIO DO MOTOR CHROME PARA O SELENIUM
        String userPath = System.getProperty("user.dir");
        String chromeDriverPath = userPath + "/lib/chromeDriver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        WebDriver driver = new ChromeDriver();
        String url = "http://localhost/04_TC1/Aula-08/01_Aula08_SeleniumWebDriver_Parte2.html";
        //O método get abre uma página de uma certa url.
        driver.get(url);
        driver.manage().window().maximize();
    }
}
