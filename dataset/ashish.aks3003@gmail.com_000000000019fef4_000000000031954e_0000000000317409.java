import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {
	public static void main(String[] args) {
		InputStream in = System.in;
		InputReader scan = new InputReader(in);
		int t = scan.nextInt();
		for(int i = 0; i<t; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			String dir = scan.next();
			int found = -1;
			for(int j=0; j<dir.length(); j++) {
				char direction = dir.charAt(j);
				if(direction == 'S')
					y--;
				else if(direction == 'N')
					y++;
				else if(direction == 'W')
					x--;
				else if(direction == 'E')
					x++;
				
				int time = Math.abs(x)+Math.abs(y);
				if(time<=(j+1)) {
					found = j+1;
					break;
				}			
			}
			if(found==-1)
				System.out.println("Case #"+(i+1)+": "+"IMPOSSIBLE");
			else
				System.out.println("Case #"+(i+1)+": "+found);
		}				
	}
	
	
	static class InputReader{
		BufferedReader br;
		StringTokenizer st;
		public InputReader(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));			
		}
		
		String next(){
			while(st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}	
	}
}
