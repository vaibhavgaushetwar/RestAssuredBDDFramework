Feature: Validate playlist api
Scenario: Verify if create playlist is working
Given Create playlist api payload
When user calls with POST http request 
Then Api call executed with status code 201

Scenario: Verify if fetch playlist functionality is working 
Given Get a playlist payload
When user call with GET http code
Then api call executed with status code 200


Scenario: Verify if update playlist functionality is working 
Given Update playlist api payload
When user calls with PUT http request 
Then Api call should  executes with status code 201