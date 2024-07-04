import java.util.Scanner;
import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		for (int t = 1; t <= tc; t++) {
			int x = in.nextInt();
			int y = in.nextInt();
			int ax = Math.abs(x);
			int ay = Math.abs(y);
			if (ax % 2 == ay % 2) System.out.println("Case #" + t + ": IMPOSSIBLE");
			else {
				int j = 1;
				int lx = 0, ly = 0;
				String path = "";
				while (true) {
					//System.out.println(path + " loc: " + lx + " " + ly);
					int m = 1<<j;
					if ((ax-lx) % m != 0) {
						// take ax +/- 1 <<(j-1)
						if (lx + (1 << (j-1)) == ax && ((ay != ly) ? (ay-ly) % m != 0 : true)) {
							lx += 1<<(j-1);
							path += "E";
						} else if (lx - (1 << (j-1)) == ax && ((ay != ly) ? (ay-ly) % m != 0 : true)) {
							lx -= 1<<(j-1);
							path += "W";
						} else if ((ax - (lx+ (1<<(j-1)))) % (m<<1) != (ay-ly)%(m<<1)) {
							lx += 1<<(j-1);
							path += "E";
						} else {
							lx -= 1<<(j-1);
							path += "W";
						}
					} else if ((ay-ly) % m != 0) {
						if (ly+(1<<(j-1)) == ay && ((ax != lx) ? (ax-lx) % m != 0 : true)) {
							ly += 1<<(j-1);
							path += "N";
						} else if (ly-(1<<(j-1)) == ay && ((ax != lx) ? (ax-lx) % m != 0 : true)) {
							ly -= 1<<(j-1);
							path += "S";
						} else if ((ay-(ly+(1<<(j-1)))) % (m<<1) != (ax-lx)%(m<<1)) {
							ly += 1<<(j-1);
							path += "N";
						} else {
							ly -= 1<<(j-1);
							path += "S";
						}
					} else {
						System.out.println("error");
						break;
					}
					j++;
					if (lx == ax && ly == ay) break;
				}
				Hashtable<Character, Character> h = new Hashtable<Character, Character>();
				if (x >= 0 && y >= 0) {
					h.put('N', 'N');
					h.put('S', 'S');
					h.put('E', 'E');
					h.put('W', 'W');
				} else if (x >= 0) {
					h.put('N', 'S');
					h.put('S', 'N');
					h.put('E', 'E');
					h.put('W', 'W');
				} else if (y >= 0) {
					h.put('N', 'N');
					h.put('S', 'S');
					h.put('E', 'W');
					h.put('W', 'E');
				} else {
					h.put('N', 'S');
					h.put('S', 'N');
					h.put('E', 'W');
					h.put('W', 'E');
				}
				
				String str = "";
				for (int i = 0; i < path.length(); i++) str += h.get(path.charAt(i));
				System.out.println("Case #" + t + ": " + str);
			}
			
		}
	}
}
