Feature: Login Page
Scenario: Hotel Booking System Login Scenario
Given user is in Login Page
Given Title of login page is "Hotel Booking Application"
When User enters invalid credentials receives warning message
When User enters correct Login Credentials
Then User is in home page title is "Hotel Booking"