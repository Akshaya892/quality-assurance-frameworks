Feature: Registration

  Scenario: Successful Student Registration

    Given User opens DemoQA website
    Then User should see DemoQA homepage loaded
    When User clicks on Forms card
    And User fills the registration form
      | firstName | Lisha              |
      | lastName  | Luise              |
      | email     | Lisha@example.com  |
      | gender    | Female             |
      | mobile    | 1001001001         |
      | month     | January            |
      | year      | 2000               |
      | day       |   21               |
      | subject   | English            |
      | hobby     | Music              |
      | address   | Lisha House        |
      | state     | Haryana            |
      | city      | Panipat            |
    Then User should see the submitted form details