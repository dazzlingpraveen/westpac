
@Westpac
Feature: Westpac KiwiSaver Retirement Calculator
  In order to get an idea of what my projected KiwiSaver balance could be at retirement
  As a customer
  I want to be able to calculate retirement balance projections


  Background:
    Given As an user I am on the KiwiSaver Retirement Calculator page

  Scenario Outline: Users are able to get a clear understanding of what needs to be entered in the fields
    When an user clicks the information icon besides the <Field>
    Then the following message should be displayed- <Message>

    Examples:
      | Field       | Message                                                                                                   |
      | Current age | This calculator has an age limit of 64 years old as you need to be under the age of 65 to join KiwiSaver. |
