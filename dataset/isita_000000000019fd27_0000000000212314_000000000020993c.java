import java.awt.*;
import java.awt.geom.Point2D;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner console = new Scanner(System.in);
		int cases = console.nextInt();
		HashSet<Integer> hash = new HashSet<>();
		
		for(int i = 0; i < cases; i++)
		{
			System.out.println(i);
			boolean repeats = false;
			int N = console.nextInt();
			
			int[][] matrix = new int[N][N];
			int trace = 0;
			
			int rowRep = 0;
			for(int j = 0; j < N; j++)
			{
				HashSet<Integer> row = new HashSet<>();
				boolean rep = false;
				
				for(int k = 0; k < N; k++)
				{
					
					int num = console.nextInt();
					System.out.println(num);
					matrix[j][k] = num;
					if(!row.add(num))
						rep = true;
					if(j == k)
					{
						trace += num;
						hash.add(num);
					}
				}
				if(rep)
					rowRep++;
			}
			int colRep = 0;
			for(int j = 0; j < N; j++)
			{
				HashSet<Integer> col = new HashSet<>();
				boolean rep = false;
				
				for(int k = 0; k < N; k++)
				{
					
					int num = matrix[j][k];
					if(!col.add(num))
						rep = true;
					if(j == k)
					{
						hash.add(num);
					}
				}
				if(rep)
					colRep++;
			}
			if(hash.size() != N)
				repeats = true;
			
			System.out.println("Case #" + (i + 1) + ":" + trace + " " + rowRep + " " + colRep);
		}
	}

}
