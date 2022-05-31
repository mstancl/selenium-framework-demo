# Selenium framework demo

## Description  
A very simple framework for test automation of web based front end applications  
using :  
    
  - Selenium    (webElement interactions)
  - TestNG      (test hierarchy, suite execution)
  - Maven       (dependencies, execution) 
   
## Prerequisites  
  
  - Java JDK 11(+) installed     (https://java.tutorials24x7.com/blog/how-to-install-java-11-on-windows)
  - Git client installed         (https://github.com/git-guides/install-git)
  - Apache maven bin downloaded  (https://maven.apache.org/download.cgi)  
          -- Make sure you set the environment variables correctly (https://mkyong.com/maven/how-to-install-maven-in-windows/)
  - IDE for Java development installed (community version of Intellij https://www.jetbrains.com/idea/download/#section=windows)
  - Access to the maven repo. Works by default, only issues occur when behind proxy or VPN (https://mvnrepository.com/)
  
 
  ##### STEPS  
  
  - `git clone https://github.com/mstancl/selenium-framework-demo.git`  via git bash  
    - Or you can open Intellij - File - new -> project from version control and paste the .git URL 
  - Open the project in IntelliJ ( file -> open)  
  - Go to settings and configure Maven and Git to point to your sources  
        -- File -> settings -> version control -> git -> 'Path to  git executable'  
        -- File -> settings -> Build,execution,Deployment -> Build tools -> Maven - Maven home directory (point this to where you extracted the .zip)
        
## How to run tests
Execute `mvn clean install -DsuiteXmlFile=src/test/resources/executionXMLs/smokeTest.xml` from command line  
This will execute the smokeTest.xml suite containing all the tests. 


## Reporting
Once the tests finish, you can find the test report under `test-output/extent.html`
 
## Demo web application
Web application used for this demo is `https://demoqa.com/`  
written by `https://www.toolsqa.com/` . Website full of very useful resources, make sure to visit them!  

## Author
author of this demo framework - Martin Stancl. https://www.linkedin.com/in/martin-štancl-11b591108  