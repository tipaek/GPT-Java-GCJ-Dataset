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

		    if(p.x == -1 && p.y ==-1) {
		        if((!queue.isEmpty()) )
		        {
		            if(queue.peekLast().x!=-1 )
		            {
		                queue.add(new Point(-1,-1));
		                if(lastRoundTotal == total) {
		                        sum+=total;
		                lastRoundTotal = total;
		                total=0;
		                rounds++;
		                    break;
		                }
		                
		            }
		            
		        }
		                sum+=total;
		                lastRoundTotal = total;
		                total=0;
		                rounds++;
		        continue;
		    
		    }
		    
		    
		    
		    total += matrix[p.x][p.y];
		    int count =0;
		    int totalr=0;
		    if(leftExist(p.x,p.y, rows, cols, matrix)!=0) {
		        count++;
		        totalr+=leftExist(p.x,p.y, rows, cols, matrix);
		    }
		    
		    if(rightExist(p.x,p.y, rows, cols, matrix)!=0) {
		        count++;
		        totalr+=rightExist(p.x,p.y, rows, cols, matrix);
		    }
		    if(topExist(p.x,p.y, rows,cols, matrix)!=0) {
		        count++;
		        totalr+=topExist(p.x,p.y, rows, cols, matrix);
		    }
		    if(bottomExist(p.x,p.y, rows, cols, matrix)!=0) {
		        count++;
		        totalr+=bottomExist(p.x,p.y, rows, cols, matrix);
		    }
		    if(count ==0)
		    count =1;
                double average =(double) (totalr)/count;

                if(average<=matrix[p.x][p.y])
                {
                    queue.add(new Point(p.x,p.y));
                }
                else 
                {
                    matrix[p.x][p.y] = 0;
                }
            
            
        System.out.println("Case #"+ll+" "+sum);
		}

		
	}
  }
  public static int leftExist(int x,int y, int rows,int cols, int matrix[][]){
    
    int left = y-1;
    
    while(y-1>=0) {
        if(matrix[x][y-1]>0) {
            return matrix[x][y-1]; 
        }
        y--;
    }
    
    return 0;
    
  }
  public static int rightExist(int x, int y,int rows,int cols,int matrix[][]){
     
    int right = y+1;
    
    while(y+1<cols) {
        if(matrix[x][y+1]>0) {
            return matrix[x][y+1];
        }
    y++;

    }
    
    return 0;
  }public static int topExist(int x,int y, int rows,int cols, int matrix[][]){
  
    int top = x-1;
    
    while(x-1>=0) {
        if(matrix[x-1][y]>0) {
            return matrix[x-1][y]; 
        }
        x--;
    }
    
    return 0;
  
  }public static int bottomExist(int x, int y, int rows,int cols, int matrix[][]){
  
    int bottom = x+1;
    
    while(x+1<rows) {
        if(matrix[x+1][y]>0) {
            return matrix[x+1][y]; 
        }
        x++;
    }
    
    return 0;
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
