import java.io.*;
import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int p=0;p<t;p++){
            int k=0,r=0,c=0;
            int n=sc.nextInt();
            int m[][]=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    m[i][j]=sc.nextInt();
                    if(i==j)
                    k+=m[i][j];
                    
                }
            }
            
            for(int i=0;i<n;i++){
                int countrow[]=new int[120];
                for(int j=0;j<n;j++){
                    countrow[m[i][j]]++;
                    if(countrow[m[i][j]]==2){
                        r++;
                        break;
                    }
                }
            }
            
            
            for(int i=0;i<n;i++){
                int countcol[]=new int[120];
                for(int j=0;j<n;j++){
                    countcol[m[j][i]]++;
                    if(countcol[m[j][i]]==2){
                        c++;
                        break;
                    }
                    
                }
            }
            
            
          int temp=p+1;
          System.out.println("Case #"+temp+": "+k+" "+r+" "+c);
        }
        
    }
    
}