import java.util.*;
import java.io.*;
import java.text.*;

public class Solution {
    //SOLUTION BEGIN
    //Into the Hardware Mode
    void pre() throws Exception{ }
    void solve(int TC) throws Exception{
        long L = nl(), R = nl();
        long N = 0;
        for(int i = 0; i< 10; i++){
            if(N+1 <= Math.max(L, R)){
                N++;
                if(L >= R)L -= N;
                else R -= N;
            }else {
                pn("Case #"+TC+": "+N+" "+L+" "+R);
                return;
            }
        }

        if(L> R){
            long D = L-R;
            long lo = 0, hi = 2*sqrt(L);
            while(lo+1 < hi){
                long mid = lo+(hi-lo)/2;
                if(f(mid) < D)lo = mid;
                else hi = mid;
            }
            if(f(hi) < D)lo = hi;

            N = lo;
            L -= f(lo);
            hold(L >= R && L-(N+1) < R);
        }
        else if(L < R){
            long D = R-L;
            long lo = 0, hi = 2*sqrt(R);
            while(lo+1 < hi){
                long mid = lo+(hi-lo)/2;
                if(f(mid) < D)lo = mid;
                else hi = mid;
            }
            if(f(hi) < D)lo = hi;
            N = lo;
            R -= f(lo);
            hold(R > L);
            if(R >= N+1){
                R -= ++N;
            }else {
                pn("Case #"+TC+": "+N+" "+L+" "+R);
                return;
            }
            hold(L >= R && L-(N+1) < R);
        }
        long lo = 0, hi = (long)1e9;
        while(lo+1 < hi){
            long mid = lo+(hi-lo)/2;
            if(mid*mid+mid+mid*N <= R)lo = mid;
            else hi = mid;
        }
        if(hi*hi+hi+hi*N <= R)lo = hi;


        L -= lo*lo+lo*N;
        R -= lo*lo+lo*N+lo;
        N += 2*lo;
        if(L >= N+1){
            N++;
            L -= N;
        }
        pn("Case #"+TC+": "+N+" "+L+" "+R);
    }
    long f(long x){
        return (x*x+x)/2;
    }
    long sqrt(long x){
        long y = (long)Math.sqrt(x);
        while(y*y >= x)y--;
        while(y*y < x)y++;
        return y;
    }
    //SOLUTION END
    void hold(boolean b)throws Exception{if(!b)throw new Exception("Hold right there, Sparky!");}
    void exit(boolean b){if(!b)System.exit(0);}
    static void debug(Object... o){System.out.println(Arrays.deepToString(o));}
    final long IINF = (long)2e18;
    final int INF = (int)1e9+2;
    DecimalFormat df = new DecimalFormat("0.00000000000");
    double PI = 3.141592653589793238462643383279502884197169399, eps = 1e-8;
    static boolean multipleTC = true, memory = true, fileIO = false;
    FastReader in;PrintWriter out;
    void run() throws Exception{
        long ct = System.currentTimeMillis();
        if (fileIO) {
            in = new FastReader("");
            out = new PrintWriter("");
        } else {
            in = new FastReader();
            out = new PrintWriter(System.out);
        }
        //Solution Credits: Taranpreet Singh
        int T = multipleTC? ni():1;
        pre();
        for (int t = 1; t <= T; t++) solve(t);
        out.flush();
        out.close();
        System.err.println(System.currentTimeMillis() - ct);
    }
    public static void main(String[] args) throws Exception{
        if(memory)new Thread(null, new Runnable() {public void run(){try{new Solution().run();}catch(Exception e){e.printStackTrace();}}}, "1", 1 << 28).start();
        else new Solution().run();
    }
    int[][] make(int n, int[] from, int[] to, int e, boolean f){
        int[][] g = new int[n][];int[]cnt = new int[n];
        for(int i = 0; i< e; i++){
            cnt[from[i]]++;
            if(f)cnt[to[i]]++;
        }
        for(int i = 0; i< n; i++)g[i] = new int[cnt[i]];
        for(int i = 0; i< e; i++){
            g[from[i]][--cnt[from[i]]] = to[i];
            if(f)g[to[i]][--cnt[to[i]]] = from[i];
        }
        return g;
    }
    int[][][] makeS(int n, int[] from, int[] to, int e, boolean f){
        int[][][] g = new int[n][][];int[]cnt = new int[n];
        for(int i = 0; i< e; i++){
            cnt[from[i]]++;
            if(f)cnt[to[i]]++;
        }
        for(int i = 0; i< n; i++)g[i] = new int[cnt[i]][];
        for(int i = 0; i< e; i++){
            g[from[i]][--cnt[from[i]]] = new int[]{to[i], i};
            if(f)g[to[i]][--cnt[to[i]]] = new int[]{from[i], i};
        }
        return g;
    }
    int find(int[] set, int u){return set[u] = (set[u] == u?u:find(set, set[u]));}
    int digit(long s){int ans = 0;while(s>0){s/=10;ans++;}return ans;}
    long gcd(long a, long b){return (b==0)?a:gcd(b,a%b);}
    int gcd(int a, int b){return (b==0)?a:gcd(b,a%b);}
    int bit(long n){return (n==0)?0:(1+bit(n&(n-1)));}
    void p(Object o){out.print(o);}
    void pn(Object o){out.println(o);}
    void pni(Object o){out.println(o);out.flush();}
    String n()throws Exception{return in.next();}
    String nln()throws Exception{return in.nextLine();}
    int ni()throws Exception{return Integer.parseInt(in.next());}
    long nl()throws Exception{return Long.parseLong(in.next());}
    double nd()throws Exception{return Double.parseDouble(in.next());}

    class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws Exception{
            br = new BufferedReader(new FileReader(s));
        }

        String next() throws Exception{
            while (st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch (IOException  e){
                    throw new Exception(e.toString());
                }
            }
            return st.nextToken();
        }

        String nextLine() throws Exception{
            String str;
            try{
                str = br.readLine();
            }catch (IOException e){
                throw new Exception(e.toString());
            }
            return str;
        }
    }
}