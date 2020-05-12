Feature: Sample test feature

  Scenario: Intital Test
    Given I type something

  Scenario: Webservice Test with simple GET command
    Given I access the users api
    Then status code should be 200

  Scenario: Webservice Test with simple POST command
    Given I access the post method
    Then status code should be 200

  Scenario: Webservice Test with GET and verify data contents of response
    Given I access the users api with verification for capdev408
    Then uqvd409 should be available in the response

  Scenario: Webservice test with GET and verify data contents of response using hamcrest matcher equal To
    Given I access the users api with getUserInfo
    Then nid should be n477353
    And headers should have Access-Control-Allow-Methods as following
      | GET     |
      | POST    |
      | OPTIONS |

  Scenario: Webservice test with GET and verify schema of the json response
    Given I access the users api with getUserInfo
    Then response should match user-info-schema.json

#    http://dummy.restapiexample.com/
  Scenario: Webservice test with GET and verify complex data by filtering response data
    Given I access the public api
    Then following members should be available under age 30
      | Quinn Flynn  |
      | Cedric Kelly |
      | Sonya Frost  |

  Scenario: Use details from one api and use in another api
    Given I access the public api
    When search for employee with age 63
    Then increase the salary of the employee










