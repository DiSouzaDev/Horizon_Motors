/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motors.horizon.model.bean;

/**
 *
 * @author 823214424
 */
public class Carro {

    private int id_carro;
    private String marca_carro;
    private String modelo_carro;
    private int ano_carro;
    private String cambio_carro;
    private String potencia_carro;
    private String gasolina_carro;
    private double preco_carro;
    private String descricao_carro;

    public Carro() {
    }

    public Carro(int id_carro, String marca_carro, String modelo_carro, int ano_carro, String cambio_carro, String potencia_carro, String gasolina_carro, double preco_carro, String descricao_carro) {
        this.id_carro = id_carro;
        this.marca_carro = marca_carro;
        this.modelo_carro = modelo_carro;
        this.ano_carro = ano_carro;
        this.cambio_carro = cambio_carro;
        this.potencia_carro = potencia_carro;
        this.gasolina_carro = gasolina_carro;
        this.preco_carro = preco_carro;
        this.descricao_carro = descricao_carro;
    }

    public int getId_carro() {
        return id_carro;
    }

    public void setId_carro(int id_carro) {
        this.id_carro = id_carro;
    }

    public String getMarca_carro() {
        return marca_carro;
    }

    public void setMarca_carro(String marca_carro) {
        this.marca_carro = marca_carro;
    }

    public String getModelo_carro() {
        return modelo_carro;
    }

    public void setModelo_carro(String modelo_carro) {
        this.modelo_carro = modelo_carro;
    }

    public int getAno_carro() {
        return ano_carro;
    }

    public void setAno_carro(int ano_carro) {
        this.ano_carro = ano_carro;
    }

    public String getCambio_carro() {
        return cambio_carro;
    }

    public void setCambio_carro(String cambio_carro) {
        this.cambio_carro = cambio_carro;
    }

    public String getPotencia_carro() {
        return potencia_carro;
    }

    public void setPotencia_carro(String potencia_carro) {
        this.potencia_carro = potencia_carro;
    }

    public String getGasolina_carro() {
        return gasolina_carro;
    }

    public void setGasolina_carro(String gasolina_carro) {
        this.gasolina_carro = gasolina_carro;
    }

    public double getPreco_carro() {
        return preco_carro;
    }

    public void setPreco_carro(double preco_carro) {
        this.preco_carro = preco_carro;
    }

    public String getDescricao_carro() {
        return descricao_carro;
    }

    public void setDescricao_carro(String descricao_carro) {
        this.descricao_carro = descricao_carro;
    }

    @Override
    public String toString() {
        return marca_carro + " " + modelo_carro;
    }
    
    public String getCambio(){
        return cambio_carro;
    }
}
