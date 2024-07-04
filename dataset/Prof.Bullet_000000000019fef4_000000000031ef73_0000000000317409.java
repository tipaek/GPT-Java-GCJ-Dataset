
import java.util.*;
import java.io.*;

public class Solution {
	public static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
    public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    
    public static void main(String []args) {
        int numOfCases = in.nextInt();
        for (int caseNum = 0; caseNum < numOfCases; caseNum++) {
        	int x = in.nextInt();
        	int y = in.nextInt();
        	System.out.println("Case #"+ (caseNum+1) + ": " + calcCase(x, y));
        }
    } 
    
    public static String calcCase (int x, int y) {
    	Point currentPoint = new Point(x,y);
    	Point startiongPoint = new Point (0,0);
    	String tour = in.next();
    	for (int i = 0; i < tour.length(); i++) {
    		currentPoint = getPointFromDirection(currentPoint, tour.charAt(i));
    		int d = distance(currentPoint, startiongPoint);
    		if (d <= i+1) {
    			return (String.valueOf(i+1));
    		}
    	}
    	return "IMPOSSIBLE";
    }
    
    public static Point getPointFromDirection(Point currentPoint, char direction) {
    	if (direction == 'N') {
    		return (new Point(currentPoint.x, currentPoint.y+1));
    	}else if (direction == 'S') {
    		return (new Point(currentPoint.x, currentPoint.y-1));
    	}else if (direction == 'E') {
    		return (new Point(currentPoint.x+1, currentPoint.y));
    	}
    	return (new Point(currentPoint.x-1, currentPoint.y));
    }
    
    public static int distance (Point p1, Point p2) {
    	return (Math.abs(p2.x-p1.x) + Math.abs(p2.y-p1.y));
    }
    


    
}


