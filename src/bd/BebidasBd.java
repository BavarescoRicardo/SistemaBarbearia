/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import conecta.Conecta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Bebidas;

/**
 *
 * @author Ricardo
 */
public class BebidasBd {
    
        public  List<Bebidas> getBebidas(){
        List<Bebidas> listBebidas = new ArrayList<Bebidas>();
        Bebidas bebida;
        Conecta conecta = new Conecta();
        String sql = "SELECT * FROM barbearia.bebidas;";
        conecta.iniciaConexao();
        ResultSet rs;
        try {
            PreparedStatement pstm = conecta.getConexao().prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String desc = rs.getString("descricao");
                float custo = rs.getFloat("custo");
                float venda = rs.getFloat("precVenda");
                bebida = new Bebidas(desc,custo,venda);
                bebida.setId(id);
                
                listBebidas.add(bebida);
            }
        } catch (SQLException ex) {
            System.out.println("Erro sql");
            //erro SQL
        } catch (Exception ex) {
            System.out.println("Erro geral");
            //erro geral
        }
        
        conecta.fechaConexao();

        
        
        return listBebidas;
    }
      
     public Bebidas getBebidaId(int idB){
        Bebidas bebida = null;
        Conecta conecta = new Conecta();
        String sql = "SELECT * FROM barbearia.bebidas WHERE id = ?;";
        conecta.iniciaConexao();
        ResultSet rs;
        try {
            PreparedStatement pstm = conecta.getConexao().prepareStatement(sql);
            pstm.setInt(1, idB);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String desc = rs.getString("descricao");
                float custo = rs.getFloat("custo");
                float venda = rs.getFloat("precVenda");
                bebida = new Bebidas(desc,custo,venda);
                bebida.setId(id);
}
        } catch (SQLException ex) {
            System.out.println("Erro sql");
            //erro SQL
        } catch (Exception ex) {
            System.out.println("Erro geral");
            //erro geral
        }
        conecta.fechaConexao();
        
        return bebida;
    }
        
    public  Bebidas getBebidaEspecifica(String descricao){
        Bebidas bebida = null;
        Conecta conecta = new Conecta();
        String sql = "SELECT * FROM barbearia.bebidas WHERE ? = descricao ;";
        conecta.iniciaConexao();
        ResultSet rs;
        try {
            PreparedStatement pstm = conecta.getConexao().prepareStatement(sql);
            pstm.setString(1, descricao);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String desc = rs.getString("descricao");
                float custo = rs.getFloat("custo");
                float venda = rs.getFloat("precVenda");
                bebida = new Bebidas(desc,custo,venda);
                bebida.setId(id);
                
            }
        } catch (SQLException ex) {
            System.out.println("Erro sql");
            //erro SQL
        } catch (Exception ex) {
            System.out.println("Erro geral");
            //erro geral
        }
        conecta.fechaConexao();
        
        return bebida;
    }
       
    public void salvarBebida(Bebidas bebida){
        Conecta conecta = new Conecta();
        String sql  = "INSERT INTO `barbearia`.`bebidas` (`descricao`, `custo`, `precVenda`) VALUES (?,?,?);";
        
        conecta.iniciaConexao();
        ResultSet rs;

        try {
            PreparedStatement pstm;
            pstm = conecta.getConexao().prepareStatement(sql);
            
            pstm.setString(1, bebida.getDescricao());
            pstm.setFloat(2,bebida.getCusto());
            pstm.setFloat(3, bebida.getPrecoVenda());
            
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

        public void atualizaBebida(Bebidas bebida){
        Conecta conecta = new Conecta();
        String sql  = "UPDATE `barbearia`.`bebidas` SET `descricao`=?, `custo`=?, `precVenda`=? WHERE `id`=?;";


        conecta.iniciaConexao();
        ResultSet rs;

        try {
            PreparedStatement pstm;
            pstm = conecta.getConexao().prepareStatement(sql);

            pstm.setString(1, bebida.getDescricao());
            pstm.setFloat(2,bebida.getCusto());
            pstm.setFloat(3, bebida.getPrecoVenda());
            pstm.setInt(4, bebida.getId());
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

        public static void main(String[] args) {
        BebidasBd bd = new BebidasBd();
        bd.getBebidas();
    }

}
