package Entities;

import java.time.LocalDate;

public class Evaluation {
    private int id;
        private LocalDate date;
        private int NoteF;
        private String cour;
        private String nom_enseignant;
        private String description;

        //private  User id_user;

       //private Cour id_cour;

public Evaluation(){

}
    public Evaluation(LocalDate date, int NoteF,String description,String cour,String nom_enseignant) {

        this.cour=cour;
        this.nom_enseignant=nom_enseignant;
        this.date = date;
        this.NoteF = NoteF;
        this.description=description;
    }
    public Evaluation(int id, LocalDate date, int NoteF,String description,String cour,String nom_enseignant) {
        this.id = id;
        this.date = date;
        this.NoteF = NoteF;
        this.description=description;
        this.cour=cour;
        this.nom_enseignant=nom_enseignant;

    }

    public String getCour() {
        return cour;
    }

    public void setCour(String cour) {
        this.cour = cour;
    }

    public String getNom_enseignant() {
        return nom_enseignant;
    }

    public void setNom_enseignant(String nom_enseignant) {
        this.nom_enseignant = nom_enseignant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getNoteF() {
        return NoteF;
    }

    public void setNoteF(int NoteF) {
        this.NoteF = NoteF;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Evaluation{" +
                "id=" + id +
                ", date=" + date +
                ", NoteF=" + NoteF +
                ", cour='" + cour + '\'' +
                ", nom_enseignant='" + nom_enseignant + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}


