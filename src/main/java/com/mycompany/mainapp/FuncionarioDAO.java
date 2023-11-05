/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mainapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    private Connection connection;

    public FuncionarioDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Funcionario funcionario) {
        // Implementa la lógica para insertar un nuevo funcionario en la base de datos.
        try {
            String sql = "INSERT INTO funcionarios (nombre, apellido, cargo) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, funcionario.getNombre());
            statement.setString(2, funcionario.getApellido());
            statement.setString(3, funcionario.getCargo());
            statement.executeUpdate();
        } catch (SQLException e) {
            // Maneja la excepción adecuadamente.
        }
    }

    public Funcionario read(int id) {
        // Implementa la lógica para leer un funcionario de la base de datos y devolverlo como un objeto Funcionario.
        Funcionario funcionario = null;
        try {
            String sql = "SELECT * FROM funcionarios WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                funcionario = new Funcionario();
                funcionario.setId(result.getInt("id"));
                funcionario.setNombre(result.getString("nombre"));
                funcionario.setApellido(result.getString("apellido"));
                funcionario.setCargo(result.getString("cargo"));
            }
        } catch (SQLException e) {
            // Maneja la excepción adecuadamente.
        }
        return funcionario;
    }

    public void update(Funcionario funcionario) {
        // Implementa la lógica para actualizar los datos de un funcionario en la base de datos.
        try {
            String sql = "UPDATE funcionarios SET nombre = ?, apellido = ?, cargo = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, funcionario.getNombre());
            statement.setString(2, funcionario.getApellido());
            statement.setString(3, funcionario.getCargo());
            statement.setInt(4, funcionario.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            // Maneja la excepción adecuadamente.
        }
    }

    public void delete(int id) {
        // Implementa la lógica para eliminar un funcionario de la base de datos.
        try {
            String sql = "DELETE FROM funcionarios WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            // Maneja la excepción adecuadamente.
        }
    }
}
