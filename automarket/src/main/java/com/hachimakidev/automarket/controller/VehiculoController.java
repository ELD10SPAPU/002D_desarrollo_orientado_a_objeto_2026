package com.hachimakidev.automarket.controller;

import java.util.ArrayList;

import com.hachimakidev.automarket.model.Vehiculo;
import com.hachimakidev.automarket.model.VehiculoManager;

public class VehiculoController {

    private VehiculoManager vehiculoManager;

    public VehiculoController(){
        vehiculoManager = new VehiculoManager();
    }

    public ArrayList<Vehiculo> getVehiculos(){
        return vehiculoManager.getVehiculos();
    }

    public void AgregarVehiculo(Vehiculo vehiculo){
        vehiculoManager.getVehiculos().add(vehiculo);
    }
}
