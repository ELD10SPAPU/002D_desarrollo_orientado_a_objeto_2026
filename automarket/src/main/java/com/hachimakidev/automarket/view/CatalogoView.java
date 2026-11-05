package com.hachimakidev.automarket.view;

// IMPORTS DE TU MODELO (Faltaba importar Vehiculo)
import com.hachimakidev.automarket.model.Automovil;
import com.hachimakidev.automarket.model.Motocicleta;
import com.hachimakidev.automarket.model.Vehiculo;

import com.hachimakidev.automarket.controller.VehiculoController;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CatalogoView {

    private TableView<Vehiculo> tabla_vehiculo;
    private VehiculoController vehiculoController;

    public CatalogoView() {
        vehiculoController = new VehiculoController();

        configurarTabla();
        cargarVehiculos();
    }

    private void configurarTabla() {

        tabla_vehiculo = new TableView<>();
        tabla_vehiculo.setFixedCellSize(110);
        TableColumn<Vehiculo, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colId.setMaxWidth(600);

        TableColumn<Vehiculo, String> colTipo = new TableColumn<>("Tipo");
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));

        TableColumn<Vehiculo, String> colModelo = new TableColumn<>("Marca");
        colModelo.setCellValueFactory(new PropertyValueFactory<>("marca"));

        TableColumn<Vehiculo, String> colMarca = new TableColumn<>("Modelo");
        colMarca.setCellValueFactory(new PropertyValueFactory<>("modelo"));

        TableColumn<Vehiculo, Integer> colPrecio = new TableColumn<>("Precio");
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        TableColumn<Vehiculo, String> colEspecificacion = new TableColumn<>("Especificación");
        colEspecificacion.setCellValueFactory(new PropertyValueFactory<>("especificacion"));

        TableColumn<Vehiculo, Boolean> colDisponible = new TableColumn<>("Disponible");
        colDisponible.setCellValueFactory(new PropertyValueFactory<>("disponible"));

        tabla_vehiculo.getColumns().add(colId);
        tabla_vehiculo.getColumns().add(colTipo);
        tabla_vehiculo.getColumns().add(colMarca);
        tabla_vehiculo.getColumns().add(colModelo);
        tabla_vehiculo.getColumns().add(colPrecio);
        tabla_vehiculo.getColumns().add(colEspecificacion);
        tabla_vehiculo.getColumns().add(colDisponible);
    }

    private void cargarVehiculos() {
        ObservableList<Vehiculo> datos = FXCollections.observableArrayList(vehiculoController.getVehiculos());
        tabla_vehiculo.setItems(datos);
    }

    public VBox catalogo() {
        Label lbl_titulo = new Label("AutoMarket — Catálogo de Automóviles y Motocicletas");
        lbl_titulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        VBox contenedor_tabla = new VBox(10, tabla_vehiculo);
        contenedor_tabla.setPadding(new Insets(20));
        contenedor_tabla.setStyle("-fx-border-color: #cbd5e1; -fx-border-radius: 6; -fx-background-color: #f8fafc;");

        Label lbl_tipo = new Label("Tipo: ");
        ComboBox<String> cmbTipo = new ComboBox<>();
        cmbTipo.getItems().addAll("Automovil", "Motocicleta");
        cmbTipo.setValue("Automovil");

        Label lbl_marca = new Label("Marca: ");
        TextField txf_marca = new TextField();

        Label lbl_modelo = new Label("Modelo: ");
        TextField txf_modelo = new TextField();

        Label lbl_precio = new Label("Precio: ");
        TextField txf_precio = new TextField();

        Label lbl_atributo1 = new Label("Atributo 1 (Puertas / Cilindrada cc):");
        TextField txf_atributo1 = new TextField();

        Label lbl_atributo2 = new Label("Atributo 2 (Transmisión / Vel. Máx)");
        TextField txf_atributo2 = new TextField();

        Button btn_agregar_dispositivo = new Button("Agregar Vehículo");
        btn_agregar_dispositivo.setOnAction(e -> {
                String tipo = cmbTipo.getValue();
                String marca = txf_marca.getText().trim();
                String modelo = txf_modelo.getText().trim();
                int precio = Integer.parseInt(txf_precio.getText().trim());
                int nuevoId = vehiculoController.getVehiculos().size() + 1;
                boolean disponible = true;

                Vehiculo nuevoVehiculo = null;

                if ("Automovil".equalsIgnoreCase(tipo)) {
                    int puertas = Integer.parseInt(txf_atributo1.getText().trim());
                    String transmision = txf_atributo2.getText().trim();
                    nuevoVehiculo = new Automovil(nuevoId, marca, modelo, precio, disponible, puertas, transmision);
                } else if ("Motocicleta".equalsIgnoreCase(tipo)) {
                    int cilindradaCc = Integer.parseInt(txf_atributo1.getText().trim());
                    int velocidadMaxKmh = Integer.parseInt(txf_atributo2.getText().trim());
                    nuevoVehiculo = new Motocicleta(nuevoId, marca, modelo, precio, disponible, cilindradaCc, velocidadMaxKmh);
                }
            
                if (nuevoVehiculo != null) {
                    vehiculoController.AgregarVehiculo(nuevoVehiculo);
                    cargarVehiculos();
                    txf_marca.clear();
                    txf_modelo.clear();
                    txf_precio.clear();
                    txf_atributo1.clear();
                    txf_atributo2.clear();
                }});

        HBox HBox_tipo = new HBox(lbl_tipo, cmbTipo);
        HBox HBox_marca = new HBox(lbl_marca, txf_marca);
        HBox HBox_modelo = new HBox(lbl_modelo, txf_modelo);
        HBox HBox_precio = new HBox(lbl_precio, txf_precio);
        HBox Hbox_atributo1 = new HBox(lbl_atributo1, txf_atributo1);
        HBox Hbox_atributo2 = new HBox(lbl_atributo2, txf_atributo2);

        VBox VBox_form = new VBox(HBox_tipo, HBox_marca, HBox_modelo, HBox_precio, Hbox_atributo1, Hbox_atributo2,
                btn_agregar_dispositivo);

        HBox fila_formulario = new HBox(10, VBox_form);
        VBox contenedor_formulario = new VBox(10, fila_formulario);
        contenedor_formulario.setPadding(new Insets(16));
        contenedor_formulario
                .setStyle("-fx-border-color: #cbd5e1; -fx-border-radius: 6; -fx-background-color: #ffffff;");

        VBox layout_principal = new VBox(16, lbl_titulo, contenedor_tabla, contenedor_formulario);
        layout_principal.setPadding(new Insets(20));

        return layout_principal;
    }
}