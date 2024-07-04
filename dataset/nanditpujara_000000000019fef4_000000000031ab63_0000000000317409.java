import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.*;
import java.io.*;
import java.lang.*;
public class Solution{
    public static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
     
        public int read() {
            if (numChars==-1)
                throw new InputMismatchException();
     
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                }
                catch (IOException e) {
                    throw new InputMismatchException();
                }
     
                if(numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }
     
        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        public int nextInt() {
            int c = read();
     
            while(isSpaceChar(c))
                c = read();
     
            int sgn = 1;
     
            if (c == '-') {
                sgn = -1;
                c = read();
            }
     
            int res = 0;
            do {
                if(c<'0'||c>'9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
     
            return res * sgn;
        }
     
        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
     
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }
     
        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
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
            }
            while (!isSpaceChar(c));
     
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
 
    static long gcd(long a, long b){
        if (a == 0)
            return b;  
        return gcd(b % a, a);  
    }
    static long lcm(long a, long b)  {
        return (a*b)/gcd(a, b);  
    }
    public static void sortbyColumn(int arr[][], int col) 
    { 
        
        Arrays.sort(arr, new Comparator<int[]>() { 
            
          @Override              
          
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
  
            
            if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        });  
    } 
    static long func(long a[],long size,int s){
        long max1=a[s];
        long maxc=a[s];
        for(int i=s+1;i<size;i++){
            maxc=Math.max(a[i],maxc+a[i]);
            max1=Math.max(maxc,max1);
        }
        return max1;
    }
    public static class Pair<U extends Comparable<U>, V extends Comparable<V>> implements Comparable<Pair<U, V>> {
        public U x;
        public V y;
    
        public Pair(U x, V y) {
            this.x = x;
            this.y = y;
        }
    
        public int hashCode() {
            return (x == null ? 0 : x.hashCode() * 31) + (y == null ? 0 : y.hashCode());
        }
    
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Pair<U, V> p = (Pair<U, V>) o;
            return (x == null ? p.x == null : x.equals(p.x)) && (y == null ? p.y == null : y.equals(p.y));
        }
    
        public int compareTo(Pair<U, V> b) {
            int cmpU = x.compareTo(b.x);
            return cmpU != 0 ? cmpU : y.compareTo(b.y);
        }
    
        public String toString() {
            return String.format("(%s, %s)", x.toString(), y.toString());
        }
    
    }
    static LinkedList<Integer> li[]=new LinkedList[100001];
    static int ans1=0,ans2=0,max1=-1;
    static int dist[];
    static int visited[][];
    //static int arr[];
    static ArrayList<Integer> adj[];
    
    public static void main(String args[]){
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter w = new PrintWriter(outputStream);
        int i,j,k=1,t=in.nextInt();
        while(t-->0){
            int x,y;
            x=in.nextInt();
            y=in.nextInt();
            String s=in.next();
            int n=s.length(),ans=-1;
            char ch[]=s.toCharArray();
            int mx=0,my=0,cx=x,cy=y;
            for(i=0;i<n;i++){
                if(ch[i]=='S'){
                    cy--;
                    if(cx-mx>0){
                        mx++;
                    }else if(cx-mx<0){
                        mx--;
                    }else{
                        if(cy-my>0){
                            my++;
                        }else if(cy-my<0){
                            my--;
                        }
                    }
                }
                if(ch[i]=='N'){
                    cy++;
                    if(cx-mx>0){
                        mx++;
                    }else if(cx-mx<0){
                        mx--;
                    }else{
                        if(cy-my>0){
                            my++;
                        }else if(cy-my<0){
                            my--;
                        }
                    }
                }
                if(ch[i]=='E'){
                    cx++;
                    if(cy-my>0){
                        my++;
                    }else if(cy-my<0){
                        my--;
                    }else{
                        if(cx-mx>0){
                            mx++;
                        }else if(cx-mx<0){
                            mx--;
                        }
                    }
                }
                if(ch[i]=='W'){
                    cx--;
                    if(cy-my>0){
                        my++;
                    }else if(cy-my<0){
                        my--;
                    }else{
                        if(cx-mx>0){
                            mx++;
                        }else if(cx-mx<0){
                            mx--;
                        }
                    }
                }
                if(cx==mx&&cy==my){
                    ans=i+1;
                    break;
                }
            }
            if(ans==-1){
                w.println("Case #"+k+": IMPOSSIBLE");
            }else{
                w.println("Case #"+k+": "+ans);
            }
            k++;
            
        }
        w.close();
    }
   
}

