package package1;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution 
{
	    public int a;
	    public int b;
	    public int c;

	    public Solution(int a, int b,int c) 
	    {
	        this.a = a;
	        this.b = b;
	        this.c=c;
	    }
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		    int i,j,k,s,m,n;
		    boolean row;
		    boolean []col;
		    Scanner input = new Scanner(System.in); 
			m=input.nextInt();
			ArrayList<Solution> res = new ArrayList<>();
		    for (i=0;i<m;i++)
		    {  
		    	n=input.nextInt();
		    	Solution r =  new Solution(0,0,0);		       
		        int [][]matrix = new int [n][n];
		        col = new boolean[n];
		        for (j=0;j<n;j++) 
		        	col[j] = false;
		        for (j=0;j<n;j++)
		        {
		            row = false;
		            for (k=0;k<n;k++)
		            {
		                matrix[j][k]=input.nextInt();
		                if(j==k) r.a+=matrix[j][k];
		                if (k>0 && !row)
		                    for (s=0;s<k;s++)
		                        if(matrix[j][s] == matrix[j][k])
		                        {
		                            row = true;
		                            r.b++;
		                            break;
		                        }
		                if (j>0 && !col[k])
		                    for (s=0;s<j;s++)
		                        if(matrix[s][k] == matrix[j][k])
		                        {
		                            col[k] = true;
		                            r.c++;
		                            break;
		                        }
		            }
		        }
		        res.add(r);
		    }
		    input.close();
		    for (i=0;i<res.size();i++)
		       System.out.println("Case #"+String.valueOf(i+1)+": "+res.get(i).a+" "+res.get(i).b+" "+res.get(i).c+" ");
		    res.clear();
		    return;
		}
}
