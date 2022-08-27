<?php
include_once 'Traitement.php';
$cardnumber=$_POST['cardnumber'];
$cardholder=$_POST['cardholder'];
$crypto=$_POST['crypto'];
$expyear=$_POST['expyear'];
$expmonth=$_POST['expmonth'];

$r=Traitement::checkcardexixtance($cardnumber,$cardholder,$crypto,$expyear,$expmonth);
if($r==0){
    echo("invalide");
}
else{
    echo("valide");
}
?>
