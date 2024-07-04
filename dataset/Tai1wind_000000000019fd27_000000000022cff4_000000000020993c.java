import java.util.*;
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int cas = 0; cas < t; cas++){
        int r = sc.nextInt();
        int c = r;
        int[][] matrix = new int[r][c];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int trace = 0;
        for(int i = 0; i<r; i++){
            trace += matrix[i][i];
        }
        int badrows = 0;
        for(int i = 0; i < r; i++){//check each row
            boolean[] used = new boolean[r + 1];
            for(int j = 0; j < c; j++) {
                int item = matrix[i][j];
                if (used[item]) {
                    badrows += 1;
                    break;
                }
                used[item] = true;
            }
        }
        int badcol = 0;
        for(int i = 0; i < c; i++){
            boolean[] used = new boolean[r + 1];
            for(int j = 0; j < r; j++){
                int item = matrix[j][i];
                if(used[item]){
                    badcol += 1;
                    break;
                }
                used[item] = true;
            }
        }
        System.out.println("Case #" + (cas + 1) + ": " + trace + " " + badrows + " " + badcol);
    }
    }
}
