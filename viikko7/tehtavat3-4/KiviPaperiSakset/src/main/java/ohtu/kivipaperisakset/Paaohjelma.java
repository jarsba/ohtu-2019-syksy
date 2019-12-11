package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            tulostaMenu();

            String vastaus = scanner.nextLine();
            System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
            if (vastaus.endsWith("a")) {
                KPSPeliTehdas.pelaaKaksinpeli();
            } else if (vastaus.endsWith("b")) {
                KPSPeliTehdas.pelaaHelppoYksinpeli();
            } else if (vastaus.endsWith("c")) {
                KPSPeliTehdas.pelaaVaikeYksinpeli();
            } else {
                break;
            }
        }
    }

    public static void tulostaMenu() {
        System.out.println("\nValitse pelataanko"
                + "\n (a) ihmistä vastaan "
                + "\n (b) tekoälyä vastaan"
                + "\n (c) parannettua tekoälyä vastaan"
                + "\nmuilla valinnoilla lopetataan");
    }
}
