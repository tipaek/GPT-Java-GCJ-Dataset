import java.util.*;
import java.io.*;

class Czynnosc {
    int start;
    int end;
    char osoba;

    Czynnosc() {

    }

    Czynnosc(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Solution {
public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        //in.nextLine();

        for(int tt = 0; tt < T; tt++) {
            int N = in.nextInt();
            String output = "";
            ArrayList<Czynnosc> czynnosci = new ArrayList<>();
            boolean impossible = false;
            for (int i = 0; i < N; i++) {
                int s, e;
                s = in.nextInt();
                e = in.nextInt();

                Czynnosc nowa = new Czynnosc(s,e);

                boolean kolizjaC = false;
                boolean kolizjaJ = false;
                for(Czynnosc czynnosc : czynnosci) {
                    if ((nowa.start >= czynnosc.start && nowa.start < czynnosc.end) // poczatek pomiedzy istniejacymi
                        || (nowa.end > czynnosc.start && nowa.end <= czynnosc.end)) { // koniec pomiedzy istniejacymi
                        switch(czynnosc.osoba) {
                            case 'C':
                                kolizjaC = true;
                                break;
                            case 'J':
                                kolizjaJ = true;
                                break;
                        }

                    }
                }
                if(kolizjaC) {
                    if(kolizjaJ) {
                        impossible = true;
                    } else {
                        nowa.osoba = 'J';
                        czynnosci.add(nowa);
                        output += 'J';
                    }
                } else {
                    // kolizjaJ
                    nowa.osoba = 'C';
                    czynnosci.add(nowa);
                    output += 'C';
                }
            }
            if(impossible)
                output = "IMPOSSIBLE";
            System.out.println("Case #" + (tt + 1) + ": " + output);
        }
    }
}
