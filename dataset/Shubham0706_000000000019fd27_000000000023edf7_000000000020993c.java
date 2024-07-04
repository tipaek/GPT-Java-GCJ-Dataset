import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Vestigium {
	public static void main(String as[])
	{
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		// case #i starts
		for(int i=0;i<N;i++)
		{
			HashMap<Integer,Set<Integer>> row=new HashMap<Integer,Set<Integer>>();
			HashMap<Integer,Set<Integer>> column=new HashMap<Integer,Set<Integer>>();
			int k=0;
			int r=0;
			int c=0;
			int l=scan.nextInt();
			int[][] arr=new int[l][l];
			for(int x=0;x<l;x++)
			{
				for(int y=0;y<l;y++)
				{
					arr[x][y]=scan.nextInt();
					if(x==y)
					{
						k=k+arr[x][y];
					}
				}
			}
			for(int x=0;x<l;x++)
			{
				HashSet<Integer> set=new HashSet<Integer>();
				for(int y=0;y<l;y++)
				{
					if(set.contains(arr[x][y]))
					{
						r++;
						break;
					}
					set.add(arr[x][y]);
				}
			}
			
			for(int y=0;y<l;y++)
			{
				HashSet<Integer> set=new HashSet<Integer>();
				for(int x=0;x<l;x++)
				{
					if(set.contains(arr[x][y]))
					{
						c++;
						break;
					}
					set.add(arr[x][y]);
				}
			}
			
			System.out.println("Case #"+(i+1)+": "+k+" "+r+" "+c);
		}
	}
}
