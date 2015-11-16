/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author DIEGOHEYY
 */
public class Conexao {

    private static Connection conexao = null;

    public static Connection obterConexao() throws SQLException {
        /*
		 * localhost ->  Máquina onde está hospedado o banco, pode ser o IP da máquina, para isto é necessário habilitar o acesso
		 * 				 no arquivo de configuração pg_hba.conf (no caso do postgres)
		 * :5432     ->  Porta habilitada para conexões no postgres
		 * 
         */
        //String nomeDoBanco = "AULAPROG";
        //String url = "jdbc:sqlserver://localhost:49275/" + nomeDoBanco;
        String url = "jdbc:sqlserver://localhost:49275;"
                + "databaseName=contato";
        String usuario = "sa";
        String senha = "sa123";

        if (conexao == null) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conexao = DriverManager.getConnection(url, usuario, senha);
            } catch (ClassNotFoundException e1) {
                System.out.println("Classe não encontrada");
                System.exit(0);
            } catch (SQLException e) {
                throw e;
            }

        }
        return conexao;
    }

    public static void close() {
        try {
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conexao = null;
    }

    public static Statement obterStatement() throws SQLException {
        try {
            return obterConexao().createStatement();
        } catch (SQLException e) {
            throw e;
        }
    }
}
