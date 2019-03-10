package TicTacToe;
// @author vug

public class Tabla {

    private static int m=3; // méret
    private static final String[] BETUK = {"A", "B", "C", "D", "E", "F"};
    private Lepes[][] tabla = new Lepes [m][m];
    //private Lepes cella;

    public void rajzol() {

        System.out.print("    ");
        for (int i = 1; i <= m; i++) {
            System.out.print(i + "   ");
        }
        System.out.print("\n  +");
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < m; i++) {
                System.out.print("---+");
            }
            System.out.println();
            System.out.print(BETUK[j]);
            for (int i = 0; i < m; i++) {
                System.out.print(" | " + tabla[j][i].getJel());
            }
            System.out.print(" |\n  +");
        }
        for (int i = 0; i < m; i++) {
            System.out.print("---+");
        }
        System.out.println();
    }
    
    public char nyertes() {
        int tempV;
        int tempF;
        int tempAB = 0;
        int tempAJ = 0;
        for (int i = 0; i < m; i++) {
            tempV = 0;
            tempF = 0;
            for (int j = 0; j < m; j++) {
                tempV += tabla[i][j].getJel();
                tempF += tabla[j][i].getJel();
                if (i == j) {
                    tempAB += tabla[i][j].getJel();
                }
                if (i + j == m - 1) {
                    tempAJ += tabla[i][j].getJel();
                }
            }
            if (tempV == m * 79 || tempF == m * 79) {     // méret * 'O' ascii értéke
                return 'O';
            } else if (tempV == m * 88 || tempF == m * 88) {
                return 'X';
            }
        }
        if (tempAB == m * 79 || tempAJ == m * 79) {
            return 'O';
        } else if (tempAB == m * 88 || tempAJ == m * 88) {
            return 'X';
        }
        return '#'; // döntetlen 
    }
    
        public boolean vege() {
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla.length; j++) {
                if (tabla[i][j].getJel() % 32 == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public Tabla() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                tabla[i][j] = new Lepes(BETUK[j]+(i+1), ' ');
            }

        }
    }

    public Lepes[][] getTabla() {
        return tabla;
    }

    public int getM() {
        return m;
    }

    public static void setM(int am) {       // 3x3 ... 6x6
        if (am > 2 && am < 7) {
            m = am;
        } else {
            m = 3;
        }
    }

    public void setTablaCella(Lepes cella) {
        
        this.tabla[cella.getSor()][cella.getOszlop()] = cella;
    }

    public String[] getBETUK() {
        return BETUK;
    }  
    
}
