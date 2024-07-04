import java.io.OutputStream;
import java.util.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.LinkedHashSet;
import java.io.Writer;
import java.math.BigInteger;
import java.io.OutputStreamWriter;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Egor Kulikov (egor@egork.net)
 */
 class Solution {

    public static void main(String[] args) throws FileNotFoundException {

        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        Solutio solver = new Solutio();
      
        int testCount =Integer.parseInt(in.next());
       // int sum=in.readInt(),te=0;
		// if(sum==1)
       
		for (int i = 1; i <= testCount; i++) 
		{
			solver.solve(i, in, out);
			//System.out.println();
		}
//		Scanner sc=new Scanner(new File("/home/ujjman/Desktop/Solution1.txt"));
//		Scanner sc1=new Scanner(new File("/home/ujjman/Desktop/Solution.txt"));
//		//System.out.println(sc.nextLine()+"    "+sc1.nextLine());//break;
//		while(sc.hasNext())
//		{
//			String s=sc.nextLine();
//			String s1=sc1.nextLine();
//			if(!s.contentEquals(s1))
//			{
//				System.out.println(s+"    "+s1);//break;
//			}
//		}
        out.close();
    }
//**********************SOLVE    HERE     EVERYTHING******************************



    //1 2 3 4 5 
    static class Solutio {
    	static long mod=(long)(Math.pow(10, 9)+7);
        public void solve(int testNumber, InputReader in, OutputWriter out) throws FileNotFoundException {
//        	Graph<Node<Integer>> g=new Graph<Node<Integer>>(true);
//        	Node<Integer> node;
//        	Node<Integer> node2;
//        	for(int i=0;i<10;i++)
//        	{
//        		node=new Node<Integer>(in.readInt(),0);
//        		node2=new Node<Integer>(in.readInt(),0);
//        		g.add(node, node2);
//        	}
//        	
//
//        	g.print();
        	//g.bfs(1);
        	List<Pair> cbusymin=new ArrayList<Pair>();
        	List<Pair> jbusymin=new ArrayList<Pair>();
        	int n=in.readInt();
        	int start[]=new int[n],end[]=new int[n];
        	for(int i=0;i<n;i++)
        	{
        		start[i]=in.readInt();
        		end[i]=in.readInt();
        	}
        	Pair te;
        	int ch=0;
        	for(int i=0;i<n;i++)
        	{
        		ch=0;
        		te=new Pair();
        		te.add(start[i], end[i]);
        		for(int j=0;j<cbusymin.size();j++)
        		{
        			if(cbusymin.get(j).contains(start[i],end[i]))
        			{
        			ch=1;	
        			}
        		}
        		if(ch==0)
        		{
        			cbusymin.add(te);
        		}
        		else
        		{
        			ch=0;
        			for(int j=0;j<jbusymin.size();j++)
            		{
            			if(jbusymin.get(j).contains(start[i],end[i]))
            			{
            			ch=1;	
            			}
            		}
        			if(ch==0)
        			{
        				jbusymin.add(te);
        			}
        			else
        			{
        				out.printLine("Case #"+testNumber+": IMPOSSIBLE");return;
        			}
        		}
        		
        	}
        	out.print("Case #"+testNumber+": ");
        	loop:
        	for(int i=0;i<n;i++)
        	{
        		for(int j=0;j<cbusymin.size();j++)
        		{
        			if(cbusymin.get(j).a==start[i] && cbusymin.get(j).b==end[i])
        			{
        				out.print("C");continue loop;
        			}
        		}
        		for(int j=0;j<jbusymin.size();j++)
        		{
        			if(jbusymin.get(j).a==start[i] && jbusymin.get(j).b==end[i])
        			{
        				out.print("J");continue loop;
        			}
        		}
        		
        	}
        	out.printLine();

        	
        }
        
        
        static int kFactors(int n, int k) 
        { 
            // A vector to store all prime factors of n 
            ArrayList<Integer> P = new ArrayList<Integer>(); 
          
            // Insert all 2's in list 
            while (n % 2 == 0) 
            { 
                P.add(2); 
                n /= 2; 
            } 
          
            // n must be odd at this point 
            // So we skip one element (i = i + 2) 
            for (int i = 3; i * i <= n; i = i + 2) 
            { 
                while (n % i == 0) 
                { 
                    n = n / i; 
                    P.add(i); 
                } 
            } 
          
            // This is to handle when n > 2 and 
            // n is prime 
            if (n > 2) 
                P.add(n); 
            if (P.size() < k) 
            {  
                return -1; 
            } 
            int product = 1; 
            for (int i = k - 1; i < P.size(); i++) 
                product = product * P.get(i); 
            return product;
        } 
          
        // Driver code 
        
        }  
        
        
        public static long gcd(long a,long b)
        {
        	if(a==0)
        		return b;
        	if(b==0)
        		return a;
        	if(a==1 || b==1 || a%b==0 || b%a==0)
        		return Math.min(a, b);
        	if(a>b)
        		return gcd(a%b,b);
        	else
        		return gcd(a,b%a);
        	
        }
        public static int binarySearch(int arr[],int l,int u,int toSearch)
        {
        	if(l>u )
        	{
        		return -1;
        	}
        	int mid=(l+u)/2;
        	if(arr[mid]==toSearch)
        		return mid;
        	if(toSearch>arr[mid])
        	{
        		return binarySearch(arr,mid+1,u,toSearch);
        	}
        	else
        		return binarySearch(arr,l,mid-1,toSearch);
        	
        	
        	
        }
      
        private static int nextGreaterElementInSortedList(long arr[], long target)  
        {  
            int start = 0, end = arr.length - 1;  
        
            int ans = -1;  
            while (start <= end) {  
                int mid = (start + end) / 2;  
        
                // Move to right side if target is  
                // greater.  
                if (arr[mid] <= target) {  
                    start = mid + 1;  
                }  
        
                // Move left side.  
                else {  
                    ans = mid;  
                    end = mid - 1;  
                }  
            }  
            return ans;  
        }  
        static class Pair
        {
        	int a;
        	int b;
        	public Pair()
        	{
        		a=-1;
        		b=-1;
        	}
        	public void add(int x,int y)
        	{
        		a=x;
        		b=y;
        	}
        	public boolean contains(int k,int j)
        	{
        		if(k>a && k<b)
        			return true;
        		if(j>a && j<b)
        			return true;
        		return false;
        	}
        	
        }


//*********************END        HERE       EVERYTHING*******************************    

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public void readIntArrays(int[]... arrays) {
            for (int i = 0; i < arrays[0].length; i++) {
                for (int j = 0; j < arrays.length; j++) {
                    arrays[j][i] = readInt();
                }
            }
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

    }
}

class Node<E>{
	E data;
	int weight;
	Node(E d,int w)
	{
		data=d;
		weight=w;
	}
	
}
class Graph<Node>
{
	int size;
	boolean directed;
	HashMap<Node,LinkedList<Node>> vertex;
	Graph(boolean dir)
	{
		vertex=new HashMap<Node,LinkedList<Node>>();
		size=0;
		directed=dir;
	}
	
	public void add(Node from,Node to)
	{
		if(from==to)
			return;
		if(!vertex.containsKey(from) )
		{
			vertex.put(from, new LinkedList<Node>());
			size++;
		}
		if(!vertex.containsKey(to))
		{
			vertex.put(to, new LinkedList<Node>());
			size++;
		}
		if(directed==false)
		{
			vertex.get(from).add(to);
			vertex.get(to).add(from);
		}
		else
		vertex.get(from).add(to);
		
	}
	
	public void bfs(Node start)
	{
		LinkedList<Node> visited=new LinkedList<Node>();
		Queue<Node> vis=new LinkedList<Node>();
		vis.add(start);
		visited.add(start);
		while(vis.isEmpty()==false )
		{
			for(int i=0;i<vertex.get(vis.peek()).size();i++)
			{
				if(!visited.contains(vertex.get(vis.peek()).get(i)))
				{
					vis.add(vertex.get(vis.peek()).get(i));
					visited.add(vertex.get(vis.peek()).get(i));
				}
			}
			
			visited.add(vis.peek());
			System.out.print(vis.poll()+"   ");
			
		}
		System.out.println();
	}
	
	public void print()
	{
		for(Node key:vertex.keySet())
			System.out.println(key+" --> "+vertex.get(key));
		
		
	}

	
	
}

