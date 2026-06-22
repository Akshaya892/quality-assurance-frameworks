Feature: Registration

  Scenario: Successful Student Registration

    Given User opens DemoQA website
    Then User should see DemoQA homepage loaded
    When User click on forms card
    When the user enters the following details:
      | First Name | Lisha             |
      | Last Name  | Luise             |
      | Email      | lisha@example.com |
      | Gender     | Male              |
      | Mobile     | 9876543210        |
      | Date of Birth | 18 Jun 2026    |
      | Subjects   | Maths             |
      | Hobbies    | Sports            |
      | Address    | Kerala, India     |
      | State      | NCR               |
      | City       | Delhi             |