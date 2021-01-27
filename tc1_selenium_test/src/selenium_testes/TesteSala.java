package selenium_testes;

import model.Sala;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class TesteSala {

    public static void main(String[] args) throws InterruptedException {
        Sala sala = new Sala();
        Map<String, Boolean> tipoExibicao= new HashMap<>();

        sala.salas = sala.carregaSalas();


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

        //clica no item de menu cadastrar novo filme
        driver.findElement(By.linkText("Cadastrar nova Sala")).click();

        String titulo = driver.getTitle();
        if(titulo.equals("Cadastar nova Sala")) {
            System.out.println("Estamos na página correta");
            driver.findElement(By.id("codigo")).sendKeys("8");
            driver.findElement(By.id("nome")).sendKeys("Sala 8");
            driver.findElement(By.id("capacidade")).sendKeys("35");

            //Check Box
            WebElement cb2D = driver.findElement(By.id("2d"));
            WebElement cb3D = driver.findElement(By.id("3d"));
            WebElement cbOutros = driver.findElement(By.id("Outros"));
            //Alternando clicks entre os checkbox
            cb2D.click();
            cb3D.click();
            cbOutros.click();
            Thread.sleep(1000);
            cb3D.click();
            Thread.sleep(1000);
            cbOutros.click();
            Thread.sleep(1000);
            cb3D.click();
            Thread.sleep(1000);
            cb2D.click();

            //Radio Button
            WebElement radio1 = driver.findElement(By.id("true"));
            WebElement radio2 = driver.findElement(By.id("false"));
            //Alternando clicks entre os radio buttons
            radio1.click();
            Thread.sleep(1000);
            radio2.click();
            Thread.sleep(1000);
            radio1.click();

            driver.findElement(By.id("telefone")).sendKeys("123456789");


            Thread.sleep(1000);

            //Obtendo dados de uma nova sala

            //Tipos de exibição
            tipoExibicao.put("2d", cb2D.isSelected());
            tipoExibicao.put("3d", cb3D.isSelected());
            tipoExibicao.put("outros", cbOutros.isSelected());

            //Sala acessível
            Boolean salaAcessivel;
            salaAcessivel = (radio1.isSelected()) ? true : false;

            Sala novaSala = new Sala(
                    Integer.parseInt(driver.findElement(By.id("codigo")).getAttribute("value")),
                    Integer.parseInt(driver.findElement(By.id("capacidade")).getAttribute("value")),
                    driver.findElement(By.id("nome")).getAttribute("value"),
                    driver.findElement(By.id("telefone")).getAttribute("value"),
                    salaAcessivel,
                    tipoExibicao
            );

//            System.out.println(novaSala.getTipoExibicao().get("2d"));

            sala.incluirSala(sala.salas, novaSala);

            //Print no terminal apenas para confirmar a inclusão do filme
            for (Sala s : sala.salas) {
                System.out.println(s.toString());
            }
            System.out.println("Filme cadastrado com sucesso");
        }
        Thread.sleep(2000);
        driver.close();
    }
}
