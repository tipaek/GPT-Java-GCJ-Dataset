package checking;

import java.io.*;
import java.util.*;
import java.lang.*;
class Solution 
{
    
    public static void traceRowCol(int a[][],int n,int t)
    {
    
        int countRow=0,countCol=0;
        int tran[][]=new int[n][n];
         countRow=getCount(a,n);
        for(int i=0;i<n;i++)
        {

            for(int j=0;j<n;j++)
            {
                
                tran[i][j]=a[j][i];
                
            }
            
        }
        countCol=getCount(tran,n);
        
        
        /*for(int i=0;i<n;i++)
        {
            //HashSet<Integer> sh = new HashSet<>(); 
            for(int j=0;j<n;j++)
            {
            	System.out.print(tran[i][j]+" ");
                
            }
            System.out.println();
        }
        */
        
        
        

        System.out.println(t+" "+countRow+" "+countCol);
        
    } 
    
    
    public static int getCount(int a[][],int n)
    {
    	//HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
    	int c=0;
    	
    	for (int row = 0; row < n; row++)
        {
    		ArrayList<Integer> vis=new ArrayList<>();
            for (int col = 0; col < n; col++)
            {
            	if(vis.contains(a[row][col])) {
            		c++;
            	break;
            }
                vis.add(a[row][col]);
            }
        }
       return c;
   
    }
    
   /* public static int traceCol(int a[][],int n)
    {
    
        int countCol=0;
        //int tran[][]=new int[n][n];
         
        for(int i=0;i<n;i++)
        {
            //HashSet<Integer> sh = new HashSet<>(); 
            for(int j=0;j<n;j++)
            {
            	a[i][j]=a[j][i];
                
            }
            
        }
        
        for(int i=0;i<n;i++)
        {
        	
            HashSet<Integer> hs = new HashSet<>(); 
            //HashSet<Integer> sh = new HashSet<>(); 
            for(int j=0;j<n;j++)
            {
                
                
                hs.add(a[i][j]); 
                //sh.add(a[j][i]); 
                
            }
            
            if (hs.size() == 1) 
                countCol++;
            
        }

        return countCol;
        
    } */
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int tc=sc.nextInt();
        for(int t=0;t<tc;t++){
        int n=sc.nextInt();
        int arr[][]=new int[n][n];
        int trace=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j]=sc.nextInt();
                if(i==j) trace+=arr[i][j];
            }
            
        }
        traceRowCol(arr,n,trace);
        }
    }
}