<?php
include_once 'Dataaccess.php';
$UserName=$_POST["UserName"];
$Email=$_POST['Email'];
$Pass=$_POST['Pass'];
$datenaissance=$_POST['datenaissance'];

$req="insert into users(UserName,Email,Pass,datenaissance) values('$UserName','$Email','$Pass','$datenaissance')";
$r=Dataaccess::miseajour($req);

?>