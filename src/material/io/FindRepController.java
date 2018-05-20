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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

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
    @FXML public javafx.scene.control.Button btreplace;
    @FXML public javafx.scene.control.TextField tfind;
    @FXML public javafx.scene.control.TextField tfreplace;
    @FXML public javafx.scene.control.Label lbnotfound;
    public String text;
    @FXML
    public void findReplace(ActionEvent event) throws IOException
    {
        System.out.println(text);
        String find = tfind.getText();
        System.out.println(find);
        if(text.indexOf(find) == -1)
        {
            lbnotfound.setVisible(true);
        }
        else
        {
            String replace = tfreplace.getText();
            
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
