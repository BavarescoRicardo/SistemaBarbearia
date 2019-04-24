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
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Agenda;

/**
 *
 * @author Ricardo
 */
public class AgendaBD {
    public  List<Agenda> getAgenda(){
        List<Agenda> listAgenda = new ArrayList<Agenda>();
        Agenda agenda;
        Conecta conecta = new Conecta();
        String sql = "SELECT * FROM barbearia.agenda;";
        conecta.iniciaConexao();
        ResultSet rs;
        try {
            PreparedStatement pstm = conecta.getConexao().prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String cliente = rs.getString("cliente");
                String data = rs.getString("dia");
                String hora = rs.getString("hora");
                agenda = new Agenda(cliente, data, hora);
                agenda.setId(id);
                listAgenda.add(agenda);
                
            }
        } catch (SQLException ex) {
            System.out.println("Erro sql");
            //erro SQL
        } catch (Exception ex) {
            System.out.println("Erro geral");
            //erro geral
        }
        conecta.fechaConexao();

        
        
        return listAgenda;
    }
        
    
    public void salvarAgendamento(Agenda agenda){
        Conecta conecta = new Conecta();
       // corrigir 
       String sql  = "INSERT INTO `barbearia`.`agenda` (`cliente`, `dia`, `hora`) VALUES (?,?,?);";
        
        conecta.iniciaConexao();
        ResultSet rs;

        try {
            PreparedStatement pstm;
            pstm = conecta.getConexao().prepareStatement(sql);
            
           // corrigir
            pstm.setString(1, agenda.getNome());
            pstm.setString(2,agenda.getData());
            pstm.setString(3, agenda.getHora());
            
            //
            pstm.execute();
        

        } catch (SQLException ex) {
            System.out.println("Erro sql");
            //erro SQL
        } catch (Exception ex) {
            System.out.println("Erro geral");
            //erro geral
        }
    }
    
    public void removerAgendamento(int id){
         Conecta conecta = new Conecta();
        conecta.iniciaConexao();
        String remove = "DELETE FROM agenda WHERE id = ? ;";
    
        PreparedStatement pstm;
        
        try{
            
            pstm = conecta.getConexao().prepareStatement(remove);       
            pstm.setInt(1, id);
            pstm.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(AgendaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        AgendaBD agendaBD = new AgendaBD();
        agendaBD.removerAgendamento(2);
        
    }
}
