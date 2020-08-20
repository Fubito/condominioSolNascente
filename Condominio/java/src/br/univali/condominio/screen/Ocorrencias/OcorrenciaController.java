package br.univali.condominio.screen.Ocorrencias;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.univali.condominio.java.CondominioConnector;
import br.univali.condominio.screen.Screens.SecondScreen;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class OcorrenciaController   implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button idInsert;

    @FXML
    private Button idEditar;

    @FXML
    private Button idDeletar;

    @FXML
    private Button idVoltar;

    @FXML
    private TextArea textField;

    @FXML
    private ScrollBar scrollBar;

    @FXML
    void deletarClicked(MouseEvent event) throws IOException{
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../Screens/deleteScreen.fxml"))));

        window.show();
    }

    @FXML
    void editarClicked(MouseEvent event)throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        if(SecondScreen.getTableId() == 3) {
            window.setScene(new Scene(FXMLLoader.load(getClass().getResource("ocorrenciaUpdateScreen.fxml"))));
            window.show();
        }
    }

    @FXML
    void insertClicked(MouseEvent event) throws IOException{
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("ocorrenciaInsertScreen.fxml"))));
        window.show();
    }

    @FXML
    void voltarClicked(MouseEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../Screens/secondScreen.fxml"))));

        window.show();
    }
    private void reloadTable(){
        textField.setText(text());
    }

    private String text(){
        StringBuilder result = new StringBuilder("ID            Data               Id Condomino         Ocorrencia\n");

        for(int i = 0; i < CondominioConnector.getOcorrenciaId().size(); i++){
            result.append(CondominioConnector.getOcorrenciaId().get(i)).append("             ")
                    .append(CondominioConnector.getDataOcorrencia().get(i)).append("          ")
                    .append(CondominioConnector.getOcorrenciaCondominoId().get(i)).append("                         ")
                    .append(CondominioConnector.getOcorrencia().get(i)).append("\n");
        }

        return result.toString();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SecondScreen.setTableId(3);
        reloadTable();
        scrollBar.setMin(0);
        scrollBar.setMax(textField.getText().length());
        scrollBar.valueProperty().addListener((obs, oldVal, newVal)->{
            textField.positionCaret(newVal.intValue());

        });

    }

    @FXML
    void initialize() {
        assert idInsert != null : "fx:id=\"idInsert\" was not injected: check your FXML file 'ocorrenciasScreen.fxml'.";
        assert idEditar != null : "fx:id=\"idEditar\" was not injected: check your FXML file 'ocorrenciasScreen.fxml'.";
        assert idDeletar != null : "fx:id=\"idDeletar\" was not injected: check your FXML file 'ocorrenciasScreen.fxml'.";
        assert idVoltar != null : "fx:id=\"idVoltar\" was not injected: check your FXML file 'ocorrenciasScreen.fxml'.";
        assert textField != null : "fx:id=\"textField\" was not injected: check your FXML file 'ocorrenciasScreen.fxml'.";
        assert scrollBar != null : "fx:id=\"scrollBar\" was not injected: check your FXML file 'ocorrenciasScreen.fxml'.";

    }
}
