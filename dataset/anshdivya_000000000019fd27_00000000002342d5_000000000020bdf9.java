import java.util.*;
import java.lang.*;
import java.io.*;
public class Solution {

	public static class Point {
		int pos, id;
		boolean isStr;
		
		Point(int id, int pos, boolean type) {
			this.id = id;
			this.pos = pos;
			this.isStr = type;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FastReader s = new FastReader();
		int t = s.nextInt();

		for(int z = 1;z <= t; z++) {
			int n = s.nextInt();
			Point[] p = new Point[2*n];
			
			for(int i=0;i<n;i++) {
				int x = s.nextInt();
				int y = s.nextInt();
				
				p[i] = new Point(i, x, true);
				p[i+n] = new Point(i, y, false);
			}
			
			char[] doer = new char[n];
			
			int[] al_id = new int[2];
			
			al_id[0] = al_id[1] = -1;
			Arrays.sort(p, new myc());
			int count = 0;
			
			boolean possible = true;
			for(int i=0;i<2*n;i++) {
				Point pi = p[i];
				
				if(pi.isStr) {
					if(count == 2) {
						possible = false;
						break;
					}
					else {
						count++;
						int free = 0;
						if(al_id[0] != -1)
							free = 1;
						
						al_id[free] = pi.id;
						
						if(free == 0)
							doer[pi.id] = 'C';
						else
							doer[pi.id] = 'J';
					}
				}
				
				else {
					count--;
					int used = 0;
					
					if(al_id[0] != pi.id)
						used = 1;
					
					al_id[used] = -1;
				}
			}
			
			if(!possible) {
				System.out.println("Case "+"#"+z+": IMPOSSIBLE");
			}
			
			else {
				System.out.print("Case #"+z+": ");
				
				for(int i=0;i<n;i++)
					System.out.print(doer[i]);
				System.out.println();
			}
		}
	}
	
	public static class myc implements Comparator<Point> {
		public int compare(Point p1, Point p2) {
			if(p1.pos != p2.pos)
				return p1.pos - p2.pos;
			
			else {
				if(p1.isStr)
					return 1;
				else
					return -1;
			}
		}
	}

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
}
