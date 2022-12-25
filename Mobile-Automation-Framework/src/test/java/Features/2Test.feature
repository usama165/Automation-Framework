Feature: dropdown
  @reg
  Scenario: ClickDropDownXY
    And Wait for 10000
    And getDropdownThroughtCoordinates

  Scenario: tradeDropdown
    And Wait for 5000
    And Click Button "tradeScreenButton"
    And Wait for 4000

    And Click Button "accountDropdownclick"
    And Wait for 2000
    And getDropdownList "accountDropdownList" "accountDropdownValues"

  Scenario: Verify Market Data agreement is not accepted
    And Wait for 4000
    And Click Button "CreateWatchlist"
    Given Fill TextBox "AddWatchlistName" "Test"
    And Click Button "ClickCreateButton"
    And Wait for 2000
 #   Given Fill Multiple Symbols in watchlist
      |Symbol|
      |QQQ|
    And Wait for 3000
   # And validatemarketDataagreementacceptedornot "Marketagree"

  @reg
  Scenario: Delete watchList TC0007
    And Wait for 4000
    And Click Button "CreateWatchlist"
    Given Fill TextBox "AddWatchlistName" "Test"
    And Click Button "ClickCreateButton"
    And Wait for 2000
    And Click Button "openSideDrawer"
    And Wait for 4000
    And Click Button "clickOnManageWatchlistButton"
    And Wait for 2000
    Given Addmultiplewatchlists
      |Symbol|
      |M1|
      |M2|
      |M3|
    And Wait for 2000
    And Click Button "clickOnSelectAll"
    And Click Button "removeButtonManageWatchlist"
    And Wait for 2000
    And Click Button "PopupButtonManageWatchlist"
    And Wait for 2000
    And Click Button "backButtonManageWatchlist"
    And Validate text of label key "noSymbolOnWatchlist" value "You have no watchlist added."


  Scenario: Add watchList throught the manage watchlist TC0008
    And Wait for 4000
    And Click Button "CreateWatchlist"
    Given Fill TextBox "AddWatchlistName" "Test"
    And Click Button "ClickCreateButton"
    And Wait for 2000
    And Click Button "openSideDrawer"
    And Wait for 4000
    And Click Button "clickOnManageWatchlistButton"
    And Wait for 2000
    Given Addmultiplewatchlists
      |Symbol|
      |M1|
      |M2|
      |M3|



  Scenario : Watchlist Popup
    And Wait for 5000
    Then Check the Presence of "WatchListPopupexistance"


  Scenario: WatchList Exist or not
    And Wait for 5000
    And Click Button "CreateWatchlist"
    Given Fill TextBox "AddWatchlistName" "Test"
    And Click Button "ClickCreateButton"
    And WatchList is created "WatchListExist"