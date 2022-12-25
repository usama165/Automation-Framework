Feature: TradeScreen

  Scenario:Check the Toast Messages
    And Wait for 2000
    And Click Button "tradeScreenButton"
    And Wait for 2000
    And Click Button "SendOrderButton"
    And Wait for 100
    And validateToastMessage "EnterSymbolTM" expectedResult "Please enter your Symbol"

 Scenario:TC0026 - Check the validation on Symbol in Trade screen.
   And Wait for 2000
   And Click Button "tradeScreenButton"
   And Click Button "SendOrderButton"
   And validateToastMessage "ToastMessage" expectedResult "Please enter your Symbol"


  Scenario:TC0027 - Check the validation on quantity on Trade screen.
    And Wait for 2000
    And Click Button "tradeScreenButton"
    And Fill TextBox "SymbolField" "QQQ"
    And Click Button "AddSymbolIcon"
    And Wait for 2000
    And Click Button "SendOrderButton"
    And validateToastMessage "ToastMessage" expectedResult "Please enter Quantity of Symbol"

  Scenario:TC0028 - Tap on the Advanced Trade option to view more options.
    And Wait for 2000
    And Click Button "tradeScreenButton"
    And Wait for 2000
    And Click Button "clickAdvanceButton"
    And Wait for 2000
    Given SwapScreen yCordinate 0.8 endCordinate 0.2
    And Wait for 2000
    And Check the Presence of "orderTypeLabel"
    And Check the Presence of "tifLabel"
    And Wait for 2000

    And Check the Presence of "destinationLabel"
    And Check the Presence of "priceLabel"

  Scenario:











  Scenario: Check the scrolling thing
    And Wait for 3000
    And Click Button "clickOnOrdersTab"
    And Wait for 3000
    #And SwapScreen yCordinate 0.8 endCordinate 0.2
    And GetListVal




  Scenario:Order
    And Wait for 5000
    And Click Button "tradeScreenButton"
    And Fill TextBox "SymbolField" "QQQ"
    And Click Button "AddSymbolIcon"
    And Wait for 3000
    And Fill TextBox "enterQty" "200"
    And Wait for 2000
    And Click Button "SendOrderButton"
    And Wait for 2000
    And Get text of label "ConfirmOrderModalText"
   # And Validate text of label key "OrderModalsheetBottomValue" value "You are placing a market order to Buy 200 share(s) of QQQ.+"<br>"+If executed your order will be filled at market price."
    And Click Button "ConfirmOrderModal"
    And validateToastMessage "ToastMessage" expectedResult "Order successfully created."
   # And Wait for Visibilty till 2000
 #   And Get text of label "OrderSuccessToast"

  Scenario:Validate Symbol Bid/Ask Value
    And Wait for 4000
    And Click Button "CreateWatchlist"
    Given Fill TextBox "AddWatchlistName" "Test"
    And Click Button "ClickCreateButton"
    And Wait for 2000
    #And Click Button "tradeScreenButton"
  #  And Wait for 2000

     Given Fill Multiple Symbols
       | Symbol |
       | QQQ    |
       | MSFT   |
       | BMO    |

    And Click Button "TapOnSymbol"
    And Wait for 3000
    And validateBidAskValue last "LastPrice" , bid "BidPrice", ask "AskPrice"

  Scenario:Create Watch List
    And Wait for 5000
 #   And Click Button "CreateWatchlist"
 #   Given Fill TextBox "AddWatchlistName" "Test"
 #   And Click Button "ClickCreateButton"
 #   And Wait for 4000
    And Click Button "tradeScreenButton"
    And Wait for 3000
    Given Fill Multiple Symbols
      | Symbol |
      | QQQ    |
      | MSFT   |


  Scenario:tradeDropdown
    And Wait for 5000
    And Click Button "clickOnOrdersTab"
  #  And Wait for 3000
  # And scrollToSendOrderOut
   # And Click Button "tradeScreenButton"
    And Wait for 5000
 # And checkListValues
  #And GetListVal
#   And scrollToEndscrollToEnd
   # And Click Button "clickAdvanceButton"
   # And Wait for 2000
  #  And Click Button "accountDropdownclick"
  #  And getDropdownThroughtCoordinates
  #  And Wait for 5000
  #  And Click Button "accountDropdownclick"
  #  And Wait for 2000
  #  And getDropdownThroughtCoordinates
  #  And scrollToSendOrderOut
    #And Click Button "SendOrderButton"
   # And validateToasterMessage "ToasterMessage"
    # And scrollToSendOrderOut ""
   #And getALLOrdersist
  #"clickOnOrder22"
   # And Click Button with Action "SendOrderButton"
         # And getDropdownList "accountDropdownList" "accountDropdownValues"

     #    And getDropdownThroughtCoordinates
           # And Tap On Control "accountDropdownGetByFrameOut"
       #   And getDropdownList "accountDropdownGetByFrameOut"

  Scenario Outline:CreateOrder
    And Click Button "tradeScreenButton"
    And Wait for 5000
    Given Fill Values in Multiple Text Boxes as following table
      | Key      | Value                   |
      | Username | qatest23@mailinator.com |
      | Password | Qatest17@               |

 #   Given Fill Multiple Textboxes "Username,Password" "qatest23@mailinator.com,Qatest17@"
    And Click Button "LoginButton"
    And Wait for 5000
    When I add Verification code"<VerificationCode>"
    And Click Button "VerifyButton"
    Then Check the Presence of "NavBar"

    Examples:
      | Username                | Password  | VerificationCode |
      | qatest23@mailinator.com | Qatest17@ | 123456           |