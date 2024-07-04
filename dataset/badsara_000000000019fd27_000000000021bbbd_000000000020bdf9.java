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
            Pair[] b=new Pair[n];
            for(int i=0;i<n;i++){
                Pair p=new Pair(sc.nextInt(),sc.nextInt());
                a[i]=p;
                b[i]=p;
            }
            Arrays.sort(b,new Comparator<Pair>(){
                public int compare(Pair p1,Pair p2){
                    return p1.e-p2.e;
                }
            });
            int ce=0,je=0;
            Map<Pair,Character> mp=new HashMap<>();
            boolean flag=true;
            for(int i=0;i<n;i++){
                if(b[i].s>=ce){
                    mp.put(b[i],'C');
                    ce=b[i].e;
                }else if(b[i].s>=je){
                    mp.put(b[i],'J');
                    je=b[i].e;
                }else{
                    flag=false;
                    break;
                }
            }
            if(!flag){
                sb.append("Case #").append(t).append(": IMPOSSIBLE");
                sb.append("\n");
            }else{
                String ans="";
                for(int i=0;i<n;i++){
                    ans+=mp.get(a[i]);
                }
                sb.append("Case #").append(t).append(": ");
                sb.append(ans).append("\n");
            }
        }
        out.println(sb);
        out.close();
    }
    public static PrintWriter out = new PrintWriter (new BufferedOutputStream(System.out));
}