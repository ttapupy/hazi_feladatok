// dátum osztály
package datumoop;

// @author vug
public class Datum {

    private int ev;
    private int honap;
    private int nap;

    public Datum() {
    }

    public Datum(int ev, int honap, int nap) {
        this.ev = ev;
        this.honap = honap;
        this.nap = nap;
    }

    @Override
    public String toString() {
        return ev + "." + (honap > 9 ? honap : "0" + honap) + "." + (nap > 9 ? nap : "0" + nap) +
                ".";
    }

    public boolean szokoev() {
        if (this.ev % 400 == 0) {
            return true;
        } else if (this.ev % 100 == 0) {
            return false;
        } else if (this.ev % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    private int evHossz(Datum d) {      //év napértéke
        if (d.szokoev()) {
            return 366;
        } else {
            return 365;
        }
    }

    private int hoHossz(Datum d) {      //hónapok napértéke
        switch (d.honap) {
            case 1:
                return 31;
            case 2:
                return (this.szokoev() ? 29 : 28);
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 30;
            case 11:
                return 30;
            case 12:
                return 31;
            default:
                return 0;
        }
    }

    private Datum korabbi(Datum d2) {       //melyik a korábbi dátum a 2 közül
        if (this.ev<d2.ev) {
            return this;
        } else if (this.ev>d2.ev){
            return d2;  
        } else {
            if (this.honap<d2.honap) {
                return this;               
            } else if (this.honap>d2.honap) {
                return d2;
            } else {
                if (this.nap<=d2.nap) {
                    return this;
                } else {
                    return d2;
                }
            }    
        }
    }

    private Datum korabbiEv(Datum d2) {     // a kisebb évszámot tartalmazó dátum
        if (this.ev <= d2.ev) {
            return this;
        } else {
            return d2;
        }
    }

    private Datum korabbiHonap(Datum d2) {
        if (this.honap <= d2.honap) {
            return this;
        } else {
            return d2;
        }
    }

    private Datum korabbiNap(Datum d2) {
        if (this.nap <= d2.nap) {
            return this;
        } else {
            return d2;
        }
    }

    private Datum honapAd(Datum d, int step) {      // hónapok léptetéséhez adott dátumhoz képest
        Datum dd = new Datum(d.ev, d.honap + step, d.nap);
        return dd;
    }

    private Datum evAd(Datum d, int step) {     // évek léptetéséhez
        Datum dd = new Datum(d.ev + step, d.honap, d.nap);
        return dd;
    }

    public int kulonbseg(Datum d) {     //tádám
        Datum kEv = this.korabbiEv(d);
        Datum kHo = this.korabbiHonap(d);
        Datum kNap = this.korabbiNap(d);
        Datum elobb = this.korabbi(d);
        int napkul = Math.abs(d.nap - this.nap);
        int hokul = Math.abs(d.honap - this.honap);
        int evkul = Math.abs(d.ev - this.ev);;
        int hnn = 0;    //hónapkülönbség napokban
        int en = 0;     //évkülönbség napokban
        
        for (int i = 0; i < evkul; i++) {       //  a kisebbik évtől haladok a nagyobb felé
            en += evHossz(evAd(kEv, i));
        }

        for (int i = 0; i < hokul; i++) {   
            hnn += hoHossz(honapAd(kHo, i));
        }
        
        if (elobb.honap==kHo.honap) {       //ha a kisebb dátum hónapja egyben a kisebb hónap is 
            if (elobb.nap==kNap.nap) {
                return en + hnn + napkul;
            } else {
                return en + hnn - napkul;
            }
            
        } else {
            if (elobb.nap==kNap.nap) {
                return en - hnn + napkul;
            } else {
                return en - hnn - napkul;
            }
        }
    }

    public int getEv() {
        return ev;
    }

    public void setEv(int ev) {
        this.ev = ev;
    }

    public int getHonap() {
        return honap;
    }

    public void setHonap(int honap) {
        this.honap = honap;
    }

    public int getNap() {
        return nap;
    }

    public void setNap(int nap) {
        this.nap = nap;
    }

}
