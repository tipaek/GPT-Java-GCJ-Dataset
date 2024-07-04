import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;



public class Solution{
	
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    }
	
	static class Pair
	{
		int x;
		int y;
		String s;
		Pair(int x,int y,String s)
		{
			this.x = x;
			this.y = y;
			this.s = s;
		}
	}
	public static void main(String[] args) 
	{
		OutputStream outputStream = System.out;
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(outputStream);
        
        int t = sc.nextInt();
        int cnt = 0;
        while(t-- > 0)
        {	
        	cnt++;
        	int sx = 0;
        	int sy = 0;
        	
        	int x = sc.nextInt();
        	int y = sc.nextInt();
        	
        	Queue<Pair> q = new LinkedList<>();
        	
        	q.add(new Pair(0,0,""));
        	
        	int z = 100000;
        	int p = 0;int p1 = (int)Math.pow(4,p+1);
        	String ans = "IMPOSSIBLE";
        	outer: while(!q.isEmpty() && z-- > 0)
        	{
        		Pair pr = q.poll();
        		
        		int nx = pr.x;
        		int ny = pr.y;
        		
        		//System.out.println(cnt+" "+nx+" "+ny+" "+pr.s);
        		String sr = "";
        		for(int i = 0; i < 4; i++)
        		{
        			//N
        			if(i == 0)
        			{
        				nx = pr.x + (int)Math.pow(2,p);
        				ny = pr.y;
        				sr = "E";
        				sr = pr.s+sr;
        				if(nx == x && ny == y)
        				{
        					ans = sr;
        					break outer;
        				}
        				q.add(new Pair(nx,ny,sr));
        				p1--;
        			}
        			//S
        			if(i == 1)
        			{
        				nx = pr.x - (int)Math.pow(2,p);
        				ny = pr.y;
        				sr = "W";
        				sr = pr.s+sr;
        				if(nx == x && ny == y)
        				{
        					ans = sr;
        					break outer;
        				}
        				q.add(new Pair(nx,ny,sr));
        				p1--;
        			}
        			//E
        			if(i == 2)
        			{
        				ny = pr.y + (int)Math.pow(2,p);
        				nx = pr.x;
        				sr = "N";
        				sr = pr.s+sr;
        				if(nx == x && ny == y)
        				{
        					ans = sr;
        					break outer;
        				}
        				q.add(new Pair(nx,ny,sr));
        				p1--;
        			}
        			//W
        			if(i == 3)
        			{
        				ny = pr.y - (int)Math.pow(2,p);
        				nx = pr.x;
        				sr = "S";
        				sr = pr.s+sr;
        				if(nx == x && ny == y)
        				{
        					ans = sr;
        					break outer;
        				}
        				q.add(new Pair(nx,ny,sr));
        				p1--;
        			}
        		}
        		
        		if(p1 == 0)
        		{
        			p += 1;
        			p1 = (int)Math.pow(4,p+1);
        		}
        		
        	}
        	
        	out.println("Case #"+cnt+": "+ans);
        }
        out.close();
	}

}
