/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wbs.entity;

import java.math.BigInteger;

/**
 *
 * @author Willian Bandeira
 */
public class Usuario {

    private BigInteger id;
    private String nome;
    private String fone;
    private String login;
    private String senha;
    private String tipo;
    private String celular;

    public Usuario() {

    }

    public Usuario(BigInteger id, String nome, String fone, String login, String senha, String tipo, String celular) {
        this.id = id;
        this.nome = nome;
        this.fone = fone;
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
        this.celular = celular;
    }
     public Usuario(String nome, String fone, String login, String senha, String tipo, String celular) {
        
        this.nome = nome;
        this.fone = fone;
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
        this.celular = celular;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCelular() {
        return this.celular;
    }

}
