import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    
    static PrintWriter out;

    public static void main(String[] args)  {
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        out = new PrintWriter(System.out);
        for (int t = 1; t <= count; t++) {
            out.print("Case #" + t + ": ");
            solve(s, out);
        }
        out.close();
    }

    static void solve(Scanner sc, PrintWriter out) {
        int c = sc.nextInt();
        int d = sc.nextInt();
        int[] x = new int[c];
        int[][] e = new int[d][2];
        int[] l = new int[d];
        int[] s = new int[c];
        boolean simple = true;
        for(int i=1; i<c; i++) {
            x[i] = -sc.nextInt();
            if(x[i] <= 0) simple = false;
        }
        for(int i=0; i<d; i++) {
            e[i][0] = sc.nextInt()-1;
            e[i][1] = sc.nextInt()-1;
            l[i] = 1000000;
        }

        if(simple) {
            for (int i = 0; i < c; i++) {
                s[i] = x[i] * 1000;
            }
            for (int j = 0; j < d; j++) {
                int diff = Math.abs(s[e[j][0]] - s[e[j][1]]);
                l[j] = Math.max(diff, 1);
            }
            for (int j = 0; j < d; j++) {
                if (j > 0)
                    out.print(" ");
                out.print(l[j]);
            }
            out.println();
            return;
        }

        List<Integer> f = new ArrayList<>();
        for(int i=1; i<c; i++) {
            if(x[i] < 0) {
                f.add(-x[i]);
                s[i] = -x[i];
            }
        }
        Collections.sort(f);
        int last = 0;
        int ls = 0;
        int fpos = 0;
        boolean lastfix = true;
        for(int i=1; i<c; ) {
            int count = 0;
            for(int j=0; j<c; j++) {
                if(x[j] == i) count++;
            }
            if(count>0) {
                ls++;
                for(int j=0; j<c; j++) {
                    if(x[j] == i) {
                        s[j] = ls;
                    }
                }
                last = i;
                i+=count;
                lastfix = false;
                continue;
            }
            int same = 1;
            for(int k=fpos+1; k<f.size(); k++) {
                if(f.get(fpos).equals(f.get(k))) same++;
            }
            if(lastfix) {
                last = i;
                ls = f.get(fpos);
                fpos+=same;
                i+=same;
            } else {
                for(int j=0; j<c; j++) {
                    if(x[j] == last) {
                        s[j] = f.get(fpos);
                    }
                }
                ls = f.get(fpos);
                fpos+=same;
                i+=same;
                lastfix = true;
            }
        }
        for (int j = 0; j < d; j++) {
            int diff = Math.abs(s[e[j][0]] - s[e[j][1]]);
            l[j] = Math.max(diff, 1);
        }
        for (int j = 0; j < d; j++) {
            if (j > 0)
                out.print(" ");
            out.print(l[j]);
        }
        out.println();

    }

}
