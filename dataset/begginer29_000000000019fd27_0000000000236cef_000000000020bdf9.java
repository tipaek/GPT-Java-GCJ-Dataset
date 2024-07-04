import java.util.*;
import java.lang.*;
import java.io.*;
public class Solution
{       static PrintWriter out=new PrintWriter(System.out);static FastScanner in = new FastScanner(System.in);static class FastScanner {BufferedReader br;StringTokenizer stok;FastScanner(InputStream is) {br = new BufferedReader(new InputStreamReader(is));}
        String next() throws IOException {while (stok == null || !stok.hasMoreTokens()) {String s = br.readLine();if (s == null) {return null;}
                stok = new StringTokenizer(s);}return stok.nextToken();}
        int ni() throws IOException {return Integer.parseInt(next());}long nl() throws IOException {return Long.parseLong(next());}double nd() throws IOException {return Double.parseDouble(next());}char nc() throws IOException {return (char) (br.read());}String ns() throws IOException {return br.readLine();}
        int[] nia(int n) throws IOException{int a[] = new int[n];for (int i = 0; i < n; i++)a[i] = ni();return a;}long[] nla(int n) throws IOException {long a[] = new long[n];for (int i = 0; i < n; i++)a[i] = nl();return a;}
        double[] nda(int n)throws IOException {double a[] = new double[n];for (int i = 0; i < n; i++)a[i] = nd();return a;}int [][] imat(int n,int m) throws IOException{int mat[][]=new int[n][m];for(int i=0;i<n;i++){for(int j=0;j<m;j++)mat[i][j]=ni();}return mat;}
    }
	static long mod=Long.MAX_VALUE;
	public static void main (String[] args) throws java.lang.Exception
	{   int i,j;
	    HashSet<Integer> set=new HashSet<Integer>();
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        int t=in.ni();
        for(int zz=1;zz<=t;zz++)
        {  
            int n=in.ni();
            pair p[]=new pair[n];
            for(i=0;i<n;i++)
                p[i]=new pair(in.ni(),in.ni(),i);
            Arrays.sort(p);
            int end1=-100,end2=-100;
            char temp[]=new char[n];
            ArrayList<Character> arr=new ArrayList<>();
            int flag=0;
            for(i=0;i<n;i++)
            {   if(end1<=p[i].x)
                {   temp[p[i].index]='C';
                    //arr.add('C');
                    end1=p[i].y;
                }
                else if(end2<=p[i].x)
                {   temp[p[i].index]='J';
                    //arr.add('J');
                    end2=p[i].y;
                }
                else
                    {flag=1;break;}
            }
            if(flag==1)
            {   out.println("Case #"+zz+": IMPOSSIBLE");
            }
            else
            {   out.print("Case #"+zz+": ");
                for(char c:temp)
                    out.print(c);
                out.println();    
            }
        }
        
        
        
        
        out.close();
	}
	static class pair implements Comparable<pair>{
		int x, y,index;
		public pair(int x, int y,int index){this.x = x; this.y = y;this.index=index;}
		@Override
		public int compareTo(pair arg0) 
		{   if(x<arg0.x)    return -1;
		    else if(x==arg0.x)
		    {   if(y<arg0.y)    return -1;
		        else if(y>arg0.y)   return 1;
		        else    return 0;
		    }
		    else    return 1;
		}
		public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof pair)) return false;
        pair key = (pair) o;
        return x == key.x && y == key.y;}
        public int hashCode() {int result = x;result = 31 * result + y;return result;}
	}
	static long gcd(long a,long b)
	{   if(b==0)
	        return a;
	    return gcd(b,a%b);    
	}
	static long exponent(long a,long n)
	{   long ans=1;
	    while(n!=0)
	    {   if(n%2==1)
	            ans=(ans*a)%mod;
	       a=(a*a)%mod;
	       n=n>>1;
	    }
	    return ans;
	}
	static int binarySearch(int a[], int item, int low, int high) 
    {   if (high <= low) 
            return (item > a[low])?  (low + 1): low; 
        int mid = (low + high)/2; 
        if(item == a[mid]) 
            return mid+1; 
        if(item > a[mid]) 
            return binarySearch(a, item, mid+1, high); 
        return binarySearch(a, item, low, mid-1); 
    } 
    static void merge(int arr[], int l, int m, int r) {   
        int n1 = m - l + 1; int n2 = r - m; int L[] = new int [n1]; int R[] = new int [n2]; 
        
        for (int i=0; i<n1; ++i) L[i] = arr[l + i]; for (int j=0; j<n2; ++j) R[j] = arr[m + 1+ j]; int i = 0, j = 0; int k = l; while (i < n1 && j < n2) {   if (L[i] <= R[j]) {   arr[k] = L[i]; i++; } else{   arr[k] = R[j]; j++; } k++; } while (i < n1){   arr[k] = L[i]; i++; k++; } while (j < n2) { arr[k] = R[j];   j++;     k++; } 
    } 
    static void Sort(int arr[], int l, int r) {if (l < r) {   int m = (l+r)/2; Sort(arr, l, m); Sort(arr , m+1, r); merge(arr, l, m, r); } } 
    
    static void sort(int a[])
    {Sort(a,0,a.length-1);}
}