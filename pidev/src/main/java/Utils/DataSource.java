package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private static String url="jdbc:mysql://localhost:3306/esprit";
    private static String user="root";
    private static  String pwd="";
    private static DataSource data;
    private Connection con;

    private DataSource()
    {
        try {

            con = DriverManager.getConnection(url, user, pwd);
            System.out.println("connexion établie");
        }catch (SQLException e){
            System.out.println(e);
        }
    }


    public static DataSource getInstance(){
        if(data==null)
            data=new DataSource();
        return data;
    }
    public Connection getCon(){
        return con;
    }


}
