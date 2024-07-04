import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
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

			list.offer(new Node(n.stepsSoFar + 'N', n.x, n.y + stepSize));
			list.offer(new Node(n.stepsSoFar + 'E', n.x + stepSize, n.y));
			list.offer(new Node(n.stepsSoFar + 'W', n.x - stepSize, n.y));
			list.offer(new Node(n.stepsSoFar + 'S', n.x, n.y - stepSize));
			
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