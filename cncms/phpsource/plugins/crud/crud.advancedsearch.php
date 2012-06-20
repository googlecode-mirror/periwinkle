<?php

function crud_advancedsearch($NAMEDSTRUCTURE, $SELECTORS){

    echo commonhtml_form_startform("advancedsearch_do");

    echo "<h2>Advanced Search</h2>";

    $optionsary=array("OR"=>"OR",
                      "AND"=>"AND");

    echo commonhtml_form_select("searchtype","OR",$optionsary);
    echo "Search Type <br /> \n";

    foreach ($NAMEDSTRUCTURE as $dbname => $dbvalue){
        if ($dbvalue['search'] != "yes"){ continue; }

        $formname="form_".$dbname;
        if (isset($dbvalue['javascript'])){
            $javascript=$dbvalue['javascript'];
            }else{
            $javascript="";
            }

        if ($dbvalue['type']=="select"){
            echo commonhtml_form_select($formname,"",$NAMEDSTRUCTURE[$dbname]['special']);
            }else{
                echo commonhtml_form_input("text",$formname,"","","",$javascript);
            }

        echo $dbvalue['displayname'] . "<br /> \n";

    }

    echo commonhtml_form_input("Submit","Search","Search","","","");
    echo "\n</form>";
}


function crud_advancedsearch_do($NAMEDSTRUCTURE, $SELECTORS){

    //Start building the SQL statement
    $sqlmiddle="";

    foreach ($_POST as $name => $value){
        //skip action
        if ($name=="action"){ continue; }
        //skip projectrequested
        if ($name=="projectrequested"){ continue; }
        //skip Search
        if ($name=="Search"){ continue; }
        //skip searchtype
        if ($name=="searchtype"){ continue; }
        //skip items with empty values
        if ($value==""){ continue; }

        //Remove the word form from the name
        $name=str_replace("form_", "", $name);

        if (isset($NAMEDSTRUCTURE[$name]['type']) && $NAMEDSTRUCTURE[$name]['type'] == "date"){
            $d = explode('/', $value);
            $myoutdate=$d[2]."-".$d[0]."-".$d[1];
            $value=$myoutdate;
        }

        //Escape the value
        $value=mysql_real_escape_string($value);

    $sqlmiddle.="`$name`='$value'";

    if ($_POST['searchtype']=="AND"){
        $sqlmiddle.=" AND ";
    }else{
        $sqlmiddle.=" OR ";
    }

    }

    if ($sqlmiddle==""){ echo "<h2>No search terms provided.</h2>"; crud_advancedsearch($NAMEDSTRUCTURE, $SELECTORS); crud_exit(); }

    //Remove last AND or OR
    if ($_POST['searchtype']=="AND"){
        $sqlmiddle=substr($sqlmiddle, 0, -4);
    }else{
        $sqlmiddle=substr($sqlmiddle, 0, -3);
    }

    //Advanced search session tag
    $TAGNAME=CRUD_TABLE."advancedsearchsql";
    $_SESSION[$TAGNAME]=$sqlmiddle;

    return $sqlmiddle;
}


?>