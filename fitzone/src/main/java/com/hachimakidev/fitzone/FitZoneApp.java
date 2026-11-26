package com.hachimakidev.fitzone;

import com.hachimakidev.fitzone.view.PlanView;
import javafx.application.Application;
import javafx.stage.Stage;

public class FitZoneApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        PlanView planView = new PlanView();
        primaryStage.setTitle("FitZone — Gestión de Planes de Membresía");
        primaryStage.setScene(planView.crearEscena());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

