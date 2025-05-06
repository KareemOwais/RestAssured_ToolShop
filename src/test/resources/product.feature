Feature: Product API

  Scenario: Create Product
    Given A brand is Created
    And  Category is Created
    And Product is Created with name "KareemTest123"
    When the product is retrieved
    Then the product name should be correct

  Scenario: Update Product
    Given Product exists in database
    When Product Name is updated to "TestKareem123" and Price is updated to 10
    Then Product Name and Price should be updated

  Scenario: Delete Product by Id
    Given Logged in as Admin
    And Product exists in database
    When Product is Deleted
    Then Product ID Shouldn't exist


