Feature: Booking Management

  Scenario: Add a booking and validate the response
    Given the booking details are provided
    When the user creates a new booking
    Then the booking should be successfully created
    And the booking details should be validated using the ID

  Scenario: Validate a non-existing booking
    When the user fetches booking details with an invalid ID
    Then the response should return a 404 status
