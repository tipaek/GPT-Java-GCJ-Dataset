import java.awt.*;
import java.awt.geom.Point2D;
import java.util.*;

public class Beehive2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner console = new Scanner(System.in);
		int cases = console.nextInt();
		HashSet<Integer> hash = new HashSet<>();
		
		for(int i = 0; i < cases; i++)
		{
			System.out.println("Case" + (i + 1));
			int N = console.nextInt();
			System.out.println("n" + (N));
			int[][] matrix = new int[N][N];
			int trace = 0;
			
			int rowRep = 0;
			for(int j = 0; j < N; j++)
			{
				HashSet<Integer> row = new HashSet<>();
				boolean rep = false;
				
				for(int k = 0; k < matrix.length; k++)
				{
					System.out.println("hi");
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
			for(int a = 0; a < N; a++)
			{
				HashSet<Integer> col = new HashSet<>();
				boolean rep = false;
				
				for(int b = 0; b < N; b++)
				{
					
					int num = matrix[b][a];
					if(!col.add(num))
						rep = true;
				}
				if(rep)
					colRep++;
			}
			
			System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowRep + " " + colRep);
		}
	}

}
