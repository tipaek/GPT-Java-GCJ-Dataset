import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String args[]){
    int T;
    Scanner sc=new Scanner(System.in);
    T=sc.nextInt();
    while (T-- > 0)
    {
        int N,i,j,k=0;
        N=sc.nextInt();
        int a[][]=new int[N][N];
        for(i=0;i<N;i++) // trace
        {
            for(j=0;j<N;j++)
            {
                a[i][j] = sc.nextInt();
            }
        }
        for(i=0;i<N;i++) // trace
        {
            for(j=0;j<N;j++)
            {
                if(i==j)
                {
                    k+= a[i][j];
                }
            }
        }
		//================================
         int r = 0; 
        for (i = 0; i < a.length; i++) { 
            int first = a[i][0]; 
            boolean allSame = true; 
    for (j = 1; j < a.length; j++) { 
    if (a[i][j] != first) { 
                    allSame = false; 
                    break; 
                } 
            } 
        if (allSame) 
                r++; 
        }
        
        int c = 0; 
        for (i = 0; i < a.length; i++) { 
            int first = a[0][i]; 
            boolean allSame = true; 
            for (j = 1; j < a.length; j++) { 
            if (a[i][j] != first) { 
                    allSame = false; 
                    break; 
                } 
            } 
                if (allSame) 
                c++; 
        }
        System.out.println("Case #" + T+1 + ":" + " " + k + " " + r + " " + " " + c);
    }
    }
}