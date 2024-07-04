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
    
    
    public static int getCount(int inArray[][],int n)
    {
    	int c=0;
    	for (int row = 0; row < inArray.length; row++)
        {
            for (int col = 0; col < inArray[row].length; col++)
            {
                int num = inArray[row][col];
                for (int otherCol = col + 1; otherCol < inArray.length; otherCol++)
                {
                    if (num == inArray[row][otherCol])
                    {
                         c++;
                        //break;
                    }
                    //c++;
                }
                //break;
                //c++;
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