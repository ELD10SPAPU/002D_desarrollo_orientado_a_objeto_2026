package com.hachimakidev.fitzone.model;

public abstract class PlanMembresia {

    private int id;
    private String nombreCliente;
    private int precioBase;
    private int duracionMeses;

    // Constructor con id (para SELECT desde Oracle y UPDATE)
    public PlanMembresia(int id, String nombreCliente, int precioBase, int duracionMeses) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.precioBase = precioBase;
        this.duracionMeses = duracionMeses;
    }

    // Constructor sin id (para INSERT en Oracle; el id lo genera IDENTITY)
    public PlanMembresia(String nombreCliente, int precioBase, int duracionMeses) {
        this.nombreCliente = nombreCliente;
        this.precioBase = precioBase;
        this.duracionMeses = duracionMeses;
    }

    public abstract String getTipo();

    public abstract int calcularPagoMensual();

    public abstract String getDetalle();

    // Getter auxiliar para enlazar la columna "Pago Mensual" en TableView
    public int getPagoMensual() {
        return calcularPagoMensual();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(int precioBase) {
        this.precioBase = precioBase;
    }

    public int getDuracionMeses() {
        return duracionMeses;
    }

    public void setDuracionMeses(int duracionMeses) {
        this.duracionMeses = duracionMeses;
    }
}

