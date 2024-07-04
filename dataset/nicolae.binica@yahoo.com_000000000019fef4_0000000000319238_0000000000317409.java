import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {

	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int Q = in.nextInt();
		for(int test = 1; test <= Q; test ++){
			System.out.printf("Case #%d: ", test);
			
			solve(in);
			
			System.out.println();
		}
	}
	
	public static void solve(Scanner in) {
		
		int X = in.nextInt();
		int Y = in.nextInt();
		String path = in.next();
		
		for(int i = 0; i < path.length(); i ++) {
			char c = path.charAt(i);
			
			switch(c) {
			case 'N':
				Y++;
				break;
			case 'S':
				Y--;
				break;
			case 'W':
				X--;
				break;
			case 'E':
				X++;
				break;
			}
			if( Math.abs(X) + Math.abs(Y) <= i+1) {
				System.out.print(i+1);
				return;
			}
		}
		System.out.print("IMPOSSIBLE");
	}

}