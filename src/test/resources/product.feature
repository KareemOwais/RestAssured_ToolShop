Feature: Product API

  Scenario: Get product by ID
    Given A brand is Created
    And Catergory is Created
    And Product is Created
    When the product is retrieved
    Then the product name should be "Product525"
