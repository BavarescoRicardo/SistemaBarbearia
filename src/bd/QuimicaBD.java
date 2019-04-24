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
import modelo.Quimica;

/**
 *
 * @author Ricardo
 */
public class QuimicaBD {
    public List<Quimica> getListaQuimica(){
        List<Quimica> listaQuimica = new ArrayList<Quimica>();
        String SQL  = "SELECT * FROM quimica;";
        Conecta conecta = new Conecta();
       conecta.iniciaConexao();
        ResultSet rs;
        try {
            PreparedStatement pstm = conecta.getConexao().prepareStatement(SQL);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String desc = rs.getString("descricao");
                float valor = Float.parseFloat(rs.getString("valor"));
                Quimica quimica = new Quimica(id,desc,valor);
                listaQuimica.add(quimica);
            }
        } catch (SQLException ex) {
            System.out.println("Erro sql");
            //erro SQL
        } catch (Exception ex) {
            System.out.println("Erro geral");
            //erro geral
        }
        conecta.fechaConexao();


        return listaQuimica;
    }


    public Quimica getQuimicaId(int idQ){
        Quimica quimica = null;
        String sql  = "SELECT * FROM quimica WHERE id = ?;";
        Conecta conecta = new Conecta();
        conecta.iniciaConexao();
        ResultSet rs;
        try {
            PreparedStatement pstm = conecta.getConexao().prepareStatement(sql);
            pstm.setInt(1, idQ);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String desc = rs.getString("descricao");
                float valor = Float.parseFloat(rs.getString("valor"));
                quimica = new Quimica(id,desc,valor);
            }
        } catch (SQLException ex) {
            System.out.println("Erro sql");
            //erro SQL
        } catch (Exception ex) {
            System.out.println("Erro geral");
            //erro geral
        }
        conecta.fechaConexao();

        return quimica;
    }

    public Quimica getQuimicaDesc(String descricao){
        Quimica quimica = null;
        String sql  = "SELECT * FROM quimica WHERE descricao = ?;";
        Conecta conecta = new Conecta();
        conecta.iniciaConexao();
        ResultSet rs;
        try {
            PreparedStatement pstm = conecta.getConexao().prepareStatement(sql);
            pstm.setString(1, descricao);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String desc = rs.getString("descricao");
                float valor = Float.parseFloat(rs.getString("valor"));
                quimica = new Quimica(id,desc,valor);
            }
        } catch (SQLException ex) {
            System.out.println("Erro sql");
            //erro SQL
        } catch (Exception ex) {
            System.out.println("Erro geral");
            //erro geral
        }
        conecta.fechaConexao();



        return quimica;
    }


     public void atualizarQuimica(Quimica quimica,String antigo){
     Conecta conecta = new Conecta();
     String sql = "UPDATE `barbearia`.`quimica` SET `descricao` =?, `valor` =? WHERE `descricao` =?;";
     conecta.iniciaConexao();

      try {
            PreparedStatement pstm;
            pstm = conecta.getConexao().prepareStatement(sql);

            pstm.setString(1, quimica.getDescricao());
            pstm.setFloat(2,quimica.getValor());
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



