# testspring
Develop a web application with RESTFUL API calls to perform CRUD operations on a database table "package_info"


Following are the Resources that are performing CRUD operations Using Spring 4 + Restful Web Services + Spring Services + Hiberante 4.

1. Test Rest Web Service: 
http://localhost:8080/testspring/rest/api/v1.0/hello

2. Get All packageInformation Resource: (GET Method)
http://localhost:8080/testspring/rest/api/v1.0/packageinformations/ 

3. Get packageInformation by Id Resource: (GET Method and path variable)
http://localhost:8080/testspring/rest/api/v1.0/packageinformations/{identifier}

4. Save packageInformation Resource:  (POST Method and Json Request Body)
http://localhost:8080/testspring/rest/api/v1.0/packageinformations/ 

5. Update packageInformation by Id Resource: (PUT Method, Json Request Body and path variable)
http://localhost:8080/testspring/rest/api/v1.0/packageinformations/{identifier}

6. Delete packageInformation by Id Resource: (DELETE Method and path variable)
http://localhost:8080/testspring/rest/api/v1.0/packageinformations/{identifier}

Note : 

  1. Please add user and password of Mysql Database in AppConfig file as your machine Mysql User/password. Moreover you can change Database vendor
  by updating datasource porperties in AppConfig file.
  
  2. Create Schema and Table stucture: https://gist.github.com/b490a02a553bfe8330f824395e72cb42.git
