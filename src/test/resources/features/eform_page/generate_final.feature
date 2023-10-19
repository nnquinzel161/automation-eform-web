Feature: Tracking Order
  As a User,
  I want the message in generate final notification in EForm web is following the status response of generate document final process
  So that the information shown is the same as requested

  Background:
    Given User already in home page
    And User select menu tracking order submenu tracking order

  @TrackingOrder @GenerateFinal @Success
    Scenario: Generate final success
    And User input success appl no
    And User click Find and page display retrieved data
    And User click generate final button
    Then Page will display success notification box
    And User click OK
    And Generate Final button is disabled
    And Print button is enabled

  @TrackingOrder @GenerateFinal @Failed
  Scenario Outline: Generate Final failed with 5 different conditions
    When User input failed "<appl_no>"
    And User click Find and page display retrieved data
    And User click generate final button
    Then Page will display failed notification with message "<resp_message>"
    And User click OK
    And Generate Final button is enabled
    And Print button is disabled

  Examples:
    |   appl_no         |   resp_message                                                           |
    |   10123001481     |   Rule tidak ditemukan atas Applno tersebut                              |
    |   10323000220     |   Tidak Ada Dokumen atas Applno tersebut/Dokumen belum disetup           |
    |   10323000214     |   karena ada field yang tidak terisi                                     |