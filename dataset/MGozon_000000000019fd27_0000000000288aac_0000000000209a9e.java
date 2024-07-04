import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException {
		//BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(System.in);
		//StringTokenizer st = new StringTokenizer(f.readLine());
		int tc = in.nextInt(); //Integer.parseInt(st.nextToken());
		int b = in.nextInt(); //Integer.parseInt(st.nextToken());
		for (int t = 1; t <= tc; t++) {
			int q = 1;
			// throw away first bit
			for (int i = 0; i < 3; i++) {
				System.out.println(b);
				in.next();
				q++;
			}
			StringBuilder fr = new StringBuilder();
			StringBuilder bk = new StringBuilder();
			//int count, group;
			int loc = 0;
			while (true) {
				// take it 8 bits at a time, 4 at start and 4 at end
				for (int i = 0; i < 4; i++) {
					System.out.println(loc+i+1);
					char c = in.next().charAt(0);
					fr.append(c);
				}
				for (int i = 0; i < 4; i++) {
					System.out.println(b-loc-i);
					char c = in.next().charAt(0);
					bk.append(c);
				}
				loc += 4;
				if (fr.toString().equals(bk.toString())) {
					System.out.println(1);
					in.next();
					System.out.println(1);
					char c = in.next().charAt(0);
					if (c != fr.charAt(0)) {
						fr = com(fr);
						bk = com(bk);
					}
				} else if (fr.toString().equals(com(bk).toString())) {
					System.out.println(1);
					in.next();
					System.out.println(1);
					char c = in.next().charAt(0);
					if (c != fr.charAt(0)) {
						fr = com(fr);
						bk = com(bk);
					}
				} else {
					int si = same(fr, bk);
					int di = dif(fr, bk);
					System.out.println(si+1);
					char rs = in.next().charAt(0);
					System.out.println(di+1);
					char rd = in.next().charAt(0);
					if (rs == fr.charAt(si)) { // did not complement --> check reversed
						if (rd != fr.charAt(di)) { // reversed
							StringBuilder temp = fr;
							fr = bk;
							bk = temp;
						}
					} else {
						fr = com(fr);
						bk = com(bk);
						if (rd != fr.charAt(di)) {
							StringBuilder temp = fr;
							fr = bk;
							bk = temp;
						}
					}
				}
				
				// end of rep
				if (fr.length() >= b/2) break;
			}
			bk = new StringBuilder(bk.substring(0, b/2));
			System.out.println(fr.substring(0, b/2) + bk.reverse());
			char ret = in.next().charAt(0);
			if (ret == 'Y') continue;
			else break;
		}
	}
	
	public static int same(StringBuilder a, StringBuilder b) {
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == b.charAt(i)) return i;
		}
		return -1;
	}
	
	public static int dif(StringBuilder a, StringBuilder b) {
		for (int i = 0; i < a.length(); i++)
			if (a.charAt(i) != b.charAt(i)) return i;
		return -1;
	}
	
	public static StringBuilder com(StringBuilder s) {
		StringBuilder sn = new StringBuilder();
		for (int i = 0; i < s.length(); i++)
			sn.append(s.charAt(i) == '0' ? '1' : '0');
		return sn;
	}
}
