import java.io.*;
import java.util.*;
import java.awt.Point;

 class Solution {
	
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int z = 0; z< N; z++) {
			ArrayList<Point> jamie = new ArrayList<Point>();
			ArrayList<Point> cameron = new ArrayList<Point>();
			
			String output = "";
			int n = Integer.parseInt(br.readLine());
			for(int i = 0; i< n; i++) {
				
				StringTokenizer st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				Point current = new Point(start, end);
				
				if(possible(jamie, current)) {
					output+="J";
					jamie.add(current);
				}
				else if(possible(cameron, current)) {
					output+="C";
					cameron.add(current);
				}
				else {
					output = "IMPOSSIBLE";
					break;
				}
			}
			
			
			System.out.println("Case #"+(z+1)+": "+output);
			
		}
	}
	
	
	public static boolean possible(ArrayList<Point> person, Point current) {
		for(Point p:person) {
			if((current.x<p.y &&current.x>p.x) ||(current.y<p.y &&current.y>p.x) ) {
				return false;
			}
		}
		
		return true;
	}

}