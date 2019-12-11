package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPeliTehdas {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Tuomari tuomari = new Tuomari();
    private static final Tekoaly heikkoTekoaly = new TekoalyHeikko();
    private static final Tekoaly paranneltuTekoaly = new TekoalyParannettu(20);

    public static void pelaaHelppoYksinpeli() {
        new KPSPeliVsTekoaly(scanner, tuomari, heikkoTekoaly).pelaa();
    }

    public static void pelaaVaikeYksinpeli() {
        new KPSPeliVsTekoaly(scanner, tuomari, paranneltuTekoaly).pelaa();
    }

    public static void pelaaKaksinpeli() {
        new KPSPeliVsPelaaja(scanner, tuomari).pelaa();
    }

}
