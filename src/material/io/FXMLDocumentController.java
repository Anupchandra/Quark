/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.io;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextArea;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextAreaBuilder;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
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
