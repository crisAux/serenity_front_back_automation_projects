Feature: Agregar varios productos a carrito de compras
  Como un usuario comprador
  Yo quiero agregar varias productos al carrito
  Para poder realizar compras

  Scenario: Agregar varios productos al carrito de compras
    Given Cesar esta en la seccion de cabeceras de la categoria de dormitorio
    When Cesar agrega de forma aleatoria varios de estos productos al carrito de compras en diferentes cantidades
    Then Cesar verifica que los nombres de los productos en el carrito de compras corresponda a lo agregado
    And Verifica que el total de los precios de los productos corresponda
    And Verifica que las cantidades de los productos sea lo agregado en el proceso
    And que el total de los productos sea igual a las cantidades de los productos agregados