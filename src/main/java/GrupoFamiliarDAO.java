import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GrupoFamiliarDAO {
    private Connection connection;

    public GrupoFamiliarDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(GrupoFamiliar grupoFamiliar) {
        try {
            String sql = "INSERT INTO grupo_familiar (nombre, parentesco) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, grupoFamiliar.getNombre());
            statement.setString(2, grupoFamiliar.getParentesco());
            statement.executeUpdate();
        } catch (SQLException e) {
            // Manejo de excepciones, por ejemplo, registro de errores o lanzar una excepción personalizada.
        }
    }

    public GrupoFamiliar read(int id) {
        GrupoFamiliar grupoFamiliar = null;
        try {
            String sql = "SELECT * FROM grupo_familiar WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                grupoFamiliar = new GrupoFamiliar();
                grupoFamiliar.setId(resultSet.getInt("id"));
                grupoFamiliar.setNombre(resultSet.getString("nombre"));
                grupoFamiliar.setParentesco(resultSet.getString("parentesco"));
            }
        } catch (SQLException e) {
            // Manejo de excepciones, por ejemplo, registro de errores o lanzar una excepción personalizada.
        }
        return grupoFamiliar;
    }

    public void update(GrupoFamiliar grupoFamiliar) {
        try {
            String sql = "UPDATE grupo_familiar SET nombre = ?, parent";
            String sql = "UPDATE grupo_familiar SET nombre = ?, parentesco = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, grupoFamiliar.getNombre());
            statement.setString(2, grupoFamiliar.getParentesco());
            statement.setInt(3, grupoFamiliar.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            // Manejo de excepciones, por ejemplo, registro de errores o lanzar una excepción personalizada.
        }
    }

    public void delete(int id) {
        try {
            String sql = "DELETE FROM grupo_familiar WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            // Manejo de excepciones, por ejemplo, registro de errores o lanzar una excepción personalizada.
        }
    }
}
