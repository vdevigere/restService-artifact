restService-artifact
====================

A maven artifact to create a restfull webservice project backed by HSQLDB. Technologies used include:
Jersey
Guice
JPA/Hibernate
Glassfish

Use command to generate project from artifact.
mvn archetype:generate -DarchetypeGroupId=com.viddu.archetype -DarchetypeArtifactId=restService -DarchetypeVersion=1.0-SNAPSHOT -DgroupId=com.example -DartifactId=exampleService
