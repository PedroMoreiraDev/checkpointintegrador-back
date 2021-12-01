package br.com.turma04.ctdcommerce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConfiguracaoJDBC {
    private String jdbcDriver;
    private String dbUrl;
    private String nomeUsuario;
    private String senha;

    private static final String SQL_CREATE_TABLE = "CREATE TABLE categories " +
            "(" +
            "id int auto_increment primary key, " +
            "name varchar(50))";

    private static final String SQL_CREATE_TABLE2 = "CREATE TABLE products " +
            "(" +
            "id int auto_increment primary key, " +
            "title varchar(50), " +
            "price decimal(10,2), " +
            "description varchar(255), " +
            "image varchar(255), " +
            "category_id int)";

    public ConfiguracaoJDBC(String jdbcDriver, String dbUrl, String nomeUsuario, String senha) {
        this.jdbcDriver = jdbcDriver;
        this.dbUrl = dbUrl;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }
    public ConfiguracaoJDBC() {
        this.jdbcDriver = "org.h2.Driver";
        this.dbUrl = "jdbc:h2:~/test";
        this.nomeUsuario = "sa";
        this.senha = "";
        criarTabela();
    }
    private void criarTabela(){
        try {
            Connection connection = conectarBanco();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);
            statement.execute(SQL_CREATE_TABLE2);
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Connection conectarBanco(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, nomeUsuario, senha);
        } catch (Exception e){
            e.printStackTrace();
        }
        return  connection;
    }
}
