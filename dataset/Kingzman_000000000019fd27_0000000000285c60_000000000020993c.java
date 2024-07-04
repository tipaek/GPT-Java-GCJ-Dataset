import java.io.*;
import java.util.*;
class Solution{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        int cas = 0;
        while(++cas<=t){
            int n = Integer.parseInt(br.readLine().trim());
            int [][]mat = new int[n][n];
            for(int i=0; i<n; i++){
                String []num = br.readLine().split("\\s+");
                for(int j=0; j<num.length; j++){
                    mat[i][j] = Integer.parseInt(num[j]);
                }
            }
            int sum = n*(n+1)/2;
            int row_rep_el = 0, col_rep_el = 0;
            int cur_row = 0, cur_col=0, trace=0;
            for(int i=0; i<n; i++){
                trace+=mat[i][i];
                int r[] = new int[n+1];
                int j=0;
                for(; j<n; j++){
                    if(r[mat[i][j]]<1)
                        r[mat[i][j]] = 1;
                    else
                        break;
                }
                if(j!=n)
                    row_rep_el++;
             }
            
            for(int i=0; i<n; i++){
                int c[] = new int[n+1];
                int j=0;
                for(; j<n; j++){
                    if(c[mat[j][i]]<1)
                        c[mat[j][i]] = 1;
                    else
                        break;
                }
                if(j!=n)
                    col_rep_el++;
             }
            
            System.out.println("Case #"+cas+": "+trace+" "+row_rep_el+" "+col_rep_el);
        }
    }
}