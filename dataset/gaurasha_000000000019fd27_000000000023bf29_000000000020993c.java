import javax.swing.text.MutableAttributeSet;
import java.io.*;
import java.util.*;
import java.lang.Math;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Solution {
    public static void main(String args []){
        int t = in();
        for(int tt = 1;tt<=t;++tt){
            String ans = "";
            int n = in();
            List<List<Integer>> mat = new ArrayList<>(),rev=new ArrayList<>();
            for(int i=0;i<n;++i){
                mat.add(inl(n));
            }
            int trace = IntStream.range(0,n).map(i->mat.get(i).get(i)).reduce((a,b)->a+b).orElse(0);
            long rows = mat.stream().map(i-> i.size()-i.stream().distinct().count()).filter(i->i>0).count();
            for(int i=0;i<n;++i){
                List<Integer> tmp = new ArrayList<>();
                for(int j=0;j<n;++j){
                    tmp.add(mat.get(j).get(i));
                }
                rev.add(tmp);
            }
            long col = rev.stream().map(i-> i.size()-i.stream().distinct().count()).filter(i->i>0).count();
            ans = trace+" "+rows+" "+col;
            ol("Case #"+tt+": "+ans);
        }

    }


    static class Pair<T1 extends  Comparable,T2 extends  Comparable> implements Comparable<Pair>{
        public T1 t1;
        public T2 t2;

        public Pair(T1 t1, T2 t2) {
            this.t1 = t1;
            this.t2 = t2;
        }

        @Override
        public int compareTo(Pair that) {
            int res= this.t1.compareTo(that.t1);
            if(res ==0){
                res = this.t2.compareTo(that.t2);
            }
            return res;
        }
    }












    public static void ol(Object o){
        System.out.println(o);
    }
    public static void o(Object o){
        System.out.print(o);
    }
    static FastScanner fastScanner = new FastScanner();
    public static Integer in(){
        return fastScanner.nextInt();
    }
    public static Double db(){
        return fastScanner.nextDouble();
    }
    public static Long lg(){
        return fastScanner.nextLong();
    }
    public static String ss(){
        return fastScanner.nextToken();
    }

    public static String ln(){
        return fastScanner.nextLine();
    }


    public static <T> List<T> genericIn(int n, Supplier<T> func){
        List<T>  arr = new ArrayList<>();
        for(int i=0;i<n;++i){
            arr.add(func.get());
        }
        return arr;
    }

    public static List<Integer> inl(int n){
        return genericIn(n,Solution::in);
    }

    public static Integer[] ina(int n){
        return (Integer[]) inl(n).toArray();
    }

    public static List<Double> dbl(int n){
        return genericIn(n,Solution::db);
    }

    public static Double[] dba(int n){
        return (Double[]) dbl(n).toArray();
    }

    public static List<Long> lgl(int n){
        return genericIn(n,Solution::lg);
    }

    public static Long[] lga(int n){
        return (Long[]) lgl(n).toArray();
    }

    public static List<String> ssl(int n){
        return genericIn(n,Solution::ss);
    }

    public static String[] ssa(int n){
        return (String[]) ssl(n).toArray();
    }




    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
