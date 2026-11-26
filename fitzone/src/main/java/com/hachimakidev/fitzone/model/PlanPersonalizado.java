package com.hachimakidev.fitzone.model;

public class PlanPersonalizado extends PlanMembresia {

    private int sesionesEntrenador;
    private int recargoEntrenador;

    public PlanPersonalizado(int id, String nombreCliente, int precioBase, int duracionMeses,
                             int sesionesEntrenador, int recargoEntrenador) {
        super(id, nombreCliente, precioBase, duracionMeses);
        this.sesionesEntrenador = sesionesEntrenador;
        this.recargoEntrenador = recargoEntrenador;
    }

    public PlanPersonalizado(String nombreCliente, int precioBase, int duracionMeses,
                             int sesionesEntrenador, int recargoEntrenador) {
        super(nombreCliente, precioBase, duracionMeses);
        this.sesionesEntrenador = sesionesEntrenador;
        this.recargoEntrenador = recargoEntrenador;
    }

    @Override
    public String getTipo() {
        return "PERSONALIZADO";
    }

    @Override
    public int calcularPagoMensual() {
        return getPrecioBase() + recargoEntrenador;
    }

    @Override
    public String getDetalle() {
        return sesionesEntrenador + " sesiones PT · Recargo $" + recargoEntrenador;
    }

    public int getSesionesEntrenador() {
        return sesionesEntrenador;
    }

    public void setSesionesEntrenador(int sesionesEntrenador) {
        this.sesionesEntrenador = sesionesEntrenador;
    }

    public int getRecargoEntrenador() {
        return recargoEntrenador;
    }

    public void setRecargoEntrenador(int recargoEntrenador) {
        this.recargoEntrenador = recargoEntrenador;
    }
}

