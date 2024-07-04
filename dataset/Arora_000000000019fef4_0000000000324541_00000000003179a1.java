import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
class Solution{//PRACTICE
    static class pair{
        int st,ed;
        pair(int a,int b){
            st=a;
            ed=b;
        }
    }
    public static void main(String args[]){
        FastScanner sc=new FastScanner(System.in);
        int t=sc.nextInt();
        for(int p1=0;p1<t;p1++){
            int u=sc.nextInt();
            String ans="";
            if(u==2){
                ans=solveCase1(sc);
            }
            else{
                ans=solveCase2(sc);
            }
            System.out.println("Case #"+(p1+1)+": "+ans);
        }
    }
    static String solveCase1(FastScanner sc){
        HashMap<Character,pair> map=new HashMap<>();
        for(int i=0;i<10000;i++){
            int m=sc.nextInt();
            String r=sc.next();
            int n=r.length();
            if(n==1){
                char ch=r.charAt(0);
                if(map.containsKey(ch)){
                    pair p=map.get(ch);
                    int end=9;
                    if(m<10){
                        end=m;
                    }
                    if(p.ed>end){
                        p.ed=end;
                    }
                    p.st=1;
                    map.put(ch,p);
                }
                else{
                    int end=9;
                    if(m<10){
                        end=m;
                    }
                    pair p=new pair(1,end);
                    map.put(ch,p);
                }
            }
            else{
                char ch=r.charAt(0);
                if(map.containsKey(ch)){
                    pair p=map.get(ch);
                    if(p.ed>m/10){
                        p.ed=m/10;
                    }
                    p.st=1;
                    map.put(ch,p);
                }
                else{
                    pair p=new pair(1,m/10);
                    map.put(ch,p);
                }
                ch=r.charAt(1);
                if(map.containsKey(ch)){
                    pair p=map.get(ch);
                    int end=9;
                    if(m<10){
                        end=m;
                    }
                    if(p.ed>end){
                        p.ed=end;
                    }
                    map.put(ch,p);
                }
                else{
                    int end=9;
                    if(m<10){
                        end=m;
                    }
                    pair p=new pair(0,end);
                    map.put(ch,p);
                }
            }
        }
        char arr[]=new char[10];
        for(char ch:map.keySet()){
            if(map.get(ch).st==0){
                arr[0]=ch;
            }
            else{
                arr[map.get(ch).ed]=ch;
            }
        }
        String ans=String.valueOf(arr);
        return ans;
    }
    static String solveCase2(FastScanner sc){
        HashMap<Character,pair> map=new HashMap<>();
        for(int j=0;j<10000;j++){
            String m=sc.next();
            String r=sc.next();
            int n=r.length();
            int x=m.length();
            for(int i=0;i<n;i++){
                char ch=r.charAt(i);
                if(i==0){
                    if(map.containsKey(ch)){
                        pair p=map.get(ch);
                        int end=(m.charAt(i)-'0');
                        if(p.ed>end){
                            p.ed=end;
                        }
                        p.st=1;
                        map.put(ch,p);
                    }
                    else{
                        int end=(m.charAt(i)-'0');
                        pair p=new pair(1,end);
                        map.put(ch,p);
                    }
                }
                else{
                    if(n==x){
                        if(map.containsKey(ch)){
                            pair p=map.get(ch);
                            int end=(m.charAt(i)-'0');
                            if(p.ed>end){
                                p.ed=end;
                            }
                            map.put(ch,p);
                        }
                        else{
                            int end=(m.charAt(i)-'0');
                            pair p=new pair(0,end);
                            map.put(ch,p);
                        }
                    }
                    else{
                        if(map.containsKey(ch)){
                            pair p=map.get(ch);
                            int end=9;
                            if(p.ed>end){
                                p.ed=end;
                            }
                            map.put(ch,p);
                        }
                        else{
                            int end=9;
                            pair p=new pair(0,end);
                            map.put(ch,p);
                        }
                    }
                }
            }
        }
        char arr[]=new char[10];
        for(char ch:map.keySet()){
            if(map.get(ch).st==0){
                arr[0]=ch;
            }
            else{
                arr[map.get(ch).ed]=ch;
            }
        }
        String ans=String.valueOf(arr);
        return ans;
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}