package com.hachimakidev.fitzone.controller;

import java.util.ArrayList;

import com.hachimakidev.fitzone.dao.PlanDAO;
import com.hachimakidev.fitzone.model.PlanEstandar;
import com.hachimakidev.fitzone.model.PlanMembresia;
import com.hachimakidev.fitzone.model.PlanPersonalizado;

public class PlanController {
    private PlanDAO PlanDAO;

    public PlanController(){
        this.PlanDAO = new PlanDAO();
    }

    public boolean registrarPlan(String tipo, String nombre_cliente, int precio_base, int duracion_meses, int clases_semanales, Boolean acceso_piscina, int sesiones_entrenador, int recargo_entrenador){
        if (tipo == null || tipo.isBlank() || nombre_cliente == null || nombre_cliente.isBlank()) {
            return false;
        }
        try {
            if ("ESTANDAR".equalsIgnoreCase(tipo)) {
                PlanEstandar planEstandar = new PlanEstandar(nombre_cliente, precio_base, duracion_meses, clases_semanales, acceso_piscina);
                return PlanDAO.guardar(planEstandar);
            } else if ("PERSONALIZADO".equalsIgnoreCase(tipo)){
                PlanPersonalizado planPersonalizado = new PlanPersonalizado(nombre_cliente, precio_base, duracion_meses, sesiones_entrenador, recargo_entrenador);
                return PlanDAO.guardar(planPersonalizado);
            } else{
                return false;
            }
        } catch (Exception e) {
            System.out.println("Datos invalidos: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarPlan(int id,String tipo, String nombre_cliente, int precio_base, int duracion_meses, int clases_semanales, Boolean acceso_piscina, int sesiones_entrenador, int recargo_entrenador){
        if (tipo == null || tipo.isBlank() || nombre_cliente == null || nombre_cliente.isBlank()) {
            return false;
        }
        try {
            if ("ESTANDAR".equalsIgnoreCase(tipo)) {
                PlanEstandar planEstandar = new PlanEstandar(id, nombre_cliente, precio_base, duracion_meses, clases_semanales, acceso_piscina);
                return PlanDAO.actualizar(planEstandar);
            } else if ("PERSONALIZADO".equalsIgnoreCase(tipo)){
                PlanPersonalizado planPersonalizado = new PlanPersonalizado(id, nombre_cliente, precio_base, duracion_meses, sesiones_entrenador, recargo_entrenador);
                return PlanDAO.actualizar(planPersonalizado);
            } else{
                return false;
            }
        } catch (Exception e) {
            System.out.println("Datos invalidos: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<PlanMembresia> obtenerPlan(){
        return PlanDAO.obtenerTodas();
    }

    public boolean eliminarPlan (int id){
        if (id <= 0) {
            return false;
        }
        return PlanDAO.eliminar(id);
    }
}