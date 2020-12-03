/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_assignment2.pkg2;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

/**
 *
 * @author Jeremy
 */
public class NumberField extends TextField {

    public NumberField () {
        initSpellListener();
    }

    public final void initSpellListener() {
        this.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                this.setText(newValue.replaceAll("[^\\d,]", ""));/*The comma here "[^\\d,]" can be changed with the dot*/
                StringBuilder aus = new StringBuilder();
                aus.append(this.getText());
                boolean firstPointFound = false;

                for (int i = 0; i < aus.length(); i++) {
                    if (aus.charAt(i) == ',') {/*Change the , with . if you want the . to be the decimal separator*/
                        if (!firstPointFound) {
                            firstPointFound = true;
                        } else {
                            aus.deleteCharAt(i);
                        }
                    }
                }
                newValue = aus.toString();
                this.setText(newValue);
            } else {
                this.setText(newValue);
            }
        });
    }
}