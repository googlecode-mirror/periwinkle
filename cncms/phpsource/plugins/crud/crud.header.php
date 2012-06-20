<?php

function crud_header(){
    $headerhtml=file_get_contents(CRUDLIBS.'/crud.header.html', true);

    $headerhtml=str_replace("%project%", REQPROJ, $headerhtml);

    if (isset($_GET['uid']) && $_GET['uid'] !=""){ $myuid=$_GET['uid']; }
    if (isset($_POST['uid']) && $_POST['uid'] !=""){ $myuid=$_POST['uid']; }
    if (isset($_SESSION['uid']) && $_SESSION['uid'] !=""){ $myuid=$_SESSION['uid']; }

    if (isset($myuid) && $myuid != ""){
        $headerhtml=str_replace("%uid%", $myuid, $headerhtml);
        }else{
        $headerhtml=str_replace("%uid%", "", $headerhtml);
        }

    //Replace %thisurl% on the header
    $headerhtml=str_replace("%thisurl%", THISURL, $headerhtml);

    //Replace %CRUDurlHTML% on the header
    $headerhtml=str_replace("%CRUDurlHTML%", CRUDurlHTML, $headerhtml);

    echo $headerhtml;

    projectchooser_topnav();

    crud_topnav();
}




function crud_topnav(){

    $navhtmlfile=PHPsourcePATH . "/crud/crud.topnavskeleton.html";
    $navigationhtml=file_get_contents($navhtmlfile, true);

    //Replace %REQPROJ% on the top navigation
    $navigationhtml=str_replace("%REQPROJ%", REQPROJ, $navigationhtml);

    echo $navigationhtml;

    echo "<hr>";


}

?>