Feature: Position
  @reg
  Scenario: position grid
    And Wait for 5000
    And Click Button "PositionTab"
    And Wait for 5000
    Then Validate Values of Position List Symbol "MA", Position "Long" and Account ""
      | Key                   | Value |
      | PositionSymbolLabel   | MA    |
      | PositionQuantityLabel | 2,000 |
    Then Click on menu icon on Position Screen of Symbol "MA", Position "Long" and Account ""
    And Wait for 5000
    And Select Position Menu Option "Decrease"
