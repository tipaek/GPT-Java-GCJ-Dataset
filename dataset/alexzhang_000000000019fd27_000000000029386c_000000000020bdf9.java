import java.io.*;
import java.util.*;
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int asdfasdf=1; asdfasdf<T+1; asdfasdf++) {
			System.out.print("Case #"+asdfasdf+": ");
			int N = Integer.parseInt(br.readLine());
			int[] starttimes = new int[N];
			int[] endtimes = new int[N];
			for (int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				starttimes[i]=Integer.parseInt(st.nextToken());
				endtimes[i]=Integer.parseInt(st.nextToken());
			}
			boolean imp = false;
			for (int sgu=0; sgu<Math.pow(2, N); sgu++) {
				String bobyjoe = Integer.toString(sgu, 2);
				while (bobyjoe.length()<N)bobyjoe="0"+bobyjoe;
				boolean broken=false;
				for (int t = 0; t <= 1440; t++) {
					int joecounter = 0;
					int coecounter = 0;
					for (int i = 0; i < N; i++) {
						if (starttimes[i] <= t && t < endtimes[i]) {
							if (bobyjoe.charAt(i) == '0')
								joecounter++;
							else
								coecounter++;
						}
					}
					if (joecounter>=2||coecounter>=2) {
						/*for (int i=0; i<N; i++) {
							if (bobyjoe.charAt(i)=='0')System.out.print("J");
							else System.out.print("C");
						}*/
						broken=true;
						break;
					}
				}
				if (!broken) {
					for (int i=0; i<N; i++) {
						if (bobyjoe.charAt(i)=='0')System.out.print("J");
						else System.out.print("C");
					}
					System.out.println();
					imp = true;
					break;
				}
				
			}
			if (!imp)System.out.println("IMPOSSIBLE");
		}
	}
}
