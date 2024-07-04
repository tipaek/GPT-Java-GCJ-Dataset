import java.util.*;
import java.io.*;
// import java.lang.*;
// import java.math.BigInteger;

public class Solution
{
    // public static int M = 1000000007;
    public static void main(String[] args) throws IOException{
        InputReader in 		= new InputReader(System.in);
        OutputWriter out	=	new OutputWriter(System.out);
        int t = in.readInt();
        
        for(int k=1;k<=t;k++){
            int n = in.readInt();
            int trace = 0;
            int[][] arr = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j] = in.readInt();
                    if(i==j){
                        trace+=arr[i][j];
                    }
                }
            }
            int row = 0 ,col = 0;
            for(int i=0;i<n;i++){
                HashSet<Integer> h = new HashSet<Integer>();
                for(int j=0;j<n;j++){
                    if(h.contains(arr[i][j])){
                        row++;
                        break;
                    }
                    else{
                        h.add(arr[i][j]);
                    }
                }
            }
            for(int j=0;j<n;j++){
                HashSet<Integer> h = new HashSet<Integer>();
                for(int i=0;i<n;i++){
                    if(h.contains(arr[i][j])){
                        col++;
                        break;
                    }
                    else{
                        h.add(arr[i][j]);
                    }
                }
            }
            System.out.println("case #"+k+": " + trace + " " + row + " " + col);
        }
        out.flush();
        out.close();
        
    }
    public static boolean check(long x){
        if((x&1) == 1 || x%4==0){
            return true;
        }
        return false;
    }
    
    
    
}
    
    class InputReader {
 
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
    
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
    
        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }
    
        public int readInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
    
        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }
    
        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    
        public String next() {
            return readString();
        }
    
        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
    
    class OutputWriter {
        private final PrintWriter writer;
    
        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }
    
        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }
    
        public void print(Object...objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    writer.print(' ');
                writer.print(objects[i]);
            }
        }
    
        public void printLine(Object...objects) {
            print(objects);
            writer.println();
        }
    
        public void close() {
            writer.close();
        }
    
        public void flush() {
            writer.flush();
        }
    
        }
    
    class IOUtils {
    
        public static int[] readIntArray(InputReader in, int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++)
                array[i] = in.readInt();
            return array;
        }
    
        }
    
    
    