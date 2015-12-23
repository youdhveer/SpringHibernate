# SpringHibernate
This is a spring repository to guide you from beginner to expert.

1. Install Java 6 or later and eclipse kepler or later
2. Install maven 3.2 or latest
3. Install Apache Tomact 7
4. Configure all these in user environmental variables
    Example -- 

        CATALINA_HOME ==  C:\Apache Software Foundations\apache-tomcat-7.0.57 
        
        M2_HOME       ==  C:\Apache Software Foundations\apache-maven-3.2.1
        
        M2            ==  %M2_HOME%\bin
        
        JAVA_HOME     ==  C:\Program Files\Java\jdk1.7.0_45
        
        CATALINA_OPTS == -Xdebug -Xrunjdwp:transport=dt_socket,address=8002,server=y,suspend=n   (For remote debugging)
        
        Path          ==  %M2%;%CATALINA_HOME%;%JAVA_HOME%\bin;

5. Install Microsoft SQL Server and configure a database using help from microsoft official site.  
6. Finally, you can give command 
    mvn clean install
    (It will compile and make a war file for your maven project)
    Now you can deploy this war in tomact and run at your local server
    
    Other option, you can configure direct tomact maven plugin in your pom which will deploy directly your war file in tomact
    using same command, mvn clean install
    
    
