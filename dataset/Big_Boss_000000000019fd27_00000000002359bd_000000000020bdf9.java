import java.util.Arrays;
import java.util.Comparator;
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
			Arrays.sort(time, Comparator.comparing((int[] itv) -> itv[0]));
			PriorityQueue<Integer> cameron = new PriorityQueue<>();
			PriorityQueue<Integer> jamie = new PriorityQueue<>();
			StringBuilder res= new StringBuilder();
			for (int[] itv : time) 
			{
		        if (cameron.isEmpty()) 
		        {
		            cameron.offer(itv[1]);
		            res.append('C');
		        } 
		        else if (jamie.isEmpty()) 
		        {
		            jamie.offer(itv[1]);
		            res.append('J');
		        }
		        else
		        {
		            if (itv[0] >= cameron.peek()) 
		            {
		                cameron.poll();
		                cameron.offer(itv[1]);
			            res.append('C');
		            } 
		            else if(itv[0] >= jamie.peek())
		            {
		            	jamie.poll();
		                jamie.offer(itv[1]);
			            res.append('J');
		            }
		            else
		            {
		            	res.delete(0, res.length());
		            	res.append("IMPOSSIBLE");
		            	break;
		            }
		 
		        }
		    }
			System.out.println("Case #" + i + ": "+res);
		}
	}

}
