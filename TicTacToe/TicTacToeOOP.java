package TicTacToe;
// @author vug
// * 2 személyes vagy gép elleni Tic Tac Toe választható pályamérettel *

import java.util.HashMap;
import java.util.Scanner;


public class TicTacToeOOP {

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
        HashMap<Character, String> felold = new HashMap<>();    //az eredmény kiírásához
        felold.put(j1.getJel(), j1.toString());
        felold.put(j2.getJel(), j2.toString());
        felold.put('#', "döntetlen");
        Lepes lep = new Lepes();
        String lepes;
        char jel= 'X';
        while ((!palya.vege()) && palya.nyertes() == '#') {    //nincs vége és még nincs nyertes ("döntetlen")

            if (jatekosok[kor].isGepi()) {
                System.out.print(
                        jatekosok[kor] + " lép: ");
                lep.gepiLepes(palya, jel);
                System.out.println(" " + lep.getLepes());
                palya.setTablaCella(lep);
                kor = 1;
                jel = 'O';
                try {
                    Thread.sleep(1200);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    System.out.println(ex);
                }
            } else {
                System.out.print(
                        jatekosok[kor] + " jön. Add meg az elfoglalni kívánt cellát: ");

                Lepes jlep = new Lepes("huhu", 'w');    //érvénytelenre állítom a lépést
                do {
                    lepes = sc.nextLine();
                    jlep.setLepes(palya, lepes, jel);
                    if (!jlep.checkStep(palya)) {
                        System.out.print(" # hibás adat # újra: ");
                    }
                } while (!jlep.checkStep(palya));
                if (kor == 0) {
                    palya.setTablaCella(jlep);
                    kor = 1;
                    jel = 'O';
                } else {
                    palya.setTablaCella(jlep);
                    kor = 0;
                    jel = 'X';
                }

            }

            System.out.println();
            palya.rajzol();

        }
        System.out.println("Vége. A győztes: " + felold.get(palya.nyertes()));

    }
}
