<?php
include_once 'Dataaccess.php';
class Traitement{
    public static function getallusers(){
        $req="select UserName,Pass,profilepicmobile from users";
        $curs=Dataaccess::selection($req);
        return $curs;
    }
    public static function gettravelsbyway($outile){
        $req="select idvoyage,villedepart,villearriver,datedepart,datearriver,prix,heuredepart,heurearrive,capacite,outile from voyage where outile='$outile'";
        $curs=Dataaccess::selection($req);
        return $curs;
    }
    public static function gettravelsbywayandvd($outile,$vd){
        $req="select idvoyage,villedepart,villearriver,datedepart,datearriver,prix,heuredepart,heurearrive,capacite,outile from voyage where outile='$outile' and villedepart='$vd'";
        $curs=Dataaccess::selection($req);
        return $curs;
    }
    public static function getalltours(){
        $req="select idtour,titretour,datedepart,prix,imageweb,idcateg from specialstours";
        $curs=Dataaccess::selection($req);
        return $curs;
    }
    public static function gettoursbycat($idtour){
        $req="select idtour,titretour,datedepart,prix,imageweb,idcateg from specialstours where idcateg='$idtour'";
        $curs=Dataaccess::selection($req);
        return $curs;
    }
    public static function travelEpmtyPlaces($id){
        $nbtotal=0;
        $nbnotempty=0;
        $req1="select capacite from voyage where idvoyage='$id'";
        $curs=DataAccess::selection($req1);
        while($row=$curs->fetch()){
            $nbtotal=$row[0];
        }
        $curs->closeCursor();
        $req1="select sum(nbrdeplace) from billet where idvoyage='$id' and Type='voyage' ";
        $curs=DataAccess::selection($req1);
        while($row=$curs->fetch()){
            $nbnotempty=$row[0];
        }
        $curs->closeCursor();
        return $nbtotal-$nbnotempty;

    }
    public static function getpriceoftravel($id){
        $req="select prix from voyage where idvoyage='$id' ";
        $curs=DataAccess::selection($req);
        $prix=0;
        while($row=$curs->fetch()){
            $prix=$row[0];
        }
        $curs->closeCursor();
        return $prix;
    }
    public static function checkcardexixtance($number,$name,$crypto,$expyear,$expmonth){
        $req1="select * from cartebancaire where numcarte='$number' and detenteur='$name' and anneeexp='$expyear' and moisexp='$expmonth' and crypto='$crypto'";
        $curs=DataAccess::selection($req1);
        return $curs->rowCount();
    }
    public static function ra9mkorsi($type,$id){
        $req="select sum(nbrdeplace) from billet where Type='$type' and id$type='$id'  ";
        $curs=DataAccess::selection($req);
        $ra9mkorsi=0;
        while($row=$curs->fetch()){
           $ra9mkorsi=$row[0];
        }
        $curs->closeCursor();
        return $ra9mkorsi;
    }
    public static function emptyTourPlaces($tourid){
        $req="select capacite from specialstours where idtour='$tourid' ";
        $curs=DataAccess::selection($req);
        $r1=0;
        while($row=$curs->fetch()){
            $r1=$row[0];
        }
        $curs->closeCursor();
        $req="select sum(nbrdeplace) from billet where Type='tour' and idtour='$tourid' ";
        $curs=DataAccess::selection($req);
        $r2=0;
        if($curs->rowCount()!=0)
        {
            while($row=$curs->fetch()){
                $r2=$row[0];
            }
            $curs->closeCursor();
        }
        
        $r=$r1-$r2;
        return $r;
    }
    public static function getCategorieNameById($categid){
        $req="select titre from specialtourscategories where idcate='$categid' ";
        $curs=DataAccess::selection($req);
        $catename="";
        if($curs->rowCount()!=0)
        {
            while($row=$curs->fetch()){
                $catename=$row[0];
            }
            $curs->closeCursor();
        }
        
       
        return $catename;
    }
    public static function getpriceoftour($id){
        $req="select prix from specialstours where idtour='$id' ";
        $curs=DataAccess::selection($req);
        $prix=0;
        while($row=$curs->fetch()){
            $prix=$row[0];
        }
        $curs->closeCursor();
        return $prix;
    }

}

?>