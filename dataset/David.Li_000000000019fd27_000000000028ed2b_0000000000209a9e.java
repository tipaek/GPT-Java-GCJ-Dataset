import java.io.*;
import java.util.*;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int t = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		for (int test = 0; test < t; test++) {
			int[] bits = new int[b + 1];
			int r = -1, c = -1;
			int b1 = 1,b2=1;
			int half = (b+1) / 2;
			int q = 1;
			int even = 0;
			while (b2 <= b) {
				if ((q>1)&&(q % 10 == 1)) {
					if ((r == -1) && (c == -1)) {
						System.out.println(1);
						st = new StringTokenizer(f.readLine());
						int temp = Integer.parseInt(st.nextToken());
						System.out.flush();
						q++;
						if (temp != bits[1]) {
							for (int i = 1; i <= b1; i++) {
								bits[i] = 1 - bits[i];
								bits[b + 1 - i] = 1 - bits[b + 1 - i];
							}
						}
					} else if ((r == -1) && (c != -1)) {
						System.out.println(c);
						st = new StringTokenizer(f.readLine());
						int current = Integer.parseInt(st.nextToken());
						System.out.flush();
						q++;
						if (current != bits[c]) {
							for (int i = 1; i <= b1; i++) {
								bits[i] = 1 - bits[i];
								bits[b + 1 - i] = 1 - bits[b + 1 - i];
							}
						}
					} else if ((r != -1) && (c == -1)) {
						System.out.println(r);
						st = new StringTokenizer(f.readLine());
						int current = Integer.parseInt(st.nextToken());
						System.out.flush();
						q++;
						if (current != bits[r]) {
							for (int i = 1; i <= b1; i++) {
								bits[i] = 1 - bits[i];
								bits[b + 1 - i] = 1 - bits[b + 1 - i];
							}
						}
					} else if ((r != -1) && (c != -1)) {
						System.out.println(r);
						st = new StringTokenizer(f.readLine());
						int current1 = Integer.parseInt(st.nextToken());
						System.out.flush();
						q++;
						System.out.println(c);
						st = new StringTokenizer(f.readLine());
						int current2 = Integer.parseInt(st.nextToken());
						System.out.flush();
						q++;
						if ((current2 != bits[c]) && (current1 != (1 - bits[r]))) {
							for (int i = 1; i <= b1; i++) {
								int temp = bits[i];
								bits[i] = 1 - bits[b + 1 - i];
								bits[b + 1 - i] = 1 - temp;
							}
						}
						if ((current2 != bits[c]) && (current1 == (1 - bits[r]))) {
							for (int i = 1; i <= b1; i++) {
								bits[i] = 1 - bits[i];
								bits[b + 1 - i] = 1 - bits[b + 1 - i];
							}
						}
						if ((current2 == bits[c]) && (current1 != bits[r])) {
							for (int i = 1; i <= b1; i++) {
								int temp = bits[i];
								bits[i] = bits[b + 1 - i];
								bits[b + 1 - i] = temp;
							}
						}
						if ((current2 == bits[c]) && (current1 == bits[r])) {

						}
					}

				} else {
					if (even == 0) {
						int i = b1;
						System.out.println(i);
						st = new StringTokenizer(f.readLine());
						bits[i] = Integer.parseInt(st.nextToken());
						System.out.flush();
						q++;
						even = 1;
						b2++;
					} else {
						int i = b1;
						int j = b - i + 1;
						System.out.println(j);
						st = new StringTokenizer(f.readLine());
						bits[j] = Integer.parseInt(st.nextToken());
						System.out.flush();
						q++;

						if ((r == -1) && (bits[i] != bits[j]))
							r = i;
						if ((c == -1) && (bits[i] == bits[j]))
							c = i;
						even = 0;
						b1++;
						b2++;
					}
				}
			}
			String result="";
			for(int i=1;i<b;i++) result=result+bits[i];
			System.out.println(result);
		}
	}
}