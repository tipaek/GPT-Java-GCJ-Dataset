import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	public static HashMap<Integer, String> mySolutions = new HashMap<Integer,String>();
	public static int bestSolution = Integer.MAX_VALUE; 
	public static int maxJump = Integer.MAX_VALUE; 
	
public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int jump = 1;
			bestSolution = maxJump; 
			mySolutions = new HashMap<Integer,String>();
			int X = sc.nextInt();
			int Y = sc.nextInt();
			int result = maxJump;
			result = solve(0,0,X,Y,jump,"",0);
			if(result != maxJump) {
				String toPrint = mySolutions.get(result);
				System.out.println("Case #"+(i+1)+": "+toPrint);
			} else {
				System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
			}
		}
	}
	
	public static int solve(int startX, int startY, int goalX, int goalY, int jump, String solution, int numJump) {
		
		if(numJump > bestSolution)
			return maxJump;
		// est, west, north, solution
		int Est = maxJump;
		int West = maxJump; 
		int North = maxJump;
		int South = maxJump;
		if(startX == goalX && startY == goalY) {
			mySolutions.put(numJump,solution);
			if(numJump < bestSolution)
				bestSolution = numJump;
			return numJump;
		}
		if(startX != goalX && ((startX+jump > goalX && goalX > 0) || (startX-jump < goalX && goalX < 0)
				|| (startX+2*jump < goalX && startX > 0) || (startX-2*jump > goalX && startX < 0)))
			return maxJump;
		if(startY != goalY && ((startY+jump > goalY && goalY > 0) || (startY-jump < goalY && goalY < 0)
				|| (startY+2*jump < goalY && startY < 0) || (startY-2*jump > goalY && startY < 0)))
			return maxJump;
		if(goalY != startY) {
			North = solve(startX, startY+jump, goalX, goalY, jump*2, solution+"N",numJump+1);
			South = solve(startX, startY-jump, goalX, goalY, jump*2, solution+"S",numJump+1);
		}
		if(goalX != startX) {
			Est = solve(startX+jump, startY, goalX, goalY, jump*2, solution+"E",numJump+1);
			West = solve(startX-jump, startY, goalX, goalY, jump*2, solution+"W",numJump+1);
		}
		return Math.min(Est, Math.min(West, Math.min(North, South)));
	}
}
