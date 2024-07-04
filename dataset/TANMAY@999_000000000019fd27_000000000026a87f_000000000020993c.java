
import  java.io.*;
import  java.util.*;


  class Solution{
     
     public static void main(String args[]) throws IOException{
           
           BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
         
         
         int test_case = Integer.parseInt(in.readLine());
         
     for(int t=1;t<=test_case;t++){
           int n = Integer.parseInt(in.readLine());
             
             int trace=0;
             HashMap<Integer,Integer> hmap_ver = new HashMap<Integer,Integer>(n);
             HashMap<Integer,Integer> hmap_hor = new HashMap<Integer,Integer>(n);
             
             
             int hor_dup=0,ver_dup=0;
             
             int a[][] = new int[n][n];
             for(int i=0;i<n;i++){
                 
                 String line[]=in.readLine().split(" ");
                 for(int j=0;j<line.length;j++){
                     
                     a[i][j]=Integer.parseInt(line[j]);
                    
                     
                 
                 if(i==j){
                     trace+=a[i][j];
                 }
                 
                
                 
                 }
             }
             
              for(int i=0;i<n;i++){
                 for(int j=0;j<n;j++){
                 
                 if(!hmap_hor.containsKey(a[i][j])){
                     hmap_hor.put(a[i][j],1);
                 }
                 else{
                     hor_dup++;
                     break;
                 }
                 
                 }
                 
                 hmap_ver.clear();
                 hmap_hor.clear();
             }
             
             
             for(int i=0;i<n;i++){
                 for(int j=0;j<n;j++){
                 
                 if(!hmap_ver.containsKey(a[j][i])){
                     hmap_ver.put(a[j][i],1);
                 }
                 else{
                     ver_dup++;
                     break;
                 }
                 
                 }
                 
                 hmap_ver.clear();
                 hmap_hor.clear();
             }
             
             
             System.out.println("case #"+t+": "+ trace+" "+hor_dup+" "+ver_dup);
             
             
             
              
                 
             hmap_ver.clear();
             hmap_hor.clear();

         }
         
     }
 
 }