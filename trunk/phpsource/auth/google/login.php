<?php
  include_once("GoogleOpenID.php");
  
  $googleLogin = GoogleOpenID::createRequest("http://aoicms.org/cncms/phpsource/auth/return.php");
  $googleLogin->redirect();
?>