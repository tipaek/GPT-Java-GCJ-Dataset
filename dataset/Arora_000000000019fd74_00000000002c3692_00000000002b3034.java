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
    public static void main(String args[]){
        FastScanner sc=new FastScanner(System.in);
        int t=sc.nextInt();
        for(int p1=0;p1<t;p1++){
            int n=sc.nextInt();
            String a[]=new String[n];
            int len[]=new int[n];
            int flag=0;
            int max=0;
            String maxs="";
            for(int i=0;i<n;i++){
                a[i]=sc.next();
                len[i]=a[i].length();
                if(a[i].charAt(0)!='*'){
                    flag=1;
                }
                if(max<len[i]){
                    max=len[i];
                    maxs=a[i];
                }
            }
            if(flag==0){
                String ans=case1(a,maxs,n,max);
                System.out.println("Case #"+(p1+1)+": "+ans);
            }
            else{
                int flag1=0;
                String val1=a[0];
                for(int i=1;i<n;i++){
                    val1=case2(val1,a[i]);
                    if(val1.equals("-1")){
                        flag1=1;
                        break;
                    }
                }
                String ans="";
                int l=val1.length();
                for(int i=0;i<l;i++){
                    if(val1.charAt(i)!='*'){
                        ans=ans+val1.charAt(i);
                    }
                }
                if(flag1==1){
                    System.out.println("Case #"+(p1+1)+": *");
                }
                else{
                    System.out.println("Case #"+(p1+1)+": "+ans);
                }
            }
        }
    }
    static String case1(String a[],String maxs,int n,int max){
        for(int i=0;i<n;i++){
            int k1=max-1;
            int k2=a[i].length()-1;
            while(k1>0 && k2>0){
                if(maxs.charAt(k1)!=a[i].charAt(k2)){
                    return "*";
                }
                k1--;
                k2--;
            }
        }
        return maxs.substring(1);
    }
    static String case2(String p,String s){
        int x=p.indexOf("*");
        int y=s.indexOf("*");
        int k1=0,k2=0;
        while(k1<x && k2<y){
            if(p.charAt(k1)!=s.charAt(k2)){
                return "-1";
            }
            else{
                k1++;
                k2++;
            }
        }
        k1=p.length()-1;
        k2=s.length()-1;
        while(k1>x && k2>y){
            if(p.charAt(k1)!=s.charAt(k2)){
                return "-1";
            }
            else{
                k1--;
                k2--;
            }
        }
        String p1=p.substring(0,x);
        String p2=p.substring(x+1);
        String s1=s.substring(0,y);
        String s2=s.substring(y+1);
        String ans="";
        if(p1.length()>=s1.length()){
            ans=ans+p1;
        }
        else{
            ans=ans+s1;
        }
        ans=ans+"*";
        if(p2.length()>=s2.length()){
            ans=ans+p2;
        }
        else{
            ans=ans+s2;
        }
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