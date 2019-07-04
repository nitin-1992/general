@Operations
Feature: Verify different operation using Rest assured

@Get
  Scenario: Performing Get Operation
    Given I perform Get operation for employee data
    
    When I perfrom Get operation for employee "51729"
    
    Then I see status code as "200" and employee name as "test11"
 
 
 @Post
  Scenario: Title of your scenario outline
    Given I perform post operation for employee data
   
  
  @Put
  Scenario: Performming Update operation
  Given I Want to Update the data for employee data "51730"
  
  
