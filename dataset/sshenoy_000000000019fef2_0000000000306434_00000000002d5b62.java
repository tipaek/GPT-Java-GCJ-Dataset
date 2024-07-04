import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		FastScanner in = new FastScanner(System.in);
		OutputStream outputStream = System.out;
		PrintWriter out = new PrintWriter(outputStream);
		
		int T = in.nextInt();

		for(int aa = 1; aa <= T; aa++) {
			
			int X = in.nextInt();
			int Y = in.nextInt();
			
			boolean xneg = false;
			boolean yneg = false;
			if(X < 0) {
				xneg = true;
				X = -X;
			}
			if(Y < 0) {
				yneg = true;
				Y = -Y;
			}
			
			int X2 = (-(~X))+1; 
			int Y2 = (-(~Y))+1;
			
			int xm = getBit(X);
			int xm2 = getBit(X2) + 1;
			int ym = getBit(Y);
			int ym2 = getBit(Y2) + 1;
			
	//		out.println(X2+ " " + Y2);
			
			boolean d1 = isGood(X, Y, false, false);
			boolean d2 = isGood(X, Y2, false, true);
			boolean d3 = isGood(X2, Y, true, false);
			boolean d4 = isGood(X2, Y2, true, true);

			int min = 100;
			int pos = -1;
			if(d1 && Math.min(xm, ym)+1 < min) {
				pos = 1;
				min = Math.min(xm, ym);
			}
			
			if(d2 && Math.min(xm, ym2)+1 < min) {
				pos = 2;
				min = Math.min(xm, ym2);
			}
			
			if(d3 && Math.min(xm2, ym)+1 < min) {
				pos = 3;
				min = Math.min(xm2, ym);
			}
			
			if(d4 && Math.min(xm2, ym2)+1 < min) {
				pos = 4;
				min = Math.min(xm2, ym2);
			}
			
			if(pos == -1) {
				out.println("Case #"+aa+": IMPOSSIBLE");
			}else {
				String ans = "";
				if(pos == 1) {
					ans = ans(X, Y, false, false, xneg, yneg);
				}else if(pos == 2) {
					ans = ans(X, Y2, false, true, xneg, yneg);
				}else if(pos == 3) {
					ans = ans(X2, Y, true, false, xneg, yneg);
				}else if(pos == 4) {
					ans = ans(X2, Y2, true, true, xneg, yneg);
				}
				
				out.println("Case #"+aa+": "+ans);
			}
		}
		
		out.close();

	}
	
	static String ans(int x, int y, boolean xmod, boolean ymod, boolean xneg, boolean yneg) {
		int xm = 0;
		int ym = 0;
		
		if(xmod) {
			x = x + (1 << (getBit(x)+1));
			xm = getBit(x);
		}else {
			xm = getBit(x);
		}
		
		if(ymod) {
			y = y + (1 << (getBit(y)+1));
			ym = getBit(y);
		}else {
			ym = getBit(y);
		}
		
		int lasty = ym;
		int lastx = xm;
		
		char A [] = new char [Math.max(xm, ym)+1];
		for(int i = 0; i <= Math.max(xm, ym); i++) {
			if(bit(x, i) == bit(y, i)) {
				if(xmod && ymod) {
					if(xm < ym) {
						A[i] = 'X';
						lastx = i;
					}else {
						A[i] = 'Y';
						lasty = i;
					}
				}else if(xmod) {
					A[i] = 'X';
					lastx = i;
				}else if(ymod) {
					A[i] = 'Y';
					lasty = i;
				}
			}else {
				if(bit(x, i) == 1) {
					A[i] = 'X';
				}else {
					A[i] = 'Y';
				}
			}
		}
		
		for(int i = 0; i <= Math.max(xm, ym); i++) {
			if(A[i] == 'X') {
				if(i == lastx) {
					A[i] = pos(true, xmod, xneg, true);
				}else {
					A[i] = pos(true, xmod, xneg, false);
				}
			}else {
				if(i == lasty) {
					A[i] = pos(false, ymod, yneg, true);
				}else {
					A[i] = pos(false, ymod, yneg, false);
				}
			}
		}
		String s = "";
		for(int i = 0; i <= Math.max(xm, ym); i++) {
			s = s + A[i];
		}
		return s;
		
	}
	
	static char pos(boolean isX, boolean mod, boolean neg, boolean isLast) {
		if(isX) {
			if(!mod) {
				if(neg) {
					return 'W';
				}else {
					return 'E';
				}
			}else {
				if(isLast) {
					if(neg) {
						return 'W';
					}else {
						return 'E';
					}
				}else {
					if(neg) {
						return 'E';
					}else {
						return 'W';
					}
				}
			}
		}else {
			if(!mod) {
				if(neg) {
					return 'S';
				}else {
					return 'N';
				}
			}else {
				if(isLast) {
					if(neg) {
						return 'S';
					}else {
						return 'N';
					}
				}else {
					if(neg) {
						return 'N';
					}else {
						return 'S';
					}
				}
			}
		}
	}
	
	static boolean isGood(int x, int y, boolean xmod, boolean ymod) {
		int xm = 0;
		int ym = 0;
		
		if(xmod) {
			x = x + (1 << (getBit(x)+1));
			xm = getBit(x);
		}else {
			xm = getBit(x);
		}
		if(ymod) {
			y = y + (1 << (getBit(y)+1));
			ym = getBit(y);
		}else {
			ym = getBit(y);
		}
		boolean good = true;
		for(int i = 0; i <= Math.max(xm, ym); i++) {
			if(bit(x, i) == bit(y, i)) {
				if(bit(x, i) == 0) {
					if(xmod && ymod) {
						if(Math.min(xm, ym) >= i) {
							good = false;
						}
					}else if(xmod) {
						if(xm >= i) {
							good = false;
						}
					}else if(ymod) {
						if(ym >= i) {
							good = false;
						}
					}else {
						good = false;
					}
				}else {
					good = false;
				}
			//s	System.out.println(i+ " " + bit(x, i) +" "+ bit(x, getBit(x)));
			}
		}
		return good;
	}
	
	static int bit(int num, int p) {
		return ((num >> (p)) & 1);
	}
	
	
    public static int getBit(int n) 
    { 
    	if(n == 0 || n == 1) {
    		return 0;
    	}
        return (int)((Math.log10(n & -n)) / Math.log10(2))+1; 
    } 

	
	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner(InputStream stream) {
			br = new BufferedReader(new InputStreamReader(stream));
			st = new StringTokenizer("");
		}

		public FastScanner(String fileName) throws Exception {
			br = new BufferedReader(new FileReader(new File(fileName)));
			st = new StringTokenizer("");
		}

		public String next() throws Exception {
			while (!st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}

		public int nextInt() throws Exception {
			return Integer.parseInt(next());
		}

		public long nextLong() throws Exception {
			return Long.parseLong(next());
		}

		public Double nextDouble() throws Exception {
			return Double.parseDouble(next());
		}

		public String nextLine() throws Exception {
			if (st.hasMoreTokens()) {
				StringBuilder str = new StringBuilder();
				boolean first = true;
				while (st.hasMoreTokens()) {
					if (first) {
						first = false;
					} else {
						str.append(" ");
					}
					str.append(st.nextToken());
				}
				return str.toString();
			} else {
				return br.readLine();
			}
		}
	}

}