import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String args[]) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer str = new StringTokenizer(br.readLine());
	int testCases = Integer.parseInt(str.nextToken());
	int ll=1;
	while(testCases-->0) {

	  str = new StringTokenizer(br.readLine());
	  int targetX = Integer.parseInt(str.nextToken());
	  int targetY = Integer.parseInt(str.nextToken());
	  
	  LinkedList<Point> q = new LinkedList<Point>();
	  int multiplier = 1;
	  q.add(new Point(0,0,""));
	  int level = 1;
	  q.add(new Point(Integer.MAX_VALUE,Integer.MAX_VALUE,""));
	  boolean found = false;
	  String result ="";
	  while(!q.isEmpty() ) {
	        Point p = q.removeFirst();
	     //   System.out.println(p.x+" "+p.y+" "+p.s);
	        if(p.x==targetX && p.y == targetY) {
	            found = true;
	            result = p.s;
	            break;
	            
	        }
	        
	        if(p.x == Integer.MAX_VALUE) {
	            level++;
	            multiplier *= 2;
	            if(q.isEmpty() ) {
	               
	                break;
	            }
	            if(q.peekFirst().x != Integer.MAX_VALUE) {
	       
	                q.add(new Point(Integer.MAX_VALUE,Integer.MAX_VALUE,""));
	                continue;
	            }
	            
	        }
	        if(Math.abs(p.x-targetX)>=multiplier)
	        q.add(new Point(p.x-multiplier,p.y,"W"+p.s));
	 
	        if(Math.abs(p.x-targetX)>=multiplier)
	        q.add(new Point(p.x+multiplier,p.y, "E"+p.s));
	 
	       if(Math.abs(p.y-targetY)>=multiplier)
	        q.add(new Point(p.x,p.y-multiplier, "N"+p.s));
	 
	        if(Math.abs(p.y-targetY)>=multiplier)
	        q.add(new Point(p.x,p.y+multiplier, "S"+p.s));
	        
	        
	  
	  }
        if(found) {
	        System.out.println("Case #"+ll+": "+result);
	  }
	  else {
	        System.out.println("Case #"+ll+": IMPOSSIBLE");
	  
	  }
          ll++;   

	}
	
  }
}
class Point
{
    public int x, y;
    String s;
    public Point(int x, int y, String s) {
        this.x = x;
        this.y = y;
        this.s = s;
    }

}