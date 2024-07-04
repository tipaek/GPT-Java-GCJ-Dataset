import java.io.PrintWriter;
import java.util.ArrayList;
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

        int r = sc.nextInt();
        int s = sc.nextInt();

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        int res = 0;

        for(int rr = r; rr>=2; rr--) {
            for(int i=0; i<s-1; i++) {
                int nums = rr * s;
                a.add(nums - rr - i);
                b.add(rr-1);
            }
        }

        out.println(a.size());
        for(int i=0; i<a.size(); i++) {
            out.println(a.get(i) + " " + b.get(i));
        }
    }

}
