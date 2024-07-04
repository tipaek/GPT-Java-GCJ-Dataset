import java.util.*;

public class testOK
{
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int u=0;u<t;u++)
        {
        	int n=sc.nextInt();
            int i;
            int j;
            int[][] m=new int[n][n];
            for(i=0;i<n;i++)
            {
                for(j=0;j<n;j++)
                {
                    int p=sc.nextInt();
                    m[i][j]=p;
                    
                }
            }
            sc.close();
           
            for( i=0;i<n;i++)
            {
               k=k+m[i][i];
            }
            System.out.println(k);
            int r=0;
            int[] temp=new int [n];
            for(int x=0;x<n;x++)
            {
            	for (int p = 0; p <n; p++) 
            	{
            		temp[p]=m[x][p];
            		for ( i = 0; i <n; i++) 
                    { 
                    	for ( j = i + 1; j < n; j++)
                    	{ 
                    		if (temp[i]==temp[j]) 
                    		{
                    			r++;
                    			break;
                    		}
                    	}
                    }
            	}
            }
            System.out.println(r);
            int c=0;
            int[] temp1=new int [n];
            for(int x=0;x<n;x++)
            {
            	for (int p = 0; p <n; p++) 
            	{
            		temp1[p]=m[p][x];
            		for ( i = 0; i <n; i++) 
                    { 
                    	for ( j = i + 1; j < n; j++)
                    	{ 
                    		if (temp1[i]==temp1[j]) 
                    		{
                    			r++;
                    			break;
                    		}
                    	}
                    }
            	}
            }
            System.out.println(c);
            

        
        }
        
        
    }
}