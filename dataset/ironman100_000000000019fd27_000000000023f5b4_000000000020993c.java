import java.io.*;
import java.util.*;
public class Solution{

     public static void main(String []args)throws Exception{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int t = Integer.parseInt(line);
        for(int T=1;T<=t;T++){
            line = br.readLine();
        int n = Integer.parseInt(line);
        int[][] M = new int[n][n];
        for(int i=0;i<n;i++){
            line = br.readLine();
            String[] strs = line.trim().split("\\s+");
            for(int j=0;j<n;j++) M[i][j] = Integer.parseInt(strs[j]);
        }
        int x = 0;
        int y = 0;
        int z = 0;
        for(int i=0;i<n;i++){
            HashSet<Integer> hs = new HashSet<Integer>();
            for(int j=0;j<n;j++){
                if(hs.contains(M[i][j])){ y++; break; }
                else hs.add(M[i][j]);
            }
            HashSet<Integer> hs1 = new HashSet<Integer>();
            for(int j=0;j<n;j++){
                if(hs1.contains(M[j][i])){ z++; break; }
                else hs1.add(M[j][i]);
            }
        }
        for(int i=0;i<n;i++) x += M[i][i];
        System.out.println("Case #"+T+": "+x+" "+y+" "+z);
        }
     }
}