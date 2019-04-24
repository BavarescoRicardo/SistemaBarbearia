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
public class Faturamento {
    
    private Date data;
    private int qntCortes,qntBarbas,qntSobrancelhas,qntQuimica;
    private float valorCortes,valorBarbas,valorSobrancelhas,valorBebidas,valorProdutos,totalBruto,valorQuimica,custo,totalLiquido;

    public Faturamento() {
    }

    public Faturamento(Date data, int qntCortes, int qntBarbas, int qntSobrancelhas,int qntQuimica, float valorCortes, float valorBarbas, float valorSobrancelhas,float valorQuimica,float custo, float valorBebidas, float valorProdutos, float totalBruto, float totalLiquido) {
        this.data = data;
        this.qntCortes = qntCortes;
        this.qntBarbas = qntBarbas;
        this.qntSobrancelhas = qntSobrancelhas;
        this.qntQuimica = qntQuimica;
        this.valorCortes = valorCortes;
        this.valorBarbas = valorBarbas;
        this.valorSobrancelhas = valorSobrancelhas;
        this.valorQuimica = valorQuimica;
        this.valorBebidas = valorBebidas;
        this.valorProdutos = valorProdutos;
        this.totalBruto = totalBruto;
        this.custo = custo;
        this.totalLiquido = totalLiquido;
    }
    
    public Date getData() {
        return data;
    }

    public float getCusto() {
        return custo;
    }

    public int getQntQuimica() {
        return qntQuimica;
    }

    public void setQntQuimica(int qntQuimica) {
        this.qntQuimica = qntQuimica;
    }

    public float getValorQuimica() {
        return valorQuimica;
    }

    public void setValorQuimica(float valorQuimica) {
        this.valorQuimica = valorQuimica;
    }
    

    public void setCusto(float custo) {
        this.custo = custo;
    }
    
    public void setData(Date data) {
        this.data = data;
    }

    public int getQntCortes() {
        return qntCortes;
    }

    public void setQntCortes(int qntCortes) {
        this.qntCortes = qntCortes;
    }

    public int getQntBarbas() {
        return qntBarbas;
    }

    public void setQntBarbas(int qntBarbas) {
        this.qntBarbas = qntBarbas;
    }

    public int getQntSobrancelhas() {
        return qntSobrancelhas;
    }

    public void setQntSobrancelhas(int qntSobrancelhas) {
        this.qntSobrancelhas = qntSobrancelhas;
    }

    public float getValorCortes() {
        return valorCortes;
    }

    public void setValorCortes(float valorCortes) {
        this.valorCortes = valorCortes;
    }

    public float getValorBarbas() {
        return valorBarbas;
    }

    public void setValorBarbas(float valorBarbas) {
        this.valorBarbas = valorBarbas;
    }

    public float getValorSobrancelhas() {
        return valorSobrancelhas;
    }

    public void setValorSobrancelhas(float valorSobrancelhas) {
        this.valorSobrancelhas = valorSobrancelhas;
    }

    public float getValorBebidas() {
        return valorBebidas;
    }

    public void setValorBebidas(float valorBebidas) {
        this.valorBebidas = valorBebidas;
    }

    public float getValorProdutos() {
        return valorProdutos;
    }

    public void setValorProdutos(float valorProdutos) {
        this.valorProdutos = valorProdutos;
    }

    public float getTotalBruto() {
        return totalBruto;
    }

    public void setTotalBruto(float totalBruto) {
        this.totalBruto = totalBruto;
    }

    public float getTotalLiquido() {
        return totalLiquido;
    }

    public void setTotalLiquido(float totalLiquido) {
        this.totalLiquido = totalLiquido;
    }

    
    
    
}
