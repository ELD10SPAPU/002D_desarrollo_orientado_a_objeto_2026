package com.hachimakidev.automarket.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class VehiculoManager {

    private ArrayList<Vehiculo> lista_Vehiculo = new ArrayList<>();

    public VehiculoManager(){
        cargarDatos();
    }

    public void cargarDatos(){
        InputStream cadena = getClass().getResourceAsStream("/vehiculos.json");
        if (cadena == null){
            throw new IllegalStateException("No se encontro vehiculo.json en resources");
        }
        try (InputStreamReader reader = new InputStreamReader(cadena)){

            Gson gson = new Gson();

            JsonObject[] vehiculos = gson.fromJson(reader, JsonObject[].class);

            for (JsonObject vehiculo : vehiculos){
                String tipo = vehiculo.get("tipo").getAsString();
                int id = vehiculo.get("id").getAsInt();
                String marca = vehiculo.get("marca").getAsString();
                String modelo = vehiculo.get("modelo").getAsString();
                int precio = vehiculo.get("precio").getAsInt();
                Boolean dipsonible = vehiculo.get("disponible").getAsBoolean();
                switch (tipo) {
                    case "motocicleta":
                        int cilindradaCc = vehiculo.get("cilindradaCc").getAsInt();
                        int velocidadMaxKmh = vehiculo.get("velocidadMaxKmh").getAsInt();
                        Motocicleta motocicleta = new Motocicleta(id,marca,modelo,precio,dipsonible,cilindradaCc,velocidadMaxKmh);
                        lista_Vehiculo.add(motocicleta);
                        break;
                    case "automovil":
                        int puertas = vehiculo.get("puertas").getAsInt();
                        String transmision = vehiculo.get("transmision").getAsString();
                        Automovil automovil = new Automovil(id,marca,modelo,precio,dipsonible,puertas,transmision);
                        lista_Vehiculo.add(automovil);
                        break;
                    default:
                        System.out.println("Tipo de dispositivo desconocido: " + tipo);
                        break;
                }
            }
        } catch (java.io.IOException e ){
            throw new IllegalStateException("No se pudo leer vehiculo.json",e);
        }
    }
    public ArrayList<Vehiculo> getVehiculos(){
        return lista_Vehiculo;
    }
    
}
