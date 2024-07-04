import java.util.*;
import java.io.*;

public class vestigium {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i = 1; i<=t; ++i)
		{
			int n = in.nextInt();
			int trace = 0;
			int[][] matrix = new int[n][n];
			int r = 0;
			int c = 0;
			boolean done = false;
			for(int dos = 0; dos<n; dos++)
			{
				for(int tres = 0; tres<n; tres++)
				{
					int next = in.nextInt();
					matrix[dos][tres] = next;
				}
			}
			for(int cuat = 0; cuat<n; cuat++)
			{
				trace+=matrix[cuat][cuat];
			}
			for(int cinco = 0; cinco<n; cinco++)
			{
				done = false;
				for(int seis = 0; seis<n; seis++)
				{
					int temp = matrix[cinco][seis];
					for(int other = seis+1; other<n; other++)
					{
						if(temp == matrix[cinco][other]&&done!=true)
						{
							r+=1;
							done=true;
						}
					}
				}
			}
			for(int col = 0; col<n; col++)
			{
				done=false;
				for(int row = 0; row<n; row++)
				{
					int temp = matrix[row][col];
					for(int other2 = row+1; other2<n; other2++)
					{
						if(temp == matrix[other2][col]&&done!=true)
						{
							c+=1;
							done=true;
						}
					}
				}
			}
			System.out.println("Case #"+i+": "+trace+" "+r+" "+c);
		}
	}
}
