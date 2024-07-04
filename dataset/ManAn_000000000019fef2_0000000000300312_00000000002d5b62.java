import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
 
import static java.lang.Math.*;
 
public class Solution implements Runnable {
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
   
    static class Pair<U extends Comparable<U>, V extends Comparable<V>> implements Comparable<Pair<U, V>> {
        public U first;
        public V second;
 
        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
 
        public int hashCode() {
            return (first == null ? 0 : first.hashCode() * 31) + (second == null ? 0 : second.hashCode());
        }
 
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair<U, V> p = (Pair<U, V>) o;
            return (first == null ? p.first == null : first.equals(p.first)) &&
                    (second == null ? p.second == null : second.equals(p.second));
        }
 
        public int compareTo(Pair<U, V> b) {
            int cmpU = first.compareTo(b.first);
            return cmpU != 0 ? cmpU : second.compareTo(b.second);
        }
 
        public String toString() {
            return String.format("Pair = (%s, %s)", first.toString(), second.toString());
        }
    }
   
    static void printArr(int arr[])
    {
        int len=arr.length;
        for(int i=0;i<len;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
   
    public static void main(String args[]) throws Exception {
        new Thread(null, new Solution(),"Main",1<<26).start();
    }
    public void run() {
        InputReader sc = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);
 
             int t=sc.nextInt();
             int count = 0;
             while (t-->0) {
                 count++;
                 int[] move = new int[2];

                 move[0] = Integer.parseInt(sc.next());
                 move[1] = Integer.parseInt(sc.next());
                
                 Next ob = new Next();
                 if(ob.jump(move,1)){
                     w.println("Case #"+count+": "+ob.getString());
                 }
                 else{
                     w.println("Case #"+count+": IMPOSSIBLE");
                 }                 

             }
             
        w.close();
    }  
}

/**
 * InnerSolution
 */
class Next {
    String str = "";

    String getString(){
        return str;
    }

    boolean jump(int[] move,int i){
        
        if(move[0]==0 && move[1] == 0){
            return true;
        }

        if(Math.abs(move[0])%2 == 1 && Math.abs(move[1])%2 == 1){
                return false;
        }
        
        if(Math.abs(move[0])==1 || Math.abs(move[1])==1){
            if(i!=1){
                return false;
            }
        }

        int m = (int) Math.pow(2, i - 1);
        int smaller = abs(move[0])<=abs(move[1]) ? 0:1;
        if(move[smaller] == 0){
            smaller = rev(smaller);
        }
       
        if(m==1){
            if(abs(move[smaller])%2==1){
                str += jpd(smaller, move[smaller]);
                move[smaller] = mv(move[smaller],m);
            }
            else{
                smaller = rev(smaller);   
                if(abs(move[smaller])%2==1){
                    str += jpd(smaller, (0-1)*move[smaller]);
                    move[smaller] = mv(move[smaller],(0-1)*m);
                }
                else{
                    return false;
                }
            }
        }
        else{
            str += jpd(smaller,move[smaller]);
            move[smaller] = mv(move[smaller],m);
        }
        return jump(move, i+1);
    }

    String jpd(int smaller,int a){
        if(smaller==0){
            if(a<0){
                return "W";
            }
            else{
                return "E";
            }
        }
        else{
            if(a<0){
                return "S";
            }
            else{
                return "N";
            }
        }
    }

    int mv(int move,int a){
        if(move<0){
            return move+a;
        }
        else{
            return move-a;
        }
    }

    int rev(int a){
        if(a==0){
            return 1;
        }
        else{
            return 0;
        }
    }

}
