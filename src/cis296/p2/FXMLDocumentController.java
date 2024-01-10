/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis296.p2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class FXMLDocumentController implements Initializable {

    @FXML
    private Button button;

    @FXML
    private ComboBox<String> comboBox1;

    @FXML
    private ComboBox<String> comboBox2;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    void buttonPress(MouseEvent event) {
        // calculate two selection
        label3.setText(String.format("$%,d/semester", dormPrice + mealPrice));
    }
    
    
    ObservableList<String> dormList = FXCollections.observableArrayList(
            "Snaggletooth Hall", "Bupkis Hall", "Dumptruck Hall", "University Suites");
    
    ObservableList<String> mealList = FXCollections.observableArrayList(
            "7 meals per week", "14 meals per week", "Unlimited meals");

    // dorm price list
    int[] dormPriceList = {1500, 2500, 1200, 3000};

    // meal plan price list
    int[] mealPriceList = {600, 1100, 1800};

    int dormPrice, mealPrice; // set price after the ComboBox is set

    @FXML
    void combo1Changed (ActionEvent event) {
        if (Objects.equals(comboBox1.getValue(), dormList.get(0))) {
            label1.setText(String.format("$%,d/semester", dormPriceList[0]));
            dormPrice = dormPriceList[0];
        } else if (Objects.equals(comboBox1.getValue(), dormList.get(1))) {
            label1.setText(String.format("$%,d/semester", dormPriceList[1]));
            dormPrice = dormPriceList[1];
        } else if (Objects.equals(comboBox1.getValue(), dormList.get(2))) {
            label1.setText(String.format("$%,d/semester", dormPriceList[2]));
            dormPrice = dormPriceList[2];
        } else {
            label1.setText(String.format("$%,d/semester", dormPriceList[3]));
            dormPrice = dormPriceList[3];
        }
    }

    @FXML
    void combo2Changed (ActionEvent event) {
        if (Objects.equals(comboBox2.getValue(), mealList.get(0))) {
            label2.setText(String.format("$%,d/semester", mealPriceList[0]));
            mealPrice = mealPriceList[0];
        } else if (Objects.equals(comboBox2.getValue(), mealList.get(1))) {
            label2.setText(String.format("$%,d/semester", mealPriceList[1]));
            mealPrice = mealPriceList[1];
        } else {
            label2.setText(String.format("$%,d/semester", mealPriceList[2]));
            mealPrice = mealPriceList[2];
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBox1.setItems(dormList);
        comboBox2.setItems(mealList);
    }
}

