
package datumoop;

// @author vug
public class DatumOOP {

    // other stuff
    
    public static void main(String[] args) {
        Datum maiD = new Datum(2019, 02, 21);
        System.out.println(maiD);
        System.out.println(maiD.szokoev());
        
        Datum[] datumok =new Datum[6];
        datumok[0] = maiD;
        datumok[1] = new Datum(2019, 02, 18);
        datumok[2] = new Datum(2019, 05, 24);
        datumok[3] = new Datum(2019, 01, 03);
        datumok[4] = new Datum(2019, 04, 03);
        datumok[5] = new Datum(2033, 1, 01);
        for (Datum datum : datumok) {
            System.out.println(datum);
        }
        Datum a = datumok[1];
        Datum b = datumok[2];
        Datum c = datumok[3];
        Datum d = datumok[4];
        Datum e = datumok[5];
        System.out.println(maiD+" és "+a+" különbsége napokban: "+maiD.kulonbseg(a));
        System.out.println(maiD+" és "+b+" különbsége napokban: "+maiD.kulonbseg(b));
        System.out.println(maiD+" és "+c+" különbsége napokban: "+maiD.kulonbseg(c));
        System.out.println(maiD+" és "+d+" különbsége napokban: "+maiD.kulonbseg(d));
        System.out.println(maiD+" és "+e+" különbsége napokban: "+maiD.kulonbseg(e));

        
    }
}
