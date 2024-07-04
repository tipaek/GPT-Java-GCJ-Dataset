import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= t; ++i) {
	    		int r = in.nextInt();
	    		int c = in.nextInt();
	    		int interest = 0;
	    		int[][] skill = new int[r][c];
	    		for(int j = 0; j < r; j++) {
	    			for(int k = 0; k < c; k++){
	    				skill[j][k] = in.nextInt();
	    			}
	    		}
	    		boolean flag = true;
	    		while(flag) {
	    			interest += interestCalc(skill);
	    			flag = runOneRound(skill);
	    		}
	    		System.out.println("Case #" + i + ": " + interest);
	    }
	}
	
	public static boolean runOneRound(int[][]skill) {
		boolean answer = false;
		int[][] newskill = new int[skill.length][skill[0].length];
		for(int j = 0; j < skill.length; j++) {
			for(int k = 0; k < skill[0].length; k++){
				if(skill[j][k] != 0 && meanNeighbors(j,k, skill)) {
					newskill[j][k] = 0;
					answer = true;
				}
				else {
					newskill[j][k] = skill[j][k];
				}
			}
		}
		for(int j = 0; j < skill.length; j++) {
			for(int k = 0; k < skill[0].length; k++){
				skill[j][k]= newskill[j][k];
			}
		}
		return answer;
	}
	public static boolean meanNeighbors(int j, int k, int[][] skill) {
		int[] xs = new int[] {-1,0,0,1};
		int[] ys = new int[] {0,-1,1,0};
		int val = skill[j][k];
		int neighbors = 0;
		int neighTot = 0;
		for(int i = 0; i < xs.length; i++) {
			boolean flag = true;
			int counter = 0;
			while(flag) {
				counter++;
				int newx = j + (xs[i] * counter);
				int newy = k + (ys[i] * counter);
				if(!(newx >=0 && newy >= 0 && newx < skill.length && newy < skill[0].length)) {
					flag = false;
				}
				else {
					if(skill[newx][newy] != 0) {
						neighbors++;
						neighTot += skill[newx][newy];
						flag = false;
					}
				}
			}
		}
		return neighTot > (neighbors * val);
	}
	public static int interestCalc(int[][] skill) {
		int answer = 0;
		for(int j = 0; j < skill.length; j++) {
			for(int k = 0; k < skill[0].length; k++){
				answer+= skill[j][k];
			}
		}
		return answer;
	}

}
