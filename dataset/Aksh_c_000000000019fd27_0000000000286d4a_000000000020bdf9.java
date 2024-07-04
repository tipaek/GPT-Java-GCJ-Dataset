import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.*; 
import java.util.StringTokenizer; 
import java.io.PrintWriter;
import java.io.*;
import java.util.stream.Collectors.*;
import java.lang.*;
import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;
public class Solution
{ 
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
                catch (IOException  e) 
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
   
static int power(int x,int y) 
{ 
    int res = 1;      // Initialize result 
  
      // Update x if it is more than or  
                // equal to p 
  
    while (y > 0) 
    { 
        // If y is odd, multiply x with result 
        if (y%2==1) 
            res = (res*x); 
  
        // y must be even now 
        y = y>>1; // y = y/2 
        x = (x*x);   
    } 
    return res; 
} 
 
 static long gcd(long a,long b) 
    { 
        if (a == 0) 
            return b; 
        return gcd(b % a, a); 
    } 
 
 
  static boolean compareSeq(char[] S, int x, int y, int n) 
    { 
        for (int i = 0; i < n; i++)
         {
 
            if (S[x] < S[y]) 
               return true;
            else if (S[x] > S[y]) 
                return false; 
            x = (x + 1) % n; 
            y = (y + 1) % n; 
        } 
        return true; 
    } 
 
    static void build(long[] sum,int[] arr,int n)
    {
      for(int i=0;i<(1<<n);i++)
      {
        long total=0;
        for(int j=0;j<n;j++)
        {
          if((i & (1 << j)) > 0)
            total+=arr[j];
        }
 
        sum[i]=total;
      }
    }

 
       static int parity(int a)
       {
    a^=a>>16;
    a^=a>>8;
    a^=a>>4;
    a^=a>>2;
    a^=a>>1;
    return a&1;
  }
/*
  PriorityQueue<aksh> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.p < o2.p)
                return 1;
            else if (o1.p > o2.p)
                return -1;
            else
                return 0;
 
        });//decreasing order acc to p*/
static int power(int x, int y, int m)  
    { 
        if (y == 0) 
            return 1; 
          
        int p = power(x, y / 2, m) % m; 
        p = (p * p) % m; 
      
        if (y % 2 == 0) 
            return p; 
        else
            return (x * p) % m; 
    } 
/*static int modinv(int a, int m) 
    { 
        int g = gcd(a, m); 
        if (g != 1) 
            return 0;
        else 
        { 
           return power(a, m - 2, m); 
        } 
        //return 0;
    } */
 
static int[] product(int[] nums) {
    int[] result = new int[nums.length];
 
    int[] t1 = new int[nums.length];
    int[] t2 = new int[nums.length];
 
    t1[0]=1;
    t2[nums.length-1]=1;
 
    //scan from left to right
    for(int i=0; i<nums.length-1; i++){
        t1[i+1] = nums[i] * t1[i];
    }
 
    //scan from right to left
    for(int i=nums.length-1; i>0; i--){
        t2[i-1] = t2[i] * nums[i];
    }
 
    for(int i=0;i<nums.length;i++)
      {
        System.out.print(t1[i]+" "+t2[i]);
        System.out.println();
      }
 
    //multiply
    for(int i=0; i<nums.length; i++){
        result[i] = t1[i] * t2[i];
    }
 
    return result;
}
 
static int getsum(int[] bit,int ind)
{
  int sum=0;
  while(ind>0)
  {
    sum+=bit[ind];
    ind-= ind & (-ind);
  }
 
  return sum;
}
 
static void update(int[] bit,int max,int ind,int val)
{
  while(ind<=max)
  {
    bit[ind]+=val;
    ind+= ind & (-ind);
  }
}
 
    //static ArrayList<Integer>[] adj;
 
    static boolean check(long mid,long a,long b)
    {
      long count=1;
      while(count<=mid)
      {
        count++;
        if(a<b)
          a+=count;
        else
          b+=count;
 
        if(a==b)
          return true;
      }
        return false;
    }
 
    static class aksh implements Comparable<aksh>
    {
      int x;
      int y;
      public aksh(int x,int y)
      {
        this.x=x;
        this.y=y;
      }
      public int compareTo(aksh o)
      {
        if(x!=o.x)
          return x-o.x;
        else
          return y-o.y;
      }
    }
    static int get(int arr[], int n) 
    { 
        int result = 0; 
        int x, sum; 
          
        // Iterate through every bit 
        for(int i=0; i<32; i++) 
        { 
            // Find sum of set bits at ith position in all  
            // array elements 
            sum = 0; 
            x = (1 << i); 
            for(int j=0; j<n; j++) 
            { 
                if((arr[j] & x)!=0) 
                sum++; 
            }  
            if ((sum % 3)!=0) 
            result |= x; 
        } 
        return result; 
    }
 
    static boolean isPrime(int n)  
    {  
        // Corner cases  
        if (n <= 1) return false;  
        if (n <= 3) return true;  
          
        // This is checked so that we can skip  
        // middle five numbers in below loop  
        if (n % 2 == 0 || n % 3 == 0) return false;  
          
        for (int i = 5; i * i <= n; i = i + 6)  
            if (n % i == 0 || n % (i + 2) == 0)  
            return false;  
          
        return true;  
    }  
      
    static int nextPrime(int N)  
    {  
      
        // Base case  
        if (N <= 1)  
            return (2-N);  
      
        int prime = N;  
        boolean found = false;    
        while (!found)  
        {  
            if (isPrime(prime))  
                {
                  found = true;
                  break;
                }  
 
            prime++;
        }  
      
        return (prime-N);  
    }  
 
 
    static long product(long x) 
{ 
    long prod = 1; 
    while (x > 0)  
    { 
        prod *= (x % 10); 
        x /= 10; 
    } 
    return prod; 
} 
  
// This function returns the number having 
// maximum product of the digits 
static long findNumber(long l, long r) 
{ 
    // Converting both integers to strings 
    //string a = l.ToString(); 
    String b = Long.toString(r); 
  
    // Let the current answer be r 
    long ans = r; 
    for (int i = 0; i < b.length(); i++)  
    { 
        if (b.charAt(i) == '0') 
            continue; 
  
        // Stores the current number having 
        // current digit one less than current 
        // digit in b 
        char[] curr = b.toCharArray(); 
        curr[i] = (char)(((int)(curr[i] -  
                    (int)'0') - 1) + (int)('0')); 
  
        // Replace all following digits with 9 
        // to maximise the product 
        for (int j = i + 1; j < curr.length; j++) 
            curr[j] = '9'; 
  
        // Convert string to number 
        int num = 0; 
        for (int j = 0; j < curr.length; j++) 
            num = num * 10 + (curr[j] - '0'); 
  
        // Check if it lies in range and its product 
        // is greater than max product 
        if (num >= l && product(ans) < product(num)) 
            ans = num; 
    } 
  
    return product(ans); 
} 
 
static long mod=998244353;
 
static long pow(long in, long pow) {
    if(pow == 0) return 1;
    long out = pow(in, pow / 2);
    out = (out * out) % mod;
    if(pow % 2 == 1) out = (out * in) % mod;
    return out;
  }
  static long inv(long in) {
    return pow(in, mod - 2);
  }
 
  static void swap(int x,int y)
  {
    int temp=x;
    x=y;
    y=temp;
  }
 
  static int[] par;
  static int[] size;
  static int find(int i) 
  {
     if (par[i] == i)
      return i;
 
    return par[i] = find(par[par[i]]);
  }
 
  static void union(int x, int y) 
  {
      x = find(x);
      y = find(y);
      if (x == y)
        return;
      if (size[x] < size[y])
        swap(x, y);
 
      par[y] = x;
      size[x] += size[y];
    }
 
 
    static void multisourcebfs(long[] arr,int n,int m)
    {
      //HashSet<Long> vis=new HashSet<>();
      HashMap<Long,Long> dis=new HashMap<>();
      Queue<Long> q=new LinkedList<>();
 
      for(int i=0;i<arr.length;i++)
      {
        dis.put(arr[i],(long)0);
        q.add(arr[i]);
        //vis.add(arr[i]);
      }
 
      long[] res=new long[m];
      long ans=0;
      int k=0;
      while(!q.isEmpty())
      {
        if(k==m)
          break;
        long x=q.remove();
        if(dis.get(x)!=0)
        {
          ans+=dis.get(x);
          res[k]=x;
          k++;
        }
 
        if(dis.get(x-1)==null)
        {
          dis.put(x-1, dis.get(x)+1);
          q.add(x-1);
          //vis.add(x-1);
        }
 
        if(dis.get(x+1)==null)
        {
          dis.put(x+1, dis.get(x)+1);
          q.add(x+1);
          //vis.add(x+1);
        }
      }
 
      System.out.println(ans);
 
      for(int i=0;i<m;i++)
        System.out.print(res[i]+" ");
 
    }
 
    static int x; 
    static int maxcount=0;
    static void dfs(int node,int par,int dist)
    {
        if(dist>=maxcount)
        {
           maxcount=dist;
           x=node;
        }
 
        List<Integer> l = adj[node]; 
        for(Integer i: l)
        {
          if(i!=par)
          dfs(i,node,dist+1);
        }
    }

    

    static int h;
    static int w;
    static int bfs(char[][] ch,int i,int j)
    {
        Queue<aksh> q=new LinkedList<>();
        q.add(new aksh(i,j));

        int[][] dis=new int[h][w];
        int[][] vis=new int[h][w];
        vis[i][j]=1;
        dis[i][j]=0;
 
        while(!q.isEmpty())
        {
          aksh arr=q.poll();
          int x1=arr.x;
          int y1=arr.y;
 
          if((x1-1)>=0 && ch[x1-1][y1]!='#' && vis[x1-1][y1]==0)
          {
            vis[x1-1][y1]=1;
            q.add(new aksh(x1-1, y1));
            dis[x1-1][y1]=Math.max(dis[x1-1][y1],dis[x1][y1]+1);
          }
 
          if((x1+1)<h && ch[x1+1][y1]!='#' && vis[x1+1][y1]==0)
          {
            vis[x1+1][y1]=1;
            dis[x1+1][y1]=Math.max(dis[x1+1][y1],dis[x1][y1]+1);
            q.add(new aksh(x1+1, y1));
          }
 
          if((y1-1)>=0 && ch[x1][y1-1]!='#' && vis[x1][y1-1]==0)
          {
            vis[x1][y1-1]=1;
            dis[x1][y1-1]=Math.max(dis[x1][y1-1],dis[x1][y1]+1);
            q.add(new aksh(x1,y1-1));
          }
 
    
          if((y1+1)<w && ch[x1][y1+1]!='#' && vis[x1][y1+1]==0)
          {
            vis[x1][y1+1]=1;
            dis[x1][y1+1]=Math.max(dis[x1][y1+1],dis[x1][y1]+1);
            q.add(new aksh(x1,y1+1));
          }
        }
        int max=Integer.MIN_VALUE;

        for(int x=0;x<h;x++)
        {
          for(int y=0;y<w;y++)
            max=Math.max(dis[x][y],max);
        }

        return max;
    }

    static ArrayList<Integer> cnt;

    static void primefact(int n)
    {
 
          for (int i=2;i*i<=n;i++)
           {
              while ((n % i)==0)
              {
                cnt.add(i);
                n /= i;
              }
           }

          if(n>1)
             {
              cnt.add(n);
             }
    }

    static boolean hash[];
    static void sieve(int n)
    {
      Arrays.fill(hash, true);
    for (int p = 2; p * p < n; p++) 
        if (hash[p] == true) 
            for (int i = p * 2; i < n; i += p) 
                hash[i] = false; 
    }

    static long div(long n) 
  {
    long total = 1; 
    for (int p = 2; p <= n; p++)  
    { 
        if (hash[p]) 
        { 
            int count = 0; 
            if (n % p == 0)  
            { 
                while (n % p == 0)  
                { 
                    n = n / p; 
                    count++; 
                } 
                total = total * (count + 1); 
            } 
        } 
    } 
    return total; 
} 


    
    static  int upperbound(ArrayList<Integer> array, int length, int value) 
    {
        int low = 0;
        int high = length;
        while (low < high) {
            final int mid = (low + high) / 2;
            if (value >= array.get(mid)) 
            {
                low = mid + 1;
            } 
            else
            {
                high = mid;
            }
        }
        return low;
    }

     static int[][] dp;

    static void func(int[][] a,int n,int k,int p)
    {
              for (int i = 1; i < n; i++)
                for (int j = 1; j <= Math.min((i + 1) * k, p); j++)
                   for (int t2 = 0; t2 <= Math.min(k, Math.min(j, p)); t2++)
                     {
                         int aksh = 0;
                         if (t2!=0)
                         aksh = a[i][t2 - 1];

                         dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - t2] + aksh);
                      }
    }


    static final long INF = Long.MAX_VALUE/5;
    static ArrayList<Integer>[] adj;
    static long binpow(long a, long b)
    {
       long res = 1;
       while (b > 0) 
       {
        if ((b & 1) !=0)
            res = res * a;
        a = a * a;
        b >>= 1;
        }
    return res;
    }

    static int upper(int[] array, int length, int value) {
        int low = 0;
        int high = length;
        while (low < high) {
            final int mid = (low + high) / 2;
            if (value >= array[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    static int ans=0;
    static void bs(ArrayList<Integer> arr, int max, int k,int n)
    {
            int l= 1;
            int h= max;
            ans = h;

            while (l<=h)
           {
               int m = (l+h)/2;
               int r = 0;

               for (int i = 0; i < n; ++i)
                {
                  r += (arr.get(i) + m - 1) / m;
                  r--;
                }

               if(r <= k)
                  {
                    ans = m;
                    h = m - 1;
                  }
               else
                  l=m+1;
            }
    }
    static public void merge(int[][] arr) 
    {
        int n=arr[0].length;
        aksh[] a=new aksh[n];
        
        for(int i=0;i<n;i++)
            a[i]=new aksh(arr[i][0],arr[i][1]);
        
        Arrays.sort(a);
        Stack<aksh> s=new Stack<>();
        s.push(a[0]);
        
        for(int i=1;i<n;i++)
        {
            aksh temp=s.peek();
            if(temp.y>a[i].x)
            {
                temp.y=a[i].y;
                s.pop();
                s.push(temp);
            }
            else if(temp.y<a[i].x)
            {
                s.push(a[i]);
                System.out.println("hii");
            }
        }
        
        int size=s.size();
        int[][] ans=new int[size][2];
        int j=0;
        while(!s.isEmpty())
        {
            aksh temp=s.pop();
            ans[j][0]=temp.x;
            ans[j][1]=temp.y;
            j++;
        }  
        
    }

    static boolean pal(String s)
    {
      int n=s.length();
      int l=0;
      int r=n-1;
      int flag=0;
      while(l<r)
      {
        if(s.charAt(l)==s.charAt(r))
        {
          l++;
          r--;
        }
        else
          {
            flag=1;
            break;
          }
      }

      if(flag==1)
        return false;
      else
        return true;
    }   
    
    public static void main(String args[] ) throws Exception 
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        FastReader sc=new FastReader();
        int t=sc.nextInt();

        for(int t1=1;t1<=t;t1++)
        {
          int n=sc.nextInt();
          aksh[] a=new aksh[n];

          for(int i=0;i<n;i++)
          {
            int a1=sc.nextInt();
            int a2=sc.nextInt();
            a[i]=new aksh(a1,a2);
          }
          Arrays.sort(a);
          int e1=a[0].y;
          int e2=0;
          int flag=0;
          StringBuilder ans=new StringBuilder("C");
          for(int i=1;i<n;i++)
          {
            if(a[i].x>=e1)
            {
              ans.append("C");
              e1=a[i].y;
            }
            else if(a[i].x>=e2)
            {
              ans.append("J");
              e2=a[i].y;
            }
            else
              flag=1;
          }

          if(flag==0)
             System.out.println("Case #"+t1+": "+ans.toString());
          else
            System.out.println("Case #"+t1+": "+"IMPOSSIBLE");

        }

    }
 }
