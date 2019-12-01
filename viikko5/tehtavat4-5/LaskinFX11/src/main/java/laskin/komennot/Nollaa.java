package laskin.komennot;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.Sovelluslogiikka;

public class Nollaa extends Komento {

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        int tulosarvo = 0;

        try {
            tulosarvo = Integer.parseInt(tuloskentta.getText());
        } catch (Exception e) {
        }

        syotekentta.setText("");
        tuloskentta.setText("" + 0);
        nollaa.disableProperty().set(true);
        undo.disableProperty().set(false);
        edellinenArvo = tulosarvo;
    }

    @Override
    public void peru() {
        syotekentta.setText("");
        tuloskentta.setText("" + this.edellinenArvo);

        if ( this.edellinenArvo==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);

        edellinenArvo = 0;
    }
}