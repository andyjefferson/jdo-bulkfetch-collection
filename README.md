jdo-bulkfetch-collection
========================

Example of using a query to bulk fetch a field that contains a collection of
persistables.


* <a href="https://github.com/datanucleus/test-jdo/tree/master/src/main/java/mydomain/model">src/main/java/mydomain/model/</a>   **This contains the model classes A and B**
* <a href="https://github.com/datanucleus/test-jdo/blob/master/src/main/resources/META-INF/persistence.xml">src/main/resources/META-INF/persistence.xml</a>   **This defines the persistence classes and database**
* <a href="https://github.com/datanucleus/test-jdo/blob/master/src/test/java/org/datanucleus/test/SimpleTest.java">src/test/java/org/datanucleus/test/SimpleTest.java</a>   **This provides a demonstration of the process, persisting objects, and then retrieving them using a single query.**

To run this, simply type "mvn clean test".

The test creates some data, and then does a single JDOQL query fetch, with the Collection field in the DFG. This results in SQL of

```
SELECT 'mydomain.model.B' AS DN_TYPE,A1.ID,A1."NAME",A0.ID_OID,A0.IDX AS NUCORDER0 
FROM A_BS A0 INNER JOIN B A1 ON A0.ID_EID = A1.ID 
WHERE A0.IDX >= 0 AND EXISTS 
    (SELECT 'mydomain.model.A' AS DN_TYPE,A0_SUB.ID AS DN_APPID 
     FROM A A0_SUB 
     WHERE A0.ID_OID = A0_SUB.ID) ORDER BY NUCORDER0
```

So a single SQL
