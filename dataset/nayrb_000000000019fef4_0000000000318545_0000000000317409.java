import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class Solution{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		int keis = Integer.valueOf(br.readLine().trim());
		
		for(int kei = 0; kei < keis; kei++){
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			
			int x = Integer.valueOf(st.nextToken());
			int y = Integer.valueOf(st.nextToken());
			
			String path = st.nextToken();
			int len = path.length();
			
			int idx = -1;
			
			for(int i = 0; i < len; i++){
				char ch = path.charAt(i);
				if(ch == 'S') {
					y--;
				}
				else if(ch == 'N'){
					y++;
				}
				else if(ch == 'E'){
					x++;
				}
				else{
					x--;
				}
				
				int diff = Math.abs(y) + Math.abs(x);
				
				if(diff <= (i+1)){
					idx = i;
					break;
				}
			}
			out.print("Case #"+(kei+1)+": ");
			if(idx == -1) {
				out.println("IMPOSSIBLE");
			}
			else{
				out.println((idx +1));
			}
		}
	}
}