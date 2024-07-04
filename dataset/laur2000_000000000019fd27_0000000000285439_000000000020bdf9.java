import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
 
public class ej3 {
 
    public static void main(String[] args) {
 
 
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        int ncases = 1;
       
        while(ncases <= cases) {
            String guy = "C";
            int tasks = sc.nextInt();
           
            String res = "";
            List<Pair> ls = new ArrayList<>();
           
            for(int x = 0; x<tasks; x++) {
                Pair p = new Pair(sc.nextInt(),sc.nextInt(),x);
                ls.add(p);
            }
            Collections.sort(ls);
            int init = 0;
            int fin = 0;
            int otherInit = 0;
            int otherFin = 0;
            boolean imposible = false;
            for(int x = 0; x<ls.size(); x++) {
                int nextInit = ls.get(x).getV1();
                int nextFin = ls.get(x).getV2();
               
                if (nextInit<fin) {
                    if(nextInit<otherFin) {
                        imposible = true;
                        break;
                    }
                    else {
                    if(guy.equals("C"))
                        guy = "J";
                    else
                        guy = "C";
                    otherInit = init;
                    otherFin = fin;
                    init = nextInit;
                    fin = nextFin;
                    ls.get(x).setLetter(guy);
                    }
                }
               
                else {
                   
                    ls.get(x).setLetter(guy);
                    init = nextInit;
                    fin = nextFin;
                   
                }
                   
            }
           
            if(imposible)
                System.out.println("Case #" + ncases + ": IMPOSSIBLE");
            else {
               
                Collections.sort(ls, Comparator.comparing(x->x.getIndex()));
               
                for(int i = 0; i<ls.size(); i++) {
                    res += ls.get(i).getLetter();
                }
               
                System.out.println("Case #" + ncases + ": "+res);
            }
               
           
           
            ncases++;
           
        }
        sc.close();
    }
 
}
 
class Pair implements Comparable<Pair>{
   
    private Integer v1;
    private Integer v2;
    private Integer index;
    private String letter;
 
   
   
    public Integer getIndex() {
        return index;
    }
    public int getV1() {
        return v1;
    }
    public void setV1(Integer v1) {
        this.v1 = v1;
    }
    public int getV2() {
        return v2;
    }
    public void setIndex(Integer index) {
        this.index = index;
    }
    public void setLetter(String letter) {
        this.letter = letter;
    }
    public String getLetter() {
        return letter;
    }
    public void setV2(Integer v2) {
        this.v2 = v2;
    }
    public Pair(Integer v1, Integer v2, Integer index) {
        super();
        this.v1 = v1;
        this.v2 = v2;
        this.index = index;
        this.letter = "";
   
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + v1;
        result = prime * result + v2;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pair other = (Pair) obj;
        if (v1 != other.v1)
            return false;
        if (v2 != other.v2)
            return false;
        return true;
    }
    @Override
    public int compareTo(Pair o) {
       
        return this.v1.compareTo(o.getV1());
       
    }
    @Override
    public String toString() {
        return "Pair [v1=" + v1 + ", v2=" + v2 +  "]";
    }
}