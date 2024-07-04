import java.util.HashSet;
import java.util.Scanner;

public class Solution1
{
    public static void main(String[] st)
    {
        int t=0;
        Scanner scan=new Scanner(System.in);
        t=scan.nextInt();
        for(int i=1;i<=t;i++)
        {
        	int n=1;
        	n=scan.nextInt();
        	int[][] arr=new int[n][n];
        	for(int j=0;j<n;j++)
        	{
        		for(int k=0;k<n;k++)
        		{
        			arr[j][k]=scan.nextInt();
        		}
        	}
        	//System.out.println("Case #"+i+": "+calTrace(arr,n)+" "+calRow(arr)+" "+calCol+"");
        	
        	int trace=0;
        	for(int j=0;j<n;j++)
        	{
        		trace+=arr[j][j];
        	}
        	int row=0,col=0;
        	for(int j=0;j<n;j++)
        	{
        		HashSet<Integer> hs = new HashSet<>(); 
        		for(int k=0;k<n;k++)
        		{
        			hs.add(arr[j][k]); 
        		}
        		if (hs.size()!=n) 
        		{
                        row++; 
                } 
        	}
	        for(int j=0;j<n;j++)
	    	{
	    		HashSet<Integer> hs = new HashSet<>(); 
	    		for(int k=0;k<n;k++)
	    		{
	    			hs.add(arr[k][j]); 
	    		}
	            
	    		if (hs.size()!=n) 
	    		{
	                    col++; 
	            } 
	    	}
	        System.out.println("Case #"+i+": "+trace+" "+row+" "+col+"");
        	
        }
    }
}