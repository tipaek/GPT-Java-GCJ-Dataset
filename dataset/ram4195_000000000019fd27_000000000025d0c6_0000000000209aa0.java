import java.io.*;
import java.util.*;
public class Solution {
    static boolean check(int[][] arr,int x,int y,int value)
    {
        for(int i=0;i<x;i++)
        {
            if(arr[y][i]==value)
            {
                return false;
            }
        }
        for(int i=0;i<y;i++)
        {
            if(arr[i][x]==value)
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        for(int kmn =1;kmn<=testcases;kmn++)
        {
            int n=sc.nextInt();
            int k=sc.nextInt();
            int[] test = new int[n];
            int[][] arr = new int[n][n];
            for(int j=0;j<n;j++)
            {
                test[j]=j+1;
            }
            int c=0;
            for (int i = 0; i < n; i++) { 
  
                // Fix the second element as A[j] 
                for (int j = i + 1; j < n; j++) { 
      
                    // Now look for the third number 
                    for (int l = j + 1; l < n; l++) { 
                        if (test[i] + test[j] + test[l] == k) { 
                            arr[0][0]=test[i];
                            arr[1][1]=test[j];
                            arr[2][2]=test[l];
                            c=1;
                            break;    
                        } 
                    } 
                if(c==1)
                {
                    break;
                }
                }
            if(c==1)
            {
                break;
            }
            }
        int boom=0;   
        for(int j=0;j<n;j++)
        {
            for(int i=0;i<n;i++)
            {
                if(i!=j)
                {
                    for(int q=1;q<=n;q++)
                    {
                        
                        if(q!=arr[j][j])
                        {
                            System.out.println("j+++++++++++++"+j);
                        System.out.println("i+++++++++++++"+i);
                        System.out.println("q+++++++++++++"+q);
                        System.out.println();
                            
                            if(check(arr,i,j,q))
                            {
                                arr[j][i]=q;
                               
                                boom=1;
                                break;
                            }
                        }
                    }
                }
            
            }
        }
        for(int j=0;j<n;j++)
        {
            for(int i=0;i<n;i++)
            {
                System.out.print(arr[j][i]+" ");
            }
            System.out.println();
        }
        


        }
    }

    
    

}