package web;

import com.itextpdf.text.DocumentException;

import core.DriverFactory;
import core.ThreadHelper;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.BasePage;
import pages.FormularioDeCadastroPage;
import pages.UtilizarCuponsPage;

public class UtilizarCupomFreteGratisStep extends BasePage {

	FormularioDeCadastroPage form = new FormularioDeCadastroPage();
	ThreadHelper thread = new ThreadHelper();
	BasePage base = new BasePage();
	DriverFactory fact = new DriverFactory();
	UtilizarCuponsPage Ucupom = new UtilizarCuponsPage();

	@Dado("que estou na pagina principal sem ter feito o login")
	public void que_estou_na_pagina_principal_sem_ter_feito_o_login() {

	}

	@E("acessar a pagina Minha Conta")
	public void acessar_a_pagina_Minha_Conta() {
		form.clickCriarConta();
	}

	@E("clicar no botao prosseguir com o e-mail preenchido corretamente")
	public void clicar_no_botao_prosseguir_com_o_e_mail_preenchido_corretamente() throws DocumentException {
		form.preencherLogin();
		form.clickCadastrar();
	}

	@Quando("realizar uma compra utilizando o cupom {string}")
	public void realizar_uma_compra_utilizando_o_cupom(String cupom) {
			Ucupom.comprarProduto1();
			Ucupom.finalizarCompra1();
			Ucupom.preencherCupom(cupom);
			Ucupom.formaPagamento();
			Ucupom.formaEnvio();
			Ucupom.finalizarCompra2();
	}

	@Entao("deve ser validado a apresenta??o da mensagem de sucesso")
	public void deve_ser_validado_a_apresenta_o_da_mensagem_de_sucesso() throws InterruptedException {
		base.takeScreenshot("Validação de compra utilizando cupom bem sucedida");
		ThreadHelper.espera(5000);
		DriverFactory.killDriver();

	}
}

