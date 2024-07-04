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
        String[] mid = new String[n];

        String l = "";
        String r = "";

        for(int i=0; i<n; i++) {
            String a = sc.next();
            int p1 = a.indexOf('*');
            int p2 = a.lastIndexOf('*');
            left[i] = a.substring(0, p1);
            if(l.length() < left[i].length()) {
                l = left[i];
            }
            right[i] = a.substring(p2 + 1);
            if(r.length() < right[i].length()) {
                r = right[i];
            }
            if(p1 == p2) {
                mid[i] = "";
            } else {
                mid[i] = a.substring(p1+1, p2).replaceAll("\\*", "");
            }

        }
        for(int i=0; i<n; i++) {
            if(!l.startsWith(left[i]) || !r.endsWith(right[i])) {
                out.println("*");
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(l);
        for (int i = 0; i < n; i++) {
            sb.append(mid[i]);
        }
        sb.append(r);
        out.println(sb.toString());
    }

}
