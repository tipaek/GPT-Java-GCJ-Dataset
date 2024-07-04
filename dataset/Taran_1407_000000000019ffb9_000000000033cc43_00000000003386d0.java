import java.util.*;
import java.io.*;
import java.text.*;

public class Solution {
    //SOLUTION BEGIN
    //Into the Hardware Mode
    void pre() throws Exception{ }
    void solve(int TC) throws Exception{

        int N = ni();
        long[][] P = new long[N][];
        for(int i = 0; i< N; i++)P[i] = new long[]{nl(), nl()};
        int ans = Math.min(N, 2);

        for(int i = 0; i< N; i++)
            for(int j = i+1; j< N; j++){
                long a = P[j][1]-P[i][1], b = -(P[j][0]-P[i][0]);//, c = P[i][0]*P[j][1]-P[i][1]*P[j][0];
                TreeMap<Long, Integer> mp = new TreeMap<>();
                for(int k = 0; k< N; k++){
                    long C = a*P[k][0]+b*P[k][1];//+c;
                    mp.put(C, mp.getOrDefault(C, 0)+1);
                }
                ArrayList<Integer> odd = new ArrayList<>(), even = new ArrayList<>();
                int one = 0;
                for(int x:mp.values()){
                    if(x == 1)one++;
                    else if(x%2 == 0)even.add(x);
                    else odd.add(x);
                }

                ans = Math.max(ans, solve(odd, even, one));


            }

        pn("Case #"+TC+": "+ans);
    }
    int solve(ArrayList<Integer> odd, ArrayList<Integer> even, int one){
        Collections.sort(odd, Collections.reverseOrder());
        Collections.sort(even, Collections.reverseOrder());
        int curAns = 0;
        for(int x = 0; x+1< odd.size(); x += 2){
            curAns += odd.get(x)+odd.get(x+1);
        }
        for(int x:even)curAns += x;

        int lo = (odd.size()%2 == 1?odd.get(odd.size()-1):-1);
        if(lo == -1){
            return curAns+Math.min(2, one);
        }else{
            return curAns+Math.max(lo-1+Math.min(2, one), lo+Math.min(1, one));
        }
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