package TicTacToe;
// @author vug

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// A lépés tkp. a tábla egy cellája

public class Lepes {

    private String lepes;
    private char betu;
    private int szam;
    private int oszlop;
    private int sor;
    private char jel;

    public Lepes(String lepes, char jel) {
        this.lepes = lepes;
        this.betu = Character.toUpperCase(lepes.charAt(0));
        this.szam = Character.getNumericValue(lepes.charAt(1));
        this.sor = betu - 'A';
        this.oszlop = szam - 1;
        this.jel = jel;
    }

    public Lepes() {
    }

    public boolean checkStep(Tabla t) {

        if (t.getM() + 'A' < betu + 1 || 'A' - betu > 0 || szam < 1 || szam > t.getM()
                || lepes.length() != 2 || t.getTabla()[sor][oszlop].getJel()!= 32) {
            return false;
        }
        return true;
    }

    public void gepiLepes(Tabla t, char jel) {
        List<String> ures = new ArrayList<String>();
        for (int i = 0; i < t.getM(); i++) {
            for (int j = 0; j < t.getM(); j++) {
                if (t.getTabla()[i][j].getJel()== 32) {
                    ures.add(t.getBETUK()[i] + (j+1));
                }
            }
        }
        Random randsz = new Random();
        int sz = randsz.nextInt(ures.size());
        this.setLepes(t, ures.get(sz), jel);
    }

    public String getLepes() {
        return lepes;
    }

    public char getBetu() {
        return betu;
    }

    public int getSzam() {
        return szam;
    }

    public int getOszlop() {
        return oszlop;
    }

    public int getSor() {
        return sor;
    }

    public void setLepes(Tabla t, String lepes, char jel) {
        this.lepes = lepes;
        this.betu = Character.toUpperCase(lepes.charAt(0));
        this.szam = Character.getNumericValue(lepes.charAt(1));
        this.sor = betu - 'A';
        this.oszlop = this.szam - 1;
        this.jel = jel;
    }

    public char getJel() {
        return jel;
    }   

}
