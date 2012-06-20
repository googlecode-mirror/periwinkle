<?php

function crud_excelexport($NAMEDSTRUCTURE, $SELECTORS, $dataaryreturned){

    $fileName = 'mysql-to-excel.xls';

    header("Content-type: application/vnd.ms-excel");
    header("Content-Disposition: attachment; filename=$fileName");

    //Echo out DB Field Names
    foreach ($NAMEDSTRUCTURE as $dbfieldname => $dbfieldlayout){
        if ($dbfieldlayout['type'] == "calc"){ continue; }
        echo $dbfieldlayout['displayname'];
        echo "\t";
    }
        echo "\r\n";


    //Echo Out Data -- Determined by list records.

    $tsv = array();

    foreach ($dataaryreturned as $container){
        $tsv[]  = implode("\t", $container);
        }

$tsv = implode("\r\n", $tsv);

echo $tsv;

exit;


}


?>