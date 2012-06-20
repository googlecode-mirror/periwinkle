<?php

//Turn on error reporting.
//Note: Disable the following two if used in a production environment.
ini_set("display_errors","1");
ERROR_REPORTING(E_ALL);

//Path to phpsource
define ('CNCMSsourcePATH', getcwd() . '/phpsource');

//Include config.php
include_once(CNCMSsourcePATH . "/config.php");

//Execute config.php
$DB_Config=config_init();

//Include mysql.php and mysqlmulti.php
include_once(CNCMSsourcePATH . "/mysql.php");
include_once(CNCMSsourcePATH . "/mysqlmulti.php");

//Make the default set of queries.
$Main_Qry=array("GlobalSettings" => "SELECT * FROM `$DB_Config[db_tableprefix]globalsettings`");

$SETUP_Main=mysqli_multiselect($Main_Qry);

echo "<pre>";
print_r($SETUP_Main);
echo "</pre>";

?>