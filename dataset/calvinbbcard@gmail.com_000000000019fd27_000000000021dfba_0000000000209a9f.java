import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int t = reader.nextInt();
        int c = 1;
        while (c <= t) {
            String s = reader.next();
            StringBuilder solution = new StringBuilder();
            int curr = s.charAt(0) - '0';
            for (int i=0;i<curr;i++) solution.append("(");
            solution.append("" + curr);
            for (int i=1;i<s.length();i++) {
                int prev = curr;
                curr = s.charAt(i) - '0';
                int diff = curr - prev;
                if (diff > 0) for (int j=0;j<diff;j++) solution.append("(");
                if (diff < 0) for (int j=0;j<-diff;j++) solution.append(")");
                solution.append("" + curr);
            }
            for (int i=0;i<curr;i++) solution.append(")");
            System.out.printf("Case #%d: %s\n", c++, solution);
        }
    }
}