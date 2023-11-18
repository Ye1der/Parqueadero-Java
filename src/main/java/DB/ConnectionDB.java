package DB;

import java.sql.*;

public class ConnectionDB {

    private String driver = "jdbc:sqlite";
    private String ruta = "src/main/java/DB/Parqueadero.db";
    private Connection connection;
    private Statement statement;
    private ResultSet result;

    public ConnectionDB() {
        String url = driver + ":" + ruta;

        try {
            connection = DriverManager.getConnection(url);
            if (connection != null) {
                DatabaseMetaData data = connection.getMetaData();
                System.out.println("Base de datos conectada crrectamente: " + data.getDriverName());
            }
        } catch (SQLException ex) {
            System.out.println("error al realizar la concxion con la base de datos: " + ex.getMessage());
        }
    }

    private void finishConecction(){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println("error al cerrar la conexion: " + ex.getMessage());
            }
        }
    }

    public void closeConnection(){
        finishConecction();
    }

    public ResultSet consult(String query){
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(query);
            return result;
        } catch (SQLException ex) {
            System.out.println("error al realizar la consulta: " + ex.getMessage());
            return null;
        }
    }

    public boolean exexute(String query){
        try {
            statement = connection.createStatement();
            boolean complete = statement.execute(query);
            return complete;
        } catch (SQLException ex) {
            System.out.println("error al realizar la consulta: " + ex.getMessage());
            return false;
        }
    }
}
