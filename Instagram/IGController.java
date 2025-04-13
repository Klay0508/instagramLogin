package javaFx.FXML.Instagram;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class IGController {
    @FXML private TextField name;
    @FXML private TextField lastName;
    @FXML private TextField phNumber;
    @FXML private ChoiceBox<String> choiceBox;

    @FXML
    public void instagram(){

        try {
            UserInformation UI = new UserInformation();
            UI.setName(name.getText());
            UI.setLastName(lastName.getText());

            try{
                long number = Long.parseLong(phNumber.getText());
                UI.setPhNumber(number);
            }catch (NumberFormatException e){
                throw new IGException("Phone number cannot be empty and must be digits only");
            }

            String gender = choiceBox.getValue();
            if(gender == null){
                throw new IGException("please choose a gender");
            }


            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Confirmation");
            alert.setContentText("Hello " + UI.getName() + " !");
            alert.showAndWait();
            name.clear();
            lastName.clear();
            phNumber.clear();
            choiceBox.getItems().clear();


        }catch (IGException ige){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText(ige.getMessage());
            alert.showAndWait();
        }
    }
    @FXML
    public void choice() {
        ObservableList<String> options = FXCollections.observableArrayList();
        options.addAll("Male", "Female", "Other");
        choiceBox.setItems(options);
        }


    @FXML
    public void cancel(){
        Stage stage = (Stage) name.getScene().getWindow();
        stage.close();
        Platform.exit();
    }
}
