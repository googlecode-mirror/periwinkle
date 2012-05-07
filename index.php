<?php

ini_set("display_errors","1");
ERROR_REPORTING(E_ALL);

//Path to phpsource
define ('CNCMSsourcePATH', getcwd() . '/phpsource');

//Include config.php
include_once(CNCMSsourcePATH . "/config.php");

//Execute config.php
$DB_Config=config_init();

//Include mysql.php
include_once(CNCMSsourcePATH . "/mysql.php");
include_once(CNCMSsourcePATH . "/mysqlmulti.php");


$querykeyed=array("example1" => "SELECT * FROM  `test`",
                  "example2" => "SHOW TABLES");

$data=mysqli_multiselect($querykeyed);

print_r($data);

?>