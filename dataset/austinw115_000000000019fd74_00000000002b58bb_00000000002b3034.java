import java.io.*;
import java.awt.*;
import java.util.*;
import java.math.*;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 32768);
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		//BufferedReader br = new BufferedReader(new FileReader("A.in"));
		//PrintWriter pw = new PrintWriter(new FileWriter("A.out"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String[] arr = new String[N];
			String longest = "*";
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				String P = st.nextToken();
				System.out.println(P);
				if (P.length() > longest.length()) {
					longest = P;
				}
				arr[j] = P;
			}
			System.out.println(Arrays.toString(arr));
			String ans = longest.substring(1);
			for (int c = 0; c < arr.length; c++) {
				String s1 = arr[c];
				System.out.println(s1);
				if (s1.length() > 1) {
					s1 = s1.substring(1);
				}
				
				if (longest.indexOf(s1) == -1) {
					ans = "*";
				}
			}
			pw.println("Case #" + i + ": " + ans);
		}
		pw.close();
	}
}