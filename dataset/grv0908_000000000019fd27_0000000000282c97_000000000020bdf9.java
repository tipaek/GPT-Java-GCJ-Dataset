import java.util.*;
class Solution {
    static class Pair {
        int x;
        int y;
        int index;
        Pair (int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int tc = sc.nextInt();
        
        for (int test = 1; test <= tc; test++) {
            int n = sc.nextInt();
            
            Pair[] timings = new Pair[n];
            
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                
                timings[i] = new Pair(x, y, i);
            }
            
            Arrays.sort(timings, new Comparator<Pair>(){
                public int compare(Pair p1, Pair p2) {
                    return p1.x - p2.x;
                }
            });
            
            int j_last = 0;
            int c_last = 0;
            
            boolean isPossible = true;
            char[] ans = new char[n];
            
            for (int i = 0; i < n; i++) {
                Pair p = timings[i];
                
                if (p.x < j_last && p.x < c_last) {
                    isPossible = false;
                    break;
                }
                
                if (p.x >= j_last) {
                    ans[p.index] = 'J';
                    j_last = p.y;
                } else {
                    ans[p.index] = 'C';
                    c_last = p.y;
                }
            }
            
            if (!isPossible) {
                System.out.println("Case #" + test + ": " + "IMPOSSIBLE");
            } else {
                System.out.println("Case #" + test + ": " + new String(ans));
            }
        }
    }
}