import java.io.*;
import java.util.*;

import org.xml.sax.HandlerBase;
 
public class Solution {
    
 
    private void solve() throws Exception {
        int T = nextInt();
        for(int tt = 1; tt <= T; tt++) {
            long X = nextLong();
            long Y = nextLong();
            String res = null;
            for(int i = 1; i <= 8; i++) {
                for(int j = 0; j < (1<<(2*i)); j++) {
                    int jj = j;
                    int x = 0;
                    int y = 0;
                    long pow = 1L;
                    String cur = "";
                    for(int k = 0; k < 2*i; k+=2) {
                        if(jj%4 == 0) {
                            x += pow;
                            cur += "E";
                        } else if(jj%4 == 1) {
                            x -= pow;
                            cur += "W";
                        } else if(jj%4 == 2) {
                            y += pow;
                            cur += "N";
                        } else {
                            y -= pow;
                            cur += "S";
                        }
                        pow *= 2L;                        
                        jj/=4;
                    }
                    if(x == X && y == Y) {
                        res = cur;
                        break;
                    }
                }
                if(res != null) break;
            }
            System.out.println("Case #" + tt + ": " + (res==null?"IMPOSSIBLE":res));
        }
    }
    
    
    
    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            public void run() {
                new Solution().run();
            }
        }, "1", 1 << 27).start();
    }

    private BufferedReader in;
    private PrintWriter out;
    private StringTokenizer tokenizer;

    public void run() {
        try {
            //in = new BufferedReader(new FileReader("fossil_fuels.txt"));
            in = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
            //out = new PrintWriter(new File("outputPQ.txt"));
            out = new PrintWriter(System.out);
            solve();
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    private float nextFloat() throws IOException {
        return Float.parseFloat(nextToken());
    }

    private String nextLine() throws IOException {
        return new String(in.readLine());
    }

    private String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(in.readLine());
        }
        return tokenizer.nextToken();
    }
 
}


class Point 
{ 
    double x; 
    double y; 
  
        public Point(double x, double y)  
        { 
            this.x = x; 
            this.y = y; 
        } 
      
}; 

class GFG  
{ 
  
  
// Given three colinear points p, q, r, the function checks if 
// point q lies on line segment 'pr' 
static boolean onSegment(Point p, Point q, Point r) 
{ 
    if (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) && 
        q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y)) 
    return true; 
  
    return false; 
} 
  
// To find orientation of ordered triplet (p, q, r). 
// The function returns following values 
// 0 --> p, q and r are colinear 
// 1 --> Clockwise 
// 2 --> Counterclockwise 
static int orientation(Point p, Point q, Point r) 
{ 
    // See https://www.geeksforgeeks.org/orientation-3-ordered-points/ 
    // for details of below formula. 
    double val = (q.y - p.y) * (r.x - q.x) - 
            (q.x - p.x) * (r.y - q.y); 
  
    if (Math.abs(val) <= 1e-9) return 0; // colinear 
  
    return (val > 0)? 1: 2; // clock or counterclock wise 
} 
  
// The main function that returns true if line segment 'p1q1' 
// and 'p2q2' intersect. 
static boolean doIntersect(Point p1, Point q1, Point p2, Point q2) 
{ 
    // Find the four orientations needed for general and 
    // special cases 
    int o1 = orientation(p1, q1, p2); 
    int o2 = orientation(p1, q1, q2); 
    int o3 = orientation(p2, q2, p1); 
    int o4 = orientation(p2, q2, q1); 
  
    // General case 
    if (o1 != o2 && o3 != o4) 
        return true; 
  
    // Special Cases 
    // p1, q1 and p2 are colinear and p2 lies on segment p1q1 
    if (o1 == 0 && onSegment(p1, p2, q1)) return true; 
  
    // p1, q1 and q2 are colinear and q2 lies on segment p1q1 
    if (o2 == 0 && onSegment(p1, q2, q1)) return true; 
  
    // p2, q2 and p1 are colinear and p1 lies on segment p2q2 
    if (o3 == 0 && onSegment(p2, p1, q2)) return true; 
  
    // p2, q2 and q1 are colinear and q1 lies on segment p2q2 
    if (o4 == 0 && onSegment(p2, q1, q2)) return true; 
  
    return false; // Doesn't fall in any of the above cases 
} 
  
// Driver code 
public static void main(String[] args)  
{ 
    Point p1 = new Point(1, 1); 
    Point q1 = new Point(10, 1); 
    Point p2 = new Point(1, 2); 
    Point q2 = new Point(10, 2); 
  
    if(doIntersect(p1, q1, p2, q2)) 
        System.out.println("Yes"); 
    else
        System.out.println("No"); 
  
    p1 = new Point(10, 1); q1 = new Point(0, 10); 
    p2 = new Point(0, 0); q2 = new Point(10, 10); 
    if(doIntersect(p1, q1, p2, q2)) 
            System.out.println("Yes"); 
    else
        System.out.println("No"); 
  
    p1 = new Point(-5, -5); q1 = new Point(0, 0); 
    p2 = new Point(1, 1); q2 = new Point(10, 10);; 
    if(doIntersect(p1, q1, p2, q2)) 
        System.out.println("Yes"); 
    else
        System.out.println("No"); 
} 
} 
  