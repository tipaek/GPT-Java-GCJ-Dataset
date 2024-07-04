
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	public static void main (String[] args) {

    int t,n,sum,flag,rmax,cmax,a;
    Scanner sc=new Scanner(System.in);
    t=sc.nextInt();
    for(int z=0;z<t;z++)
    {
        n=sc.nextInt();
        sum=0;
        flag=0;
        rmax=0;
        cmax=0;
        int[][] arr=new int[n][n];
        int[] arr2=new int[100];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j]=sc.nextInt();
                a=arr[i][j];
                
                if(arr2[a-1]!=0)
                {
                    flag=1;
                    
                }
                arr2[a-1]++;
                
            }
            if(flag==1)
            {
                rmax++;
            }
            Arrays.fill(arr2,0);
            
            flag=0;
        }
        
        for(int j=0;j<n;j++)
        {
            for(int i=0;i<n;i++)
            {
                
                a=arr[i][j];
                
                if(arr2[a-1]!=0)
                {
                    flag=1;
                    
                }
                arr2[a-1]++;
                
            }
            if(flag==1)
            {
                cmax++;
            }
            Arrays.fill(arr2,0);
            flag=0;
        }
        
        
        for(int i=0;i<n;i++)
        sum+=arr[i][i];
        
        System.out.println("Case #"+(z+1)+": "+sum+" "+rmax+" "+cmax);
    
    }
}
}