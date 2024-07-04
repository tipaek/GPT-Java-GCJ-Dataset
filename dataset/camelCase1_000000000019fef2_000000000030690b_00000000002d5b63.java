import java.util.*;
import java.io.*;
public class Solution {

	static BufferedReader br;
	static StringTokenizer tokenizer;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = nextInt();
		int x = 1;
		outer:
		while(t --> 0) {
			x++;
			int[] arr = new int[3];
			int a = nextInt();
			int b = nextInt();
			int l = -1000000000;
			int r = 0;
			int m = (l + r) / 2;
			while(l < r) {
				System.out.println(m + " " + 0);
				System.out.flush();
				String s = next();
				if(s.equals("HIT")) {
					r = m;
				} else if(s.equals("CENTER")) {
					continue outer;
				} else {
					l = m + 1;
				}
				m = (l + r) / 2;
			}
			arr[0] = l;
			l = 0;
			r = 1000000000;
			m = (l + r) /2;
			while(l < r) {
				System.out.println(m + " " + 0);
				System.out.flush();
				String s = next();
				if(s.equals("HIT")) {
					l = m;
				} else if(s.equals("CENTER")) {
					continue outer;
				} else {
					r = m - 1;
				}
				m = (l + r) / 2;
			}
			arr[1] = l;
			System.out.println("0 -1");
			System.out.flush();
			String str = next();
			boolean bot = true;
			if(str.equals("HIT")) {
				l = -1000000000; r = 0;
			} else if(str.equals("CENTER")) continue outer;
			else {
				l = 0; r = 1000000000; bot = false;
			}
			while(l < r) {
				System.out.println(0 + " " + m);
				System.out.flush();
				String s = next();
				if(s.equals("HIT")) {
					if(bot) r = m;
					else l = m;
				} else if(s.equals("CENTER")) {
					continue outer;
				} else {
					if(bot) l = m + 1;
					else r = m - 1;
				}
				m = (l + r) / 2;
			}
			arr[2] = l;
			System.out.println();
			Circle c = CircleThree.circleFromPoints(new Point(arr[0], 0), new Point(arr[1], 0), new Point(arr[2], 0));
			System.out.println((int) c.center.x + " " + (int) c.center.y);
			if(!next().equals("CENTER")) return;
		}
	}

	public static String next() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			String line = br.readLine();
			if (line == null)
				throw new IOException();
			tokenizer = new StringTokenizer(line);
		}
		return tokenizer.nextToken();
	}

	public static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	public static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	public static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
}
class CircleThree
{ 
  static final double TOL = 0.0000001;

  public static Circle circleFromPoints(final Point p1, final Point p2, final Point p3)
  {
    final double offset = Math.pow(p2.x,2) + Math.pow(p2.y,2);
    final double bc =   ( Math.pow(p1.x,2) + Math.pow(p1.y,2) - offset )/2.0;
    final double cd =   (offset - Math.pow(p3.x, 2) - Math.pow(p3.y, 2))/2.0;
    final double det =  (p1.x - p2.x) * (p2.y - p3.y) - (p2.x - p3.x)* (p1.y - p2.y); 

    if (Math.abs(det) < TOL) { throw new IllegalArgumentException("Yeah, lazy."); }

    final double idet = 1/det;

    final double centerx =  (bc * (p2.y - p3.y) - cd * (p1.y - p2.y)) * idet;
    final double centery =  (cd * (p1.x - p2.x) - bc * (p2.x - p3.x)) * idet;
    final double radius = 
       Math.sqrt( Math.pow(p2.x - centerx,2) + Math.pow(p2.y-centery,2));

    return new Circle(new Point(centerx,centery),radius);
  }


}
 class Circle
{
  final Point center;
  final double radius;
  public Circle(Point center, double radius)
  {
    this.center = center; this.radius = radius;
  }
  @Override 
  public String toString()
  {
    return new StringBuilder().append("Center= ").append(center).append(", r=").append(radius).toString();
  }
}

 class Point
{
  final double x,y;

  public Point(double x, double y)
  {
    this.x = x; this.y = y;
  }
  @Override
  public String toString()
  {
    return "("+x+","+y+")";
  }
}
