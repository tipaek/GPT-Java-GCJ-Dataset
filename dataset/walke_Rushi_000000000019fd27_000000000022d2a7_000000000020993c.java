import java.io.*;
import java.util.*;
public class Solution{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine());
        int p=1;
        while(t-->0){
        
            int n= Integer.parseInt(br.readLine());
            int a[][]= new int[n][n];
            int trace=0;
            for(int i=0;i<n;i++){
                String[] inp= br.readLine().split(" ");
                for(int j=0;j<n;j++){
                    a[i][j]= Integer.parseInt(inp[j]);
                    if(i==j){
                        trace+=a[i][i];
                    }
                }
            }
            int sum=0;
            for(int i=1;i<=n;i++){
                sum+=i;
            }
            int rownum=0, colnum=0;
            
            for(int i=0;i<n;i++){
                int sumcol=0,sumrow=0;
                for(int j=0;j<n;j++){
                    sumcol+=a[j][i];
                    sumrow+=a[i][j];
                }
                if(sumcol!=sum){
                    colnum++;
                }
                if(sumrow!=sum){
                    rownum++;
                }
                
                
            }
            System.out.println("Case #"+p+": "+trace+" "+rownum+" "+colnum);
            p++;
        }
    }
}
            