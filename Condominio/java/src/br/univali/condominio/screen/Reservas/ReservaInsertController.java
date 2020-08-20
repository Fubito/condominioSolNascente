package br.univali.condominio.screen.Reservas;

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

public class ReservaInsertController  {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField reservaTextField;

    @FXML
    private TextField idCondominoTextField;

    @FXML
    private Button voltarButton;

    @FXML
    private Button insertButton;

    @FXML
    private TextField dataTextField;

    @FXML
    void inserirClicked(MouseEvent event) throws IOException{
        String reserva = reservaTextField.getText();
        int idCondomino = Integer.parseInt(idCondominoTextField.getText());
        String data = dataTextField.getText();

        CondominioConnector.insertReserva(reserva,data,idCondomino);
    }

    @FXML
    void voltarClicked(MouseEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("reservasScreen.fxml"))));

        window.show();
    }

    @FXML
    void initialize() {
        assert reservaTextField != null : "fx:id=\"reservaTextField\" was not injected: check your FXML file 'reservaInsertScreen.fxml'.";
        assert idCondominoTextField != null : "fx:id=\"idCondominoTextField\" was not injected: check your FXML file 'reservaInsertScreen.fxml'.";
        assert voltarButton != null : "fx:id=\"voltarButton\" was not injected: check your FXML file 'reservaInsertScreen.fxml'.";
        assert insertButton != null : "fx:id=\"insertButton\" was not injected: check your FXML file 'reservaInsertScreen.fxml'.";
        assert dataTextField != null : "fx:id=\"dataTextField\" was not injected: check your FXML file 'reservaInsertScreen.fxml'.";

    }
}
