package ohtu.kivipaperisakset;

import java.util.Scanner;

public abstract class KPSPeli {

    protected Scanner scanner;
    protected Tuomari tuomari;

    public KPSPeli(Scanner scanner, Tuomari tuomari) {
        this.scanner = scanner;
        this.tuomari = tuomari;
    }

    public abstract void pelaa();

    public void tulostaLopputulos() {
        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
