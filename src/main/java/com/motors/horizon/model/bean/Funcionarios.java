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
    private String nome_func;
    private String cargo_func;

    public Funcionarios() {
    }

    public Funcionarios(String nome_func, String cargo_func) {
        this.nome_func = nome_func;
        this.cargo_func = cargo_func;
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
