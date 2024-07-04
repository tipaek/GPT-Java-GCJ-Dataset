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
import java.awt.Point;
 
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
        		int x=in.nextInt();
        		int y=in.nextInt();
        		String s=in.next();
        		boolean works=false;
        		int min=0;
        		for(int i=0;i<=s.length();i++) {
        			if(i>=Math.abs(x)+Math.abs(y)) {
        				works=true;
        				min=i;
        				break;
        			}
        			if(i!=s.length()) {
        				x+=fx(s.charAt(i));
            			y+=fy(s.charAt(i));
        			}
        		}
        		if(works) {
        			out.println("Case #"+(z+1)+": "+min);
        		}
        		else {
        			out.println("Case #"+(z+1)+": "+"IMPOSSIBLE");
        		}
        		
        	}
        }

		private int fy(char charAt) {
			if(charAt=='N')return 1;
			if(charAt=='S')return -1;
			return 0;
		}

		private int fx(char charAt) {
			if(charAt=='E')return 1;
			if(charAt=='W')return -1;
			return 0;
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
        public int[] nextIntArr(int n) {
        	int arr[]=new int[n];
        	for(int i=0;i<n;i++) {
        		arr[i]=this.nextInt();
        	}
        	return arr;
        }
 
    }
}
        