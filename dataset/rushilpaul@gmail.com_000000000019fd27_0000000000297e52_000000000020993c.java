import java.util.*;

class Solution {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            int ar[][] = new int[n][n];
            
            int trace = 0;
            int r = 0, c = 0;
            Set<Integer> set = new HashSet();
            
            for(int i = 0; i < n; i++) {
                set.clear();
                for(int j = 0; j < n; j++) {
                    ar[i][j] = sc.nextInt();
                    if(i == j)
                        trace += ar[i][j];
                    set.add(ar[i][j]);
                }
                if(set.size() < n)
                    r++;
            }
            
            for(int j = 0; j < n; j++) {
                set.clear();
                for(int i = 0; i < n; i++)
                    set.add(ar[i][j]);
                if(set.size() < n)
                    c++;
            }
            System.out.printf("Case #%d: %d %d %d\n", t, trace, r, c);
        }
    }
}