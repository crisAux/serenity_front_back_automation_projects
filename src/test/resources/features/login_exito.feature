Feature: Login de un usuario comprador
  Como un usuario comprador
  Yo quiero ingresar a la plataforma del exito
  Para poder realizar compras

  Scenario: Realizar ingreso de un usuario comprador
    Given Cesar esta en la pagina principal de exito
    When Cesar se autentica con su respectivo usuario y password
    Then Cesar Puede ingresar con exito a la plataforma del exito