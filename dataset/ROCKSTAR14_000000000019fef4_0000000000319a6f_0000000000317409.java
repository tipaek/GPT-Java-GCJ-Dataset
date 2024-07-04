import java.util.*;

/**
 * 02/05/20
 * Created by Himanshu
 **/
public class Solution {
    static class pair {
        int a , b;
        pair(int a , int b) {
            this.a = a;
            this.b = b;
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int q = 1;q<=t;q++) {
            System.out.print("Case #" + q + ": ");
            int x = s.nextInt();
            int y = s.nextInt();
            String str = s.next();
            if (x == 0 && y == 0) {
                System.out.println(0);
                continue;
            }
            int ans = Integer.MAX_VALUE;
            for (int i=0;i<str.length();i++) {
                char c = str.charAt(i);
                pair p = nextStep(c);
                x = x + p.a;
                y = y + p.b;
                if (Math.abs(x) + Math.abs(y) <= (i+1)) {
                    ans = i+1;
                    break;
                }
            }
            if (ans != Integer.MAX_VALUE) System.out.println(ans);
            else System.out.println("IMPOSSIBLE");
        }
    }
    private static pair nextStep(char c) {
        if (c == 'N') return new pair(0,1);
        else if (c == 'S') return new pair(0,-1);
        else if (c == 'E') return new pair(1,0);
        else if (c == 'W') return new pair(-1,0);
        return new pair(0,0);
    }
}
