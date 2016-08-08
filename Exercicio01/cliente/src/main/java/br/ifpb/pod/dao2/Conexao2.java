/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpb.pod.dao2;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao2 {

    private Connection conn;

    public Conexao2() throws SQLException, IOException, ClassNotFoundException {
        try {
            String url = "jdbc:postgresql://localhost:5432/bd2atividade1";
            String user = "postgres";
            String password = "12345";

            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        return this.conn;
    }

    public void closeAll(PreparedStatement stat) throws Exception {
        try {
            stat.close();
            this.conn.close();

        } catch (SQLException e) {
            throw new Exception("Falha ao fechar: " + e.getMessage());
        }

    }

    public void closeAll(Statement stat) throws Exception {
        try {
            stat.close();
            this.conn.close();
        } catch (SQLException e) {
            throw new Exception("Falha ao fechar: " + e.getMessage());
        }
    }

}
