package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import DAO.AnagrammaDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Anagrammi;

public class FXMLController {
	
	Anagrammi model;
	AnagrammaDAO dao;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private TextField txtParola;

    @FXML
    void doCalcola(ActionEvent event) {
    	txtCorretti.clear();
    	txtErrati.clear();
    	Set<String> listaFinale; 
    	listaFinale = model.anagramma(txtParola.getText());
    	for(String s: listaFinale) {
    		if(dao.isCorrect(s)) {
    			txtCorretti.appendText(s+"\n");
    		}
    		else {
    			txtErrati.appendText(s+"\n");
    		}
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtCorretti.clear();
    	txtErrati.clear();
    	txtParola.clear();
    }
    
    public void setModel(Anagrammi model) {
   		this.model = model;
   		this.dao = new AnagrammaDAO();
   	}

    @FXML
    void initialize() {
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}

	
