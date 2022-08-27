<?php
include_once 'Traitement.php';
if($_GET['cate']=="all"){
    $curs=Traitement::getalltours();
}
else{
    $curs=Traitement::gettoursbycat($_GET['cate']);

}
   
 
    $reponsetour['Tours']=array();
    while($row=$curs->fetch()){
        $Tour=array();
        $Tour['idtour']=$row[0];
        $Tour['titre']=$row[1];
        $Tour['date']=$row[2];
        $Tour['prix']=$row[3];
        $Tour['image']=$row[4];
        $Tour['capacite']=Traitement::emptyTourPlaces($row[0]);
        $Tour['categ']=Traitement::getCategorieNameById($row[5]);


        array_push($reponsetour['Tours'],$Tour);
    }
    $curs->closeCursor();
    echo json_encode($reponsetour);

?>