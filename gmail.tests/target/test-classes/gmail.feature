Feature: Gmail

Scenario: I compose a mail
Given I am logged into my gmail account
When I click on compose button
And I compose a mail
And I close the mail
Then the mail should be saved in drafts