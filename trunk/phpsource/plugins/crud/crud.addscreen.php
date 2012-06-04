<?php

function crud_addscreen($NAMEDSTRUCTURE, $SELECTORS){

    // Open the HTML Edit Template
    $HTMLeditTemplate=CRUDLayoutsPath . "/" . REQPROJ . "/" . REQPROJ . ".editscreen.html";
    $file = file_get_contents($HTMLeditTemplate, true);

    //Replace %startform%
    $startform_html=commonhtml_form_startform("insertrecord");
    $file = str_replace("%startform%", $startform_html, $file);

    //Replace %formbutton%
    $editscreenbutton=commonhtml_form_input("Submit","Insert Record","Insert Record","","","");
    $file = str_replace("%formbutton%", $editscreenbutton, $file);

    //Replace %endform%
    $file = str_replace("%endform%", "\n</form>", $file);


    foreach ($NAMEDSTRUCTURE as $name => $structure){

    //Submit blank uid
    if ($name == "uid"){
        $tag="%".$name."%";
        $formname="form_".$name;
        $inputhtml=commonhtml_form_input("hidden",$name,"","","AutoID","");
        $file = str_replace($tag, $inputhtml, $file);
        continue;
        }

    //Integer handling: int
    if ($structure['type'] == "int"){
        $tag="%".$name."%";
        $formname="form_".$name;
        if (isset($structure['defaultvalue'])){$value=$structure['defaultvalue'];}else{$value="";}
        $inputhtml=commonhtml_form_input("text",$formname,"$value","","","");
        $file = str_replace($tag, $inputhtml, $file);
        continue;
    }

    //Varchar handling: varchar
    if ($structure['type'] == "varchar"){
        $tag="%".$name."%";
        $formname="form_".$name;
        if (isset($structure['defaultvalue'])){$value=$structure['defaultvalue'];}else{$value="";}
        $inputhtml=commonhtml_form_input("text",$formname,"$value","","","");
        $file = str_replace($tag, $inputhtml, $file);
        continue;
    }

    //Text handling: text
    if ($structure['type'] == "text"){
        $tag="%".$name."%";
        $formname="form_".$name;
        if (isset($structure['defaultvalue'])){$value=$structure['defaultvalue'];}else{$value="";}
        $inputhtml=commonhtml_form_text($formname,"$value",$structure['cols'],$structure['rows']);
        $file = str_replace($tag, $inputhtml, $file);
        continue;
    }

    //Date handling: date
    if ($structure['type'] == "date"){
        $tag="%".$name."%";
        $formname="form_".$name;
        $inputhtml=commonhtml_form_input("text",$formname,"","","",$structure['javascript']);
        $file = str_replace($tag, $inputhtml, $file);
        continue;
    }

    //Select handling: select
    if ($structure['type'] == "select"){
        $tag="%".$name."%";
        $formname="form_".$name;
        $inputhtml=commonhtml_form_select($formname,"",$structure['special']);
        $file = str_replace($tag, $inputhtml, $file);
        continue;
    }

    }

    echo $file;

    //Done
    crud_exit();

}


?>