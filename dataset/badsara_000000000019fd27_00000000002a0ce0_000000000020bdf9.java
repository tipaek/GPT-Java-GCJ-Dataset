import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

class Pair{
    int s,e;
    public Pair(int s,int e){
        this.s=s;
        this.e=e;
    }
}

class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        for(int t=1;t<=T;t++){
            int n=sc.nextInt();
            Pair[] a=new Pair[n];
            for(int i=0;i<n;i++){
                Pair p=new Pair(sc.nextInt(),sc.nextInt());
                a[i]=p;
            }
            int cs=0,ce=0,js=0,je=0;
            boolean flag=true;
            String ans="";
            for(int i=0;i<n;i++){
                if(a[i].s>=ce || a[i].e<=cs){
                    ans+="C";
                    ce=a[i].e;
                    cs=a[i].s;
                }else if(a[i].s>=je || a[i].e<=js){
                    ans+="J";
                    je=a[i].e;
                    js=a[i].s;
                }else{
                    flag=false;
                    break;
                }
            }
            if(!flag){
                sb.append("Case #").append(t).append(": IMPOSSIBLE");
            }else{
                sb.append("Case #").append(t).append(": ");
                sb.append(ans);
            }
            if(t!=T){
                sb.append("\n");
            }
        }
        out.println(sb);
        out.flush();
        out.close();
    }
    public static PrintWriter out = new PrintWriter (new BufferedOutputStream(System.out));
}