package laskin.komennot;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.Sovelluslogiikka;

public class Summa extends Komento {

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        int syotearvo = 0;

        try {
            syotearvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }

        int tulosarvo = 0;

        try {
            tulosarvo = Integer.parseInt(tuloskentta.getText());
        } catch (Exception e) {
        }


        int laskunTulos = syotearvo + tulosarvo;

        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);

        if ( laskunTulos==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);

        edellinenArvo = syotearvo;
    }

    @Override
    public void peru() {

        int tulosarvo = 0;

        try {
            tulosarvo = Integer.parseInt(tuloskentta.getText());
        } catch (Exception e) {
        }

        int laskunTulos = (tulosarvo-this.edellinenArvo);

        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);

        if ( laskunTulos==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);

        edellinenArvo = 0;
    }
}