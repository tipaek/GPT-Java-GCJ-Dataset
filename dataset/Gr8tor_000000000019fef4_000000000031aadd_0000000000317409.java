import java.io.*;
import java.util.*;

public class Solution{
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int i = 0; i < T; i++) {
			System.out.print("Case #" + (i+1) + ": ");
			StringTokenizer st = new StringTokenizer(in.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			HashMap<Character, int[]> dir = new HashMap<Character, int[]>();
			dir.put('N', new int[] {0, 1});
			dir.put('S', new int[] {0, -1});
			dir.put('E', new int[] {1, 0});
			dir.put('W', new int[] {-1, 0});
			
			String moves = st.nextToken();
			int px = X;			
			int py = Y;
			
			boolean way = false;
			for (int m = 0; m < moves.length(); m++) {
				char c = moves.charAt(m);
				int[] newP = dir.get(c);
				px += newP[0];
				py += newP[1];
				
				if (Math.abs(px) + Math.abs(py) <= (m+1)) {
					System.out.println(m+1);
					way = true;
					break;
				}
			}
			
			if (!way) 
				System.out.println("IMPOSSIBLE");
			
		}
	}
}
