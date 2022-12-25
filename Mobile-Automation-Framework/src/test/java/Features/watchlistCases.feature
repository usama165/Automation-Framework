Feature: CreateWatchlist


  Scenario:Validate Watchlist Popup
    And Wait for 3000
    And Click Button "addWatchlistButton"
    And Wait for 2000
    And Is Watchlist Popup Exist "WatchListPopupexistance"

  Scenario:Verify WatchList Is Not Existance
    And Wait for 5000
    And WatchList Existance Or Not "WatchListNotExist"

  Scenario:Verify WatchList Exist
    And Wait for 5000
    And Click Button "addWatchlistButton"
    Given Fill TextBox "AddWatchlistName" "Logiciel"
    And Click Button "watchlistPopCreateButton"
    And WatchList is created "WatchListExist"

  Scenario:Create WatchList By SideMenu And Check Validations in Watchlist Popup TC0003
    And Wait for 5000
    And Click Button "addWatchlistButton"
    Given Fill TextBox "AddWatchlistName" "Test"
    And Click Button "watchlistPopCreateButton"
    And Click Button "openSideDrawer"
    And Click Button "drawerAddWatchlistButton"
    And Wait for 2000
    And Validate text of label key "watchListNameLayout" value "Name Your Watchlist"
    And Click Button "watchlistPopCreateButton"
    And Wait for 4000
    And Validate text of label key "textinput_errorOFWatchlistPopup" value "Please Enter Watchlist name"



  Scenario:Validate Edit watchlist has no symbol TC0004
    And Wait for 5000
    And Click Button "addWatchlistButton"
    Given Fill TextBox "AddWatchlistName" "Test"
    And Click Button "watchlistPopCreateButton"
    And Click Button "editWatchList"
    And Wait for 2000
    And Validate text of label key "EmptyWatchlist" value "There are no symbols in this watchlist."



  Scenario:Add watchlist by Manage watchlist
  And Wait for 5000
  And Click Button "addWatchlistButton"
  And Wait for 2000
  Given Fill TextBox "AddWatchlistName" "Test"
  And Click Button "watchlistPopCreateButton"
  And Wait for 2000
  And Click Button "openSideDrawer"
  And Wait for 4000
  And Click Button "clickOnManageWatchlistButton"
    And Fill TextBox "ManageWatchlistTextBox" "Logiciel"
    And Click Button "AddButtonInManageWatchlist"
    And Validate symbolORWatchlist Existance "listOfWatchlistName"
      | key      |
      | Logiciel |
      | BMO      |


  Scenario:Add Symbols In Watchlist and Validate Symbols
    And Wait for 5000
    And Click Button "addWatchlistButton"
    Given Fill TextBox "AddWatchlistName" "Test"
    And Click Button "watchlistPopCreateButton"
    And Wait for 4000
    Given Fill Multiple Values "SymbolField"
      | key  |
      | QQQ  |
      | MSFT |
      | IBM  |
    Given Validate symbolORWatchlist Existance "symbolList"
      | key  |
      | QQQ  |
      | MSFT |
      | IBM  |




  Scenario:Check Watchlist Existance In Edit Watchlist Screen TC0004
    And Wait for 4000
    And Click Button "addWatchlistButton"
    Given Fill TextBox "AddWatchlistName" "Test"
    And Click Button "watchlistPopCreateButton"
    And Wait for 2000
    And Click Button "openSideDrawer"
    And Wait for 4000
    And Click Button "clickOnManageWatchlistButton"
    And Wait for 2000
    Given Fill Multiple Values "ManageWatchlistTextBox" button "AddButtonInManageWatchlist"
      | key |
      | M1  |
      | M2  |
      | M3  |
    And Wait for 2000
    Given Validate symbolORWatchlist Existance "watchlistListInEditWatchlistScreen"
      | key |
      | M1  |
      | M2  |
      | M3  |
    And Click Button "selectAllButton"
    And Click Button "deleteButtonInManageWatchlist"
    And Wait for 2000
    And Click Button "alertbuttonInManageWatchlist"
 #   And Wait for 2000
  #  And Click Button "backButtonManageWatchlist"
    And Wait for 2000
    And Validate text of label key "noWatchlistInManageWatchlist" value "You have no watchlist added."


  Scenario:Delete watchList TC0007
    And Wait for 4000
    And Click Button "addWatchlistButton"
    Given Fill TextBox "AddWatchlistName" "Test"
    And Click Button "watchlistPopCreateButton"
    And Wait for 2000
    And Click Button "openSideDrawer"
    And Wait for 4000
    And Click Button "clickOnManageWatchlistButton"
    And Wait for 2000
    Given Fill Multiple Values "ManageWatchlistTextBox" button "AddButtonInManageWatchlist"
      | key  |
      | M1 |
      | M2 |
      | M3 |
    And Wait for 2000
    And Click Button "selectAllButton"
    And Click Button "deleteButtonInManageWatchlist"
    And Wait for 2000
    And Click Button "alertbuttonInManageWatchlist"
    And Wait for 2000
    And Click Button "backButtonManageWatchlist"
    And Wait for 2000
    And Validate text of label key "WatchListNotExist" value "You have no watchlist added."


  Scenario:Add watchList throught the manage watchlist TC0008
    And Wait for 4000
    And Click Button "addWatchlistButton"
    Given Fill TextBox "AddWatchlistName" "Test"
    And Click Button "watchlistPopCreateButton"
    And Wait for 2000
    And Click Button "openSideDrawer"
    And Wait for 4000
    And Click Button "clickOnManageWatchlistButton"
    And Wait for 2000
    Given Fill Multiple Values "ManageWatchlistTextBox" button "AddButtonInManageWatchlist"
      | key |
      | M1  |
      | M2  |
      | M3  |


  Scenario:Verify Market Data agreement is not accepted
        And Wait for 4000
        And Click Button "addWatchlistButton"
        Given Fill TextBox "AddWatchlistName" "Test"
        And Click Button "watchlistPopCreateButton"
        And Wait for 2000
        Given Fill Multiple Values "SymbolField" button "AddSymbolIcon"
          | key |
          | QQQ |

    And Wait for 5000
    And validatemarketDataagreementacceptedornot "marketAgreementRetry" buttonVal "retryButton" regularPrice "regularPriceOnwatchlist"




