Feature: Test OrangeHRM login feature

  @Test
  Scenario Outline: Login functionality with valid username and password
    Given User launch the "<browser>" Browser
    When User enters the orangeHRM"<URL>"
    And User enters Username "<username>" and Password "<password>"
    And User clicks on login button
    Then User verifies the that he is logged in successfully.
    Examples:
      | browser | URL           | username           | password           |
      | browser | OrangeHRM_URL | OrangeHRM_username | OrangeHRM_password |