import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for (int d = 1; d <= n; d++) {
            int b = sc.nextInt();
            int[][] a = new int[b][4];
            
            for (int i = 0; i < b; i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
                a[i][2] = i;
                a[i][3] = 0;
            }
            
            System.out.println("Case #" + d + ": " + nestedFun(a));
        }
    }

    public static String nestedFun(int[][] ar) {
        Arrays.sort(ar, (a, b) -> Integer.compare(a[0], b[0]));
        int c = 0, q = 0;
        StringBuilder sb = new StringBuilder();
        
        for (int[] interval : ar) {
            int start = interval[0];
            int end = interval[1];
            
            if (start >= c) {
                interval[3] = 1;
                c = end;
            } else if (start >= q) {
                interval[3] = 2;
                q = end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        Arrays.sort(ar, (a, b) -> Integer.compare(a[2], b[2]));
        
        for (int[] interval : ar) {
            sb.append(interval[3] == 1 ? "C" : "J");
        }
        
        return sb.toString();
    }
}