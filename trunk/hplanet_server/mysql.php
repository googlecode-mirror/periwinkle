<?php
//Returns a single array populated with each field, useful for SQL query that has limit 0,1
function mysql_returnsarray($query){
global $DB_Config;

// open connection
$connection = mysql_connect($DB_Config['db_host'], $DB_Config['db_user'], $DB_Config['db_pass']) or die ("Unable to connect!");
// select database
mysql_select_db($DB_Config['db_name']) or die ("Unable to select database!");
// execute query
$result = mysql_query($query) or die ("Error in query: $query. ".mysql_error());
// see if any rows were returned
if (mysql_num_rows($result) > 0) {
     // yes
     // print them one after another
     // Initialize array
     $sqlary = array();
     while($row = mysql_fetch_row($result)) {
          $value2="";
          foreach ($row as $value){
               $sqlary[] = $value;
          }
     }

}else{
     // no results returned, return error message.
     // print status message
     $sqlary = array();
     $sqlary[] = "zero_rows_returned";
}

// free result set memory
mysql_free_result($result);
// close connection
mysql_close($connection);
return $sqlary;
}



//Returns real multidimensional arrays...sorta
function mysql_returnmarray($query){
global $DB_Config;

// open connection
$connection = mysql_connect($DB_Config['db_host'], $DB_Config['db_user'], $DB_Config['db_pass']) or die ("Unable to connect!");
// select database
mysql_select_db($DB_Config['db_name']) or die ("Unable to select database!");

// execute query
$result = mysql_query($query) or die ("Error in query: $query. ".mysql_error());

// see if any rows were returned
if (mysql_num_rows($result) > 0) {
     //Get field names for this set
   $NumberOfFields=0;
   $FieldNames=array();
    while($NumberOfFields < mysql_num_fields($result)){
        $meta=mysql_fetch_field($result,$NumberOfFields);
        $FieldNames[] = $meta->name;
        $NumberOfFields++;
        }

     $sqlary=array();
     $insidearray=array();
     $fieldpos=0;

     while($row = mysql_fetch_row($result)) {
        foreach ($row as $value){
        $insidearray[$FieldNames[$fieldpos]]=$value;
        $fieldpos++;
        }

        $sqlary[] = $insidearray;
        $fieldpos=0;
     }
}else{
     // no
     // print status message
     $sqlary[]="zero_rows_returned";
}



// free result set memory
mysql_free_result($result);

// close connection
mysql_close($connection);

return $sqlary;
}

//SQL Plain request. No Return.
function sqlnoreturn($query){
global $DB_Config;

// open connection
$connection = mysql_connect($DB_Config['db_host'], $DB_Config['db_user'], $DB_Config['db_pass']) or die ("Unable to connect!");

// select database
mysql_select_db($DB_Config['db_name']) or die ("Unable to select database!");

// execute query
$result = mysql_query($query) or die ("Error in query: $query. ".mysql_error());

// close connection
mysql_close($connection);
}


function sqlreturnid($query,$config){
global $DB_Config;

// open connection
$connection = mysql_connect($DB_Config['db_host'], $DB_Config['db_user'], $DB_Config['db_pass']) or die ("Unable to connect!");

// select database
mysql_select_db($DB_Config['db_name']) or die ("Unable to select database!");

// execute query
$result = mysql_query($query) or die ("Error in query: $query. ".mysql_error());

$id = mysql_insert_id();

// close connection
mysql_close($connection);

return $id;
}

?>
