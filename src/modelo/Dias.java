/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author Ricardo
 */
public class Dias {
    private Date data;
    private Cliente cliente;
    private int corte,barba,sobrancelhas;
    private Servico servico;
    private Bebidas bebida;
    private int qntBebida;
    private Produto produto;
    private int qntProduto;
    private Quimica quimica;
    private float total;

    public Dias() {
    }

    public Dias(Date data, Cliente cliente, int corte, int barba, int sobrancelhas,Quimica quimica,Bebidas bebida,int qntBebida, Produto produto,int qntProduto, float total) {
        this.data = data;
        this.cliente = cliente;
        this.corte = corte;
        this.barba = barba;
        this.sobrancelhas = sobrancelhas;
        this.servico = servico;
        this.quimica = quimica;
        this.bebida = bebida;
        this.qntBebida = qntBebida;
        this.produto = produto;
        this.qntProduto = qntProduto;
        this.total = total;
    }

    public Dias(Date d, Cliente cliente, int corte2, int barba2, int sobrancelhas2, Bebidas bebida, Produto produto1, float all) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getCorte() {
        return corte;
    }

    public void setCorte(int corte) {
        this.corte = corte;
    }

    public int getBarba() {
        return barba;
    }

    public void setBarba(int barba) {
        this.barba = barba;
    }

    public int getSobrancelhas() {
        return sobrancelhas;
    }

    public void setSobrancelhas(int sobrancelhas) {
        this.sobrancelhas = sobrancelhas;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public int getQntBebida() {
        return qntBebida;
    }

    public void setQntBebida(int qntBebida) {
        this.qntBebida = qntBebida;
    }

    public int getQntProduto() {
        return qntProduto;
    }

    public void setQntProduto(int qntProduto) {
        this.qntProduto = qntProduto;
    }
  
    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Bebidas getBebida() {
        return bebida;
    }

    public void setBebida(Bebidas bebida) {
        this.bebida = bebida;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Quimica getQuimica() {
        return quimica;
    }

    public void setQuimica(Quimica quimica) {
        this.quimica = quimica;
    }
    
    
    
}
