<?php

function crud_updaterecord($NAMEDSTRUCTURE, $SELECTORS){

    //Start building the SQL statement
    $sql="UPDATE `".REQPROJ."` SET ";

    foreach ($_POST as $name => $value){

        //Skip Update_Record
        if ($name == "Update_Record"){ continue; }

        //Skip Action
        if ($name == "action"){ continue; }

        if ($name == "projectrequested"){ continue; }

        //uid handling
        if ($name == "form_uid"){ $update_uid=$value; continue;}

        //Remove the word form from the name
        $name=str_replace("form_", "", $name);

        //Try to match the inputted name with our structure
        if (!isset($NAMEDSTRUCTURE[$name])){ crud_error("Input mismatch. See config file or editscreen template for mismatched: $name"); }

        //If the input is a date then convert it to mysql format
        if ($NAMEDSTRUCTURE[$name]['type'] == "date"){
            $d = explode('/', $value);
            $myoutdate=$d[2]."-".$d[0]."-".$d[1];
            $value=$myoutdate;
        }

        //Escape the value
        $value=mysql_real_escape_string($value);

        $sql.="`$name`='$value', ";


    }

    if (!isset($update_uid) || $update_uid == ""){ crud_error("uid not specified"); }

    //Remove the extra space and comma
    $sql=substr($sql, 0, -2);
    $sql.=" WHERE `uid`=$update_uid LIMIT 1";

    //Run SQL update statement
    sqlnoreturn($sql,"main");

    //go back to the edit screen
    crud_editscreen($NAMEDSTRUCTURE, $SELECTORS,"Record Updated",$update_uid);

    //Done
    crud_exit();

}


?>