import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		cycle: for (int i = 1; i<= T; i++) {
			System.out.print(("Case #" + i + ": "));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			String first = "";
			String second = "";
			boolean multA = false;
			boolean multB = false;
			if (a < 0)
				multA = true;
			if (b < 0)
				multB = true;
			boolean finished = false;
			first = Integer.toBinaryString(Math.abs(a));
			second = Integer.toBinaryString(Math.abs(b));
			String ans = "";
			while (first.length() < second.length()) first  = "0" +first;
			while (second.length() < first.length()) second = "0" + second;
			for (int j = 0; j < first.length(); j++) {
				if (first.charAt(j) == second.charAt(j)) break;
				if (first.charAt(j) == '1') {
					if (multA)
						ans += "W";
					else ans += "E";
				} 
				if (second.charAt(j) == '1') {
					if (multB)
						ans += "S";
					else ans += "N";
				}
				if (j == first.length()-1) finished = true;
			}
			if (finished) {
				System.out.println(ans);
				continue cycle;
			}
			boolean thing = false;
			boolean twosCompA = false;
			boolean twosCompB = false;
			if (Math.abs(a) > Math.abs(b)) {
				twosCompB = true;
				thing = true;
				int temp = Math.abs(b)*-1;
				if (temp == -1) {
					second = "1";
				} else if (temp == 0) {
					second = "0";
				}else {
					second = Integer.toBinaryString(temp);
					second = second.substring(second.indexOf('0')-1);
				}
				first = Integer.toBinaryString(Math.abs(a));
			} else {
				twosCompA = true;
				thing = true;
				int temp = Math.abs(a)*-1;
				if (temp == -1) {
					first = "1";
				} else if (temp == 0) {
					first = "0";
				}else {
					first = Integer.toBinaryString(temp);
					first = first.substring(first.indexOf('0')-1);
				}
				second = Integer.toBinaryString(Math.abs(b));

			}

			while (first.length() < second.length()) first  = "0" +first;
			while (second.length() < first.length()) second = "0" + second;
			ans = "";
			finished = false;
			for (int j = 0; j < first.length(); j++) {
				if (first.charAt(j) == second.charAt(j)) {
					break;
				}
				if (first.charAt(j) == '1' ) {
					if (twosCompA && multA && thing || !twosCompA && multA || twosCompA && !multA && !thing) {
						ans = "W" + ans;
					} else ans = "E" + ans;
					if (thing)
						thing =false;
				}
				if (second.charAt(j) == '1') {
					if (twosCompB && multB && thing || !twosCompB && multB || twosCompB && !multB && !thing) {
						ans = "S" + ans;
					} else ans = "N" + ans;
					if (thing)
						thing = false;
				}
				if (j == first.length()-1)
					finished = true;
			}
			if (finished) {
			System.out.println(ans);
			continue cycle;
			}
			thing = false;
			twosCompA = false;
			twosCompB = false;
			if (Math.abs(a) < Math.abs(b)) {
				twosCompB = true;
				thing = true;
				int temp = Math.abs(b)*-1;
				if (temp == -1) {
					second = "1";
				} else if (temp == 0) {
					second = "0";
				}else {
					second = Integer.toBinaryString(temp);
					second = second.substring(second.indexOf('0')-1);
				}
				first = Integer.toBinaryString(Math.abs(a));

			} else {
				twosCompA = true;
				thing = true;
				int temp = Math.abs(a)*-1;
				if (temp == -1) {
					first = "1";
				} else if (temp == 0) {
					first = "0";
				}else {
					first = Integer.toBinaryString(temp);
					first = first.substring(first.indexOf('0')-1);
				}
				second = Integer.toBinaryString(Math.abs(b));

			}
//			System.out.println(twosCompA);
//			System.out.println(twosCompB);
			while (first.length() < second.length()) first  = "0" +first;
			while (second.length() < first.length()) second = "0" + second;
			ans = "";
			for (int j = 0; j < first.length(); j++) {
				if (first.charAt(j) == second.charAt(j)) {
					System.out.println("IMPOSSIBLE");
					continue cycle;
				}
				if (first.charAt(j) == '1' ) {
					if (twosCompA && multA && thing || !twosCompA && multA || twosCompA && !multA && !thing) {
						ans = "W" + ans;
					} else ans = "E" + ans;
					if (thing)
						thing =false;
				}
				if (second.charAt(j) == '1') {
					if (twosCompB && multB && thing || !twosCompB && multB || twosCompB && !multB && !thing) {
						ans = "S" + ans;
					} else ans = "N" + ans;
					if (thing)
						thing = false;
				}

			}
			System.out.println(ans);

			
		}
	}

}
