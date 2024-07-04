import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution{

public static void main(String[] args)
{
    int i,j,trace=0,k=1;
    int cntr=0,cntc=0;
    
    int t;
    int n;
    
    Scanner sc =new Scanner(System.in);
    
    t=sc.nextInt();
    while(t>0)
    {
        n=sc.nextInt();
        int[][] mat=new int[n][n];
        int[] temp=new int[n+1];
        for(i=0;i<n+1;i++)
            temp[i]=0;
            
        int[] tempc=new int[n+1];
        for(i=0;i<n+1;i++)
            tempc[i]=0;
        
        for(i=0;i<n;i++)
            for(j=0;j<n;j++)
                mat[i][j]=sc.nextInt();
        
        for(i=0;i<n;i++){
            for(j=0;j<n;j++)
            {
                if(i==j)
                    trace=trace+mat[i][j];
                
                if(temp[mat[i][j]]==0)
                {
                    // printf("1. %d\n",mat[i][j]);
                    temp[mat[i][j]]++;
                }
                else if(temp[mat[i][j]]>0&&cntr<=i)
                {
                    cntr++;
                }
                
                if(tempc[mat[j][i]]==0)
                {
                    // printf("1. %d\n",mat[j][i]);
                    tempc[mat[j][i]]++;
                    // printf("2. %d\n",mat[j][i]);
                }
                else if(temp[mat[j][i]]>0&&cntc<=i)
                {
                    cntc++;
                }
                // printf("2. %d\n",tmat[j][i]);
            }
            for(int l=0;l<n+1;l++)
                temp[l]=0;

            for(int m=0;m<n+1;m++)
                tempc[m]=0;
            // cntr=1;
            // cntc=1;
        }
        System.out.println("Case #"+k+" :"+" "+trace+" "+cntr+" "+cntc);
        k++;
        trace=0;
        cntr=0;
        cntc=0;
        t--;
    }   
}
}