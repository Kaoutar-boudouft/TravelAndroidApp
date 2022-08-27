<?php
include_once 'Traitement.php';
$curs=Traitement::getallusers();
$reponse['users']=array();
while($row=$curs->fetch()){
    $user=array();
    $user['username']=$row[0];
    $user['pass']=$row[1];
    $user['pic']=$row[2];
    array_push($reponse['users'],$user);
}
$curs->closeCursor();
echo json_encode($reponse);

?>