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
        PrintWriter out = new PrintWriter(outputStream);
        Solutio solver = new Solutio();
        List<Integer> prime=new LinkedList<>();
        //prime=sieveOfEratosthenes(100002);
        int testCount =Integer.parseInt(in.next());
       // int sum=in.readInt(),te=0;
		// if(sum==1)
       
		for (int i = 1; i <= testCount; i++) 
		{
			solver.solve(i, in, out,prime);
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
        public void solve(int testNumber, InputReader in, PrintWriter out,List<Integer> prime) throws FileNotFoundException {
               int x=in.readInt();
               int y=in.readInt();
               String s=in.readString();
               int min=x;
               out.print("Case #"+testNumber+": ");
               if(s.length()<min)
               {
            	   out.println("IMPOSSIBLE");return;
               }
               for(int i=0;i<x;i++)
               {
            	   if(s.charAt(i)=='S')
            	   {
            		   y--;
            	   }
            	   else
            	   {
            		   y++;
            	   }
               }
               
               int ansx=x;
               int ansy=0;
               if(ansx==x && ansy==y)
               {
            	   out.println(x);return;
               }
               if((s.length()-1)==x)
               {
            	   if(Math.abs(ansy-y)==1  )
            	   {
            		   if((s.charAt(x)=='S'  && ansy<y) ||(s.charAt(x)=='N' && ansy>y)) {
                		   out.println(min+1);return;}
            	   }
               }
               for(int i=x;i<s.length()-1;i++)
               {
            	   if(Math.abs(ansy-y)==1)
            	   {
            		   if((s.charAt(i+1)=='S'  && ansy<y) ||(s.charAt(i+1)=='N' && ansy>y)) {
            		   out.println(min+1);return;}
            		   
            	   }
            	   if(s.charAt(i)=='S')
            		   {
            		   if(ansy>y)
            		   {
            			   ansy--;
            		   }
            		   else
            		   {
            			   ansy++;
            		   }
            		   min++;
            		   
            		      y--;
            		      
            		   }
            	   else if(s.charAt(i)=='N')
            	   {
            		   if(ansy>y)
             		  {
             			ansy--;  
             		  }
            		   else {
            			   ansy++;
            		   }
            		   min++;
            		   
            		   y++;
            		  
            	   }
            	   
               }
               out.println("IMPOSSIBLE");
               
               
        	
        }
        static boolean checkperm(int a[],int b[])
        {
        	Arrays.sort(a);
        	Arrays.sort(b);
        	if(a[0]!=b[0] || a[1]!=b[1] || a[2]!=b[2]) {
        		
        	
        		return false;}
        	return true;
        		
        }
        static long power(long number, long power) 
        { 
                long n= power;
                if(number==0)
                    return 0;
                long ans= number;
                long tot=1;
                while(n>0)
                {
                    if(n%2==1)
                        tot= (tot*ans)%mod;
                    ans= (ans*ans)%mod;
                    n=n>>1;
                }
                return tot%mod;
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
        
        
        
        
        private static int nextGreaterElementInSortedList(List<Pair> arr, long target)  
        {  
            int start = 0, end = arr.size() - 1;  
        
            int ans = -1;  
            while (start <= end) {  
                int mid = (start + end) / 2;  
        
                // Move to right side if target is  
                // greater.  
                if (arr.get(mid).a <= target) {  
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
       
        
        
    }
  static ArrayList<Integer> sieveOfEratosthenes(int n) 
    { 
        // Create a boolean array "prime[0..n]" and initialize 
        // all entries it as true. A value in prime[i] will 
        // finally be false if i is Not a prime, else true. 
        boolean prime[] = new boolean[n+1]; 
        for(int i=0;i<n;i++) 
            prime[i] = true; 
          ArrayList<Integer> li=new ArrayList<Integer>();
        for(int p = 2; p*p <=n; p++) 
        { 
            // If prime[p] is not changed, then it is a prime 
            if(prime[p] == true) 
            { 
                // Update all multiples of p 
                for(int i = p*p; i <= n; i += p) 
                    prime[i] = false; 
            } 
        } 
          
        // Print all prime numbers 
        for(int i = 2; i <= n; i++) 
        { 
            if(prime[i] == true) 
                li.add(i);
        }
        return li;
    } 
  
  static class Paircomp implements Comparator<Pair> {

		@Override
		public int compare(Pair c, Pair d) {
		return c.a -d.a;
			
		}

	}
    static class Pair{
    	int a;
    	int b;
    	Pair(int x,int y)
    	{
    		a=x;
    		b=y;
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


