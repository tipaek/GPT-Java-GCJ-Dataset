import javax.swing.text.ChangedCharSetException;
import javax.swing.text.MutableAttributeSet;
import java.io.*;
import java.util.*;
import java.lang.Math;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
    public static void main(String args []){
        int t = in(),b=in();
        for(int tt = 1;tt<=t;++tt){
            String ans = "";
            List<Integer> bits = new ArrayList<>();
            for(int i=0;i<b;++i){
                bits.add(-1);
            }
            int li=0,ei=bits.size()-1,tries=0;
            Pair<Integer,Integer> pp = fill(bits,li,ei,10);
            li = pp.t1;
            ei = pp.t2;
            while(li<=ei && tries<150){
                Pair<CHANGE_TYPE,Integer> p = getChangeType(bits);
                // ol(p.t1+" "+p.t2);
                bits = transform(p.t1,bits);
                pp = fill(bits,li,ei,10-p.t2);
                li = pp.t1;
                ei = pp.t2;
            }
            ans = bits.stream().map(a->a+"").reduce((a,x)->a+""+x).orElse("");

            ol(ans);
            String res = ss();
            if(res.equals("N")){
                System.exit(1);
            }
        }

    }

    enum CHANGE_TYPE {
        REV,FLIP,BOTH,NONE
    }

    public static Pair<Integer,Integer> fill(List<Integer> bits,int li,int ri,int tries){
        int ltry = tries/2,rtry = tries-ltry;
        for(int i=0;i<ltry;++i){
            bits.set(li,check(li));
            li++;
        }
        for(int i=0;i<rtry;++i){
            bits.set(ri,check(ri));
            ri--;
        }
        return new Pair<>(li,ri);
    }
    public static Pair<CHANGE_TYPE,Integer> getChangeType(List<Integer> bits){
        int sidx = -1,didx = -1,sflag=0,dflag =0;
        for(int i=0;i<bits.size();++i){
            if(bits.get(i)!=-1){
                if(bits.get(i)==bits.get(bits.size()-1-i)){
                    sidx = i;
                    sflag = 1;
                }
                if(bits.get(i)!=bits.get(bits.size()-1-i)){
                    didx = i;
                    dflag = 1;
                }
            }
            if(sflag+dflag==2){
                break;
            }
        }
//        ol(sidx+" "+didx);
//        ol(bits.stream().map(a->a+"").reduce((a,x)->a+""+x).orElse(""));

        if(sidx ==-1 && sidx==didx){
            ol("Should not be the case");
        }else if(sidx == -1 ){
            int x = check(didx);
            if(x==bits.get(didx)){
                return new Pair(CHANGE_TYPE.NONE,1);
            }else{
                return new Pair(CHANGE_TYPE.FLIP,1);
            }
        }else if(didx == -1){
            int x = check(sidx);
            if(x==bits.get(sidx)){
                return new Pair(CHANGE_TYPE.NONE,1);
            }else{
                return new Pair(CHANGE_TYPE.FLIP,1);
            }
        }else{
            int x = check(sidx),y=check(didx);
            if(x==bits.get(sidx)){
                if(y==bits.get(didx)){
                    return new Pair(CHANGE_TYPE.NONE,2);
                }else{
                    return new Pair(CHANGE_TYPE.REV,2);
                }
            }else{
                if(y==bits.get(didx)){
                    return new Pair(CHANGE_TYPE.BOTH,2);
                }else{
                    return new Pair(CHANGE_TYPE.FLIP,2);
                }
            }
        }

        return new Pair<>(CHANGE_TYPE.NONE,0);
    }

    public static int check(int idx){
        ol((idx+1));
        int x = in();
        return x;
    }
    public static List<Integer> transform(CHANGE_TYPE cht,List<Integer> bits){
        switch (cht){
            case NONE: break;
            case FLIP: bits = flip(bits); break;
            case REV: Collections.reverse(bits); break;
            case BOTH:bits = flip(bits);Collections.reverse(bits);
        }
        return bits;
    }

    public static List<Integer> flip(List<Integer> bits){
       return  bits.stream().map(b->b==0?1:b==1?0:b).collect(Collectors.toList());
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
