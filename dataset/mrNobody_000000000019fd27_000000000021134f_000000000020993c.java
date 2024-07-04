import java.util.*;
import java.io.*;
class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int q = 1; q<=t; q++) {
            int n=Integer.parseInt(br.readLine());
            int mat[][]=new int [n][n];
            int k=0,r=0,c=0;
            
            for (int i = 0; i < n; i++) {
                Set<Integer> set = new HashSet<>();
                String[] input = br.readLine().split(" ");
                boolean b=false;
                for (int j = 0; j < n; j++) {
                    mat[i][j]=Integer.parseInt(input[j]);
                    if(!set.contains(mat[i][j]))set.add(mat[i][j]);
                    else b=true;
                    if(i==j)k=k+mat[i][j];
                }
                if(b)r++;
            }
            for (int i = 0; i < n; i++) {
                Set<Integer> set = new HashSet<>();
                 boolean b=false;
                for (int j = 0; j < n; j++) {
                    if(!set.contains(mat[j][i]))set.add(mat[j][i]);
                    else b=true;
                }
                if(b)c++;
            }
            
            sb.append("Case #"+q+": "+k+" "+r+" "+c+"\n");
        }
        System.out.println(sb);
    }
}
