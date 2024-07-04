import java.util.*;
import java.io.*;

public class Solution
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
	//	System.out.println(t);
		for(int i=0;i<t;i++)
		{
			int n = sc.nextInt();
			int array[][] = new int[n][n];
			int trans[][] = new int[n][n];
			
			//System.out.println(n);
		    sc.nextLine();
		
			int k=0;
			int r=0;
			int c=0;
			int row[] = new int[n];
			int col[] = new int[n];
			for(int a=0;a<n;a++)
			{
			    for(int b=0;b<n;b++)
			    {
			        array[a][b] = sc.nextInt();
			        row[b]=array[a][b];
			        if(a==b)
			        {
			            k+=array[a][b];
			        }
			       
			    }
			    Arrays.sort(row);
			    int q=0;
			    while(q<n-1)
			    {
			        
			        if(row[q]==row[q+1])
			        {
			            //System.out.println("HI");
			            r++;
			            break;
			        }
			        else
			        {
			            q++;
			        }
			    }
			}
		
			
			for(int a=0;a<n;a++)
			{
			    for(int b=0;b<n;b++)
			    {
			        trans[a][b] = array[b][a];
			       col[b]=trans[a][b];
			    }
			    Arrays.sort(col);
			    int q=0;
			    while(q<n-1)
			    {
			        if(col[q]==col[q+1])
			        {
			            c++;
			            break;
			        }
			        else
			        {
			            q++;
			        }
			    }
			    
			}
			

		
			
		System.out.println("Case #"+(i+1)+": "+k+" "+r+" "+c);
			
			
			
		}
	}
}