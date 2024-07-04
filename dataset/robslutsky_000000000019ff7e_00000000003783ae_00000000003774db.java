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
        static int minmoves = 0;
        static String ans = "";
        static int stop = 0;
        public static void main(String[] args) throws IOException {
            FastScanner fs=new FastScanner(System.in);
            int k = fs.nextInt();
            for(int cas=1;cas<=k;cas++) {
            	minmoves = Integer.MAX_VALUE;
            	ans = "";
            	String s1 = fs.next();
            	String s2 = fs.next();
            	stop = Math.max(s1.length(), s2.length());
            	ds(s1, s2, 0, true, 0);
            	System.out.println(ans);
            }
        } 
        public static void ds(String a, String b, int pos, boolean at, int moves) {

        	if(moves > stop) {
        		return;
        	}
        	if(pos == a.length() && pos == b.length()) {
        		if(moves < minmoves) {
        			ans = a;
        			minmoves = moves;
        		}
        		return;
        	}
        	if(pos > a.length() &&pos > b.length()) {
        		return;
        	}
        	if(pos<a.length() && pos < b.length()&&a.charAt(pos) == b.charAt(pos)) {
        		ds(a,b,pos+1,at,moves);
        	}
        	else {
        		if(at) {
        			if(pos < b.length()) {
        				char c = b.charAt(pos);
//        				System.out.println(pos+" "+a+" "+a.substring(pos+1));
        				if(pos + 1 <=a.length())
        					ds(a.substring(0,pos)+c+a.substring(pos+1),b,pos+1,!at, moves + 1);
        				ds(a.substring(0,pos)+c+a.substring(pos),b,pos+1,!at, moves + 1);
        			}
        			if(pos < a.length())
        				ds(a.substring(0,pos)+a.substring(pos+1),b,pos,!at, moves + 1);
        		}
        		else {
        			if(pos < a.length()) {
        				char c = a.charAt(pos);
        				if(pos + 1 <=b.length())
        					ds(a,b.substring(0,pos)+c+b.substring(pos+1),pos+1,!at, moves + 1);
        				ds(a,b.substring(0,pos)+c+b.substring(pos),pos+1,!at, moves + 1);
        			}
        			if(pos<b.length())
        				ds(a,b.substring(0,pos)+b.substring(pos+1),pos,!at, moves + 1);
        		}
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