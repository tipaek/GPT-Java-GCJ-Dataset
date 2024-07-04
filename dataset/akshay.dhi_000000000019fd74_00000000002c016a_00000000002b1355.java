import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String args[]) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer str = new StringTokenizer(br.readLine());
	int testCases = Integer.parseInt(str.nextToken());

	while(testCases-->0) {
		str = new StringTokenizer(br.readLine());
		int rows = Integer.parseInt(str.nextToken());
		int cols = Integer.parseInt(str.nextToken());
		int matrix[][] = new int[rows][cols];
		LinkedList<Point> queue = new LinkedList<Point>();
		
		for(int i=0;i<rows;i++) {
		    str = new StringTokenizer(br.readLine());
		    for(int j=0;j<cols;j++) {
		        matrix[i][j] = Integer.parseInt(str.nextToken());
		        queue.add(new Point(i,j));
		    }
		}
		queue.add(new Point(-1,-1));
		int rounds = 1;
		int lastRoundTotal = 0;
		int total = 0;
		long sum = 0;
		while(!queue.isEmpty())
		{
		    Point p= queue.removeFirst();
		    System.out.println(p.x+" "+p.y);
		   
		    if(p.x == -1 && p.y ==-1) {
		        if((!queue.isEmpty()) )
		        {
		            if(queue.peekLast().x!=-1 )
		            {
		                queue.add(new Point(-1,-1));
		                if(lastRoundTotal == total) {
		                    break;
		                }
		                sum+=total;
		                lastRoundTotal = total;
		                total=0;
		                rounds++;
		            }
		            
		        }
		        
		    
		    }
		    
		    
		    
		    total += matrix[p.x][p.y];
		    int count =0;
		    int totalr=0;
		    if(leftExist(p.x, rows, cols)) {
		        count++;
		        totalr+=matrix[p.x][p.y-1];
	 
		    }
		    if(rightExist(p.x, rows, cols)) {
		        count++;
		        totalr+=matrix[p.x][p.y+1];
		    }
		    if(topExist(p.x, rows, cols)) {
		        count++;
		        totalr+=matrix[p.x-1][p.y];
		    }
		    if(bottomExist(p.x, rows, cols)) {
		        count++;
		        totalr+=matrix[p.x+1][p.y];
		    }
		    
                double average =(double) (totalr)/count;
                
                if(average<=matrix[p.x][p.y])
                {
                    queue.add(new Point(p.x,p.y));
                }
            
            
  
		}
		System.out.println(sum);
		
		
	}
  }
  public static boolean leftExist(int x, int rows,int cols){
    if(x>0)
        return true;
    return false;
  }
  public static boolean rightExist(int x, int rows,int cols){
      if(x==cols-1)
        return false;
    return true;
  
  }public static boolean topExist(int y, int rows,int cols){
  
  if(y==0)
        return false;
    return true;
  
  }public static boolean bottomExist(int y, int rows,int cols){
   if(y==rows-1)
        return false;
    return true;
 
  }
}
class Point
{
    Point(int x, int y) {
        this.x= x;
        this.y =y;
    
    }
    public int x,y;

}
