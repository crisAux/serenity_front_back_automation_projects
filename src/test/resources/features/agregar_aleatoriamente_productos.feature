Feature: Agregar varios productos a carrito de compras
  Como un usuario comprador
  Yo quiero agregar varias productos al carrito
  Para poder realizar compras

  Scenario: Agregar varios productos al carrito de compras
    Given Cesar esta en la seccion de cabeceras de la categoria de dormitorio
    When Cesar agrega varios de estos productos al carrito de compras
    Then Cesar Puede ingresar con exito a la plataforma del exito