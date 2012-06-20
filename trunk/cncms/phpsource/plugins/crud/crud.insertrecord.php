<?php

function crud_insertrecord($NAMEDSTRUCTURE, $SELECTORS){

    //Start building the SQL statement
    $beg="INSERT INTO `".REQPROJ."` (";

    $insertvalues="";
    $position=0;
    $namestring="";
    $fieldlistsql="";

    foreach ($NAMEDSTRUCTURE as $name => $structure){

        //Skip calculation fields
        if ($structure['type'] == "calc"){ continue; }

        ///Construct the list of field names into a SQL list
        $fieldlistsql.="`$name` , ";

        //Add form_ to the beginning of the structured $name
        $formname="form_" . $name;

        //Ignore uid if sent, always send NULL
        if ($name == "uid"){ $insertvalues.="NULL, "; continue; }

        //Ignore projectrequested
        if ($name == "projectrequested"){ continue; }

        //Check integer input
        if ($structure['type'] == "int"){
            //$tempint is used to CAST the input from the user into a PHP integer
            $tempint=intval($_POST[$formname]);
            if ($tempint != "" && is_integer($tempint)){ $insertvalues.="$tempint, "; continue;}
            echo "Value submitted: $_POST[$formname] for: <b>$name</b> is not an integer.<br> Please press back on your browser to correct this.";
            crud_exit();
        }

        //Date conversion from User input to mysql format
        if ($structure['type'] == "date" && isset($_POST[$formname]) && $_POST[$formname] != ""){
            $escapedstring=mysql_real_escape_string($_POST[$formname]);
            $d = explode('-', $escapedstring);
            $myoutdate=$d[2]."-".$d[0]."-".$d[1];
            $insertvalues.="'$myoutdate', ";
            continue;
        }

        if (isset($_POST[$formname]) && $_POST[$formname] != ""){
            $escapedstring=mysql_real_escape_string($_POST[$formname]);
            $insertvalues.="'$escapedstring', ";
        }else{
            $insertvalues.="'', ";
        }

    }


    //Remove the last two characters from $fieldlistsql
    $fieldlistsql=substr($fieldlistsql, 0, -2);

    //Remove the last two characters from $insertvalues
    $insertvalues=substr($insertvalues, 0, -2);

    //Put everything together
    $finalsql=$beg . $fieldlistsql . ")VALUES(" . $insertvalues . ")";

    //Insert SQL
    $myreturnedid=sqlreturnid($finalsql,"main");

    //Reshow the edit screen
    crud_editscreen($NAMEDSTRUCTURE, $SELECTORS,"Record Inserted",$myreturnedid);

    //Done
    crud_exit();
}

?>