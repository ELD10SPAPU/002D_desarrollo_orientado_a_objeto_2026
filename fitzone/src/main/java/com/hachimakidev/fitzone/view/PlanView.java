package com.hachimakidev.fitzone.view;

import com.hachimakidev.fitzone.controller.PlanController;
import com.hachimakidev.fitzone.model.PlanEstandar;
import com.hachimakidev.fitzone.model.PlanMembresia;
import com.hachimakidev.fitzone.model.PlanPersonalizado;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class PlanView {

    private PlanController controller;
    private TableView<PlanMembresia> tablaPlanes;

    private ComboBox<String> cmbTipo;
    private TextField txtNombreCliente;
    private TextField txtPrecioBase;
    private TextField txtDuracionMeses;

    // Controles exclusivos de PlanEstandar
    private VBox panelEstandar;
    private TextField txtClasesSemanales;
    private CheckBox chkAccesoPiscina;

    // Controles exclusivos de PlanPersonalizado
    private VBox panelPersonalizado;
    private TextField txtSesionesEntrenador;
    private TextField txtRecargoEntrenador;

    private Label lblEstado;

    // Guarda el ID de la fila seleccionada en la tabla (-1 indica sin selección)
    private int idSeleccionado = -1;

    public PlanView() {
        this.controller = new PlanController();
    }

    public void setController(PlanController controller) {
        this.controller = controller;
    }

    public Scene crearEscena() {
        VBox panelFormulario = crearPanelFormulario();
        VBox panelTabla = crearPanelTabla();

        HBox.setHgrow(panelTabla, Priority.ALWAYS);

        HBox raiz = new HBox(20, panelFormulario, panelTabla);
        raiz.setPadding(new Insets(20));

        cargarDatosEnTabla();

        return new Scene(raiz, 1020, 560);
    }

    private VBox crearPanelFormulario() {
        Label lblTitulo = new Label("FitZone — Planes de Membresía");
        lblTitulo.setStyle("-fx-font-size: 17px; -fx-font-weight: bold;");

        cmbTipo = new ComboBox<>();
        cmbTipo.getItems().addAll("ESTANDAR", "PERSONALIZADO");
        cmbTipo.setValue("ESTANDAR");
        cmbTipo.setMaxWidth(Double.MAX_VALUE);

        txtNombreCliente = new TextField();
        txtNombreCliente.setPromptText("Ej: Camila Rojas");

        txtPrecioBase = new TextField();
        txtPrecioBase.setPromptText("Ej: 32000");

        txtDuracionMeses = new TextField();
        txtDuracionMeses.setPromptText("Ej: 6");

        // Subpanel ESTANDAR
        txtClasesSemanales = new TextField();
        txtClasesSemanales.setPromptText("Ej: 4");

        chkAccesoPiscina = new CheckBox("Incluye acceso a piscina (+$12.000)");

        panelEstandar = new VBox(6,
                new Label("Clases semanales:"), txtClasesSemanales,
                chkAccesoPiscina);

        // Subpanel PERSONALIZADO
        txtSesionesEntrenador = new TextField();
        txtSesionesEntrenador.setPromptText("Ej: 8");

        txtRecargoEntrenador = new TextField();
        txtRecargoEntrenador.setPromptText("Ej: 25000");

        panelPersonalizado = new VBox(6,
                new Label("Sesiones con entrenador:"), txtSesionesEntrenador,
                new Label("Recargo entrenador ($):"), txtRecargoEntrenador);

        actualizarVisibilidadTipo();
        cmbTipo.setOnAction(e -> actualizarVisibilidadTipo());

        Button btnGuardar = new Button("Guardar");
        Button btnActualizar = new Button("Actualizar");
        Button btnEliminar = new Button("Eliminar");
        Button btnLimpiar = new Button("Limpiar");

        btnGuardar.setOnAction(e -> accionGuardar());
        btnActualizar.setOnAction(e -> accionActualizar());
        btnEliminar.setOnAction(e -> accionEliminar());
        btnLimpiar.setOnAction(e -> limpiarFormulario());

        HBox filaBotones = new HBox(8, btnGuardar, btnActualizar, btnEliminar, btnLimpiar);

        lblEstado = new Label("Listo.");
        lblEstado.setWrapText(true);

        VBox panel = new VBox(8,
                lblTitulo,
                new Label("Tipo de plan:"), cmbTipo,
                new Label("Nombre cliente:"), txtNombreCliente,
                new Label("Precio base ($):"), txtPrecioBase,
                new Label("Duración (meses):"), txtDuracionMeses,
                panelEstandar,
                panelPersonalizado,
                filaBotones,
                lblEstado);
        panel.setPrefWidth(330);
        return panel;
    }

    private VBox crearPanelTabla() {
        Label lblSubtitulo = new Label("Membresías Registradas en Oracle");
        lblSubtitulo.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        tablaPlanes = new TableView<>();

        TableColumn<PlanMembresia, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colId.setPrefWidth(50);

        TableColumn<PlanMembresia, String> colTipo = new TableColumn<>("Tipo");
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colTipo.setPrefWidth(115);

        TableColumn<PlanMembresia, String> colCliente = new TableColumn<>("Cliente");
        colCliente.setCellValueFactory(new PropertyValueFactory<>("nombreCliente"));
        colCliente.setPrefWidth(150);

        TableColumn<PlanMembresia, Integer> colDuracion = new TableColumn<>("Meses");
        colDuracion.setCellValueFactory(new PropertyValueFactory<>("duracionMeses"));
        colDuracion.setPrefWidth(65);

        TableColumn<PlanMembresia, String> colDetalle = new TableColumn<>("Detalle");
        colDetalle.setCellValueFactory(new PropertyValueFactory<>("detalle"));
        colDetalle.setPrefWidth(210);

        TableColumn<PlanMembresia, Integer> colPago = new TableColumn<>("Pago Mensual ($)");
        colPago.setCellValueFactory(new PropertyValueFactory<>("pagoMensual"));
        colPago.setPrefWidth(120);

        tablaPlanes.getColumns().add(colId);
        tablaPlanes.getColumns().add(colTipo);
        tablaPlanes.getColumns().add(colCliente);
        tablaPlanes.getColumns().add(colDuracion);
        tablaPlanes.getColumns().add(colDetalle);
        tablaPlanes.getColumns().add(colPago);

        tablaPlanes.getSelectionModel().selectedItemProperty().addListener((obs, anterior, seleccionado) -> {
            if (seleccionado != null) {
                idSeleccionado = seleccionado.getId();
                cmbTipo.setValue(seleccionado.getTipo());
                actualizarVisibilidadTipo();

                txtNombreCliente.setText(seleccionado.getNombreCliente());
                txtPrecioBase.setText(String.valueOf(seleccionado.getPrecioBase()));
                txtDuracionMeses.setText(String.valueOf(seleccionado.getDuracionMeses()));

                if (seleccionado instanceof PlanEstandar estandar) {
                    txtClasesSemanales.setText(String.valueOf(estandar.getClasesSemanales()));
                    chkAccesoPiscina.setSelected(estandar.isAccesoPiscina());
                    txtSesionesEntrenador.clear();
                    txtRecargoEntrenador.clear();
                } else if (seleccionado instanceof PlanPersonalizado personalizado) {
                    txtSesionesEntrenador.setText(String.valueOf(personalizado.getSesionesEntrenador()));
                    txtRecargoEntrenador.setText(String.valueOf(personalizado.getRecargoEntrenador()));
                    txtClasesSemanales.clear();
                    chkAccesoPiscina.setSelected(false);
                }

                lblEstado.setText("Editando plan ID #" + idSeleccionado);
            }
        });

        VBox.setVgrow(tablaPlanes, Priority.ALWAYS);
        return new VBox(10, lblSubtitulo, tablaPlanes);
    }

    private void actualizarVisibilidadTipo() {
        boolean esEstandar = "ESTANDAR".equals(cmbTipo.getValue());
        panelEstandar.setVisible(esEstandar);
        panelEstandar.setManaged(esEstandar);
        panelPersonalizado.setVisible(!esEstandar);
        panelPersonalizado.setManaged(!esEstandar);
    }

    private void accionGuardar() {
        try {
            int precioBase = txtPrecioBase.getText().isBlank() ? 0 : Integer.parseInt(txtPrecioBase.getText().trim());
            int duracionMeses = txtDuracionMeses.getText().isBlank() ? 0 : Integer.parseInt(txtDuracionMeses.getText().trim());
            int clasesSemanales = txtClasesSemanales.getText().isBlank() ? 0 : Integer.parseInt(txtClasesSemanales.getText().trim());
            int sesionesEntrenador = txtSesionesEntrenador.getText().isBlank() ? 0 : Integer.parseInt(txtSesionesEntrenador.getText().trim());
            int recargoEntrenador = txtRecargoEntrenador.getText().isBlank() ? 0 : Integer.parseInt(txtRecargoEntrenador.getText().trim());

            boolean exito = controller.registrarPlan(
                    cmbTipo.getValue(),
                    txtNombreCliente.getText(),
                    precioBase,
                    duracionMeses,
                    clasesSemanales,
                    chkAccesoPiscina.isSelected(),
                    sesionesEntrenador,
                    recargoEntrenador);

            if (exito) {
                limpiarFormulario();
                cargarDatosEnTabla();
                lblEstado.setText("Plan agregado correctamente en Oracle");
            } else {
                lblEstado.setText("Error: no se pudo guardar (revisa los campos y la consola).");
            }
        } catch (NumberFormatException ex) {
            lblEstado.setText("Error: Los campos numéricos deben contener números enteros válidos.");
        }
    }

    private void accionActualizar() {
        if (idSeleccionado == -1) {
            lblEstado.setText("Selecciona primero un plan en la tabla.");
            return;
        }
        try {
            int id = idSeleccionado;
            int precioBase = txtPrecioBase.getText().isBlank() ? 0 : Integer.parseInt(txtPrecioBase.getText().trim());
            int duracionMeses = txtDuracionMeses.getText().isBlank() ? 0 : Integer.parseInt(txtDuracionMeses.getText().trim());
            int clasesSemanales = txtClasesSemanales.getText().isBlank() ? 0 : Integer.parseInt(txtClasesSemanales.getText().trim());
            int sesionesEntrenador = txtSesionesEntrenador.getText().isBlank() ? 0 : Integer.parseInt(txtSesionesEntrenador.getText().trim());
            int recargoEntrenador = txtRecargoEntrenador.getText().isBlank() ? 0 : Integer.parseInt(txtRecargoEntrenador.getText().trim());

            boolean exito = controller.actualizarPlan(
                    id,
                    cmbTipo.getValue(),
                    txtNombreCliente.getText(),
                    precioBase,
                    duracionMeses,
                    clasesSemanales,
                    chkAccesoPiscina.isSelected(),
                    sesionesEntrenador,
                    recargoEntrenador);

            if (exito) {
                limpiarFormulario();
                cargarDatosEnTabla();
                lblEstado.setText("Plan ID #" + id + " actualizado");
            } else {
                lblEstado.setText("Error al actualizar plan.");
            }
        } catch (NumberFormatException ex) {
            lblEstado.setText("Error: Los campos numéricos deben contener números enteros válidos.");
        }
    }

    private void accionEliminar() {
        if (idSeleccionado == -1) {
            lblEstado.setText("Selecciona primero un plan en la tabla.");
            return;
        }
        Boolean exito = controller.eliminarPlan(idSeleccionado);

        if (exito) {
            lblEstado.setText("Usuario eliminado de Oracle.");
            limpiarFormulario();
            cargarDatosEnTabla();
        } else {
            lblEstado.setText("No se pudo eliminar el Plan");
        }
    }

    private void cargarDatosEnTabla() {
        ObservableList<PlanMembresia> datos = FXCollections.observableArrayList(controller.obtenerPlan());
        tablaPlanes.setItems(datos);
    }

    private void limpiarFormulario() {
        idSeleccionado = -1;
        cmbTipo.setValue("ESTANDAR");
        actualizarVisibilidadTipo();
        txtNombreCliente.clear();
        txtPrecioBase.clear();
        txtDuracionMeses.clear();
        txtClasesSemanales.clear();
        chkAccesoPiscina.setSelected(false);
        txtSesionesEntrenador.clear();
        txtRecargoEntrenador.clear();
        tablaPlanes.getSelectionModel().clearSelection();
        lblEstado.setText("Formulario limpio.");
    }
}