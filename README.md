# websphere-multipart-problem

Code example to validate a problem with multi-windows / multi-tabs in JSF applications.

Build e. g. with:
* Java Version: 1.8.0_162
* Apache Maven: 3.5.3

```
$ mvn clean package tomee:run
```

Browse this URL: [http://localhost:8080/]()

Follow the instructions on that page. 
The sources can be found under /src/main/webapp/index.xhtml

With that TomEE setup there should be no problem.

To test the application with Websphere, 
please deploy it on Websphere 8.5.5.x / 9.0.0.7 under 
e.g. the context-path /demo.

If you have no Websphere installed, but have Docker use this command:

```
echo "password" >PASSWORD
docker run --name was -h was -v $(pwd)/PASSWORD:/tmp/PASSWORD -p 9043:9043 -p 9443:9443 -d ibmcom/websphere-traditional:8.5.5.13-profile
```
 
(For more information see [https://hub.docker.com/r/ibmcom/websphere-traditional/]()) 
 
browse this URL: [https://localhost:9443/demo/]()
