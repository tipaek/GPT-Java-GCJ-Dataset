import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;
class Solution {
	
	
static class Point
{
	int x;
    int y;
	String str;
	  Point(int x,int y,String str)
	  {
	  this.x = x;
	  this.y = y;
	  this.str = str;
	  }
}


public static String minStep(HashSet<String> set,String str,Point source, Point dest)
{
	Queue<Point> q = new LinkedList<>();
    q.add(source);
	
	
	
    // WESN
	char [] arr = {'W','E','S','N'};
    int [] row = {-1,1,0,0};
    int [] col = {0,0,-1,1};
    
    if(source.x == dest.x && source.y == dest.y)
    	return str;
    
	
    int pow=1;
    while(q.size()>0) 
    {
    	int size = q.size(); //2
      
        while(size-->0)
        {
			 Point s = q.poll();   // (2,1)
            
             if(s.x == dest.x && s.y == dest.y)
             {
             	return s.str;
             }
			 
			 
            
            set.add(s.x+"#"+s.y);
        		
		   for(int i=0;i<4;i++)
           {
           		//int pow = (int)Math.pow(2,count);
				int r = row[i]*pow + s.x;
                int c = col[i]*pow + s.y;
			    
				 
             
              if(!set.contains(r+"#"+c))
              {
              	q.add(new Point(r,c,s.str+arr[i]));
              }
           }
        }

        pow *=2;
    }
	  
	return null;
    
}
	
    public static void main(String args[] ) throws Exception {
        
		//BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner scan = new Scanner(System.in);
        
		int t = scan.nextInt();
		
		for(int test=1;test<=t;test++)
		{
			int x = scan.nextInt();
			int y = scan.nextInt();
			
			Point source = new Point(0,0,"");
			
			Point dest = new Point(x,y,"");
			
			HashSet<String> set = new HashSet<>();
			
			if((Math.abs(x)%2 ==1  && Math.abs(y)%2 ==1)  || Math.abs(x) == Math.abs(y))
			{
				System.out.println("Case #"+test+": IMPOSSIBLE");			
			}
			else
			{
				String dist = minStep(set,"",source,dest);
				System.out.println("Case #"+test+": "+dist);			
			}
			
		}
		
		
		
		
    }
}
