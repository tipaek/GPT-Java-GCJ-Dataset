import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader scn = new FastReader();
		int t = scn.nextInt();
		int p = t;
		while(t-->0) {
			int u = scn.nextInt();
			HashMap<Character, Integer> map = new HashMap<>();
			HashMap<Character, Integer> map2 = new HashMap<>();
			for(int i=0; i<10000; i++) {
				String a = scn.next();
				String b = scn.next();
				if(map2.size() < 10)
				{
					for(int j=0; j<b.length(); j++)
					map2.put(b.charAt(j), 1);
				}
				int k1 = Integer.parseInt(String.valueOf(a.charAt(0)));
				if(a.length() == b.length()) {
					if(map.containsKey(b.charAt(0))) {
						if(k1 < map.get(b.charAt(0)))
								map.put(b.charAt(0),k1);
					}else
						map.put(b.charAt(0), k1);
				}
				
			}
//			System.out.println(map2);
//			System.out.println(map);
			Set<Character> keys = map.keySet();
			for(Character k : keys) {
				map2.remove(k);
			}
			//System.out.println(map2);
			char[] ch = new char[10];
			ch[0] = (char) map2.keySet().toArray()[0];
			for(Character k:keys) {
				int a = map.get(k);
				ch[a] = k;
			}
			String str = "";
			for(int i=0; i<10; i++)
				str += ch[i];
			System.out.println("Case #" + (p-t) + ": " + str);
		}
		
	}
	
	
	static int gcd(int a, int b) 
    { 
    if (a == 0) 
        return b;  
    return gcd(b % a, a);  
    } 
      
    static int lcm(int a, int b) 
    { 
        return (a*b)/gcd(a, b); 
    } 
    
    static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}

	