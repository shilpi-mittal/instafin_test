Feature: Download All Transactions report
Ideally fresh data should be created in test setup steps and rollback in teardown. But as it is just a dummy task, I am using existing data in tests.

@AllTransactionReport
Scenario Outline: Download All Transactions Report

Given User is logged in
When goes to All Transaction reports
And filter reports by <startDate>, <endDate> and <branch>
Then user should see <rows> rows in filter results
Then user should see <count> in filter results
When user exports excel
Then file should download
And there should be <excelRows> transactions in report

Examples:
| startDate | endDate    | branch     | count | rows | excelRows |
| "17052018"| "17052018" | "Branch 1" | "7"   | "7"  | "7"       |
