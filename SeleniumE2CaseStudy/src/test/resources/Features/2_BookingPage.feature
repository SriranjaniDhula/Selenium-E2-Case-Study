Feature: Booking Page
Scenario: Hotel Booking Form
Given User is in Hotel Booking Form "Hotel Booking"
When User enters all the details
And Submits the form
Then User is in confirmation page with message "Booking Completed!"