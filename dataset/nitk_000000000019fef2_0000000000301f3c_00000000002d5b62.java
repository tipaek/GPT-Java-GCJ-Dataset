import java.util.*;
import java.io.*;

public class Solution
{
	private static BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;
	
	public static void main(String[] args) throws IOException
	{
		int numTestCases = Integer.parseInt(infile.readLine());
		for(int t = 1; t <= numTestCases; t++)
		{
			tokens = new StringTokenizer(infile.readLine());
			int x = Integer.parseInt(tokens.nextToken());
			int y = Integer.parseInt(tokens.nextToken());
			System.out.println("Case #" + t + ": " + recur("", 0, 0, x, y, 1));
		}
	}
	private static String recur(String path, int currX, int currY, int x, int y, int jump)
	{
		if(currX == x && currY == y)
			return path;
		if(jump > 2000000000)
			return "IMPOSSIBLE";
		String north = recur(path + "N", currX, currY + jump, x, y, jump * 2);
		String south = recur(path + "S", currX, currY - jump, x, y, jump * 2);
		String west = recur(path + "W", currX - jump, currY, x, y, jump * 2);
		String east = recur(path + "E", currX + jump, currY, x, y, jump * 2);
		String toReturn = north;
		if((toReturn.equals("IMPOSSIBLE") && !south.equals("IMPOSSIBLE")) || (!toReturn.equals("IMPOSSIBLE") && south.length() < toReturn.length()))
			toReturn = south;
		if((toReturn.equals("IMPOSSIBLE") && !west.equals("IMPOSSIBLE")) || (!toReturn.equals("IMPOSSIBLE") && west.length() < toReturn.length()))
			toReturn = west;
		if((toReturn.equals("IMPOSSIBLE") && !east.equals("IMPOSSIBLE")) || (!toReturn.equals("IMPOSSIBLE") && east.length() < toReturn.length()))
			toReturn = east;
		return toReturn;
	}
}
