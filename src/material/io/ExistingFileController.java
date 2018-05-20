package material.io;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ADMIN-PC
 */
public class ExistingFileController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML public javafx.scene.control.Button savefile;
    @FXML public javafx.scene.control.TextArea tfopenfile;
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
                saveTextToFile(tfopenfile.getText(), file);
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
    public String readFile(File file) throws IOException{
        StringBuilder stringBuffer = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String text;
            while ((text = bufferedReader.readLine()) != null) {
                stringBuffer.append(text);
                stringBuffer.append("\n");

            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //bufferedReader.close();
        return stringBuffer.toString();    
    }
    @FXML private javafx.scene.control.Button button;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }
    @FXML private javafx.scene.control.Button findbutton;
    @FXML
    public void findRep(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("FindRep.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        FindRepController c = fxmlLoader.getController();
        c.tffile.setText(tfopenfile.getText());
        Stage stage = new Stage();
        stage.setTitle("Find and Replace");
        stage.setScene(new Scene(root1)); 
        stage.showAndWait();
        tfopenfile.setText(c.getText2());
        //((Node)(event.getSource())).getScene().getWindow().hide();
        
        /*FXMLLoader loader = new FXMLLoader(getClass().getResource("FindRep.fxml"));  
        Stage stage = new Stage();
        stage.initOwner(findbutton.getScene().getWindow());
        FindRepController c = loader.getController();
        c.tffile.setText(tfopenfile.getText());
        stage.setScene(new Scene((Parent) loader.load()));
        // showAndWait will block execution until the window closes...
        stage.showAndWait();
        FindRepController controller = loader.getController();
        tfopenfile.setText(controller.getText());*/
    }
    @FXML
    public void sett(String s)
    {
        tfopenfile.setText(s);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    
    
}
