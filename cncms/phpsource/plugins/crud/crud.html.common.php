<?php

/*  Requires five arguments as follows:
    $type = Type of input box: submit, text, hidden
    $name = Name of input box.
    $value = Value of input box.
    $class = Cascading Style Sheet Class for input box.
    $description = Description to be placed after input box, with <br /> tag added to the end
    $javascript = Javascript or special text to be added
*/
function commonhtml_form_input($type,$name,$value,$class,$description,$javascript){
    //If the description isn't empty, add a <br /> tag to the end of it.
    if ($description != ""){$description .= " <br />";}

    //If the class isn't empty, then add it to the string
    if ($class != ""){$clshtml = " class=\"$class\" ";}else{ $clshtml=""; }

    $output="<input type=\"$type\" name=\"$name\" value=\"$value\" $clshtml $javascript /> $description\n";
    return $output;
}


function commonhtml_form_text($name,$data,$cols,$rows){
    $output="<textarea name=\"$name\" ";
        if (isset($cols) && $cols != "" && isset($rows) && $rows != ""){
            $output.="cols=\"$cols\" rows=\"$rows\"";
        }

    $output.=">$data</textarea>";
    return $output;
}



function commonhtml_form_startform($myaction){
    $output="<form method=\"POST\" action=\"".THISURL."\">";
    $output.=commonhtml_form_input("hidden","projectrequested",REQPROJ,"","","");
    $output.=commonhtml_form_input("hidden","action",$myaction,"","","");
    return $output;
}

function commonhtml_form_select($formname,$selected,$optionsary){

    $output="<select name=\"$formname\">\n";
	if (isset($selected) && $selected != ""){
	    $output.="<option value=\"$selected\">$optionsary[$selected] (SELECTED)</option>";
        }

        foreach ($optionsary as $name => $value){
            $output.="<option value=\"$name\">$value</option>";
        }
    $output.="</select>\n";

    return $output;
}


?>