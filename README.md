
PROJECT CONFIGURATION :
    
    - The Porject has been developed With following Java dependencies/tools
      1- Cucumber-JVM 1.2.5
      2- Spring-Framework 4.2.2.RELEASE
      3- Rest-assured  3.0.5
      4- Selenium 3.5.3
      5- Allure Reports 2.5
      6- slf4j-api 1.7.6

RUN OPTIONS:

1- It can be run with both chrome and firefox driver by providing following commands accordingly. 
Note: Both drivers for Mac & Windows are provided at src/main/resources/drivers. At the moment, path for both drivers is set for Mac in pom.xml, you can change it accordingly

 
 (i) Run tests with Chrome. It can be changed to 'firefox' 
   > mvn clean install -DdriverType=chrome
 
 (ii) Also you can run either All, GUI or API tests by mentioning in Cucumber Options
   > mvn clean install -DdriverType=chrome
   
   or
   
   > mvn clean install -DdriverType=chrome -Dcucumber.options="--tags @ui"
  
   or
   
   > mvn clean install -DdriverType=chrome -Dcucumber.options="--tags @api"

REPORTING :   

 - To produce Allure reports, please run the site command or you can run the "site" with previous commands together
 Note: You can open the allure reports by opening "allure-maven-plugin.html" file in target/site/ folder location.
 
  > mvn site
   
   or
   
   > mvn clean install site
   
TASK EXPLANATION:

TASK 1 : To implement the remaining two scenarios tagged as @wip...
 
  - "search.feature" has been implemented by remaining two new scenarios
  - They have been implemented through Page Object Model. All the Page Objects are located at src/main/java/com.stage1.test/pages


TASK 2 : To write and implement a few more BDD scenarios for UI and API tests to demonstrate candidates understanding of what scenarios are best for UI and what scenarios are best for API tests...
 
  => Two feature files (search.feature and searchAPI.feature) have been implemented for this task, one for GUI and other for API with view of logic mentioned below.
    
    GUI feature has all the tests related to front end verfication, like 
      Scenario 1: Search results are displayed 
      Scenario 2 : Checking the Mouse Over functionality for dropdown and final category destination page breadcrumb
      Scenario 3 : Checking the product description has been displayed same on the other page as it was on the landing page.
    
     API feature has all the tests related to different services call, like 
       Scenario 1:  Request to Search Service and checking the status OK along with expected response in search results.
       Scenario 2 : Request to Category Service end point and checking the status OK along with expected response for respective category
       Scenario 3 : Request to Listing Service end point and checking the status 200/OK along with expected response for listing product
      
    Note : GUI tests should always look/check for presence of DOM elements (like textboxes, images, labels, buttons etc) as expectedly displayed/present or not.
    Whereas API tests are necessary to run when on some event(buttoClick, Link Click, Form Submit etc), the underpinning web-service has been invoked so they can be tested for OK status(like 200 in GET case) along with expected response body/header.
       
TASK 3 : Good to have but not required: How to run the tests in parallel, with batch strategy, etc.
   
    => To run the tests in parallel, there should be couple of steps need to be taken in design
     
      1- Add following configuration settings in Maven Surefire plugin in pom.xml
                 <forkCount>4</forkCount>
                 <reuseForks>true</reuseForks>
                 <argLine>-Xmx1024m -XX:MaxPermSize=256m</argLine>

      2- Add each Runner file for each feature file so it can be run parallel
      
TASK 4 : Any other improvements / suggestions.
 
   =>  Following are couple of suggestions
   
       1- Good to introduce some configuration for Selenium Grid for cross browser testing using Desired Capabilities.
       2- Also it is nice to have Cloud Configuration like Sauce Lab\ Browser Stack to run the tests on different VM devices
            
       

  
