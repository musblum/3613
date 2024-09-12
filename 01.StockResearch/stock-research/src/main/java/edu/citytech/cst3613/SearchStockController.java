package edu.citytech.cst3613;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;

public class SearchStockController implements Initializable {
    @FXML
    private FlowPane fpMarketCap;

    @FXML
    private FlowPane fpStocks;

    @FXML
    private Label lblRowCount;

    @FXML
    private Label lblTitle;

    @FXML
    private ToggleGroup tgMarketCap;

    ObservableList<Node> stocks;
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        stocks = fpStocks.getChildren();
        count(0, 1);


    }

    public void count(int i, int multipleOf){
        
        for ( Node node : stocks) {
            Label label = (Label)node;
            label.setText(((i= i+ 1) * multipleOf) + ""); 
            
        }
    }

    @FXML
    void selectMarketcap(ActionEvent event) {
        Node node = (Node)event.getSource();
        String sUserData = node.getUserData().toString();
        int multipleOf = Integer.parseInt(sUserData);
        System.out.println(event);
        count(0,multipleOf);
    }

}
