package ohtu.kivipaperisakset;

public class TekoalyHeikko implements Tekoaly {

    int siirto;

    public TekoalyHeikko() {
        siirto = 0;
    }

    public String annaSiirto() {
        siirto++;
        siirto = siirto % 3;

        if (siirto == 0) {
            return "k";
        } else if (siirto == 1) {
            return "p";
        } else {
            return "s";
        }
    }

    public void asetaSiirto(String ekanSiirto) {
        // ei tehdä mitään 
    }
}
