import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
			
			long range = (int)Math.pow(10, U) - 1;
			
			HashMap<Character, Pair> hashmap = new  HashMap<>();
			
			for(int i = 0; i < 10000; i++) {
				long M = sc.nextLong();
				String str = sc.next();
				
				for(char ch : str.toCharArray()) {
					if(hashmap.containsKey(ch)) {
						hashmap.put(ch, new Pair(ch, (hashmap.get(ch).cnt + 1)));
					} else {
						hashmap.put(ch, new Pair(ch, 1));
					}
				}
			}
			
			ArrayList<Pair> list = new ArrayList<Pair>(hashmap.values());
			list.sort(null);
			
			for(Pair p : list) {
				System.out.print(p.ch);
			}
		}
	}

}
