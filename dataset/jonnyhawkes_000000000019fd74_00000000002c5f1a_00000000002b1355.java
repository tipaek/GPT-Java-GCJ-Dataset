
import java.util.*;
import java.io.*;
public class Solution
{
	
		public int skill = 0;
		public Solution up = null;
		public Solution down = null;
		public Solution left = null;
		public Solution right = null;
		public double neighbors = 0;
		
		public Solution(int newskill)
		{
			skill = newskill;
		}
		
		public void score()
		{
			neighbors = 0;
			int count = 0;
			if(left != null)
			{
				neighbors += left.skill;
				++count;
			}
			if(up != null)
			{
				neighbors += up.skill;
				++count;
			}
			if(down != null)
			{
				neighbors += down.skill;
				++count;
			}
			if(right != null)
			{
				neighbors += right.skill;
				++count;
			}
			
			if(count>0)
				neighbors = neighbors/count;
		}
	
		
	public static void main(String[] args) 
	{

		
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		
		for (int i = 1; i <= t; ++i)
		{	
			int R = in.nextInt();
			int C = in.nextInt();
			
			Solution [][] grid = new Solution[R][C];
			ArrayList<Solution> stillDancing = new ArrayList<Solution>();
			
			ArrayList<String> oMatchedTokens = new ArrayList<String>();
			for(int r=0;r<R;++r)
			{
				for(int c=0;c<C;++c)					
					grid[r][c] = new Solution(in.nextInt());
			}


			for(int r=0;r<R;++r)
			{
				for(int c=0;c<C;++c)
				{
					if(c>0)
						grid[r][c].left = grid[r][c-1];
					if(r>0)
						grid[r][c].up = grid[r-1][c];
					if(c<C-1)
						grid[r][c].right = grid[r][c+1];
					if(r<R-1)
						grid[r][c].down = grid[r+1][c];
					
					stillDancing.add(grid[r][c]);
				}
			}


			boolean bRemoved = true;
			int competition = 0;				
			
			while (bRemoved)
			{
				int round = 0;
				bRemoved = false;

				for(int d=0;d<stillDancing.size();++d)
				{
					stillDancing.get(d).score();
					round += stillDancing.get(d).skill;
				}

				for(int d=stillDancing.size()-1;d>=0;--d)
				{
					if(stillDancing.get(d).skill < stillDancing.get(d).neighbors)
					{
						if(stillDancing.get(d).left != null)
							stillDancing.get(d).left.right = stillDancing.get(d).right;

						if(stillDancing.get(d).up != null)
							stillDancing.get(d).up.down = stillDancing.get(d).down;

						if(stillDancing.get(d).right != null)
							stillDancing.get(d).right.left = stillDancing.get(d).left;

						if(stillDancing.get(d).down != null)
							stillDancing.get(d).down.up = stillDancing.get(d).up;

						bRemoved = true;
						stillDancing.remove(d);
					}
				}

				
				competition += round;
			}
			
			
			
			System.out.println("Case #"  + i + ": " + competition);

		}

		in.close();
	}
}
