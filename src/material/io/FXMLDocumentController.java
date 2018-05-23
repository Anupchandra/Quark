/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.io;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author ARMC
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML private javafx.scene.control.Button button;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }
    @FXML public javafx.scene.control.TextArea tfnewfile;
    @FXML
    private void openNewFile(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewFile.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Edit New File");
        stage.setScene(new Scene(root1)); 
        stage.show();
        //((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML private javafx.scene.control.Button openfile;
    @FXML public javafx.scene.control.TextArea tfopenfile;
    @FXML
    private void openExistingFile(ActionEvent event) throws IOException
    {
        FileChooser fileChooser = new FileChooser();
        Stage stage = (Stage) openfile.getScene().getWindow();
            //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        //Show open file dialog
        File file = fileChooser.showOpenDialog(stage);
        if(file != null)
        {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("ExistingFile.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            ExistingFileController c = fxmlLoader.getController();
            c.tfopenfile.setText(c.readFile(file));
            //c.sett("Hello");
            Stage stage1 = new Stage();
            stage1.setTitle("Edit Existing File");
            stage1.setScene(new Scene(root1));
            stage1.show();
        }
        //((Node)(event.getSource())).getScene().getWindow().hide();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
