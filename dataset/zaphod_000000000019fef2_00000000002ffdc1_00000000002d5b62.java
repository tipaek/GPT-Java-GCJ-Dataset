import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution
{

	public static final char[] DIRECTIONS = { 'N', 'S', 'W', 'E' };

	public static void main(String[] args) throws IOException
	{

		BufferedReader in = new BufferedReader(new InputStreamReader
		(System.in));

		int noOfCases = Integer.parseInt(in.readLine());

		for (int caseNo = 1; caseNo <= noOfCases; caseNo++)
		{
			StringTokenizer data = new StringTokenizer(in.readLine());
			int X = Integer.parseInt(data.nextToken());
			int Y = Integer.parseInt(data.nextToken());

			HashSet<Path> paths = new HashSet<Path>();
			paths.add(new Path(0, 0));
			boolean found = false;
			int distance = 1;
			String path = "IMPOSSIBLE";
			while (!found)
			{
				HashSet<Path> newPaths = new HashSet<Path>();

				for (Path old : paths)
				{
					for (int i = 0; i < DIRECTIONS.length && !found; i++)
					{
						Path newPath = new Path(old, DIRECTIONS[i], distance);
						if (newPath.x == X && newPath.y == Y)
						{
							path = newPath.path.toString();
							found = true;
						}
						else if (!newPaths.contains(newPath))
							newPaths.add(newPath);
					}
					if (found)
						break;
				}
				paths = newPaths;
				distance *= 2;

				// Only good for first two cases
				if (distance > 128)
					break;
			}

			System.out.printf("Case #%d: %s%n", caseNo, path);
		}
		in.close();

	}
}

class Path
{
	StringBuilder path;
	int x, y;

	public Path(int x, int y)
	{
		this.path = new StringBuilder();
		this.x = x;
		this.y = y;
	}

	public Path(Path other, char direction, int distance)
	{
		this.path = new StringBuilder(other.path);
		path.append(direction);
		this.x = other.x;
		this.y = other.y;
		if (direction == 'N')
			this.y+=  distance;
		else if (direction == 'S')
			this.y-=  distance;
		else if (direction == 'W')
			this.x -= distance;
		else
			this.x+=  distance;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Path other = (Path) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	public String toString()
	{
		return String.format("%s (%d, %d)", path.toString(), x, y);
	}

}