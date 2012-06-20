<?php

//Define global variables

define ('HEADERBGCOLOR', "BLUE");   //Header background color
define ('HEADERtxtCOLOR', "WHITE"); //Header text color

define ('ODDROWbgCOLOR', "WHITE");  //Odd row background color
define ('ODDROWtxtCOLOR', "BLACK"); //Odd row text color

define ('EVENROWbgCOLOR', "CYAN");   //Even row background color
define ('EVENROWtxtCOLOR', "Black"); //Even row text color

define ('RECORDSPERSCREEN', "50");   //Maximum records to display on listing

$dateformat="%m/%d/%Y";             //Date format, default Month, Day, Year

define ('CRUDLIBS', "/var/www/phpsource/crud");   //Location of shared CRUD php files
define ('CRUDLayoutsPath', "/var/www/phpsource/tables"); //Location of CRUD Layout file sets

//Determine which table to open
if (isset($_GET['project']) && $_GET['project'] != ""){$requestedproject=$_GET['project'];}
if (isset($_POST['project']) && $_POST['project'] != ""){$requestedproject=$_POST['project'];}
if (isset($_POST['projectrequested']) && $_POST['projectrequested'] != ""){$requestedproject=$_POST['projectrequested'];}

//If a project isn't set in _GET or _POST then exit with an error.
if (!isset($requestedproject)){ echo "No project specified."; exit;}
if ($requestedproject == ""){ echo "No project specified."; exit;}

define ('REQPROJ',$requestedproject);

//Include CRUD.main.php
include_once (CRUDLIBS.'/crud.main.php'); //Determines what actions to perform

//Include main functions
include_once (CRUDLIBS.'/crud.list.php'); //CRUD List - Creates an HTML Table of Records
include_once (CRUDLIBS.'/crud.editscreen.php'); //Editscreen for CRUD
include_once (CRUDLIBS.'/crud.updaterecord.php'); //Update a Record Function for CRUD
include_once (CRUDLIBS.'/crud.addscreen.php'); //Add screen for CRUD
include_once (CRUDLIBS.'/crud.insertrecord.php'); //Insert a record for CRUD
include_once (CRUDLIBS.'/crud.html.common.php'); //Common HTML functions
include_once (CRUDLIBS.'/crud.header.php'); //CRUD Header
include_once (CRUDLIBS.'/crud.csvexport.php'); //CRUD CSV Export
include_once (CRUDLIBS.'/crud.excelexport.php'); //CRUD Excel Export
include_once (CRUDLIBS.'/crud.advancedsearch.php'); //CRUD Advanced Search

//Show the CRUD Header
if (isset($_GET['action'])){
    if ($_GET['action'] != "csvexport" && $_GET['action'] != "excelexport"){  crud_header(); }
}else{
    crud_header();
}

//Call Main Function
crud_main();


function crud_error($message){
    echo $message;
    crud_exit();
}



function crud_exit(){
    if (isset($_GET['action']) && $_GET['action'] == "csvexport"){ exit; }
    if (isset($_GET['action']) && $_GET['action'] == "excelexport"){ exit; }

    crud_topnav();
    //Done
    exit;
}
?>