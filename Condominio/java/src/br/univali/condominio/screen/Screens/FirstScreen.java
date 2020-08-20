package br.univali.condominio.screen.Screens;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class FirstScreen {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView image;

    @FXML
    private Button idGerenciar;

    @FXML
    private Button idSair;

    @FXML
    void gerenciarClicked(MouseEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("secondScreen.fxml"))));

        window.show();
    }

    @FXML
    void gerenciarReleased(MouseEvent event) {

    }

    @FXML
    void sairClicked(MouseEvent event) {

        Stage stage = (Stage) idSair.getScene().getWindow();
        stage.close();
        System. exit(-1);
    }

    @FXML
    void sairReleased(MouseEvent event) {

    }

    @FXML
    void initialize() {
        image.setImage(new Image("file:fundo.png"));



        assert image != null : "fx:id=\"image\" was not injected: check your FXML file 'screen.fxml'.";
        assert idGerenciar != null : "fx:id=\"idGerenciar\" was not injected: check your FXML file 'screen.fxml'.";
        assert idSair != null : "fx:id=\"idSair\" was not injected: check your FXML file 'screen.fxml'.";



    }
}
