<?php

function mysqli_multiselect($querykeyed){
global $DB_Config;
    
$link = mysqli_connect($DB_Config['db_host'], $DB_Config['db_user'], $DB_Config['db_pass'], $DB_Config['db_name']);

/* check connection */
if (mysqli_connect_errno()) {
    printf("Connect failed: %s\n", mysqli_connect_error());
    exit();
}
    
$maincontainer=array();
$sequencecount=0;
$query="";

foreach ($querykeyed as $name => $value){
    $querysequence[]=$name;
    $query.=$value . ";";
}


/* execute multi query */
if (mysqli_multi_query($link, $query)) {
    do {
        $rsltcount=0;
        $tablecontainer=array();
        /* store first result set */
        if ($result = mysqli_store_result($link)) {
            while ($row = mysqli_fetch_assoc($result)) {
                $tablecontainer[]=$row;
                ++$rsltcount;
                }
            mysqli_free_result($result);
        }
        
        if ($rsltcount == 0){ $tablecontainer[]="zero_results_returned"; }
        
        $maincontainer[$querysequence[$sequencecount]]=$tablecontainer;
        $sequencecount++;
        
        } while (mysqli_next_result($link));
}

/* close connection */
mysqli_close($link);
return $maincontainer;

}
?>