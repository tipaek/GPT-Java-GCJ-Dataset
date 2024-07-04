import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int test = 1;
		int A = sc.nextInt();
		int B = sc.nextInt();
		while(T-- > 0) {
			boolean out = docase(sc);
			if(!out) break;
		}
		// :)
	}
	static int max = 1000000000;
	static int[][] queries = {{0,max/2}, {0,-max/2}, {max/2,0}, {-max/2,0}};
	static boolean docase(Scanner sc) {
		int x = 0, y = 0;
		String s;
		for(int[] q: queries) {
			System.out.println(q[0]+" "+q[1]); s = sc.next(); if(s.equals("CENTER")) return true; if(s.equals("WRONG")) return false;
			if(s.equals("HIT")) {
				x = q[0]; y = q[1]; break;
			}
		}
		//bin search for x
		int xleft;
		int a = -max, b = x; //we know b is yes
		System.out.println(a+" "+y); s = sc.next(); if(s.equals("CENTER")) return true; if(s.equals("WRONG")) return false;
		if(s.equals("HIT")) {
			xleft = a;
		}
		else {//a is no
			while(b - a > 1) {
				int c = (a+b)/2;
				System.out.println(c+" "+y); s = sc.next(); if(s.equals("CENTER")) return true; if(s.equals("WRONG")) return false;
				if(s.equals("HIT")) b = c;
				else a = c;
			}
			//a is no, b is yes
			xleft = b;
		}
		int xright;
		a = x; b = max; //we know a is yes
		System.out.println(b+" "+y); s = sc.next(); if(s.equals("CENTER")) return true; if(s.equals("WRONG")) return false;
		if(s.equals("HIT")) {
			xright = b;
		}
		else {//b is no
			while(b - a > 1) {
				int c = (a+b)/2;
				System.out.println(c+" "+y); s = sc.next(); if(s.equals("CENTER")) return true; if(s.equals("WRONG")) return false;
				if(s.equals("HIT")) a = c;
				else b = c;
			}
			xright = a;
		}
		int xres = (xleft + xright) / 2;
		//bin search for y
		int ydown;
		a = -max; b = y; //we know b is yes
		System.out.println(xres+" "+a); s = sc.next(); if(s.equals("CENTER")) return true; if(s.equals("WRONG")) return false;
		if(s.equals("HIT")) {
			ydown = a;
		}
		else {//a is no
			while(b - a > 1) {
				int c = (a+b)/2;
				System.out.println(xres+" "+c); s = sc.next(); if(s.equals("CENTER")) return true; if(s.equals("WRONG")) return false;
				if(s.equals("HIT")) b = c;
				else a = c;
			}
			//a is no, b is yes
			ydown = b;
		}
		int yup;
		a = y; b = max; //we know a is yes
		System.out.println(xres+" "+b); s = sc.next(); if(s.equals("CENTER")) return true; if(s.equals("WRONG")) return false;
		if(s.equals("HIT")) {
			yup = b;
		}
		else {//b is no
			while(b - a > 1) {
				int c = (a+b)/2;
				System.out.println(xres+" "+c); s = sc.next(); if(s.equals("CENTER")) return true; if(s.equals("WRONG")) return false;
				if(s.equals("HIT")) a = c;
				else b = c;
			}//a is yes, b is no
			yup = a;
		}
		int yres = (ydown + yup) / 2;
		System.out.println(xres+" "+yres); s = sc.next(); 
		if(s.equals("CENTER")) return true;
		else return false;
	}

}
