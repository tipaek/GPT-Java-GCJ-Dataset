
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.System;
import java.util.StringTokenizer;

//Nastya and Rice https://codeforces.com/contest/1341/problem/0

public class Solution {

	static void solve() throws Exception {
		log("/////////////////////////////");
		int x=scanInt();
		int y=scanInt();
		String m=scanString();
		log(m);
		int time=m.length();
		int fx=x,fy=y;
		int minx=x,miny=y;
		int mindist=x+y;
		int mindisttime=Integer.MAX_VALUE;
		int minTime=Integer.MAX_VALUE;
		int currtime=0;
		for(int i=0;i<m.length();i++) {
			log("loooooooooooooooooooooooooooop");
			currtime++;
			if(m.charAt(i)=='N') {
				fy++;
			} else if(m.charAt(i)=='E') {
				fx++;
			} else if(m.charAt(i)=='W') {
				fx--;
			} else if(m.charAt(i)=='S') {
				fy--;
			}
			log("dir:"+m.charAt(i));
			log("fx:"+fx);
			log("fx:"+fy);
			int currdist=(Math.abs(fx)+Math.abs(fy));
			log("currtime:"+currtime);
			log("currdist:"+currdist);
			if(mindist>=currdist) {
				mindist=currdist;
				minx=fx;miny=fy;
				mindisttime=i+1;
				if(mindisttime<minTime)
					minTime=mindisttime;
			}
			if(currtime>currdist) {
				log("mintime here");				
				if(currtime<minTime || minTime==1)
					minTime=currtime;
			}
			log("mindisttime:"+mindisttime);
			log("minTime:"+minTime);
		}
		log(mindisttime);
		log(minTime);
		log(minx);
		log(miny);
		if((Math.abs(fx)+Math.abs(fy))>time) {
			printlnCase("IMPOSSIBLE 1");
		} else if(mindisttime==Integer.MAX_VALUE) {
			printlnCase("IMPOSSIBLE 2");
		} else if((Math.abs(minx)+Math.abs(miny))>mindisttime){
			printlnCase("IMPOSSIBLE 3");
		} else if(minTime!=1){
			printlnCase(minTime);
		} else {
			printlnCase(mindisttime);
		}
		
//		printlnCase("");
	}

	static int scanInt() throws IOException {
		return parseInt(scanString());
	}

	static long scanLong() throws IOException {
		return parseLong(scanString());
	}

	static String scanString() throws IOException {
		while (tok == null || !tok.hasMoreTokens()) {
			tok = new StringTokenizer(in.readLine());
		}
		return tok.nextToken();
	}

	static void printCase() {
		System.out.print("Case #" + test + ": ");
	}

	static void printlnCase(Object o) {
		System.out.println("Case #" + test + ": "+o);
	}
	
	static void log(Object s) {
		if(log)
			System.out.println("- - -| "+s);
	}

	static BufferedReader in;
	static StringTokenizer tok;
	static int test;
	static boolean log=false;

	public static void main(String[] args) {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			int tests = scanInt();
			for (test = 1; test <= tests; test++) {
				solve();
			}
			in.close();
		} catch (Throwable e) {
			e.printStackTrace();
			exit(1);
		}
	}
}
