/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conecta;

/**
 *
 * @author Ricardo
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ricardo
 */
public class Conecta {

    private String DRIVER = "com.mysql.jdbc.Driver";
    private String BD = "barbearia";
    private String URL = "jdbc:mysql://localhost:3306/" + BD;
    private String USERNAME = "root";
    private String PASSWORD = "admin";
    private Connection conexao;
    private Statement stm;
        private String msg;
    private String c;

    public Conecta() {
        this.msg = this.iniciaConexao();
                
    }

    public Conecta(String bd, String user, String senha) {
        this.BD = bd;
        this.USERNAME = user;
        this.PASSWORD = senha;
        this.msg = this.iniciaConexao();

    }

    public String iniciaConexao() {
        try {
            Class.forName(this.DRIVER);
            this.conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            // Definimos o objeto responsÃƒÂ¡vel por executar os comandos
            this.stm = this.getConexao().createStatement();
            return "sucesso";
             
        } catch (ClassNotFoundException e) {
            this.conexao = null;
            return "NÃ£o foi possivel encontrar o driver de banco: " + e.getMessage();
        } catch (SQLException e) {
            this.conexao = null;
            return "SQLException Erro!" + e.getMessage();
        }
    }

    public String fechaConexao() {
        try {
            if (this.getConexao() != null) {
                this.getConexao().close();
                this.conexao = null;
            }
            if (this.getStm() != null) {
                this.stm = null;
            }
            return "Con Encerrada";
        } catch (SQLException ex) {
            return "Houve erro no fechamento da cnx! "+ex.getMessage();
        }
    }

    public Connection getConexao() {
        return conexao;
    }

    public Statement getStm() {
        return stm;
    }
    
    public String getMsg() {
        return msg;
    }
    public static void main(String[] args) {
        Conecta conecta = new Conecta();
        System.out.println(conecta.iniciaConexao());
    }

}

