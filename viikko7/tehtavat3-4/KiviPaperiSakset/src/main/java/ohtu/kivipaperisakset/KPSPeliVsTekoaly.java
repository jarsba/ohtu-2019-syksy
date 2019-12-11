package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPeliVsTekoaly extends KPSPeli {

    protected Tekoaly tekoaly;

    public KPSPeliVsTekoaly(Scanner scanner, Tuomari tuomari, Tekoaly tekoaly) {
        super(scanner, tuomari);
        this.tekoaly = tekoaly;
    }

    public void pelaa() {
        while (true) {
            System.out.print("Ensimmäisen pelaajan siirto: ");

            String ekanSiirto = scanner.nextLine();
            String tokanSiirto = tekoaly.annaSiirto();

            if (!onkoOkSiirto(ekanSiirto) || !onkoOkSiirto(tokanSiirto)) {
                break;
            }

            System.out.println("Tietokone valitsi: " + tokanSiirto);

            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            tekoaly.asetaSiirto(ekanSiirto);
        }
        tulostaLopputulos();
        tuomari.nollaaPisteet();
    }
}
