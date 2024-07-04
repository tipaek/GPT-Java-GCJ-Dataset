import java.util.*;
import javax.swing.*;

public class Test{
	private static Scanner sc;
	static int tp=1;
	public static void main(String[] args)
	{
		sc = new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
			solve();
		}
	}
	private static void solve()
	{
		int n=sc.nextInt();
		int[][] mt = new int[n][2];
		int[][] mst = mt.clone();
		char person = 'J';
		char[] chars = new char[n];
		Stack<int[]> jst = new Stack<>();
		Stack<int[]> cst= new Stack<>();
		boolean imp=false;
		
		Map<int[],Integer> map=new HashMap<>();
		
		for(int i=0;i<mt.length;i++)
		{
			for(int j=0;j<mt[i].length;j++)
			{
				mt[i][j]=sc.nextInt();
			}
			map.put(mt[i],i);
			
		}
		Arrays.sort(mst,new Comparator<int[]>(){
			 @Override
			 public int compare(int[] a,int[] b) {
				 return a[0]-b[0];
			 }
			 
			 
		});
		for(int i=0;i<mst.length;i++)
		{
			chars[map.get(mst[i])]=person;
			if (i<mst.length-1 && lap(mst[i],mst[i+1]))
			{
				if(person=='J')
				{
					jst.push(mst[i]);
					person=gp(person);
					
					if (!cst.isEmpty() && lap(cst.peek(),mst[i+1]))
					{
						imp=true;
						break;
					}
				}
				else
				{
					cst.push(mst[i]);
					person=gp(person);
					if(!jst.isEmpty() && lap(jst.peek(),mst[i+1]))
					{
						imp=true;
						break;
					}
				}
			}
			else
			{
				if(person=='J')
				{
					jst.push(mst[i]);
				}
				else
				{
					cst.push(mst[i]);
				}
			}
		}
		System.out.println("Case #"+ (tp++)+": "+ (imp ? "IMPOSSIBLE" : new String(chars)));	
		
	}
	private static char gp(char p)
	{
		return p=='J' ? 'C' : 'J';
	}
	private static boolean lap(int[] x,int[] y)
	{
		return x[1]>y[0];
	}
	
}