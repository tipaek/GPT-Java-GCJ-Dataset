import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int t1 = 1; t1 <= t; t1++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            int[] arr = new int[n];
            int[][] mat = new int[n][n];
            HashMap<Integer, ArrayList<Integer>> row = new HashMap<>();
            HashMap<Integer, ArrayList<Integer>> col = new HashMap<>();
            
            int d = k / 3;
            int r = k % 3;
            
            for (int i = 0; i < n; i++) {
                int u = d;
                if (r > 0) {
                    u++;
                    r--;
                }
                arr[i] = u;
                
                row.computeIfAbsent(i, k1 -> new ArrayList<>()).add(u);
                col.computeIfAbsent(i, k1 -> new ArrayList<>()).add(u);
                
                mat[i][i] = arr[i];
            }
            
            boolean isPossible = true;
            
            for (int i = 0; i < n && isPossible; i++) {
                for (int j = 0; j < n; j++) {
                    TreeSet<Integer> tr = new TreeSet<>();
                    tr.addAll(col.get(j));
                    tr.addAll(row.get(i));
                    
                    int h1 = tr.first();
                    int h2 = tr.last();
                    
                    int h = 0;
                    if (h1 > 1) {
                        h = h1 - 1;
                    } else if (h2 < n) {
                        h = h2 + 1;
                    }
                    
                    if (h == 0) {
                        isPossible = false;
                        break;
                    }
                    
                    if (mat[i][j] == 0) {
                        mat[i][j] = h;
                    }
                    
                    row.get(i).add(mat[i][j]);
                    col.get(j).add(mat[i][j]);
                }
            }
            
            String ans = isPossible ? "POSSIBLE" : "IMPOSSIBLE";
            System.out.println("Case #" + t1 + ": " + ans);
            if (isPossible) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(mat[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }
        sc.close();
    }
}