package br.univali.condominio.screen.Condomino;

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

public class CondominoUpdateScreen {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nomeTextField;

    @FXML
    private TextField apTextField;

    @FXML
    private Button voltarButton;

    @FXML
    private Button inserirButton;

    @FXML
    private TextField telefoneTextField;

    @FXML
    private TextField idCondominoTextField;

    @FXML
    void updateClicked(MouseEvent event) {
        int id = Integer.parseInt(idCondominoTextField.getText());
        String nome = nomeTextField.getText();
        String ap = apTextField.getText();
        String telefone = telefoneTextField.getText();

        CondominioConnector.updateCondomino(id,nome,ap,telefone);
    }

    @FXML
    void voltarClicked(MouseEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("condominoScreen.fxml"))));

        window.show();
    }

    @FXML
    void initialize() {
        assert nomeTextField != null : "fx:id=\"nomeTextField\" was not injected: check your FXML file 'condominoInsertScreen.fxml'.";
        assert apTextField != null : "fx:id=\"apTextField\" was not injected: check your FXML file 'condominoInsertScreen.fxml'.";
        assert voltarButton != null : "fx:id=\"voltarButton\" was not injected: check your FXML file 'condominoInsertScreen.fxml'.";
        assert inserirButton != null : "fx:id=\"inserirButton\" was not injected: check your FXML file 'condominoInsertScreen.fxml'.";
        assert telefoneTextField != null : "fx:id=\"telefoneTextField\" was not injected: check your FXML file 'condominoInsertScreen.fxml'.";
        assert idCondominoTextField != null : "fx:id=\"idCondominoTextField\" was not injected: check your FXML file 'condominoInsertScreen.fxml'.";

    }
}
