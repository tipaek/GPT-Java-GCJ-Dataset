import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int i=1;i<=t;i++) {
			new Solution().solve(i,br);
		}
	}

	private void solve(int t, BufferedReader br) throws IOException {
		String in[]=br.readLine().split(" ");
		int n=Integer.parseInt(in[0]);
		int d=Integer.parseInt(in[1]);
		in=br.readLine().split(" ");
		List<Long> l=new ArrayList<>();
		Map<Long,Integer> map=new HashMap<>();
		for(String w:in) {
			long v=Long.parseLong(w);
			map.put(v, map.getOrDefault(v, 0)+1);
		}
		int max=0;
		for(long w:map.keySet()) {
			max=Math.max(max, map.get(w));
			l.add(w);
		}
		Collections.sort(l);
		int num=l.size();
		int res=0;
		if(d==2) {
			if(max>=2) {
				res=0;
			}else {
				res=1;
			}
		}else {
			if(max>=3) {
				res=0;
			}else if(res>=2) {
				res=1;
			}else {
				res=2;
				for(int i=0;i<num-1;i++) {
					for(int j=i+1;j<num;j++) {
						if(l.get(i)*2==l.get(j)) {
							res=1;
							break;
						}
					}
				}
			}
		}
		System.out.println("Case #"+t+": "+res);
	}
}
