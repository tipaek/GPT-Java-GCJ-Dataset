import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			String[] split = br.readLine().split(" ");
			int n = Integer.parseInt(split[0]);
			int d = Integer.parseInt(split[1]);
			HashMap<Long, Integer> count = new HashMap<>();
			split = br.readLine().split(" ");
			ArrayList<Long> s = new ArrayList<>();
			for(int i=0; i<n; i++) {
				long cur = Long.parseLong(split[i]);
				count.put(cur, !count.containsKey(cur) ? 1 : count.get(cur)+1);
			}
			for(long cur : count.keySet()) s.add(cur);
			Collections.sort(s);
			int moves = 2;
			for(int i=0; i<s.size(); i++) {
				long cur = s.get(i);
				if(count.get(cur)>=d) {
					moves = 0;
					break;
				} else if(count.get(cur)==d-1 && i<s.size()-1) {
					moves = 1;
				} else if(cur%2==0 && count.containsKey(cur/2) && count.get(cur/2)>=1) {
					moves = 1;
				}
			}
			System.out.println("Case #"+t+": "+moves);
		}
	}
}
