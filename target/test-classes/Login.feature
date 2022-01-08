Feature: Login page feature

@loginPage
Scenario: Login page url Verification
Given User in Github page
When User click on SignIn button
Then Verify the URL contains "https://github.com/login"

@loginPage1
Scenario: Verify the login Page elements
Given User in Github page
When User click on SignIn button
Then User verify that Email and Password fields are dispalyed

