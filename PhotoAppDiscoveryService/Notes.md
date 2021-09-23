###How to enable an application to act as a Eureka Discovery service
Add @EnableEurekaServer annotation to main class
Add the following properties to application.properties : 
port, application name, client.registerWithEureka, client.fetchRegistry, service url, default zone, 

<b>Eureka Server</b>  

Discovery server where applications can register or deregister a service  

<b>Eureka Client</b>  

Ay application that can discover services.  

<b>Eureka Service</b>  

Any application that can be found in the Eureka Server's registry and is discoverable by others.    

In Order to enable a spring boot application as a Eureka Client, add annotation @EnableDiscoveryClient to the main Class of that Application 