import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		loop: for (int i = 1; i <= T; i++) {
			System.out.print("Case #" + i + ": ");
			StringTokenizer token = new StringTokenizer(in.readLine());
			int X = Integer.parseInt(token.nextToken());
			int Y = Integer.parseInt(token.nextToken());
			boolean negx = (X < 0);
			boolean negy = (Y < 0);
			if (X < 0)
				X = -X;
			if (Y < 0)
				Y = -Y;
			if (X == 0) {
				char[] y = Integer.toBinaryString(Y).toCharArray();
				StringBuilder moves = new StringBuilder(40);
				for(int a = y.length - 1; a >= 0; a--) {
					if(y[a] == '1')
						moves.append(negy ? 'S' : 'N');
					else {
						System.out.println("IMPOSSIBLE");
						continue loop;
					}
				}
				System.out.println(moves.toString());
			} else if (Y == 0) {
				char[] x = Integer.toBinaryString(X).toCharArray();
				StringBuilder moves = new StringBuilder(40);
				for(int a = x.length - 1; a >= 0; a--) {
					if(x[a] == '1')
						moves.append(negx ? 'W' : 'E');
					else {
						System.out.println("IMPOSSIBLE");
						continue loop;
					}
				}
				System.out.println(moves.toString());
			} else {
				String tx = ("0" + Integer.toBinaryString(X));
				String ty = ("0" + Integer.toBinaryString(Y));
				while (tx.length() < ty.length())
					tx = "0" + tx;
				while (ty.length() < tx.length())
					ty = "0" + ty;
				char[] x = tx.toCharArray();
				char[] y = ty.toCharArray();
				StringBuilder moves = new StringBuilder(40);
				boolean poss = true;
				for (int a = 0; a < x.length - 2; a++) {
					if (x[x.length - 1 - a] == y[y.length - 1 - a]) {
						poss = false;
						break;
					}
					if (x[x.length - 1 - a] == '1') {
						if (x[x.length - 1 - a - 1] == y[y.length - 1 - a - 1]) {
							moves.append('W');
							x[x.length - 1 - a] = '0';
							int idx = x.length - 1 - a - 1;
							while (x[idx] == '1') {
								x[idx] = '0';
								idx--;
							}
							x[idx] = '1';
						} else {
							moves.append('E');
							x[x.length - 1 - a] = '0';
						}
					} else {
						if (y[y.length - 1 - a - 1] == x[x.length - 1 - a - 1]) {
							moves.append('S');
							y[y.length - 1 - a] = '0';
							int idx = y.length - 1 - a - 1;
							while (y[idx] == '1') {
								y[idx] = '0';
								idx--;
							}
							y[idx] = '1';
						} else {
							moves.append('N');
							y[y.length - 1 - a] = '0';
						}
					}
				}
				if (!poss) {
					System.out.println("IMPOSSIBLE");
					continue;
				}
				if(x[1] == '1' && x[0] == '1' || y[1] == '1' && y[0] == '1') {
					while(true) {
						
					}
				}
				if (x[1] == '0' && x[0] == '0') {
					if (y[1] == '0' && y[0] == '1') {
						System.out.println("IMPOSSIBLE");
						continue;
					}
					if (y[1] == '1' && y[0] == '0')
						moves.append('N');
				} else if (x[1] == '1') {
					if (y[1] == '1') {
						System.out.println("IMPOSSIBLE");
						continue;
					}
					if (y[0] == '1') {
						moves.append('E');
						moves.append('N');
					} else
						moves.append('E');
				} else {
					if (y[1] == '0' && y[0] == '1') {
						System.out.println("IMPOSSIBLE");
						continue;
					}
					if (y[1] == '1') {
						moves.append('N');
						moves.append('E');
					} else {
						System.out.println("IMPOSSIBLE");
						continue;
					}
				}
				if (negx) {
					for(int a = 0; a < moves.length(); a++)
						if(moves.charAt(a) == 'E')
							moves.setCharAt(a, 'W');
						else if(moves.charAt(a) == 'W')
							moves.setCharAt(a, 'E');
				}
				if (negy) {
					for(int a = 0; a < moves.length(); a++)
						if(moves.charAt(a) == 'N')
							moves.setCharAt(a, 'S');
						else if(moves.charAt(a) == 'S')
							moves.setCharAt(a, 'N');
				}
				System.out.println(moves.toString());
			}
		}
	}
}
