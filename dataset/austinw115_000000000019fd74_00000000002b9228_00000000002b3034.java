import java.io.*;
import java.awt.*;
import java.util.*;
import java.math.*;

public class SolutionA {
	
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
				//System.out.println(P);
				if (P.length() > longest.length()) {
					longest = P;
				}
				arr[j] = P;
			}
			//System.out.println(Arrays.toString(arr));
			String ans = longest;
			
	
			for (int c = 0; c < arr.length; c++) {
				String s1 = arr[c];
				if (s1 != longest) {
				if (s1.length() > 1) {
					s1 = s1.substring(1);
				}
				
				if (longest.indexOf(s1) == -1) {
					ans = "*";
				}
				}
			}
			pw.println("Case #" + i + ": " + ans);
		}
		pw.close();
	}
	
	/*
	public static void main(String[] args) throws NumberFormatException, IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 32768);
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		BufferedReader br = new BufferedReader(new FileReader("A.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("A.out"));
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
				if (s1.length() > 1) {
					int index = s1.indexOf("*");
					if (index >= 0) {
						if (longest.indexOf(s1.substring(0, index)) == -1 || longest.indexOf(s1.substring(index)) == -1) {
							ans = "*";
						}
					}
				}
				if (s1 != "*" ) {
					if (longest.indexOf(s1) == -1) {
						
					}
				}
			}
			pw.println("Case #" + i + ": " + ans);
		}
		pw.close();
	}*/
}
