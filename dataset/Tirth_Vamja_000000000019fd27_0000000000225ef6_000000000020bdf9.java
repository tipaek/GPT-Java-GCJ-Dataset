import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
public class Solution{
    static void ff(int nn,int aa[],int j)
    {for(;j<=nn;j++)aa[j]=1;}
    static void solve(InputReader sc, PrintWriter out, int test)
    {
        int bb[] = new int[1442];
        int n = sc.nextInt();
        P[] p = new P[n];
        int aa[] = new int[1442];
        for(int z=0;z<n;z++){
            int ss = sc.nextInt();
            int ee =sc.nextInt();
            p[z] = new P(ss,ee,z);}
        Arrays.sort(p,new SP());
        char anss[] = new char[n];
        for(int i=0;i<n;i++){
            int ee = p[i].b;
            int ss = p[i].a;
            int in = p[i].in;
            if(aa[ss]!=1){
                anss[p[i].in]='C';
                ff(ee-1,aa,ss);}
            else if(bb[ss]!=1){
                anss[p[i].in]='J';
                ff(ee-1,bb,ss);}
            else{
                out.println("Case #"+test+": IMPOSSIBLE");
                return;}
        }
        out.println("Case #"+test+": "+new String(anss));
    }
   
    
    static class P
    {
        int a,b,in;
        P(int aa, int bb,int ii){
            a = aa;
            b = bb;
            in=ii;}
        public String toString(){
            return "["+a+" "+b+"]";}
    }
    static class SP implements Comparator<P>
    {
        public int compare(P a, P b){
            if(a.a != b.a) return a.a - b.a;
            return a.b - b.b;}
    }
    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
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
 
    public static void main(String args[]) throws Exception {
        InputReader sc = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int tt = sc.nextInt();
        for(int j=1;j<=tt;j++)solve(sc,out,j);         
        out.close();
    }
}