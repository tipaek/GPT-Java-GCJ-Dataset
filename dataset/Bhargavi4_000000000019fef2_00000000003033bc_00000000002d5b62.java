import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		if(str == null) {
			return;
		}
		
		int t = Integer.parseInt(str);
		StringBuilder sb = new StringBuilder();
		int c = 1;
		while(t-- > 0) {
			sb.append("Case #"+c+ ": ");
			c++;
			String s = br.readLine();
			String st[] = s.split(" ");
			
			int x = Integer.parseInt(st[0]);
			int y = Integer.parseInt(st[1]);
			
			String res = solve(x,y);
			sb.append(res).append("\n");
		}
		
		System.out.println(sb.toString().trim());
         
	}

	private static String solve(int x,int y) {
		if(Math.abs(x) == Math.abs(y)) return "IMPOSSIBLE";
		
		int steps = Math.abs(x) + Math.abs(y);
		
		//int val = pow(steps);
		
		
		int i = 1;
		int val = 0;
		while(val < steps) {
			
			val += pow(i);
		    i++;	
		}
		
		
		i=i-1;
		int m = x;
		int n = y;
		String out = "";
		while(i > 0) {
			
			int v = pow(i);
			int x1 = m >=0 ? m-v : m+v;
			int y1 = n;
			
			int x2 = m;
			int y2 = n >= 0 ? n-v : n+v;
			
			
			
			double a = Math.sqrt((x1*x1 + y1*y1));
			
			double b =  Math.sqrt((x2*x2 + y2*y2));
			
			
			double f  = Math.min(a, b);
			
			if(f == a) {
				
				out = getDirection(m,n,x1,y1)+out;
				m = x1;
				n=y1;
				
			}else {
				
				out = getDirection(m,n,x2,y2) + out;
				m=x2;
				n = y2;
				//out = getDirection(n,false) + out;
			}
			
			
			i=i-1;
			
		}
		
		//System.out.println(out);
		
		return out;
	}

	private static String getDirection(int m, int n, int x1, int y1) {
		
		if(m == x1 && n > y1) {
			return "N";
		}else if(m == x1 && n < y1) {
			return "S";
		}else if( n == y1 && m > x1) {
			return "E";
		}else if(n == y1 && m < x1) {
			return "W";
		}
		
		return null;
	}

	

	private static int pow(int steps) {
		
		if(steps == 1) return 1;
		
		return  2 * pow(steps-1);
	}

}
