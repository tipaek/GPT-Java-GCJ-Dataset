/**
 * Author: Rohan Arora(codiinggeek)
 */

import java.io.*;
import java.util.*;

public class Solution {
    static long mod = (long)Math.pow(10,9);
    public static void main(String[] args){
        try{
            FastReader s = new FastReader();
            int t = s.nextInt();
            int m=1;
            while(t-->0){
                int n = s.nextInt();
                int d = s.nextInt();
                HashMap<Long, Integer> mp = new HashMap<>();
                HashSet<Long> st = new HashSet<>();
                for(int i=0;i<n;i++){
                    long a = s.nextLong();
                    mp.put(a, mp.getOrDefault(a,0)+1);
                    st.add(a);
                }
                Iterator<Long> itr = st.iterator();
                int p=0;
                while(itr.hasNext()){
                    long v = itr.next();
                    if(mp.get(v)==d){
                        p=1;
                        break;
                      }
                }
                if(p==1){
                    System.out.println("Case #" + m + ": " +0 );
                    m++;
                    continue;
                }
                if(d==2){
                    System.out.println("Case #" + m + ": " +1 );
                    m++;
                    continue;
                }
                int y= 0;
                Iterator<Long> its = st.iterator();
                while(its.hasNext()){
                    long v = its.next();
                    long a = v/2;
                    if(st.contains(a)){
                        y=1;
                        break;
                    }
                }
                if(y==1)
                    System.out.println("Case #" + m + ": " +1 );
                else
                    System.out.println("Case #" + m + ": " +2 );
                m++;
            }
        }catch(Exception e){
            System.out.println(e);
            return ;
        }
    }
    /*static ArrayList<String> intopo(String given, long d, long r)
    {
        ArrayList<String> al = new ArrayList<>();
        Stack<Character> st = new Stack<>();
        Stack<Character> st1 = new Stack<>();
         for(int i=0;i<given.length();i++){
            st.push(given.charAt(i));
        }
        String ns="";
        while(!st.isEmpty()){
            char ch = st.pop();
            if(ch==')'){
                st1.push(ch);
            }else if(Character.isLetter(ch)){
                st1.push(ch);
            }else if(Character.isDigit(ch)){
                int len = ch-48;
                while(!st1.isEmpty()&&st1.peek()!=')'){
                    ns += st1.pop();
                }
                String n=ns;
                for(int i=1;i<len;i++){
                    ns += n;
                }
                int nlen = ns.length();
                for(int k =0;k<nlen;k++){
                    st.push(ns.charAt(k));
                }
                if(st1.size()>0&&st1.peek()==')'){
                    st1.pop();
                }
                while(!st1.isEmpty()){
                    st.push(st1.pop());
                }
                ns="";
            }
        }
        String fn = "";
        while(!st1.isEmpty()){
            char ch = st1.pop();
            if(ch=='S')
                d++;
            else if(ch=='N')
                d--;
            if(ch=='E')
                r++;
            else if(ch=='W')
                r--;

            fn += ch;
        }
        String dd = d+"";
        String rr = r+"";
        al.add(fn);
        al.add(dd);
        al.add(rr);
        return al;

    }
    public static void main(String[] args) {
        try {
            FastReader s = new FastReader();
            int t = s.nextInt();
            int m=1;
            while(t-->0){
                String ss = s.next();
                int  l =ss.length();
                String  comp = "";
                long d=0, r=0;
                ArrayList<String> al = new ArrayList<>();
                al = intopo(ss,d,r);
                long w = Long.parseLong(al.get(2));
                long h = Long.parseLong(al.get(1));
                //String ans = al.get(0);
                if(w<0){
                    w = (long)Math.pow(10,9) + w + 1;
                }else {
                    w += 1;
                }
                if(h<0){
                    h = (long)Math.pow(10,9) + h +1;
                }else {
                    h += 1;
                }
                System.out.println("Case #"+m+": "+w+" "+h);
                m++;
            }
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }*/

    /**Pair class */
    class Pair<U, V> {
        U first;
        V second;

        Pair(U a, V b) {
            first = a;
            second = b;
        }
    }
/**---------------------------------------------------------------------------------*/
    /** FAST I/O */
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
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
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
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
