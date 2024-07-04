import java.io.OutputStream;
import java.util.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.LinkedHashSet;
import java.io.Writer;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.io.OutputStreamWriter;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Egor Kulikov (egor@egork.net)
 */
 class Solution {

    public static void main(String[] args) throws FileNotFoundException {

        InputStream inputStream = System.in;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(System.out);
        Solutio solver = new Solutio();
      
        int testCount =Integer.parseInt(in.next());
       // int sum=in.readInt(),te=0;
        long a=Long.parseLong(in.readString());
        long b=Long.parseLong(in.readString());
		// if(sum==1)
		for (int i = 1; i <= testCount; i++) 
		{
			solver.solve(i, in, out,a,b);
			out.flush();
		}
		
        
    }
//**********************SOLVE    HERE     EVERYTHING******************************



    //1 2 3 4 5 
    static class Solutio {
    	static List<String> perm;
    	static int st=-1000000000;
    	static int en=1000000000;
        public void solve(int testNumber, InputReader in, PrintWriter out,long a,long b) throws FileNotFoundException {
          System.out.println(st+" 0");
          String s=in.readString();
          if(s.equals("WRONG"))
    		  System.exit(0);
          long x=st,y=st;
          while(!s.equals("HIT"))
          {
        	  x++;
        	  System.out.println(x+" 0");
        	  s=in.readString();
        	  if(s.equals("WRONG"))
        		  System.exit(0);
        	  
          }
          s="";
          while(!s.equals("HIT"))
          {
        	  
        	  System.out.println("0 "+y);
        	  s=in.readString();
        	  if(s.equals("WRONG"))
        		  System.exit(0);
        	  y++;
        	  
          }
          long cx=x+a;
          long cy=y+a;
          System.out.println(cx+" "+cy);
          
          
          
         
          
          
        
        
        
        }
        static int ispowerof2 ( long num ) 
        { 
            if ((num & (num - 1)) == 0) 
                return 1; 
            return 0;  
        } 
     
        static void printPermutn(String str, String ans) 
        { 
      
            // If string is empty 
            if (str.length() == 0) { 
                perm.add(ans);
                return;
            } 
      
            for (int i = 0; i < str.length(); i++) { 
      
                // ith character of str 
                char ch = str.charAt(i); 
      
                // Rest of the string after excluding  
                // the ith character 
                String ros = str.substring(0, i) +  
                             str.substring(i + 1); 
      
                // Recurvise call 
                printPermutn(ros, ans + ch); 
            }
            
        } 
            
        	
        
        
        
        
        }
    static class StringComparator implements Comparator<String>
    {

		@Override
		public int compare(String arg0, String arg1) {
			
			return arg0.length()-arg1.length();
		}
    	
    	
    }
        
       static ArrayList<Integer> primeSieve(int n) 
        { 
            ArrayList<Integer> li=new ArrayList<Integer>();
            li.add(1);
            boolean prime[] = new boolean[n+1]; 
            for(int i=0;i<n;i++) 
                prime[i] = true; 
              
            for(int p = 2; p*p <=n; p++) 
            { 
                // If prime[p] is not changed, then it is a prime 
                if(prime[p] == true) 
                { 
                    // Update all multiples of p 
                    for(int i = p*2; i <= n; i += p) 
                        prime[i] = false; 
                } 
            } 

            for(int i = 2; i <= n; i++) 
            { 
                if(prime[i] == true) 
                    li.add(i);
            }
            return li;
        } 
       
       static class Tree
       {
    	   
    	   
       }
        
      
  

//*********************END        HERE       EVERYTHING*******************************    

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public void readIntArrays(int[]... arrays) {
            for (int i = 0; i < arrays[0].length; i++) {
                for (int j = 0; j < arrays.length; j++) {
                    arrays[j][i] = readInt();
                }
            }
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

    }
}


