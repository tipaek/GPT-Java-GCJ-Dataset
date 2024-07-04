import java.io.*;
import java.util.*;
import java.util.HashSet;
public class Solution {

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int x= 1;
        while(x<=t)
        {
            int n = s.nextInt();
        int a[][] = new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
               a[i][j] = s.nextInt(); 
            }
        }
        int k =0,r =0,c =0;
        for(int i=0;i<n;i++)
        {
            HashSet<Integer> hr = new HashSet<>(); 
            HashSet<Integer> hc = new HashSet<>(); 
            for(int j=0;j<n;j++)
            {
                if(i==j){
                    k=k+a[i][j];
                }
                hr.add(a[i][j]);
                hc.add(a[j][i]);
                
            }
          
            if(hr.size()!=n)
                r+=1;
            if(hc.size()!=n)
                c+=1;
        }
        System.out.println("Case #"+x+": "+k+" "+r+' '+c);
        x = x+1;
        }
    }
}