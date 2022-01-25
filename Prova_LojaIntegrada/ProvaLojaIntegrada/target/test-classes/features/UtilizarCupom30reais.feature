#language: pt
#encoding: UTF-8

  @web
  Funcionalidade: Utilizar os cupons disponibilizados
    Contexto:
      Dado que estou na pagina principal sem ter feito o login

    @cupom30Reais
    Cenario:  Validar a utilizacao do cupom de 30 reais de desconto

      E  acessar a pagina Minha Conta
      E clicar no botao prosseguir com o e-mail preenchido corretamente
      Quando realizar uma compra utilizando o cupom "30REAIS"
      Entao deve ser validado a apresentação da mensagem de sucesso