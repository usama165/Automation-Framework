Feature: Login

  Scenario Outline: Login vBate
    Given I am using the vBate
    And Click Button "LoginBtnSplash"
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
