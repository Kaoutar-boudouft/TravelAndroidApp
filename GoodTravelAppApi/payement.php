<?php
include_once 'Traitement.php';
$user=$_POST['user'];
$type=$_POST['type'];
$id=$_POST['id'];
$nbrplaces=$_POST['nbplace'];


$ra9mkorsi=Traitement::ra9mkorsi($type,$id);
$da=new DateTime();
$date=$da->format('Y-m-d H:i:s');
$ar9amkrasa="";
for($i=1;$i<=$nbrplaces;$i++){
    $ar9amkrasa.="place n:";
    $ar9amkrasa.=$ra9mkorsi+$i;
    $ar9amkrasa.="/";
}
if($type=="voyage"){
    $prix=Traitement::getpriceoftravel($id);
    $totalapayer=$prix*$nbrplaces;
    $r=DataAccess::miseajour("insert into billet(UserName,Type,idvoyage,nbrdeplace,numerodeplaces,boughtin,totalapayes) values('$user','$type','$id','$nbrplaces','$ar9amkrasa','$date','$totalapayer')");
    $curs=DataAccess::selection("select idbillet from billet order by idbillet desc limit 1");
    $idbillet=0;
    while($row=$curs->fetch()){
        $idbillet=$row[0];
    }
    $curs->closeCursor();
    echo($idbillet);

    
}
if($type=="Tour"){
    $prix=Traitement::getpriceoftour($id);
    $totalapayer=$prix+(($nbrplaces-3)*$prix*0.12);
    $r=DataAccess::miseajour("insert into billet(UserName,Type,idtour,nbrdeplace,numerodeplaces,boughtin,totalapayes) values('$user','$type','$id','$nbrplaces','$ar9amkrasa','$date','$totalapayer')");
    $curs=DataAccess::selection("select idbillet from billet order by idbillet desc limit 1");
    $idbillet=0;
    while($row=$curs->fetch()){
        $idbillet=$row[0];
    }
    $curs->closeCursor();
    echo($idbillet);
}

?>