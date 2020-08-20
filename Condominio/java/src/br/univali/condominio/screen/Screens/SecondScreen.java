package br.univali.condominio.screen.Screens;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SecondScreen {

    private static int tableId = 0;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button idVoltar;

    @FXML
    private Button idCondomino;

    @FXML
    private Button idReservas;

    @FXML
    private Button idOcorrencias;

    @FXML
    private Button idFuncionarios;

    @FXML
    private Button idAchados;

    @FXML
    private Button idCargos;

    @FXML
    void achadosClicked(MouseEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../AchadosEPerdidos/achadosScreen.fxml"))));

        window.show();
    }

    @FXML
    void achadosReleased(MouseEvent event) {

    }

    @FXML
    void cargosClicked(MouseEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../Cargos/cargosScreen.fxml"))));

        window.show();
    }

    @FXML
    void cargosReleased(MouseEvent event) {

    }

    @FXML
    void condominoClicked(MouseEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../Condomino/condominoScreen.fxml"))));

        window.show();
    }

    @FXML
    void condominoReleased(MouseEvent event) {

    }

    @FXML
    void funcionariosClicked(MouseEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../Funcionarios/funcionarioScreen.fxml"))));

        window.show();
    }

    @FXML
    void funcionariosReleased(MouseEvent event) {

    }

    @FXML
    void ocorrenciasClicked(MouseEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../Ocorrencias/ocorrenciasScreen.fxml"))));

        window.show();
    }

    @FXML
    void ocorrenciasReleased(MouseEvent event) {

    }

    @FXML
    void reservasClicked(MouseEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../Reservas/reservasScreen.fxml"))));

        window.show();
    }

    @FXML
    void reservasReleased(MouseEvent event) {

    }

    @FXML
    void voltarClicked(MouseEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("screen.fxml"))));

        window.show();
    }

    @FXML
    void voltarReleased(MouseEvent event) {

    }

    public static int getTableId() {
        return tableId;
    }

    public static void setTableId(int tableId) {
        SecondScreen.tableId = tableId;
    }

    @FXML
    void initialize() {
        assert idVoltar != null : "fx:id=\"idVoltar\" was not injected: check your FXML file 'secondScreen.fxml'.";
        assert idCondomino != null : "fx:id=\"idCondomino\" was not injected: check your FXML file 'secondScreen.fxml'.";
        assert idReservas != null : "fx:id=\"idReservas\" was not injected: check your FXML file 'secondScreen.fxml'.";
        assert idOcorrencias != null : "fx:id=\"idOcorrencias\" was not injected: check your FXML file 'secondScreen.fxml'.";
        assert idFuncionarios != null : "fx:id=\"idFuncionarios\" was not injected: check your FXML file 'secondScreen.fxml'.";
        assert idAchados != null : "fx:id=\"idAchados\" was not injected: check your FXML file 'secondScreen.fxml'.";
        assert idCargos != null : "fx:id=\"idCargos\" was not injected: check your FXML file 'secondScreen.fxml'.";

    }
}
