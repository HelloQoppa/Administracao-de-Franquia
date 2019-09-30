package selenium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium {

	public WebDriver driver = new ChromeDriver();

	@Before
	public void testeChrome() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\luiiz\\git\\TesteQ\\lib\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://localhost:8081/Teste_Qualidade/login");

	}

	@Test
	public void telaAdmin(String nome) {
		WebElement elementNome = driver.findElement(By.id("nome"));
		elementNome.sendKeys(nome);
	}

	@Test
	public void telaSenha(String senha) {
		WebElement elementSenha = driver.findElement(By.id("senha"));
		elementSenha.sendKeys(senha);
	}

	@Test
	public void btnEnviar() {
		WebElement elementButton = driver.findElement(By.id("enviarBTN"));
		elementButton.click();
	}

	@Test
	public void testeFranqueado() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\luiiz\\git\\TesteQ\\lib\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://localhost:8081/Teste_Qualidade/franqueado.jsp");

		WebElement elementNome = driver.findElement(By.id("nome"));
		elementNome.sendKeys("Luiz");

		WebElement elementSobrenome = driver.findElement(By.id("sobrenome"));
		elementSobrenome.sendKeys("Borges");

		WebElement elementDataNascimento = driver.findElement(By.id("datanascimento"));
		elementDataNascimento.sendKeys("22/04/1997");

		WebElement elementCpf = driver.findElement(By.id("cpf"));
		elementCpf.sendKeys("40585248515");

		WebElement elementEmail = driver.findElement(By.id("email"));
		elementEmail.sendKeys("luiz.junior@ucsal.edu.br");

		WebElement elementCelular = driver.findElement(By.id("celular"));
		elementCelular.sendKeys("71995078415");

		WebElement elementResidencial = driver.findElement(By.id("residencial"));
		elementResidencial.sendKeys("7133154788");

		WebElement elementComercial = driver.findElement(By.id("comercial"));
		elementComercial.sendKeys("7132155787");

		WebElement elementEndereco = driver.findElement(By.id("endereco"));
		elementEndereco.sendKeys("Rua de Pituaçu");

		WebElement elementBairro = driver.findElement(By.id("bairro"));
		elementBairro.sendKeys("Pituaçu");

		WebElement elementCep = driver.findElement(By.id("cep"));
		elementCep.sendKeys("40320185");

		WebElement elementCidade = driver.findElement(By.id("cidade"));
		elementCidade.sendKeys("Salvador");

		WebElement elementEstado = driver.findElement(By.id("estado"));
		elementEstado.sendKeys("Bahia");

		WebElement elementButton = driver.findElement(By.id("enviarBtn"));
		elementButton.click();

		driver.get("http://localhost:8081/Teste_Qualidade/franqueadolist.jsp");
	}

}
