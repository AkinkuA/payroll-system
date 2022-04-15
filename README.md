# Wave SE-Challenge-Payroll
## Documentation
## Name: Akin Akinkugbe
### Technologies Used
1. Java
2. SpringBoot
3. Hibernate
4. HSQL - (Initially MySQL but switched so application can run agnostically)
5. BootStrap
### How to run
Go into the root folder and run the following command 

`./mvnw spring-boot:run`

This should install the maven project and start up the server. The application 
is running on localhost:8080

There are 2 endpoints

`payrollReport` - GET

`uploadTimesheet` - POST(requires a request parameter named `File` and the value being the csv file)

After starting off the server open up an API testing tool, point to localhost:8080/{requireEndpoint} and hit send

### Architecture
Code is structured using the MVC model, without the V(View), as it was stated it was not needed.
- Models are stored in the com.wavehq.model package
- Controllers are stored in the com.wavehq.controller package
- Services are stored in the com.wavehq.service package

All tests are stored in the corresponding folder but in the test package

#### Models
The following are the models
1. EmployeeReport - Contains information about employees, pay period and amount paid during the pay period 
2. JobGroup - Contains information on the type of employee and the pay rate
3. PayPeriod - Contains beginning and end date for pay period 
4. PayrollReport - Contains list of all employee reports
5. PayrollReportResponse - Object for Rest Payroll report response
6. TimeReport - Contains information for uploaded file 
7. TimeReportInfo - Contains information gotten from uploaded file after parsing

#### Services
The following are the services
1. TimeReportInfoService - This is used to store and retrieve information from the parsed file into the database
2. TimeReportService - This is used to store information about uploaded files

### Testing 
As stated above unit testing was done (50 percent code coverage was achieved). Also API testing tool (Postman) was used
to test the end-to-end functionality of the API

### Production changes
If the code was destined for production i will make the following changes
1. Increase unit tests to make sure code coverage is at least 80%
2. Change the JobGroup Enum to a model with its own SQL Table (That way creating additional job types will not require 
full code deployments)
3. Create a frontend for the application so its easily used. (UI is available but instructs user to use
4. an API testing tool)
5. Add more error-handling
6. Add more checks to input to ensure format compliance

###Time Constraint Changes
1. Lack of 80% code coverage
2. Lack of functional UI
