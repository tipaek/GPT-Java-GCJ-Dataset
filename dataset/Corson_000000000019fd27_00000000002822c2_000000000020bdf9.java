import java.util.*;
import java.io.*;

class Czynnosc {
    int start;
    int end;
    char osoba;
    int kolejnosc;

    Czynnosc(int start, int end, int kolejnosc) {
        this.start = start;
        this.end = end;
        this.kolejnosc = kolejnosc;
    }
}

class SortowanieCzynnosci implements Comparator<Czynnosc> {
    @Override
    public int compare(Czynnosc czynnosc, Czynnosc t1) {
        if (czynnosc.start < t1.start) {
            return -1;
        } else if (czynnosc.start > t1.start) {
            return 1;
        } else {
            if (czynnosc.end < t1.end) {
                return -1;
            } else if (czynnosc.end > t1.end) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}

class OdwrocenieSortowania implements Comparator<Czynnosc> {
    @Override
    public int compare(Czynnosc czynnosc, Czynnosc t1) {
        if (czynnosc.kolejnosc < t1.kolejnosc)
            return -1;
        else if (czynnosc.kolejnosc > t1.kolejnosc)
            return 1;
        else
            return 0;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        for(int tt = 0; tt < T; tt++) {
            int N = in.nextInt();
            String output = "";
            ArrayList<Czynnosc> czynnosci = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                int s, e;
                s = in.nextInt();
                e = in.nextInt();

                czynnosci.add(new Czynnosc(s,e,i));
            }

            // trzeba to sortowanie odwrocic pozniej
            czynnosci.sort(new SortowanieCzynnosci());

            int maxJ = 0;
            int maxC = 0;
            boolean impossible = false;

            for (int i = 0; i < N; i++) {
                Czynnosc czynnosc = czynnosci.get(i);
                if (czynnosc.start >= maxJ) {
                    maxJ = czynnosc.end;
                    czynnosc.osoba = 'J';
                } else if (czynnosc.start >= maxC) {
                    maxC = czynnosc.end;
                    czynnosc.osoba = 'C';
                } else {
                    impossible = true;
                }
                czynnosci.set(i, czynnosc);
            }
            if (impossible) {
                System.out.println("Case #" + (tt + 1) + ": IMPOSSIBLE");
            } else {
                czynnosci.sort(new OdwrocenieSortowania());
                for(Czynnosc czynnosc : czynnosci) {
                    output+= czynnosc.osoba;
                }
                System.out.println("Case #" + (tt + 1) + ": " + output);
            }
        }
    }
}
