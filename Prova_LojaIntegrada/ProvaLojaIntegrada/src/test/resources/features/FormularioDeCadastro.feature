#language: pt
#encoding: UTF-8

  @web
  Funcionalidade: Realizar cadastro de dados de um usuario
    Contexto:
      Dado que estou na pagina principal sem ter feito o login

    @realizarCadastro
    Cenario: Validar cadastro com todos os dados preenchidos

      E acessar a pagina minha conta
      E clicar no botao cadastrar com o email preenchido corretamente
      Quando preencher o formulario com todos os dados
      Entao deve ser validado a apresentação da mensagem de sucesso

