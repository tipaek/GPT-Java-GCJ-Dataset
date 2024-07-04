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
                long A = in.nextLong();
                long B = in.nextLong();

                Map <Long,Map<Long,Long>> dist = new HashMap();
                Map <Long,Map<Long,String>> direction = new HashMap<>();
                PriorityQueue <Node> pq = new PriorityQueue<>();

                pq.add(new Node(0l,0l,0l));
                dist.put(0l,new HashMap<>());
                dist.get(0l).put(0l,0l);
                while (!pq.isEmpty()){
                    Node tmp = pq.poll();
          //          System.out.println(tmp.x+" "+tmp.y+" "+tmp.cost);
                    if (tmp.cost >= 10)break;
                    if (tmp.x == A && tmp.y == B)break;
                    long val = 1 << tmp.cost;
                    long x = tmp.x;
                    long y = tmp.y;

                    // N
                    x = tmp.x;
                    y = tmp.y + val;
                    if (!dist.containsKey(x))dist.put(x,new HashMap<>());
                    if (dist.get(x).getOrDefault(y,Long.MAX_VALUE) > dist.get(tmp.x).get(tmp.y) + 1){
                        dist.get(x).put(y,dist.get(tmp.x).get(tmp.y) + 1);
                        pq.add(new Node(x,y,dist.get(x).get(y)));
                        if (!direction.containsKey(x))direction.put(x,new HashMap<>());
                        direction.get(x).put(y,"N");
                    }
                    // S
                    x = tmp.x;
                    y = tmp.y - val;

                    if (!dist.containsKey(x))dist.put(x,new HashMap<>());
                    if (dist.get(x).getOrDefault(y,Long.MAX_VALUE) > dist.get(tmp.x).get(tmp.y) + 1){
                        dist.get(x).put(y,dist.get(tmp.x).get(tmp.y) + 1);
                        pq.add(new Node(x,y,dist.get(x).get(y)));
                        if (!direction.containsKey(x))direction.put(x,new HashMap<>());
                        direction.get(x).put(y,"S");

                    }

                    // E
                    x = tmp.x + val;
                    y = tmp.y ;

                    if (!dist.containsKey(x))dist.put(x,new HashMap<>());
                    if (dist.get(x).getOrDefault(y,Long.MAX_VALUE) > dist.get(tmp.x).get(tmp.y) + 1){
                        dist.get(x).put(y,dist.get(tmp.x).get(tmp.y) + 1);
                        pq.add(new Node(x,y,dist.get(x).get(y)));
                        if (!direction.containsKey(x))direction.put(x,new HashMap<>());
                        direction.get(x).put(y,"E");
                    }

                    // W
                    x = tmp.x - val;
                    y = tmp.y;

                    if (!dist.containsKey(x))dist.put(x,new HashMap<>());
                    if (dist.get(x).getOrDefault(y,Long.MAX_VALUE) > dist.get(tmp.x).get(tmp.y) + 1){
                        dist.get(x).put(y,dist.get(tmp.x).get(tmp.y) + 1);
                        pq.add(new Node(x,y,dist.get(x).get(y)));
                        if (!direction.containsKey(x))direction.put(x,new HashMap<>());
                        direction.get(x).put(y,"W");
                    }
                }
            //    w.println("LOL");
                if (dist.get(A) == null || dist.get(A).get(B) == null){
                    w.println("Case #"+tc+": "+"IMPOSSIBLE");
                }
                else{
                    long curX = A;
                    long curY = B;
                    String s = "";
                    while (curX != 0 || curY != 0){
       //                 System.out.println(curX+" "+curY);
                        s += direction.get(curX).get(curY);
                       String tmp = direction.get(curX).get(curY);
                       if (tmp.equals("N")){
                           long val = dist.get(curX).get(curY);
                           curY -= ((1<< val) - (1 << (val-1)));
                       }
                       else if (tmp.equals("S")){
                           long val = dist.get(curX).get(curY);
                           curY += ((1<< val) - (1 << (val-1)));

                       }
                       else if (tmp.equals("E")){
                           long val = dist.get(curX).get(curY);
                           curX -= ((1<< val) - (1 << (val-1)));

                       }
                       else if (tmp.equals("W")){
                           long val = dist.get(curX).get(curY);
                           curX += ((1<< val) - (1 << (val-1)));
                       }
         //              System.out.println("--"+curX+" "+curY);
                    }
                    char c[] = s.toCharArray();
                    for (int i=0;i<c.length/2;i++){
                        char tmp = c[i];
                        c[i] = c[c.length-i-1];
                        c[c.length-i-1] = tmp;
                    }
                    w.println("Case #"+tc+": "+String.valueOf(c));
                }

                tc++;
            }
            w.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    class Node implements Comparable<Node>{
        long x,y,cost;
        Node(long x,long y,long cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
        public int compareTo(Node o){
            return this.cost  <  o.cost ? -1 : this.cost > o.cost ? 1 : 0;
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

