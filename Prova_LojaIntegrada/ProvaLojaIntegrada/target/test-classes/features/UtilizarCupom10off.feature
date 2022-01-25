#language: pt
#encoding: UTF-8

  @web
  Funcionalidade: Utilizar os cupons disponibilizados
    Contexto:
      Dado que estou na pagina principal sem ter feito o login

    @cupomOff10
    Cenario:  Validar a utilizacao do cupom de 10 por cento de desconto

      E  acessar a pagina Minha Conta
      E clicar no botao prosseguir com o e-mail preenchido corretamente
      Quando realizar uma compra utilizando o cupom "10OFF"
      Entao deve ser validado a apresentação da mensagem de sucesso
      