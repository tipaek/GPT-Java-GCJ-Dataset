//package round1c2020;

/*
ID: urd00m
LANG: JAVA
TASK: over
 */
import java.io.*;
import java.util.*;

public class Solution {
	static int t;
	static int n, d; 
	static long[] slices; 
	public static void main(String args[]) throws IOException {
		// input
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer input;
		t = Integer.parseInt(f.readLine());
		for (int cn = 1; cn < t + 1; cn++) {
			input = new StringTokenizer(f.readLine()); 
			n = Integer.parseInt(input.nextToken()); d = Integer.parseInt(input.nextToken());
			slices = new long[n]; 
			input = new StringTokenizer(f.readLine()); 
			for(int i = 0; i < n ; i++) {
				slices[i] = Long.parseLong(input.nextToken()); 
			}
			Arrays.sort(slices);
			int maxChunk = 0;
			for(int i = 0; i < n; i++) {
				long cur = slices[i];
				int chunk = 1;
				int j;
				for(j = i+1; j < n; j++) {
					if(slices[j] == cur) chunk++; 
					//if(slices[j]%2 == 0 && slices[j]/2 == cur) chunk++; 
				}
				if(chunk > maxChunk) maxChunk = chunk; 
			}
			int ret = -1; 
			if(d == 2) {
				if(maxChunk >= 2) ret = 0; 
				else if(maxChunk == 1) ret = 1; 
			}
			if(d == 3) {
				if(maxChunk >= 3) ret = 0; 
				else if(maxChunk == 2) {
					//finding greater 
					boolean greater = false; 
					for(int i = 0; i < n; i++) {
						long cur = slices[i];
						int chunk = 1;
						int j;
						for(j = i+1; j < n; j++) {
							if(slices[j] == cur) chunk++; 
							if(chunk == maxChunk) {
								if(j < n-1) greater = true; 
							}
						}
						if(chunk > maxChunk) maxChunk = chunk; 
					}
					
					
					
					if(greater == true) ret = 1;
					else {
						maxChunk = 0; 
						for(int i = 0; i < n; i++) {
							long cur = slices[i];
							int chunk = 1;
							int j;
							for(j = i+1; j < n; j++) {
								//if(slices[j] == cur) chunk++; 
								if(slices[j]%2 == 0 && slices[j]/2 == cur) chunk++; 
							}
							if(chunk > maxChunk) maxChunk = chunk; 
						}
						if(maxChunk >= 2) ret = 1;  
						else ret = 2; 
					}
				}
				else if(maxChunk == 1) {
					//check for doubles 
					maxChunk = 0; 
					for(int i = 0; i < n; i++) {
						long cur = slices[i];
						int chunk = 1;
						int j;
						for(j = i+1; j < n; j++) {
							//if(slices[j] == cur) chunk++; 
							if(slices[j]%2 == 0 && slices[j]/2 == cur) chunk++; 
						}
						if(chunk > maxChunk) maxChunk = chunk; 
					}
					if(maxChunk == 2) ret = 1;  
					else ret = 2; 
				}
			}


			System.out.println("Case #" + cn + ": " + ret);

		}

	}
}
