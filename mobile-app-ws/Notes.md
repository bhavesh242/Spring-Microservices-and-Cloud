###Ways to create Spring Boot Projects
1. Spring Tool Suite -> New Project
2. Spring Initializr 

###HTTP Method Mapping
@GetMapping  
@PutMapping  
@PostMapping  
@DeleteMapping  

###Path Variables and Request Parameter Mappings

path = "/{variable name}"
@PathVariable for Path Variables

@RequestParam(value = "variable name") for Request Parameters

@RequestParam(value = "variable name", defaultValue="xyz") for making parameter optional or user (required = false) but that does not work vert well with primitive data types

###Return Java Object as Response
Just change return type of the method to Class Name
It returns JSON object by Default
###Return Java Object as an XML Response

use Accept HTTP header and set it to application/xml

in the @Getmapping provide produces = {list of all media types that can be produced}

Also need to add Jackson Dataformal XML dependency to pom.xml

###Return Different Status Code

Use a ResponseEntity(HTTPStatus.OK);
You can also include body and headers in your ResponseEntity object instance.

###Read Http Post Request Body

Use @RequestBody
Also add consumes = {mediatypes} in the @PostMapping() params
In the Request headers, set content = application/json

###Validating HTTP Post Request Body
use @Valid and use Annotations on the Fields in the class such as @Size(min, max)

##Handling HTTP Put and Delete Requests
Used to update resources

###Handling an Exception and Sending a Custom Error Message
Create a single Exception handler Class that will handle all application exceptions  
Use the @ControllerAdvice : It is a specialization for a Component for classes that declare @ExceptionHandler, @InitBinder etc, to be shared across multiple controller classes  
Use @ExceptionHander class for methods that handle exception  
This method will return ResponseEntity that will contain headers, status of response and body of response.     
Exception Handler takes value = {Exception types}  
ResponseEntity will have (exception (as body), headers (multi-value map), and status)

<b>Custom Representation of Error</b>  

Create a custom error class

###Handling Specific Exceptions
Create a new Method with new Values = {Specific Exception names} in the ExceptionHandler annotation
Always the method with specific exception is triggered instead of general if a handler method for that is found.

###Custom Exception
Create custom exception classes by extending RuntimeException  
Spring boot supports <b>Sneaky throws </b>. In Java, the sneaky throw concept allows us to throw any checked exception without defining it explicitly in the method signature. This allows the omission of the throws declaration, effectively imitating the characteristics of a runtime exception.

###Dependency Injection
A class may be required to communicate with other classes for which we will need instances of those classes, which will create a direct dependency and therefore we will not be able to test our method independent of those instances i.e. we will not be able to mock them in our testing framework.  
The dependencies that you are trying to inject into your class should be annotated with Auto-wired. For the framework to create an instance of a service implementation and autowire it to class that needs it, you should annotate the implementation with @Service. This enables framework to scan packages and see this implementation for instance creation and Auto-wiring.  
You can also inject dependencies using constructors. If a Class needs another class's instance, pass that class object in the constructor and annotate the constructor with @Autowired. Also mark the dependency class implementation with @Service for automatic instance creation

###Run Web Service as A Stand-alone application
through CLI, go to project root and run mvn install.  
a folder with name target will be generated along with the .jar file.  
This jar file already has embedded tomcat and you can directly run it using java -jar command.  

###Eureka Discovery Service
Was actually a project built by netflix which is now used by a lot of developers around the world. Eureka helps microservices find each other. In a scaled system, Any microservice that has multiple instances running on different addresses, thus the client wont know the address of all these services. Therefore Eureka comes into picture. Each microservice instance will register itself with Eureka Service on startup and Eureka will know address of each instance of each microservice. You need not manually add these addresses using the config file.
When we add an API gateway and load balancer to our application architecture, then the Eureka Discovery service tells the gateway about all the locations of all the instances of the microservices.

 