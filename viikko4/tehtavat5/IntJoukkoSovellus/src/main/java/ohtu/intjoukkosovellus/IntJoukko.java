
package ohtu.intjoukkosovellus;

import java.util.Arrays;

public class IntJoukko {

    private final static int KAPASITEETTI = 5,
            OLETUSKASVATUS = 5;
    private int[] joukko;
    private int kasvatuskoko;
    private int alkioidenLkm;

    public int getKasvatuskoko() {
        return kasvatuskoko;
    }

    public void setKasvatuskoko(int kasvatuskoko) {
        this.kasvatuskoko = kasvatuskoko;
    }

    public int[] getJoukko() {
        return joukko;
    }

    public void setJoukko(int[] joukko) {
        this.joukko = joukko;
    }

    public int getAlkioidenLkm() {
        return alkioidenLkm;
    }

    public void setAlkioidenLkm(int alkioidenLkm) {
        this.alkioidenLkm = alkioidenLkm;
    }

    private void alustaTaulukko(int kapasiteetti, int kasvatuskoko) {
        joukko = new int[kapasiteetti];
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public IntJoukko() {
        alustaTaulukko(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        alustaTaulukko(kapasiteetti, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti pienempi kuin nolla");
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kasvatuskoko pienempi kuin nolla");
        }
        alustaTaulukko(kapasiteetti, kasvatuskoko);
    }

    private boolean taysi() {
        return alkioidenLkm % joukko.length == 0;
    }

    private void kasvata() {
        int[] uusi = new int[alkioidenLkm + kasvatuskoko];
        kopioiTaulukko(joukko, uusi);
        joukko = uusi;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        System.arraycopy(vanha, 0, uusi, 0, vanha.length);
    }

    public boolean kuuluu(int luku) {
        return Arrays.stream(joukko).anyMatch(i -> i == luku);
    }

    public int haeLukuIndeksista(int indeksi) {
        return joukko[indeksi];
    }

    public int getKoko() {
        return joukko.length;
    }

    public int etsIndeksi(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == joukko[i]) {
                return i;
            }
        }
        return -1;
    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            joukko[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (taysi()) {
                kasvata();
            }
            return true;
        }
        return false;
    }

    public boolean poista(int luku) {
        int indeksi = etsIndeksi(luku);
        if (indeksi != -1) {
            joukko[indeksi] = 0;
            for (int j = indeksi; j < alkioidenLkm - 1; j++) {
                joukko[j] = joukko[j + 1];
            }
            alkioidenLkm--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String tuotos = "{";
        for (int i = 0; i < alkioidenLkm; i++) {
            tuotos += joukko[i];
            if (i + 1 != alkioidenLkm) {
                tuotos += ", ";
            }
        }
        tuotos += "}";
        return tuotos;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        System.arraycopy(joukko, 0, taulu, 0, alkioidenLkm);
        return taulu;
    }


    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        for (int i = 0; i < a.getKoko(); i++) {
            x.lisaa(a.haeLukuIndeksista(i));
        }
        for (int i = 0; i < b.getKoko(); i++) {
            x.lisaa(b.haeLukuIndeksista(i));
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        for (int i = 0; i < a.getKoko(); i++) {
            for (int j = 0; j < b.getKoko(); j++) {
                if (a.haeLukuIndeksista(i) == b.haeLukuIndeksista(j)) {
                    y.lisaa(b.haeLukuIndeksista(j));
                }
            }
        }
        return y;

    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        for (int i = 0; i < a.getKoko(); i++) {
            z.lisaa(a.haeLukuIndeksista(i));
        }
        for (int i = 0; i < b.getKoko(); i++) {
            z.poista(b.haeLukuIndeksista(i));
        }

        return z;
    }

}
