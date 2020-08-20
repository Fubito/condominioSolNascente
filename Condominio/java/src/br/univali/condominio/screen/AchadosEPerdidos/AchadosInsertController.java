package br.univali.condominio.screen.AchadosEPerdidos;

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

public class AchadosInsertController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField itemTextField;

    @FXML
    private TextField idFuncionarioTextField;


    @FXML
    private Button voltarButton;

    @FXML
    private Button inserirButton;

    @FXML
    void inserirClicked(MouseEvent event) {
            String itemAchado = itemTextField.getText();
            int idFuncionario = Integer.parseInt(idFuncionarioTextField.getText());

            //verificar
            CondominioConnector.insertAchadosEPerdidos(itemAchado, idFuncionario);

    }


    @FXML
    void voltarClicked(MouseEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("achadosScreen.fxml"))));

        window.show();
    }

    @FXML
    void initialize() {
        assert itemTextField != null : "fx:id=\"itemTextField\" was not injected: check your FXML file 'achadosInsertScreen.fxml'.";
        assert idFuncionarioTextField != null : "fx:id=\"idFuncionarioTextField\" was not injected: check your FXML file 'achadosInsertScreen.fxml'.";
        assert voltarButton != null : "fx:id=\"voltarButton\" was not injected: check your FXML file 'achadosInsertScreen.fxml'.";
        assert inserirButton != null : "fx:id=\"inserirButton\" was not injected: check your FXML file 'achadosInsertScreen.fxml'.";

    }
}
