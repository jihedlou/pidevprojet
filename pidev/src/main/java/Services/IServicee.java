package Services;

import java.sql.SQLException;
import java.util.List;

public interface IServicee<C> {
    public void ajouter(C c) throws SQLException;
    public void delete(int id) throws SQLException;

    public void update (C c) throws SQLException;

    C findById(int id) throws SQLException;

    List<C> readAll() throws SQLException;
}
