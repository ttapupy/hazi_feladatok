package TicTacToeConsole;
// @author vug

public class Jatekos {
    
    private String nev;
    private char jel;
    private boolean gepi;
    private boolean kezd;

    public Jatekos(String nev, char jel, boolean gepi) {
        this.nev = nev;
        this.kezd = kezd;
        if (jel=='O' || jel =='o' || jel =='0') {
            this.jel = 'O';
            this.kezd = false;
        } else {
            this.jel = 'X';
            this.kezd = true;
        }
        this.gepi = gepi;
    }

    @Override
    public String toString() {
        return nev + " { " + jel + " }";
    }
    
    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public char getJel() {
        return jel;
    }

    public boolean isGepi() {
        return gepi;
    } 

}
