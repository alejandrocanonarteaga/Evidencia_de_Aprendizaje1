/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mainapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        // Establece la conexión a la base de datos
        Connection connection = null;
        try {
            String jdbcUrl = "jdbc:mysql://localhost:3306/tu_base_de_datos";
            String username = "tu_usuario";
            String password = "tu_contraseña";
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Conexión a la base de datos exitosa.");
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            return;
        }

        // Crea instancias de los DAO
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO(connection);
        GrupoFamiliarDAO grupoFamiliarDAO = new GrupoFamiliarDAO(connection);
        InformacionAcademicaDAO informacionAcademicaDAO = new InformacionAcademicaDAO(connection);

        // Ejemplo de operaciones CRUD

        // Crear un nuevo funcionario
        Funcionario nuevoFuncionario = new Funcionario("Nombre", "Apellido", "Cargo");
        funcionarioDAO.create(nuevoFuncionario);

        // Leer información de un funcionario
        Funcionario funcionarioLeido = funcionarioDAO.read(1);
        System.out.println("Información del funcionario leído: " + funcionarioLeido);

        // Actualizar información de un funcionario
        funcionarioLeido.setCargo("Nuevo Cargo");
        funcionarioDAO.update(funcionarioLeido);

        // Eliminar un funcionario
        funcionarioDAO.delete(funcionarioLeido.getId());

        // Cerrar la conexión a la base de datos
        try {
            connection.close();
            System.out.println("Conexión a la base de datos cerrada.");
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión a la base de datos: " + e.getMessage());
        }
    }
}
