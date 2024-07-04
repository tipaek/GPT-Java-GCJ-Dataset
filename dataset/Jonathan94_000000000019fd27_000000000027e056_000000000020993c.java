import java.util.*;
public class Solution{
    
    public static int[] computeAnswer(int m[][], int n){
        int ansForRow = 0;
        for (int i = 0; i < n ; i++) {
            boolean lookup[] = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                if(lookup[m[i][j]]){
                    ansForRow++;
                    break;
                }
                lookup[m[i][j]] = true;
            }
        }

        int ansForColum = 0;
        for (int i = 0; i < n ; i++) {
            boolean lookup[] = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                if(lookup[m[j][i]]){
                    ansForColum++;
                    break;
                }
                lookup[m[j][i]] = true;
            }
        }

        int k = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j){
                    k = k + m[i][j];
                }
            }
        }

        return new int[]{k, ansForRow, ansForColum};
    }
    public static void main(String args[]){
        
        Scanner sca = new Scanner(System.in);
        int t = sca.nextInt();
        int kase = 1;
        while(t-- > 0){
            int n = sca.nextInt();
            int matrix[][] = new int[n][n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    matrix[i][j] = sca.nextInt();
                }
            }
            int ans[] = computeAnswer(matrix, n);
            System.out.println("Case #" + (kase++) + ": " + ans[0] + " " + ans[1] + " " + ans[2]);

        }
    }
}