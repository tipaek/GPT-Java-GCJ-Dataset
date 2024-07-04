import java.util.BitSet;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T;t++) {
            int N = sc.nextInt();
            BitSet[] csets =  new BitSet[N];
            for (int i = 0; i<N;i++) {
                csets[i] = new BitSet(N);
            }

            int r = 0;
            int c = 0;
            int trace = 0;
            for (int i = 0;i < N;i++) {
                BitSet rset = new BitSet(N);
                for (int j = 0; j < N;j++) {
                    int x = sc.nextInt();

                    if (i == j) trace += x;

                    rset.set(x - 1);
                    csets[j].set(x - 1);
                }

                if (rset.cardinality() < N) r++;
            }

            for (int i = 0 ;i < N;i++) if (csets[i].cardinality() < N) c++;

            System.out.println("Case #" + t + ": " + trace + " " + r + " " + c);
        }
    }
}
