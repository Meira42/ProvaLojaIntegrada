package pages;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import beans.Evidence;
import beans.ValuesHelper;

public class UtilizarCuponsPage extends FormularioDeCadastroPage {

	public UtilizarCuponsPage() {
		PageFactory.initElements(getDriver(), this);
	}

	ValuesHelper helper = new ValuesHelper();
	Evidence evidence = new Evidence();
	
	@FindBy(xpath = "//div[contains(text(),'Usar cupom')]")
	private WebElement titleCupom;

	@FindBy(xpath = "//div[contains(text(),'[CATEGORIA] Produto com categoria - 1 Nível')]")
	private WebElement titleProduto1;
	
	@FindBy(xpath = "//div[contains(text(),'[CATEGORIA] Produto com categoria - 2 Nível')]")
	private WebElement titleProduto2;
	
	@FindBy(xpath = "//div[contains(text(),'[CATEGORIA] Produto com categoria - 3 Nível')]")
	private WebElement titleProduto3;
	
	// ================== IDENTIFICADOR BOTÕES ===================
	
	@FindBy(className = "botao botao-comprar principal grande" )
	private WebElement btnComprar;
	
	@FindBy(className = "botao-comprar principal grande" )
	private WebElement btnFinalizarCompra1;
	
	@FindBy(id = "formaEnvio2-pac" )
	private WebElement btnFormaEnvio;
	
	@FindBy(id = "radio-mercadopagov1-520160" )
	private WebElement btnFormaPagamento;
	
	@FindBy(className = "botao botao-comprar principal grande" )
	private WebElement btnFinalizarCompra2;
	
	// ==================== BOTÕES ================================
	
	public void preencherCupom(String cupom) {
		titleCupom.click();
		titleCupom.sendKeys(cupom);
	}

	public void comprarProduto1() {
		titleProduto1.click();
	}
	
	public void comprarProduto2() {
		titleProduto2.click();
	}
	
	public void comprarProduto3() {
		titleProduto3.click();
	}
	
	public void finalizarCompra1() {
		btnFinalizarCompra1.click();
	}
	
	public void finalizarCompra2() {
		btnFinalizarCompra2.click();
	}
	
	public void formaEnvio() {
		btnFormaEnvio.click();
	}
	
	public void formaPagamento() {
		btnFormaPagamento.click();
	}
}
