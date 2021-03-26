package com.company.myapp;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Casa {
    private String dbName = "casa";
    private String dbUser = "root";
    private String dbPwd = "ange09lina08";

    public void buscarYMostrar(String sql){
        ConexionDB conexionDB = new ConexionDB(dbName,dbUser,dbPwd);
        ResultSet resultados = conexionDB.consultar(sql);
        try{
            mostrarResultados(resultados);
        }catch(SQLException e){
            System.out.println("No se encontraron resultados.");
        }finally {
            conexionDB.cerrar();
        }
    }

    private void mostrarResultados(ResultSet resultados) throws SQLException {
        if(resultados != null)
            while(resultados.next()) {
                System.out.println(resultados.getInt("id")+": " + resultados.getString("nombre")+
                        " - "+resultados.getString("responsable"));
            }
    }
    public void mostrarTareaPorResponsable(String responsable){
        buscarYMostrar("SELECT * FROM tareas WHERE responsable = '"+responsable+"'");
    }
    public void mostrarTareasPendientesPorResponsable(String responsable){
        buscarYMostrar("SELECT * FROM tareas WHERE estado = 'PENDIENTE' AND responsable = '"+responsable+"'");
    }
    public void mostrarTareaPorID(int id){
        buscarYMostrar("SELECT * FROM tareas WHERE id = "+id);
    }
    public void listarTareas() {
        buscarYMostrar("SELECT * FROM tareas;");
    }

    public boolean agregarTarea(Tarea tarea) {
        ConexionDB conexionDB = new ConexionDB(dbName,dbUser,dbPwd);
        String nombre = tarea.getNombre();
        String descripcion = tarea.getDescripcion();
        String responsable = tarea.getResponsable();
        String estado = tarea.getEstado().name();

        String sql = "INSERT INTO tareas (nombre, descripcion, responsable, estado) VALUES "+
                "('"+nombre+"','"+descripcion+"','"+responsable+"','"+estado+"');";
        boolean respuesta = false;
        try {
            respuesta = conexionDB.insertar(sql);
        }catch(SQLException e){
            System.out.println("No se pudo agregar la tarea.");
        }finally {
            conexionDB.cerrar();
        }
        return respuesta;
    }

    public void cambiarEstadoDeTarea(int idACambiar, int idEstado) {
        ConexionDB conexionDB = new ConexionDB(dbName,dbUser,dbPwd);
        String estado = Estado.values()[idEstado].name();
        String sql = "UPDATE tareas SET estado='"+estado+"' WHERE (id="+idACambiar+");";
        try {
            conexionDB.insertar(sql);
        }catch(SQLException e){
            System.out.println("No se pudo modificar la tarea.");
        }finally {
            conexionDB.cerrar();
        }
    }
}
