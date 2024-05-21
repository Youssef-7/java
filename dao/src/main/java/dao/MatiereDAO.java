package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Matiere;

public class MatiereDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/formulaire?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "azerty";

    private static final String INSERT_MATIERE_SQL = "INSERT INTO matiere (nom) VALUES (?);";
    private static final String SELECT_MATIERE_BY_ID = "SELECT id, nom FROM matiere WHERE id = ?;";
    private static final String SELECT_ALL_MATIERES = "SELECT * FROM matiere;";
    private static final String DELETE_MATIERE_SQL = "DELETE FROM matiere WHERE id = ?;";
    private static final String UPDATE_MATIERE_SQL = "UPDATE matiere SET nom = ? WHERE id = ?;";

    public MatiereDAO() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertMatiere(Matiere matiere) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MATIERE_SQL)) {
            preparedStatement.setString(1, matiere.getNom());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Matiere selectMatiere(int id) {
        Matiere matiere = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MATIERE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String nom = rs.getString("nom");
                matiere = new Matiere(id, nom);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matiere;
    }

    public List<Matiere> selectAllMatieres() {
        List<Matiere> matieres = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MATIERES)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                matieres.add(new Matiere(id, nom));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matieres;
    }

    public boolean deleteMatiere(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_MATIERE_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateMatiere(Matiere matiere) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_MATIERE_SQL)) {
            statement.setString(1, matiere.getNom());
            statement.setInt(2, matiere.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
