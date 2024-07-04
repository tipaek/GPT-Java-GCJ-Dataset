import java.util.*;
import java.io.*;
class Solution{
    public static void main(String[] args) throws IOException{
        BufferedReader b  = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(b.readLine());
        int k=0;
        while(t--!=0){
            int n = Integer.parseInt(b.readLine());
            
            int[][] arr = new int[n][n];
            boolean[][] check = new boolean[n][n];
            int rowc=0,colc=0,diags=0;
            
            for(int i=0;i<n;i++){
                String[] in = b.readLine().split(" ");
                boolean flag = true;
                for(int j=0;j<n;j++){
                    arr[i][j] = Integer.parseInt(in[j]);
                    if(i==j){
                        diags+= arr[i][j];
                    }
                    if(check[i][arr[i][j]-1] && flag){
                        rowc++;
                        flag = false;
                    }
                    check[i][arr[i][j]-1] = true;
                }
            }
            boolean[][] check2 = new boolean[n][n];
                
            for(int i=0;i<n;i++){
                boolean flag = true;
                for(int j=0;j<n;j++){
                    if(check2[arr[j][i]-1][i] && flag){
                        colc++;
                        flag = false;
                    }
                        check2[arr[j][i]-1][i] = true;
                }
            }
            System.out.println("Case #"+ (++k)+": "+diags+" "+rowc+" "+colc);
            
        }
    }
}