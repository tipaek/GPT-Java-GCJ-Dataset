import java.util.*;
import java.io.*;

public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int k = 1; k <= t; k++) {
            int n = in.nextInt();

            boolean impossible = false;
            StringBuilder res=new StringBuilder();

            BitSet bj = new BitSet((24*60)+1);
            BitSet bc = new BitSet((24*60)+1);
            for (int i=0; i<n; i++){
                int ini = in.nextInt();
                int end = in.nextInt();

                if (impossible) {
                    continue;
                }

                //System.out.println("ini: "+ini+ " end: "+end);
                int nextJ = bj.nextSetBit(ini);
                //System.out.println("nextJ: "+nextJ);
                boolean intersectJ = nextJ >= ini && nextJ < end;
                if (!intersectJ) {
                    bj.set(ini, end);
                    res.append('J');
                    continue;
                }

                int nextC = bc.nextSetBit(ini);
                //System.out.println("nextC: "+nextC);
                boolean intersectC = nextC >= ini && nextC < end;
                if (!intersectC) {
                    bc.set(ini, end);
                    res.append('C');
                    continue;
                }

                impossible=true;
            }

            if (impossible) {
                System.out.println("Case #" + k + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + k + ": " + res.toString());
            }
        }
    }
}