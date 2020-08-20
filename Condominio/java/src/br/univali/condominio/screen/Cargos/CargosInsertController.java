package br.univali.condominio.screen.Cargos;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.univali.condominio.java.CondominioConnector;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CargosInsertController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nomeCargoTextField;

    @FXML
    private Button voltarButton;

    @FXML
    private Button insertButton;

    @FXML
    void inserirClicked(MouseEvent event) {
        String nomeCargo = nomeCargoTextField.getText();

        CondominioConnector.insertCargo(nomeCargo);
    }

    @FXML
    void voltarClicked(MouseEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("cargosScreen.fxml"))));

        window.show();
    }

    @FXML
    void initialize() {
        assert nomeCargoTextField != null : "fx:id=\"nomeCargoTextField\" was not injected: check your FXML file 'cargosInsertScreen.fxml'.";
        assert voltarButton != null : "fx:id=\"voltarButton\" was not injected: check your FXML file 'cargosInsertScreen.fxml'.";
        assert insertButton != null : "fx:id=\"insertButton\" was not injected: check your FXML file 'cargosInsertScreen.fxml'.";

    }
}
