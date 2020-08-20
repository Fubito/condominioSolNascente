package br.univali.condominio.screen.Screens;

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

public class DeleteScreen {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button voltarButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField deleteTextField;

    @FXML
    void deleteClicked(MouseEvent event) {
        int id = Integer.parseInt(deleteTextField.getText());
        System.out.println(SecondScreen.getTableId());

        if(SecondScreen.getTableId() == 1) {
            CondominioConnector.deleteCondomino(id);
        }
        if(SecondScreen.getTableId() == 2){
            CondominioConnector.deleteReserva(id);
        }
        if(SecondScreen.getTableId() == 3){
            CondominioConnector.deleteOcorrencia(id);
        }
        if(SecondScreen.getTableId() == 4){
            CondominioConnector.deleteFuncionario(id);
        }
        if (SecondScreen.getTableId() == 5) {
            CondominioConnector.deleteAchadosEPerdidos(id);
        }
        if(SecondScreen.getTableId() == 6){
            CondominioConnector.deleteCargo(id);
        }
    }
    @FXML
    void voltarClicked(MouseEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        if(SecondScreen.getTableId() == 1) {
            window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../Condomino/condominoScreen.fxml"))));
        }
        if(SecondScreen.getTableId() == 2){
            window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../Reservas/reservasScreen.fxml"))));
        }
        if(SecondScreen.getTableId() == 3){
            window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../Ocorrencias/ocorrenciasScreen.fxml"))));
        }
        if(SecondScreen.getTableId() == 4){
            window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../Funcionarios/funcionarioScreen.fxml"))));
        }
        if (SecondScreen.getTableId() == 5) {
            window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../AchadosEPerdidos/achadosScreen.fxml"))));
        }
        if(SecondScreen.getTableId() == 6){
            window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../Cargos/cargosScreen.fxml"))));
        }
        window.show();
    }

    @FXML
    void initialize() {
        assert voltarButton != null : "fx:id=\"voltarButton\" was not injected: check your FXML file 'deleteScreen.fxml'.";
        assert deleteButton != null : "fx:id=\"deleteButton\" was not injected: check your FXML file 'deleteScreen.fxml'.";
        assert deleteTextField != null : "fx:id=\"deleteTextField\" was not injected: check your FXML file 'deleteScreen.fxml'.";

    }
}
