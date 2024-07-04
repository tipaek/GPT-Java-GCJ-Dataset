import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {
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
					if(row.containsKey(x))
					{
						row.get(x).add(arr[x][y]);
						//System.out.println(row);
					}
					else
					{
						Set<Integer> set=new HashSet<Integer>();
						set.add(arr[x][y]);
						row.put(x, set);
					}
					if(column.containsKey(y))
					{
						column.get(y).add(arr[x][y]);
					}
					else
					{
						Set<Integer> set=new HashSet<Integer>();
						set.add(arr[x][y]);
						column.put(y, set);
					}
				}
			}
			//System.out.println(row);
			//System.out.println(column);
			for(int a=0;a<l;a++)
			{
				if(row.get(a).size()!=l)
				{
					r++;
				}
			}
			for(int a=0;a<l;a++)
			{
				if(column.get(a).size()!=l)
				{
					c++;
				}
			}
			System.out.println("Case #"+(i+1)+": "+k+" "+r+" "+c);
		}
	}
}
