#language: pt
#encoding: UTF-8

  @web
  Funcionalidade: Utilizar os cupons disponibilizados
    Contexto:
      Dado que estou na pagina principal sem ter feito o login

    @cupomFreteGratis
    Cenario: Validar a utilizacao do cupom de frete gratis

      E  acessar a pagina Minha Conta
      E clicar no botao prosseguir com o e-mail preenchido corretamente
      Quando realizar uma compra utilizando o cupom "FRETEGRATIS"
      Entao deve ser validado a apresentação da mensagem de sucesso
