
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;
public  class Solution implements Runnable {
	 
	 
    public void run() {
 
        InputReader input = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);
       
        int t = input.nextInt();
        int count=1;
        while(count<=t)
        {
        	int n = input.nextInt();
        	
        	int[][] arr= new int[n][3];
        	for(int i=0;i<n;i++)
        	{
        		arr[i][0]=input.nextInt();
        		arr[i][1] =input.nextInt();
        		arr[i][2] = i;
        	}
        	Arrays.sort(arr, (a,b) -> (a[0]-b[0]));
        	
        	char[] ans =new char[n];
        	
        	int flag1=0;
        	int flag2=0;
        	int end1=0;
        	int end2=0;
        	int flag3=0;
        	for(int i=0;i<n;i++)
        	{
        		if(arr[i][0]>=end1)
        		{
        			flag1=0;
        		}
        		if(arr[i][0]>=end2)
        		{
        			flag2=0;
        		}
        		//System.out.println(flag1 + " " + flag2 + " " + end1 + " " + end2 );
        		if(flag1==0)
        		{
        			flag1=1;
        			end1=arr[i][1];
        			ans[arr[i][2]]='C';
        		}
        		else if(flag2==0)
        		{
        			flag2=1;
        			end2= arr[i][1];
        			ans[arr[i][2]]='J';
        		}
        		else
        		{
        			flag3=1;
        		}
        		//System.out.println(flag1 + " " + flag2 + " " + end1 + " " + end2 );
        		//System.out.println(ans);
        	}
        	String ans1= new String(ans);
        	if(flag3==1)
        	{
        		ans1="IMPOSSIBLE";
        	}
        	System.out.println("Case #" + (count)+": " + ans1);
        
        	count++;
        }
        	
        
        
    }
        
        
       
        
        
        
        
    
   
    	
    static int ans(int[] arr, int n)
    {
    	
    	int max = arr[0] | arr[1];
    	
    	for(int i=1;i<n-1;i++)
    	{
    		max =Math.max(max, arr[i] | arr[i+1]);
    	}
    	return max;
    }
class Sorting implements Comparator<pair>
{
	public int compare(pair one, pair two)
	{
		if(one.a>two.a)
			return 1;
		else if(one.a==two.a)
			return 0;
		else 
			return -1;
				
	}
}
class pair
{
	int a;
	int b;
	
	pair(int a ,int b)
	{
		this.a=a;
		this.b=b;
	}
		
}
 
    class Graph{
        private final int v;
        private List<List<Integer>> adj;
        Graph(int v){
            this.v = v;
            adj = new ArrayList<>(v);
            for(int i=0;i<v;i++){
                adj.add(new LinkedList<>());
            }
        }
        private void addEdge(int a,int b){
            adj.get(a).add(b);
        }
        private boolean isCyclic()
        {
            boolean[] visited = new boolean[v];
            boolean[] recStack = new boolean[v];
            for (int i = 0; i < v; i++)
                if (isCyclicUtil(i, visited, recStack))
                    return true;
 
            return false;
        }
        private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack)
        {
            if (recStack[i])
                return true;
            if (visited[i])
                return false;
            visited[i] = true;
            recStack[i] = true;
            List<Integer> children = adj.get(i);
            for (Integer c: children)
                if (isCyclicUtil(c, visited, recStack))
                    return true;
            recStack[i] = false;
            return false;
        }
    }
    public static void sortbyColumn(int arr[][], int col)
    {
 
        Arrays.sort(arr, new Comparator<int[]>()
        {
            public int compare(int[] o1, int[] o2){
                return(Integer.valueOf(o1[col]).compareTo(o2[col]));
            }
        });
 
    }
    static long gcd(long a, long b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    public static class DJSet {
        public int[] upper;
 
        public DJSet(int n) {
            upper = new int[n];
            Arrays.fill(upper, -1);
        }
 
        public int root(int x) {
            return upper[x] < 0 ? x : (upper[x] = root(upper[x]));
        }
 
        public boolean equiv(int x, int y) {
            return root(x) == root(y);
        }
 
        public boolean union(int x, int y) {
            x = root(x);
            y = root(y);
            if (x != y) {
                if (upper[y] < upper[x]) {
                    int d = x;
                    x = y;
                    y = d;
                }
                upper[x] += upper[y];
                upper[y] = x;
            }
            return x == y;
        }
    }
    public static int[] radixSort(int[] f)
    {
        int[] to = new int[f.length];
        {
            int[] b = new int[65537];
            for(int i = 0;i < f.length;i++)b[1+(f[i]&0xffff)]++;
            for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
            for(int i = 0;i < f.length;i++)to[b[f[i]&0xffff]++] = f[i];
            int[] d = f; f = to;to = d;
        }
        {
            int[] b = new int[65537];
            for(int i = 0;i < f.length;i++)b[1+(f[i]>>>16)]++;
            for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
            for(int i = 0;i < f.length;i++)to[b[f[i]>>>16]++] = f[i];
            int[] d = f; f = to;to = d;
        }
        return f;
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
        new Thread(null, new Solution(),"TaskA",1<<26).start();
    }
}
 
 
 