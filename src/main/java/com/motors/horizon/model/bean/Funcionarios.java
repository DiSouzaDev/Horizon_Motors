/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motors.horizon.model.bean;

/**
 *
 * @author 823214424
 */
public class Funcionarios {
    private int id_func;
    private String nome_func;
    private String cargo_func;

    public Funcionarios() {
    }

    public Funcionarios(int id_func, String nome_func, String cargo_func) {
        this.id_func = id_func;
        this.nome_func = nome_func;
        this.cargo_func = cargo_func;
    }

    public int getId_func() {
        return id_func;
    }

    public void setId_func(int id_func) {
        this.id_func = id_func;
    }

    public String getNome_func() {
        return nome_func;
    }

    public void setNome_func(String nome_func) {
        this.nome_func = nome_func;
    }

    public String getCargo_func() {
        return cargo_func;
    }

    public void setCargo_func(String cargo_func) {
        this.cargo_func = cargo_func;
    }

    
}
