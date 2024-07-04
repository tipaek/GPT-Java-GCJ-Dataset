
import java.io.*;
import java.util.*;

public class Solution {
	static class Node implements Comparable<Node>{
		char c;
		int count;
		Node(char c, int count){
			this.c =c;
			this.count = count;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.count, o.count);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for (int tc = 1; tc <= t; ++tc) {
			int u = Integer.parseInt(br.readLine());
			HashSet<Character> set = new HashSet<Character>();
			HashMap<Character, boolean[]> map = new HashMap<Character, boolean[]>();
			for (int i = 0; i < 10000; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String q = st.nextToken();
				String r = st.nextToken();
				for(int idx = 0; idx < r.length(); ++idx) {
					set.add(r.charAt(idx));
				}
				if (q.length() == r.length()) {
					int qi = q.charAt(0) - '0';
					char currentR = r.charAt(0);
					if (!map.containsKey(currentR)) {
						map.put(currentR, new boolean[10]);
						for (int idx = 0; idx < 10; ++idx) {
							map.get(currentR)[idx] = true;
						}
					}
					for (int num = qi + 1; num < 10; ++num) {
						map.get(currentR)[num] = false;
						;
					}
				}
			}
			ArrayList<Node> arr = new ArrayList<Node>();
			for (Character ch : map.keySet()) {
				int count = 0;
				for(int idx = 0; idx < 10; ++idx) {
					if(map.get(ch)[idx]) {
						count++;
					}else {
						break;
					}
				}
				arr.add(new Node(ch,count));
			}
			Collections.sort(arr);
			char[] ans = new char[10];
			for(int i = 1; i < 10; ++i) {
				ans[i] = arr.get(i-1).c;
			}
			for(char c : set) {
				if(!map.containsKey(c)) {
					ans[0] = c;
					break;
				}
			}
			StringBuilder tans = new StringBuilder();
			for(int i = 0; i < 10; ++i) {
				tans.append(ans[i]);
			}
			tans.append('\n');
			answer.append("Case #"+tc+": "+tans);
		}
		System.out.println(answer);
	}
}