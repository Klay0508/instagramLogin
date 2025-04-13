package javaFx.FXML.Instagram;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {


    public void switchToScene2(ActionEvent Event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("javaFx/FXML/Instagram/instagram.fxml"));
        Stage stage = (Stage) ((Node) Event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
