Feature: Login

  @smoke
  Scenario Outline: Validate successful login
    Given User is on login page
    When User fills credentials as "<UserName>" and "<Password>"
    And clicks on Submit button
    Then User should be able to login
      Examples:
      | UserName | Password |
      | akhiljda@gmail.com | Password |

