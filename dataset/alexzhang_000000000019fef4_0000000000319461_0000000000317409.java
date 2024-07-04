import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int asdfasdf=1; asdfasdf<T+1; asdfasdf++) {
			joestar(asdfasdf);
			/*System.out.print("Case #"+asdfasdf+": ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			String m = st.nextToken();
			int currx = X;
			int curry = Y;
			for (int i=0; i<m.length(); i++) {
				char c = m.charAt(i);
				if (c=='N') {
					curry++;
				}
				if (c=='S') {
					curry--;
				}
				if (c=='E') {
					
				}
				if (c=='W') {
					
				}
			}*/
		}
	}
	public static void joestar(int kamamam) throws IOException {
		System.out.print("Case #"+kamamam+": ");
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		String m = st.nextToken();
		int currx = X;
		int curry = Y;
		for (int i=1; i<=m.length(); i++) {
			char c = m.charAt(i-1);
			if (c=='N') {
				curry++;
			}
			if (c=='S') {
				curry--;
			}
			if (c=='E') {
				currx++;
			}
			if (c=='W') {
				currx--;
			}
			if (Math.abs(currx)+Math.abs(curry)>i) {
				continue;
			}
			System.out.println(i);
			return;
			/*String s ="";
			if (currx>0) {
				for (int k=0; k<currx; k++) {
					s+="E";
				}
			}
			else {
				for (int k=0; k<currx; k++) {
					s+="W";
				}
			}
			if (curry>0) {
				for (int k=0; k<curry; k++) {
					s+="N";
				}
			}
			else {
				for (int k=0; k<curry; k++) {
					s+="S";
				}
			}
			for (int k=0; k<i-Math.abs(currx)-Math.abs(curry); k++) {
				
			}*/
		}
		System.out.println("IMPOSSIBLE");
		return;
	}
}
