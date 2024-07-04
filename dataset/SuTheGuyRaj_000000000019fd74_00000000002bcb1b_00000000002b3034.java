import java.io.*;
import java.util.*;

public class Solution {
	public static int next(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}

	static int T;
	static int N;
	static String[][] patts;
	static StringBuilder pattern;
	public static void main(String[] args) throws Exception {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(sc.readLine());
		for(int tt = 0; tt < T; tt++){
		    System.out.printf("Case #%d: ", tt+1);
		    N = Integer.parseInt(sc.readLine());
		    patts = new String[N][];
		    for(int i = 0; i < N; i++) {
		    	patts[i] = ("A" + sc.readLine() + "A").split("\\*");
		    	/*
		    	for(String s : patts[i]) {
		    		System.out.print(s + " ");
		    	}
		    	System.out.println();*/
		    }
		    combine();
		    String p = pattern.toString();
		    if(p.equals("*")) {
		    	System.out.println("*");
		    }
		    else {
		    	System.out.println(p.substring(1, p.length()-1));
		    }
		}
		
		sc.close();
	}
	
	public static void combine() {
		String max = patts[0][0];
		for(int i = 1; i < N; i++) {
			if(patts[i][0].length() > max.length()) {
				max = patts[i][0];
			}
		}
		for(int i = 0; i < N; i++) {
			if(!match(max, patts[i][0])) {
				pattern = new StringBuilder("*");
				return;
			}
		}
		pattern = new StringBuilder(max);
		for(int i = 0; i < N; i++) {
			for(int e = 1; e < patts[i].length - 1; e++) {
				pattern.append(patts[i][e]);
			}
		}
		max = patts[0][patts[0].length-1];
		for(int i = 1; i < N; i++) {
			if(patts[i][patts[i].length-1].length() > max.length()) {
				max = patts[i][patts[i].length-1];
			}
		}
		for(int i = 0; i < N; i++) {
			if(!matchSuff(max, patts[i][patts[i].length-1])) {
				pattern = new StringBuilder("*");
				return;
			}
		}
		pattern.append(max);
	}
	
	public static boolean match(String a, String b){
		int l = 0;
		while(l < b.length() && a.charAt(l) == b.charAt(l)) {
			l++;
		}
		return (l >= b.length());
	}
	
	public static boolean matchSuff(String a, String b) {
		int l = 0;
		while(l < b.length() && a.charAt(a.length() - l - 1) == b.charAt(b.length() - l - 1)) {
			l++;
		}
		return (l >= b.length());
	}
}
