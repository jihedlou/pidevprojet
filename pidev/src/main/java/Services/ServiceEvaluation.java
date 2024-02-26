package Services;

import Entities.Evaluation;
import Utils.DataSource;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServiceEvaluation implements IService<Evaluation>{
    private Connection con= DataSource.getInstance().getCon();
    private Statement ste;
    public  ServiceEvaluation(){
        try {
            ste=con.createStatement();

        }catch (SQLException e){
            System.out.println(e);
        }

    }
    public void ajouter(Evaluation evaluation) throws SQLException {
        String rep="INSERT INTO `evaluation` (`date`,`NoteF`,`description`,`cour`,`nom_enseignant`) VALUES (?,?,?,?,?);";
        PreparedStatement pre=con.prepareStatement(rep);
        pre.setDate(1, java.sql.Date.valueOf(evaluation.getDate()));
        pre.setInt(2,evaluation.getNoteF());
        pre.setString(3,evaluation.getDescription());
        pre.setString(4,evaluation.getCour());
        pre.setString(5,evaluation.getNom_enseignant());

        pre.executeUpdate();

    }


    @Override
    public void delete(int id) throws SQLException {
        String rep="DELETE FROM `evaluation` WHERE id="+id;
        PreparedStatement pre=con.prepareStatement(rep);
        pre.executeUpdate();

    }

    @Override
    public void update(Evaluation evaluation) throws SQLException {
        String req = "UPDATE `evaluation` SET `date`=\""+evaluation.getDate()+"\",`NoteF`=\""+evaluation.getNoteF()+"\",`description`=\""+"\" where id ="+evaluation.getId();
        System.out.println(req);
        ste.executeUpdate(req);
    }




    @Override
    public Evaluation findById(int id) throws SQLException {
        ResultSet res = ste.executeQuery("SELECT * FROM evaluation WHERE id+"+id);
        if(res.next()) {
            int ide = res.getInt("id");
            LocalDate date = res.getDate("date").toLocalDate();
            int note = res.getInt("NoteF");
            String description = res.getString("description");
            String cour = res.getString("cour");
            String nom_enseignant = res.getString("nom_enseignant");
            Evaluation e1=new Evaluation(ide,date,note,description,cour,nom_enseignant);
            return e1;
        }
        return null;
    }

    @Override
    public List<Evaluation> readAll() throws SQLException {
        List<Evaluation> list=new ArrayList<>();
        ResultSet res=ste.executeQuery("select * from evaluation");
        while (res.next()) {

            int id = res.getInt(1);
            LocalDate date = res.getDate("Date").toLocalDate();
            int NoteF = res.getInt("NoteF");
            String description = res.getString("description");
            String cours = res.getString("cour");
            String nom_ens = res.getString("nom_enseignant");
            Evaluation e1=new Evaluation(id,date,NoteF,description,cours,nom_ens);
            list.add(e1);
        }

        return list;
    }


}
