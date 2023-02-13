jdo-bulkfetch-collection
========================

Example of using a query to bulk fetch a field that contains a collection of
persistables.


* <a href="https://github.com/datanucleus/test-jdo/tree/master/src/main/java/mydomain/model">src/main/java/mydomain/model/</a>   **This contains the model classes A and B**
* <a href="https://github.com/datanucleus/test-jdo/blob/master/src/main/resources/META-INF/persistence.xml">src/main/resources/META-INF/persistence.xml</a>   **This defines the persistence classes and database**
* <a href="https://github.com/datanucleus/test-jdo/blob/master/src/test/java/org/datanucleus/test/SimpleTest.java">src/test/java/org/datanucleus/test/SimpleTest.java</a>   **This provides a demonstration of the process, persisting objects, and then retrieving them using a single query.**

To run this, simply type "mvn clean test"
