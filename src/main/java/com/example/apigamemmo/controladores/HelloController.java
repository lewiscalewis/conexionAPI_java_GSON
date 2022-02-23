package com.example.apigamemmo.controladores;

import com.example.apigamemmo.modelos.JuegoMMO;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import com.google.gson.Gson;

public class HelloController {

    @FXML
    private ChoiceBox<String> genero;

    @FXML
    private ChoiceBox<String> plataforma;

    @FXML
    private TableView<?> tabla;

    @FXML
    void initialize() throws IOException {

        genero.getItems().add("Shooter");
        genero.getItems().add("Acción");
        genero.getItems().add("Anime");

        plataforma.getItems().add("Alfabetico");
        plataforma.getItems().add("Fecha de lanzamiento");
        plataforma.getItems().add("Popularidad");

    }

    @FXML
    void lanzar() throws IOException {

        ArrayList resultado1 = new ArrayList<String>();

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
            JuegoMMO[] footballPlayers = gson.fromJson(linea, JuegoMMO[].class);

            for (JuegoMMO footballPlayer : footballPlayers) {
                System.out.println(footballPlayer);
            }
            resultado1.add(linea);
        }
        // Cerrar el BufferedReader
        rd.close();
        // Regresar resultado, pero como cadena, no como StringBuilder
        System.out.println(resultado1.get(0));
    }

}
