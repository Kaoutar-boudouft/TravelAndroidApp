package com.example.goodtravel;

public class Travel {
    private String id,villedepart,villearrivee,datedepart,datearrivee,prix,heuredepart,heurearrivee,capacite,outile;




    public Travel(String id,String villedepart, String villearrivee, String datedepart, String datearrivee, String prix, String heuredepart, String heurearrivee, String capacite,String outile) {
        this.villedepart = villedepart;
        this.villearrivee = villearrivee;
        this.datedepart = datedepart;
        this.datearrivee = datearrivee;
        this.prix = prix;
        this.heurearrivee=heurearrivee;
        this.heuredepart=heuredepart;
        this.capacite=capacite;
        this.outile=outile;
        this.id=id;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOutile() {
        return outile;
    }

    public void setOutile(String outile) {
        this.outile = outile;
    }

    public String getVilledepart() {
        return villedepart;
    }

    public void setVilledepart(String villedepart) {
        this.villedepart = villedepart;
    }

    public String getVillearrivee() {
        return villearrivee;
    }

    public void setVillearrivee(String villearrivee) {
        this.villearrivee = villearrivee;
    }

    public String getDatedepart() {
        return datedepart;
    }

    public void setDatedepart(String datedepart) {
        this.datedepart = datedepart;
    }

    public String getDatearrivee() {
        return datearrivee;
    }

    public void setDatearrivee(String datearrivee) {
        this.datearrivee = datearrivee;
    }

    public String getHeuredepart() {
        return heuredepart;
    }

    public void setHeuredepart(String heuredepart) {
        this.heuredepart = heuredepart;
    }

    public String getHeurearrivee() {
        return heurearrivee;
    }

    public void setHeurearrivee(String heurearrivee) {
        this.heurearrivee = heurearrivee;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }
    public String getCapacite() {
        return capacite;
    }

    public void setCapacite(String capacite) {
        this.capacite = capacite;
    }
}
