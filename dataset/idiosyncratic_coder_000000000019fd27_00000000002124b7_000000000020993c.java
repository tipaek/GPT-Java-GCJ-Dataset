import java.io.*;
import java.util.*;
import java.math.*;
public class Solution {
	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(System.in);
		int nc = in.nextInt();
		for(int i = 0; i < nc; i++)
		{
			int n = in.nextInt();
			int[][] m = new int[n][n];
			int trace = 0;
			int r = 0;
			int c = 0;
			TreeSet<Integer> ru = new TreeSet<Integer>();
			ArrayList<Integer> cu = new ArrayList<Integer>();
			for(int row = 0; row < n; row++)
			{
				ru.clear();
				for(int col = 0; col < n; col++)
				{
					m[row][col] = in.nextInt();
					if(row == col)
					{
						trace += m[row][col];
					}
					ru.add(m[row][col]);
				}
				if(ru.size() != n) r++;
			}
			for(int co = 0; co < n; co++)
			{
				cu.clear();
				for(int ro = 0; ro < n; ro++)
				{
					if(cu.contains(m[ro][co]))
					{
						c++;
						break;
					}
					else
					{
						cu.add(m[ro][co]);
					}
				}
			}
			System.out.printf("Case #%d: ", i + 1);
			System.out.println(trace + " " + r + " " + c);
		}
	}
}
