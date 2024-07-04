import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int i=1;i<=t;i++) {
			new Solution().solve(i,br);
		}
	}

	private void solve(int t, BufferedReader br) throws IOException {
		String in[]=br.readLine().split(" ");
		int x=Integer.parseInt(in[0]);
		int y=Integer.parseInt(in[1]);
		String path=in[2];
		int c=0;
		int n=path.length();
		boolean f=false;
		if(Math.abs(x)+Math.abs(y)<=c) {
			f=true;
		}else {
			for(int i=0;i<n;i++) {
				++c;
				char ch=path.charAt(i);
				if(ch=='N') {
					++y;
				}else if(ch=='S') {
					--y;
				}else if(ch=='E') {
					++x;
				}else if(ch=='W') {
					--x;
				}
				if(Math.abs(x)+Math.abs(y)<=c){
					f=true;
					break;
				}
			}
		}	
		if(f) {
			System.out.println("Case #"+t+": "+c);
		}else {
			System.out.println("Case #"+t+": IMPOSSIBLE");
		}
		
	}
	
	
	
   
}