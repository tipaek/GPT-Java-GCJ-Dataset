import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.*;
import java.io.*;
import java.lang.*;
public class Main{
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
    public static class Pair<U extends Comparable<U>, V extends Comparable<V>> implements Comparable<Pair<U, V>> {
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
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Pair<U, V> p = (Pair<U, V>) o;
            return (first == null ? p.first == null : first.equals(p.first)) && (second == null ? p.second == null : second.equals(p.second));
        }
    
        public int compareTo(Pair<U, V> b) {
            int cmpU = first.compareTo(b.first);
            return cmpU != 0 ? cmpU : second.compareTo(b.second);
        }
    
        public String toString() {
            return String.format("(%s, %s)", first.toString(), second.toString());
        }
    
    }
    static boolean sol;
    static int ans[][]=new int[60][60];
    static boolean rs[][]=new boolean[60][60];
    static boolean cs[][]=new boolean[60][60];
    static int n,k,t;
    static void funcE(int r,int c,int m)
    {
        if(r==n&&c==n+1&&m==k&&!sol)
        {
            sol=true;
            System.out.println("Case #"+t+": POSSIBLE");
            for(int i=1;i<=n;i++)
            {
                for(int j=1;j<=n;j++)
                {
                    System.out.print(ans[i][j]+" ");
                   
                }
                System.out.println();
            }
            return;
        }
        else if(r>n){
            return;
        }
        else if(c>n){
            funcE(r+1,1,m);
        }
        for(int i=1;i<=n&&!sol;i++)
        {
            if(!rs[r][i]&&!cs[c][i])
            {
                rs[r][i]=cs[c][i]=true;
                if(r==c){
                    m+=i;
                }
            ans[r][c]=i;
           
            funcE(r,c+1,m);
           
            rs[r][i] = false;
            cs[c][i] = false;
            if (r == c) {
                m -= i;
            }
            ans[r][c] = 0;
            }
        }
    }
    static LinkedList<Integer> li[]=new LinkedList[100001];
    static int ans1=0,ans2=0,max1=-1;
    static int dist[]=new int[100001];
    static int visited[]=new int[100001];
    //static int arr[];
    static ArrayList<Integer> adj[]=new ArrayList[100001];
    static void bfs(int n, char ch[]){
        //visited[x]=1;
        //visit[j]++;
        //dist[n]=0;
        //visited[n]=1;
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int u=q.poll();
            int x=ch[u]-'0';
            if(u==n-1){
                break;
            }
            for(int i=0;i<adj[x].size();i++){
                if(dist[adj[x].get(i)]==-1){
                    dist[adj[x].get(i)]=dist[u]+1;
                    q.add(adj[x].get(i));
                }
            }
            adj[x].clear();
            if(u>0&&dist[u-1]==-1){
                q.add(u-1);
                dist[u-1]=dist[u]+1;
            }
            if(dist[u+1]==-1){
                q.add(u+1);
                dist[u+1]=dist[u]+1;
            }
        }
    } 
    
    public static void main(String args[]){
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter w = new PrintWriter(outputStream);
        int q=in.nextInt();
        sol=false;
        for(t=1;t<=q;t++)
        {
            n=in.nextInt();
            k=in.nextInt();
            funcE(1,1,0);
            if(!sol){
                System.out.println("Case #"+t+": IMPOSSIBLE");
            }
            sol=false;
        }
        w.close();
    }
    
   
}