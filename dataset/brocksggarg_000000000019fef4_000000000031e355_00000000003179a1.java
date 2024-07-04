import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int i=1;i<=t;i++) {
			new Solution().solve(i,br);
		}
	}

	private void solve(int t, BufferedReader br) throws NumberFormatException, IOException {
		int u=Integer.parseInt(br.readLine());
		String in[];
		int v;
		String s;
		int mv;
		Set<String> set=new HashSet<>();
		Map<String, Integer> map=new HashMap<>();
		for(int i=1;i<=10000;i++) {
			in=br.readLine().split(" ");
			s=in[1];
			String carr[]=s.split("");
			for(String q:carr) {
				set.add(q);
			}
			v=Integer.parseInt(in[0]);
			if(v<10) {
				
				mv=map.getOrDefault(s, 10);
				if(v<mv) {
					map.put(s, v);
				}
			}
		}
		String ar[]=new String[10];
		for(String w:map.keySet()) {
			ar[map.get(w)]=w;
		}
		String res="";
		for(int i=1;i<10;i++) {
			res=res+ar[i];
			set.remove(ar[i]);
		}
		for(String w:set) {
			res=w+res;
		}
		System.out.println("Case #"+t+": "+res);
	}
	

}
