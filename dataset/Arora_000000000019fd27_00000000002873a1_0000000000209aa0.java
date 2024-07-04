import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
class Solution{
    static int flag=0;
    public static void main(String args[]){
        FastScanner sc=new FastScanner(System.in);
        int t=sc.nextInt();
        for(int p1=0;p1<t;p1++){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int board[][]=new int[n][n];
            flag=0;
            latinSquare(board,n,k,0,0);
            if(flag==0){
                System.out.println("Case #"+(p1+1)+": IMPOSSIBLE");
            }
            else{
                System.out.println("Case #"+(p1+1)+": POSSIBLE");
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        if(j==n-1){
                            System.out.print(board[i][j]);
                        }
                        else{
                            System.out.print(board[i][j]+" ");
                        }
                    }
                    System.out.println();
                }
            }
        }
    }
    static void latinSquare(int board[][],int n,int k,int row,int col){
        helper(board,n,k,row,col);
        return;
    }
    static boolean helper(int board[][],int n,int k,int row,int col){
        if(row==n-1 && col==n){
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=board[i][i];
            }
            if(sum==k){
                flag=1;
                return true;
            }
            else{
                return false;
            }
        }
        if(col==n){
            col=0;
            row++;
        }
        if(board[row][col]!=0){
            if(helper(board,n,k,row,col+1)){
                return true;
            }
        }
        for(int i=1;i<=n;i++){
            if(isValid(board,row,col,i)){
                board[row][col]=i;
                if(helper(board,n,k,row,col+1)){
                    return true;
                }
                else{
                    board[row][col]=0;
                }
            }
        }
        return false;
    }
    public static boolean isValid(int board[][],int row,int col,int x){
        int n=board.length;
        for(int i=0;i<n;i++){
            if(board[row][i]==x){
                return false;
            }
            if(board[i][col]==x){
                return false;
            }
        }
        return true;
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}