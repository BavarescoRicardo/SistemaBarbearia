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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import modelo.Bebidas;
import modelo.Cliente;
import modelo.Dias;
import modelo.Produto;
import modelo.Quimica;
import modelo.Servico;

/**
 *
 * @author Ricardo
 */
public class DiasBD {
    ClienteBD clienteBD = new ClienteBD();
    ServicoBD servicoBD = new ServicoBD();
    BebidasBd bebidaBd = new BebidasBd();
    ProdutoBd produtoBD = new ProdutoBd();
    
        Cliente cliente = clienteBD.getClienteEspecifico(2);
        Servico servico = servicoBD.getServicoId(2);
        Bebidas bebida = bebidaBd.getBebidaId(3);
        Produto produto = produtoBD.getProdutoId(3);

    public List<Dias> getTodos_do_dia(Date data){
        List<Dias> listaDias = new ArrayList<Dias>();
        Dias dia;
        Conecta conecta = new Conecta();
        String sql = "SELECT * FROM barbearia.dias WHERE dat = ?;";
        conecta.iniciaConexao();
        ResultSet rs;
        QuimicaBD quimicaBD = new QuimicaBD();
        try {
            PreparedStatement pstm = conecta.getConexao().prepareStatement(sql);
            pstm.setDate(1, data);
            rs = pstm.executeQuery();
            while (rs.next()) {
                
                
                int idCliente = rs.getInt("idCliente");
                Cliente cliente = clienteBD.getClienteEspecifico(idCliente);
                
                int corte = rs.getInt("corte");
                int barba = rs.getInt("barba");
                int sobrancelhas = rs.getInt("sobranchelas");
                
                int idBebida = rs.getInt("idBebidas");
                Bebidas bebida = bebidaBd.getBebidaId(idBebida);
                int qntBebida = rs.getInt("qntBebida");

                int idProduto = rs.getInt("idProdutos");
                Produto produto = produtoBD.getProdutoId(idProduto);
                int qntProduto = rs.getInt("qntProduto");

                int idQuimica = rs.getInt("idQuimica");
                Quimica quimica = quimicaBD.getQuimicaId(idQuimica);
                
                float total = rs.getFloat("total");
            
                dia = new Dias(data, cliente, corte,barba,sobrancelhas,quimica, bebida,qntBebida, produto,qntProduto, total);
                listaDias.add(dia);
            }
            
        } catch (SQLException ex) {
            System.out.println("Erro sql");
            //erro SQL
        } catch (Exception ex) {
            System.out.println("Erro geral");
            //erro geral
        }
        conecta.fechaConexao();
        
        return listaDias;
    }
 
    
    
    public void salvarDia(Dias dia){
        
        Conecta conecta = new Conecta();
        String sql = "INSERT INTO `barbearia`.`dias` (`dat`, `idCliente`, `corte`, `barba`, `sobranchelas`, `idBebidas`, `qntBebida`, `idProdutos`, `qntProduto`, `idQuimica`, `total`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?,?);";
        conecta.iniciaConexao();
        ResultSet rs;
         try {
            PreparedStatement pstm;
            pstm = conecta.getConexao().prepareStatement(sql);
            
            pstm.setDate(1,dia.getData());
            pstm.setInt(2, dia.getCliente().getId());
            pstm.setInt(3, dia.getCorte());
            pstm.setInt(4, dia.getBarba());
            pstm.setInt(5, dia.getSobrancelhas());
            System.out.println("Chega a esse ponto AA");
            pstm.setInt(6, dia.getBebida().getId());
            System.out.println("Chega a esse ponto AA1");
            pstm.setInt(7, dia.getQntBebida());
            pstm.setInt(8, dia.getProduto().getId());
            pstm.setInt(9, dia.getQntProduto());
            pstm.setInt(10, dia.getQuimica().getId());
            pstm.setFloat(11, dia.getTotal());
            
            System.out.println("Dias BD Executa ate aqui");
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
