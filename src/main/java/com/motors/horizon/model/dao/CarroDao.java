/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motors.horizon.model.dao;

import com.motors.horizon.connection.ConnectionFactory;
import com.motors.horizon.model.bean.Carro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 823214424
 */
public class CarroDao {
    public Carro[] obterCarros() throws SQLException {
        String sql = "select * from Carro;";
        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = ps.executeQuery();) {
                int totalDeCarros = rs.last() ? rs.getRow(): 0;
                Carro[] carros = new Carro[totalDeCarros];
                rs.beforeFirst();
                int contador = 0;
                while (rs.next()) {
                    int id = rs.getInt("id_carro");
                    String marca = rs.getString("marca_carro");
                    String modelo = rs.getString("modelo_carro");
                    int ano = rs.getInt("ano_carro");
                    String cambio = rs.getString("cambio_carro");
                    String potencia = rs.getString("potencia_carro");
                    String gasolina = rs.getString("gasolina_carro");
                    double preco = rs.getDouble("preco_carro");
                    String descricao = rs.getString("descricao_carro");
                    carros[contador++] = new Carro(id, marca, modelo, ano, cambio, potencia, gasolina, preco, descricao);
                }
                return carros;
            }
    }
}
