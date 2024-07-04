import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
		static HashMap<BigDecimal, BigDecimal> map = new HashMap<BigDecimal, BigDecimal> ();
		public static void main(String[] args) throws IOException {
			FastScanner fs=new FastScanner(System.in);
			int t=fs.nextInt();
			long startTime = System.nanoTime();
			for(int cas=1; cas<=t;cas++) {
				int c = fs.nextInt();
				int d = fs.nextInt();
				int[] bf = new int[c];
				for(int i = 1;i<c;i++) {
					bf[i] = fs.nextInt();
				}
				Vertex[] v = new Vertex[c];
				for(int i =0;i<c;i++) {
					v[i]=new Vertex(i);
				}
				ArrayList<Edge> eg = new ArrayList<Edge>();
				for(int i = 0;i<d;i++) {
					int s = fs.nextInt();
					int e = fs.nextInt();
					Edge j = new Edge(v[s-1],v[e-1]);
					eg.add(j);
					v[s-1].edges.add(j);
					v[e-1].edges.add(j);
					v[s-1].v.add(v[e-1]);
					v[e-1].v.add(v[s-1]);
				}
				ArrayList<Vertex> at = new ArrayList<Vertex>();
				at.add(v[0]);
				v[0].seen = true;
				int on = 1;
				int levels = 1;
				while(at.size() != c) {
					int newon = on;
					int nowat =(levels)*(levels+1)/2;
					ArrayList<Vertex> atadd = new ArrayList<Vertex>();
					for(Vertex vv: at) {
						for(int vert = 0;vert<vv.v.size();vert++) {
							if(bf[vv.v.get(vert).val] == -1 * on) {
								vv.edges.get(vert).lat = nowat - vv.dist; 
								newon++;
								if(!vv.v.get(vert).seen) {
									atadd.add(vv.v.get(vert));
									vv.v.get(vert).seen = true;
									vv.v.get(vert).dist = nowat;
								}
							}
						}
					}
					levels++;
					on = newon;
					at.addAll(atadd);
				}
				StringBuilder sb = new StringBuilder("Case #"+cas+": ");
				for(int i =0;i<eg.size();i++) {
					sb.append(eg.get(i).lat+" ");
				}
				sb.setLength(sb.length()-1);
				System.out.println(sb);
			}
		}
		
			
		static class FastScanner {
		    BufferedReader br;
		    StringTokenizer st;
		    public FastScanner(InputStream i){
		        br = new BufferedReader(new InputStreamReader(i));
		        st = new StringTokenizer("");
		    }
		    public String next() throws IOException{
		        if(st.hasMoreTokens()) return st.nextToken();
		        else st = new StringTokenizer(br.readLine());
		        return next();
		    }
		    public long nextLong() throws IOException{ return Long.parseLong(next()); }
		    public int nextInt() throws IOException { return Integer.parseInt(next()); }
		    public double nextDouble() throws IOException { return Double.parseDouble(next()); }
		    public String nextLine() throws IOException {
		        if(!st.hasMoreTokens()) 
		            return br.readLine();
		        String ret = st.nextToken();
		        while(st.hasMoreTokens()) 
		            ret += " " + st.nextToken();
		        return ret;
		    }
		}
	}
class Vertex{
public ArrayList<Vertex> v = new ArrayList<Vertex>();
public ArrayList<Edge> edges = new ArrayList<Edge>();
public int val=0;
public int dist = 0;
public boolean seen = false;
public Vertex(int x) {
	val = x;
}
public String toString() {
	return seen + " "+dist;
}
}
class Edge{
public Vertex a,b;
public int lat = 1000000;
public Edge(Vertex a, Vertex b) {
	if(a.val < b.val) {
	this.a=a;
	this.b=b;}
	else {
		this.a=b;
		this.b=a;
	}
}
public String toString() {
	return lat+"";
}
}
