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

        int n = sc.nextInt();
        String[] left = new String[n];
        String[] right = new String[n];

        String l = "";
        String r = "";

        for(int i=0; i<n; i++) {
            String a = sc.next();
            int pos = a.indexOf('*');
            left[i] = a.substring(0, pos);
            if(l.length() < left[i].length()) {
                l = left[i];
            }
            right[i] = a.substring(pos + 1);
            if(r.length() < right[i].length()) {
                r = right[i];
            }
        }
        for(int i=0; i<n; i++) {
            if(!l.startsWith(left[i]) || !r.endsWith(right[i])) {
                out.println("*");
                return;
            }
        }
        out.println(l + r);
    }

}
