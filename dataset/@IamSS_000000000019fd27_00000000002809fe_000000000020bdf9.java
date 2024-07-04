// Nice question failed a lot but learned a lot
import java.util.*;
import java.io.*;
public class Solution{ 
static PrintWriter out = new PrintWriter(System.out);
static boolean flag=true;
static void dfs(LinkedList<Integer> l[],int s,int col[]){
    
                      
                        for(Integer i: l[s]){
                            if(col[i]==-1){
                               col[i]=1-col[s];                              
                               dfs(l,i,col);
                            }
                          else if(col[i]==col[s]){
                                 flag=false;
                                 return;     
                             }
                       }             
}
static boolean testOverlap(int x1, int x2, int y1, int y2) {
  return (x1 >= y1 && x1 <= y2) ||
         (x2 >= y1 && x2 <= y2) ||
         (y1 >= x1 && y1 <= x2) ||
         (y2 >= x1 && y2 <= x2);
}
static void solve() throws Exception{

int t = ni();
for(int o=1;o<=t;o++)
{
      int n = ni();
      int s[] = new int[n];
      int e[] = new int[n];
      for(int i=0;i<n;i++)
          {
                 s[i] = ni()+1;
                 e[i] = ni();
          }
      LinkedList<Integer> l[] = new LinkedList[n];
         int col[] = new int[n];
         for(int i=0;i<n;i++){
              l[i] = new LinkedList();
              col[i]=-1;
          }
         for(int i=0;i<n;i++)
           for(int j=i+1;j<n;j++)
              {
                   if(testOverlap(s[i],e[i],s[j],e[j])){
                       //  System.out.println("i :"+i+" j :"+j);
                         l[i].add(j);
                         l[j].add(i);
                   }
              }
          
                   for(int i=0;i<n;i++)
                       if(col[i]==-1)
                        {
                             col[i]=1; 
                             dfs(l,i,col) ;    
                             if(flag==false) break;
                        }
     if(flag==false)
         pn("Case #"+o+": IMPOSSIBLE");
     else{
        
         String res ="";
         for(int i=0;i<n;i++){
             if(col[i]==1)
                res=res+'J';
             else
                res =res+'C';
         }
         pn("Case #"+o+": "+res);   
     }
  flag=true;
}
   out.flush();
}
public static void main(String[] args){

// use this block when you need more recursion depth
new Thread(null, null, "Name", 99999999) {
            public void run() {
                try {
                    solve();
                } catch(Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }.start(); 
} 
static int[] ai(int n)  // it will give in array of size n
{
    int a[] = new int[n];
    for(int i=0;i<n;i++)
        a[i] = ni();
    return a;
}
static long[] al(int n)  // it will give in array of size n
{
    long a[] = new long[n];
    for(int i=0;i<n;i++)
        a[i] = nl();
    return a;
}
 
static void p(Object o)
{
   out.print(o);
}
static void pn(Object o)
{
    out.println(o);
}
static int abs(int x)
{
    return x>0 ? x : -x;
}
static long gcd(long a,long b)
{
       if(b%a==0)
          return a;
          return gcd(b%a,a);
}
static int count_set(int n)
{
   int c=0;
while(n>0)
{
   if(n%2==1)
     c++;
     n=n/2;
}
   return c;
}
static void subtract_1(char s[]) // it will subtract 1 from the given number.  number should be positive
{
      if(s[0]=='0') // number is zero
          return;
     int n = s.length,i=n-1;
     while(s[i]=='0')
       i--;
     s[i] = (char)((int)(s[i]-'0') + 47);
   
     for(int j=i+1;j<n;j++)
         s[j]='9';
}
static long pow(long a,long b,long md)
{ 
    long ans=1;
    while(b>0)
    {
         if(b%2==1)
           ans = (ans*a)%md;
           a = (a*a)%md;
           b = b/2;
    }
   return ans;
}
static long min(long a,long b){
 
     return a<b ? a : b;
}
static long max(long a,long b){
     return a>b ? a : b;
}
static boolean pal(String s)
{
   int n = s.length(),i1=0,i2=n-1;
 
     while(i1<i2)
     {
        if(s.charAt(i1)!=s.charAt(i2))
             return false;
             i1++; i2--;
     }
       return true;
}
static String rev(String r)
{
    String s = "";
    int i= r.length()-1;
 
    while(i>=0)
    {
        s=s+r.charAt(i);
        i--;   
    }
       return s;
}
static FastReader sc=new FastReader(); 
 
      static int ni(){
                 int x = sc.nextInt();
                 return(x);
        }
      static long nl(){
              long x = sc.nextLong();
              return(x);
         }
      static String n(){
                 String str = sc.next();
                     return(str);
       }
     static String ns(){
                 String str = sc.nextLine();
                   return(str);
      }
     static double nd(){
               double d = sc.nextDouble();
                 return(d);
       }
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
}