import java.io.PrintWriter;
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
        for(int i=1; i<c; i++) {
            x[i] = -sc.nextInt();
        }
        int[][] e = new int[d][2];
        int[] l = new int[d];
        for(int i=0; i<d; i++) {
            e[i][0] = sc.nextInt()-1;
            e[i][1] = sc.nextInt()-1;
            l[i] = 1000000;
        }
        int[] s = new int[c];
        for(int i=0; i<c; i++) {
            s[i] = x[i] * 1000;
        }
        for(int j=0; j<d; j++) {
            int diff = Math.abs(s[e[j][0]]-s[e[j][1]]);
            l[j] = Math.max(diff, 1);
        }
        for(int j=0; j<d; j++) {
            if(j > 0) out.print(" ");
            out.print(l[j]);
        }
        out.println();

    }

}
