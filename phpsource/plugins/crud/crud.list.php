<?php

function crud_list($NAMEDSTRUCTURE, $SELECTORS){
    global $db_config;

    //Custom search tag name
    $TAGNAME=CRUD_TABLE."advancedsearchsql";

    //Reset $_SESSION['advancedsearchsql'] if action==resetlist
    if (isset($_GET['action']) && $_GET['action']=="resetlist"){
        unset($_SESSION[$TAGNAME]);
        $_SESSION[$TAGNAME]="";
        }

    //Get the start record
    if (isset($_GET['startrecord']) && $_GET['startrecord'] != ""){
        $startrecord=$_GET['startrecord'];
        }else{
            $startrecord="0";
        }

    //define records per screen
    $recordsperscreen=RECORDSPERSCREEN;

    //Start Building the SQL Statement
    $sql_beginningselector="SELECT ";

    foreach ($NAMEDSTRUCTURE as $dbfieldname => $dbfieldlayout){

        //Catch calculation fields
        if ($dbfieldlayout['type'] == "calc"){
                $sql_beginningselector.=$dbfieldlayout['special'] . ", "; continue;
                }

        //Catch date fields
        if ($dbfieldlayout['type'] == "date"){ $sql_beginningselector.="DATE_FORMAT(`$dbfieldname`, '%m/%d/%Y')" . ", "; continue; }

        $sql_beginningselector.= "`$dbfieldname`, ";

    }

$sql_beginningselector = substr($sql_beginningselector,0,-2);
$sql_beginningselector.=" FROM `".CRUD_TABLE."` ";

//Determine sort order column name
if (isset($_GET['orderby']) && $_GET['orderby'] != ""){
    $orderby=mysql_real_escape_string($_GET['orderby']);
    $orderbystring=" ORDER BY `$orderby`";
}

//Set ordering vars
    if (!isset($orderbystring)){$orderbystring="";}
    if (!isset($ordertype)){$ordertype="";}

//Determine sort type
if (isset($_GET['sorttype']) && $_GET['sorttype'] != "" && $_GET['sorttype'] == "ASC"){
    $ordertype=" ASC";
}

if (isset($_GET['sorttype']) && $_GET['sorttype'] != "" && $_GET['sorttype'] == "DESC"){
    $ordertype=" DESC";
}

//Default query
if (isset($_GET['action']) && $_GET['action'] == "excelexport"){
    $limit="";
}else{
    $limit="LIMIT $startrecord, $recordsperscreen";
}

$query="$sql_beginningselector $orderbystring $ordertype $limit";

//Advanced Search Block
//Ignore all preceeding code if $SQLINPUT is populated or if $_POST['action']=advancedsearch_do
if (isset($_SESSION[$TAGNAME]) && $_SESSION[$TAGNAME] != ""){
    $SQLINPUT=$_SESSION[$TAGNAME];
    $query="$sql_beginningselector WHERE $SQLINPUT $orderbystring $ordertype $limit";
    }

if (isset($_POST['action']) && $_POST['action'] == "advancedsearch_do"){
    $SQLINPUT=crud_advancedsearch_do($NAMEDSTRUCTURE, $SELECTORS);
    $query="$sql_beginningselector WHERE $SQLINPUT $orderbystring $ordertype $limit";
}
//Advanced Search Block

//Run query
$dataaryreturned=mysql_returnmarray("$query","main");


//////Excel EXPORT
if (isset($_GET['action']) && $_GET['action'] == "excelexport"){
    crud_excelexport($NAMEDSTRUCTURE, $SELECTORS, $dataaryreturned);
    crud_exit();
}
//////Excel EXPORT



//Clear Advanced Search Link
if (isset($_SESSION[$TAGNAME]) && $_SESSION[$TAGNAME] != ""){
    echo "<P><b>Search Results</b> - <a href=\"index.php?project=".REQPROJ."&&action=resetlist\">Clear Search</a></p>";
    }



//Start pagination

//Count how many records are in this set.
    $recordscounted=0;
    foreach ($dataaryreturned as $item){
        $recordscounted++;
    }

if ($dataaryreturned[0]=="zero_rows_returned"){ echo "<h2>No results found.<h2>"; crud_exit(); }

$nextset=$startrecord + $recordsperscreen;
$previousset=$startrecord - $recordsperscreen;

echo "<p>";
if ($previousset >= 0){
    echo "<a href=\"".THISURL."?startrecord=$previousset&&project=".REQPROJ;

if (isset($_GET['orderby']) && isset($_GET['sorttype']) && isset($_GET['orderby']) && isset($_GET['sorttype'])){
    echo "&&orderby=".$_GET['orderby']."&&sorttype=".$_GET['sorttype'];
}
    echo "\">Previous</a> - ";
}

if ($recordscounted == $recordsperscreen){
echo "<a href=\"".THISURL."?startrecord=$nextset&&project=".REQPROJ;

if (isset($_GET['orderby']) && isset($_GET['sorttype']) && isset($_GET['orderby']) && isset($_GET['sorttype'])){
    echo "&&orderby=".$_GET['orderby']."&&sorttype=".$_GET['sorttype'];
}
echo "\">Next</a>";
}
echo "</p>\n";
//End Pagination

//Print the table heading.
crud_list_heading($NAMEDSTRUCTURE, $SELECTORS);

//Now continue printing the table

//Set rowcolor
$rowcolor=0;

foreach ($dataaryreturned as $container){

    //Row Color Formatting
    if ($rowcolor==0){
        echo "<tr bgcolor=\"".ODDROWbgCOLOR."\">";
        $rowcolor++;
        }else{
        echo "<tr bgcolor=\"".EVENROWbgCOLOR."\">";
        $rowcolor=0;
        }

    //Print main data block
    foreach ($container as $fieldname => $fielddata){
        if ($fieldname == "uid"){echo "<td><a href=\"".THISURL."?action=edit&&uid=$fielddata&&project=".REQPROJ."\">$fielddata</a></td>"; continue;}
        if ($fielddata == "" or $fielddata == null or $fielddata == " "){ echo "<td>&nbsp</td>"; continue;}
        echo "<td>$fielddata</td>\n";
    }
    echo "</tr>\n\n";
}

//done close the table
echo "</table>";

//Start pagination

//Count how many records are in this set.
    $recordscounted=0;
    foreach ($dataaryreturned as $item){
        $recordscounted++;
    }

$nextset=$startrecord + $recordsperscreen;
$previousset=$startrecord - $recordsperscreen;

echo "<p>";
if ($previousset >= 0){
    echo "<a href=\"".THISURL."?startrecord=$previousset&&project=".REQPROJ;

if (isset($_GET['orderby']) && isset($_GET['sorttype']) && isset($_GET['orderby']) && isset($_GET['sorttype'])){
    echo "&&orderby=".$_GET['orderby']."&&sorttype=".$_GET['sorttype'];
}
    echo "\">Previous</a> - ";
}

if ($recordscounted == $recordsperscreen){
echo "<a href=\"".THISURL."?startrecord=$nextset&&project=".REQPROJ;

if (isset($_GET['orderby']) && isset($_GET['sorttype']) && isset($_GET['orderby']) && isset($_GET['sorttype'])){
    echo "&&orderby=".$_GET['orderby']."&&sorttype=".$_GET['sorttype'];
}
echo "\">Next</a>";
}
echo "</p>\n";
//End Pagination

//Done
crud_exit();
}




function crud_list_heading($NAMEDSTRUCTURE, $SELECTORS){

    //Initialize count variable
    $fieldcount=0;

//Echo back ordering requested
if (isset($_GET['orderby']) && $_GET['orderby'] != ""){
    echo "<p>Ordered by: " . $_GET['orderby'];
    }else{
        echo "<p>Ordered by: default</p>";
    }
if (isset($_GET['sorttype']) && $_GET['sorttype'] != ""){ echo " " . $_GET['sorttype'] . "</p>"; }

    //Start the table
    echo "<table border=\"1\" cellpadding=\"2\" cellspacing=\"3\">\n<tr bgcolor=\"".HEADERBGCOLOR."\">\n";

    foreach ($NAMEDSTRUCTURE as $dbfieldname => $dbfieldlayout){
        $fieldcount++;
        echo "<td><strong>";

        if ($dbfieldlayout['type'] != "calc"){

            if (isset($_GET['orderby']) && $_GET['orderby'] == $dbfieldname && isset($_GET['sorttype']) && $_GET['sorttype'] == "ASC"){
                echo "<a href=\"".THISURL."?orderby=$dbfieldname&&sorttype=DESC&&project=".REQPROJ."\">";
                }else{
                    echo "<a href=\"".THISURL."?orderby=$dbfieldname&&sorttype=ASC&&project=".REQPROJ."\">";
                    }
        }

        echo "<font color=\"".HEADERtxtCOLOR."\">";
        echo $dbfieldlayout['displayname'];
        echo "</font></a></strong></B></td>\n";
    }

    //close this part of the table
    echo "</tr>\n\n";

}

?>