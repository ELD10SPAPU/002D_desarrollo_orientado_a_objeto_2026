package com.hachimakidev.fitzone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import com.hachimakidev.fitzone.database.ConexionDB;
import com.hachimakidev.fitzone.model.PlanEstandar;
import com.hachimakidev.fitzone.model.PlanMembresia;
import com.hachimakidev.fitzone.model.PlanPersonalizado;

public class PlanDAO {
    public ArrayList<PlanMembresia> obtenerTodas(){
        ArrayList<PlanMembresia> lista = new ArrayList<>();
        String sql_select = "SELECT id, tipo, nombre_cliente, precio_base, duracion_meses, clases_semanales, acceso_piscina, sesiones_entrenador, recargo_entrenador FROM planes_membresia ORDER BY id ASC";
        try (Connection conn = ConexionDB.obetenerConexion()){
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String tipo = rs.getString("tipo");
                    String nombre_cliente = rs.getString("nombre_cliente");
                    int precio_base = rs.getInt("precio_base");
                    int duracion_meses = rs.getInt("duracion_meses");
                    if ("ESTANDAR".equalsIgnoreCase(tipo)){
                        int clases_semanales = rs.getInt("clases_semanales");
                        Boolean acceso_piscina = "S".equalsIgnoreCase(rs.getString("acceso_piscina"));
                        lista.add(new PlanEstandar(id,nombre_cliente, precio_base, duracion_meses, clases_semanales, acceso_piscina));
                    } else if ("PERSONALIZADO".equalsIgnoreCase(tipo)){
                        int sesiones_entrenador = rs.getInt("sesiones_entrenador");
                        int recargo_entrenador = rs.getInt("recargo_entrenador");
                        lista.add(new PlanPersonalizado(id,nombre_cliente, precio_base, duracion_meses, sesiones_entrenador, recargo_entrenador));
                    }  
                }
        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }

    public boolean guardar(PlanMembresia planMembresia){
        String sql_insert = "INSERT INTO planes_membresia (tipo, nombre_cliente, precio_base, duracion_meses, clases_semanales, acceso_piscina, sesiones_entrenador, recargo_entrenador) VALUES (?,?,?,?,?,?,?,?)";
        try (Connection conn = ConexionDB.obetenerConexion();
            PreparedStatement ps = conn.prepareStatement(sql_insert)){
                ps.setString(1, planMembresia.getTipo());
                ps.setString(2, planMembresia.getNombreCliente());
                ps.setInt(3, planMembresia.getPrecioBase());
                ps.setInt(4, planMembresia.getDuracionMeses());
                if (planMembresia instanceof PlanEstandar planestandar) {
                    ps.setInt(5, planestandar.getClasesSemanales());
                    ps.setString(6, planestandar.isAccesoPiscina() ? "S" : "N");
                    ps.setNull(7, Types.INTEGER);
                    ps.setNull(8, Types.INTEGER);
                } else if (planMembresia instanceof PlanPersonalizado planPersonalizado){
                    ps.setNull(5, Types.INTEGER);
                    ps.setNull(6, Types.CHAR);
                    ps.setInt(7, planPersonalizado.getSesionesEntrenador());
                    ps.setInt(8, planPersonalizado.getRecargoEntrenador());
                }
                int filasAfectadas = ps.executeUpdate();
                return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al guardar: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizar(PlanMembresia planmembresia){
        String sql_update = "UPDATE planes_membresia SET tipo = ?, nombre_cliente = ?, precio_base = ?, duracion_meses = ?, clases_semanales = ?, acceso_piscina = ?, sesiones_entrenador = ?, recargo_entrenador = ? WHERE id = ?";
        try (Connection conn = ConexionDB.obetenerConexion();
            PreparedStatement ps = conn.prepareStatement(sql_update)){
                ps.setString(1, planmembresia.getTipo());
                ps.setString(2, planmembresia.getNombreCliente());
                ps.setInt(3, planmembresia.getPrecioBase());
                ps.setInt(4, planmembresia.getDuracionMeses());
                if (planmembresia instanceof PlanEstandar planestandar) {
                    ps.setInt(5, planestandar.getClasesSemanales());
                    ps.setString(6, planestandar.isAccesoPiscina() ? "S" : "N");
                    ps.setNull(7, Types.INTEGER);
                    ps.setNull(8, Types.INTEGER);
                } else if (planmembresia instanceof PlanPersonalizado planpersonalizado){
                    ps.setNull(5, Types.INTEGER);
                    ps.setNull(6, Types.CHAR);
                    ps.setInt(7, planpersonalizado.getSesionesEntrenador());
                    ps.setInt(8, planpersonalizado.getRecargoEntrenador());
                }
                ps.setInt(9, planmembresia.getId());
                int filasAfectadas = ps.executeUpdate();
                return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id){
        String sql_delete = "DELETE FROM planes_membresia WHERE id = ?";
        try (Connection conn = ConexionDB.obetenerConexion();
            PreparedStatement ps = conn.prepareStatement(sql_delete)){
                ps.setInt(1, id);

                int filasAfectadas = ps.executeUpdate();
                return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }
}