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
	static int u; 
	public static void main(String args[]) throws IOException { 
		//input 
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); StringTokenizer input; 
		t = Integer.parseInt(f.readLine()); 
		u = Integer.parseInt(f.readLine()); 
		
		
		for(int cn = 1; cn < t+1; cn++) {
			//run through the values while mapping the lowerbound of the first digit which should tell you the location of each digit 
			//length of m and r have to match to tell you any information
			HashMap<String, Integer> convert = new HashMap<String, Integer>(); 
			HashMap<String, Boolean> stringsFound = new HashMap<String, Boolean>();
			int found = 0; 
			int id = 0; 
			int[] lowerBound = new int[10];
			Arrays.fill(lowerBound, 9);
			int m; 
			String r; 
			
			if(t == 1) {
			for(int i = 0; i < 10000; i++) {
				input = new StringTokenizer(f.readLine()); 
				m = Integer.parseInt(input.nextToken()); 
				r = input.nextToken(); 
				if((""+m).length() != r.length() || m == -1) continue; 
				else {
					if(found != 10)
						for(int j = 0; j < r.length(); j++) {
							if(stringsFound.containsKey(r.substring(j, j+1)) == false) {
								stringsFound.put(r.substring(j,j+1), true); found++; 
							}
						}
					if(convert.containsKey(r.substring(0, 1)) == false) convert.put(r.substring(0, 1), id++); 
					lowerBound[convert.get(r.substring(0, 1))] = Math.min(lowerBound[convert.get(r.substring(0, 1))], Integer.parseInt((""+m).substring(0,1))); 
				}
			}
			
		
			//checked 
			String[] output = new String[10]; 
			for(String item : convert.keySet()) {
				output[lowerBound[convert.get(item)]] = item; 
				stringsFound.remove(item); 
			}
			for(String item : stringsFound.keySet()) output[0] = item;  
			
			
			
			
			System.out.print("Case #" + cn + ": ");
			for(String item : output)  System.out.print(item);
			System.out.println();
			
			}
			
		}
	}
}

