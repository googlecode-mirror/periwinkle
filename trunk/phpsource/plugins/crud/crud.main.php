<?php

function crud_main(){

//Layout file path
$layoutfilepath=CRUDLayoutsPath . "/" . REQPROJ . "/" . REQPROJ . ".php";

if (!file_exists($layoutfilepath)){ echo "Layout not valid: " . REQPROJ ; }
include_once ($layoutfilepath);
$layout=layout_init();

list ($NAMEDSTRUCTURE, $SELECTORS) = $layout;

//Determine which action to perform.

//////Editing Records
//Edit a record screen: edit
if (isset($_GET['action']) && $_GET['action'] == "edit"){
    if (isset($_GET['uid']) && !is_numeric($_GET['uid'])){ crud_error("Invalid argument for ID"); crud_exit();}
    crud_editscreen($NAMEDSTRUCTURE, $SELECTORS,"","");
    crud_exit();
    }

//Update the record: updaterecord
if (isset($_POST['action']) && $_POST['action'] == "updaterecord"){
    if (isset($_POST['uid']) && !is_numeric($_POST['uid'])){ crud_error("Invalid argument for ID"); crud_exit();}
    crud_updaterecord($NAMEDSTRUCTURE, $SELECTORS);
    crud_exit();
    }
//////Editing Records


//////Inserting Records
//Add a record screen: add
if (isset($_GET['action']) && $_GET['action'] == "add"){
    crud_addscreen($NAMEDSTRUCTURE, $SELECTORS);
    crud_exit();
    }

//Insert a record: insertrecord
if (isset($_POST['action']) && $_POST['action'] == "insertrecord"){
    crud_insertrecord($NAMEDSTRUCTURE, $SELECTORS);
    crud_exit();
    }
//////Inserting Records

//////Advanced Search
if (isset($_GET['action']) && $_GET['action'] == "advancedsearch"){
    crud_advancedsearch($NAMEDSTRUCTURE, $SELECTORS);
    crud_exit();
}

//Performing the advanced search is intiated by list records

//////Advanced Search

//////Listing Records
//If no action is specified, then show the default listing.
crud_list($NAMEDSTRUCTURE, $SELECTORS);
crud_exit();
//////Listing Records

}
?>