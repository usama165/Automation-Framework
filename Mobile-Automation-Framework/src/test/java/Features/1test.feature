Feature: Test
  #@reg

  @reg
  Scenario: tradeDropdown
    And Wait for 5000
    And Click Button "tradeScreenButton"
    And Wait for 4000
    And Click Button "accountDropdownclick"
    And Wait for 4000

  #Scenario Outline: Test
   # And Wait for 10000
   # And Click Button "TradeTab"
   # Given Add Multiple Symbols of this file "src/test/resources/Symbols.txt" and verify Company Info
   # Given Fill TextBox "SymbolField" "MA"
   # And Click Button "AddSymbolIcon"
   # And Log Message "Info" "Symbol Added Successfully"
    #Given Fill TextBox "QuantityField" "<Quantity>"
   # And Click Button "SendOrderButton"
   # And Wait for 5000
    #And Click Button "ConfirmOrderYes"
   # Then Action on Order Successfully Created pop up "Ok"
    #Examples:
   #   | Symbol | Quantity | Account | Confirmation | Action |
   #   | MA     | 1000     | 1LOC-LOCA-123456-M | Yes          | OK     |
