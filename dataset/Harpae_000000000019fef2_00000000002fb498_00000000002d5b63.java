import java.io.*;
import java.util.*;

public class Solution {
	static PrintWriter out = new PrintWriter(System.out);
	static FS in = new FS();
	
	static long MINVAL = -1_000_000_000L;
	static long MAXVAL = 1_000_000_000L;
	static long RANGE = 2_000_000_000;
	
	static long A, B;
	
	static final boolean debug = false;
	static VecL inpCenter = new VecL(123124,-12412321);
	static long inpR = 888_888_888;
	
	public static void main(String[] args) {
		int T = in.nextInt();
		A = in.nextLong();
		B = in.nextLong();
		for(int runs = 1; runs <= T; runs++) {
			boolean found = false;
			ArrayList<VecL> edgePoints = new ArrayList<VecL>();
			
			long step = RANGE/5;
			long y = MINVAL;
			
			for(int iter = 0; iter < 4; iter++) {
				y += step;
				long step2 = RANGE/4;
				long x = MINVAL;
				
				VecL pnt = null;
				
				for(int iter2 = 0; iter2 < 3; iter2++) {
					x += step2;
				
					char c = query(x, y);
					if(c == 'C') { found = true; break;}
					else if(c == 'H') { pnt = new VecL(x, y); break;}
				}
				if(found) break;
				
				
				VecL leftMost = new VecL(pnt.x, pnt.y);
				VecL rightMost = new VecL(pnt.x, pnt.y);
				// Now have point for binary search reference.
				for(int k = 30; k >= 0; k--) {
					if(leftMost.x - (1L<<k) >= MINVAL) {
						char c = query(leftMost.x - (1L<<k), leftMost.y);
						if(c == 'C') { found = true; break;}
						else if(c == 'H') { leftMost.x -= (1L<<k);}
					}
					if(rightMost.x + (1L<<k) <= MAXVAL) {
						char c = query(rightMost.x + (1L<<k), rightMost.y);
						if(c == 'C') { found = true; break;}
						else if(c == 'H') { rightMost.x += (1L<<k);}
					}		
				}
				if(found) break;
				edgePoints.add(leftMost);
				edgePoints.add(rightMost);
			}
			if(found) continue;
			
			// Now do min enc circle
			Vec vs[] = new Vec[edgePoints.size()];
			for(int i = 0; i < edgePoints.size(); i++) vs[i] = edgePoints.get(i).toD();
			
			Circle circ = minEnclosingCircle(vs);
			
			long cx = Math.round(circ.c.x);
			long cy = Math.round(circ.c.y);
			
			for(long xx = cx - 2; xx <= cx+2; xx++) {
				for(long yy = cy - 2; yy <= cy+2; yy++) {
					char c = query(xx, yy);
					if(c == 'C') { found = true; break;}
				}
				if(found) break;
			}
			if(!found) throw null;
			
		}
		
	
		out.close();
	}
	
	static char query(long x, long y) {
		if(debug) {
			if(x == inpCenter.x && y == inpCenter.y) return 'C';
			long dx = (x-inpCenter.x), dy = (y - inpCenter.y);
			return (dx*dx + dy*dy) <= inpR*inpR ? 'H' : 'M';
		}
		else {
			out.println(x+" "+y);
			out.flush();
			return in.next().charAt(0);
		}
	}
	
	static class VecL {
		long x, y;
		public VecL(long xx, long yy) {
			x=xx;
			y=yy;
		}
		public Vec toD() {
			return new Vec(x, y);
		}
		@Override
		public String toString() {
			return "("+x+", "+y+")";
		}
	}
	
	
	//returns the minimum enclosing circle
	public static Circle minEnclosingCircle(Vec[] toProcess) {
		ArrayList<Vec> temp=new ArrayList<>(Arrays.asList(toProcess));
		Collections.shuffle(temp);
		Vec[] a=temp.toArray(new Vec[0]);
		return minEnclosingCircle(a, 0, null, null, null);
	}
	

	static class Vec {
		static final double EPS=1e-6;
		double x, y;
		public Vec(double x, double y) {this.x=x;this.y=y;}
		public Vec add(Vec o) {return new Vec(x+o.x, y+o.y);}
		public Vec sub(Vec o) {return new Vec(x-o.x, y-o.y);}
		public Vec scale(double s) {return new Vec(x*s, y*s);}
		public double dot(Vec o) {return x*o.x+y*o.y;}
		public double cross(Vec o) {return x*o.y-y*o.x;}
		public double mag2() {return dot(this);}
		public double mag() {return Math.sqrt(mag2());}
		public Vec unit() {return scale(1/mag());}
		public Vec rot90() {return new Vec(-y, x);}
		public Vec rot270() {return new Vec(y, -x);}
		
		public Vec rotate(double theta) {
			double PI=Math.PI;
			double newX=x*Math.cos(theta)+y*Math.cos(PI/2+theta);
			double newY=x*Math.sin(theta)+y*Math.sin(PI/2+theta);
			return new Vec(newX, newY);
		}
		
		//angle between 0 and 2PI
		public double angle() {
			return (Math.atan2(y, x)+2*Math.PI)%(2*Math.PI);
		}
		
		static boolean eq(double a, double b) {return Math.abs(a-b)<EPS;}
		static boolean leq(double a, double b) {return a-EPS<b;}
		static boolean geq(double a, double b) {return a+EPS>b;}
		
		public boolean equals(Object oo) {
			Vec o=(Vec)oo;
			return eq(x, o.x)&&eq(y, o.y);
		}
	}
	
	//circle defined by a, b, and c, assumes all points are unique
	//if a is null, returns a circle at (1<<31, 0) r=0
	//if b is null, it returns a circle centered at a, r=0
	//if c is null, it returns the circle defined by a and b
	//
	//O(n)
	public static Circle enclosing(Vec a, Vec b, Vec c) {
		if (a==null) return new Circle(new Vec(Integer.MAX_VALUE, 0), 0);
		if (b==null) return new Circle(a, 0);
		if (c==null) return new Circle(a.add(b).scale(.5), a.sub(b).mag()/2);
		Vec abDir=b.sub(a), bcDir=c.sub(b);
		Vec abMid=a.add(b).scale(.5), bcMid=b.add(c).scale(.5);
		Seg abSeg=new Seg(abMid, abMid.add(abDir.rot90())), bcSeg=new Seg(bcMid, bcMid.add(bcDir.rot90()));
		Vec center=abSeg.lineIntersect(bcSeg);
		return new Circle(center, center.sub(a).mag());
	}
	
	
	private static Circle minEnclosingCircle(Vec[] toProcess, int toProcessIndex, Vec b1, Vec b2, Vec b3) {
		if (toProcessIndex==toProcess.length||b3!=null)
			return enclosing(b1, b2, b3);
		Vec p=toProcess[toProcessIndex];
		Circle smaller=minEnclosingCircle(toProcess, toProcessIndex+1, b1, b2, b3);
		if (smaller.contains(p))
			return smaller;
		return minEnclosingCircle(toProcess, toProcessIndex+1, p, b1, b2);
	}
	
	static class Circle {
		Vec c;
		double r;
		
		public Circle(Vec c, double r) {
			this.c=c;
			this.r=r;
		}
		
		public boolean contains(Vec v) { 
			return c.sub(v).mag2()-Vec.EPS*Vec.EPS<=r*r;
		}
		
		//when standing at this circle, returns right tangent, then left tangent
		public Vec[] intersect(Circle o) {
			if (c.equals(o.c)) return null;
			Vec dir=o.c.sub(c);
			double d2=dir.mag2(), d=Math.sqrt(d2);
			if (r+o.r<d||r+d<o.r||o.r+d<r)
				return null;
			if (Vec.eq(r+o.r, d)||Vec.eq(o.r+d, r))
				return new Vec[] {c.add(dir.scale(r/d))};
			if (Vec.eq(r+d, o.r))
				return new Vec[] {c.sub(dir.scale(r/d))};//.sub()!!
			
			double d1=(r*r+d2-o.r*o.r)/(2*d);
			double h=Math.sqrt(r*r-d1*d1);
			Vec unitDir=dir.unit();
			Vec rInt=c.add(unitDir.scale(d1).add(unitDir.rot270().scale(h)));
			Vec lInt=c.add(unitDir.scale(d1).add(unitDir.rot90().scale(h)));
			return new Vec[] {rInt, lInt};
		}
		
		public double intersectionArea(Circle o) {
			double d=o.c.sub(c).mag();
			if (r+o.r<d) return 0;
			double minR=Math.min(r, o.r), maxR=Math.max(r, o.r), pi=Math.PI;
			if (Vec.leq(d+minR, maxR)) return pi*minR*minR;
			
			double theta1=2*Math.acos((r*r+d*d-o.r*o.r)/(2*r*d));
			double theta2=2*Math.acos((o.r*o.r+d*d-r*r)/(2*o.r*d));
			double part1Area=theta1/2*r*r;
			double part2Area=theta2/2*o.r*o.r;
			
			double tri1=r*r*Math.sin(theta1)/2;
			double tri2=o.r*o.r*Math.sin(theta2)/2;
			return part1Area+part2Area-tri1-tri2;
		}
		
		//returns right tangent, then left tangent from perspective of the point
		public Vec[] getTangentPoints(Vec p) {
			if (contains(p))
				return null;
			double d2=c.sub(p).mag2();
			return new Circle(p, Math.sqrt(d2-r*r)).intersect(this);
		}
		
		//line going from my left to his right, then my right to his left
		//lines go from me to him
		public Seg[] internalTangentLines(Circle o) {
			Vec[] tangentPoints=new Circle(c, r+o.r).getTangentPoints(o.c);
			Vec offset1=tangentPoints[0].sub(o.c).rot90().unit().scale(o.r);
			Vec offset2=tangentPoints[1].sub(o.c).rot270().unit().scale(o.r);
			return new Seg[] {new Seg(tangentPoints[0].add(offset1), o.c.add(offset1)),
							  new Seg(tangentPoints[1].add(offset2), o.c.add(offset2))};
		}
		
		//right external tangent, then left external tangent, from my perspective
		//lines go from me to him
		public Seg[] externalTangentLines(Circle o) {
			if (o.r>r) {
				Seg[] oAnswer=o.externalTangentLines(this);
				return new Seg[] {new Seg(oAnswer[1].to, oAnswer[1].from), new Seg(oAnswer[0].to, oAnswer[0].from)};
			}
			Vec[] tangentPoints=new Circle(c, r-o.r).getTangentPoints(o.c);
			Vec offset1=tangentPoints[0].sub(o.c).rot270().unit().scale(o.r);
			Vec offset2=tangentPoints[1].sub(o.c).rot90().unit().scale(o.r);
			return new Seg[] {new Seg(tangentPoints[1].add(offset2), o.c.add(offset2)),
							  new Seg(tangentPoints[0].add(offset1), o.c.add(offset1))};
		}
		
		//line (not line segment)-circle intersection in the order of line.dir
		public Vec[] intersectLine(Seg line) {
			Vec closest=line.projectToLine(c);
			double d2=closest.sub(c).mag2();
			if (d2>r*r) return null;
			double l=Math.sqrt(r*r-d2);
			if (Vec.eq(l, 0)) return new Vec[] {closest};
			Vec lVec=line.dir.unit().scale(l);
			return new Vec[] {closest.sub(lVec), closest.add(lVec)};
		}
		
		//line segment-circle intersection
		public Vec[] intersectSeg(Seg seg) {
			Vec[] lineIntersections=intersectLine(seg);
			if (lineIntersections==null) return null;
			ArrayList<Vec> contained=new ArrayList<>();
			for (Vec v:lineIntersections)
				if (seg.containsPoint(v))
					contained.add(v);
			if (contained.isEmpty()) return null;
			return contained.toArray(new Vec[contained.size()]);
		}
		
		
	}
	
	static class Seg {
		Vec from, to, dir;
		
		public Seg(Vec from, Vec to) {
			this.from=from;
			this.to=to;
			dir=to.sub(from);
		}
		
		//line-line intersection
		public Vec lineIntersect(Seg o) {
			double det=o.dir.x*dir.y-dir.x*o.dir.y;
			if (Vec.eq(det, 0)) return null;
			double dist=(o.dir.x*(o.from.y-from.y)-
					o.dir.y*(o.from.x-from.x))/det;
			return from.add(dir.scale(dist));
		}
		
		public boolean containsPoint(Vec o) {
			double distFromLine=dir.unit().cross(o.sub(from));
			if (!Vec.eq(distFromLine, 0)) return false;
			return Vec.eq(dir.mag(), from.sub(o).mag()+to.sub(o).mag());
		}
		
		//seg-seg intersection
		public Vec segIntersection(Seg o) {
			Vec intersect=lineIntersect(o);
			return containsPoint(intersect)&&o.containsPoint(intersect)?intersect:null;
		}
		
		//returns 1 if above, 0 if on, -1 if below
		public int side(Vec o) {
			Vec oDir=o.sub(from);
			double distFromLine=dir.unit().cross(oDir);
			if (Vec.eq(distFromLine, 0))
				return 0;
			return (int)Math.signum(distFromLine);
		}
		
		public boolean intersects(Seg o) {
			return side(o.from)!=side(o.to) && o.side(from)!=o.side(to);
		}
		
		public Vec getClosestTo(Vec o) {
			double percentThere=o.sub(from).dot(dir)/dir.mag2();
			return from.add(dir.scale(Math.max(0, Math.min(1, percentThere))));
		}
		
		public Vec projectToLine(Vec o) {
			return dir.scale(o.sub(from).dot(dir)/dir.mag2()).add(from);
		}
		
	}
	
	
	static class FS{
		BufferedReader br;
		StringTokenizer st;
		public FS() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {st = new StringTokenizer(br.readLine());}
				catch(Exception e) { throw null;}
			}
			return st.nextToken();
		}
		int nextInt() { return Integer.parseInt(next());}
		double nextDouble() { return Double.parseDouble(next());}
		long nextLong() { return Long.parseLong(next());}
		int[] NIA(int n) {
			int r[] = new int[n];
			for(int i = 0; i < n; i++) r[i] = nextInt();
			return r;
		}
		long[] NLA(int n) {
			long r[] = new long[n];
			for(int i = 0; i < n; i++) r[i] = nextLong();
			return r;
		}
		char[][] grid(int r, int c){
			char res[][] = new char[r][c];
			for(int i = 0; i < r; i++) {
				char l[] = next().toCharArray();
				for(int j = 0; j < c; j++) {
					res[i][j] = l[j];
				}
			}
			return res;
		}
	}
	
}
