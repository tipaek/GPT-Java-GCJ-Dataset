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
			
			int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE, minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
			
			Map<String, ArrayList<Location>> pathMap = new HashMap<String, ArrayList<Location>>();
			Set<String> unvisited = new HashSet<String>();
			pathMap.put(x + " " + y, new ArrayList<Location>());
			pathMap.get(x + " " + y).add(new Location(x, y, 0));
			unvisited.add(x + " " + y);
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
				
				if(x < minX)
					minX = x;
				else if(x > maxX)
					maxX = x;
				
				if(y < minY)
					minY = y;
				else if(y > maxY)
					maxY = y;
				
				unvisited.add(x + " " + y);
				if(!pathMap.containsKey(x + " " + y))
					pathMap.put(x + " " + y, new ArrayList<Location>());
				pathMap.get(x + " " + y).add(new Location(x, y, i + 1));
			}
			
			if(minX <= 0 && maxX <= 0)
				maxX = 0;
			else if(minX >= 0 && maxX >= 0)
				minX = 0;
			
			if(minY <= 0 && maxY <= 0)
				maxY = 0;
			else if(minY >= 0 && maxY >= 0)
				minY = 0;
			
			Set<String> visited = new HashSet<String>();
			Queue<Location> queue = new LinkedList<Location>();
			queue.add(new Location(0, 0, 0));
			int minDistance = Integer.MAX_VALUE;
			while(!unvisited.isEmpty())
			{
				Location temp = queue.remove();
				while((!queue.isEmpty() && visited.contains(temp.getCoords())) || temp.getX() > maxX || temp.getX() < minX || temp.getY() > maxY || temp.getY() < minY)
					temp = queue.remove();
				
				if(pathMap.containsKey(temp.getCoords()))
				{
					unvisited.remove(temp.getCoords());
					for(Location celeb : pathMap.get(temp.getCoords()))
						if(temp.getDist() <= celeb.getDist() && celeb.getDist() < minDistance)
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