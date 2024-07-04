import java.io.*;
import java.util.*;

class Solution{
    public static void main(String[] args)throws Exception{
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuffer sb = new StringBuffer();
        for(int test = 1; test<=t; test++){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[][] = new int[n][n];
            for(int i=0;i<n;i++){
                String s[] = br.readLine().trim().split(" ");
                for(int j=0;j<n;j++){
                    arr[i][j] = Integer.parseInt(s[j]);
                }
            }
            
            int row = 0;
            for(int i=0;i<n;i++){
                int f[] = new int[n+1];
                for(int j=0;j<n;j++){
                    if(f[arr[i][j]] == 0)
                        f[arr[i][j]]++;
                    else{
                        row++;
                        break;
                    }
                }
            }
            
            int col=0;
            for(int i=0;i<n;i++){
                int f[] = new int[n+1];
                for(int j=0;j<n;j++){
                    if(f[arr[j][i]] == 0)
                        f[arr[j][i]]++;
                    else{
                        col++;
                        break;
                    }
                }
            }
            
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=arr[i][i];
            }
            
            sb.append("Case #"+test+": "+sum+" "+row+" "+col+"\n");
        }
        
        System.out.print(sb);
    
    }
}