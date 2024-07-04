import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.*;
import java.io.*;
import java.lang.*;
class Solution{
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
        int t=in.nextInt(),i,j,k;
        for(i=0;i<t;i++){
            String s=in.next(),s1="";
            int n=s.length(),op=0,cl=0;
            char ch[]=s.toCharArray();
            for(j=0;j<ch[0]-'0';j++){
                s1+='(';
            }
            s1+=ch[0];
            for(j=1;j<n;j++){
                if(ch[j]>ch[j-1]){
                    op=ch[j]-ch[j-1];
                    for(k=0;k<op;k++){
                        s1+='(';
                    }
                }else if(ch[j]<ch[j-1]){
                    cl=ch[j-1]-ch[j];
                    for(k=0;k<cl;k++){
                        s1+=')';
                    }
                }
                s1+=ch[j];
            }
            for(j=0;j<ch[n-1]-'0';j++){
                s1+=')';
            }
            w.println("Case #"+(i+1)+": "+s1);
        }
        w.close();
    }
   
}