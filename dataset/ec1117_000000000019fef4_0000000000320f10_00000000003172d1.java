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
        		int n=in.nextInt();
        		int d=in.nextInt();
        		Long arr[]=new Long[n];
        		for(int i=0;i<n;i++) {
        			arr[i]=in.nextLong();
        		}
        		Arrays.sort(arr);
        		if(d==2) {
        			boolean works=false;
        			for(int i=0;i<n;i++) {
        				for(int j=i+1;j<n;j++) {
        					if(arr[i]==arr[j]) {
        						works=true;
        						break;
        					}
        				}
        				if(works)break;
        			}
        			if(works) {
        				out.println("Case #"+(z+1)+": "+0);
        			}
        			else {
        				out.println("Case #"+(z+1)+": "+1);
        			}
        		}
        		if(d==3) {
        			int prev=0;
        			int point=0;
        			int max=1;
        			boolean zworks=false;
        			while(point<n) {
        				if(arr[point]==arr[prev]) {
        					point++;
        				}
        				else {
        					if(point-prev==2 && prev!=0) {
        						zworks=true;
        					}
        					max=Math.max(max, point-prev);
        					prev=point;
        				}
        			}
        			for(int i=0;i<n;i++) {
        				for(int j=i+1;j<n;j++) {
        					if(arr[i]*2==arr[j]) {
        						zworks=true;
        						break;
        					}
        				}
        				if(zworks)break;
        			}
        			if(max>=3) {
        				out.println("Case #"+(z+1)+": "+0);
        			}
        			else if(zworks) {
        				out.println("Case #"+(z+1)+": "+1);
        			}
        			else {
        				out.println("Case #"+(z+1)+": "+2);
        			}
        		}
//        		int min=d-1;
//        		for(int i=0;i<n;i++) {
//        			int same=0;
//        			long sum=0;
//        			for(int j=i+1;j<n;j++) {
//        				if(arr[j]==arr[i])same++;
//        				sum+=arr[j]/arr[i];
//        			}
//        			min=Math.min(min,)
//        		}
//        		out.println("Case #"+(z+1)+": "	);
        	}
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
        