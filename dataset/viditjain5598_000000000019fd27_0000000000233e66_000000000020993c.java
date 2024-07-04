import java.util.*;

public class Solution{
    static int nRows(int[][] mat){
        int n = mat.length, k=0;
        for(int i = 0; i<n; i++){
            boolean isLatin = true;
            HashMap<Integer, Integer> mp = new HashMap<>();
            for(int j=0; j<n; j++){
                if(mp.containsKey(mat[i][j])){
                    isLatin = false;
                    break;
                }else{
                    mp.put(mat[i][j], 1);
                }
            }
            if(!isLatin) ++k;
        }
        return k;
    }
    static int nCols(int[][] mat){
        int n = mat.length, k=0;
        for(int i = 0; i<n; i++){
            boolean isLatin = true;
            HashMap<Integer, Integer> mp = new HashMap<>();
            for(int j=0; j<n; j++){
                if(mp.containsKey(mat[j][i])){
                    isLatin = false;
                    break;
                }else{
                    mp.put(mat[j][i], 1);
                }
            }
            if(!isLatin) ++k;
        }
        return k;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-->0){
            int n = in.nextInt();
            int[][] mat = new int[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    mat[i][j] = in.nextInt();
                }
            }
            int k = 0;
            for(int i=0; i<n; i++){
                k += mat[i][i];
            }
            System.out.println(k + " " + nRows(mat) + " " + nCols(mat));

        }
    }
}