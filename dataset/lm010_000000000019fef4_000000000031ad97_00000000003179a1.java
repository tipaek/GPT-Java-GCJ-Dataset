import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import static java.lang.Math.*;
public class Solution implements Runnable {

    public static void main(String[] args) {
        new Thread(null, new Solution(), "Check2", 1 << 28).start();// to increse stack size in java
    }
    long mod= (long)(1e9+7);
    public void run() {
        try {
            boolean file = false;
            InputReader in;
            PrintWriter w;
            if (file) {
                in = new InputReader(new FileInputStream("C:\\Users\\Lenovo\\Downloads\\A-large(1).in"));
                w = new PrintWriter("output.txt");
            } else {
                in = new InputReader(System.in);
                w = new PrintWriter(System.out);
            }

            int t = in.nextInt();
            int tc = 1;

            while (t-- > 0){
                int u = in.nextInt();
                if (u == 2){
                    int n = 10000;
                    Pair p[] = new Pair[n];
                    for (int i=0;i<n;i++)p[i] = new Pair(in.nextInt(),in.next());
                    Arrays.sort(p,(a,b) -> (a.val - b.val));
                    Set<Character> used = new HashSet<>();
                    Map <Integer,Character> map = new HashMap<>();

                    for (int i=0;i<n;i++){
                        int digitCount = getDigitCount(p[i].val);
                        if (digitCount == 2)break;
                        if (!used.contains(p[i].digit.charAt(0))){
                            used.add(p[i].digit.charAt(0));
                            map.put(p[i].val,p[i].digit.charAt(0));
                        }
                    }

                    Queue <Character> other = new LinkedList<>();
                    for (int i=0;i<n;i++){
                        for (int j=0;j<p[i].digit.length();j++){
                            if (!used.contains(p[i].digit.charAt(j))){
                                other.add(p[i].digit.charAt(j));
                                used.add(p[i].digit.charAt(j));
                            }
                        }
                    }
                    for (int i=0;i<=9;i++){
                        if (!map.containsKey(i)){
                            map.put(i,other.poll());
                        }
                    }
                    w.print("Case #"+tc+": ");
                    for (int i=0;i<=9;i++){
                        w.print(map.get(i));
                    }
                    w.println();
                }
                else if (u == 16){
                    int n = 10000;
                    Pair p[] = new Pair[n];
                    for (int i=0;i<n;i++)p[i] = new Pair(in.nextInt(),in.next());
                    Arrays.sort(p,(a,b) -> (a.val - b.val));
                    Set<Character> used = new HashSet<>();
                    Map <Integer,Character> map = new HashMap<>();

                    for (int i=0;i<n;i++){
                        int digitCount = getDigitCount(p[i].val);
                        if (digitCount == 2)break;
                        if (!used.contains(p[i].digit.charAt(0))){
                            used.add(p[i].digit.charAt(0));
                            map.put(p[i].val,p[i].digit.charAt(0));
                        }
                    }

                    Queue <Character> other = new LinkedList<>();
                    for (int i=0;i<n;i++){
                        for (int j=0;j<p[i].digit.length();j++){
                            if (!used.contains(p[i].digit.charAt(j))){
                                other.add(p[i].digit.charAt(j));
                                used.add(p[i].digit.charAt(j));
                            }
                        }
                    }
                    for (int i=0;i<=9;i++){
                        if (!map.containsKey(i)){
                            map.put(i,other.poll());
                        }
                    }
                    w.print("Case #"+tc+": ");
                    for (int i=0;i<=9;i++){
                        w.print(map.get(i));
                    }
                    w.println();

                }
                else{

                }
                tc++;
            }
            w.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    int getDigitCount(int val){
        int count = 0;
        while (val > 0){
            val /= 10;
            count++;
        }
        return count;
    }
    class Pair{
        int val;
        String digit;
        Pair(int val,String digit){
            this.val = val;
            this.digit = digit;
        }
    }
    static class InputReader
    {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream)
        {
            this.stream = stream;
        }

        public int read()
        {
            if (numChars==-1)
                throw new InputMismatchException();

            if (curChar >= numChars)
            {
                curChar = 0;
                try
                {
                    numChars = stream.read(buf);
                }
                catch (IOException e)
                {
                    throw new InputMismatchException();
                }

                if(numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine()
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String stock = "";
            try
            {
                stock = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return stock;
        }
        public int nextInt()
        {
            int c = read();

            while(isSpaceChar(c))
                c = read();

            int sgn = 1;

            if (c == '-')
            {
                sgn = -1;
                c = read();
            }

            int res = 0;
            do
            {
                if(c<'0'||c>'9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));

            return res * sgn;
        }

        public long nextLong()
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-')
            {
                sgn = -1;
                c = read();
            }
            long res = 0;

            do
            {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }

        public double nextDouble()
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-')
            {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.')
            {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.')
            {
                c = read();
                double m = 1;
                while (!isSpaceChar(c))
                {
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

        public String readString()
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do
            {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));

            return res.toString();
        }

        public boolean isSpaceChar(int c)
        {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next()
        {
            return readString();
        }

        public interface SpaceCharFilter
        {
            public boolean isSpaceChar(int ch);
        }
    }
}

