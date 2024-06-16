/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motors.horizon.model.bean;

import java.sql.Date;

/**
 *
 * @author 823214424
 */
public class Agendamento {
    private int id_agendamento;
    private Date data_agendamento;
    private double hora_agendamento;

    public Agendamento() {
    }

    public Agendamento(int id_agendamento, Date data_agendamento, double hora_agendamento) {
        this.id_agendamento = id_agendamento;
        this.data_agendamento = data_agendamento;
        this.hora_agendamento = hora_agendamento;
    }

    public int getId_agendamento() {
        return id_agendamento;
    }

    public void setId_agendamento(int id_agendamento) {
        this.id_agendamento = id_agendamento;
    }

    public Date getData_agendamento() {
        return data_agendamento;
    }

    public void setData_agendamento(Date data_agendamento) {
        this.data_agendamento = data_agendamento;
    }

    public double getHora_agendamento() {
        return hora_agendamento;
    }

    public void setHora_agendamento(double hora_agendamento) {
        this.hora_agendamento = hora_agendamento;
    }

    
}
