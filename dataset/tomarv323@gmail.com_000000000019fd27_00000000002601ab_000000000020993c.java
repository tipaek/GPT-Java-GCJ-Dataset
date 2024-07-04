 import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException{
    
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     int t = Integer.parseInt(br.readLine());
     
     for(int p=1; p<=t; p++){
         int n = Integer.parseInt(br.readLine());
         int [][] mat = new int[n][n];
         for(int i=0; i<n; i++){
             String [] inp = br.readLine().split(" ");
             for(int j=0; j<n; j++){
                 mat[i][j]= Integer.parseInt(inp[j]);
             }
         }
         
         int k =0;
         int r= 0;
         int c=0;
         for(int i=0; i<n; i++){
             HashSet<Integer> hs = new HashSet<>();
             for(int j=0; j<n; j++){
                if(i==j){
                    k+= mat[i][j];
                }
                
                if(!hs.contains(mat[i][j])){
                    hs.add(mat[i][j]);
                }
             }
             if(hs.size()< n){
                 r++;
             }
         }
         
         for(int i=0; i<n; i++){
             HashSet<Integer> hs = new HashSet<>();
             for(int j=0; j<n; j++){
                if(!hs.contains(mat[j][i])){
                    hs.add(mat[j][i]);
                }
             }
             if(hs.size()< n){
                 c++;
             }
         }
         
         System.out.println("Case #"+p +": "+ k+" "+r+" "+c);
     }
  }
}