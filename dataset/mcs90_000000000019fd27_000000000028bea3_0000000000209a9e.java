import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        int B = s.nextInt();
        for (int t = 1; t <= T; ++t) {
            new Solution().solve(s, B);
        }
    }
    
    private int[] a;
    
    public void solve(Scanner scanner, int B) {
        a = new int[B+1];

        int same = -1;
        int diff = -1;
        
        int p = 1;
        for (int q = 0; p <= B / 2; q += 2, ++p) {
            if (q > 0 && q % 10 == 0) {
                q += adjustArray(same, diff, scanner);
            }
            
            int left = query(p, scanner);
            int right = query(B - p + 1, scanner);
            a[p] = left;
            a[B - p + 1] = right;
            
            if (left == right) {
                same = p;
            } else {
                diff = p;
            }
        }
        
        String res = "";
        for (int b : a) {
            res += b;
        }
        System.out.println(res.substring(1));
        scanner.next();
    }
    
    private int adjustArray(int same, int diff, Scanner s) {
        int q = 0;
        if (same > 0) {
            int b = query(same, s);
            q++;
            if (diff > 0) {
                int bDiff = query(diff, s);
                q++;
                boolean x = (b != a[same]);
                boolean y = (bDiff != a[diff]);
                if (x && y) {
                    flip();
                } else if (x) {
                    flip();
                    rev();
                } else if (y) {
                    rev();
                }
            } else {
                if (b != a[same]) {
                    flip();
                }
            }
        } else {
            int b = query(diff, s);
            q++;
            if (b != a[diff]) {
                flip(); // or rev, same thing
            }
        }
        if (q == 1) {
            query(1, s);
        }
        return 2;
    }
    
    private int query(int query, Scanner scanner) {
        System.out.println(query);
        return scanner.nextInt();
    }
    
    private void rev() {
        int n = a.length - 1;
        for (int i = 1; i <= n / 2; ++i) {
            int t = a[i];
            a[i] = a[n - i + 1];
            a[n - i + 1] = t;
        }
    }
    
    private void flip() {
        for (int i = 0; i < a.length; ++i) {
            a[i] = 1 - a[i];
        }
    }
}