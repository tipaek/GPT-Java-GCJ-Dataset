import java.util.*;
import java.io.*;


public class Solution {
	
	static LinkedList<State> ll;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			ll = new LinkedList<State>();
			pw.println("Case #" + i + ": " );
			int N = Integer.parseInt(br.readLine());
			if (N == 1) pw.println("1 1");
			else if (N == 2) {
				pw.println("1 1");
				pw.println("2 1");
			} 
			else if (N == 3) {
				pw.println("1 1");
				pw.println("2 1");
				pw.println("3 1");
			} else {
				pw.println("1 1");
				pw.println("2 1");
				pw.println("3 2");
				N = N-4;
				int temp = 3;
				while (N - temp >= 0) {
					N = N-temp;
					pw.println((temp+1) + " " + 2);
					temp++;
				}
				while (N != 0) {
					N = N-1;
					pw.println(temp + " " + 1);
					temp++;
				}
			}
			
			
			
			
		}
		pw.close();
		
		
		
	}
	
	public static boolean dfs(int steps, int up, int down, int last_up, int last_down, long value, int goal) {
		if (up < 0 || down < 0 || down > up)
			return false;
		if (steps > 500) 
			return false;
		if (up == last_up || down==last_down) return false;
		if (value == goal) return true;
		if (down != 0) {
		}
		return false;
	}
	 static class State {
		   int x;
		   int y;
		   
		   public State(int a, int b) {
			   x = a;
			   y = b;
		   }
		   
	   }



}