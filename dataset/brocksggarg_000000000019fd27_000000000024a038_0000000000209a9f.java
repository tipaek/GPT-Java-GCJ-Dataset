import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

 class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			solve(br, i);
		}
	}

	private static void solve(BufferedReader br, int t) throws IOException {
		String s[]=br.readLine().split("");
		String res="";
		int op=0;
		int v;
		for(int i=0;i<s.length;i++) {
			v=Integer.parseInt(s[i]);
			int requiredParanthese = v - op;
			if(requiredParanthese==0) {
				res=res+v;
			}else if(requiredParanthese>0) {
				while(requiredParanthese>0) {
					res=res+"(";
					--requiredParanthese;
				}
				res=res+v;
				op=v;
			}else {
				//close some
				while(requiredParanthese<0) {
					res=res+")";
					++requiredParanthese;
				}
				res=res+v;
				op=v;
			}
		}
		while(op>0) {
			res=res+")";
			--op;
		}
		System.out.println("Case #"+t+": "+res);
	}

}
