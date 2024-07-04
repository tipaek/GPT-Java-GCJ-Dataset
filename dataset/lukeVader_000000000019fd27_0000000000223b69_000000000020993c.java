import java.util.*;

public class Solution{
    
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(;t > 0; t--) {
            int x = sc.nextInt();
            int[][] mat = new int[x][x];
            for (int i = 0; i < x; i++){
                for(int j = 0; j < x; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            int trace = 0, row = 0, col = 0;
            HashSet<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < x; i++){
                set.clear();
                trace += mat[i][i];
                for (int j = 0; j < x; j++) {
                    if (set.contains(mat[i][j])) {
                        row++;
                        break;
                    } else {
                        set.add(mat[i][j]);
                    }
                }
                set.clear();
                for (int j = 0; j < x; j++) {
                    if (set.contains(mat[j][i])) {
                        col++;
                        break;
                    } else {
                        set.add(mat[j][i]);
                    }
                }
            }
            System.out.println("Case #" + t + ": " + trace +" "+row+" "+col);
        }
    }
}