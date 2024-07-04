import java.util.*;
import java.lang.*;
import java.io.*;
class Solution{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        int count = 1;
        StringBuffer sbuf = new StringBuffer();
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int[][] mat = new int[n][n];
            
            for(int i=0;i<n;i++){
                String[] values = br.readLine().split(" ");
                
                for(int j=0;j<n;j++){
                    mat[i][j] = Integer.parseInt(values[j]);
                }
            }
                
                int k=0,r=0,c=0;
                
            for(int i=0;i<n;i++){
                   k += mat[i][i];
            }
            
            for(int i=0;i<n;i++){
                int[] arr = new int[200];
                Arrays.fill(arr,0);
                
                for(int j=0;j<n;j++){
            
                    if(arr[mat[i][j]]==1){
                        r++;
                        break;
                    }
                    arr[mat[i][j]] = 1;
                }
                
            }
            
            
            for(int j=0;j<n;j++){
                int[] arr = new int[200];
         
                for(int i=0;i<n;i++){
                    if(arr[mat[i][j]]==1){
                        c++;
                        break;
                    }
                    arr[mat[i][j]] = 1;
                }
                
                
            }
            
            
            sbuf.append("Case #"+count+": "+k+" "+r+" "+c+"\n");
            count++;
            
        } 
        
        
        System.out.println(sbuf);
    }
}