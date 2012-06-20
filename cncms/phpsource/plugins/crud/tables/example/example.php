<?php

function layout_init(){

//CRUD Project Identifier
define ('CRUD_PROJID', "crud_example");

//CRUD Database Settings
define ('CRUD_TABLE', "example");

//Sex Selector
$Exampleselector=array(""  => "-----",
                       "On" => "On",
                       "Off" => "Off");

$SELECTORS=array($Exampleselector);                       
                       
$NAMEDSTRUCTURE=array(
    "uid"           => array("displayname" => "UID",                    "type" => "int",       "length" => "255",     "search"=>"no",  "special" => "autoincrement"),
    "var1"          => array("displayname" => "Var1 Example",           "type" => "varchar",   "length" => "255",   "search"=>"yes" ),
    "var2" 	    => array("displayname" => "Var2 (Default Value)",   "type" => "varchar",   "length" => "255",   "search"=>"no", "defaultvalue"=>"default value example",   ),
    "int1" 	    => array("displayname" => "Int1",                   "type" => "int",       "length" => "20",     "search"=>"yes" ),
    "selector1"     => array("displayname" => "selector1",              "type" => "select",    "length" => "3",     "search"=>"yes", "special" => $Exampleselector ),
    "date1" 	    => array("displayname" => "date1",                  "type" => "date",      "length" => "10",    "search"=>"yes", "special" => "",  "javascript" => "onClick=\"displayDatePicker('form_date1');\""),
    "text1"         => array("displayname" => "Notes",                  "type" => "text",      "length" => "",      "search"=>"yes", "special" => "", "rows"=>"5", "cols"=>"100"),
    );

$complete_layout=array($NAMEDSTRUCTURE, $SELECTORS);

return $complete_layout;

}

?>