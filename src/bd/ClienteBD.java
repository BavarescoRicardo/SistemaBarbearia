/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import conecta.Conecta;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;

/**
 *
 * @author Ricardo
 */
public class ClienteBD {
  
       public  List<Cliente> getClientes(){
        List<Cliente> listClientes = new ArrayList<Cliente>();
        Cliente cliente;
        Conecta conecta = new Conecta();
        String sql = "SELECT * FROM barbearia.clientes ORDER BY nome;";
        conecta.iniciaConexao();
        ResultSet rs;
        try {
            PreparedStatement pstm = conecta.getConexao().prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int idc = rs.getInt("id");
                String nome = rs.getString("nome");
                Date data = rs.getDate("ultimoCorte");
                String apelido = rs.getString("Apelido");
                String contato = rs.getString("Contato");
                String nasc = rs.getString("nascimento");

                cliente = new Cliente(nome,nasc, apelido, contato,data);
                cliente.setId(idc);
                
                listClientes.add(cliente);
            }
        } catch (SQLException ex) {
            System.out.println("Erro sql");
            //erro SQL
        } catch (Exception ex) {
            System.out.println("Erro geral");
            //erro geral
        }
        conecta.fechaConexao();

        
        
        return listClientes;
    }
       
    public Cliente getClienteEspecifico(int idC){
        Cliente cliente = null;
        Conecta conecta = new Conecta();
        String sql = "select * from clientes where id = ?;";
        conecta.iniciaConexao();
        ResultSet rs;
        try {
            PreparedStatement pstm = conecta.getConexao().prepareStatement(sql);
            pstm.setInt(1, idC);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                
                String nome = rs.getString("nome");
                Date data = rs.getDate("ultimoCorte");
                String apelido = rs.getString("Apelido");
                String contato = rs.getString("Contato");
                String nasc = rs.getString("nascimento");

                cliente = new Cliente(nome,nasc, apelido, contato,data);
                cliente.setId(id);
                
}
        } catch (SQLException ex) {
            System.out.println("Erro sql");
            //erro SQL
        } catch (Exception ex) {
            System.out.println("Erro geral");
            //erro geral
        }
        conecta.fechaConexao(); 
        
        return cliente;
    }
    
     public Cliente getClienteNome(String nomeRef){
        Cliente cliente = null;
        Conecta conecta = new Conecta();
        String sql = "select * from clientes where nome = ?;";
        conecta.iniciaConexao();
        ResultSet rs;
        try {
            PreparedStatement pstm = conecta.getConexao().prepareStatement(sql);
            pstm.setString(1, nomeRef);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                Date data = rs.getDate("ultimoCorte");
                String apelido = rs.getString("Apelido");
                String contato = rs.getString("Contato");
                String nasc = rs.getString("nascimento");

                cliente = new Cliente(nome,nasc, apelido, contato,data);
                
                cliente.setId(id);
}
        } catch (SQLException ex) {
            System.out.println("Erro sql");
            //erro SQL
        } catch (Exception ex) {
            System.out.println("Erro geral");
            //erro geral
        }
        conecta.fechaConexao(); 
        
        return cliente;
    }
     
      public void removeCliente(int id){
        Conecta conecta = new Conecta();
        String sql = "DELETE FROM `barbearia`.`clientes` WHERE `id` = ?; ";
        conecta.iniciaConexao();
  
        try {
            PreparedStatement pstm = conecta.getConexao().prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();

 
        } catch (SQLException ex) {
            System.out.println("Erro sql");
            //erro SQL
        } catch (Exception ex) {
            System.out.println("Erro geral");
            //erro geral
        }
        conecta.fechaConexao();
        
    }
       
    public void salvarCliente(Cliente cliente){
        Conecta conecta = new Conecta();
        String sql  = "INSERT INTO `barbearia`.`clientes` (`nome`, `ultimoCorte`,`apelido`,`contato`,`nascimento`) VALUES (?, ?, ?, ?, ?);";

        String d = "2018-05-05";
        //d = LocalDate.now().toString();
        DateFormat forma = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date data = null;
        try {
            data = new java.sql.Date(forma.parse(d).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(FaturamentoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        data = new java.sql.Date(Calendar.getInstance().getTime().getTime());
       
        conecta.iniciaConexao();
        ResultSet rs;

        try {
            PreparedStatement pstm;
            pstm = conecta.getConexao().prepareStatement(sql);
            
            pstm.setString(1, cliente.getNome());
            pstm.setDate(2,data);
            pstm.setString(3, cliente.getApelido());
            pstm.setString(4, cliente.getContato());
            pstm.setString(5, cliente.getAniversario());
            
            pstm.execute();
        

        } catch (SQLException ex) {
            System.out.println("Erro sql");
            //erro SQL
        } catch (Exception ex) {
            System.out.println("Erro geral");
            //erro geral
        }
        conecta.fechaConexao();
    }


}
