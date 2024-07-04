import java.util.*;
import java.io.*;
import java.math.BigInteger;
import java.text.*;
public class Solution {
    static long mod = (long)1e9 + 7;
    static long mod1 = 998244353;
    static boolean fileIO = false;
    static FastScanner f;
    static PrintWriter pw = new PrintWriter(System.out);
    static Scanner S = new Scanner(System.in);
    public static void solve()throws IOException {
        int time = 0;
        int x = f.nextInt(); int y = f.nextInt();
        String str = f.next();
        int p = 0 , q = 0;
        int n = str.length();
        int i = 0;
        boolean ok = false;
        if(x == p && y == q) pn(0);
        else {
            while(n > 0) {
                ++time;
                char ch = str.charAt(i);
                if(ch == 'N') {++y;}
                else if(ch == 'S') {--y;}
                else if(ch == 'E') {++x;}
                else {--x;}
                //if(x == 2 && y == 2) pn("time" + time);
                int disp = Math.abs(x - p) + Math.abs(y - q);
                if(disp <= time || disp == 0) {ok = true; break;}
                ++i;
                --n;
            }
        }
        if(!ok) pn("IMPOSSIBLE");
        else pn(time);
    }
    public static void main(String[] args)throws IOException {
        init();
        int t = f.nextInt(); int tt = 1;
        while(t --> 0) {
            p("Case #" + (tt++) + ": ");
            solve();
        }
        pw.flush(); 
        pw.close();  
    }
        
/******************************END OF MAIN PROGRAM*******************************************/
    public static void init()throws IOException{if(fileIO){f=new FastScanner("");}else{f=new FastScanner(System.in);}}
    public static class FastScanner {
        BufferedReader br;StringTokenizer st;
        FastScanner(InputStream stream){try{br=new BufferedReader(new InputStreamReader(stream));}catch(Exception e){e.printStackTrace();}}
        FastScanner(String str){try{br=new BufferedReader(new FileReader("!a.txt"));}catch(Exception e){e.printStackTrace();}}
        String next(){while(st==null||!st.hasMoreTokens()){try{st=new StringTokenizer(br.readLine());}catch(IOException e){e.printStackTrace();}}return st.nextToken();}
        String nextLine()throws IOException{return br.readLine();}int nextInt(){return Integer.parseInt(next());}long nextLong(){return Long.parseLong(next());}double nextDouble(){return Double.parseDouble(next());}
    }
    public static void pn(Object o){pw.println(o);}
    public static void p(Object o){pw.print(o);}
    public static void pni(Object o){pw.println(o);pw.flush();}
    static int gcd(int a,int b){if(b==0)return a;else{return gcd(b,a%b);}}
    static long gcd(long a,long b){if(b==0)return a;else{return gcd(b,a%b);}}
    static long pow(long a,long b){long res=1;while(b>0){if((b&1)==1)res=res*a;b>>=1;a=a*a;}return res;}
    static long minv(long x){return mpow(x,mod-2);}
    static long mpow(long a,long b){long res=1;while(b>0){if((b&1)==1)res=((res%mod)*(a%mod))%mod;b>>=1;a=((a%mod)*(a%mod))%mod;}return res;}
    static boolean isPrime(long n){if(n<=1)return false;if(n<=3)return true;if(n%2==0||n%3==0)return false;for(long i=5;i*i<=n;i=i+6)if(n%i==0||n%(i+2)==0)return false;return true;}
    static HashSet<Long> factors(long n){HashSet<Long> hs=new HashSet<Long>();for(long i=1;i<=(long)Math.sqrt(n);i++){if(n%i==0){hs.add(i);hs.add(n/i);}}return hs;}
    static int[] inpint(int n){int arr[]=new int[n];for(int i=0;i<n;i++){arr[i]=f.nextInt();}return arr;}
    static long[] inplong(int n){long arr[] = new long[n];for(int i=0;i<n;i++){arr[i]=f.nextLong();}return arr;}
    static HashSet<Integer> hsi(){return new HashSet<Integer>();}static HashSet<Long> hsl(){return new HashSet<Long>();}
    static ArrayList<Integer> ali(){return new ArrayList<Integer>();}static ArrayList<Long> all(){return new ArrayList<Long>();}
    static HashMap<Integer,Integer> hii(){return new HashMap<Integer,Integer>();}
    static HashMap<Integer,ArrayList<Integer>> g(){return new HashMap<Integer,ArrayList<Integer>>();}
    static boolean ise(int x){return ((x&1)==0);}static boolean ise(long x){return ((x&1)==0);}
    static void sort(int[] a){ArrayList<Integer> l=new ArrayList<>();for(int i:a)l.add(i);Collections.sort(l);for(int i=0;i<a.length;++i)a[i]=l.get(i);}
    static void sort(long[] a){ArrayList<Long> l=new ArrayList<>();for(long i:a)l.add(i);Collections.sort(l);for(int i=0;i<a.length;++i)a[i]=l.get(i);}
}
