Feature: Get Value

  Background:
    # baseUrl from `karate-config`
    * url baseUrl
    * def uri = '/value'

    # Expected value setting
    # ref : https://github.com/intuit/karate#fuzzy-matching
    * def expected =
    """
    '#string'
    """

    * def notExpected =
    """
    '#number'
    """

    * def definedParam = 'hello'

    # If it is called from `KeyValueDtoScenario.feature`, use param.
    # else use definedParam defined in advance.
    * def param = typeof param == 'undefined' ? definedParam : param

  @GetValue
  Scenario: Get Value
    Given path uri
    And param key = param
    And header Accept = 'application/json'
    When method GET
    Then status 200

    # $ = response
    And match $ == expected
    And match response == expected
    And match response != notExpected

    And print "[Feature] [@GetValue] : ", response