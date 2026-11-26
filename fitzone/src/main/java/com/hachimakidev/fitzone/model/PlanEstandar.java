package com.hachimakidev.fitzone.model;

public class PlanEstandar extends PlanMembresia {

    public static final int RECARGO_PISCINA = 12000;

    private int clasesSemanales;
    private boolean accesoPiscina;

    public PlanEstandar(int id, String nombreCliente, int precioBase, int duracionMeses,
                        int clasesSemanales, boolean accesoPiscina) {
        super(id, nombreCliente, precioBase, duracionMeses);
        this.clasesSemanales = clasesSemanales;
        this.accesoPiscina = accesoPiscina;
    }

    public PlanEstandar(String nombreCliente, int precioBase, int duracionMeses,
                        int clasesSemanales, boolean accesoPiscina) {
        super(nombreCliente, precioBase, duracionMeses);
        this.clasesSemanales = clasesSemanales;
        this.accesoPiscina = accesoPiscina;
    }

    @Override
    public String getTipo() {
        return "ESTANDAR";
    }

    @Override
    public int calcularPagoMensual() {
        return getPrecioBase() + (accesoPiscina ? RECARGO_PISCINA : 0);
    }

    @Override
    public String getDetalle() {
        return clasesSemanales + " clases/sem · Piscina: " + (accesoPiscina ? "Sí" : "No");
    }

    public int getClasesSemanales() {
        return clasesSemanales;
    }

    public void setClasesSemanales(int clasesSemanales) {
        this.clasesSemanales = clasesSemanales;
    }

    public boolean isAccesoPiscina() {
        return accesoPiscina;
    }

    public void setAccesoPiscina(boolean accesoPiscina) {
        this.accesoPiscina = accesoPiscina;
    }
}

