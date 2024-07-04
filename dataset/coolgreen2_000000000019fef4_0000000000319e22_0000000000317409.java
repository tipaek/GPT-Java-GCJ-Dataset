import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		cycle: for (int cases = 1; cases <= T; cases++) {
	         System.out.print("Case #" + cases + ": " );
	         StringTokenizer st = new StringTokenizer(br.readLine());
	         int x = Integer.parseInt(st.nextToken());
	         int y = Integer.parseInt(st.nextToken());
	         String s = st.nextToken();
	         for (int i = 0; i < s.length(); i++) {
	        	 if (s.charAt(i) == 'N')
	        		 y++;
	        	 if (s.charAt(i) == 'S')
	        		 y--;
	        	 if (s.charAt(i) == 'E')
	        		 x++;
	        	 if (s.charAt(i) == 'W')
	        		 x--;
	        	 if (Math.abs(x) + Math.abs(y) <= i+1) {
	        		 System.out.println(i+1);
	        		 continue cycle;
	        	 }
	        		 
	         }
	         System.out.println("IMPOSSIBLE");
	         
		}
		pw.close();
	}
	
}
