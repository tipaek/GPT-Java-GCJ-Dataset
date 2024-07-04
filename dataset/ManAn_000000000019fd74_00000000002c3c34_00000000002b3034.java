import java.io.*;
import java.util.*;
import java.util.Map.Entry;


import java.math.*;
import java.lang.*;
 
import static java.lang.Math.*;
 
class Solution implements Runnable {
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
 
        int t = Integer.parseInt(sc.next());
        int count =0;
        while(t-->0){
            count++;
            int n = Integer.parseInt(sc.next());
            String[] s = new String[n];
            for (int i = 0; i < n; i++) {
                s[i] = sc.next();
            }
            s = sort(s, n);

            char[][] carr = new char[n][];
            for (int i = 0; i < s.length; i++) {
                carr[i] = s[i].toCharArray();
            }
            // String[] s1 = new String[n];
            // for (int i = 0; i < n; i++) {
            //     s1[i] = new String(carr[i], 1, carr[i].length-1);
            // }
            // sort(s1, n);
            // boolean flag = true;
            // for (int i = 0; i < s1.length-1; i++) {
            //     if(!s1[i+1].endsWith(s1[i])){
            //         flag = false;
            //         break;
            //     }
            // }
            
            // if(flag){
            // System.out.println("Case #"+count+": A"+s1[s1.length-1]);
            // }
            // else{
            //     System.out.println("Case #"+count+": *");
            // }

            String[] s2 = new String[n];
            String[] se = new String[n];
            for (int i = 0; i < n; i++) {
                if(carr[i][0]=='*'){
                    s2[i] = "*";
                    se[i] = new String(carr[i],1,carr[i].length-1);
                    s[i] = se[i];
                }
                else if(carr[i][carr[i].length-1]=='*'){
                    s2[i] = new String(carr[i],0,carr[i].length-2);
                    se[i] = "*";
                    s[i] = s2[i];
                }
                else{
                    int a = 0;
                    while (carr[i][a]!='*') {
                        a++;
                    }
                    s2[i] = new String(carr[i],0,a-1);
                    se[i] = new String(carr[i],a+1,carr[i].length-a-1);
                    s[i] = s2[i]+se[i];
                }
            }
            boolean flag = true;
            for (int i = 0; i < n-1; i++) {
                if(!s2[i+1].startsWith(s2[i]) && !s2[i].equals("*") && !s2[i+1].equals("*")){
                    flag = false;
                    break;
                }
                if(!se[i+1].endsWith(se[i]) && !se[i].equals("*") && !se[i+1].equals("*")){
                    flag = false;
                    break;
                }
            }
            if(flag){
                   w.println("Case #"+count+": "+s[n-1]);
            }
            else{
                w.println("Case #"+count+": *");

            }
        } 
        w.close();
    }
   
    static String[] sort(String[] str, int n) 
    { 
        TreeMap<Integer, ArrayList<String> > map 
            = new TreeMap<Integer, ArrayList<String> >(); 
  
        for (int i = 0; i < n; i++) { 
  
            map.putIfAbsent(str[i].length(), 
                            new ArrayList<String>()); 
            map.get(str[i].length()).add(str[i]); 
        } 
  
        int temp = 0; 
  
        for (Entry<Integer, ArrayList<String> > 
                 e : map.entrySet()) { 
  
            for (int i = 0; i < e.getValue().size(); i++) { 
  
                str[temp] = e.getValue().get(i); 
                temp++; 
            } 
        } 
        return str; 
    }
}