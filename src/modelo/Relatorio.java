/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author Skynet
 */
public class Relatorio {

    private String nmeCliente,corte,barba,sobran,data,quimica;

    public Relatorio() {
    }

    public Relatorio(String nmeCliente, String corte, String barba, String sobran,String quimica, String data) {
        this.nmeCliente = nmeCliente;
        this.corte = corte;
        this.barba = barba;
        this.sobran = sobran;
        this.quimica = quimica;
        this.data = data;
        
    }

    public String getBarba() {
        return barba;
    }

    public void setBarba(String barba) {
        this.barba = barba;
    }

    public String getCorte() {
        return corte;
    }

    public void setCorte(String corte) {
        this.corte = corte;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNmeCliente() {
        return nmeCliente;
    }

    public void setNmeCliente(String nmeCliente) {
        this.nmeCliente = nmeCliente;
    }

    public String getQuimica() {
        return quimica;
    }

    public void setQuimica(String quimica) {
        this.quimica = quimica;
    }

    public String getSobran() {
        return sobran;
    }

    public void setSobran(String sobran) {
        this.sobran = sobran;
    }
    
}
