import java.io.*;
import java.util.*;
class Solution{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        int cas = 1;
        while(cas++<=t){
            int n = Integer.parseInt(br.readLine().trim());
            int [][]mat = new int[n][n];
            for(int i=0; i<n; i++){
                String []num = br.readLine().split("\\s+");
                for(int j=0; j<num.length; j++){
                    mat[i][j] = Integer.parseInt(num[0]);
                }
            }
            int sum = n*(n+1)/2;
            int row_rep_el = 0, col_rep_el = 0;
            int cur_row = 0, cur_col=0, trace=0;
            for(int i=0; i<n; i++){
                cur_row=0;
                cur_col=0;
                trace+=mat[i][i];
                for(int j=0; j<s.length; j++){
                    cur_row+=mat[i][j];
                    cur_col+=mat[j][i];
                }
                if(cur_row!=sum)
                    row_rep_el++;
                
                if(cur_col!=sum)
                    col_rep_el++;
            }
            
            System.out.println("Case #"+cas+": "+trace+" "+row_rep_el+" "+col_rep_el);
        }
    }
}