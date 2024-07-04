import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t=in.nextInt();
		for(int i=1; i<=t; i++)
		{
			int rows=in.nextInt();
			int[][] time=new int[rows][2];
			for(int l=0; l<rows; l++)
				for(int m=0; m<2; m++)
					time[l][m]=in.nextInt();
			System.out.println("Case #" + i + ": "+helper(time));
		}
	}
	
	public static StringBuilder helper(int[][] copytime)
	{
		int[][] time=new int[copytime.length][2];
		for(int l=0; l<copytime.length; l++)
			for(int m=0; m<2; m++)
				time[l][m]=copytime[l][m];
		Arrays.sort(time, Comparator.comparing((int[] itv) -> itv[0]));
		PriorityQueue<Integer> cameron = new PriorityQueue<>();
		PriorityQueue<Integer> jamie = new PriorityQueue<>();
		HashMap<Integer, Character> temp=new HashMap<Integer, Character>();
		StringBuilder res= new StringBuilder();
		for (int[] itv : time) 
		{
	        if (cameron.isEmpty()) 
	        {
	            cameron.offer(itv[1]);
	            //res.append('C');
	            temp.put(itv[0],'C');
	        } 
	        else if (jamie.isEmpty()) 
	        {
	            jamie.offer(itv[1]);
	            //res.append('J');
	            temp.put(itv[0],'J');
	        }
	        else
	        {
	            if (itv[0] >= cameron.peek()) 
	            {
	                cameron.poll();
	                cameron.offer(itv[1]);
		            //res.append('C');
	                temp.put(itv[0],'C');
	            } 
	            else if(itv[0] >= jamie.peek())
	            {
	            	jamie.poll();
	                jamie.offer(itv[1]);
		            //res.append('J');
	                temp.put(itv[0],'J');
	            }
	            else
	            {
	            	StringBuilder imp= new StringBuilder("IMPOSSIBLE");
	            	return imp;
	            }
	        }
	    }
		for(int i=0; i<copytime.length; i++)
		{
			res.append(temp.get(copytime[i][0]));
		}
		return res;
	}

}
