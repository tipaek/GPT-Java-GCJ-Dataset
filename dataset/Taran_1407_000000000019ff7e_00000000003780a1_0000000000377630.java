import java.util.*;
import java.io.*;
import java.text.*;

public class Solution {
    //SOLUTION BEGIN
    //Into the Hardware Mode
    void pre() throws Exception {}
    void solve(int TC) throws Exception{
        int T = ni(), N = ni(), C = ni();
        boolean[][] f = new boolean[T][N], ch = new boolean[T][N];
        int cnt = N;
        Random r = new Random();
        ArrayList<Integer>[] list = new ArrayList[T];
        for(int i = 0; i< T; i++)list[i] = new ArrayList<>();
        int SZ = 6;
        while(cnt > 0){
            int[] q = new int[T];
            for(int i = 0; i< T; i++){
                if(list[i].size() == SZ)p("0 ");
                else{
                    int idx = r.nextInt(N);
                    while(ch[i][idx])idx = r.nextInt(N);
                    q[i] = idx;
                    p(idx+" ");
                    ch[i][idx] = true;
                }
            }
            pni("");
            for(int i = 0; i< T; i++){
                if(ni() == 1) {
                    f[i][q[i]] = true;
                    list[i].add(q[i]);
                    if(list[i].size() == SZ)cnt--;
                }
            }
        }
        for(int i = 0; i< T; i++)p("0 ");pni("");
        for(int i = 0; i< T; i++){
            int i1 = r.nextInt(list[i].size()), i2 = r.nextInt(list[i].size());
            while(i1 == i2)i2 = r.nextInt(list[i].size());
            p(list[i].get(i1)+" "+list[i].get(i2)+" ");
        }
        pni("");
    }
    //SOLUTION END
    void hold(boolean b)throws Exception{if(!b)throw new Exception("Hold right there, Sparky!");}
    void exit(boolean b){if(!b)System.exit(0);}
    static void debug(Object... o){System.out.println(Arrays.deepToString(o));}
    final long IINF = (long)2e18;
    final int INF = (int)1e6+2;
    DecimalFormat df = new DecimalFormat("0.00000000000");
    double PI = 3.141592653589793238462643383279502884197169399, eps = 1e-8;
    static boolean multipleTC = false, memory = false, fileIO = false;
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
            g[from[i]][--cnt[from[i]]] = new int[]{to[i], i, 0};
            if(f)g[to[i]][--cnt[to[i]]] = new int[]{from[i], i, 1};
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