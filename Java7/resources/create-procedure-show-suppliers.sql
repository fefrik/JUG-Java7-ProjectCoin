CREATE PROCEDURE SHOW_SUPPLIERS()
  PARAMETER STYLE JAVA
  LANGUAGE JAVA
  DYNAMIC RESULT SETS 1
  EXTERNAL NAME 'com.oracle.tutorial.jdbc.StoredProcedureJavaDBSample.showSuppliers';