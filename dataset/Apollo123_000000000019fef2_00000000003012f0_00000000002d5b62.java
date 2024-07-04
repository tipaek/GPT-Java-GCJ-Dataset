import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

	static String numToBin(int n) {
		String s = "";
		if(n == 0){
			s = "0";
		}
		while (n > 0) {
			if (n % 2 == 0) {
				s = "0" + s;
			} else {
				s = "1" + s;
			}
			n /= 2;
		}
		return s;
	}

	static String sendUp(String s, int k) {
		String s2 = s.substring(k+1);
		boolean start = false;
		boolean stop = false;
		for (int i = k; i >= 0; i--) {
			if (!start) {
				s2 = "0" + s2;
				if (s.charAt(i) == '1') {
					start = true;
				}
			} else if(start){
				if(!stop){
					if(s.charAt(i) == '1'){
						s2 = "0" + s2;
					}else{
						s2 = "1" + s2;
						stop = true;
					}
				}else if(stop){
					s2 = ""+s2.charAt(i)+s2;
				}
				
				
			}
		}

		return s2;
	}

	public static void main(String[] args) {
		Kattio scan = new Kattio(System.in);
		int T = scan.getInt();
		for (int t = 1; t <= T; t++) {
			int x = scan.getInt();
			int y = scan.getInt();
			int posX = 1;
			if (x < 0) {
				posX = -1;
				x = -x;
			}

			int posY = 1;
			if (y < 0) {
				posY = -1;
				y = -y;
			}
			String sx = numToBin(x);
			String sy = numToBin(y);

			for (int i = 0; i < sx.length() - sy.length(); i++) {
				sy = "0" + sy;
			}
			for (int i = 0; i < sy.length() - sx.length(); i++) {
				sx = "0" + sx;
			}
			sx = "0" + sx;
			sy = "0" + sy;
			String out = "";
			
			

			for (int i = sx.length() - 1; i >= 1; i--) {
				if (sx.charAt(i) == '0' && sy.charAt(i) == '0') {
					out = "IMPOSSIBLE";
					break;
				} else if (sx.charAt(i) == '1' && sy.charAt(i) == '0') {
					if ((sx.charAt(i - 1) == '1' && sy.charAt(i - 1) == '1')
							|| (i!=1&&(sx.charAt(i - 1) == '0' && sy.charAt(i - 1) == '0'))) {
						if (posX == 1) {
							out = out + "W";
						} else {
							out = out + "E";
						}
						sx = sendUp(sx, i);
						
					} else {
						if (posX == 1) {
							out = out + "E";
						} else {
							out = out + "W";
						}
					}

				} else if (sx.charAt(i) == '0' && sy.charAt(i) == '1') {
					if ((sy.charAt(i - 1) == '1' && sx.charAt(i - 1) == '1')
							|| (i!=1&&(sy.charAt(i - 1) == '0' && sx.charAt(i - 1) == '0'))) {
						if (posY == 1) {
							out = out + "S";
						} else {
							out = out + "N";
						}
						sy = sendUp(sy, i);

					} else {
						if (posY == 1) {
							out = out + "N";
						} else {
							out = out + "S";
						}
					}
				} else if (sx.charAt(i) == '1' && sy.charAt(i) == '1') {
					out = "IMPOSSIBLE";
					break;
				}
			}
			
			if(sx.charAt(0) == '0' && sy.charAt(0) == '0'){
				
			}else if(sx.charAt(0) == '1' && sy.charAt(0) == '1'){
				out = "IMPOSSIBLE";
			}else if(sx.charAt(0) == '1' && sy.charAt(0) == '0'){
				if (posX == 1) {
					out = out + "E";
				} else {
					out = out + "W";
				}
			}else if(sx.charAt(0) == '0' && sy.charAt(0) == '1'){
				if (posY == 1) {
					out = out + "N";
				} else {
					out = out + "S";
				}
			}
			
			
			
			System.out.println("Case #" + t+ ": " + out);

		}

	}

	private static class Kattio extends PrintWriter {
		public Kattio(InputStream i) {
			super(new BufferedOutputStream(System.out));
			r = new BufferedReader(new InputStreamReader(i));
		}

		public Kattio(InputStream i, OutputStream o) {
			super(new BufferedOutputStream(o));
			r = new BufferedReader(new InputStreamReader(i));
		}

		public boolean hasMoreTokens() {
			return peekToken() != null;
		}

		public int getInt() {
			return Integer.parseInt(nextToken());
		}

		public double getDouble() {
			return Double.parseDouble(nextToken());
		}

		public long getLong() {
			return Long.parseLong(nextToken());
		}

		public String getWord() {
			return nextToken();
		}

		private BufferedReader r;
		private String line;
		private StringTokenizer st;
		private String token;

		private String peekToken() {
			if (token == null)
				try {
					while (st == null || !st.hasMoreTokens()) {
						line = r.readLine();
						if (line == null)
							return null;
						st = new StringTokenizer(line);
					}
					token = st.nextToken();
				} catch (IOException e) {
				}
			return token;
		}

		private String nextToken() {
			String ans = peekToken();
			token = null;
			return ans;
		}
	}

}
