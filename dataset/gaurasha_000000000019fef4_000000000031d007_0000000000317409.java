import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String args[]){
        solve_util();
    }

    public static void solve_util(){
        int t = in(),tt = 1;
        while(tt <=t){
            int [] dir = new int[30];
            for(int i=0;i<dir.length;++i){
                dir[i]=0;
            }
            int ans = 0 ;
            int x=in(),y=in();
            String s = ss();

            List<Pair<Integer,Integer> >pos = new ArrayList<>();
            pos.add(new Pair(x,y));
            int xx=x,yy=y;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='N'){
                    yy++;
                }else if(s.charAt(i)=='S'){
                    yy--;
                }else if(s.charAt(i)=='W'){
                    xx--;
                }else if(s.charAt(i)=='E'){
                    xx++;
                }
                pos.add(new Pair(xx,yy));
            }
            for(int i=0;i<pos.size();i++){
                xx=Math.abs(pos.get(i).t1);yy=Math.abs(pos.get(i).t2);
                if(xx+yy>i)continue;
                else {
                    ans=i;
                    break;
                }
            }

            if(ans>0){
                ol("Case #"+tt+": "+(ans));
            }else{
                ol("Case #"+tt+": IMPOSSIBLE");
            }
            tt++;

        }
    }

    public static int solve(int x,int y,String s,int idx,int dir[]){
            ol(s+" "+x+" "+y+" "+idx);

            if(x==0 && y == 0){
                return 0;
            }
            if(idx >= s.length()){
                return Integer.MIN_VALUE;
            }

            if(dir[s.charAt(idx)-'A']<0){
                if(s.charAt(idx) == 'E' || s.charAt(idx) == 'W'){

                    if(x>1){
                        return solve(x-2,y,s,idx+1,dir)+1;
                    }else if(x==1){
                        y = y>0 ? y-1:0;
                        return solve(x-1,y,s,idx+1,dir)+1;
                    }else{
                        y = y>0 ? y-1:0;
                        return solve(x,y,s,idx+1,dir)+1;
                    }
                }else{

                    if(y>1){
                        return solve(x,y-2,s,idx+1,dir)+1;
                    }else if(y==1){
                        x = x>0 ? x-1:0;
                        return solve(x,y-1,s,idx+1,dir)+1;
                    }else{
                        x = x>0 ? x-1:0;
                        return solve(x,y,s,idx+1,dir)+1;
                    }
                }
            }else{
//                if(s.charAt(idx) == 'E' || s.charAt(idx) == 'W'){
//                    y = y>0 ? y-1:0;
//                }else{
//                    x = x>0 ? x-1:0;
//                }
                return solve(x,y,s,idx+1,dir)+1;
            }

//        return 0;
    }



        // Pair
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

    // Fast IO
    public static void  o(List<? extends Object> olist){
        o(olist," ");
    }
    public static void o(List<? extends Object> olist,String sep){
        for(Object o : olist){
            o(o+sep);
        }
    }

    public static void ol(List<? extends Object> olist){
        ol(olist," ");
    }
    public static void ol(List<? extends Object> olist,String sep){
        for(Object o : olist){
            o(o+sep);
        }
        ol();
    }

    public static void o(Object[] olist){
        o(olist," ");
    }
    public static void o(Object[] olist,String sep){
        for(Object o : olist){
            o(o+sep);
        }
    }

    public static void ol(Object[] olist){
        ol(olist," ");
    }
    public static void ol(Object[] olist,String sep){
        for(Object o : olist){
            o(o+sep);
        }
        ol();
    }
    public static void ol(){
        ol("");
    }
    public static void o(){
        o(" ");
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
        return genericIn(n,()->in());
    }
    public static List<Double> dbl(int n){
        return genericIn(n,()->db());
    }
    public static List<Long> lgl(int n){
        return genericIn(n,()->lg());
    }
    public static List<String> ssl(int n){
        return genericIn(n,()->ss());
    }
    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
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


    // Common Util Functions
    static <T extends Comparable<T>> T max(T ... args){
        if(args.length == 0 ){
            return null;
        }
        T res = args[0];
        for(T num : args){
            if (res.compareTo(num) > 0){
                res = num;
            }
        }
        return res;
    }
    static <T extends Comparable<T>> T min(T ... args){
        if(args.length == 0 ){
            return null;
        }
        T res = args[0];
        for(T num : args){
            if (res.compareTo(num) < 0){
                res = num;
            }
        }
        return res;
    }

    static <T extends Comparable<T>> T max(List<T> args){
        if(args.size() == 0 ){
            return null;
        }
        T res = args.get(0);
        for(T num : args){
            res = max(res,num);
        }
        return res;
    }
    static <T extends Comparable<T>> T min(List<T> args){
        if(args.size() == 0 ){
            return null;
        }
        T res = args.get(0);
        for(T num : args){
            res = min(res,num);
        }
        return res;
    }



//Utilities for generating array and list with default values

    public static <T> List<T> gL(int len, T defVal){
        List<T> list = new ArrayList<>(len);
        for(int i=0;i<len;++i){
            list.add(defVal);
        }
        return list;
    }

    public static List<Integer> gl(int len,Integer defaultValue){
        return gL(len,defaultValue);
    }

    public static List<String> gl(int len,String defaultValue){
        return gL(len,defaultValue);
    }

    public static List<Long> gl(int len,Long defaultValue){
        return gL(len,defaultValue);
    }
    public static List<Double> gl(int len,Double defaultValue){
        return gL(len,defaultValue);
    }

    public static Integer[] ga(int len,Integer defaultValue){
        Integer [] arr = new Integer[len];
        for(int i=0;i<len;++i){
            arr[i] = defaultValue;
        }
        return arr;
    }

    public static String[] ga(int len,String defaultValue){
        String [] arr = new String[len];
        for(int i=0;i<len;++i){
            arr[i] = defaultValue;
        }
        return arr;
    }

    public static Long[] ga(int len,Long defaultValue){
        Long [] arr = new Long[len];
        for(int i=0;i<len;++i){
            arr[i] = defaultValue;
        }
        return arr;
    }

    public static Double[] ga(int len,Double defaultValue){
        Double [] arr = new Double[len];
        for(int i=0;i<len;++i){
            arr[i] = defaultValue;
        }
        return arr;
    }



}
