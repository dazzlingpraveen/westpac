
@Westpac
Feature: Westpac KiwiSaver Retirement Calculator

  Background:
    Given As an user I am on the KiwiSaver Retirement Calculator page

  Scenario Outline: Users are able to get a clear understanding of what needs to be entered in the fields
    When an user clicks the information icon besides the <Field>
    Then the following message should be displayed- <Message>

    Examples:
      | Field       | Message                                                                                                   |
      | current-age | This calculator has an age limit of 84 years old. |

  Scenario Outline: Users are able to plan their investments better with projected balance at retirement
    When an user enters the details for scenario <TestNumber> in the KiwiSaver calculator
    Then the projected KiwiSaver balance at retirement gets displayed

    Examples:
      |       TestNumber     |
      |             1        |
      |             2        |
      |             3        |