import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Vector;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.io.InputStream;
import java.util.HashSet;
import java.util.HashMap;
import java.util.TreeSet;
 
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Autocompletion solver = new Autocompletion();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class Autocompletion {
        
        public void solve(int testNumber, InputReader in, PrintWriter out) {
        	int t=in.nextInt();
        	for(int z=0;z<t;z++) {
        		int u=in.nextInt();
        		HashSet<Character> seen=new HashSet<Character>();
        		HashMap<Character,Integer> ran=new HashMap<Character,Integer>();
        		for(int i=0;i<10000;i++) {
        			long q=in.nextLong();
        			String r=in.next();
        			for(int j=0;j<r.length();j++) {
        				seen.add(r.charAt(j));
        			}
        			if(q==-1) {
        				for(int j=0;j<r.length();j++) {
        					if(!ran.containsKey(r.charAt(j))) {
        						ran.put(r.charAt(j), 9);
        					}
        				}
        			}
        			else {
//        				System.out.println(q+" "+digits(q));
        				if(digits(q)==r.length()) {
        					if(ran.containsKey(r.charAt(0))) {
        						ran.put(r.charAt(0), Math.min(Integer.parseInt(Long.toString(q).substring(0, 1)), ran.get(r.charAt(0))));
        					}
        					else {
        						ran.put(r.charAt(0), Integer.parseInt(Long.toString(q).substring(0, 1)));
        					}
        				}
        			}
        		}
        		StringBuilder sb=new StringBuilder();
        		for(int i=1;i<10;i++) {
        			for(Character a:ran.keySet()) {
//        				System.out.println(a+" "+ran.get(a));
        				if(ran.get(a)==i) {
        					seen.remove(a);
        					sb.append(a);
        				}
        			}
        		}
        		String ret=seen.toArray()[0]+sb.toString();
        		out.println("Case #"+(z+1)+": "+ret);
        	}
        }

		private int digits(long q) {
			return (int) Math.log10(q)+1;
		}
        
    }
    static class Cont{
    	char l1;
    	int a;
    	char l2;
    	int b;
    	Cont(char c,int d,char e,int f){
    		l1=c;
    		a=d;
    		l2=e;
    		b=f;
    	}
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
 
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
 
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
 
        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
        	return Long.parseLong(next());
        }
 
    }
}
        