import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.text.*;
public class Solution{
    //SOLUTION BEGIN
    //Into the Hardware Mode
    void pre() throws Exception{}
    void solve(int TC) throws Exception{
        int r = ni(), c = ni();
        long[][] skill = new long[r][c];
        long total = 0, sum = 0;
        for(int i = 0; i< r; i++)
            for(int j = 0; j< c; j++) {
                skill[i][j] = nl();
                sum += skill[i][j];
            }
        total += sum;
        LST[] row = new LST[r], col = new LST[c];
        for(int i = 0; i< r; i++){
            row[i] = new LST(c);
            row[i].setRange(c);
        }
        for(int i = 0; i< c; i++){
            col[i] = new LST(r);
            col[i].setRange(r);
        }
        TreeSet<int[]>[] q = new TreeSet[2];
        for(int i = 0; i< 2; i++)q[i] = new TreeSet<>((int[] i1, int[] i2) -> {
            if(i1[0] != i2[0])return Integer.compare(i1[0], i2[0]);
            return Integer.compare(i1[1], i2[1]);
        });
        int t = 0;
        for(int i = 0; i< r; i++){
            for(int j = 0; j< c; j++){
                if(remove(skill, row, col, i, j))q[t].add(new int[]{i, j});
            }
        }
        boolean flag = true;
        while(flag){
            flag = false;
            for(int[] pos:q[t]){
                if(remove(skill, row, col, pos[0], pos[1])) {
                    flag = true;
                    sum -= skill[pos[0]][pos[1]];
                    skill[pos[0]][pos[1]] = 0;
                    row[pos[0]].unset(pos[1]);
                    col[pos[1]].unset(pos[0]);
                }
            }
            if(!flag)break;
            total += sum;
            q[t^1].clear();
            for(int[] pos:q[t]){
                int pr = -1;
                int i = pos[0], j = pos[1];
                if(skill[i][j] != 0)continue;
                if((pr = row[i].prev(j)) != -1){
                    q[t^1].add(new int[]{i, pr});
                }
                if((pr = row[i].next(j)) != -1){
                    q[t^1].add(new int[]{i, pr});
                }
                if((pr = col[j].prev(i)) != -1){
                    q[t^1].add(new int[]{pr, j});
                }
                if((pr = col[j].next(i)) != -1){
                    q[t^1].add(new int[]{pr, j});
                }
            }
            t ^= 1;
        }
        pn("Case #"+TC+": "+total);
    }
    boolean remove(long[][] skill, LST[] row, LST[] col, int i, int j){
        long around = 0;int cnt = 0;
        row[i].toggle(j);
        col[j].toggle(i);
        int pr = -1;
        if((pr = row[i].prev(j)) != -1){
            around += skill[i][pr];
            cnt++;
        }
        if((pr = row[i].next(j)) != -1){
            around += skill[i][pr];
            cnt++;
        }
        if((pr = col[j].prev(i)) != -1){
            around += skill[pr][j];
            cnt++;
        }
        if((pr = col[j].next(i)) != -1){
            around += skill[pr][j];
            cnt++;
        }
        row[i].toggle(j);
        col[j].toggle(i);
        return cnt > 0 && skill[i][j]*cnt < around;
    }
    public static class LST {
        public long[][] set;
        public int n;
//		public int size;

        public LST(int n) {
            this.n = n;
            int d = 1;
            for(int m = n;m > 1;m>>>=6, d++);

            set = new long[d][];
            for(int i = 0, m = n>>>6;i < d;i++, m>>>=6){
                set[i] = new long[m+1];
            }
//			size = 0;
        }

        // [0,r)
        public LST setRange(int r)
        {
            for(int i = 0;i < set.length;i++, r=r+63>>>6){
                for(int j = 0;j < r>>>6;j++){
                    set[i][j] = -1L;
                }
                if((r&63) != 0)set[i][r>>>6] |= (1L<<r)-1;
            }
            return this;
        }

        // [0,r)
        public LST unsetRange(int r)
        {
            if(r >= 0){
                for(int i = 0;i < set.length;i++, r=r+63>>>6){
                    for(int j = 0;j < r+63>>>6;j++){
                        set[i][j] = 0;
                    }
                    if((r&63) != 0)set[i][r>>>6] &= ~((1L<<r)-1);
                }
            }
            return this;
        }

        public LST set(int pos)
        {
            if(pos >= 0 && pos < n){
//				if(!get(pos))size++;
                for(int i = 0;i < set.length;i++, pos>>>=6){
                    set[i][pos>>>6] |= 1L<<pos;
                }
            }
            return this;
        }

        public LST unset(int pos)
        {
            if(pos >= 0 && pos < n){
//				if(get(pos))size--;
                for(int i = 0;i < set.length && (i == 0 || set[i-1][pos] == 0L);i++, pos>>>=6){
                    set[i][pos>>>6] &= ~(1L<<pos);
                }
            }
            return this;
        }

        public boolean get(int pos)
        {
            return pos >= 0 && pos < n && set[0][pos>>>6]<<~pos<0;
        }

        public LST toggle(int pos)
        {
            return get(pos) ? unset(pos) : set(pos);
        }

        public int prev(int pos)
        {
            for(int i = 0;i < set.length && pos >= 0;i++, pos>>>=6, pos--){
                int pre = prev(set[i][pos>>>6], pos&63);
                if(pre != -1){
                    pos = pos>>>6<<6|pre;
                    while(i > 0)pos = pos<<6|63-Long.numberOfLeadingZeros(set[--i][pos]);
                    return pos;
                }
            }
            return -1;
        }

        public int next(int pos)
        {
            for(int i = 0;i < set.length && pos>>>6 < set[i].length;i++, pos>>>=6, pos++){
                int nex = next(set[i][pos>>>6], pos&63);
                if(nex != -1){
                    pos = pos>>>6<<6|nex;
                    while(i > 0)pos = pos<<6|Long.numberOfTrailingZeros(set[--i][pos]);
                    return pos;
                }
            }
            return -1;
        }

        private static int prev(long set, int n)
        {
            long h = set<<~n;
            if(h == 0L)return -1;
            return -Long.numberOfLeadingZeros(h)+n;
        }

        private static int next(long set, int n)
        {
            long h = set>>>n;
            if(h == 0L)return -1;
            return Long.numberOfTrailingZeros(h)+n;
        }

        @Override
        public String toString(){
            List<Integer> list = new ArrayList<Integer>();
            for(int pos = next(0);pos != -1;pos = next(pos+1)){
                list.add(pos);
            }
            return list.toString();
        }
    }
    //SOLUTION END
    void hold(boolean b)throws Exception{if(!b)throw new Exception("Hold right there, Sparky!");}
    void exit(boolean b){if(!b)System.exit(0);}
    final long IINF = (long)1e13;
    final int INF = (int)1e9+2, MX = (int)2e6+5;
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
        int T = (multipleTC) ? ni() : 1;
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
    int[][][] makeS(int n, int[] from, int[] to, boolean f){
        int[][][] g = new int[n][][];int[]cnt = new int[n];
        for(int i:from)cnt[i]++;if(f)for(int i:to)cnt[i]++;
        for(int i = 0; i< n; i++)g[i] = new int[cnt[i]][];
        for(int i = 0; i< from.length; i++){
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