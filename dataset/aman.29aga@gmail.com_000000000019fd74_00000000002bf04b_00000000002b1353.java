import java.io.*; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.*; 
import java.util.StringTokenizer; 

public class Solution
{ 
    static int MAXN=201;
    static int spf[] = new int[MAXN]; 
    static int ans[]=new int[MAXN];
    static HashSet s=new HashSet();
	static class FastReader 
	{ 
		BufferedReader br; 
		StringTokenizer st; 

		public FastReader() 
		{ 
			br = new BufferedReader(new
					InputStreamReader(System.in)); 
		} 

		String next() 
		{ 
			while (st == null || !st.hasMoreElements()) 
			{ 
				try
				{ 
					st = new StringTokenizer(br.readLine()); 
				} 
				catch (IOException e) 
				{ 
					e.printStackTrace(); 
				} 
			} 
			return st.nextToken(); 
		} 

		int nextInt() 
		{ 
			return Integer.parseInt(next()); 
		} 

		long nextLong() 
		{ 
			return Long.parseLong(next()); 
		} 

		double nextDouble() 
		{ 
			return Double.parseDouble(next()); 
		} 

		String nextLine() 
		{ 
			String str = ""; 
			try
			{ 
				str = br.readLine(); 
			} 
			catch (IOException e) 
			{ 
				e.printStackTrace(); 
			} 
			return str; 
		} 
	} 
    static void sieves() 
    { 
        spf[1] = 1; 
        for (int i=2; i<MAXN; i++) 
            spf[i] = i; 
        for (int i=4; i<MAXN; i+=2) 
            spf[i] = 2; 
        for (long i=3; i*i<MAXN; i++) 
        { 
            if (spf[(int)i] == i) 
            { 
                for (long j=i*i; j<MAXN; j+=i) 
                    if (spf[(int)j]==j) 
                        spf[(int)j] = (int)i; 
            } 
        } 
    } 
    static void getFactorizations(int x) 
    { 
        Vector<Integer> ret = new Vector<>(); 
        HashSet w=new HashSet();
        while (x != 1 && spf[x]!=1) 
        { 
            if(!w.contains(spf[x]) && spf[x]!=1)
            {
            w.add(spf[x]);
            ans[spf[x]]++; 
            }
            x = x / spf[x]; 
        }
    } 
	static int dp[][]=new int[501][501];
    static int row[]={-1,-1,0,0,1,1};
    static int col[]={-1,0,-1,1,0,1};
    static boolean vs[][];
    static ArrayList<Pair> res;
    public static void main(String args[])
    {
        FastReader sc=new FastReader();
        int T=sc.nextInt();
        int ct=1;
        dp[1][1]=1;
        for(int i=2;i<=500;i++)
        {
            for(int j=1;j<=i;j++)
            {
                dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
            }
        }
        while(T-->0)
        {
            int N=sc.nextInt();
            vs=new boolean[501][501];
            res=new ArrayList<>();
            ArrayList<Pair> al=new ArrayList<>();
            al.add(new Pair(1,1));
            System.out.println("Case #"+ct+": ");
            DFS(N-1,al,1,1,vs);
            for(int i=0;i<res.size();i++)
            System.out.println(res.get(i).x+" "+res.get(i).y);
            ct++;
        }
    }
    public static void DFS(int src,ArrayList<Pair> al,int x,int y,boolean vs[][])
    {
            vs[x][y]=true;
            if(src==0&&res.size()==0)
            {
                for(int i=0;i<al.size();i++)
                res.add(new Pair(al.get(i).x,al.get(i).y));
                return;
            }
            for(int i=0;i<6;i++)
            {
                int r=x+row[i];
                int c=y+col[i];
                if(check(r,c,vs,src))
                {
                    al.add(new Pair(r,c));
                    DFS(src-dp[r][c],al,r,c,vs);
                    al.remove(al.size()-1);
                }
            }
        
    }
    public static boolean check(int x,int y,boolean vs[][],int src)
    {
        if(x>=1&&x<=500&&y>=1&&y<=500&&!vs[x][y]&&src-dp[x][y]>=0&&dp[x][y]!=0&&res.size()==0)
        return true;
        return false;
        
    }
	public static void sieven(int n) 
    {
        boolean prime[] = new boolean[n+1]; 
        for(int i=0;i<n;i++) 
            prime[i] = true; 
        for(int p = 2; p*p <=n; p++) 
        { 
            if(prime[p] == true) 
            { 
                for(int i = p*2; i <= n; i += p) 
                    prime[i] = false; 
            } 
        } 
        for(int p=2; p<=n;p++)
        if(prime[p]==true)
        s.add(p);
    } 
	public static long gcd(long a,long b)
	{
	    if(b==0)
	    return a;
	    return gcd(b,a%b);
	}
	static long power(long x, long y, int p) 
    { 
        long res = 1;      
        x = x % p;  
        while (y > 0) 
        { 
            if((y & 1)==1) 
                res = (res * x) % p; 
            y = y >> 1;  
            x = (x * x) % p;  
        } 
        return res; 
    }
    static class Pair
	{ 
		int x; 
		int y;
		public Pair(int x, int y) 
		{	 
			this.x = x; 
			this.y = y; 
		}	 
	} 
    static class Compare
	{ 
		static void compare(Pair arr[], int n) 
		{ 
			// Comparator to sort the pair according to second element 
			Arrays.sort(arr, new Comparator<Pair>() { 
				@Override public int compare(Pair p1, Pair p2) 
				{ 
					if(p1.x>p2.x)
					{
						return 1;
					}
					else if(p2.x>p1.x)
					{
						return -1;
					}
					else
					{
						return 0;
					} 
				} 
			}); 
		} 
	}
}
