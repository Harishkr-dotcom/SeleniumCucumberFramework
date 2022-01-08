Feature: Home Page Validations

Background: 
Given User in Github page
When User click on SignIn button
Then User enters the Username and Password and clicks Login Button
|Username|Password|
|harishkr755@gmail.com|Harishkr@1997|

@HomePage
Scenario: Verify the Profile Options
Given User click on Profile button
Then User Validates the profile options texts
|Your profile|
|Your repositories|
|Your codespaces|
|Your projects|
|Your stars|
|Your gists|
|Upgrade| 
|Feature preview|
|Help|
|Settings|

