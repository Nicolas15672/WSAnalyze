//@author Erlandson
package dao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conecta {

    private static volatile Conecta instancia;
    private Connection conexao;

    public Conecta() {

    }

    public Connection getConnection() {

        try {

            if (this.conexao == null) {

                Class.forName("com.mysql.jdbc.Driver");
                conexao = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/analyses", "root", "");

                System.out.println("Conexão Efetuada");

            }
        } catch (SQLException | ClassNotFoundException e) {
        }

        return conexao;
    }

    public static Conecta getInstance() {

        if (instancia == null) {
            synchronized (Conecta.class) {
                if (instancia == null) {
                    instancia = new Conecta();
                }
            }
        }

        return instancia;
    }

}
