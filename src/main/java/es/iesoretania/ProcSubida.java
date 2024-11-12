package es.iesoretania;

import java.sql.*;

public class ProcSubida{
    public static void main (String[]args){
        try {
            Connection conexion = DriverManager.getConnection
                ("jdbc:mysql://localhost/practica", "root", "practica");
            
            //Recuperamos los parámetros del main
            String dep = args[0];       //departamento
            String subida = args[1];    //subida

            //Construimos orden de llamada
            String sql = "{ call subida_sal (?, ?) }";

            //Preparamos la llamada
            CallableStatement llamada = conexion.prepareCall(sql);

            //Damos valores a los argumentos
            llamada.setInt(1, Integer.parseInt(dep));
            llamada.setFloat(2, Float.parseFloat(subida));

            //Ejecutamos el procedimiento
            llamada.executeUpdate();
            System.out.println("Subida realizada...");

            llamada.close();
            conexion.close();
        }
        catch(SQLException e){e.printStackTrace();}
    }
}