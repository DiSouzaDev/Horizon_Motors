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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
    
    public void createCarro(String marca, String modelo, int ano, String cambio, String potencia, String gasolina, Double preco, String descricao){
        Connection con = new ConnectionFactory().getConnection();

        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("insert into Carro (marca_carro, modelo_carro, ano_carro, cambio_carro, potencia_carro, gasolina_carro, preco_carro, descricao_carro) values (?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, marca);
            stmt.setString(2, modelo);
            stmt.setInt(3, ano);
            stmt.setString(4, cambio);
            stmt.setString(5, potencia);
            stmt.setString(6, gasolina);
            stmt.setDouble(7, preco);
            stmt.setString(8, descricao);
            
            System.out.print(stmt);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Carro Cadastrado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Algo saiu errado, tente novamente!");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
