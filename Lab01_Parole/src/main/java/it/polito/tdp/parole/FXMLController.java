package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco = new Parole();
	List<String> lista = new LinkedList<String>();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;
    
    @FXML
    private TextArea txtTime;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnReset;

    @FXML
    void doInsert(ActionEvent event) {
    	
    	long startTime = System.nanoTime();
    	
    	elenco.addParola(txtParola.getText());
    	lista = elenco.getElenco();
    	txtResult.clear();
    	
    	for(String s : lista) {
    		txtResult.appendText(s+"\n");
    	}
    	
    	txtParola.clear();
    	
    	txtTime.appendText("Inserimento: "+(System.nanoTime() - startTime)+" nanosecondi\n");
    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	long startTime = System.nanoTime();
    	
    	elenco.reset();
    	txtResult.clear();
    	
    	txtTime.appendText("Reset: "+(System.nanoTime() - startTime)+" nanosecondi\n");
    }
    
    @FXML
    void doCancel(ActionEvent event) {
    	
    	long startTime = System.nanoTime();
    	
    	String s1 = txtResult.getSelectedText();
    	elenco.cancella(s1);
    	lista = elenco.getElenco();
    	txtResult.clear();
    	
    	for(String s : lista) {
    		txtResult.appendText(s+"\n");
    	}
    	
    	txtTime.appendText("Cancellazione: "+(System.nanoTime() - startTime)+" nanosecondi\n");
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
