package Entities;

import java.time.LocalDate;

public class Code {
    private int id;
    private String nom_etudiant;
    private String pourcentage;
    private  int code;


     private LocalDate date;

    public Code( String pourcentage, int code, LocalDate date,String nom_etudiant) {
        this.nom_etudiant=nom_etudiant;
        this.pourcentage = pourcentage;
        this.code = code;
        this.date = date;
    }
    public Code(int id, String pourcentage, int code, LocalDate date,String nom_etudiant) {
        this(pourcentage,code,date,nom_etudiant);
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(String pourcentage) {
        this.pourcentage = pourcentage;
    }

    public int getCode() {
        return code;
    }

    public String getNom_etudiant() {
        return nom_etudiant;
    }

    public void setNom_etudiant(String nom_etudiant) {
        this.nom_etudiant = nom_etudiant;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Code{" +
                "id=" + id +
                ", nom_etudiant='" + nom_etudiant + '\'' +
                ", pourcentage='" + pourcentage + '\'' +
                ", code=" + code +
                ", date=" + date +
                '}';
    }
}
