package TicTacToe;
// @author vug

public class Tabla {

    private static int M=3; // méret
    private static String[] betuk = {"A", "B", "C", "D", "E", "F"};
    private char[][] tabla = new char[M][M];

    public void rajzol() {

        System.out.print("    ");
        for (int i = 1; i <= M; i++) {
            System.out.print(i + "   ");
        }
        System.out.print("\n  +");
        for (int j = 0; j < M; j++) {
            for (int i = 0; i < M; i++) {
                System.out.print("---+");
            }
            System.out.println();
            System.out.print(betuk[j]);
            for (int i = 0; i < M; i++) {
                System.out.print(" | " + tabla[j][i]);
            }
            System.out.print(" |\n  +");
        }
        for (int i = 0; i < M; i++) {
            System.out.print("---+");
        }
        System.out.println();
    }

    public Tabla() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                tabla[i][j] = ' ';
            }

        }
    }

    public char[][] getTabla() {
        return tabla;
    }

    public int getM() {
        return M;
    }

    public static void setM(int aM) {       // 3x3 ... 6x6
        if (aM > 2 && aM < 7) {
            M = aM;
        } else {
            M = 3;
        }
    }

    public void setTablaCella(int sor, int oszlop, char jel) {
        this.tabla[sor][oszlop] = jel;
    }

    public String[] getBetuk() {
        return betuk;
    }

}
