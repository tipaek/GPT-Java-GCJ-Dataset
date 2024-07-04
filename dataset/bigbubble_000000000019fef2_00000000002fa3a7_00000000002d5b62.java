import java.io.*;
import java.util.*;

public class Solution {
	static Scanner sc;

	public static void main(String[] args) throws IOException{
		sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		//File f = new File("D.txt");
		//sc = new Scanner(f);
		
		
		int t = sc.nextInt(); 
		for (int i = 1; i <= t; i++) {
			int x= sc.nextInt();
			int y = sc.nextInt();
			boolean xpos = true; boolean ypos = true;
			if (x < 0) {
				xpos = false;
				x = x*(-1);
			}
			if (y < 0) {
				ypos = false;
				y = y* (-1);
			}
			
			ArrayList<String> arr = new ArrayList<String>();
			
			int toRet = -1;
			while(x > 0 || y > 0) {
				if (x > 0 && y == 0) {
					if (x % 2 == 0) {
						break;
					} else if (x==1) {
						arr.add("W");
						x = 0;
						toRet = 1;
					}
					if (x % 4 == 1) {
						arr.add("E");
						x = x+1;
						x = x/2;
					}else if (x % 4 == 3) {
						arr.add("W");
						x = x -1;
						x = x/2;
					}
				}else if (y > 0 && x == 0) {
					if (y % 2 == 0) {
						break;
					} else if (y==1) {
						arr.add("N");
						y = 0;
						toRet = 1;
					}
					if (y % 4 == 1) {
						arr.add("S");
						y = y+1;
						y = y/2;
					}else if (y % 4 == 3) {
						arr.add("N");
						y = y -1;
						y = y/2;
					}
				} else {
					if (x % 2 == 1 && y % 2 == 0) {
						if (y % 4 == 0) {
							if (x % 4 == 1)	{
								x = x+1;
								arr.add("E");
							}
							else if (x % 4 == 3) {
								x = x - 1;
								arr.add("W");
							}
							
						} else if (y % 4 == 2) {
							if (x % 4 == 1) {
								x = x-1;
								arr.add("W");
							}
							else {
								x = x +1;
								arr.add("E");
							}
						}
					} else if (y % 2 == 1 && x % 2 == 0) {
						if (x % 4 == 0) {
							if (y % 4 == 1)	{
								y = y+1;
								arr.add("S");
							}
							else if (y % 4 == 3) {
								y = y - 1;
								arr.add("N");
							}
							
						} else if (x % 4 == 2) {
							if (y % 4 == 1) {
								y = y-1;
								arr.add("N");
							}
							else {
								y = y +1;
								arr.add("S");
							}
						}
					}else {
						break;
					}
					
					x = x/2;
					y = y/2;
				}
			}
			String toret = "";
			if (toRet == -1) toret = "IMPOSSIBLE";
			else {
				for (int j = 0; j < arr.size(); j++) {
					if (xpos == true) {
						if (arr.get(j).equals("W")) arr.set(j,  "E");
						else if (arr.get(j).equals("E")) arr.set(j,  "W");
					}
					if (ypos == false) {
						if (arr.get(j).equals("N")) arr.set(j,  "S");
						else if (arr.get(j).equals("S")) arr.set(j,  "N");
					}
					toret = toret + arr.get(j);
				}
			}
			System.out.println("Case #" + i + ": " + toret);
			
		}
	}
}
