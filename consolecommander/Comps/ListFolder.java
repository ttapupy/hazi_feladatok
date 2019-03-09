package Comps;
// @author vug

import java.io.File;
import java.util.Comparator;


public class ListFolder implements Comparator<File>{

    @Override
    public int compare(File o1, File o2) {
        if (o1.isDirectory()==o2.isDirectory()) {
            return o1.getName().compareToIgnoreCase(o2.getName());
        } 
        if (o1.isDirectory()) {
            return -1;
        } else {
            return 1;
        }
    }
    

}
