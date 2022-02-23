package com.example.apigamemmo.controladores;

import com.example.apigamemmo.modelos.JuegoMMO;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import com.google.gson.Gson;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {

    @FXML
    private ChoiceBox<String> genero;

    @FXML
    private ChoiceBox<String> plataforma;

    @FXML
    private TableView<JuegoMMO> tabla;

    @FXML
    void initialize() throws IOException {

        genero.getItems().add("Shooter");
        genero.getItems().add("Acción");
        genero.getItems().add("Anime");

        plataforma.getItems().add("Alfabetico");
        plataforma.getItems().add("Fecha de lanzamiento");
        plataforma.getItems().add("Popularidad");

        TableColumn<JuegoMMO, String> column1 = new TableColumn<>("ID");
        column1.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<JuegoMMO, String> column2 = new TableColumn<>("Título");
        column2.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<JuegoMMO, String> column3 = new TableColumn<>("Descripción");
        column3.setCellValueFactory(new PropertyValueFactory<>("short_description"));

        TableColumn<JuegoMMO, String> column4 = new TableColumn<>("Desarrollador");
        column4.setCellValueFactory(new PropertyValueFactory<>("developer"));

        TableColumn<JuegoMMO, String> column5 = new TableColumn<>("Plataforma");
        column5.setCellValueFactory(new PropertyValueFactory<>("platform"));

        TableColumn<JuegoMMO, String> column6 = new TableColumn<>("Fecha de salida");
        column6.setCellValueFactory(new PropertyValueFactory<>("release_date"));


        tabla.getColumns().add(column1);
        tabla.getColumns().add(column2);
        tabla.getColumns().add(column3);
        tabla.getColumns().add(column4);
        tabla.getColumns().add(column5);
        tabla.getColumns().add(column6);

    }

    @FXML
    void lanzar() throws IOException {

        ArrayList resultado1 = new ArrayList<JuegoMMO>();

        String url1 = "https://www.mmobomb.com/api1/games?sort-by=";
        String url2 = "https://www.mmobomb.com/api1/games?category=";

        String param1 = genero.getValue();
        String param2 = plataforma.getValue();

        switch (param1){
            case "Acción": param1 = "action";
            break;
            case "Anime": param1 = "anime";
            break;
            case "Shooter": param1 = "shooter";
            break;
        }

        URL urls1 = new URL(url2+param1);
        URL urls2 = new URL(url1+param2);

        HttpURLConnection conexion1 = (HttpURLConnection) urls1.openConnection();
        conexion1.setRequestMethod("GET");
        HttpURLConnection conexion2 = (HttpURLConnection) urls2.openConnection();
        conexion2.setRequestMethod("GET");

        BufferedReader rd = new BufferedReader(new InputStreamReader(conexion1. getInputStream()));
        String linea;
        // Mientras el BufferedReader se pueda leer, agregar contenido a resultado
        while ((linea = rd.readLine()) != null) {
            Gson gson = new Gson();
            JuegoMMO[] juegos = gson.fromJson(linea, JuegoMMO[].class);

            for (JuegoMMO juego : juegos) {
                tabla.getItems().add(juego);
                resultado1.add(juego.toString());
                System.out.println(juego);
            }
        }
        // Cerrar el BufferedReader
        rd.close();
    }

}
