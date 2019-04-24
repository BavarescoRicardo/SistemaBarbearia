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
import modelo.Faturamento;

/**
 *
 * @author Ricardo
 */
public class FaturamentoBd {

    public List<Faturamento> getFaturamento(int mes){
        List<Faturamento> listaFaturamento = new ArrayList<Faturamento>();
        Faturamento faturamento;


        Calendar ini = Calendar.getInstance();
        ini.set(Calendar.DAY_OF_MONTH,1);
        ini.set(Calendar.MONTH, mes);
        java.sql.Date inicio = new Date(ini.getTimeInMillis());

        Calendar fi = Calendar.getInstance();
        fi.set(Calendar.DAY_OF_MONTH,31);
       fi.set(Calendar.MONTH, mes);
        java.sql.Date fim = new Date(fi.getTimeInMillis());


        Conecta conecta = new Conecta();
        String sql = "SELECT * FROM barbearia.faturamento WHERE (dataFaturamento) BETWEEN ? AND ?;";
        conecta.iniciaConexao();
        ResultSet rs;
       // System.out.println("A data inicial eh  "+inicial);
        try {
            PreparedStatement pstm = conecta.getConexao().prepareStatement(sql);
            pstm.setDate(1, inicio);
            pstm.setDate(2, fim);
            rs = pstm.executeQuery();
            while (rs.next()) {
               Date dat = rs.getDate("dataFaturamento");
               int qntCortes = rs.getInt("cortes");
               float valorCortes = rs.getFloat("valorCortes");
               int qntBarbas = rs.getInt("barba");
               float valorBarbas = rs.getFloat("valorBarba");
               int qntSobrancelhas = rs.getInt("sobrancelhas");
               float valorSobrancelhas = rs.getFloat("valorSobrancelhas");
               int qntQuimica = rs.getInt("quimica");
               float valorQuimica = rs.getFloat("valorQuimica");
               float gastos = rs.getFloat("custo");
               float valorBebidas = rs.getFloat("valorBebidas");
               float valorProdutos = rs.getFloat("valorProdutos");
               float totalBruto = rs.getFloat("totalBruto");
               float totalLiquido = rs.getFloat("totalLiquido"); 
              
               faturamento = new Faturamento(dat, qntCortes, qntBarbas, qntSobrancelhas,qntQuimica, valorCortes, valorBarbas, valorSobrancelhas,valorQuimica, gastos, valorBebidas, valorProdutos, totalBruto, totalLiquido);
               listaFaturamento.add(faturamento);
                System.out.println("Total eh  "+totalBruto);
            }
        } catch (SQLException ex) {
            System.out.println("Erro sql");
            //erro SQL
        } catch (Exception ex) {
            System.out.println("Erro geral");
            //erro geral
        }
        conecta.fechaConexao();
        
        return listaFaturamento;
    }
    
    public void salvaFaturamento(Faturamento faturamento){
        Conecta conecta = new Conecta();
        String sql = "INSERT INTO `barbearia`.`faturamento` (`dataFaturamento`, `cortes`, `valorCortes`, `barba`, `valorBarba`, `sobrancelhas`, `valorSobrancelhas`, `quimica`, `valorQuimica`, `custo`, `valorBebidas`, `valorProdutos`, `totalBruto`, `totalLiquido`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        String d = null;
        d = faturamento.getData().toString();
        DateFormat forma = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date data = null;
        try {
            data = new java.sql.Date(forma.parse(d).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(FaturamentoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        //faturamento.getData();
        conecta.iniciaConexao();
        ResultSet rs;

        try {
            PreparedStatement pstm;
            pstm = conecta.getConexao().prepareStatement(sql);
            
            pstm.setDate(1,data);
            pstm.setInt(2,faturamento.getQntCortes());
            pstm.setFloat(3,faturamento.getValorCortes());
            pstm.setInt(4,faturamento.getQntBarbas());
            pstm.setFloat(5, faturamento.getValorBarbas());
            pstm.setInt(6,faturamento.getQntSobrancelhas());
            pstm.setFloat(7,faturamento.getValorSobrancelhas());
            pstm.setInt(8, faturamento.getQntQuimica());
            pstm.setFloat(9, faturamento.getValorQuimica());
            pstm.setFloat(10, faturamento.getCusto());
            pstm.setFloat(11,faturamento.getValorBebidas());
            pstm.setFloat(12,faturamento.getValorProdutos());
            pstm.setFloat(13,faturamento.getTotalBruto());
            pstm.setFloat(14,faturamento.getTotalLiquido());
            
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