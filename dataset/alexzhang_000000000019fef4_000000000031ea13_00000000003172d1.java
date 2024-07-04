import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int asdfasdf=1; asdfasdf<T+1; asdfasdf++) {
			joestar(asdfasdf);
		}
	}
	public static void joestar(int kamamam) throws IOException {
		System.out.print("Case #"+kamamam+": ");
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int  D= Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		long[] cakes = new long[N];
		for (int i=0; i<N; i++) {
			cakes[i]=Long.parseLong(st.nextToken());
		}
		if (D ==2) {
			for (int i=0; i<N; i++) {
				for (int j=0; j<i; j++) {
					if (cakes[i]==cakes[j]) {
						System.out.println(0);
						return;
					}
				}
			}
			System.out.println(1);
		}
		if (D==3) {
			Arrays.sort(cakes);
			for (int i=0; i<cakes.length-2; i++) {
				if (cakes[i]==cakes[i+1]&&cakes[i+1]==cakes[i+2]) {
					System.out.println(0);
					return;
				}
			}
			for (int i=0; i<N; i++) {
				for (int j=0; j<i; j++) {
					if (cakes[i]==2*cakes[j]||2*cakes[i]==cakes[j]||(cakes[i]==cakes[j]&&i!=N-1)) {
						System.out.println(1);
						return;
					}
				}
			}
			System.out.println(2);
			return;
		}
	}
}
