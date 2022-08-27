<?php
include_once 'Traitement.php';
if(isset($_GET['outile'])){
    $outile=$_GET['outile'];
    if($_GET['vd']=="all"){
        $curs=Traitement::gettravelsbyway($outile);
    }
    else{
        $curs=Traitement::gettravelsbywayandvd($outile,$_GET['vd']);
    }
    $reponsetravel['Travels']=array();
    while($row=$curs->fetch()){
        $Travel=array();
        $Travel['id']=$row[0];
        $Travel['vd']=$row[1];
        $Travel['va']=$row[2];
        $Travel['dd']=$row[3];
        $Travel['da']=$row[4];
        $Travel['prix']=$row[5];
        $Travel['hd']=$row[6];
        $Travel['ha']=$row[7];
        $Travel['capacite']=Traitement::travelEpmtyPlaces($row[0]);
        $Travel['outile']=$row[9];
        array_push($reponsetravel['Travels'],$Travel);
    }
    $curs->closeCursor();
    echo json_encode($reponsetravel);
}


?>