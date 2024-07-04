import java.util.*;
import java.io.*;
public class qrc{
    public static class Pair implements Comparable<Pair>{
        int l;
        int r;
        int ind;
        char p;
        public Pair(int a,int b,int pos){l=a;r=b;p='A';ind=pos;}
        public int compareTo(Pair ac){ return Integer.compare(this.l,ac.l);}
    }
    public static void main(String[] args) throws IOException{
        Bolt sc = new Bolt(System.in);
        int T=sc.nextInt();
        StringBuffer sb=new StringBuffer();
        for(int t=1;t<=T;t++){
            int N=sc.nextInt();
            Pair[] arr=new Pair[N];
            for(int i=0;i<N;i++){
                arr[i]=new Pair(sc.nextInt(),sc.nextInt(),i);
            }
            Arrays.sort(arr);
            boolean flag=true;
            for(int i=0;i<N;i++){
                int C=0;int J=0;
                for(int j=0;j<i;j++){
                    if(arr[j].r>arr[i].l){
                        if(arr[j].p=='C') C++;
                        else J++;
                    }
                }
                if(C!=0 && J!=0){
                    flag=false;
                    break;
                }
                else arr[i].p=(C==0)?'C':'J';
            }
            StringBuffer temp=new StringBuffer(N);
            if(!flag) temp.append("IMPOSSIBLE");
            else{
                for(int i=0;i<N;i++) temp.append('A');
                for(int i=0;i<N;i++) temp.setCharAt(arr[i].ind,arr[i].p);
            }
            sb.append("Case #"+t+": "+temp+"\n");
        }
        System.out.print(sb);
        
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