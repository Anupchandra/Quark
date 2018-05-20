/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.io;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ANANTHANUP
 */
public class FindRepController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML public javafx.scene.control.TextArea tffile;
    @FXML public javafx.scene.control.Button btfind;
    @FXML public javafx.scene.control.Button button;
    @FXML public javafx.scene.control.Button btreplace;
    @FXML public javafx.scene.control.TextField tfind;
    @FXML public javafx.scene.control.TextField tfreplace;
    @FXML public javafx.scene.control.Label lbnotfound;
    String text;
    public String getText2()
    {
        return text;
    }
    @FXML
    public void Find(ActionEvent event) throws IOException
    {
        tffile.setStyle("-fx-highlight-fill: lightgray; -fx-highlight-text-fill: firebrick; -fx-font-size: 12px;");
        String find = tfind.getText();
        String text = tffile.getText();
        Pattern word = Pattern.compile(find);
        Matcher match = word.matcher(text);
        if(!match.find())
        {
            lbnotfound.setVisible(true);
        }
        else
        {
            Platform.runLater(new Runnable() {
            @Override
            public void run() {
                tffile.selectRange(match.start(),match.end());
            }
            });
        }
    }
    @FXML private void Replace(ActionEvent event)
    {
        tffile.setStyle("-fx-highlight-fill: lightgray; -fx-highlight-text-fill: firebrick; -fx-font-size: 12px;");
        String find = tfind.getText();
        String text = tffile.getText();
        String replace = tfreplace.getText();
        Pattern word = Pattern.compile(find);
        Matcher match = word.matcher(text);
        if(!match.find())
        {
            lbnotfound.setVisible(true);
        }
        else
        {
            Platform.runLater(new Runnable() {
            @Override
            public void run() {
                tffile.selectRange(match.start(),match.end());
                tffile.replaceSelection(replace);
            }
            });
        }
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        text = tffile.getText();

        // close this window...
        button.getScene().getWindow().hide();

        /*Stage stage = (Stage) button.getScene().getWindow();
        stage.close();*/
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
