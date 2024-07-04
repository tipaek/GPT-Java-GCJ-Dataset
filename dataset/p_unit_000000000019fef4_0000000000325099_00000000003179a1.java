
import java.io.*;
import java.util.*;

import static java.lang.Math.abs;

class Solution implements Runnable {

    private boolean console=false;
    private long MOD = 1000_000_007L;
    private int MAX = 1000_001;

    public void solve() {
        int testCases = 1;
        testCases = in.ni();
        for(int t=1;t<=testCases;++t){
            out.print("Case #"+t+": ");

            int n=in.ni();
            TreeSet<Integer>[] set = new TreeSet[26];

            ArrayList<Pair> list = new ArrayList<Pair>();

            for(int i=0;i<10000;++i){
                list.add(new Pair(in.nl(),in.ns()));
            }

//            list.sort(Comparator.comparingLong(pair -> pair.num));

            for(int i=0;i<10000;++i){

                char[] num = String.valueOf(list.get(i).num).toCharArray();
                char[] str = list.get(i).s.toCharArray();

                for(char ch:str){
                    if(set[ch-'A']==null){
                        set[ch-'A'] = new TreeSet<>();
                        set[ch-'A'].add(0);
                    }
                }

                if(num.length==str.length){

                    for(int j=0;j<1;++j){

                        if(set[str[j]-'A'].size()==1){
                            set[str[j]-'A'] = new TreeSet<>();
                            for(int k=0;k<10;++k){
                                set[str[j]-'A'].add(k);
                            }
                        }

                        for(int k = (num[j]-'0')+1 ; k<=9;++k){
                            set[str[j]-'A'].remove(k);
                        }
                    }

                }
            }

//            for(int i=0;i<26;++i){
//                out.println((char)('A'+i)+" -> "+set[i]);
//            }

            for(int i=0;i<=9;++i){
                boolean isfound = false;
                for(int j=0;j<26;++j){

                    if(set[j]!=null && set[j].size()!=0){
                        if(set[j].last()==i){
                            out.print((char)('A'+j));
                            set[j] = new TreeSet<>();
                            isfound = true;
                            break;
                        }
                    }
                }

                if(!isfound){
                    for(int j=0;j<26;++j){
                        if(set[j]==null){
                            out.print((char)('A'+j));
                            set[j]=new TreeSet<>();
                        }
                    }
                }

            }


            out.println();
        }
    }

    class Pair{
        long num ;
        String s;

        public Pair(long num, String s) {
            this.num = num;
            this.s = s;
        }
    }

    @Override
    public void run() {
        long time = System.currentTimeMillis();
        try {
            init();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            solve(); out.flush(); System.exit(0);
        }catch (Exception e){
            e.printStackTrace(); System.exit(1);
        }
        System.err.println(System.currentTimeMillis()-time);
    }

    /* -------------------- Templates and Input Classes -------------------------------*/

    private FastInput in;
    private PrintWriter out;
    public static void main(String[] args) throws Exception {
        new Solution().run();
//        new Thread(null, new Main(), "Main", 1 << 27).start();
    }
    private void init() throws FileNotFoundException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        try {
            if (!console && System.getProperty("user.name").equals("puneet")) {
                outputStream = new FileOutputStream("/home/puneet/Desktop/output.txt");
                inputStream = new FileInputStream("/home/puneet/Desktop/input.txt");
            }
        } catch (Exception ignored) {
        }
        out = new PrintWriter(outputStream);
        in = new FastInput(inputStream);
    }
    private void maualAssert(int a,int b,int c){
        if(a<b || a>c) throw new RuntimeException();
    }
    private void maualAssert(long a,long b,long c){
        if(a<b || a>c) throw new RuntimeException();
    }
    private void sort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int object : arr) list.add(object);
        Collections.sort(list);
        for (int i = 0; i < list.size(); ++i) arr[i] = list.get(i);
    }
    private void sort(long[] arr) {
        List<Long> list = new ArrayList<>();
        for (long object : arr) list.add(object);
        Collections.sort(list);
        for (int i = 0; i < list.size(); ++i) arr[i] = list.get(i);
    }
    public long ModPow(long x, long y, long MOD) {
        long res = 1L;
        x = x % MOD;
        while (y >= 1L) {
            if ((y & 1L) > 0) res = (res * x) % MOD;
            x = (x * x) % MOD;
            y >>= 1L;
        }
        return res;
    }
    public int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
    public long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
    private int[] arrInt(int n){
        int[] arr=new int[n];for(int i=0;i<n;++i)arr[i]=in.ni();
        return arr;
    }
    private long[] arrLong(int n){
        long[] arr=new long[n];for(int i=0;i<n;++i)arr[i]=in.nl();
        return arr;
    }
    static class FastInput { InputStream obj;
        public FastInput(InputStream obj) {
            this.obj = obj;
        }
        byte inbuffer[] = new byte[1024];
        int lenbuffer = 0, ptrbuffer = 0;
        int readByte() { if (lenbuffer == -1) throw new InputMismatchException();
            if (ptrbuffer >= lenbuffer) { ptrbuffer = 0;
                try { lenbuffer = obj.read(inbuffer);
                } catch (IOException e) { throw new InputMismatchException(); } }
            if (lenbuffer <= 0) return -1;return inbuffer[ptrbuffer++]; }
        String ns() { int b = skip();StringBuilder sb = new StringBuilder();
            while (!(isSpaceChar(b))) // when nextLine, (isSpaceChar(b) && b!=' ')
            { sb.appendCodePoint(b);b = readByte(); }return sb.toString();}
        int ni() {
            int num = 0, b;boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') { minus = true;b = readByte(); }
            while (true) { if (b >= '0' && b <= '9') { num = num * 10 + (b - '0'); } else {
                return minus ? -num : num; }b = readByte(); }}
        long nl() { long num = 0;int b;boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') { minus = true;b = readByte(); }
            while (true) { if (b >= '0' && b <= '9') { num = num * 10L + (b - '0'); } else {
                return minus ? -num : num; }b = readByte(); } }
        boolean isSpaceChar(int c) {
            return (!(c >= 33 && c <= 126));
        }
        int skip() { int b;while ((b = readByte()) != -1 && isSpaceChar(b)) ;return b; }
        float nf() {return Float.parseFloat(ns());}
        double nd() {return Double.parseDouble(ns());}
        char nc() {return (char) skip();}
    }

}