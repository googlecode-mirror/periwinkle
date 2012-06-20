<?php

function config_init(){
    $config = array('db_host' => "localhost",
                    'db_user' => "db_user",
                    'db_pass' => "db_password",
                    'db_name' => "db_user",
                    'db_tableprefix' => "cncms_");
    
    return $config;
}

?>