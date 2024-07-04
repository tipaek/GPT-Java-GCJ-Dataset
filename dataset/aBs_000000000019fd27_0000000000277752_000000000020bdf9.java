import java.util.ArrayList;
import java.util.BitSet;
import java.util.Scanner;

public class Solution {
    static final int SIZE = 1441;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = scanner.nextInt();
            String answer = "";
            ArrayList<BitSet> slots = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                int s = scanner.nextInt();
                int e = scanner.nextInt();
                BitSet b = new BitSet(SIZE);
                for (int k = s; k < e; k++) {
                    b.set(k,true);
                }
                slots.add(b);
            }
            if (N == 2) {
                answer = "CJ";
            }else {
                boolean done = false;
                String other = "C";
                for (int j = 0; j < N-2 && !done; j++) {
                    BitSet a = slots.get(j);
                    for (int k = j+1; k < N && !done; k++) {
                        BitSet b = slots.get(k);
                        BitSet t = (BitSet)a.clone();
                        t.and(b);
                        if (t.cardinality() > 0) {
                            if (other.charAt(j)=='C')
                                other+="J";
                            else
                                other+="C";
                            for (int l = k+1; l < N && !done; l++) {
                                BitSet t2 = (BitSet)t.clone();
                                BitSet c = slots.get(l);
                                t2.and(c);
                                if (t2.cardinality() > 0)
                                    done = true;
                            }
                        }
                    }
                }
                if (done)
                    answer = "IMPOSSIBLE";
                else {
                    int r = N-other.length();
                    for(int m = 0; m < r; m++) {
                        other+="C";
                    }
                    answer = other;
                }
            }
            System.out.printf("Case #%d: %s\n", i, answer);
        }
    }
}