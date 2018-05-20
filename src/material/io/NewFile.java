/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author ADMIN-PC
 */
public class NewFile extends Application {

    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        Stage primary = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("NewFile.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @FXML public javafx.scene.control.Button savefile;
    @FXML public javafx.scene.control.TextArea tfnewfile;
    @FXML
    public void saveFile(ActionEvent event) throws IOException
    {       
            FileChooser fileChooser = new FileChooser();
            Stage stage = (Stage) savefile.getScene().getWindow();
            //Set extension filter for text files
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
            //Show save file dialog
            File file = fileChooser.showSaveDialog(stage);
            if (file != null) {
                saveTextToFile(tfnewfile.getText(), file);
            }
    }
     private void saveTextToFile(String content, File file) {
            try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(content);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(NewFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private String readFile(File file) throws IOException{
        StringBuilder stringBuffer = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String text;
            while ((text = bufferedReader.readLine()) != null) {
                stringBuffer.append(text);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //bufferedReader.close();
        return stringBuffer.toString();    
    }
    @FXML private javafx.scene.control.Button btfind;
    @FXML private javafx.scene.control.Button btreplace;
    @FXML private javafx.scene.control.TextField tfind;
    @FXML private javafx.scene.control.TextField tfreplace;
    @FXML private javafx.scene.control.Label lbnotfound;
    @FXML
    public void findRep(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("FindRep.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        FindRepController c = fxmlLoader.getController();
        c.tffile.setText(tfnewfile.getText());
        Stage stage = new Stage();
        stage.setTitle("Find and Replace");
        stage.setScene(new Scene(root1)); 
        stage.show();
        //findReplace(stage);
        //((Node)(event.getSource())).getScene().getWindow().hide();
    }
    @FXML private javafx.scene.control.Button button;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
