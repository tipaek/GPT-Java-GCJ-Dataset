import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Pair implements Comparable<Pair>{
	int s;
	int e;
	String assignTo;
	Pair(int a, int b){
		s=a;
		e=b;
	}
	@Override
	public int compareTo(Pair pair) {
		return this.s-pair.s;
	}
}
 class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			solve(br, i);
		}
	}

	private static void solve(BufferedReader br, int t) throws NumberFormatException, IOException {
		int n=Integer.parseInt(br.readLine());
		String in[];
		Map<Integer,Pair> map=new HashMap<>();
		List<Pair> l=new ArrayList<>();
		for(int i=1;i<=n;i++) {
			in=br.readLine().split(" ");
			Pair p=new Pair(Integer.parseInt(in[0]),Integer.parseInt(in[1]));
			map.put(i, p);
			l.add(p);
		}
		int C=0,J=0;
		Collections.sort(l);
		boolean imp=false;
		for(Pair w:l) {
			int start=w.s;
			if(start>=C) {
				w.assignTo="C";
				C=w.e;
			}else if(start>=J) {
				w.assignTo="J";
				J=w.e;
			}else {
				imp=true;
				break;
			}
		}
		if(imp) {
			System.out.println("Case #"+t+": IMPOSSIBLE");
		}else {
			String res="";
			for(int i=1;i<=n;i++) {
				res=res+map.get(i).assignTo;
			}
			System.out.println("Case #"+t+": "+res);
		}
	}

}
