package Services;

import Entities.Code;
import Entities.Evaluation;
import Utils.DataSource;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServiceCode implements IServicee<Code> {
    private  Connection con= DataSource.getInstance().getCon();
    private Statement ste;
    public  ServiceCode(){
        try {
            ste=con.createStatement();

        }catch (SQLException e){
            System.out.println(e);
        }

    }

    @Override
    public void ajouter(Code code) throws SQLException {
        String rep="INSERT INTO `code` (`pourcentage`,`code`,`date`,`nom_etudiant`) VALUES (?,?,?,?);";
        PreparedStatement pre=con.prepareStatement(rep);
        pre.setString(1,code.getPourcentage());
        pre.setInt(2,code.getCode());
        pre.setDate(3, java.sql.Date.valueOf(code.getDate()));
        pre.setString(4,code.getNom_etudiant());


        pre.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        String rep="DELETE FROM `code` WHERE id="+id;
        PreparedStatement pre=con.prepareStatement(rep);
        pre.executeUpdate();


    }

    @Override
    public void update(Code code) throws SQLException {

    }

    @Override
    public Code findById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Code> readAll() throws SQLException {
        List<Code> list=new ArrayList<>();
        ResultSet res=ste.executeQuery("select * from code");
        while (res.next()) {

            int id = res.getInt(1);
            String pourcentage = res.getString("pourcentage");
            int code = res.getInt("code");
            LocalDate dat = res.getDate("date").toLocalDate();
            String nomEtudiant = res.getString("nom_etudiant");

            Code c1=new Code(id,pourcentage,code,dat,nomEtudiant);
            list.add(c1);
        }

        return list;
    }
}
