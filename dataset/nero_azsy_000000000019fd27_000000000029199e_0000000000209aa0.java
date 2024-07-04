import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cases = Integer.parseInt(br.readLine());
		int x = 1; 
		for(int i = 0; i < cases; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int div;
			if(k % n == 0 && k / n <= n) {
				div = k / n;
				System.out.println("Case #" + x + ": POSSIBLE");
				
				int upper = div - 1;
				for(int a = 1; a <= upper; a++) {
					StringBuilder sb = new StringBuilder();
					int tmp = div;
					while(tmp <= n) {
						sb.append(tmp + " ");
						tmp++;
					}
					for(int aa = 1; aa < div; aa++) {
						sb.append(aa + " ");
					}
					div--;
					System.out.println(sb.toString().substring(0, sb.length() - 1));
					
				}
				
				int lower = n + 1; 
				for(int b = 1; b <= n-upper; b++) {
					StringBuilder sb = new StringBuilder();
					int tmp2 = lower;
					while(tmp2 <= n) {
						sb.append(tmp2 + " ");
						tmp2++;
					}
					for(int bb = 1; bb < lower; bb++) {
						sb.append(bb + " ");
					}
					lower--;
					System.out.println(sb.toString().substring(0, sb.length() - 1));
				}
				x++;
				
			}else {
				System.out.println("Case #" + x + ": IMPOSSIBLE");
				x++;
			}
		}
	}
}