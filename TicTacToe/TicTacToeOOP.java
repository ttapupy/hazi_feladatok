package TicTacToe;
// @author vug

import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TicTacToeOOP {

    public static char nyertes(Tabla t) {
        int tempV;
        int tempF;
        int tempAB = 0;
        int tempAJ = 0;
        for (int i = 0; i < t.getTabla().length; i++) {
            tempV = 0;
            tempF = 0;
            for (int j = 0; j < t.getTabla().length; j++) {
                tempV += t.getTabla()[i][j];
                tempF += t.getTabla()[j][i];
                if (i == j) {
                    tempAB += t.getTabla()[i][j];
                }
                if (i + j == t.getM() - 1) {
                    tempAJ += t.getTabla()[i][j];
                }
            }
            if (tempV == t.getM() * 79 || tempF == t.getM() * 79) {     // méret * 'O' ascii értéke
                return 'O';
            } else if (tempV == t.getM() * 88 || tempF == t.getM() * 88) {
                return 'X';
            }
        }
        if (tempAB == t.getM() * 79 || tempAJ == t.getM() * 79) {
            return 'O';
        } else if (tempAB == t.getM() * 88 || tempAJ == t.getM() * 88) {
            return 'X';
        }
        return '#'; // döntetlen 
    }

    public static boolean vege(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] % 32 == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("*    Tic-Tac-Toe    *\n "
                + "Szabály: teljes sor kirakása a saját jellel (vízszintesen, függőlegesen vagy átlósan).");
        Scanner sc = new Scanner(System.in);
        System.out.print("Válassz pályaméretet (3,4,5,6): ");
        Tabla.setM(sc.nextInt());
        sc.nextLine();
        System.out.print("A géppel szeretnél játszani (1) vagy valaki mással (2) ?  ");
        boolean gep;
        String nev2 = "Snoopy";
        if (sc.nextInt() == 2) {
            gep = false;
        } else {
            gep = true;
            nev2 = "GÉP";
        }
        sc.nextLine();
        Tabla palya = new Tabla();
        palya.rajzol();
        int kor = 0;
        Jatekos j1 = new Jatekos(nev2, 'x', gep);
        Jatekos j2 = new Jatekos("Charlie", 'o', false);
        Jatekos[] jatekosok = {j1, j2};
        HashMap<Character, String> felold = new HashMap<Character, String>();
        felold.put(j1.getJel(), j1.toString());
        felold.put(j2.getJel(), j2.toString());
        felold.put('#', "döntetlen");
        Lepes lep = new Lepes();
        String lepes;
        while (!vege(palya.getTabla()) && nyertes(palya) == '#') {       //nincs vége és még nincs nyertes ("döntetlen")

            if (jatekosok[kor].isGepi()) {
                System.out.print(
                        jatekosok[kor] + " lép: ");
                lep.gepiLepes(palya);
                System.out.println(" " + lep.getLepes());
                palya.setTablaCella(lep.getSor(), lep.getOszlop(), 'X');
                kor = 1;
                try {
                    Thread.sleep(1200);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            } else {
                System.out.print(
                        jatekosok[kor] + " jön. Add meg az elfoglalni kívánt cellát: ");

                Lepes jlep = new Lepes("huhu");
                do {
                    lepes = sc.nextLine();
                    //System.out.println(lepes);
                    //System.out.println(jlep);
                    jlep.setLepes(palya, lepes);
                    //System.out.println("és  " + jlep);
                    if (!jlep.checkStep(palya)) {
                        System.out.print(" # hibás adat # újra: ");
                    }
                } while (!jlep.checkStep(palya));
                if (kor == 0) {
                    palya.setTablaCella(jlep.getSor(), jlep.getOszlop(), 'X');
                    kor = 1;
                } else {
                    palya.setTablaCella(jlep.getSor(), jlep.getOszlop(), 'O');
                    kor = 0;
                }

            }

            System.out.println();
            palya.rajzol();

        }
        System.out.println("Vége. A győztes: " + felold.get(nyertes(palya)));

    }
}
