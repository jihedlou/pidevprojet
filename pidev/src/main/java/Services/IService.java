package Services;

import java.sql.SQLException;
import java.util.List;

public interface IService<E> {
    public void ajouter(E e) throws SQLException;
    public void delete(int id) throws SQLException;

    public void update (E e) throws SQLException;

    E findById(int id) throws SQLException;

    List<E> readAll() throws SQLException;
}
