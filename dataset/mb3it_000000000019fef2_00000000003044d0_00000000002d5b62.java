import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTestCase = in.nextInt();
        int [][]pointArray = new int[numTestCase][2];
        
        for (int i = 0; i < numTestCase; ++i) {
        	pointArray[i][0] = in.nextInt();
        	pointArray[i][1] = in.nextInt();
        }
        in.close();
        
        for (int i = 0; i < numTestCase; i++) {
        	System.out.print("Case #" + (i+1) + ": ");
        	run(pointArray[i][0], pointArray[i][1]);
        }
	}
	
	private static void run(int X, int Y){
		boolean found = false;
		HashMap<String, String> jumpsMap = new HashMap<>();
		Queue<String> q = new LinkedList<>();
		
		q.add("0,0");
		q.add(null);
		
		int i = 0;
		int curX = 0, curY = 0;
		String coord;
		String key;
		while(q.size() > 1){
			if(q.peek() == null){
				i++;
				q.remove();
				q.add(null);
			}
			
			coord = q.poll();
			int j = (int)Math.pow(2, i);
			curX = Integer.parseInt(coord.split(",")[0]);
			curY = Integer.parseInt(coord.split(",")[1]);
			
			if(Math.abs(X - curX) > j || Math.abs(Y - curY) > j || (Math.abs(X - curX) == j && Y == curY) || (Math.abs(Y - curY) == j && X == curX)){
				if(X == curX + j && Y == curY){
					found = true;
					System.out.println(jumpsMap.get(curX + "," + curY) + "E");
					break;
				}
				else{
					key = (curX + j) + "," + curY;
					if(!jumpsMap.containsKey(key)){
						q.add(key);
						if(jumpsMap.containsKey(coord)){
							jumpsMap.put(key, jumpsMap.get(coord)+"E");
						}
						else{
							jumpsMap.put(key, "E");
						}
					}
				}
				
				if(X == curX - j && Y == curY){
					found = true;
					System.out.println(jumpsMap.get(curX + "," + curY) + "W");
					break;
				}
				else{
					key = (curX - j) + "," + curY;
					if(!jumpsMap.containsKey(key)){
						q.add(key);
						if(jumpsMap.containsKey(coord)){
							jumpsMap.put(key, jumpsMap.get(coord)+"W");
						}
						else{
							jumpsMap.put(key, "W");
						}
					}
				}
				
				if(X == curX && Y == curY + j){
					found = true;
					System.out.println(jumpsMap.get(curX + "," + curY) + "N");
					break;
				}
				else{
					key = curX + "," + (curY + j);
					if(!jumpsMap.containsKey(key)){
						q.add(key);
						if(jumpsMap.containsKey(coord)){
							jumpsMap.put(key, jumpsMap.get(coord)+"N");
						}
						else{
							jumpsMap.put(key, "N");
						}
					}
				}
				
				if(X == curX && Y == curY - j){
					found = true;
					System.out.println(jumpsMap.get(curX + "," + curY) + "S");
					break;
				}
				else{
					key = curX + "," + (curY - j);
					if(!jumpsMap.containsKey(key)){
						q.add(key);
						if(jumpsMap.containsKey(coord)){
							jumpsMap.put(key, jumpsMap.get(coord)+"S");
						}
						else{
							jumpsMap.put(key, "S");
						}
					}
				}
			}
		}
		
		if(!found){
			System.out.println("IMPOSSIBLE");
		}			
	}
}