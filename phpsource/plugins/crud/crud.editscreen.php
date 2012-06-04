<?php

function crud_editscreen($NAMEDSTRUCTURE, $SELECTORS,$message,$reqid){

    //Get the ID from the HTML form
    if (isset($_GET["uid"])){ $requestedrecord=$_GET["uid"]; }
    if (isset($_POST["uid"])){ $requestedrecord=$_POST["uid"]; }
    if (isset($_POST["form_uid"])){ $requestedrecord=$_POST["form_uid"]; }
    if (isset($reqid) && $reqid != ""){ $requestedrecord=$reqid; }

    if (!isset($requestedrecord) or $requestedrecord == ""){
        echo "Record not specified for editscreen.";
        crud_exit();
    }

    //Build the SQL statement for edit screen
    $editscreensql="SELECT * FROM `".CRUD_TABLE."` WHERE `uid`=$requestedrecord LIMIT 0, 1";
    $editaryreturned=mysql_returnmarray($editscreensql,"main");

    //Remove the outer container because it isn't needed for 1 record
    $EditDataHash=$editaryreturned[0];

    // Open the HTML Edit Template
    $HTMLeditTemplate=CRUDLayoutsPath . "/" . REQPROJ . "/" . REQPROJ . ".editscreen.html";
    $file = file_get_contents($HTMLeditTemplate, true);

    //Replace %startform%
    $startform_html=commonhtml_form_startform("updaterecord");
    $file = str_replace("%startform%", $startform_html, $file);

    //Replace %formbutton%
    $editscreenbutton=commonhtml_form_input("Submit","Update Record","Update Record","","","");
    $file = str_replace("%formbutton%", $editscreenbutton, $file);

    //Replace %endform%
    $file = str_replace("%endform%", "\n</form>", $file);

    foreach ($EditDataHash as $dbname => $dbvalue){

    //Don't allow user to modify uid, only print the uid
    if ($dbname == "uid"){
        $tag="%".$dbname."%";
        $formname="form_".$dbname;
        $inputhtml=commonhtml_form_input("hidden",$formname,$dbvalue,"",$dbvalue,"");
        $file = str_replace($tag, $inputhtml, $file);
        continue;
        }

    //Integer handling: int
    if ($NAMEDSTRUCTURE[$dbname]['type'] == "int"){
        $tag="%".$dbname."%";
        $formname="form_".$dbname;
        if ($dbvalue=="0"){ $dbvalue=NULL; }
        $inputhtml=commonhtml_form_input("text",$formname,$dbvalue,"","","");
        $file = str_replace($tag, $inputhtml, $file);
        continue;
    }

    //Varchar handling: varchar
    if ($NAMEDSTRUCTURE[$dbname]['type'] == "varchar"){
        $tag="%".$dbname."%";
        $formname="form_".$dbname;
        $inputhtml=commonhtml_form_input("text",$formname,$dbvalue,"","","");
        $file = str_replace($tag, $inputhtml, $file);
        continue;
    }

    //Text handling: text
    if ($NAMEDSTRUCTURE[$dbname]['type'] == "text"){
        $tag="%".$dbname."%";
        $formname="form_".$dbname;
        $inputhtml=commonhtml_form_text($formname,$dbvalue,$NAMEDSTRUCTURE[$dbname]['cols'],$NAMEDSTRUCTURE[$dbname]['rows']);
        $file = str_replace($tag, $inputhtml, $file);
        continue;
    }

    //Date handling: date
    if ($NAMEDSTRUCTURE[$dbname]['type'] == "date"){
        $tag="%".$dbname."%";
        $formname="form_".$dbname;
        //Convert date formats to mmmddyyyy
        if ($dbvalue != ""){
            $d = explode('-', $dbvalue);
            $myoutdate=$d[1]."/".$d[2]."/".$d[0];
            if ($myoutdate=="00-00-0000"){ $myoutdate=NULL; }
            }
        $inputhtml=commonhtml_form_input("text",$formname,$myoutdate,"","",$NAMEDSTRUCTURE[$dbname]['javascript']);
        $file = str_replace($tag, $inputhtml, $file);
        continue;
    }

    //Select handling: select
    if ($NAMEDSTRUCTURE[$dbname]['type'] == "select"){
        $tag="%".$dbname."%";
        $formname="form_".$dbname;
        $inputhtml=commonhtml_form_select($formname,$dbvalue,$NAMEDSTRUCTURE[$dbname]['special']);
        $file = str_replace($tag, $inputhtml, $file);
        continue;
    }


    } //End foreach

    if (isset($message) && $message != ""){
        echo "<p><b>$message</b></p>";
        }else{
            echo "<p>&nbsp;</p>";
        }

    echo $file;

    //Done
    crud_exit();

}

?>