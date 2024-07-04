import java.io.*;
import java.lang.*;
import java.util.*;
public class Solution{
    public static StringBuffer comp(StringBuffer arr){
        StringBuffer s=new StringBuffer();
        int len=arr.length();
        for(int i=0;i<len;i++) s.append(1-arr.charAt(i)+'0');
        return s;
    }
    public static boolean check(StringBuffer x,StringBuffer y){
        for(int i=0;i<5;i++)
            if(x.charAt(i)!=y.charAt(i)) return false;
        return true;
    }
    public static StringBuffer reverse(StringBuffer arr){
        StringBuffer s=new StringBuffer();
        int len=arr.length();
        for(int i=len-1;i>=0;i--) s.append(arr.charAt(i));
        return s;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str[]=br.readLine().split(" ");
        int T=Integer.parseInt(str[0]);
        int B=Integer.parseInt(str[1]);
        while(T-->0){
            if(B==10){
                StringBuffer sb=new StringBuffer();
                for(int i=1;i<=B;i++){
                    System.out.println(i);
                    System.out.flush();
                    int n=br.readLine().charAt(0)-'0';
                    sb.append(n);
                }
                System.out.println(sb);
                System.out.flush();
                char ch=br.readLine().charAt(0);
            }
            if(B==20){
                StringBuffer one=new StringBuffer();
                StringBuffer two=new StringBuffer();
                StringBuffer three=new StringBuffer();
                StringBuffer four=new StringBuffer();
                StringBuffer five=new StringBuffer();
                StringBuffer six=new StringBuffer();
                for(int i=1;i<=5;i++){
                    System.out.println(i);
                    System.out.flush();
                    int n=br.readLine().charAt(0)-'0';
                    one.append(n);
                }
                for(int i=16;i<=20;i++){
                    System.out.println(i);
                    System.out.flush();
                    int n=br.readLine().charAt(0)-'0';
                    two.append(n);
                }
                for(int i=6;i<=10;i++){
                    System.out.println(i);
                    System.out.flush();
                    int n=br.readLine().charAt(0)-'0';
                    three.append(n);
                }
                for(int i=11;i<=15;i++){
                    System.out.println(i);
                    System.out.flush();
                    int n=br.readLine().charAt(0)-'0';
                    four.append(n);
                }
                for(int i=1;i<=5;i++){
                    System.out.println(i);
                    System.out.flush();
                    int n=br.readLine().charAt(0)-'0';
                    five.append(n);
                }
                for(int i=6;i<=10;i++){
                    System.out.println(i);
                    System.out.flush();
                    int n=br.readLine().charAt(0)-'0';
                    six.append(n);
                }
                StringBuffer a1=comp(one);
                StringBuffer a2=reverse(two);
                StringBuffer a3=comp(a2);
                StringBuffer c1=comp(three);
                StringBuffer c2=reverse(four);
                StringBuffer c3=comp(c2);
                StringBuffer ans=new StringBuffer();
                if(check(three,six)) ans.append(three+""+four);
                else if(check(c1,six)) ans.append(c1+""+comp(four));
                else if(check(c2,six)) ans.append(c2+""+reverse(three));
                else ans.append(c3+""+comp(reverse(three)));
                if(check(one,five)) System.out.println(one+""+ans+""+two);
                else if(check(a1,five)) System.out.println(a1+""+ans+""+comp(two));
                else if(check(a2,five)) System.out.println(a2+""+ans+""+reverse(one));
                else System.out.println(a3+""+ans+""+comp(reverse(one)));
                br.readLine();
            }
        }
    }
}

class Bolt
{
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
 
        public Bolt(InputStream stream) {
            this.stream = stream;
        }
 
        public int read() {
            if (numChars == -1)
                throw new UnknownError();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new UnknownError();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }
 
        public int peek() {
            if (numChars == -1)
                return -1;
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    return -1;
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar];
        }
 
        public void skip(int x) {
            while (x-- > 0)
                read();
        }
 
        public int nextInt() {
            return Integer.parseInt(next());
        }
 
        public long nextLong() {
            return Long.parseLong(next());
        }
 
        public String nextString() {
            return next();
        }
 
        public String next() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuffer res = new StringBuffer();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
 
            return res.toString();
        }
 
        public String nextLine() {
            StringBuffer buf = new StringBuffer();
            int c = read();
            while (c != '\n' && c != -1) {
                if (c != '\r')
                    buf.appendCodePoint(c);
                c = read();
            }
            return buf.toString();
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
 
        public boolean hasNext() {
            int value;
            while (isSpaceChar(value = peek()) && value != -1)
                read();
            return value != -1;
        }
 
        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
}