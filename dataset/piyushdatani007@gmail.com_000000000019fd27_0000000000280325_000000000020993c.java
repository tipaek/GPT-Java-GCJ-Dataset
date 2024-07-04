    import java.util.*;
    import java.io.*;
    import java.math.*;
    import java.math.BigInteger;
    import java.text.DecimalFormat;
     
        class Main {
    	   		static ArrayList<String> arr=new ArrayList<>();
    			public static void main(String args[])
    		    {    				
    		    	InputReader in = new InputReader(System.in);
    		  	  	OutputStream outputStream = System.out;
    		  	  	PrintWriter out = new PrintWriter(outputStream); 
    		  	  	int t=in.nextInt();
    		  	  	int t1=t;
    		  	  	while(t-->0)
    		  	  	{
    		  	  	    int n=in.nextInt();
    		  	  	    int arr[][]=new int[n][n];
    		  	  	    int trace=0;
    		  	  	    int row=0;
    		  	  	    int col=0;
    		  	  	    for(int i=0;i<n;i++)
    		  	  	    {
    		  	  	        for(int j=0;j<n;j++)
    		  	  	        {
    		  	  	            arr[i][j]=in.nextInt();
    		  	  	        }
    		  	  	    }
    		  	  	    for(int i=0;i<n;i++)
    		  	  	    {
    		  	  	        HashMap<Integer,Integer> h=new HashMap<>();
    		  	  	        for(int j=0;j<n;j++)
    		  	  	        {
    		  	  	            if(!h.containsKey(arr[i][j]))
    		  	  	            {
    		  	  	                h.put(arr[i][j],1);
    		  	  	            }
    		  	  	            else
    		  	  	            {
    		  	  	                row++;
    		  	  	                break;
    		  	  	            }
    		  	  	        }
    		  	  	    }
    		  	  	    for(int i=0;i<n;i++)
    		  	  	    {
    		  	  	        HashMap<Integer,Integer> h=new HashMap<>();
    		  	  	        for(int j=0;j<n;j++)
    		  	  	        {
    		  	  	            if(!h.containsKey(arr[j][i]))
    		  	  	            {
    		  	  	                h.put(arr[j][i],1);
    		  	  	            }
    		  	  	            else
    		  	  	            {
    		  	  	                col++;
    		  	  	                break;
    		  	  	            }
    		  	  	        }
    		  	  	    }
    		  	  	    for(int i=0;i<n;i++)
    		  	  	    {
    		  	  	        for(int j=0;j<n;j++)
    		  	  	        {
    		  	  	            if(i==j)
    		  	  	            {
    		  	  	                trace+=arr[i][j];
    		  	  	            }
    		  	  	        }
    		  	  	    }
    		  	  	    out.println("Case #"+(t1-t)+": "+trace+" "+row+" "+col);
    		  	  	}
    		  	  	out.close();
    		    }    		
//    		    static int bs1(int n,int l,int r)
//    		    {
//    		    	long mid=(l+r)/2;
//    		    	if(l>r)
//    		    		return ans;		    	
//    		    	if(mid*(mid+1)==n)
//    		    	{
//    		    		return (int)mid;
//    		    	}
//    		    	else if(mid*(mid+1)<n)
//    		    	{
//    		    		ans=(int)mid;
//    		    		return bs1(n,(int)mid+1,r);
//    		    	}
//    		    	else
//    		    	{
//    		    		return bs1(n,l,(int)mid-1);
//    		    	}
//    		    }
    		    static int floorSearch(int arr[], int low, int high, int x)
    		    {
    		    	int ans=-1;
    		    	while(low<high)
    		    	{
    		    		// If last element is smaller than x
    		    		if (x >= arr[high])
    		    			return high;
    		    		int mid=(low)+(high-low)/2;
    		    		if(arr[mid]<=x)
    		    		{
    		    			ans=mid;
    		    			low=mid+1;
    		    		}
    		    		else
    		    		{
    		    			high=mid-1;
    		    		}
    		    	}
    		    	return ans;
    		    }
    		    void findFactors(int[] primeDivisors, int[] multiplicity, int currentDivisor, long currentResult) {
    		        if (currentDivisor == primeDivisors.length) {
    		            // no more balls
    		            System.out.println(currentResult);
    		            return;
    		        }
    		        // how many times will we take current divisor?
    		        // we have to try all options
    		        for (int i = 0; i <= multiplicity[currentDivisor]; ++i) {
    		            findFactors(primeDivisors, multiplicity, currentDivisor + 1, currentResult);
    		            currentResult *= primeDivisors[currentDivisor];
    		        }
    		    }
    		    static int ceilSearch(long arr[], int low, int high, long x)
    		    {
    		      
    		      int mid;    
    		     
    		      /* If x is smaller than or equal to the first element,
    		        then return the first element */
    		      if(x <= arr[low])
    		        return low; 
    		     
    		      /* If x is greater than the last element, then return -1 */
    		      if(x > arr[high])
    		        return -1;  
    		     
    		      /* get the index of middle element of arr[low..high]*/
    		      mid = (low + high)/2;  /* low + (high - low)/2 */
    		     
    		      /* If x is same as middle element, then return mid */
    		      if(arr[mid] == x)
    		        return mid;
    		         
    		      /* If x is greater than arr[mid], then either arr[mid + 1]
    		        is ceiling of x or ceiling lies in arr[mid+1...high] */ 
    		      else if(arr[mid] < x)
    		      {
    		        if(mid + 1 <= high && x <= arr[mid+1])
    		          return mid + 1;
    		        else
    		          return ceilSearch(arr, mid+1, high, x);
    		      }
    		     
    		      /* If x is smaller than arr[mid], then either arr[mid] 
    		         is ceiling of x or ceiling lies in arr[mid-1...high] */   
    		      else
    		      {
    		        if(mid - 1 >= low && x > arr[mid-1])
    		          return mid;
    		        else    
    		          return ceilSearch(arr, low, mid - 1, x);
    		      }
    		    }
    		    public static long find_ncr(long n, long r) {
    		    	long result=1;
    		    	   System.out.println(factorial(29));
    		    	   result = factorial(n)/(factorial(r)*factorial(n-r));
    		    	 
    		    	   return result;
    		    	}
    		   public static long factorial(long n) {
    		    	   long c;
    		    	   long result = 1;
    		    	 
    		    	   for (c = 1; c <= n; c++)
    		    	      result = result*c;
    		    	 
    		    	   return result;
    		    	}
//    		    public static long power(long base, long exp) {
////    		        long res=1;
////    		        while(exp>0) {
////    		           if(exp%2==1) res=(res*base)%MOD;
////    		           base=(base*base)%MOD;
////    		           exp/=2;
////    		        }
////    		        return res%MOD;
////    		    }
    	public static void computeLPSArray(String pat, int M, int lps[])
        {
            // length of the previous longest prefix suffix
            int len = 0;
            int i = 1;
            lps[0] = 0;  // lps[0] is always 0
     
            // the loop calculates lps[i] for i = 1 to M-1
            while (i < M)
            {
                if (pat.charAt(i) == pat.charAt(len))
                {
                    len++;
                    lps[i] = len;
                    i++;
                }
                else  // (pat[i] != pat[len])
                {
                    // This is tricky. Consider the example.
                    // AAACAAAA and i = 7. The idea is similar 
                    // to search step.
                    if (len != 0)
                    {
                        len = lps[len-1];
     
                        // Also, note that we do not increment
                        // i here
                    }
                    else  // if (len == 0)
                    {
                        lps[i] = len;
                        i++;
                    }
                }
            }
        }
    	 	public static void KMPSearch(String pat, String txt)
    	    {
    	 		System.out.println("sdfsdf");
    	        int M = pat.length();
    	        int N = txt.length();
    	 
    	        // create lps[] that will hold the longest
    	        // prefix suffix values for pattern
    	        int lps[] = new int[M];
    	        int j = 0;  // index for pat[]
    	 
    	        // Preprocess the pattern (calculate lps[]
    	        // array)
    	        computeLPSArray(pat,M,lps);	 
    	        int i = 0;  // index for txt[]
    	        while (i < N)
    	        {
    	            if (pat.charAt(j) == txt.charAt(i))
    	            {
    	                j++;
    	                i++;
    	            }
    	            if (j == M)
    	            {
    	                System.out.println("Found pattern "+
    	                              "at index " + (i-j));
    	                j = lps[j-1];
    	            }
    	 
    	            // mismatch after j matches
    	            else if (i < N && pat.charAt(j) != txt.charAt(i))
    	            {
    	                // Do not match lps[0..lps[j-1]] characters,
    	                // they will match anyway
    	                if (j != 0)
    	                    j = lps[j-1];
    	                else
    	                    i = i+1;
    	            }
    	        }
    	    }
//    	public static long power(long i)
//    	{
//    		long c=1;
//    		while(i>1)
//    		{
//    			c=((c%MOD)*(2%MOD))%MOD;
//    			i--;
//    		}
//    		return c;
//    	}
    	public static long gcd(long p, long q) {
            if (q == 0) {
                    return p;
            }
            return gcd(q, p % q);
    }
    	static int mid=-1;
    	static int find(int arr[],int k,int f,int l)
    	{
    		if(f>l)
    			return mid;
    		mid=(f+l)/2;
    		if(arr[mid]==k)
    			return mid;
    		if(arr[mid]<k)
    		{
    			f=mid;
    			return find(arr,k,f,l);
    		}
    		else
    		{
    			l=mid;
    			return find(arr,k,f,l);
    		}
    	}
//    public static int[] createSegmentTree(int[] arr){
//    		
//    		int height = (int)Math.ceil(Math.log(arr.length)/Math.log(2));
//    		int segmentTree[] = new int[(int)(Math.pow(2, height+1)-1)];
//            
//            Arrays.fill(segmentTree, 0);
//            
//            constructMinSegmentTree(segmentTree, arr, 0, arr.length - 1, 0);
//            return segmentTree;
//        }
//     
//        public static void updateSegmentTreeRange(int[] arr, int segmentTree[], int startRange, int endRange) {
//            updateSegmentTreeRange(segmentTree,arr, startRange, endRange, 0, arr.length - 1, 0);
//        }
     
        public static int rangeMinimumQuery(int []segmentTree,int qlow,int qhigh,int len){
            return rangeMinimumQuery(segmentTree,0,len-1,qlow,qhigh,0);
        }
     
//        public static void constructMinSegmentTree(int segmentTree[], int[] arr, int low, int high,int pos){
//            if(low == high){
//                if(!prime[arr[low]] && !prime[arr[low]+1]){
//                	segmentTree[pos] = 1;
//                }
//                else if(prime[arr[low]] && prime[arr[low]+1])
//                	segmentTree[pos] = 1;
//                return;
//            }
//            
//            int mid = (low + high)/2;
//            constructMinSegmentTree(segmentTree, arr, low, mid, 2 * pos + 1);
//            constructMinSegmentTree(segmentTree, arr, mid + 1, high, 2 * pos + 2);
//            segmentTree[pos] = segmentTree[2*pos+1] + segmentTree[2*pos+2];
//        }
     
//    	public static void updateSegmentTreeRange(int segmentTree[],int arr[], int startRange, int endRange, int low, int high, int pos) {
//    		if(low > high || startRange > high || endRange < low ) {
//    			return;
//    		}
//     
//    		if(low == high) {
//    			if(!prime[arr[low]] && !prime[arr[low]+1]){
//                	segmentTree[pos] = 1;
//                }
//    			else if(prime[arr[low]] && prime[arr[low]+1])
//                	segmentTree[pos] = 1;
//                else
//                	segmentTree[pos] = 0;
//    			return;
//    		}
//     
//    		int middle = (low + high)/2;
//    		updateSegmentTreeRange(segmentTree,arr, startRange, endRange, low, middle, 2 * pos + 1);
//    		updateSegmentTreeRange(segmentTree,arr, startRange, endRange, middle + 1, high, 2 * pos + 2);
//    		segmentTree[pos] = segmentTree[2*pos+1] + segmentTree[2*pos+2];
//    	}
     
    	public static int rangeMinimumQuery(int segmentTree[],int low,int high,int qlow,int qhigh,int pos){
    		if(qlow <= low && qhigh >= high){
    			return segmentTree[pos];
    		}
    		if(qlow > high || qhigh < low){
    			return 0;
    		}
    		int mid = (low + high)/2;
    		return rangeMinimumQuery(segmentTree, low, mid, qlow, qhigh, 2 * pos + 1)+
    				rangeMinimumQuery(segmentTree, mid + 1, high, qlow, qhigh, 2 * pos + 2);
    	}
    	static void merge(long arr[], int l, int m, int r)
    	{
    	    int i, j, k;
    	    int n1 = m - l + 1;
    	    int n2 =  r - m;
    	 
    	    /* create temp arrays */
    	    long L[]=new long[n1];
    	    long R[]=new long[n2];
    	 
    	    /* Copy data to temp arrays L[] and R[] */
    	    for (i = 0; i < n1; i++)
    	        L[i] = arr[l + i];
    	    for (j = 0; j < n2; j++)
    	        R[j] = arr[m + 1+ j];
    	 
    	    /* Merge the temp arrays back into arr[l..r]*/
    	    i = 0; // Initial index of first subarray
    	    j = 0; // Initial index of second subarray
    	    k = l; // Initial index of merged subarray
    	    while (i < n1 && j < n2)
    	    {
    	        if (L[i] <= R[j])
    	        {
    	            arr[k] = L[i];
    	            i++;
    	        }
    	        else
    	        {
    	            arr[k] = R[j];
    	            j++;
    	        }
    	        k++;
    	    }
    	 
    	    /* Copy the remaining elements of L[], if there
    	       are any */
    	    while (i < n1)
    	    {
    	        arr[k] = L[i];
    	        i++;
    	        k++;
    	    }
    	 
    	    /* Copy the remaining elements of R[], if there
    	       are any */
    	    while (j < n2)
    	    {
    	        arr[k] = R[j];
    	        j++;
    	        k++;
    	    }
    	}
    	 
    	/* l is for left index and r is right index of the
    	   sub-array of arr to be sorted */
    	static void mergeSort(long arr[], int l, int r)
    	{
    	    if (l < r)
    	    {
    	        // Same as (l+r)/2, but avoids overflow for
    	        // large l and h
    	        int m = l+(r-l)/2;
    	 
    	        // Sort first and second halves
    	        mergeSort(arr, l, m);
    	        mergeSort(arr, m+1, r);
    	 
    	        merge(arr, l, m, r);
    	    }
    	}
    	private static int[] nextIntArray(InputReader in,int n)	
    	{
    		int[] a=new int[n];
    		for(int i=0;i<n;i++)
    			a[i]=in.nextInt();
    		return a;
    	}
    	public static double dis(double x1,double x2,double y1)
    	{
    		return Math.sqrt(((x1-x2)*(x1-x2))+(y1*y1));
    	}
    	private static String[] nextStringArray(InputReader in,int n)	
    	{
    		String[] a=new String[n];
    		for(int i=0;i<n;i++)
    			a[i]=in.next();
    		return a;
    	}
    	private static void show(int[] a)
    	{
    		for(int i=0;i<a.length;i++)
    			System.out.print(a[i]+" ");
    		System.out.println();
    	}
    	private static void show2DArray(char[][] a)
    	{
    		for(int i=0;i<a.length;i++)
    		{
    			for(int j=0;j<a[0].length;j++)
    				System.out.print(a[i][j]);
    			System.out.println();
    		}
    	}
     static long fact(long x)
     {
    	 long i=x,mul=1;
    	 while(i>0)
    	 {
    		 mul=(mul%1000000007)*(i%1000000007)%1000000007;
    		 i--;
    	 }
    	 return mul;
     }
     static class LengthComparator implements Comparator<String> {
    	    public int compare(String arg0, String arg1) {
    		// Use Integer.compare to compare the two Strings' lengths.
    		return (arg0+arg1).compareTo(arg1+arg0);
    	    }
    	}
    // static long output(ArrayList<Integer> h[],int j,boolean[] v)
    // {
    //	 int k;
    //	 v[j]=true;
    //	 sum++;
    //	 for(k=0;k<h[j].size();k++)
    //	 {
    //		 if(v[h[j].get(k)]==false)
    //		 {
    //			 output(h,h[j].get(k),v);
    //		 }
    //	 }
    //	 return sum;
    // }
     static long func(boolean v[],int j,ArrayList<Integer> h[],long ban[])
     {
    	 	v[j]=true;
    	 	 int k;
    	 	long sum=0;
    	    sum=sum+ban[j];
    	 	//System.out.println(h[j].size());
    	 	for(k=0;k<h[j].size();k++)
    	 	{
    	 		if(v[h[j].get(k)]==false)
    	 		{
    	 			v[h[j].get(k)]=true;
    	 			sum+=func(v,h[j].get(k),h,ban);
    	 		}
    	 	}
    	 	return sum;
     }
    /*static class Graph {
        	
        	private static Deque<Integer> stack = new ArrayDeque<Integer>();
     		private int least,count,v;
     		
    		Set<Integer>[] cities;
        	private int[] risk;
        	
        	Graph(int n,String[] risk){
        		
        		cities = new HashSet[n];
        		this.risk = new int[n];
        		for(int i =0;i<n;i++){
        			cities[i] = new HashSet<>();
        		}
        		for(int i =0;i<n;i++){
        			this.risk[i] = Integer.parseInt(risk[i]);
        		}
        		visited = new boolean[n];
        	}
        	
        	
        	public void add(int x,int y){
        		cities[x].add(y);
        		cities[y].add(x);
        	}
    }*/
    	static int root(int arr[],int i)
    	{
    		while(arr[i]!=i)
    		{
    			i=arr[i];
    		}
    		return i;
    	}
    	static boolean find(int arr[],int a,int b)
    	{
    		if(root(arr,a)==root(arr,b))
    		{
    			return true;
    		}
    		else
    			return false;
    	}
    	static void weighted_union(int arr[],int size[],int a,int b)
    	{
    		int root_a=root(arr,a);
    		int root_b=root(arr,b);
    		if(root_a!=root_b)
    		{
    			if(size[root_a]<size[root_b])
    			{
    				arr[root_a]=arr[root_b];
    				size[root_b]+=size[root_a];
    			}
    			else
    			{
    				arr[root_b]=arr[root_a];
    				size[root_a]+=size[root_b];
    			}
    		//	count--;
    		}
    	}
    	static class Pair implements Comparable<Pair>
    	{
    		private long first;
    		private long index;
    		//private long second;;
     
    		public Pair(long i, long j) 
    		{ 
    			this.first = i;
    			this.index = j;
    		}
    		public Pair() {
    			// TODO Auto-generated constructor stub
    		}
    		public long getFirst() { return first; }
    		//public long getSecond() { return second; }
    		public long getIndex() { return index ;}
    		public void setFirst(long k) { this.first=k ; }
    		public void setIndex(long k) { this.index=k ;}
    		//public void setSecond(long k) { this.second=k ;}
    		@Override
    		public int compareTo(Pair o) 
    		{
    			return Long.compare(this.first, o.first);
    		}
    	}
    	static class InputReader {
    		public BufferedReader reader;
    		public StringTokenizer tokenizer;
     
    		public InputReader(InputStream inputstream) {
    			reader = new BufferedReader(new InputStreamReader(inputstream));
    			tokenizer = null;
    		}
     
    		public String nextLine(){
    			String fullLine=null;
    			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
    				try {
    					fullLine=reader.readLine();
    				} catch (IOException e) {
    					throw new RuntimeException(e);
    				}
    				return fullLine;
    			}
    			return fullLine;
    		}
    		public String next() {
    			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
    				try {
    					tokenizer = new StringTokenizer(reader.readLine());
    				} catch (IOException e) {
    					throw new RuntimeException(e);
    				}
    			}
    			return tokenizer.nextToken();
    		}
    		public long nextLong() {
    			return Long.parseLong(next());
    		}
    		public int nextInt() {
    			return Integer.parseInt(next());
    		}
    	}
    }