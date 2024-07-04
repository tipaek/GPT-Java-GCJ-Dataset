import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

	public void realMain() throws Exception {

		BufferedReader fin = new BufferedReader(new InputStreamReader(System.in), 1000000);

		String in = fin.readLine();
		String[] ar = in.split(" ");

		int T = Integer.parseInt(ar[0]);
		int B = Integer.parseInt(ar[1]);

		for(int t = 1; t <= T; t++) {

			
			if(B == 10) {
				boolean[] ans = new boolean[10];

				for(int i = 0; i < 10; i++) {
					System.out.println(i+1);
					System.out.flush();
					in = fin.readLine();
					if(in.charAt(0) == '1') {
						ans[i] = true;
					}
				}

				String strans = "";
				for(int i = 0; i < 10; i++) {
					if(ans[i]) {
						strans += "1";
					} else {
						strans += "0";
					}
				}

				System.out.println(strans);
				System.out.flush();

				in = fin.readLine();

				if(in.charAt(0) == 'N') {
					return;
				}
			}

			else if(B == 20) {
				boolean[] diff = new boolean[20];

				
				for(int offset = 0; offset < 10; offset += 5) {
				for(int i = 0; i < 5; i++) {
					System.out.println(offset + i + 1);
					System.out.flush();
					in = fin.readLine();

					int first = in.charAt(0) - '0';

			
					System.out.println(B - (offset + i));
					System.out.flush();
					in = fin.readLine();

					int last = in.charAt(0) - '0';

					if(first != last) {
						diff[offset + i] = true;
					}
				}
				}

				boolean[] ans = new boolean[20];

				for(int i = 0; i < 10; i++) {
					System.out.println(i + 1);
					System.out.flush();
					in = fin.readLine();

					if(in.charAt(0) == '1') {
						ans[i] = true;
					}
				}	

				for(int i = 0; i < 10; i++) {
					if(ans[i] && diff[i]) {
						ans[B - i - 1] = false;
					} else if(ans[i]) {
						ans[B - i - 1] = true;
					} else if(diff[i]) {
						ans[B - i - 1] = true;
					} else {
						ans[B - i - 1] = false;
					}
				}

				StringBuilder sb = new StringBuilder("");

				for(int i = 0; i < 20; i++) {
					if(ans[i]) {
						sb.append('1');
					} else {
						sb.append('0');
					}
				}

				System.out.println(sb);
				System.out.flush();

				in = fin.readLine();

				if(in.charAt(0) == 'N') {
					return;
				}
			}			


			else {
				System.out.println("111");
				System.out.flush();
				in = fin.readLine();

				if(in.charAt(0) == 'N') {
					return;
				}
			}

					
		}
	}


	public static void main(String[] args) throws Exception {
		Solution s = new Solution();
		s.realMain();
	}
}