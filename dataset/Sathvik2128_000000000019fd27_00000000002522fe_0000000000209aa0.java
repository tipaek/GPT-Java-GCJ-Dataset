import java.util.*;
public class Solution {
    public static void main(String args[]){
        Scanner in  = new Scanner(System.in);
        int t = in.nextInt();
        int testcase = 1;
        while(t--!=0){
            int n = in.nextInt();
            int k = in.nextInt();
            int [][]mat = new int[n][n];
            if(backtrack(0,0,n,k,mat,0)){
                System.out.println("Case #"+testcase+": POSSIBLE");
                for(int i=0;i<n;++i){
                    for(int j=0;j<n;++j){
                        System.out.print(mat[i][j]+" ");
                    }
                    System.out.println();
                }
            }else{
                System.out.println("Case #"+testcase+": IMPOSSIBLE");
            }
            ++testcase;
        }
    }
    public static boolean backtrack(int row,int col,int n,int k,int [][]mat,int trace){
        if(row==0&&col==n){
            if(trace==k)return true;
            return false;
        }
        if(trace>=k)return false;
        for(int i=1;i<=n;++i){
            if(isSafe(row,col,mat,i)){
                mat[row][col] = i;
                int trow = (row+1)==n?0:row+1;
                int tcol = (row+1)==n?col+1:col;
                if(backtrack(trow,tcol,n,k,mat,trace+((row==col)?i:0))){
                    return true;
                }
                mat[row][col] = 0;
            }
        }
        return false;
    }
    public static boolean isSafe(int row,int col,int [][]mat ,int toadd){
        for(int i=0;i<mat.length;++i){
            if(mat[row][i]==toadd)return false;
        }
        for(int i=0;i<mat.length;++i){
            if(mat[i][col]==toadd)return false;
        }
        return true;
    }
}