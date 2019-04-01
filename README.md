
Kamile Forbes, Chris Shaw, Jonathan Idemudian

Team description:  Creating a URL Shortener and deploying it to cloud lab.
Documentation: The computing service we will be using is mongoDB/other if need be.
		    there will be four or five separate docker containers, URL Shortener,
		    Main Worker & Redirector, database, and WebUI.  
Connecting containers:
We are going to be building a Docker network, and when instantiating all of the        containers, we are going to have them attached to the Docker network. Then in order to have connections inside the application, we will query the Docker network based on service names.

		

 
