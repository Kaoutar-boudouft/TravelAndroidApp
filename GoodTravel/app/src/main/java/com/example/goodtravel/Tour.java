package com.example.goodtravel;

public class Tour {
    String IdTour,Titre,DateDepart,capacite,Prix,Image,Categorie;


    public Tour(String idtour,String titre, String dateDepart, String prix, String image, String capacite, String categorie) {
        this.Titre = titre;
        this.DateDepart = dateDepart;
        this.Prix = prix;
        this.Image = image;
        this.capacite=capacite;
        this.Categorie=categorie;
        this.IdTour=idtour;

    }

    public String getIdTour() {
        return IdTour;
    }

    public void setIdTour(String idTour) {
        IdTour = idTour;
    }

    public String getCapacite() {
        return capacite;
    }

    public void setCapacite(String capacite) {
        this.capacite = capacite;
    }

    public String getCategorie() {
        return Categorie;
    }

    public void setCategorie(String categorie) {
        Categorie = categorie;
    }


    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }



    public String getDateDepart() {
        return DateDepart;
    }

    public void setDateDepart(String dateDepart) {
        DateDepart = dateDepart;
    }



    public String getPrix() {
        return Prix;
    }

    public void setPrix(String prix) {
        Prix = prix;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
