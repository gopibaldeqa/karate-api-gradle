Feature: Create Value

  #Background:
    # baseUrl from `karate-config`
    #* url baseUrl
    #* def uri = '/value'
#
    #* def definedRequestBody1 = { key: 'newKey', value: 'newValue' }
    #* def definedRequestBody2 =
    #"""
    #{
      #"key": "hello",
      #"value": "world"
    #}
    #"""
#
    # Expected value setting
    # ref : https://github.com/intuit/karate#fuzzy-matching
    #* def expected =
    #"""
    #{
      #"key": '#string',
      #"value": '#string',
      #"success": true
    #}
    #"""
#
    #* def failExpected =
    #"""
    #{
      #"success": false
    #}
    #"""
#
    # If it is called from `KeyValueDtoScenario.feature`, use requestBody.
    # else use definedRequestBody1 defined in advance.
    #* def requestBody = typeof requestBody == 'undefined' ? definedRequestBody1 : requestBody
#
  #@CreateValue
  #Scenario: Create Value
    #Given path uri
    #And request requestBody
    #And header Accept = 'application/json'
    #When method post
    #Then status 200
#
    #And match response == expected
    #And match response contains expected
    #And match $.key == requestBody.key
    #And match $.value == requestBody.value
#
    #And print "[Feature] [@CreateValue] : ", response
######## Output ########
#  [print] [Feature] [@CreateValue] :  {
#  "success": true,
#  "value": "newValue",
#  "key": "newKey"
#}
#######################
#
  #@FailCreateValue
  #Scenario: Fail Create Value
    #Given path uri
    #And request definedRequestBody2
    #And header Accept = 'application/json'
    #When method post
    #Then status 400
#
    #And match response != failExpected
    #And match response contains failExpected
#
    #And print "[Feature] [@FailCreateValue] : ", response
######## Output ########
#  [print] [Feature] [@FailCreateValue] :  {
#  "success": false,
#  "value": null,
#  "key": null
#}
########################

Scenario: Fail Create Value

* print "##################################"