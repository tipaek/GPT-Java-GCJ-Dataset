
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	
	public static class Coord {
		final int x;
		final int y;
		final String path;
		Coord(String path, int x, int y) {
			this.x = x;
			this.y = y;
			this.path = path;
		}
	}
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int i = 0;i<t;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			String result = "";
			
			
			ArrayList<Coord> coords = new ArrayList<Coord>();
			coords.add(new Coord("", 0, 0));
			int nextNum = 1;
			
			while (!coords.isEmpty() && result.length()==0) {
				ArrayList<Coord> temp = new ArrayList<Coord>();
				for (int j = 0;j<coords.size();j++) {
					Coord now = coords.get(j);
					if (now.x==x && now.y==y) {
						result = now.path;
						break;
					}
					//System.out.println(now.x+" "+now.y);
					int diffx = now.x-x;
					if (diffx<0) diffx*=-1;
					
					int diffy = now.y-y;
					if (diffy<0) diffy*=-1;
					
					if ((diffx!=0 && (diffx<nextNum*2 && diffx!=nextNum)) || (diffy!=0 && (diffy<nextNum*2 && diffy!=nextNum))) continue;
					
					
					if (diffy!=0) {
						temp.add(new Coord(now.path+"N",now.x, now.y+nextNum));
						temp.add(new Coord(now.path+"S",now.x, now.y-nextNum));
					}
					if (diffx!=0) {
						temp.add(new Coord(now.path+"E",now.x+nextNum, now.y));
						temp.add(new Coord(now.path+"W",now.x-nextNum, now.y));
					}
					
				}
				coords = temp;
				nextNum*=2;
			}
			if (result.contentEquals("") && (x!=0 || y!=0)) result = "IMPOSSIBLE";
			System.out.println("Case #"+(i+1)+": "+result);
		}
	}
}
