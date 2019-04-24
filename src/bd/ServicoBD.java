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
import modelo.Servico;

/**
 *
 * @author Ricardo
 */
public class ServicoBD {
    
      public  List<Servico> getServicos(){
        List<Servico> listServicos = new ArrayList<Servico>();
        Servico servico;
        Conecta conecta = new Conecta();
        String sql = "SELECT * FROM barbearia.servicos;";
        conecta.iniciaConexao();
        ResultSet rs;
        try {
            PreparedStatement pstm = conecta.getConexao().prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String desc = rs.getString("descricao");
                float valor = Float.parseFloat(rs.getString("valor"));
                servico = new Servico(desc,valor);
                servico.setId(id);
                
                listServicos.add(servico);
            }
        } catch (SQLException ex) {
            System.out.println("Erro sql");
            //erro SQL
        } catch (Exception ex) {
            System.out.println("Erro geral");
            //erro geral
        }
        conecta.fechaConexao();
   
        
        return listServicos;
    }
      
     public Servico getServicoId(int idS){
        Servico servico = null;
        Conecta conecta = new Conecta();
        String sql = "SELECT * FROM barbearia.servicos WHERE id = ?;";
        conecta.iniciaConexao();
        ResultSet rs;
        try {
            PreparedStatement pstm = conecta.getConexao().prepareStatement(sql);
            pstm.setInt(1, idS);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String desc = rs.getString("descricao");
                float valor = rs.getInt("valor");
                servico = new Servico(desc, valor);
                servico.setId(id);
            }
        } catch (SQLException ex) {
            System.out.println("Erro sql");
            //erro SQL
        } catch (Exception ex) {
            System.out.println("Erro geral");
            //erro geral
        }
        conecta.fechaConexao();
        
        return servico;
    }

     public Servico getServicoEspecifico(String descricao){
        Servico servico = null;
        Conecta conecta = new Conecta();
        String sql = "SELECT * FROM barbearia.servicos WHERE descricao = ?;";
        conecta.iniciaConexao();
        ResultSet rs;
        try {
            PreparedStatement pstm = conecta.getConexao().prepareStatement(sql);
            pstm.setString(1, descricao);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String desc = rs.getString("descricao");
                float valor = rs.getInt("valor");
                servico = new Servico(desc, valor);
                servico.setId(id);
            }
        } catch (SQLException ex) {
            System.out.println("Erro sql");
            //erro SQL
        } catch (Exception ex) {
            System.out.println("Erro geral");
            //erro geral
        }
        conecta.fechaConexao();
        
        return servico;
    }

 public void atualizarServico(Servico servico,String antigo){
     Conecta conecta = new Conecta();
     String sql = "UPDATE `barbearia`.`servicos` SET `descricao` =?, `valor` =? WHERE `descricao` =?;";
     conecta.iniciaConexao();

      try {
            PreparedStatement pstm;
            pstm = conecta.getConexao().prepareStatement(sql);

            pstm.setString(1, servico.getDescricao());
            pstm.setFloat(2,servico.getValor());
            pstm.setString(3, antigo);

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
