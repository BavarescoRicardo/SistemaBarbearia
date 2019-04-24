/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bd;

import conecta.Conecta;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import modelo.Bebidas;
import modelo.Cliente;
import modelo.Produto;
import modelo.Quimica;
import modelo.Relatorio;

/**
 *
 * @author Skynet
 */
public class RelatorioBD {

    ClienteBD clienteBD = new ClienteBD();
    ServicoBD servicoBD = new ServicoBD();
    BebidasBd bebidaBd = new BebidasBd();
    ProdutoBd produtoBD = new ProdutoBd();
    Cliente cliente;

    // Ordenar por nomes / datas e servicos 

        public List<Relatorio> getDatas(Calendar d, int filtro){
        List<Relatorio> listaRelatorio = new ArrayList<Relatorio>();
        Relatorio relatorio;
        // java.sql.Date data = new Date(d.getTimeInMillis());
        Conecta conecta = new Conecta();
        String sql = "SELECT * FROM barbearia.dias ORDER BY dat;";

        if(filtro == 2){
             sql = "SELECT * FROM barbearia.dias WHERE corte = 1 ORDER BY dat;";
        }
          if(filtro == 3){
             sql = "SELECT * FROM barbearia.dias WHERE barba = 1 ORDER BY dat;";
        }

          if(filtro == 4){
             sql = "SELECT * FROM barbearia.dias WHERE sobranchelas = 1 ORDER BY dat;";
        }

        conecta.iniciaConexao();
        ResultSet rs;
        QuimicaBD quimicaBD = new QuimicaBD();
        try {
            PreparedStatement pstm = conecta.getConexao().prepareStatement(sql);

            //pstm.setDate(1, data);
            rs = pstm.executeQuery();
            while (rs.next()) {

                java.sql.Date dia = rs.getDate("dat");
                int idCliente = rs.getInt("idCliente");
                cliente = clienteBD.getClienteEspecifico(idCliente);
                String nomeCliente = cliente.getNome();
                
                String corte = "Nao";
                String barba = "Nao";
                String sobran = "Nao";
                if(rs.getInt("corte") == 1){
                    corte = "Sim";
                }
           
                if(rs.getInt("barba") == 1){
                    barba = "Sim";
                }
                if(rs.getInt("sobranchelas") == 1){
                    sobran = "Sim";
                }

                int idQuimica = rs.getInt("idQuimica");
                Quimica q = quimicaBD.getQuimicaId(idQuimica);
                String quimica = q.getDescricao();
                
                String data = dia.toString();
                relatorio = new Relatorio(nomeCliente, corte, barba, sobran, quimica, data);
                listaRelatorio.add(relatorio);
            }

        } catch (SQLException ex) {
            System.out.println("Erro sql");
            //erro SQL
        } catch (Exception ex) {
            System.out.println("Erro geral");
            //erro geral
        }
        conecta.fechaConexao();

        return listaRelatorio;
    }

        public List<Relatorio> getDatasEspc(Calendar d, int filtro,Cliente cliente){
        List<Relatorio> listaRelatorio = new ArrayList<Relatorio>();
        Relatorio relatorio;
        // java.sql.Date data = new Date(d.getTimeInMillis());
        Conecta conecta = new Conecta();
        String sql = "SELECT * FROM barbearia.dias WHERE idCliente = ? ORDER BY dat;";

        if(filtro == 6){
             sql = "SELECT * FROM barbearia.dias WHERE idCliente = ? AND corte = 1 ORDER BY dat;";
        }
          if(filtro == 7){
             sql = "SELECT * FROM barbearia.dias WHERE idCliente = ? AND barba = 1 ORDER BY dat;";
        }

          if(filtro == 8){
             sql = "SELECT * FROM barbearia.dias WHERE idCliente = ? AND sobranchelas = 1 ORDER BY dat;";
        }

        conecta.iniciaConexao();
        ResultSet rs;
        QuimicaBD quimicaBD = new QuimicaBD();
        try {
            PreparedStatement pstm = conecta.getConexao().prepareStatement(sql);
            String dataS = "hoje";
            //pstm.setDate(1, data);
            int idC = cliente.getId();
            pstm.setInt(1, idC);
            rs = pstm.executeQuery();
            while (rs.next()) {

                java.sql.Date dia = rs.getDate("dat");
                int idCliente = rs.getInt("idCliente");
                cliente = clienteBD.getClienteEspecifico(idCliente);
                String nomeCliente = cliente.getNome();

                String corte = "Nao";
                String barba = "Nao";
                String sobran = "Nao";
                if(rs.getInt("corte") == 1){
                    corte = "Sim";
                }

                if(rs.getInt("barba") == 1){
                    barba = "Sim";
                }
                if(rs.getInt("sobranchelas") == 1){
                    sobran = "Sim";
                }

                System.out.println("O nome eh  "+nomeCliente+" ||  Cabelo  "+corte);

                int idQuimica = rs.getInt("idQuimica");
                Quimica q = quimicaBD.getQuimicaId(idQuimica);
                String quimica = q.getDescricao();

                String data = dia.toString();
                relatorio = new Relatorio(nomeCliente, corte, barba, sobran, quimica, data);
                listaRelatorio.add(relatorio);
            }

        } catch (SQLException ex) {
            System.out.println("Erro sql");
            //erro SQL
        } catch (Exception ex) {
            System.out.println("Erro geral");
            //erro geral
        }
        conecta.fechaConexao();

        return listaRelatorio;
    }

}
