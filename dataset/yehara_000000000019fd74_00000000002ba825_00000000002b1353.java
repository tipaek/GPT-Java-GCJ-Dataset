import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    
    static PrintWriter out;
    static long[][] c;

    public static void main(String[] args)  {

        c = new long[33][33];
        c[1][1] = 0;
        for(int i=2; i<=32; i++) {
            c[i][1] = c[i][i] = 1;
            for(int j=2; j<=i-2; j++) {
                c[i][j] = c[i-1][j-1]+c[i-1][j];
            }
        }

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

        out.println();
        int n = sc.nextInt();
        if(n <= 10) {
            for(int i=1; i<=n; i++) {
                out.println(i + " 1");
            }
            return ;
        }

        out.println("1 1");
        n --;
        int pos = 1;
        while(n > 0) {
            if(n < pos) {
                for(int i=0; i<n; i++) {
                    int r = pos + i;
                    int c = 1;
                    out.println(r + " " + c);
                }
                return;
            }
            out.println((pos + 1) + " 2");
            n-=pos;
            pos++;
        }
    }

}
