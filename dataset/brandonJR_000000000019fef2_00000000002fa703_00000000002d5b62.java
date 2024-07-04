package gcj201bExpogo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;


public class Solution {
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = Integer.parseInt(in.nextLine());
		
		for (int t=1; t<=T; t++){
			String result = null;
			result = doit(in.nextInt(), in.nextInt());

			System.out.printf("Case #%d: %s%n", t, result);
		}
	}

	private static String doit(int destx, int desty) {
		
		Stack<Character> path = new Stack<Character>();
		StringBuilder shortestPath = new StringBuilder();
		findPath(path, 0, 0, destx, desty, 1, shortestPath);
		
		if (path.isEmpty()) {
			return "IMPOSSIBLE";
		} else {
			return shortestPath.toString();
		}
	}

	private static boolean findPath(Stack<Character> path, int x, int y, int destx, int desty, int k, StringBuilder shortestPath) {
		if (x==destx && y==desty) {
			if (shortestPath.length() == 0) {
				path.stream().forEach(p -> shortestPath.append(p));
				return true;
			} else if (shortestPath.length() > path.size()) {
				shortestPath.setLength(0);
				path.stream().forEach(p -> shortestPath.append(p));
				return true;
			}
			return false;
		} 
		
		int hop = (int) Math.pow(2,k-1); 
		
		if (hop > 2*Math.max(Math.abs(destx),Math.abs(desty))) {
			return false;
		}
		
		//n
		path.add('N');
		if (findPath(path, x,y + hop, destx, desty, k+1, shortestPath)) {
			return true;
		} else {
			path.pop();
		}
			
		path.add('S');
		if (findPath(path, x,y - hop, destx, desty, k+1, shortestPath)) {
			return true;
		} else {
			path.pop();
		}
		
		//e	
		path.add('E');
		if (findPath(path, x + hop,y, destx, desty, k+1, shortestPath)) {
			return true;
		} else {
			path.pop();
		}
		
		//w
		path.add('W');
		if (findPath(path, x - hop,y, destx, desty, k+1, shortestPath)) {
			return true;
		} else {
			path.pop();
		}
		
		return false;
		
	}

}
