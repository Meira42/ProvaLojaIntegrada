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


public class FormularioDeCadastroStep {
	FormularioDeCadastroPage form = new FormularioDeCadastroPage();
	ThreadHelper thread = new ThreadHelper ();
	BasePage base = new BasePage();
	DriverFactory fact = new DriverFactory();

	@Dado("que estou na pagina principal sem ter feito o login")
	public void que_estou_na_pagina_principal_sem_ter_feito_o_login() {
		
	}

	@E("acessar a pagina minha conta")
	public void acessar_a_pagina_minha_conta(){
		form.clickCriarConta();
	}

	@E("clicar no botao cadastrar com o email preenchido corretamente")
	public void clicar_no_botao_cadastrar_com_o_email_preenchido_corretamente() throws InterruptedException{
		form.preencherEmail();
		form.clickCadastrar();

	}

	@Quando("preencher o formulario com todos os dados")
	public void preencher_o_formulario_com_todos_os_dados() throws DocumentException {
			form.fillFormRegistration();
			form.selectGenero();
			form.selectEstado();
			form.clickCadastrar();
	}

	@Entao("deve ser validado a apresenta??o da mensagem de sucesso")
	public void deve_ser_validado_a_apresenta_o_da_mensagem_de_sucesso() throws InterruptedException {
		base.takeScreenshot("Validação de sucesso de cadastro");
		ThreadHelper.espera(5000);
		DriverFactory.killDriver();
	}

}
