
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
	
	public static class Pair implements Comparable {
		
		public char ch;
		public long cnt;
		
		public Pair(char ch, long cnt) {
			this.ch = ch;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Object o) {
			
			Pair p = null;
			
			if(o instanceof Pair)
				p = (Pair)o;
			
			if(p.cnt < this.cnt)
				return 1;
			else if(p.cnt == this.cnt)
				return 0;
			else 
				return -1;
			
		}
		
		
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		
		int T = sc.nextInt();
		
		for(int t = 1; t<= T; t++) {
			
			int U = sc.nextInt();
			
			boolean[] used = new boolean[26];
			long[] alpha = new long[26];
			
			for(int i = 0; i < 10000; i++) {
				
				long M = sc.nextLong();
				
				String str = sc.next();
				
				for(char ch : str.toCharArray()) {
				
					used[ ch - 'A'] = true;
				}
				
				if(str.length() >= 2) {
				
					char ch = str.charAt(0);
					
					alpha[ch - 'A']++;
				}
			
			}
			
			ArrayList<Pair> list = new ArrayList<Pair>();
			
			for(int i = 0; i < 26; i++) {
			
				if(used[i]) {
					
					list.add(new Pair((char)(i + 'A'), alpha[i]));
				}
			}
			
			list.sort(null);
			String ans = String.valueOf(list.get(0).ch);
			
			for(int i = list.size() - 1; i > 0; i--) {
				char ch = list.get(i).ch;
				
				ans += ch;
			}
			
			System.out.println("Case #" + t + ": " + ans);
		}
	}

}
