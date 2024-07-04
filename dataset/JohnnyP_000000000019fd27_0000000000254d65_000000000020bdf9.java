import java.util.*;
import java.lang.*;
import java.io.*;
     
public class Solution
{
	
   	public static void main (String[] args) throws java.lang.Exception
   	{
		
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();
		
		for(int test = 0;test<t;test++)
		{
			
			int n = in.nextInt();
			
			int[][] ns = new int[n][2];
			int[][] orig = new int[n][2];
			
			for(int i=0;i<n;i++)
			{
				ns[i][0]= in.nextInt();
				ns[i][1]=  in.nextInt();
				orig[i][0] = ns[i][0];
				orig[i][1] = i;
				
			}
			
			Arrays.sort(ns, new Comparator<int[]>() {
				public int compare(int[] a, int[] b){
					if(a[0] > b[0])
						return 1;
					if(a[0] < b[0])
						return -1;
					return 0;
				}
			});
			
			Arrays.sort(orig, new Comparator<int[]>() {
				public int compare(int[] a, int[] b){
					if(a[0] > b[0])
						return 1;
					if(a[0] < b[0])
						return -1;
					return 0;
				}
			});
			
			
			char[] result = new char[n];
			
			result[0] = 'C';
			
			int check = -1;
			
			for(int i=0;i<n;i++)
			{
				
				if(check <= ns[i][0])
				{
					result[orig[i][1]] = 'C';
					ns[i][0]=-2;
					check = ns[i][1];
				}
				
			}
			
			check = -1;
			
			for(int i=0;i<n;i++)
			{
				
				if(check <= ns[i][0])
				{
					result[orig[i][1]] = 'J';
					ns[i][0]=-1;
					check = ns[i][1];
				}
				
			}
			
			System.out.print("Case #" + (test +1 ) + ": ");
			
			
			boolean ok =true;
			for(int i=0;i<n;i++)
			{
				if(ns[i][0] > 0)
				{
					ok = false;
					break;
				}
			}
			
			if(ok)
			{
				for(int i = 0; i< result.length;i++)
				{
					System.out.print(result[i]);
				}
				System.out.println();
			}
			else
			{
				System.out.println("IMPOSSIBLE");
			}
			
		}
		
    }
}