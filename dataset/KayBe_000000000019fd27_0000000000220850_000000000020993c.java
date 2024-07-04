import java.util.*;
class Solution{
    public static void main (String [] args){
        Scanner in = new Scanner(System.in);
        int T= in.nextInt();
        for (int i = 1; i<=T; i++){
            int N = in.nextInt();
            int x = i;
            int k = 0; 
            int r = 0;
            int c = 0;
            int mat [][] = new int[N][N];
            for (int j = 0; j<N; j++){
                Set <Integer> rows = new HashSet<Integer>();
                for (int m = 0; m<N; m++){
                    mat[j][m] = in.nextInt();
                    rows.add(mat[j][m]);
                }k += mat[j][j];
                if (rows.size()<N){
                    r+=1;
                }
            } for (int j = 0; j<N; j++){
                Set <Integer> cols = new HashSet<Integer>();
                for (int m = 0; m<N; m++){
                    cols.add(mat[m][j]);
                }if (cols.size()<N){
                    c+=1;
                }
                }
            System.out.println("Case #" + x + ": " + k + " " + r + " "+ c );
        }
    }
}