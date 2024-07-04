import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
    
    void run(){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int cnt=0;
        while(cnt<t){
            cnt++;
            int n=sc.nextInt();
            int mat[][]=new int[n][n];
            
            int k,r,c;
            k=r=c=0;
            for(int i=0;i<n;i++){
                Set<Integer> set=new HashSet<Integer>();
                for(int j=0;j<n;j++){
                    mat[i][j]=sc.nextInt();
                    if(i==j) k+=mat[i][j];
                    set.add(mat[i][j]);
                }
                if(set.size()!=n) r++;
            }
            
            for(int i=0;i<n;i++){
                Set<Integer> set=new HashSet<Integer>();
                for(int j=0;j<n;j++){
                    set.add(mat[j][i]);
                }
                if(set.size()!=n) c++;
            }
            
            System.out.println("Case #"+cnt+": "+k+" "+r+" "+c); 
        }
    }
    
    public static void main(String args[]) throws IOException{
        new Solution().run();
    }
}