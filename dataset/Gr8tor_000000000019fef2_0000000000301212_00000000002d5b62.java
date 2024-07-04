import java.io.*;
import java.util.*;

public class Solution {
		public static void main(String[] args) throws IOException{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(in.readLine());
			for (int t = 0; t < T; t++) {
				System.out.print("Case #" + (t+1) + ": ");
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				
				ArrayList<Integer> xBin = toBin(Math.abs(X));
				ArrayList<Integer> yBin = toBin(Math.abs(Y));
				resize(xBin, yBin);
				//System.out.println(xBin.size() + " " + yBin.size());
				
				boolean imp = false;
				
				if (xBin.get(0) == yBin.get(0)) {
					System.out.println("IMPOSSIBLE");
					imp = true;
				} else {
					for (int i = 1; i < xBin.size(); i++) {
						
						if (xBin.get(i) == 1 && yBin.get(i) == 1) {
							if (xBin.get(i-1) == 1) {
								i = change(xBin, i) - 1;
							} else if (yBin.get(i-1) == 1) {
								i = change(yBin, i) - 1;
							} else {
								System.out.println("IMPOSSIBLE");
								imp = true;
								
								break;
							}
						}
						
					}
					
					for (int i = 1; i < xBin.size() - 1; i++) {
						if (xBin.get(i) == 0 && yBin.get(i) == 0) {
							if (xBin.get(i-1) == 1) {
								xBin.set(i-1, -1);
								xBin.set(i, 1);
							} else {
								yBin.set(i-1, -1);
								yBin.set(i, 1);
							}
						}
					}
				}
				
				if (!imp) {
					char[] Xchars = {'E', 'W'};
					char[] Ychars = {'N', 'S'};
					
					int xT = 0, yT = 0;
					if (X < 0) xT = 1;
					if (Y < 0) yT = 1;
					
					for (int i = 0; i < xBin.size(); i++) {
							 if (xBin.get(i) == 1)  {System.out.print(Xchars[(0 + xT) % 2]);}
						else if (xBin.get(i) == -1) {System.out.print(Xchars[(1 + xT) % 2]);}
						else if (yBin.get(i) == 1)  {System.out.print(Ychars[(0 + yT) % 2]);}
						else if (yBin.get(i) == -1) {System.out.print(Ychars[(1 + yT) % 2]);}
					}
					System.out.println();
				}
			}
		}
		public static int change(ArrayList<Integer> arr, int i) {
			arr.set(i-1, -1);
			while (arr.get(i) == 1) {
				arr.set(i, 0);
				i++;
			}
			arr.set(i, 1);
			
			return i;
		}
		public static void resize(ArrayList<Integer> xBin, ArrayList<Integer> yBin) {
			if (xBin.size() == yBin.size()) return;
			
			ArrayList<Integer> small;
			ArrayList<Integer> big;
			if (xBin.size() < yBin.size()) {
				small = xBin;
				big = yBin;
			} else {
				small = yBin;
				big = xBin;
			}
			
			int times = big.size() - small.size();
			for (int i = 0; i < times; i++) 
				small.add(0);
			
			//System.out.println(small.size() + " " + big.size());

		}
		public static ArrayList<Integer> toBin (int x) {
			ArrayList<Integer> bin = new ArrayList<Integer>();
			
			while (x > 0) {
				bin.add(x % 2);
				x /= 2;
			}
			
			bin.add(0);
			return bin;
		}
}
