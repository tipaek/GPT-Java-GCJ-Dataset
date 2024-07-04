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
			String path = tokens.nextToken();
			
			Map<String, ArrayList<Location>> pathMap = new HashMap<String, ArrayList<Location>>();
			Set<String> unvisited = new HashSet<String>();
			pathMap.put(x + " " + y, new ArrayList<Location>());
			pathMap.get(x + " " + y).add(new Location(x, y, 0));
			for(int i = 0; i < path.length(); i++)
			{
				if(path.charAt(i) == 'N')
					y++;
				else if(path.charAt(i) == 'S')
					y--;
				else if(path.charAt(i) == 'E')
					x++;
				else if(path.charAt(i) == 'W')
					x--;
				unvisited.add(x + " " + y);
				if(!pathMap.containsKey(x + " " + y))
					pathMap.put(x + " " + y, new ArrayList<Location>());
				pathMap.get(x + " " + y).add(new Location(x, y, i + 1));
			}
			
			Set<String> visited = new HashSet<String>();
			Queue<Location> queue = new LinkedList<Location>();
			queue.add(new Location(0, 0, 0));
			int minDistance = Integer.MAX_VALUE;
			while(!unvisited.isEmpty())
			{
				Location temp = queue.remove();
				while(!queue.isEmpty() && visited.contains(temp.getCoords()))
					temp = queue.remove();
				
				if(pathMap.containsKey(temp.getCoords()))
				{
               unvisited.remove(temp.getCoords());
					for(Location celeb : pathMap.get(temp.getCoords()))
						if(temp.getDist() <= celeb.getDist())
						{
							minDistance = celeb.getDist();
							break;
						}
				}
				
				visited.add(temp.getCoords());
				
				queue.add(new Location(temp.getX() + 1, temp.getY(), temp.getDist() + 1));
				queue.add(new Location(temp.getX() - 1, temp.getY(), temp.getDist() + 1));
				queue.add(new Location(temp.getX(), temp.getY() + 1, temp.getDist() + 1));
				queue.add(new Location(temp.getX(), temp.getY() - 1, temp.getDist() + 1));
			}
			if(minDistance == Integer.MAX_VALUE)
				System.out.println("Case #" + t + ": IMPOSSIBLE");
			else
				System.out.println("Case #" + t + ": " + minDistance);
		}
	}
}

class Location
{
	private int myX, myY, myDist;
	private String coords;
	
	public Location(int x, int y, int d)
	{
		myX = x;
		myY = y;
		myDist = d;
		coords = myX + " " + myY;
	}
	
	public int getX()
	{
		return myX;
	}
	public int getY()
	{
		return myY;
	}

	public int getDist()
	{
		return myDist;
	}
	public String getCoords()
	{
		return coords;
	}
	
	public void setDist(int d)
	{
		myDist = d;
	}
	
	public boolean equals(Location other)
	{
		if(myX == other.myX && myY == other.myY && myDist == other.myDist)
			return true;
		return false;
	}
}