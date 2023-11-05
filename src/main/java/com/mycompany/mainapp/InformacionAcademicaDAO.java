package com.mycompany.mainapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InformacionAcademicaDAO {
    private Connection connection;

    public InformacionAcademicaDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(InformacionAcademica informacionAcademica) {
        // Lógica para insertar nueva información académica en la base de datos.
    }

    public InformacionAcademica read(int id) {
        // Lógica para leer información académica de la base de datos y devolverla como un objeto InformacionAcademica.
    }

    public void update(InformacionAcademica informacionAcademica) {
        // Lógica para actualizar los datos de información académica en la base de datos.
    }

    public void delete(int id) {
        // Lógica para eliminar información académica de la base de datos.
    }
}
