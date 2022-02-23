module com.example.apigamemmo {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.apigamemmo to javafx.fxml;
    exports com.example.apigamemmo;
    exports com.example.apigamemmo.controladores;
    exports com.example.apigamemmo.modelos;
    opens com.example.apigamemmo.controladores to javafx.fxml;
}