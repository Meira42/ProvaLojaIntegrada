package pages;

import beans.Evidence;
import beans.ValuesHelper;
import static org.junit.Assert.*;

import com.itextpdf.text.DocumentException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static core.DriverFactory.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FormularioDeCadastroPage extends BasePage {
	private static final Logger log = LoggerFactory.getLogger(FormularioDeCadastroPage.class);

	public FormularioDeCadastroPage() {
		PageFactory.initElements(getDriver(), this);
	}

	ValuesHelper helper = new ValuesHelper();
	Evidence evidence = new Evidence();

	@FindBy(className = "span8")
	private WebElement inpPreencherEmailCadastrar;
	
	@FindBy(xpath = "//*[@id=\"id_email\"]")
	private WebElement inpLogin;
	
	@FindBy(xpath = "//*[@id=\"id_senha\"]")
	private WebElement inpSenhalogin;
	
	@FindBy(id = "id_email")
	private WebElement inpEmail;
	
	@FindBy(id = "id_confirmacao_email")
	private WebElement inpConfirmEmail;

	@FindBy(id = "id_senha")
	private WebElement inpSenha;

	@FindBy(id = "id_confirmacao_senha")
	private WebElement inpConfirmSenha;

	@FindBy(id = "id_nome")
	private WebElement inpNome;

	@FindBy(id = "id_cpf")
	private WebElement inpCpf;

	@FindBy(id = "id_telefone_celular")
	private WebElement inpTelefone;

	@FindBy(id = "id_telefone_principal")
	private WebElement inpTelefonePrincipal;

	@FindBy(id = "id_data_nascimento")
	private WebElement inpDataNascimento;

	@FindBy(id = "id_cep")
	private WebElement inpCep;

	@FindBy(id = "id_endereco")
	private WebElement inpEndereco;

	@FindBy(id = "id_numero")
	private WebElement inpNumero;

	@FindBy(id = "id_bairro")
	private WebElement inpBairro;

	@FindBy(id = "id_cidade")
	private WebElement inpCidade;

	// ================== IDENTIFICADOR BOTÕES ===================

	@FindBy(id = "id_estado")
	private WebElement btnEstado;

	@FindBy(xpath = "//*[@id=\"cabecalho\"]/div[2]/div[1]/div[2]/div[1]/div[2]/ul/li[2]/a")
	private WebElement btnCriarConta;

	@FindBy(className = "botao principal")
	private WebElement btnCadastrar;

	public void validateAccessFormRegistration() throws DocumentException {
		log.info("Início da validação de acesso ao formulário de cadastro");
		evidence.evidenciaPorPagina("Página de cadastro exibido");
	}

	public void fillFormRegistration() throws DocumentException {
		log.info("Início do preenchimento do formulário de cadastro");

		assertTrue(inpPreencherEmailCadastrar.isDisplayed());
		inpPreencherEmailCadastrar.click();
		inpPreencherEmailCadastrar.sendKeys ("teste123@teste.com");

		assertTrue(inpConfirmEmail.isDisplayed());
		inpConfirmEmail.click();
		inpConfirmEmail.sendKeys ("teste123@teste.com");

		assertTrue(inpSenha.isDisplayed());
		inpSenha.click();
		inpSenha.sendKeys("teste123");

		assertTrue(inpConfirmSenha.isDisplayed());
		inpConfirmSenha.click();
		inpConfirmSenha.sendKeys( "teste123");

		assertTrue(inpNome.isDisplayed());
		inpNome.click();
		inpNome.sendKeys ("João Teste da Silva");

		assertTrue(inpCpf.isDisplayed());
		inpCpf.click();
		inpCpf.sendKeys ("358.897.090-89");

		assertTrue(inpTelefone.isDisplayed());
		inpTelefone.click();
		inpTelefone.sendKeys ("99999999999");

		assertTrue(inpTelefonePrincipal.isDisplayed());
		inpTelefonePrincipal.click();
		inpTelefonePrincipal.sendKeys ("88888888888");

		assertTrue(inpDataNascimento.isDisplayed());
		inpDataNascimento.click();
		inpDataNascimento.sendKeys ("1011990");

		assertTrue(inpCep.isDisplayed());
		inpCep.click();
		inpCep.sendKeys ("05731-250");

		assertTrue(inpEndereco.isDisplayed());
		inpEndereco.click();
		inpEndereco.sendKeys( "Avenida das Belezas");

		assertTrue(inpNumero.isDisplayed());
		inpNumero.click();
		inpNumero.sendKeys( "123");

		assertTrue(inpBairro.isDisplayed());
		inpBairro.click();
		inpBairro.sendKeys( "Vila Plana");

		assertTrue(inpCidade.isDisplayed());
		inpCidade.click();
		inpCidade.sendKeys( "São Paulo");

		
		evidence.evidenciaPorPagina("Formulário de cadastro preenchido");
	}
	
	// =================== BOTÕES ========================
	
	public void preencherLogin() throws DocumentException{
		inpLogin.click();
		inpLogin.sendKeys("teste123@teste.com");
		inpSenhalogin.click();
		inpSenhalogin.sendKeys("teste123");		
	}
	
	public void preencherEmail() {
		inpPreencherEmailCadastrar.click();
		inpPreencherEmailCadastrar.sendKeys("teste123@teste.com");
	}
	
	public void clickCriarConta() {
		btnCriarConta.click();
	}
	
	public void clickCadastrar() {
		btnCadastrar.click();
	}
	// ================= SELECIONAR GENERO ======================

	@FindBy(id = "id_sexo")
	private WebElement btnGenero;

	@FindBy(xpath = "//*[@id=\"id_sexo\"]/option[2]")
	private WebElement btnGeneroM;

	public void selectGenero() throws DocumentException {
		log.info("===  Seleção genero ====");
		log.info("Início da seleção do genero");
		WebElement optSwitchTheme = getDriver().findElement(By.xpath("//*[@id=\"id_sexo\"]/option[2]"));

		String optionSwitchTheme = "Masculino";
		if (btnGeneroM.isDisplayed()) {
			btnGeneroM.click();
			evidence.evidenciaPorPagina("Seleção aberta");
			assertEquals(optionSwitchTheme, optSwitchTheme.getText());
			optSwitchTheme.click();
			evidence.evidenciaPorPagina("Troca de tema para Masculino");
		} else {
			log.info("Falha em selecionar elemento");
			assertTrue(false);
		}
	}

// ================= SELECIONAR ESTADO ======================

	@FindBy(id = "id_estado")
	private WebElement idEstado;

	@FindBy(xpath = "//*[@id=\"id_estado\"]/option[25]")
	private WebElement btnEstadoSP;

	public void selectEstado() throws DocumentException {
		log.info("===  Seleção Estado ====");
		log.info("Início da seleção do Estado");
		WebElement optSwitchTheme = getDriver().findElement(By.xpath("//*[@id=\"id_estado\"]/option[25]"));

		String optionSwitchTheme = "São Paulo";
		if (btnGeneroM.isDisplayed()) {
			btnGeneroM.click();
			evidence.evidenciaPorPagina("Seleção aberta");
			assertEquals(optionSwitchTheme, optSwitchTheme.getText());
			optSwitchTheme.click();
			evidence.evidenciaPorPagina("Troca de tema para SP");
		} else {
			log.info("Falha em selecionar elemento");
			assertTrue(false);
		}
	}
}
