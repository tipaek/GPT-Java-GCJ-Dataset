import java.util.*;
import java.io.*;
import java.text.*;

public class Solution {
    //SOLUTION BEGIN
    //Into the Hardware Mode
    void pre() throws Exception {}
    void solve(int TC) throws Exception{
        String C = n(), D = n();
        int num = 3;
        String o = "";
        int da = 100, db = 100;
        for(int len = 1; len <= Math.max(C.length(), D.length()); len++){
            for(int cur = 0; cur < num; cur++){
                StringBuilder ans = new StringBuilder("");
                int x = cur;
                for(int j = 0; j< len; j++){
                    ans.append((char)('X'+(x%3)));
                    x /= 3;
                }
                String target = ans.toString();
                int DA = new Dist(target, C).dist(), DB = new Dist(target, D).dist();
                if(DA+DB < da+db){
                    o = target;
                    da = DA;db = DB;
                }
                else if((DA+DB) == (da+db) && Math.abs(DA-DB) < Math.abs(da-db)){
                    o = target;
                    da = DA;db = DB;
                }
            }
            num *= 3;
        }
        pn("Case #"+TC+": "+o);
    }
    class Dist{
        String S, T;
        int[][] D;
        Dist(String a, String b){
            S = a;T = b;
            D = new int[1+S.length()][1+T.length()];
            for(int i = 0; i< D.length; i++)Arrays.fill(D[i], -1);
        }
        int dist(){return dist(S.length(), T.length());}
        int dist(int i, int j){
            if(D[i][j] != -1)return D[i][j];
            if(Math.min(i, j) == 0)return Math.max(i, j);
            int ans = Math.min(dist(i-1, j), dist(i, j-1))+1;
            ans = Math.min(ans, dist(i-1, j-1)+(S.charAt(i-1) == T.charAt(j-1)?0:1));
            return D[i][j] = ans;
        }
    }
    //SOLUTION END
    void hold(boolean b)throws Exception{if(!b)throw new Exception("Hold right there, Sparky!");}
    void exit(boolean b){if(!b)System.exit(0);}
    static void debug(Object... o){System.out.println(Arrays.deepToString(o));}
    final long IINF = (long)2e18;
    final int INF = (int)1e6+2;
    DecimalFormat df = new DecimalFormat("0.00000000000");
    double PI = 3.141592653589793238462643383279502884197169399, eps = 1e-8;
    static boolean multipleTC = true, memory = false, fileIO = false;
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