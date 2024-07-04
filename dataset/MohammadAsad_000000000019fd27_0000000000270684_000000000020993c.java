

import java.util.Scanner;
class asad {
	    public static void main(String args[])
	    {
	        Scanner sc=new Scanner(System.in);
	        int T=sc.nextInt();//test cases
	        for(int i=1;i<=T;i++)
	        {
	           
	            int size=sc.nextInt();
	            int matrix[][]=new int[size][size];
	            for(int j=0;j<size;j++)
	               for(int k=0;k<size;k++)
	               matrix[j][k]=sc.nextInt();
	            int k=trace(matrix);
	            int r=rows(matrix);
	            int c=columns(matrix);
	            System.out.print("Case #"+i+": ");
	            System.out.print(k+" ");
	            System.out.print(r+" ");
	           System.out.println(c+" ");
	        }
	    }
	    static int trace(int a [][])
	    {
	        int sum=0;
	        for(int i=0;i<a.length;i++)
	           for(int j=0;j< a.length;j++)
	           if(i==j)
	           sum+=a[i][j];
	           return sum;
	    }
	    static int rows(int a[][])
	    {
	    	int r=0;
	    	check:
	    	for(int i=0;i<a.length;i++)
	    	{
	    		for(int j=0;j<a.length;j++)
	    		{
	    			int c=0;
	    			int x=a[i][j];
	    					for(int k=0;k<a.length;k++)
	    					{
	    						if(x==a[i][k])
	    							c++;
	    						
	    						if(c==2)
	    						{
	    							r++;
	    							continue check;
	    						}
	    							
	    					}
	    		}
	    	}
	    	return r;
	    }
	    static int columns(int a[][])
	    {
	        int cl=0;
	         of:
	    	for(int i=0;i<a.length;i++)
	    	{
	    		for(int j=0;j<a.length;j++)
	    		{
	    			int c=0;
	    			int x=a[j][i];
	    			for(int k=0;k<a.length;k++)
	    			{
	    				if(x==a[k][i])
	    				c++;
	    					if(c==2)
	    					{
	    						cl++;
	    						break of;
	    					}
	    				
	    			}
	    		}
	    		
	    	}
	         return cl;
	    }

}

	   

