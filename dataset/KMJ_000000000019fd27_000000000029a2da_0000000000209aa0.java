import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    	
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
           int N = in.nextInt();
           int B = in.nextInt();
           int a[][] =  new int[N][N];
           
           boolean rowCheck[][] = new boolean[N+1][N+1];
	   boolean colCheck[][] = new boolean[N+1][N+1];
	    
	    if(!finishMatrix(0,a,rowCheck,colCheck,N,0,B,i))
            {
                System.out.println("Case #"+i+": IMPOSSIBLE");
            }
        }
           
    }       
	
	
	public static boolean finishMatrix(int currentCell,int a[][],boolean rowCheck[][],boolean colCheck[][],int N,int sum,int B,int ithCase)
	{
	    if(currentCell==(N*N) && sum == B)
	    {
                System.out.println("Case #"+ithCase+": POSSIBLE");
                for(int row=0;row<N;row++)
                {
                    for(int col=0;col<N;col++)
                    {
                        if(col!=N-1)
                        System.out.print(a[row][col]+" ");
                        else
                        System.out.print(a[row][col]);
                    }
                    System.out.println();
                }
	        return true;
	    }
	    int i = currentCell/N;
	    int j = currentCell%N;
            
    	    for(int num=1;num<=N;num++)
    	    {
    	        if(!rowCheck[i][num] && !colCheck[j][num])
    	        {
    	            rowCheck[i][num] = true;
    	            colCheck[j][num] = true;
    	            a[i][j]=num;
                    
    	            if(finishMatrix(currentCell+1,a,rowCheck,colCheck,N,i==j?sum+num:sum,B,ithCase))
    	            {
    	                return true;    	                
    	            }
    	            rowCheck[i][num] = false;
    	            colCheck[j][num] = false;
    	            a[i][j]=0;
    	            
    	        }
    	    }   
	   
	    
	  return false;  
	}
}
