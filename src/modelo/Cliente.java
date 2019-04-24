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
public class Cliente {
    private int id;
    private String nome,aniversario,apelido,contato;
    private Date ultimoCorteSQL;

    public Cliente() {
    }
    
      public Cliente(String nome) {
        this.nome = nome;       
    }

    public Cliente(String nome, String aniversario, String apelido, String contato, Date ultimoCorteSQL) {
        this.nome = nome;
        this.aniversario = aniversario;
        this.apelido = apelido;
        this.contato = contato;
        this.ultimoCorteSQL = ultimoCorteSQL;
    }

    public int getId() {
        return id;
    }

    public String getAniversario() {
        return aniversario;
    }

    public void setAniversario(String aniversario) {
        this.aniversario = aniversario;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }



    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getUltimoCorteSQL() {
        return ultimoCorteSQL;
    }

    public void setUltimoCorteSQL(Date ultimoCorteSQL) {
        this.ultimoCorteSQL = ultimoCorteSQL;
    }

    
    
    
    
}
