import java.util.*;
public class Solution {
	static HashMap<Long, String> H;
	static long MOD = 1000000007L;
	static long GBIT = 0;
	public static void main (String [] arg) {
		Scanner sc = new Scanner(System.in);
		int TT = Integer.parseInt(sc.nextLine());

		for (int ii = 1; ii<=TT; ++ii) {
			//Something
			H = new HashMap<Long,String>();
			long X = sc.nextInt();
			long Y = sc.nextInt();
			StringBuilder ansB = new StringBuilder(31);

			boolean useEast = (X >= 0);
			boolean useNorth = (Y >= 0);
			X = Math.abs(X);
			Y = Math.abs(Y);

			int BIT = 32;
			String ans = recurse(X,Y,BIT, false);
			if (ans != null && !useEast) ans = flip(ans, 'E', 'W');
			if (ans != null && !useNorth) ans = flip(ans, 'N', 'S');
			if (X == 0 && Y == 0) ans = "IMPOSSIBLE";

			System.out.printf("Case #%d: %s\n",ii, ans == null ? "IMPOSSIBLE" : ans);
		}
	}
	public static String flip(String ans, char c1, char c2) {
		if (ans == null) return null;
		StringBuilder b = new StringBuilder(ans.length());
		char [] c = ans.toCharArray();
		for (char c3 : c) {
			if (c3 == c1) {
				b = b.append(c2);
			} else if (c3 == c2) {
				b = b.append(c1);
			} else {
				b = b.append(c3);
			}
		}
		return b.toString();
	}

	public static String recurse(long X, long Y, int BIT, boolean has) {
		if (BIT == 0) {
			if (X == 1 && Y == 1) return null;
			if (X == 0 && Y == 0) return null;
			return (X == 1) ? "E" : (Y == 1) ? "N" : null;
		} else if (X == 0 && Y == 0) {
			return null;
		}
		long key = X + MOD*Y;
		if (!H.containsKey(key)) {
			long T = 1L<<BIT;
			boolean Xt =(X & T) != 0;
			boolean Yt =(Y & T) != 0;
			//System.err.println("AT BIT " + BIT + " with X = " + X + " Y = " + Y);
			if (Xt && Yt) {
				H.put(key, null);
			} else if (Xt) {
				String ans = recurse(X ^ T, Y, BIT-1, true);
				H.put(key, (ans== null) ? null : ans + "E");
			} else if (Yt) {
				String ans = recurse(X, Y ^ T, BIT-1, true);
				H.put(key, (ans == null) ? null : ans + "N");
			} else if (X >= T || Y >= T) {
				H.put(key, null);
			} else {
				String ans0 = (!has) ? recurse(X, Y, BIT-1, has) : null;
				//System.err.println("AT BIT " + BIT + " with X = " + X + " Y = " + Y + " ans=" + ans0);
				if (ans0 != null) {
					//System.err.println("Triggered how");
					return ans0;
				} else {
				 String ans1 = (X == 0) ? null : flip( recurse(T - X, Y, BIT-1, true), 'E', 'W');
				 String ans2 = null;
				 if (ans1 == null) {
					ans2 = flip( (Y == 0) ? null : recurse(X, T - Y, BIT-1, true), 'N', 'S');
					if (ans2 != null) {
						H.put(key, ans2 + "N");
					} else {
						H.put(key, null);
					}
				 } else {
					H.put(key, ans1 + "E");
				 }
			 }
			}
		}
		return H.get(key);
	}
/*
	public static Pair recurse(long X, long Y, long T, int Z) {

		if (X == 0 && Y == 0 && T == 0) return 0;
		if (X == 0 && Y == 0) return -1;
		long key X + MOD*Y;

		boolean Xt1 =(X & T) != 0;
		boolean Yt1 =(Y & T) != 0;
		long upperT = T;
		T = T>>1;
		boolean Xt = (X & T) != 0;
		boolean Yt = (Y & T) != 0;
		if (!H.containsKey(key)) {
			if (Xt1 && Yt1) {
				H.put(key, -1);
			} else if (Xt1) {
				long ans = recurse( X ^ upperT , Y, T, Z-2);
				H.put(key, ans + 0*(1<<Z));
			} else if (Yt1) {
				long ans = recurse( X , Y^upperT, T);
				H.put(key, ans + 3*(1<<Z));
			} else if (Xt && Yt) {
				long ans1 = recurse(upperT-X, Y ^ T, T>>1, Z-2);
				if (ans1 >= 0) H.put(key, ans1);
				else {
					long ans2 = recurse(X ^ T, upperT-Y, T>>1);
					if (ans2>=0) H.put(key, ans2 + (1<<Z)*3);
					else H.put(key, -1);
				}
			} else if (Xt) {
				long ans = recurse()
			}
		}
		return H.get(key);
	}
	*/

}
