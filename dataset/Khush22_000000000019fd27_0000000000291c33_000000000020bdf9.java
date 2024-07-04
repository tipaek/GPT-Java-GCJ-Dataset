import java.util.*;
import java.util.Arrays;
import java.io.*;
public class Solution
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		System.out.println();
		for(int k=0; k<t;k++)
		{
			int n = sc.nextInt();
			char[] c = new char[n];
			int[][] v = new int[n][3];
			for(int i=0;i<n;i++)
			{
				v[i][0]=sc.nextInt();
				v[i][1]=sc.nextInt();
				v[i][2]=i;
			}
			sortbyColumn(v);
			int j_last=0,c_last=0,flag=0;
			for(int i=0;i<n;i++)
			{
			    if(v[i][0]>=c_last)
			    {
				c[v[i][2]]='C';
				c_last=v[i][1];
			    }
			    else if(v[i][0]>=j_last)
			    {
				c[v[i][2]]='J';
				j_last=v[i][1];
			    }
			    else
			    {
				flag=1;
				break;
			    }
			}
			if(flag==1)
			    System.out.println("Case #"+(k+1)+": "+"IMPOSSIBLE");
			else
			{
			    System.out.print("Case #"+(k+1)+": ");
			    for(int i=0;i<n;i++)
				System.out.print(c[i]);
			    System.out.println();
			}
 		}
	}
	public static void sortbyColumn(int arr[][]) 
	    { 
		Arrays.sort(arr, new Comparator<int[]>() 
		{ 
		  public int compare(final int[] entry1, final int[] entry2)
		 { 
	  
		    if (entry1[0] > entry2[0]) 
			return 1; 
		    else
			return -1; 
		  } 
		}); 
	    } 
}
