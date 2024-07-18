import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        // JDBC URL, usuario y contraseña de MySQL
        String URL = "jdbc:mysql://localhost:3306/estudiantes2024A";
        String USER = "root";
        String PASSWORD = "123456";

        String cedula = "1726195207";

        String sql = "DELETE FROM estudiante WHERE cedula = ?";

        try (
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement statement = conn.prepareStatement(sql)
        ) {
            statement.setString(1, cedula);

            int filasEliminadas = statement.executeUpdate();

            if (filasEliminadas > 0) {
                System.out.println("El estudiante " + cedula + " ha sido eliminado correctamente.");
            } else {
                System.out.println("No se encontró ningún estudiante con cedula " + cedula + " para eliminar.");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}