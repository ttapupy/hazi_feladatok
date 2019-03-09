package consolecommander;
// @author vug

import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsoleCommander {

    

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String program = "J";
        String defPath = "/home/vug/Dropbox/Programozas";
        Library clib = new Library(defPath);
        Library temp = new Library(defPath);
        while (true) {
            System.out.println("\n" + String.join("", Collections.nCopies(65, "-")) + "\nKilépés: Q");
            try {
                System.out.println(clib.getPath().getCanonicalPath() + "\n" + String.join("", Collections.nCopies(65, "-")));
            } catch (IOException ex) {
                Logger.getLogger(ConsoleCommander.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Érvénytelen útvonal!");
            }
            clib.listaz();
            System.out.println();
            System.out.print("Könyvtár váltáshoz vagy fájl betekintéshez válassz sorszámot (Kilépés: Q): ");
            int kt = -1;
            do {
                program = sc.nextLine();
                if (program.toUpperCase().equals("Q")) {
                    System.exit(0);
                }
                try {
                    kt = Integer.parseInt(program);
                } catch (NumberFormatException e) {
                    kt = -1;
                }
                if (kt < 0 || kt > clib.getLib().length) {
                    System.out.print("# hibás adat #\nújra: ");
                }
            } while (kt < 0 || kt > clib.getLib().length);

            if (kt == 0) {
                temp.setLibrary(clib.getParent());
            } else if (clib.getLib()[kt - 1].isDirectory()) {
                temp.setLibrary(clib.getLib()[kt - 1]);
            } else {
                clib.nezoke(kt-1);
                String nezokeBezar;
                System.out.println("Kilépés: enter");
                do{
                nezokeBezar = sc.nextLine();}
                while (nezokeBezar.equals(null));
                
                
//                File nyit = clib.getLib()[kt-1];
//                try {
//                    Desktop.getDesktop().open(nyit);
//                } catch (IOException ex) {
//                    System.out.println("A fájlt nem lehet megnyitni!");
//                    Logger.getLogger(ConsoleCommander.class.getName()).log(Level.SEVERE, null, ex);
//                }
            }
            clib.setLibrary(temp.getPath());

        }

    }

}
