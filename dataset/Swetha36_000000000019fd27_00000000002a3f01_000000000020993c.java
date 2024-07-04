import java.io.*;
import java.util.*;
class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++) {
            int n=Integer.parseInt(br.readLine());
            int mat[][]=new int[n][n];
            int diag=0,row=0,col=0;
            for(int i=0;i<n;i++) {
                String s[]=br.readLine().split(" ");
                HashMap<Integer,Integer>hm=new HashMap<>();
                for(int j=0;j<n;j++) {
                    mat[i][j]=Integer.parseInt(s[j]);
                    if(hm.containsKey(mat[i][j])) 
                       hm.put(mat[i][j],hm.get(mat[i][j])+1);
                    else 
                       hm.put(mat[i][j],1);
                }
                if(hm.size()!=n) row++;
            }
            for(int i=0;i<n;i++) {
                HashMap<Integer,Integer>hm=new HashMap<>();
                for(int j=0;j<n;j++) {
                    if(hm.containsKey(mat[i][j])) 
                       hm.put(mat[j][i],hm.get(mat[i][j])+1);
                    else 
                       hm.put(mat[j][i],1);
                }
                if(hm.size()!=n) col++;
            }
            for(int k=0;k<n;k++) {
                int i=k,j=k;
                diag+=mat[i][j];
            }
            System.out.println("Case #"+t+": "+diag+" "+row+" "+col);
        }
    }
}