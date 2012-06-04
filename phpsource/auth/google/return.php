<?php
  include_once("GoogleOpenID.php");

  $googleLogin = GoogleOpenID::getResponse();
  if($googleLogin->success()){
    $user_id = $googleLogin->identity();
  }
?>