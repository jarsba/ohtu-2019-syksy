package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPeliVsPelaaja extends KPSPeli {

    public KPSPeliVsPelaaja(Scanner scanner, Tuomari tuomari) {
        super(scanner, tuomari);
    }

    public void pelaa() {
        while (true) {
            System.out.print("Ensimmäisen pelaajan siirto: ");

            String ekanSiirto = scanner.nextLine();
            String tokanSiirto = scanner.nextLine();

            if (!onkoOkSiirto(ekanSiirto) || !onkoOkSiirto(tokanSiirto)) {
                break;
            }

            System.out.println("Tietokone valitsi: " + tokanSiirto);

            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();
        }
        tulostaLopputulos();
        tuomari.nollaaPisteet();
    }
}
