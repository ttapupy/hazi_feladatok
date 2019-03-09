package consolecommander;
// @author vug

import Comps.ListFolder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Arrays;
import java.util.Collections;

public class Library {

    private File path;
    private File[] lib;
    private File parent;

    public void listaz() {
        Arrays.sort(lib, new ListFolder());
        System.out.println(" 0.  [...]");
        for (int i = 0; i < lib.length; i++) {
            String n = lib[i].getName();
            String ext = "";
            int l = n.length();
            if (l > 45) {
                ext = "..." + n.substring(l - 3, l);
                l = 45;
                n = n.substring(0, l - 3);

            }
            if (lib[i].canRead()) {
                String fn = (lib[i].isFile() ? n + ext : "[ " + n + " ]");
                String size = (lib[i].isFile() ? (int)((double) lib[i].length() / 1024 + 1) + " KB" : lib[i].listFiles().length + " elem");
                System.out.println(((i + 1) < 10 ? " " + (i + 1) : (i + 1)) + ".  " + fn + String.join("", Collections.nCopies(60 - size.length() - fn.length(), " ")) + size);
            }
        }
    }

    public Library() {

    }

    public Library(String path) {
        this.path = new File(path);
        this.lib = this.path.listFiles();
        this.parent = this.path.getParentFile();
    }

    public void nezoke(int listElement) {

        try {
            LineNumberReader lr = new LineNumberReader(new InputStreamReader(new FileInputStream(this.getLib()[listElement].getPath()), "UTF-8"));
            String sor;
            System.out.println("\n" + this.getLib()[listElement].getPath() + "  :: Nézőke: \n");
            while (((sor = lr.readLine()) != null) && lr.getLineNumber() <= 8) {
                System.out.println(sor);
            }
            System.out.println(".\n.\n.");
            lr.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Nem találom a megadott fájlt! " + ex);
        } catch (IOException ex) {
            System.out.println("I/O hiba! " + ex);
        }

    }

    public File[] getLib() {
        return lib;
    }

    public void setLibrary(File path) {
        this.path = path;
        this.lib = path.listFiles();
        this.parent = this.path.getParentFile();
    }

    public File getPath() {
        return path;
    }

    public File getParent() {
        return parent;
    }

}
