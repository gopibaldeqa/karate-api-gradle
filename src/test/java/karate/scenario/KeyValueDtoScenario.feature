Feature: KeyValueDto Scenario
  Background:
    # Commonly Needed Utilities
    # ref : https://github.com/intuit/karate#commonly-needed-utilities
    * def getDate =
    """
    function() {
    var SimpleDateFormat = Java.type('java.text.SimpleDateFormat');
    var sdf = new SimpleDateFormat('yyyy/MM/dd');
    var date = new java.util.Date();
    return sdf.format(date);
    }
    """

    * def getUUID =
    """
    function(){ return java.util.UUID.randomUUID() + '' }
    """

    * json requestBody = { key: 'oldKey', value: 'newValue' }

    # Change JSON key
    * def newKey = 'newKey' + '|' + getDate() + '|' + getUUID()
    * requestBody['key'] = newKey

  @RegressionTest
  Scenario: Create And Get Value

    # Create Value
    * def createResult = call read('classpath:karate/demo/post.feature@CreateValue') requestBody
    * print "[Scenario] [Call @CreateValue] : ", createResult.response

    # Get Value
    # payLoad == payLoad2
    * def payLoad = { param : #(newKey) }
    * def payLoad2 =
    """
    {
    "param": '#(newKey)'
    }
    """

    * def getResult = call read('classpath:karate/demo/get.feature@GetValue') payLoad
    * print "[Scenario] [Call @GetValue] : ", getResult.response
