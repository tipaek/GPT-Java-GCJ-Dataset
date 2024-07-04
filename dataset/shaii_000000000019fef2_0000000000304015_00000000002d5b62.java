import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static HashMap<String, String> SavedShortestPathes = new HashMap<>(10000);
	static{
		SavedShortestPathes.put("0,1", "N");
		SavedShortestPathes.put("1,0", "E");
		SavedShortestPathes.put("-1,0", "W");
		SavedShortestPathes.put("0,-1", "S");
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(
				System.in)));
		int testCasesNum = scanner.nextInt();
		for (int i = 1; i <= testCasesNum; i++) {
			int X = scanner.nextInt();
			int Y = scanner.nextInt();
			String result;
			if ((X % 2 == 0 && Y % 2 == 0) || (X % 2 != 0 && Y % 2 != 0))
				result = "IMPOSSIBLE";
			else
				result = calculateSteps(0, 0, X, Y, "");
			System.out.println("Case #" + i + ": " + result);
		}
		try{
			scanner.close();
		}
		catch (Exception e){}
		System.out.flush();
	}
	
	private static String calculateSteps(int fromX, int fromY, int X, int Y, String stepsSoFar)
	{
		LinkedList<Node> list = new LinkedList<>();
		if (X % 2 != 0){
			list.offer(new Node("E", 1, 0));
			list.offer(new Node("W", -1, 0));
		}
		else {
			list.offer(new Node("N", 0, 1));
			list.offer(new Node("S", 0, -1));
		}
		do {
			Node n = list.poll();
			if (n.x == X && n.y == Y)
			{
				return n.stepsSoFar;
			}
			int i = n.stepsSoFar.length();
			int stepSize = (int) Math.pow(2, i);
			String key = n.x + "," + (n.y + stepSize);
			String savedPath = SavedShortestPathes.get(key);
			if (savedPath == null || savedPath.length()>i)
				SavedShortestPathes.put(key, n.stepsSoFar + 'N');
				list.offer(new Node(SavedShortestPathes.get(key), n.x, n.y + stepSize));
			
			key = (n.x + stepSize) + "," + n.y ;
			savedPath = SavedShortestPathes.get(key);
			if (savedPath == null || savedPath.length()>i)
				SavedShortestPathes.put(key, n.stepsSoFar + 'E');
			list.offer(new Node(SavedShortestPathes.get(key), n.x + stepSize, n.y));
			
			key = (n.x - stepSize) + "," + n.y ;
			savedPath = SavedShortestPathes.get(key);
			if (savedPath == null || savedPath.length()>i)
				SavedShortestPathes.put(key, n.stepsSoFar + 'W');
			list.offer(new Node(SavedShortestPathes.get(key), n.x - stepSize, n.y));
			
			key = n.x + "," + (n.y - stepSize);
			savedPath = SavedShortestPathes.get(key);
			if (savedPath == null || savedPath.length()>i)
				SavedShortestPathes.put(key, n.stepsSoFar + 'S');
			list.offer(new Node(SavedShortestPathes.get(key), n.x, n.y - stepSize));
			
		}
		while (true);
	}
	
	private static class Node{
		public String stepsSoFar;
		public int x;
		public int y;
		public Node(String stepsSoFar, int x, int y) {
			this.stepsSoFar = stepsSoFar;
			this.x = x;
			this.y = y;
		}
	}
}
