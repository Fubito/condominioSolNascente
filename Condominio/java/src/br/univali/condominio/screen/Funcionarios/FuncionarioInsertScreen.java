package br.univali.condominio.screen.Funcionarios;

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

public class FuncionarioInsertScreen {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nomeTextField;

    @FXML
    private TextField cargoTextField;

    @FXML
    private Button voltarButton;

    @FXML
    private Button insertButton;

    @FXML
    private TextField telefoneTextField;

    @FXML
    void inserirClicked(MouseEvent event) {
        String nome = nomeTextField.getText();
        int cargoId = Integer.parseInt(cargoTextField.getText());
        String telefone = telefoneTextField.getText();


        if(telefoneTextField.getText().isEmpty() || telefoneTextField.getText() == null){
            CondominioConnector.insertFuncionario(nome,cargoId);
        } else {
            CondominioConnector.insertFuncionarioTelefone(nome, telefone, cargoId);
        }
    }

    @FXML
    void voltarClicked(MouseEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("funcionarioScreen.fxml"))));

        window.show();
    }

    @FXML
    void initialize() {
        assert nomeTextField != null : "fx:id=\"nomeTextField\" was not injected: check your FXML file 'condominoInsertScreen.fxml'.";
        assert cargoTextField != null : "fx:id=\"cargoTextField\" was not injected: check your FXML file 'condominoInsertScreen.fxml'.";
        assert voltarButton != null : "fx:id=\"voltarButton\" was not injected: check your FXML file 'condominoInsertScreen.fxml'.";
        assert insertButton != null : "fx:id=\"insertButton\" was not injected: check your FXML file 'condominoInsertScreen.fxml'.";
        assert telefoneTextField != null : "fx:id=\"telefoneTextField\" was not injected: check your FXML file 'condominoInsertScreen.fxml'.";

    }
}
