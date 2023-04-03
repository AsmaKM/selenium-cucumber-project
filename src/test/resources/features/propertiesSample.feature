@properties
Feature: Properties Handling

  Scenario: User can get mandatory property from properties file
    Given I have a property file env.properties
    Then I can print the value of property: base_url

  Scenario: User can get default property from properties file
    Given I have a property file env.properties
    Then I can get value of property: not_mandatory_property