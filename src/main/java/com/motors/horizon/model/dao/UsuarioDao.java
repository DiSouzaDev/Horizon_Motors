/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motors.horizon.model.dao;

import com.motors.horizon.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author barbosad
 */
// Para adicionar novos usuarios - INCOMPLETO
public class UsuarioDao {

    public void createUsuario(String nome, String senha, String email, String cpf, String telefone) {
        Connection con = new ConnectionFactory().getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("insert into Usuario (nome_usuario, senha_usuario, tipo_usuario, email_usuario, cpf_usuario, telefone_usuario) values (?, ?, 'comum', ?, ?, ?)");
            stmt.setString(1, nome);
            stmt.setString(2, senha);
            stmt.setString(3, email);
            stmt.setString(4, cpf);
            stmt.setString(5, telefone);

            System.out.print(stmt);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Usuário Cadastrado com sucesso!");
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

    public boolean checkLogin(String login, String senha) {

        Connection con = new ConnectionFactory().getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM Usuario WHERE nome_usuario = ? AND senha_usuario = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro de conexão: ", e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return false;
    }
    
    public boolean checkLogin(String cpf) {

        Connection con = new ConnectionFactory().getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM Usuario WHERE cpf_usuario = ?");
            stmt.setString(1, cpf);

            rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro de conexão: ", e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return false;
    }

    public String checkTipoUsuario(String login, String senha) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement("SELECT tipo_usuario FROM Usuario WHERE nome_usuario = ? AND senha_usuario = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getString("tipo_usuario");
            } else {
                // Usuário não encontrado
                return null;
            }
        } catch (SQLException e) {
            // Trata a exceção de SQL
            throw new RuntimeException("Erro ao obter tipo de usuário: ", e);
        } finally {
            // Fecha a conexão, o PreparedStatement e o ResultSet
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }
}
