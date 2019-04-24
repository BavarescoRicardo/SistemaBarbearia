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
import modelo.Produto;

/**
 *
 * @author Ricardo
 */
public class ProdutoBd {
    public static void main(String[] args) {
        ProdutoBd bd = new ProdutoBd();
        bd.getProdutos();
    }
    
    public List<Produto> getProdutos(){
        List<Produto> listaProduto = new ArrayList<Produto>();
        Produto produto;
        
         Conecta conecta = new Conecta();
        String sql = "SELECT * FROM barbearia.produtos;";
        conecta.iniciaConexao();
        ResultSet rs;
        try {
            PreparedStatement pstm = conecta.getConexao().prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String desc = rs.getString("descricao");
                float custo = Float.parseFloat(rs.getString("custo"));
                float venda = Float.parseFloat(rs.getString("precVenda")); 
                
                produto = new Produto(desc, custo, venda);
                produto.setId(id);
                listaProduto.add(produto);
            }
        } catch (SQLException ex) {
            System.out.println("Erro sql");
            //erro SQL
        } catch (Exception ex) {
            System.out.println("Erro geral");
            //erro geral
        }
        conecta.fechaConexao();
   
        
        return listaProduto;
    }
         public Produto getProdutoId(int idP){
        Produto produto = null;
        Conecta conecta = new Conecta();
        String sql = "SELECT * FROM barbearia.produtos WHERE id = ?;";
        conecta.iniciaConexao();
        ResultSet rs;
        try {
            PreparedStatement pstm = conecta.getConexao().prepareStatement(sql);
            pstm.setInt(1, idP);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int numeroId = rs.getInt("id");
                String desc = rs.getString("descricao");
                float custo = rs.getFloat("custo");
                float venda = rs.getFloat("precVenda");
                produto = new Produto(desc,custo,venda);
                produto.setId(numeroId);
            }             
 
            
        } catch (SQLException ex) {
            System.out.println("Erro sql");
            //erro SQL
        } catch (Exception ex) {
            System.out.println("Erro geral");
            //erro geral
        }
        conecta.fechaConexao();
        
        return produto;
    }
        
     public  Produto getProdutoEspecifico(String descricao){
        Produto produto = null;
        Conecta conecta = new Conecta();
        String sql = "SELECT * FROM barbearia.produtos WHERE ? = descricao ;";
        conecta.iniciaConexao();
        ResultSet rs;
        try {
            PreparedStatement pstm = conecta.getConexao().prepareStatement(sql);
            pstm.setString(1, descricao);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int numero = rs.getInt("id");
                String desc = rs.getString("descricao");
                float custo = rs.getFloat("custo");
                float venda = rs.getFloat("precVenda");
                produto = new Produto(desc,custo,venda);
                produto.setId(numero);
                
            }
        } catch (SQLException ex) {
            System.out.println("Erro sql");
            //erro SQL
        } catch (Exception ex) {
            System.out.println("Erro geral");
            //erro geral
        }
        conecta.fechaConexao();
     
        return produto;
    }
     
      public void salvarProduto(Produto produto){
        Conecta conecta = new Conecta();
        String sql  = "INSERT INTO `barbearia`.`produtos` (`descricao`, `custo`, `precVenda`) VALUES (?,?,?);";
        
        conecta.iniciaConexao();
        ResultSet rs;

        try {
            PreparedStatement pstm;
            pstm = conecta.getConexao().prepareStatement(sql);
            
            pstm.setString(1, produto.getDescricao());
            pstm.setFloat(2,produto.getCusto());
            pstm.setFloat(3, produto.getPrecoVenda());
            
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

      public void atualizaProduto(Produto produto){
        Conecta conecta = new Conecta();
        String sql  = "UPDATE `barbearia`.`produtos` SET `descricao`=?, `custo`=?, `precVenda`=? WHERE `id`=?;";


        conecta.iniciaConexao();
        ResultSet rs;

        try {
            PreparedStatement pstm;
            pstm = conecta.getConexao().prepareStatement(sql);

            pstm.setString(1, produto.getDescricao());
            pstm.setFloat(2,produto.getCusto());
            pstm.setFloat(3, produto.getPrecoVenda());
            pstm.setInt(4, produto.getId());
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
