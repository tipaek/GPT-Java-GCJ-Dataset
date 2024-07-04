import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			int u = Integer.parseInt(br.readLine());
			HashMap<Integer, HashSet<String>> map = new HashMap<>();
			char[] d = new char[10];
			for(int i=0; i<10; i++) map.put(i, new HashSet<>());
			HashSet<Character> letters = new HashSet<>();
			boolean[] used = new boolean[26]; 
			for(int i=0; i<10000; i++) {
				String[] split = br.readLine().split(" ");
				for(int j=0; j<split[1].length(); j++) letters.add(split[1].charAt(j));
				int m = Integer.parseInt(split[0]);
				if(m<10) map.get(m).add(split[1]);
			}
			for(int i=1; i<10; i++) {
				HashSet<String> set = map.get(i);
				for(String cur : set)
					if(!used[cur.charAt(0)-'A']) {
						used[cur.charAt(0)-'A'] = true;
						d[i] = cur.charAt(0);
						break;
					}
			}
			for(char cur : letters)
				if(!used[cur-'A']) {
					d[0] = cur;
					break;
				}
			System.out.print("Case #"+t+": ");
			System.out.println(d);
		}
	}
}
