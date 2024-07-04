import java.util.HashSet;
import java.util.Scanner;

class Solution{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int M = 1;
        while(T>0){
            int N = sc.nextInt();
            int[][] mat = new int[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    mat[i][j] = sc.nextInt();
                }
            }
            int[] res = compute(N,mat);
            System.out.println("Case #"+M+": "+res[0]+" "+res[1]+" "+res[2]+" ");
            M++;
            T--;
        }
    }
    
    public static int[] compute(int N, int[][] mat){
        int[] res = new int[3];
        for(int i=0;i<N;i++){
            res[0]+=mat[i][i];
            HashSet<Integer> rowSet = new HashSet<Integer>();
            HashSet<Integer> colSet = new HashSet<Integer>();
            for(int j=0;j<N;j++){
                if(rowSet.contains(mat[i][j])){
                    res[1]++;
                    break;
                }
                else{
                    rowSet.add(mat[i][j]);
                }
                if(colSet.contains(mat[j][i])){
                    res[2]++;
                    break;
                }
                else{
                    colSet.add(mat[j][i]);
                }
            }
        }
        return res;
    }
}