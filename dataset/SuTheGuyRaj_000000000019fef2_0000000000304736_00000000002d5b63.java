import java.io.*;
import java.util.*;

public class Solution {
	public static int next(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}
	static int T, A, B;
	static BufferedReader sc;
	static boolean center;
	public static void main(String[] args) throws Exception {
		sc = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(sc.readLine());
		T = next(st);
		A = next(st);
		B = next(st);
		name: for(int tt = 0; tt < T; tt++) {
			for(int x = -7; x <= 7; x++) {
				for(int y = -7; y <= 7; y++) {
					hits(x, y);
					if(center) {
						continue name;
					}
				}
			}
		}
		
		sc.close();
	}
	
	public static boolean hits(int x, int y) throws IOException{
		System.out.println(x + " " + y);
		System.out.flush();
		String s = sc.readLine();
		if(s.equals("CENTER")) {
			center = true;
		}
		return (s.equals("HIT"));
	}
}
