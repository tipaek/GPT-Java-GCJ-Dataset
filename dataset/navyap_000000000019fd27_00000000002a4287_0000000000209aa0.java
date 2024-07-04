package com.google.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Solution {

	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int cases=Integer.parseInt(br.readLine());
			for(int i=1; i<= cases; i++) {
				output = new StringBuilder();
				output.append("Case #").append(i).append(": ");
				String[] line = br.readLine().split(" ");
				int N = Integer.parseInt(line[0]);
				int k = Integer.parseInt(line[1]);
				if(k%N != 0) {
					output.append("IMPOSSIBLE");
				} else {
					output.append("POSSIBLE");
					int startVal = k/N;
					for(int j=0; j<N; j++) {
						startVal = getMatrix(N, startVal);
					}
				}
				System.out.println(output);
			}
			br.close();
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	static int getMatrix(int N, int firstVal) {
		int val = firstVal;
		output.append("\n");
		int last = val;
		for(int i=1;i<= N; i++) {
			if(val > N) val = 1;
			output.append(val).append(" ");
			if(i == N) last = val;
			val++;
		}
		return last;
	}

}
