<?php

//Turn on error reporting.
//Note: Disable the following two if used in a production environment.
ini_set("display_errors","1");
ERROR_REPORTING(E_ALL);

//Include config.php
include_once("config.php");

//Execute config.php
$DB_Config=config_init();

//Include mysql.php and mysqlmulti.php
include_once("mysql.php");

//Show the high scores if no arguments are found.
$query="SELECT * FROM  `highscores` ORDER BY `Score` DESC ";
$data=mysql_returnmarray($query);


# Read GET variables
$pname = $_POST['pname'];
$pscore = $_POST['pscore'];

echo "<p>POST Data: $pname $pscore </p>";

echo "<h2>Hostile Planet High Scores</h2>";

echo "<table border=\"0\" cellpadding=\"2\" cellspacing=\"3\"";
echo "<tr><td><b>Name</b></td><td><b>Score</b></td></tr>";

foreach ($data as $row){
     echo "<tr><td>";
     echo $row['Name'];
     echo "</td><td>";
     echo $row['Score'];
     echo "</td></tr>";
}

echo "</table>";

exit;

?>