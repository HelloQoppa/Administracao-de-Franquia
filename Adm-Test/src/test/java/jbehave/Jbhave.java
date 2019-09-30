package jbehave;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Jbhave extends StoryBase {

	static WebDriver driverChrome;

	@Given("estou na tela de login")
	public void abrirTelaLogin() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\luiiz\\git\\TesteQ\\lib\\chromedriver.exe");
		driverChrome = new ChromeDriver();
		driverChrome.get("../src/main/webapp/login.jsp");
	}

	@When("informo que meu login e o $login")
	public void acessandoLogin(String login) {
		WebElement log = driverChrome.findElement(By.id("nome"));
		log.sendKeys("login");
	}

	@When("informo minha senha  $senha")
	public void acessandoSenha(String senha) {
		WebElement sen = driverChrome.findElement(By.id("senha"));
		sen.sendKeys("senha");
	}

	@When("Clico em login")
	public void clicarNoBotaoEbvuar() {
		WebElement btnLogin = driverChrome.findElement(By.id("enviarBTN"));
		btnLogin.click();
	}

}